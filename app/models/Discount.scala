package models

import play.api.libs.json._

case class Discount(id: Long, product_id: Long, name: String, description: String)

object Discount {
  implicit val discountFormat = Json.format[Discount]
}

