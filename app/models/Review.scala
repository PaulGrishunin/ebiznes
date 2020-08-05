package models

import play.api.libs.json._

case class Review(id: Int, product_id: Long, user_id: Long, rate: Byte, text: String)

object Review {
  implicit val reviewFormat = Json.format[Review]
}

