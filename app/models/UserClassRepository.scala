package models

import javax.inject.{ Inject, Singleton }
import play.api.db.slick.DatabaseConfigProvider
import slick.jdbc.JdbcProfile

import scala.concurrent.{ ExecutionContext, Future }

@Singleton
class UserClassRepository @Inject() (dbConfigProvider: DatabaseConfigProvider)(implicit ec: ExecutionContext) {
  val dbConfig = dbConfigProvider.get[JdbcProfile]

  import dbConfig._
  import profile.api._

  class UserTable(tag: Tag) extends Table[UserClass](tag, "user") {
    def id = column[Long]("id", O.PrimaryKey, O.AutoInc)
    def provId = column[String]("provId")
    def uKey = column[String]("uKey")
    def login = column[String]("login")
    def email = column[String]("email")
    def admin = column[Boolean]("admin")
    def * = (id, provId, uKey, login, email, admin) <> ((UserClass.apply _).tupled, UserClass.unapply)
  }

  val user = TableQuery[UserTable]

  def create(provId: String, uKey: String, login: String, email: String, admin: Boolean): Future[UserClass] = db.run {
    (user.map(u => (u.provId, u.uKey, u.login, u.email, u.admin))
      returning user.map(_.id)
      into { case ((provId, uKey, login, email, admin), id) => UserClass(id, provId, uKey, login, email, admin) }
    ) += (provId, uKey, login, email, admin)
  }

  def list(): Future[Seq[UserClass]] = db.run {
    user.result
  }

  def getById(id: Long): Future[UserClass] = db.run {
    user.filter(_.id === id).result.head
  }

  def getByIdOption(id: Long): Future[Option[UserClass]] = db.run {
    user.filter(_.id === id).result.headOption
  }

  def delete(id: Long): Future[Unit] = db.run(user.filter(_.id === id).delete).map(_ => ())

  def update(id: Long, new_user: UserClass): Future[Unit] = {
    val userToUpdate: UserClass = new_user.copy(id)
    db.run(user.filter(_.id === id).update(userToUpdate)).map(_ => ())
  }

  def getByProvId(provId: String, uKey: String): Future[Option[UserClass]] = db.run {
    user.filter(_.provId === provId).filter(_.uKey === uKey).result.headOption
  }
}

