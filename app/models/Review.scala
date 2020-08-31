package models

import play.api.libs.json._

case class Review(id: Int, product: Long, user: Long, rate: Int, text: String)

object Review {
  implicit val reviewFormat = Json.format[Review]
}

