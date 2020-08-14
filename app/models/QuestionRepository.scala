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
    def product = column[Long]("product")
    def user = column[Long]("user")
    def content = column[String]("content")
    def answer = column[String]("answer")
    def * = (id, product, user, content, answer) <> ((Question.apply _).tupled, Question.unapply)
  }

  val question= TableQuery[QuestionTable]

  def create(product: Long, user: Long, content: String, answer: String): Future[Question] = db.run {
    (question.map(q => (q.product, q.user, q.content, q.answer))
      returning question.map(_.id)
      into {case ((product, user, content, answer), id) => Question(id, product, user, content, answer)}
      ) += (product, user, content, answer)
  }

  def list(): Future[Seq[Question]] = db.run {
    question.result
  }

  def getById(id: Long): Future[Question] = db.run {
    question.filter(_.id === id).result.head
  }

  def getByIdOption(id: Long): Future[Option[Question]] = db.run {
    question.filter(_.id === id).result.headOption
  }

  def getByProduct_Id(product: Long): Future[Question] = db.run {
    question.filter(_.product === product).result.head
  }

  def delete(id: Long): Future[Unit] = db.run(question.filter(_.id === id).delete).map(_ => ())

  def update(id: Long, new_question: Question): Future[Unit] = {
    val questionToUpdate: Question = new_question.copy(id)
    db.run(question.filter(_.id === id).update(questionToUpdate)).map(_ => ())
  }

}
