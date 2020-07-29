package models

import play.api.libs.json._

case class Question(id: Long, product_id: Long, user_id: Long, content: String, answer: String)

object Question{
  implicit val questionFormat = Json.format[Question]
}
