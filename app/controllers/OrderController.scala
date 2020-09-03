package controllers

import java.util.UUID

import javax.inject._
import models.{UserClass, UserClassRepository, Product, ProductRepository, Order, OrderRepository}
import play.api.data.Form
import play.api.data.Forms._
import play.api.libs.json.Json
import play.api.mvc._

import scala.concurrent.{ExecutionContext, Future}
import scala.util.{Failure, Success}
import play.api.data.format.Formats._
import play.api.libs.json.Json


@Singleton
class OrderController @Inject()(userRepo: UserClassRepository, productRepo: ProductRepository, orderRepo: OrderRepository, cc: MessagesControllerComponents)(implicit ec: ExecutionContext) extends MessagesAbstractController(cc) {

  val orderForm: Form[CreateOrderForm] = Form {
    mapping(
      "user" -> longNumber,
      "product" -> longNumber,
      "quantity" -> number,
      "price" -> of(doubleFormat),
      "date" -> nonEmptyText,
    )(CreateOrderForm.apply)(CreateOrderForm.unapply)
  }

  val updateOrderForm: Form[UpdateOrderForm] = Form {
    mapping(
      "id" -> longNumber,
      "user" -> longNumber,
      "product" -> longNumber,
      "quantity" -> number,
      "price" -> of(doubleFormat),
      "date" -> nonEmptyText,
    )(UpdateOrderForm.apply)(UpdateOrderForm.unapply)
  }

  def addOrder = Action {
    Ok("Your new application is ready.")
  }

  def addOrderHandle = Action.async { implicit request =>
    val user = request.body.asJson.get("user").as[Long]
    val product = request.body.asJson.get("product").as[Long]
    val quantity = request.body.asJson.get("quantity").as[Int]
    val price = request.body.asJson.get("price").as[Double]
    val date = request.body.asJson.get("date").as[String]

    orderRepo.create( user, product, quantity, price, date).map { order =>
      Ok(Json.toJson(order))
    }
  }

  def updateOrder(id: Long): Action[AnyContent] = Action.async { implicit request =>
    val order = orderRepo.getByIdOption(id)
    order.map(order => Ok(Json.toJson(order)))
  }

  def updateOrderHandle = Action.async { implicit request =>
    val id = request.body.asJson.get("id").as[Long]
    val user = request.body.asJson.get("user").as[Long]
    val product = request.body.asJson.get("product").as[Long]
    val quantity = request.body.asJson.get("quantity").as[Int]
    val price = request.body.asJson.get("price").as[Double]
    val date = request.body.asJson.get("date").as[String]

    orderRepo.update(id,Order(id, user, product, quantity, price, date)).map { order =>
      Ok(Json.toJson(Order(id,user, product, quantity, price, date)))
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

  def getOrdersUsr(userid: Long): Action[AnyContent] = Action.async { implicit request =>
    val ordUsr = orderRepo.getByUser(userid)
    ordUsr.map( orders => Ok(Json.toJson(orders)))
  }

  def deleteOrder(id: Long) = Action {
    orderRepo.delete(id)
    Redirect("/orders")
  }

}

case class CreateOrderForm( user: Long, product: Long, quantity: Int, price: Double, date: String)
case class UpdateOrderForm( id: Long, user: Long, product: Long, quantity: Int, price: Double, date: String)
