package models

import play.api.libs.json._

case class Favorites(id: Long, user: Long, product: Long)

object Favorites{
  implicit val favoritesFormat = Json.format[Favorites]
}
