package controllers

import javax.inject._
import models.{Category, CategoryRepository}
import play.api.data.Form
import play.api.data.Forms._
import play.api.libs.json.Json
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
class CategoryController @Inject()(categoryRepo: CategoryRepository, cc: MessagesControllerComponents)(implicit ec: ExecutionContext) extends MessagesAbstractController(cc) {

  val categoryForm: Form[CreateCategoryForm] = Form {
    mapping(
      "name" -> nonEmptyText,
    )(CreateCategoryForm.apply)(CreateCategoryForm.unapply)
  }

  val updateCategoryForm: Form[UpdateCategoryForm] = Form {
    mapping(
      "id" -> number,
      "name" -> nonEmptyText,
    )(UpdateCategoryForm.apply)(UpdateCategoryForm.unapply)
  }


  def addCategory = Action {
    Ok("Your new application is ready.")
  }

  def addCategoryHandle = Action.async { implicit request =>
    val name = request.body.asJson.get("name").as[String]

    categoryRepo.create(name).map { category =>
      Ok(Json.toJson(category))
    }
  }

  def updateCategory(id: Int): Action[AnyContent] = Action.async { implicit request =>
    val cat = categoryRepo.getByIdOption(id)
    cat.map(category => Ok(Json.toJson(category)))
  }

  def updateCategoryHandle = Action.async { implicit request =>
    val id = request.body.asJson.get("id").as[Int]
    val name = request.body.asJson.get("name").as[String]

    categoryRepo.update(id, Category(id, name)).map { category =>
      Ok(Json.toJson(Category(id, name)))
    }
  }

  def deleteCategory(id: Int) = Action {
    categoryRepo.delete(id)
    Redirect("/categories")
  }

  def getCategory(id: Int): Action[AnyContent] = Action.async { implicit request =>
    val cat = categoryRepo.getByIdOption(id)
    cat.map(category => Ok(Json.toJson(category)))
  }

  def getCategories: Action[AnyContent] = Action.async { implicit request =>
    val cat = categoryRepo.list()
    cat.map(categories => Ok(Json.toJson(categories)))
  }
}

case class CreateCategoryForm(name: String)
case class UpdateCategoryForm(id: Int, name: String)
