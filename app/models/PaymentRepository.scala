package models

import javax.inject.{ Inject, Singleton }
import play.api.db.slick.DatabaseConfigProvider
import slick.jdbc.JdbcProfile
import scala.concurrent.{ Future, ExecutionContext }

@Singleton
class PaymentRepository @Inject() (dbConfigProvider: DatabaseConfigProvider)(implicit ec: ExecutionContext) {
  val dbConfig = dbConfigProvider.get[JdbcProfile]

  import dbConfig._
  import profile.api._

  class PaymentTable(tag: Tag) extends Table[Payment](tag, "payment") {
    def id = column[Long]("id", O.PrimaryKey, O.AutoInc)
    def order = column[Long]("order")
    def date = column[String]("date")
    def * = (id, order, date) <> ((Payment.apply _).tupled, Payment.unapply)

  }

  val payment = TableQuery[PaymentTable]

  def create(order: Long, date: String): Future[Payment] = db.run {
    (payment.map(p => (p.order, p.date))
      returning payment.map(_.id)
      into { case ((order, date), id) => Payment(id, order, date) }
    ) += (order, date)
  }

  def list(): Future[Seq[Payment]] = db.run {
    payment.result
  }

  def getById(id: Long): Future[Payment] = db.run {
    payment.filter(_.id === id).result.head
  }

  def getByIdOption(id: Long): Future[Option[Payment]] = db.run {
    payment.filter(_.id === id).result.headOption
  }
  def getByOrdOption(order: Long): Future[Payment] = db.run {
    payment.filter(_.order === order).result.head
  }

  def delete(id: Long): Future[Unit] = db.run(payment.filter(_.id === id).delete).map(_ => ())

  def update(id: Long, new_payment: Payment): Future[Unit] = {
    val paymentToUpdate: Payment = new_payment.copy(id)
    db.run(payment.filter(_.id === id).update(paymentToUpdate)).map(_ => ())
  }

}

