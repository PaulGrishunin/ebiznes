package controllers

import javax.inject._
import models.{User, UserRepository, Review, ReviewRepository}
import play.api.data.Form
import play.api.data.Forms._
import play.api.libs.json.Json
import play.api.mvc._

import scala.concurrent.{ExecutionContext, Future}
import scala.util.{Failure, Success}

@Singleton
class ReviewController @Inject()(userRepo: UserRepository, reviewRepo: ReviewRepository, cc: MessagesControllerComponents)(implicit ec: ExecutionContext) extends MessagesAbstractController(cc) {
  
  val reviewForm: Form[CreateReviewForm] = Form {
    mapping(
      "user_id" -> longNumber,
      "rate" -> byteNumber,
      "text" -> nonEmptyText,
    )(CreateReviewForm.apply)(CreateReviewForm.unapply)
  }

  val updateReviewForm: Form[UpdateReviewForm] = Form {
    mapping(
      "id" -> longNumber,
      "user_id" -> longNumber,
      "rate" -> byteNumber,
      "text" -> nonEmptyText,
    )(UpdateReviewForm.apply)(UpdateReviewForm.unapply)
  }

  def addReview = Action {
    Ok("Your new application is ready.")
  }

  def addReviewHandle = Action.async { implicit request =>
    val user_id = request.body.asJson.get("user_id").as[Long]
    val rate = request.body.asJson.get("rate").as[Byte]
    val text = request.body.asJson.get("text").as[String]

    reviewRepo.create(user_id, rate, text).map { review =>
      Ok(Json.toJson(review))
    }
  }

  def updateReview(id: Int): Action[AnyContent] = Action.async { implicit request =>
    val review = reviewRepo.getByIdOption(id)
    review.map(review => Ok(Json.toJson(review)))
  }
  def updateReviewHandle = Action.async { implicit request =>
    val id = request.body.asJson.get("id").as[Int]
    val user_id = request.body.asJson.get("user_id").as[Long]
    val rate = request.body.asJson.get("rate").as[Byte]
    val text = request.body.asJson.get("text").as[String]

    reviewRepo.update(id, Review(id, user_id, rate, text)).map { review =>
      Ok(Json.toJson(Review(id, user_id, rate, text)))
    }
  }

  def getReview(id: Int): Action[AnyContent] = Action.async { implicit request =>
    val review = reviewRepo.getByIdOption(id)
    review.map( review => Ok(Json.toJson(review)))
  }
  def getReviews: Action[AnyContent] = Action.async { implicit request =>
    val rev = reviewRepo.list()
    rev.map( reviews => Ok(Json.toJson(reviews)))
  }

  def deleteReview(id: Int): Action[AnyContent] = Action {
    reviewRepo.delete(id)
    Redirect("/reviews")
  }

}

case class CreateReviewForm( user_id: Long, rate: Byte, text: String)
case class UpdateReviewForm(id: Long, user_id: Long, rate: Byte, text: String)
