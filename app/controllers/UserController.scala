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
      "provId" -> nonEmptyText,
      "uKey" -> nonEmptyText,
      "login" -> nonEmptyText,
      "email" -> nonEmptyText,
      "admin" -> boolean,
    )(CreateUserForm.apply)(CreateUserForm.unapply)
  }

  val updateUserForm: Form[UpdateUserForm] = Form {
    mapping(
      "id" -> longNumber,
      "provId" -> nonEmptyText,
      "uKey" -> nonEmptyText,
      "login" -> nonEmptyText,
      "email" -> nonEmptyText,
      "admin" -> boolean,
    )(UpdateUserForm.apply)(UpdateUserForm.unapply)
  }

  def addUser = Action {
    Ok("Your new application is ready.")
  }

  def addUserHandle = Action.async { implicit request =>
    val provId = request.body.asJson.get("provId").as[String]
    val uKey = request.body.asJson.get("uKey").as[String]
    val login = request.body.asJson.get("login").as[String]
    val email = request.body.asJson.get("email").as[String]
    val admin = request.body.asJson.get("admin").as[Boolean]

    userRepo.create( provId, uKey, login, email, admin).map { user =>
      Ok(Json.toJson(user))
    }
  }

  def updateUser(id: Long): Action[AnyContent] = Action.async { implicit request =>
    val user = userRepo.getByIdOption(id)
    user.map(user => Ok(Json.toJson(user)))
  }

  def updateUserHandle = Action.async { implicit request =>
    val id = request.body.asJson.get("id").as[Long]
    val provId = request.body.asJson.get("provId").as[String]
    val uKey = request.body.asJson.get("uKey").as[String]
    val login = request.body.asJson.get("login").as[String]
    val email = request.body.asJson.get("email").as[String]
    val admin = request.body.asJson.get("admin").as[Boolean]

    userRepo.update(id, UserClass(id, provId, uKey, login, email, admin)).map { user =>
      Ok(Json.toJson(UserClass(id, provId, uKey, login, email, admin)))
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

case class CreateUserForm(provId: String, uKey: String, login: String, email: String, admin: Boolean)
case class UpdateUserForm(id: Long, provId: String, uKey: String, login: String, email: String, admin: Boolean)
