package models

import javax.inject.{ Inject, Singleton }
import play.api.db.slick.DatabaseConfigProvider
import slick.jdbc.JdbcProfile

import scala.concurrent.{ ExecutionContext, Future }

@Singleton
class DeliveryRepository @Inject() (dbConfigProvider: DatabaseConfigProvider)(implicit ec: ExecutionContext) {
  val dbConfig = dbConfigProvider.get[JdbcProfile]

  import dbConfig._
  import profile.api._

  class DeliveryTable(tag: Tag) extends Table[Delivery](tag, "delivery") {

    def id = column[Long]("id", O.PrimaryKey, O.AutoInc)
    def order = column[Long]("order")
    def date = column[String]("date")

    def * = (id, order, date) <> ((Delivery.apply _).tupled, Delivery.unapply)

  }

  val delivery = TableQuery[DeliveryTable]

  def create(order: Long, date: String): Future[Delivery] = db.run {
    (delivery.map(d => (d.order, d.date))
      returning delivery.map(_.id)
      into { case ((order, date), id) => Delivery(id, order, date) }
    ) += (order, date)
  }

  def list(): Future[Seq[Delivery]] = db.run {
    delivery.result
  }

  def getById(id: Long): Future[Delivery] = db.run {
    delivery.filter(_.id === id).result.head
  }

  def getByIdOption(id: Long): Future[Option[Delivery]] = db.run {
    delivery.filter(_.id === id).result.headOption
  }
  def getByOrdOption(order: Long): Future[Delivery] = db.run {
    delivery.filter(_.order === order).result.head
  }

  def delete(id: Long): Future[Unit] = db.run(delivery.filter(_.id === id).delete).map(_ => ())

  def update(id: Long, new_delivery: Delivery): Future[Unit] = {
    val deliveryToUpdate: Delivery = new_delivery.copy(id)
    db.run(delivery.filter(_.id === id).update(deliveryToUpdate)).map(_ => ())
  }

}

