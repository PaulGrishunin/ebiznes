package models

import javax.inject.{Inject, Singleton}
import play.api.db.slick.DatabaseConfigProvider
import slick.jdbc.JdbcProfile

import scala.concurrent.{ExecutionContext, Future}

@Singleton
class DiscountRepository @Inject() (dbConfigProvider: DatabaseConfigProvider)(implicit ec: ExecutionContext) {
  val dbConfig = dbConfigProvider.get[JdbcProfile]

  import dbConfig._
  import profile.api._

  class DiscountTable(tag: Tag) extends Table[Discount](tag, "discount") {

    def id = column[Long]("id", O.PrimaryKey, O.AutoInc)
    def product_id = column[Long]("productid")
    def name = column[String]("name")
    def description = column[String]("description")

    def * = (id, product_id, name, description) <> ((Discount.apply _).tupled, Discount.unapply)

  }

  val discount = TableQuery[DiscountTable]

  def create(product_id: Long, name: String, description: String): Future[Discount] = db.run {
    (discount.map(d => (d.product_id, d.name, d.description))
      returning discount.map(_.id)
      into (product_id, name, description, id) => Discount(id, product_id, name, description))
    ) += (product_id, name, description)
  }

  def list(): Future[Seq[Discount]] = db.run {
    discount.result
  }

  def getById(id: Long): Future[Discount] = db.run {
    discount.filter(_.id === id).result.head
  }

  def delete(id: Long): Future[Discount] = db.run(discount.filter(_.id === id).delete).map(_ => ())

  def update(id: Long, new_discount: Discount): Future[Discount] = {
    val discountToUpdate: Discount = new_discount.copy(id)
    db.run(discount.filter(_.id === id).update(discountToUpdate)).map(_ => ())
  }

}

