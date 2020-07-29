package models

import play.api.libs.json._

case class Payment(id: Long, order_id: Long, date: String)

object Payment {
  implicit val paymentFormat = Json.format[Payment]
}

