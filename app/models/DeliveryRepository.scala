package models

import javax.inject.{Inject, Singleton}
import play.api.db.slick.DatabaseConfigProvider
import slick.jdbc.JdbcProfile

import scala.concurrent.{ExecutionContext, Future}

@Singleton
class DeliveryRepository @Inject() (dbConfigProvider: DatabaseConfigProvider)(implicit ec: ExecutionContext) {
  val dbConfig = dbConfigProvider.get[JdbcProfile]

  import dbConfig._
  import profile.api._

  class DeliveryTable(tag: Tag) extends Table[Delivery](tag, "delivery") {

    def id = column[Long]("id", O.PrimaryKey, O.AutoInc)
    def order_id = column[Long]("order_id")
    def address = column[String]("address")

    def * = (id, order_id, address) <> ((Delivery.apply _).tupled, Delivery.unapply)

  }

  val delivery = TableQuery[DeliveryTable]

  def create(order_id: Long, address: String): Future[Delivery] = db.run {
    (delivery.map(d => (d.order_id, d.address))
      returning delivery.map(_.id)
      into {case ((order_id, address), id) => Delivery(id, order_id, address)}
    ) += (order_id, address)
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
  def getByOrderIdOption(order_id: Long): Future[Option[Delivery]] = db.run {
    delivery.filter(_.order_id === order_id).result.headOption
  }


  def delete(id: Long): Future[Unit] = db.run(delivery.filter(_.id === id).delete).map(_ => ())

  def update(id: Long, new_delivery: Delivery): Future[Unit] = {
    val deliveryToUpdate: Delivery = new_delivery.copy(id)
    db.run(delivery.filter(_.id === id).update(deliveryToUpdate)).map(_ => ())
  }

}

