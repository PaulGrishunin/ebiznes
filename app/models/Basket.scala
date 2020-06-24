package models

import play.api.libs.json._

case class Basket(id: Long, user_id: Long, product_id: Long, quantity: Int)

object Basket {
  implicit val basketFormat = Json.format[Basket]
}

