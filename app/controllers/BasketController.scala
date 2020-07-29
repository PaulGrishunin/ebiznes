package controllers

import javax.inject._
import models.{Basket, BasketRepository, ProductRepository, UserRepository}
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
class BasketController @Inject()(basketRepo: BasketRepository, productRepo: ProductRepository, userRepo: UserRepository, cc: MessagesControllerComponents)(implicit ec: ExecutionContext) extends MessagesAbstractController(cc) {

  val basketForm: Form[CreateBasketForm] = Form {
    mapping(
      "user_id" -> longNumber,
      "product_id" -> longNumber,
      "quantity" -> number,
    )(CreateBasketForm.apply)(CreateBasketForm.unapply)
  }

  val updateBasketForm: Form[UpdateBasketForm] = Form {
    mapping(
           "id" -> longNumber,
      "product_id" -> longNumber,
      "user_id" -> longNumber,
      "quantity" -> number,
    )(UpdateBasketForm.apply)(UpdateBasketForm.unapply)
  }

  def addToBasket(id: Long) = Action {
    Ok("Your new application is ready.")
  }

  def updateBasket(id: Long): Action[AnyContent] = Action.async { implicit request =>
    val basket = basketRepo.list()
    basket.map( basket => Ok(Json.toJson(basket)))
  }

  def updateBasketHandle = Action.async { implicit request =>
    val id = request.body.asJson.get("id").as[Long]
    val user_id = request.body.asJson.get("user_id").as[Long]
    val product_id = request.body.asJson.get("product_id").as[Long]
    val quantity = request.body.asJson.get("quantity").as[Int]

    basketRepo.update(id, Basket(id, user_id, product_id, quantity)).map { basket =>
      Ok(Json.toJson(Basket(id, user_id, product_id, quantity)))
    }
  }
  def deleteFromBasket(id: Long) = Action {
    basketRepo.delete(id)
    Redirect("/basket")
  }

}

case class CreateBasketForm(user_id: Long, product_id: Long, quantity: Int)
case class UpdateBasketForm(id: Long, user_id: Long, product_id: Long, quantity: Int)
