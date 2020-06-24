package models

import play.api.libs.json._

case class User(id: Long, login: String, password: String, email: String)

object User {
  implicit val userFormat = Json.format[User]
}

