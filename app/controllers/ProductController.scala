package controllers

import javax.inject._
import models.{Category, CategoryRepository, Product, ProductRepository}
import play.api.data.Form
import play.api.data.Forms._
import play.api.libs.json.Json
import play.api.mvc._

import scala.concurrent.{ExecutionContext, Future}
import scala.util.{Failure, Success}
import play.api.data.format.Formats._
import play.api.libs.json.Json

/**
 * This controller creates an `Action` to handle HTTP requests to the
 * application's home page.
 */
@Singleton
class ProductController @Inject()(productsRepo: ProductRepository, categoryRepo: CategoryRepository, cc: MessagesControllerComponents)(implicit ec: ExecutionContext) extends MessagesAbstractController(cc) {

  val productForm: Form[CreateProductForm] = Form {
    mapping(
      "name" -> nonEmptyText,
      "description" -> nonEmptyText,
      "category" -> number,
      "price" ->  of(doubleFormat),
    )(CreateProductForm.apply)(CreateProductForm.unapply)
  }

  val updateProductForm: Form[UpdateProductForm] = Form {
    mapping(
           "id" -> longNumber,
      "name" -> nonEmptyText,
      "description" -> nonEmptyText,
      "category" -> number,
      "price" ->  of(doubleFormat),
    )(UpdateProductForm.apply)(UpdateProductForm.unapply)
  }

  def index = Action {
    Ok(views.html.index("Your new application is ready."))
  }

  def getProducts: Action[AnyContent] = Action.async { implicit request =>
    val produkty = productsRepo.list()
    produkty.map( products => Ok(Json.toJson(products)))
  }

  def getProductsByCat(category: Int): Action[AnyContent] = Action.async { implicit request =>
    val produkti = productsRepo.getByCategory(category)
    produkti.map( products => Ok(Json.toJson(products)))
  }

  def getProduct(id: Long): Action[AnyContent] = Action.async { implicit request =>
    val produkt = productsRepo.getByIdOption(id)
    produkt.map( products => Ok(Json.toJson(products)))
  }

  def delete(id: Long): Action[AnyContent] = Action {
    productsRepo.delete(id)
    Redirect("/products")
  }

  def updateProduct(id: Long): Action[AnyContent] = Action.async { implicit request: MessagesRequest[AnyContent] =>
    val produkt = productsRepo.getByIdOption(id)
    produkt.map( products => Ok(Json.toJson(products)))
    }

  def updateProductHandle = Action.async { implicit request =>
    val id = request.body.asJson.get("id").as[Long]
    val name = request.body.asJson.get("name").as[String]
    val description = request.body.asJson.get("description").as[String]
    val category = request.body.asJson.get("category").as[Int]
    val price = request.body.asJson.get("price").as[Double]

        productsRepo.update(id, Product(id, name, description, category, price)).map { _ =>
          Ok(Json.toJson(Product(id,name,description,category, price)))
        }
  }


  def addProduct: Action[AnyContent] = Action.async { implicit request: MessagesRequest[AnyContent] =>
    val categories = categoryRepo.list()
    categories.map (cat => Ok(views.html.productadd(productForm, cat)))
  }

  def addProductHandle = Action.async { implicit request =>
    var categ:Seq[Category] = Seq[Category]()
    val categories = categoryRepo.list().onComplete{
      case Success(cat) => categ = cat
      case Failure(_) => print("fail")
    }

    productForm.bindFromRequest.fold(
      errorForm => {
        Future.successful(
          BadRequest(views.html.productadd(errorForm, categ))
        )
      },
      product => {
        productsRepo.create(product.name, product.description, product.category, product.price).map { _ =>
          Redirect(routes.ProductController.addProduct()).flashing("success" -> "product.created")
        }
      }
    )

  }
  /*
    def addProduct = Action { implicit request: MessagesRequest[AnyContent] =>

      var categ:Seq[Category] = Seq[Category]()
      val categories = categoryRepo.list().onComplete{
        case Success(cat) => categ = cat
        case Failure(_) => print("fail")
      }

      val errorFunction = { productForm =>
      // This is the bad case, where the form had validation errors.
      // Let's show the user the form again, with the errors highlighted.
      // Note how we pass the form with errors to the template.
      BadRequest(views.html.productadd(productForm, categ))
    }

    val successFunction = { data: Product =>
      // This is the good case, where the form was successfully parsed as a Data object.
      productsRepo.create(data.name, data.description, data.category).map { _ =>
        Redirect(routes.HomeController.addProduct()).flashing("success" -> "product.created")
      }
    }

    val formValidationResult = productForm.bindFromRequest
    formValidationResult.fold(errorFunction, successFunction)
  }
  */
}

case class CreateProductForm(name: String, description: String, category: Int, price: Double)
case class UpdateProductForm(id: Long, name: String, description: String, category: Int, price: Double)
