package models

import play.api.libs.json._

case class Discount(id: Long, product: Long, amount: Int, description: String)

object Discount {
  implicit val discountFormat = Json.format[Discount]
}

