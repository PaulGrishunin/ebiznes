package controllers

import java.util.UUID

import javax.inject._
import models.{Payment, PaymentRepository, Order, OrderRepository}
import play.api.data.Form
import play.api.data.Forms._
import play.api.libs.json.Json
import play.api.mvc._

import scala.concurrent.{ExecutionContext, Future}
import scala.util.{Failure, Success}
import play.api.data.format.Formats._
import play.api.libs.json.Json


@Singleton
class PaymentController @Inject()( paymentRepo: PaymentRepository, orderRepo: OrderRepository, cc: MessagesControllerComponents)(implicit ec: ExecutionContext) extends MessagesAbstractController(cc) {

  val paymentForm: Form[CreatePaymentForm] = Form {
    mapping(
      "order" -> longNumber,
      "date" -> nonEmptyText,
    )(CreatePaymentForm.apply)(CreatePaymentForm.unapply)
  }

  val updatePaymentForm: Form[UpdatePaymentForm] = Form {
    mapping(
      "id" -> longNumber,
      "order" -> longNumber,
      "date" -> nonEmptyText,
    )(UpdatePaymentForm.apply)(UpdatePaymentForm.unapply)
  }


  def addPayment = Action {
    Ok("Your new application is ready.")
  }

  def addPaymentHandle = Action.async { implicit request =>
    val order = request.body.asJson.get("order").as[Long]
    val date = request.body.asJson.get("date").as[String]

    paymentRepo.create(order, date).map { payment =>
      Ok(Json.toJson(payment))
    }
  }
  def updatePayment(id: Long): Action[AnyContent] = Action.async { implicit request =>
    val payment = paymentRepo.getByIdOption(id)
    payment.map(payment => Ok(Json.toJson(payment)))
  }
  def updatePaymentHandle = Action.async { implicit request =>
    val id = request.body.asJson.get("id").as[Long]
    val order = request.body.asJson.get("order").as[Long]
    val date = request.body.asJson.get("date").as[String]

    paymentRepo.update(id,Payment(id, order, date)).map { payment =>
      Ok(Json.toJson(Payment(id, order, date)))
    }
  }

  def getPayments: Action[AnyContent] = Action.async { implicit request =>
    val pays = paymentRepo.list()
    pays.map( payments => Ok(Json.toJson(payments)))
  }

  def getPayment(id: Long): Action[AnyContent] = Action.async { implicit request =>
    val payment = paymentRepo.getByIdOption(id)
    payment.map(payment => Ok(Json.toJson(payment)))
  }

  def getPaymentOrd(id: Long): Action[AnyContent] = Action.async { implicit request =>
    val payment = paymentRepo.getByOrdOption(id)
    payment.map(payment => Ok(Json.toJson(payment)))
  }

  def deletePayment(id: Long): Action[AnyContent] = Action {
    paymentRepo.delete(id)
    Redirect("/payments")
  }

}

case class CreatePaymentForm( order: Long, date: String)
case class UpdatePaymentForm(id: Long, order: Long ,date: String)
