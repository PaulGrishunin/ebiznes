package models

import play.api.libs.json.Json

case class Product(id: Long, name: String, description: String, category: Int, price: Double)

object Product {
  implicit val productFormat = Json.format[Product]
}
