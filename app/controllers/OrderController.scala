package controllers

import java.util.UUID

import javax.inject._
import models.{User, UserRepository, Product, ProductRepository, Order, OrderRepository}
import play.api.data.Form
import play.api.data.Forms._
import play.api.libs.json.Json
import play.api.mvc._

import scala.concurrent.{ExecutionContext, Future}
import scala.util.{Failure, Success}
import play.api.data.format.Formats._
import play.api.libs.json.Json


@Singleton
class OrderController @Inject()(userRepo: UserRepository, productRepo: ProductRepository, orderRepo: OrderRepository, cc: MessagesControllerComponents)(implicit ec: ExecutionContext) extends MessagesAbstractController(cc) {

  val orderForm: Form[CreateOrderForm] = Form {
    mapping(
      "user_id" -> longNumber,
      "product_id" -> longNumber,
      "quantity" -> number,
      "price" -> of(doubleFormat),
      "date" -> nonEmptyText,
      "completed" -> boolean,
    )(CreateOrderForm.apply)(CreateOrderForm.unapply)
  }

  val updateOrderForm: Form[UpdateOrderForm] = Form {
    mapping(
      "id" -> longNumber,
      "user_id" -> longNumber,
      "product_id" -> longNumber,
      "quantity" -> number,
      "price" -> of(doubleFormat),
      "date" -> nonEmptyText,
      "completed" -> boolean,
    )(UpdateOrderForm.apply)(UpdateOrderForm.unapply)
  }

  def addOrder = Action {
    Ok("Your new application is ready.")
  }

  def addOrderHandle = Action.async { implicit request =>
    val user_id = request.body.asJson.get("user_id").as[Long]
    val product_id = request.body.asJson.get("product_id").as[Long]
    val quantity = request.body.asJson.get("quantity").as[Int]
    val price = request.body.asJson.get("price").as[Double]
    val date = request.body.asJson.get("date").as[String]
    val completed = request.body.asJson.get("completed").as[Boolean]

    orderRepo.create( user_id, product_id, quantity, price, date, completed).map { order =>
      Ok(Json.toJson(order))
    }
  }

  def updateOrder(id: Long): Action[AnyContent] = Action.async { implicit request =>
    val order = orderRepo.getByIdOption(id)
    order.map(order => Ok(Json.toJson(order)))
  }

  def updateOrderHandle = Action.async { implicit request =>
    val id = request.body.asJson.get("id").as[Long]
    val user_id = request.body.asJson.get("user_id").as[Long]
    val product_id = request.body.asJson.get("product_id").as[Long]
    val quantity = request.body.asJson.get("quantity").as[Int]
    val price = request.body.asJson.get("price").as[Double]
    val date = request.body.asJson.get("date").as[String]
    val completed = request.body.asJson.get("completed").as[Boolean]

    orderRepo.update(id,Order(id, user_id, product_id , quantity, price, date, completed)).map { order =>
      Ok(Json.toJson(Order(id,user_id, product_id , quantity, price, date, completed)))
    }
  }

  def getOrder(id: Long): Action[AnyContent] = Action.async { implicit request =>
    val order = orderRepo.getByIdOption(id)
    order.map(order => Ok(Json.toJson(order)))
  }

  def getOrders: Action[AnyContent] = Action.async { implicit request =>
    val ords = orderRepo.list()
    ords.map( orders => Ok(Json.toJson(orders)))
  }

  def getOrdersUsr(user_id: Long): Action[AnyContent] = Action.async { implicit request =>
    val ordUsr = orderRepo.getByUser(user_id)
    ordUsr.map( orders => Ok(Json.toJson(orders)))
  }

  def deleteOrder(id: Long) = Action {
    orderRepo.delete(id)
    Redirect("/orders")
  }

}

case class CreateOrderForm( user_id: Long, product_id: Long, quantity: Int, price: Double, date: String, completed: Boolean)
case class UpdateOrderForm( id: Long, user_id: Long, product_id: Long, quantity: Int, price: Double, date: String, completed: Boolean)
