package models

import javax.inject.{ Inject, Singleton }
import play.api.db.slick.DatabaseConfigProvider
import slick.jdbc.JdbcProfile

import scala.concurrent.{ ExecutionContext, Future }

@Singleton
class OrderRepository @Inject() (dbConfigProvider: DatabaseConfigProvider)(implicit ec: ExecutionContext) {
  val dbConfig = dbConfigProvider.get[JdbcProfile]

  import dbConfig._
  import profile.api._

  class OrderTable(tag: Tag) extends Table[Order](tag, "order") {
    def id = column[Long]("id", O.PrimaryKey, O.AutoInc)
    def user = column[Long]("user")
    def product = column[Long]("product")
    def quantity = column[Int]("quantity")
    def price = column[Double]("price")
    def date = column[String]("date")
    def * = (id, user, product, quantity, price, date) <> ((Order.apply _).tupled, Order.unapply)
  }

  val order = TableQuery[OrderTable]

  def create(user: Long, product: Long, quantity: Int, price: Double, date: String): Future[Order] = db.run {
    (order.map(o => (o.user, o.product, o.quantity, o.price, o.date))
      returning order.map(_.id)
      into { case ((user, product, quantity, price, date), id) => Order(id, user, product, quantity, price, date) }
    ) += (user, product, quantity, price, date)
  }

  def list(): Future[Seq[Order]] = db.run {
    order.result
  }

  def getById(id: Long): Future[Order] = db.run {
    order.filter(_.id === id).result.head
  }

  def getByIdOption(id: Long): Future[Option[Order]] = db.run {
    order.filter(_.id === id).result.headOption
  }

  def getByUser(userid: Long): Future[Order] = db.run {
    order.filter(_.user === userid).result.head
  }

  def delete(id: Long): Future[Unit] = db.run(order.filter(_.id === id).delete).map(_ => ())

  def update(id: Long, new_order: Order): Future[Unit] = {
    val orderToUpdate: Order = new_order.copy(id)
    db.run(order.filter(_.id === id).update(orderToUpdate)).map(_ => ())
  }
}

