package controllers

import javax.inject._
import models.{Product, ProductRepository, Discount, DiscountRepository}
import play.api.data.Form
import play.api.data.Forms._
import play.api.libs.json.Json
import play.api.mvc._

import scala.concurrent.{ExecutionContext, Future}
import scala.util.{Failure, Success}

@Singleton
class DiscountController @Inject()(productsRepo: ProductRepository, discoRepo: DiscountRepository, cc: MessagesControllerComponents)(implicit ec: ExecutionContext) extends MessagesAbstractController(cc) {

  val discountForm: Form[CreateDiscountForm] = Form {
    mapping(
      "product" -> longNumber,
      "amount" -> number,
      "description" -> nonEmptyText,
    )(CreateDiscountForm.apply)(CreateDiscountForm.unapply)
  }

  val updatediscountForm: Form[UpdateDiscountForm] = Form {
    mapping(
      "id" -> longNumber,
      "product" -> longNumber,
      "amount" -> number,
      "description" -> nonEmptyText,
    )(UpdateDiscountForm.apply)(UpdateDiscountForm.unapply)
  }

  def addDiscount(product: Long) = Action {
    val dis = discoRepo.list()
    //dis.map( discounts => Ok(views.html.discounts(discounts)))
    Ok("Your new application is ready.")
  }
  def addDiscountHandle = Action.async { implicit request =>
    val product = request.body.asJson.get("product").as[Long]
    val amount = request.body.asJson.get("amount").as[Int]
    val description = request.body.asJson.get("description").as[String]

    discoRepo.create(product, amount, description).map { discount =>
      Ok(Json.toJson(discount))
    }
  }

  def updateDiscount(id: Long): Action[AnyContent] = Action.async { implicit request =>
    val discount = discoRepo.getByIdOption(id)
    discount.map(discount => Ok(Json.toJson(discount)))
  }

  def updateDiscountHandle = Action.async { implicit request =>
    val id = request.body.asJson.get("id").as[Int]
    val product = request.body.asJson.get("product").as[Long]
    val amount = request.body.asJson.get("amount").as[Int]
    val description = request.body.asJson.get("description").as[String]

    discoRepo.update(id, Discount(id, product, amount, description)).map { discount =>
      Ok(Json.toJson(Discount(id, product, amount, description)))
    }
  }

  def getDiscounts: Action[AnyContent] = Action.async { implicit request =>
    val discos = discoRepo.list()
    discos.map( discounts => Ok(Json.toJson(discounts)))
  }

  def getDiscount(id: Long): Action[AnyContent] = Action.async { implicit request =>
    val discount = discoRepo.getByIdOption(id)
    discount.map( discount => Ok(Json.toJson(discount)))
  }

  def getDiscountpr(id: Long): Action[AnyContent] = Action.async { implicit request =>
    val discount = discoRepo.getByProductId(id)
    discount.map(discount => Ok(Json.toJson(discount)))
  }

  def deleteDiscount(id: Long): Action[AnyContent] = Action {
    discoRepo.delete(id)
    Redirect("/discounts")
  }

}

case class CreateDiscountForm( product: Long, amount: Int, description: String)
case class UpdateDiscountForm(id: Long, product: Long, amount: Int, description: String)
