package models

import play.api.libs.json._

case class Payment(id: Long, pay_name: String, description: String)

object Payment {
  implicit val paymentFormat = Json.format[Payment]
}

