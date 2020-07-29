package models

import javax.inject.{ Inject, Singleton }
import play.api.db.slick.DatabaseConfigProvider
import slick.jdbc.JdbcProfile

import scala.concurrent.{ ExecutionContext, Future }

@Singleton
class ReviewRepository @Inject()(dbConfigProvider: DatabaseConfigProvider)(implicit ec: ExecutionContext) {
  private val dbConfig = dbConfigProvider.get[JdbcProfile]

  import dbConfig._
  import profile.api._

  private class ReviewTable(tag: Tag) extends Table[Review](tag, "review") {
    def id = column[Int]("id", O.PrimaryKey, O.AutoInc)
    def user_id = column[Long]("user_id")
    def rate: Rep[Byte] = column[Byte]("rate")
    def text: Rep[String] = column[String]("text")
    def * = (id, user_id, rate, text) <> ((Review.apply _).tupled, Review.unapply)
  }

  private val review = TableQuery[ReviewTable]

  def create(user_id: Long, rate: Byte, text: String): Future[Review] = db.run {
    (review.map(r => (r.user_id, r.rate, r.text))
      returning review.map(_.id)
      into { case ((user_id, rate, text), id) => Review(id, user_id, rate, text) }
      ) += (user_id, rate, text)
  }

  def list(): Future[Seq[Review]] = db.run {
    review.result
  }

  def delete(id: Int): Future[Unit] = db.run(review.filter(_.id === id).delete).map(_ => ())

  def update(id: Int, new_review: Review): Future[Unit] = {
    val reviewToUpdate: Review = new_review.copy(id)
    db.run(review.filter(_.id === id).update(reviewToUpdate)).map(_ => ())
  }

  def getById(id: Int): Future[Review] = db.run {
    review.filter(_.id === id).result.head
  }

  def getByIdOption(id: Int): Future[Option[Review]] = db.run {
    review.filter(_.id === id).result.headOption
  }
}