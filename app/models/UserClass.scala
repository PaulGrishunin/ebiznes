package models

import play.api.libs.json._

case class UserClass(id: Long, provid: String, uKey: String, login: String, email: String, admin: Boolean)

object UserClass {
  implicit val userFormat = Json.format[UserClass]
}

