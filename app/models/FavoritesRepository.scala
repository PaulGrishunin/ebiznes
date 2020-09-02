package models

import javax.inject.{ Inject, Singleton }
import play.api.db.slick.DatabaseConfigProvider
import slick.jdbc.JdbcProfile

import scala.concurrent.{ ExecutionContext, Future }

@Singleton
class FavoritesRepository @Inject() (dbConfigProvider: DatabaseConfigProvider)(implicit ec: ExecutionContext) {
  val dbConfig = dbConfigProvider.get[JdbcProfile]

  import dbConfig._
  import profile.api._

  class FavoritesTable(tag: Tag) extends Table[Favorites](tag, "favorites") {
    def id = column[Long]("id", O.PrimaryKey, O.AutoInc)
    def user = column[Long]("user")
    def product = column[Long]("product")
    def * = (id, user, product) <> ((Favorites.apply _).tupled, Favorites.unapply)
  }

  val favorites = TableQuery[FavoritesTable]

  def create(user: Long, product: Long): Future[Favorites] = db.run {
    (favorites.map(f => (f.user, f.product))
      returning favorites.map(_.id)
      into { case ((user, product), id) => Favorites(id, user, product) }
    ) += (user, product)
  }

  def list(user_id: Long): Future[Seq[Favorites]] = db.run {
    favorites.filter(_.user === user_id).result
  }

  def getById(id: Long): Future[Favorites] = db.run {
    favorites.filter(_.id === id).result.head
  }

  def getByIdOption(id: Long): Future[Option[Favorites]] = db.run {
    favorites.filter(_.id === id).result.headOption
  }

  def getByUserId(user: Long): Future[Favorites] = db.run {
    favorites.filter(_.user === user).result.head
  }

  def delete(productid: Long): Future[Unit] = db.run(favorites.filter(_.product === productid).delete).map(_ => ())

  def update(id: Long, new_question: Favorites): Future[Unit] = {
    val favoritesToUpdate: Favorites = new_question.copy(id)
    db.run(favorites.filter(_.id === id).update(favoritesToUpdate)).map(_ => ())
  }

}
