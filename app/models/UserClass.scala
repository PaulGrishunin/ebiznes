package models

import play.api.libs.json._

case class UserClass(id: Long, login: String, password: String, email: String, admin: Boolean)

object UserClass {
  implicit val userFormat = Json.format[UserClass]
}

