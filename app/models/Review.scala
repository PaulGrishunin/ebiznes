package models

import play.api.libs.json._

case class Review(id: Long, product_id: Long, user_id: Long, content: String, rate: Byte)

object Review {
  implicit val reviewFormat = Json.format[Review]
}

