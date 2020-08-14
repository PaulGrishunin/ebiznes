package models

import play.api.libs.json._

case class Basket(id: Long, user: Long, product: Long, quantity: Int)

object Basket {
  implicit val basketFormat = Json.format[Basket]
}

