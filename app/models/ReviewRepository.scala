package models

import javax.inject.{Inject, Singleton}
import play.api.db.slick.DatabaseConfigProvider
import slick.jdbc.JdbcProfile

import scala.concurrent.{ExecutionContext, Future}

@Singleton
class ReviewRepository @Inject() (dbConfigProvider: DatabaseConfigProvider)(implicit ec: ExecutionContext) {
  val dbConfig = dbConfigProvider.get[JdbcProfile]

  import dbConfig._
  import profile.api._

  class ReviewTable(tag: Tag) extends Table[Review](tag, "review") {
    def id = column[Long]("id", O.PrimaryKey, O.AutoInc)
    def product_id = column[Long]("productid")
    def user_id = column[Long]("userid")
    def content = column[String]("content")
    def rate = column[Byte]("rate")
    def * = (id, user_id, product_id, content, rate) <> ((Review.apply _).tupled, Review.unapply)
  }

  val review = TableQuery[ReviewTable]

  def create(user_id: Long, product_id: Long, content: String, rate: Byte): Future[Review] = db.run {
    (review.map(r => (r.user_id, r.product_id, r.content, r.rate))
      returning review.map(_.id)
      into {case((user_id, product_id, content, rate), id) => Review(id, user_id, product_id, content, rate)}
      ) += (user_id, product_id, content, rate)
  }

  def list(): Future[Seq[Review]] = db.run {
    review.result
  }

  def getById(id: Long): Future[Review] = db.run {
    review.filter(_.id === id).result.head
  }

  def getByProduct_Id(product_id: Long): Future[Review] = db.run {
    review.filter(_.product_id === product_id).result.head
  }

  def delete(id: Long): Future[Unit] = db.run(review.filter(_.id === id).delete).map(_ => ())

  def update(id: Long, new_review: Review): Future[Unit] = {
    val reviewToUpdate: Review = new_review.copy(id)
    db.run(review.filter(_.id === id).update(reviewToUpdate)).map(_ => ())
  }
}

