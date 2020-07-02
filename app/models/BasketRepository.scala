package models

import javax.inject.{Inject, Singleton}
import play.api.db.slick.DatabaseConfigProvider
import slick.jdbc.JdbcProfile

import scala.concurrent.{ExecutionContext, Future}

@Singleton
class BasketRepository @Inject() (dbConfigProvider: DatabaseConfigProvider)(implicit ec: ExecutionContext) {
  val dbConfig = dbConfigProvider.get[JdbcProfile]

  import dbConfig._
  import profile.api._

  class BasketTable(tag: Tag) extends Table[Basket](tag, "basket") {
    def id = column[Long]("id", O.PrimaryKey, O.AutoInc)
    def user_id = column[Long]("userid")
    def product_id = column[Long]("productid")
    def quantity = column[Int]("quantity")
    def * = (id, user_id, product_id, quantity) <> ((Basket.apply _).tupled, Basket.unapply)
  }

  val basket = TableQuery[BasketTable]

  def create(user_id: Long, product_id: Long, quantity: Int): Future[Basket] = db.run {
    (basket.map(b => (b.user_id, b.product_id, b.quantity))
      returning basket.map(_.id)
      into {case ((user_id, product_id, quantity), id) => Basket(id, user_id, product_id, quantity)}
      ) += (user_id, product_id, quantity)
  }

  def list(): Future[Seq[Basket]] = db.run {
    basket.result
  }

  def getById(id: Long): Future[Basket] = db.run {
    basket.filter(_.id === id).result.head
  }

  def getByUser_Id(user_id: Long): Future[Basket] = db.run {
    basket.filter(_.user_id === user_id).result.head
  }

  def delete(id: Long): Future[Unit] = db.run(basket.filter(_.id === id).delete).map(_ => ())

  def update(id: Long, new_basket: Basket): Future[Unit] = {
    val basketToUpdate: Basket = new_basket.copy(id)
    db.run(basket.filter(_.id === id).update(basketToUpdate)).map(_ => ())
  }
}

