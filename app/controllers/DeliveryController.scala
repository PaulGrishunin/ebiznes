package controllers

import javax.inject._
import models.{Delivery, DeliveryRepository, Order, OrderRepository}
import play.api.data.Form
import play.api.data.Forms._
import play.api.libs.json.Json
import play.api.mvc._

import scala.concurrent.{ExecutionContext, Future}
import scala.util.{Failure, Success}
/**
 * This controller creates an `Action` to handle HTTP requests to the
 * application's home page.
 */
@Singleton
class DeliveryController @Inject()(deliveryRepo: DeliveryRepository, orderRepo: OrderRepository, cc: MessagesControllerComponents)(implicit ec: ExecutionContext) extends MessagesAbstractController(cc) {

  val deliveryForm: Form[CreateDeliveryForm] = Form {
    mapping(
      "order" -> longNumber,
      "adress" -> nonEmptyText,
    )(CreateDeliveryForm.apply)(CreateDeliveryForm.unapply)
  }

  val updateDeliveryForm: Form[UpdateDeliveryForm] = Form {
    mapping(
           "id" -> longNumber,
      "order" -> longNumber,
      "address" -> nonEmptyText,
    )(UpdateDeliveryForm.apply)(UpdateDeliveryForm.unapply)
  }

  def addDelivery = Action {
    Ok("Your new application is ready.")
  }

  def addDeliveryHandle = Action.async { implicit request =>
    val order = request.body.asJson.get("order").as[Long]
    val address = request.body.asJson.get("address").as[String]

    deliveryRepo.create(order, address).map { delivery =>
      Ok(Json.toJson(delivery))
    }
  }

  def updateDelivery(id: Long): Action[AnyContent] = Action.async { implicit request =>
    val delivery = deliveryRepo.getByIdOption(id)
    delivery.map(delivery => Ok(Json.toJson(delivery)))
  }
  def updateDeliveryHandle = Action.async { implicit request =>
    val id = request.body.asJson.get("id").as[Long]
    val order = request.body.asJson.get("order").as[Long]
    val address = request.body.asJson.get("address").as[String]

    deliveryRepo.update(id, Delivery(id, order, address)).map { delivery =>
      Ok(Json.toJson(Delivery(id, order, address)))
    }
  }

  def deleteDelivery(id: Long) = Action {
    deliveryRepo.delete(id)
    Redirect("/")
  }

  def getDelivery(id: Long): Action[AnyContent] = Action.async { implicit request =>
    val delivery = deliveryRepo.getByIdOption(id)
    delivery.map(delivery => Ok(Json.toJson(delivery)))
  }

  def getDeliverys: Action[AnyContent] = Action.async { implicit request =>
    val devs = deliveryRepo.list()
    devs.map( deliverys => Ok(Json.toJson(deliverys)))
  }

  def getDeliveryOrd(id: Long): Action[AnyContent] = Action.async { implicit request =>
    val delivery = deliveryRepo.getByOrderIdOption(id)
    delivery.map(delivery => Ok(Json.toJson(delivery)))
  }

}

case class CreateDeliveryForm(order: Long, address: String)
case class UpdateDeliveryForm(id: Long, order: Long, address: String)
