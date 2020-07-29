package models

import javax.inject.{Inject, Singleton}
import play.api.db.slick.DatabaseConfigProvider
import slick.jdbc.JdbcProfile

import scala.concurrent.{ExecutionContext, Future}

@Singleton
class OrderRepository @Inject() (dbConfigProvider: DatabaseConfigProvider)(implicit ec: ExecutionContext) {
  val dbConfig = dbConfigProvider.get[JdbcProfile]

  import dbConfig._
  import profile.api._

  class OrderTable(tag: Tag) extends Table[Order](tag, "order") {
    def id = column[Long]("id", O.PrimaryKey, O.AutoInc)
    def user_id = column[Long]("user_id")
    def product_id = column[Long]("product_id")
    def quantity = column[Int]("quantity")
    def price = column[Double]("price")
    def date = column[String]("date")
    def completed = column[Boolean]("completed")
    def * = (id, user_id, product_id, quantity, price, date, completed) <> ((Order.apply _).tupled, Order.unapply)
  }

  val order = TableQuery[OrderTable]

  def create(user_id: Long, product_id: Long, quantity: Int, price: Double, date: String, completed: Boolean): Future[Order] = db.run {
    (order.map(o => (o.user_id, o.product_id, o.quantity, o.price, o.date, o.completed))
      returning order.map(_.id)
      into {case ((user_id, product_id, quantity, price, date, completed), id) => Order(id, user_id, product_id, quantity, price, date, completed)}
      ) += (user_id, product_id, quantity, price, date, completed)
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

  def getByUser(user_id: Long): Future[Order] = db.run {
    order.filter(_.user_id === user_id).result.head
  }

  def delete(id: Long): Future[Unit] = db.run(order.filter(_.id === id).delete).map(_ => ())

  def update(id: Long, new_order: Order): Future[Unit] = {
    val orderToUpdate: Order = new_order.copy(id)
    db.run(order.filter(_.id === id).update(orderToUpdate)).map(_ => ())
  }
}

