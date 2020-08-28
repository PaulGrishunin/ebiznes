package controllers

import javax.inject._
import models.{UserClass, UserClassRepository}
import play.api.data.Form
import play.api.data.Forms._
import play.api.mvc._

import scala.concurrent.{ExecutionContext, Future}
import scala.util.{Failure, Success}
import play.api.data.format.Formats._
import play.api.libs.json.Json

/**
 * This controller creates an `Action` to handle HTTP requests to the
 * application's home page.
 */
@Singleton
class UserController @Inject()(userRepo: UserClassRepository, cc: MessagesControllerComponents)(implicit ec: ExecutionContext) extends MessagesAbstractController(cc) {

  val userForm: Form[CreateUserForm] = Form {
    mapping(
      "login" -> nonEmptyText,
      "password" -> nonEmptyText,
      "email" -> nonEmptyText,
      "admin" -> boolean,
    )(CreateUserForm.apply)(CreateUserForm.unapply)
  }

  val updateUserForm: Form[UpdateUserForm] = Form {
    mapping(
      "id" -> longNumber,
      "login" -> nonEmptyText,
      "password" -> nonEmptyText,
      "email" -> nonEmptyText,
      "admin" -> boolean,
    )(UpdateUserForm.apply)(UpdateUserForm.unapply)
  }

  def addUser = Action {
    Ok("Your new application is ready.")
  }

  def addUserHandle = Action.async { implicit request =>
    val login = request.body.asJson.get("login").as[String]
    val password = request.body.asJson.get("password").as[String]
    val email = request.body.asJson.get("email").as[String]
    val admin = request.body.asJson.get("admin").as[Boolean]

    userRepo.create( login, password, email, admin).map { user =>
      Ok(Json.toJson(user))
    }
  }

  def updateUser(id: Long): Action[AnyContent] = Action.async { implicit request =>
    val user = userRepo.getByIdOption(id)
    user.map(user => Ok(Json.toJson(user)))
  }

  def updateUserHandle = Action.async { implicit request =>
    val id = request.body.asJson.get("id").as[Long]
    val login = request.body.asJson.get("login").as[String]
    val password = request.body.asJson.get("password").as[String]
    val email = request.body.asJson.get("email").as[String]
    val admin = request.body.asJson.get("admin").as[Boolean]

    userRepo.update(id, UserClass(id, login, password, email, admin)).map { user =>
      Ok(Json.toJson(UserClass(id, login, password, email, admin)))
    }
  }

  def deleteUser(id: Long) = Action {
    userRepo.delete(id)
    Redirect("/users")
  }

  def getUser(id: Long): Action[AnyContent] = Action.async { implicit request =>
    val user = userRepo.getByIdOption(id)
    user.map(user => Ok(Json.toJson(user)))
  }

  def getUsers = Action.async { implicit request =>
    val usr = userRepo.list()
    usr.map( users => Ok(Json.toJson(users)))
    //Ok(views.html.index("Your new application is ready."))
  }
}

case class CreateUserForm(login: String, password: String, email: String, admin: Boolean)
case class UpdateUserForm(id: Long, login: String, password: String, email: String, admin: Boolean)
