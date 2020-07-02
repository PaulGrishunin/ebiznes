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
    def pay_name = column[String]("pay_name")
    def description = column[String]("description")
    def * = (id, pay_name, description) <> ((Payment.apply _).tupled, Payment.unapply)

  }

  val payment = TableQuery[PaymentTable]

  def create(pay_name: String, description: String): Future[Payment] = db.run {
    (payment.map(p => (p.pay_name, p.description))
      returning payment.map(_.id)
      into {case ((pay_name, description), id) => Payment(id, pay_name, description)}
    ) += (pay_name, description)
  }

  def list(): Future[Seq[Payment]] = db.run {
    payment.result
  }

  def getById(id: Long): Future[Payment] = db.run {
    payment.filter(_.id === id).result.head
  }

  def delete(id: Long): Future[Unit] = db.run(payment.filter(_.id === id).delete).map(_ => ())

  def update(id: Long, new_payment: Payment): Future[Unit] = {
    val paymentToUpdate: Payment = new_payment.copy(id)
    db.run(payment.filter(_.id === id).update(paymentToUpdate)).map(_ => ())
  }

}

