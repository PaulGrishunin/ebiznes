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
    def product = column[Long]("product")
    def amount = column[Int]("amount")
    def description = column[String]("description")

    def * = (id, product, amount, description) <> ((Discount.apply _).tupled, Discount.unapply)

  }

  val discount = TableQuery[DiscountTable]

  def create(product: Long, amount: Int, description: String): Future[Discount] = db.run {
    (discount.map(d => (d.product, d.amount, d.description))
      returning discount.map(_.id)
      into {case ((product, amount, description), id) => Discount(id, product, amount, description)}
    ) += (product, amount, description)
  }

  def list(): Future[Seq[Discount]] = db.run {
    discount.result
  }

  def getById(id: Long): Future[Discount] = db.run {
    discount.filter(_.id === id).result.head
  }

  def getByIdOption(id: Long): Future[Option[Discount]] = db.run {
    discount.filter(_.id === id).result.headOption
  }

  def getByProductId(id: Long): Future[Option[Discount]] =db.run {
    discount.filter(_.product === id).result.headOption
  }

  def delete(id: Long): Future[Unit] = db.run(discount.filter(_.id === id).delete).map(_ => ())

  def update(id: Long, new_discount: Discount): Future[Unit] = {
    val discountToUpdate: Discount = new_discount.copy(id)
    db.run(discount.filter(_.id === id).update(discountToUpdate)).map(_ => ())
  }

}

