package models

import javax.inject.{Inject, Singleton}
import play.api.db.slick.DatabaseConfigProvider
import slick.jdbc.JdbcProfile

import scala.concurrent.{ExecutionContext, Future}

@Singleton
class UserRepository @Inject() (dbConfigProvider: DatabaseConfigProvider)(implicit ec: ExecutionContext) {
  val dbConfig = dbConfigProvider.get[JdbcProfile]

  import dbConfig._
  import profile.api._

  class UserTable(tag: Tag) extends Table[User](tag, "user") {
    def id = column[Long]("id", O.PrimaryKey, O.AutoInc)
    def login = column[String]("login")
    def password = column[String]("password")
    def email = column[String]("email")
    def admin = column[Boolean]("admin")
    def * = (id, login, password, email, admin) <> ((User.apply _).tupled, User.unapply)
  }

  val user = TableQuery[UserTable]

  def create(login: String, password: String, email: String, admin: Boolean): Future[User] = db.run {
    (user.map(u => (u.login, u.password, u.email, u.admin))
      returning user.map(_.id)
      into {case ((login, password, email, admin), id) => User(id, login, password, email, admin)}
      ) += (login, password, email, admin)
  }

  def list(): Future[Seq[User]] = db.run {
    user.result
  }

  def getById(id: Long): Future[User] = db.run {
    user.filter(_.id === id).result.head
  }

  def getByIdOption(id: Long): Future[Option[User]] = db.run {
    user.filter(_.id === id).result.headOption
  }

  def delete(id: Long): Future[Unit] = db.run(user.filter(_.id === id).delete).map(_ => ())

  def update(id: Long, new_user: User): Future[Unit] = {
    val userToUpdate: User = new_user.copy(id)
    db.run(user.filter(_.id === id).update(userToUpdate)).map(_ => ())
  }

}


