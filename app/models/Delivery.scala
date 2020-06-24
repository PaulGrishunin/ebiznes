package models

import play.api.libs.json._

case class Delivery(id: Long, order_id: Long, address: String)

object Delivery{
  implicit val deliveryFormat = Json.format[Delivery]
}

