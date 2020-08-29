package models

import javax.inject.{ Inject, Singleton }
import play.api.db.slick.DatabaseConfigProvider
import slick.jdbc.JdbcProfile

import scala.concurrent.{ ExecutionContext, Future }

@Singleton
class BasketRepository @Inject() (dbConfigProvider: DatabaseConfigProvider)(implicit ec: ExecutionContext) {
  val dbConfig = dbConfigProvider.get[JdbcProfile]

  import dbConfig._
  import profile.api._

  class BasketTable(tag: Tag) extends Table[Basket](tag, "basket") {
    def id = column[Long]("id", O.PrimaryKey, O.AutoInc)
    def user = column[Long]("user")
    def product = column[Long]("product")
    def quantity = column[Int]("quantity")
    def * = (id, user, product, quantity) <> ((Basket.apply _).tupled, Basket.unapply)
  }

  val basket = TableQuery[BasketTable]

  def create(user: Long, product: Long, quantity: Int): Future[Basket] = db.run {
    (basket.map(b => (b.user, b.product, b.quantity))
      returning basket.map(_.id)
      into { case ((user, product, quantity), id) => Basket(id, user, product, quantity) }
    ) += (user, product, quantity)
  }

  def list(): Future[Seq[Basket]] = db.run {
    basket.result
  }

  def list(user_id: Long): Future[Seq[Basket]] = db.run {
    basket.filter(_.user === user_id).result
  }

  def getById(id: Long): Future[Basket] = db.run {
    basket.filter(_.id === id).result.head
  }

  def getByUserId(user: Long): Future[Basket] = db.run {
    basket.filter(_.user === user).result.head
  }

  def delete(id: Long): Future[Unit] = db.run(basket.filter(_.id === id).delete).map(_ => ())

  def update(id: Long, new_basket: Basket): Future[Unit] = {
    val basketToUpdate: Basket = new_basket.copy(id)
    db.run(basket.filter(_.id === id).update(basketToUpdate)).map(_ => ())
  }
}

