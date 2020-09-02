package controllers

import javax.inject._
import models.{UserClass, UserClassRepository, Product, ProductRepository, Favorites, FavoritesRepository}
import play.api.data.Form
import play.api.data.Forms._
import play.api.libs.json.Json
import play.api.mvc._

import scala.concurrent.{ExecutionContext, Future}
import scala.util.{Failure, Success}

@Singleton
class FavoritesController @Inject()(userRepo: UserClassRepository, productRepo: ProductRepository, favsRepo: FavoritesRepository, cc: MessagesControllerComponents)(implicit ec: ExecutionContext) extends MessagesAbstractController(cc) {
  
  val favoritesForm: Form[CreateFavoritesForm] = Form {
    mapping(
      "user" -> longNumber,
      "product" -> longNumber,
    )(CreateFavoritesForm.apply)(CreateFavoritesForm.unapply)
  }

  val updateFavoritesForm: Form[UpdateFavoritesForm] = Form {
    mapping(
      "id" -> longNumber,
      "user" -> longNumber,
      "product" -> longNumber,
    )(UpdateFavoritesForm.apply)(UpdateFavoritesForm.unapply)
  }

  def addFavorites = Action {
    Ok("Your new application is ready.")
  }


  def updateFavorites(id: Long): Action[AnyContent] = Action.async { implicit request =>
    val favorites = favsRepo.getByIdOption(id)
    favorites.map(favorites => Ok(Json.toJson(favorites)))
  }

  def updateFavoritesHandle = Action.async { implicit request =>
    val id = request.body.asJson.get("id").as[Long]
    val user = request.body.asJson.get("user").as[Long]
    val product = request.body.asJson.get("product").as[Long]

    favsRepo.update(id, Favorites(id, user, product)).map { favorites =>
      Ok(Json.toJson(Favorites(id, user, product)))
    }
  }

  def getFavorit(id: Int): Action[AnyContent] = Action.async { implicit request =>
    val favorites = favsRepo.getByIdOption(id)
    favorites.map( favorites => Ok(Json.toJson(favorites)))
  }

//  def getFavorites: Action[AnyContent] = Action.async { implicit request =>
//    val favs = favsRepo.list(user_id)
//    favs.map( favorites => Ok(Json.toJson(favorites)))
//  }

  def getFavoritesUsr(user_id: Long): Action[AnyContent] = Action.async { implicit request =>
    val favsuser = favsRepo.list(user_id)
    favsuser.map( favorites => Ok(Json.toJson(favorites)))
  }

  def deleteFavorites(productid: Long): Action[AnyContent] = Action {
    favsRepo.delete(productid)
    Redirect("/favorites")
  }

}

case class CreateFavoritesForm( user: Long, product: Long)
case class UpdateFavoritesForm(id: Long, user: Long, product: Long)
