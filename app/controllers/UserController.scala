package controllers

import javax.inject._
import models.{Category, CategoryRepository, Product, ProductRepository}
import play.api.data.Form
import play.api.data.Forms._
import play.api.mvc._
import scala.concurrent.{ExecutionContext, Future}
import scala.util.{Failure, Success}
/**
 * This controller creates an `Action` to handle HTTP requests to the
 * application's home page.
 */
@Singleton
class UserController @Inject()(usersRepo: UserRepository, cc: MessagesControllerComponents)(implicit ec: ExecutionContext) extends MessagesAbstractController(cc) {

  val userForm: Form[CreateUserForm] = Form {
    mapping(
      "login" -> nonEmptyText,
      "password" -> nonEmptyText,
      "email" -> nonEmptyText,
    )(CreateUserForm.apply)(CreateUserForm.unapply)
  }

  val updateUserForm: Form[UpdateUserForm] = Form {
    mapping(
           "id" -> longNumber,
      "login" -> nonEmptyText,
      "password" -> nonEmptyText,
      "email" -> nonEmptyText,
    )(UpdateUserForm.apply)(UpdateUserForm.unapply)
  }


  def getUsers: Action[AnyContent] = Action.async { implicit request =>
    val usery = usersRepo.list()
    usery.map( users => Ok(views.html.users(users)))
  }

  def getUser(id: Long): Action[AnyContent] = Action.async { implicit request =>
    val uzer = usersRepo.getByIdOption(id)
    uzer.map(user => user match {
      case Some(p) => Ok(views.html.user(p))
      case None => Redirect(routes.UserController.getUsers())
    })
  }

  def delete(id: Long): Action[AnyContent] = Action {
    usersRepo.delete(id)
    Redirect("/users")
  }

  def updateUser(id: Long): Action[AnyContent] = Action.async { implicit request: MessagesRequest[AnyContent] =>
    var categ:Seq[Category] = Seq[Category]()
    val categories = categoryRepo.list().onComplete{
      case Success(cat) => categ = cat
      case Failure(_) => print("fail")
    }

    val uzer = usersRepo.getById(id)
    uzer.map(user => {
      val uzerForm = updateUserForm.fill(UpdateUserForm(user.id, user.login, user.password, user.email))
      //  id, product.name, product.description, product.category)
      //updateProductForm.fill(prodForm)
      Ok(views.html.userupdate(uzerForm, categ))
    })
  }

  def updateUserHandle = Action.async { implicit request =>
    var categ:Seq[Category] = Seq[Category]()
    val categories = categoryRepo.list().onComplete{
      case Success(cat) => categ = cat
      case Failure(_) => print("fail")
    }

    updateUserForm.bindFromRequest.fold(
      errorForm => {
        Future.successful(
          BadRequest(views.html.userupdate(errorForm, categ))
        )
      },
      user => {
        usersRepo.update(user.id, User(user.id, user.login, user.password, user.email)).map { _ =>
          Redirect(routes.UserController.updateUser(user.id)).flashing("success" -> "product updated")
        }
      }
    )

  }


  def addUser: Action[AnyContent] = Action.async { implicit request: MessagesRequest[AnyContent] =>
    val categories = categoryRepo.list()
    categories.map (cat => Ok(views.html.productadd(productForm, cat)))
  }

  def addUserHandle = Action.async { implicit request =>
    var categ:Seq[Category] = Seq[Category]()
    val categories = categoryRepo.list().onComplete{
      case Success(cat) => categ = cat
      case Failure(_) => print("fail")
    }

    userForm.bindFromRequest.fold(
      errorForm => {
        Future.successful(
          BadRequest(views.html.useradd(errorForm, categ))
        )
      },
      user => {
        usersRepo.create(user.login, user.password, user.email).map { _ =>
          Redirect(routes.UserController.addUser()).flashing("success" -> "user.created")
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

case class CreateUserForm(login: String, password: String, email: String)
case class UpdateUserForm(id: Long, login: String, password: String, email: String)
