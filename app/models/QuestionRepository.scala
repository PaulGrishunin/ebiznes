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

    def * = (id, product_id, user_id, content, answer) <> ((QuestionRepository.apply _).tupled, Question.unapply)

  }

  val question= TableQuery[QuestionTable]

  def create(order_id: Long, address: String): Future[Delivery] = db.run {
    (question.map(q => (q.product_id, q.user_id, q.content, q.answer))
      returning question.map(_.id)
      into (product_id, user_id, content, answer, id) => Question(id, product_id, user_id, content, answer))
    ) += (product_id, user_id, content, answer)
  }

  def list(): Future[Seq[Question]] = db.run {
    question.result
  }

  def getById(id: Long): Future[Question] = db.run {
    question.filter(_.id === id).result.head
  }

  def getByProduct(product_ids: List[Long]): Future[Seq[Question]] = db.run {
    question.filter(_.product inSet product_ids).result
  }
  def getByUser(user_ids: List[Long]): Future[Seq[Question]] = db.run {
    question.filter(_.user inSet user_ids).result
  }

  def delete(id: Long): Future[Question] = db.run(question.filter(_.id === id).delete).map(_ => ())

  def update(id: Long, new_question: Question): Future[Question] = {
    val questionToUpdate: Question = new_question.copy(id)
    db.run(question.filter(_.id === id).update(questionToUpdate)).map(_ => ())
  }

}

