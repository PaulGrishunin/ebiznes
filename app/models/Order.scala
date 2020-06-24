package models

import play.api.libs.json._

case class Order(id: Long, user_id: Long, product_id: Long, quantity: Int, completed: Boolean)

object Order {
  implicit val orderFormat = Json.format[Order]
}

