package models

import play.api.libs.json._

case class Question(id: Long, product: Long, user: Long, content: String, answer: String)

object Question{
  implicit val questionFormat = Json.format[Question]
}
