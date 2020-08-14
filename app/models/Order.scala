package models

import play.api.libs.json._

case class Order(id: Long, user: Long, product: Long, quantity: Int, price: Double, date: String, completed: Boolean)

object Order {
  implicit val orderFormat = Json.format[Order]
}

