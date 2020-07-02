package models

import javax.inject.{Inject, Singleton}
import play.api.db.slick.DatabaseConfigProvider
import slick.jdbc.JdbcProfile

import scala.concurrent.{ExecutionContext, Future}

@Singleton
class QuestionRepository @Inject() (dbConfigProvider: DatabaseConfigProvider)(implicit ec: ExecutionContext) {
  val dbConfig = dbConfigProvider.get[JdbcProfile]

  import dbConfig._
  import profile.api._

  class QuestionTable(tag: Tag) extends Table[Question](tag, "question") {
    def id = column[Long]("id", O.PrimaryKey, O.AutoInc)
    def product_id = column[Long]("productid")
    def user_id = column[Long]("userid")
    def content = column[String]("content")
    def answer = column[String]("answer")
    def * = (id, product_id, user_id, content, answer) <> ((Question.apply _).tupled, Question.unapply)
  }

  val question= TableQuery[QuestionTable]

  def create(product_id: Long, user_id: Long, content: String, answer: String): Future[Question] = db.run {
    (question.map(q => (q.product_id, q.user_id, q.content, q.answer))
      returning question.map(_.id)
      into {case ((product_id, user_id, content, answer), id) => Question(id, product_id, user_id, content, answer)}
    ) += (product_id, user_id, content, answer)
  }

  def list(): Future[Seq[Question]] = db.run {
    question.result
  }

  def getById(id: Long): Future[Question] = db.run {
    question.filter(_.id === id).result.head
  }

  def getByProduct_Id(product_id: Long): Future[Question] = db.run {
    question.filter(_.product_id === product_id).result.head
  }

  def getByUser_Id(user_id: Long): Future[Question] = db.run {
    question.filter(_.user_id === user_id).result.head
  }

  def delete(id: Long): Future[Unit] = db.run(question.filter(_.id === id).delete).map(_ => ())

  def update(id: Long, new_question: Question): Future[Unit] = {
    val questionToUpdate: Question = new_question.copy(id)
    db.run(question.filter(_.id === id).update(questionToUpdate)).map(_ => ())
  }

}

