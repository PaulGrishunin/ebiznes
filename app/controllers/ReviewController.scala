package controllers

import javax.inject._
import models.{UserClass, UserClassRepository, Review, ReviewRepository, Product, ProductRepository}
import play.api.data.Form
import play.api.data.Forms._
import play.api.libs.json.Json
import play.api.mvc._

import scala.concurrent.{ExecutionContext, Future}
import scala.util.{Failure, Success}

@Singleton
class ReviewController @Inject()(userRepo: UserClassRepository, reviewRepo: ReviewRepository, productRepo: ProductRepository, cc: MessagesControllerComponents)(implicit ec: ExecutionContext) extends MessagesAbstractController(cc) {
  
  val reviewForm: Form[CreateReviewForm] = Form {
    mapping(
      "product" -> longNumber,
      "user" -> longNumber,
           "rate" -> byteNumber,
      "text" -> nonEmptyText,
    )(CreateReviewForm.apply)(CreateReviewForm.unapply)
  }

  val updateReviewForm: Form[UpdateReviewForm] = Form {
    mapping(
      "id" -> longNumber,
      "product" -> longNumber,
      "user" -> longNumber,
      "rate" -> byteNumber,
      "text" -> nonEmptyText,
    )(UpdateReviewForm.apply)(UpdateReviewForm.unapply)
  }

  def addReview = Action {
    Ok("Your new application is ready.")
  }

  def addReviewHandle = Action.async { implicit request =>
    val product = request.body.asJson.get("product").as[Long]
    val user = request.body.asJson.get("user").as[Long]
    val rate = request.body.asJson.get("rate").as[Byte]
    val text = request.body.asJson.get("text").as[String]

    reviewRepo.create(product, user, rate, text).map { review =>
      Ok(Json.toJson(review))
    }
  }

  def updateReview(id: Int): Action[AnyContent] = Action.async { implicit request =>
    val review = reviewRepo.getByIdOption(id)
    review.map(review => Ok(Json.toJson(review)))
  }
  def updateReviewHandle = Action.async { implicit request =>
    val id = request.body.asJson.get("id").as[Int]
    val product = request.body.asJson.get("product").as[Long]
    val user = request.body.asJson.get("user").as[Long]
    val rate = request.body.asJson.get("rate").as[Byte]
    val text = request.body.asJson.get("text").as[String]

    reviewRepo.update(id, Review(id, product, user, rate, text)).map { review =>
      Ok(Json.toJson(Review(id, product, user, rate, text)))
    }
  }

  def review(productid: Long): Action[AnyContent] = Action.async { implicit request =>
    val rev = reviewRepo.list(productid)
    rev.map( reviews => Ok(Json.toJson(reviews)))
  }
//  def getReviews: Action[AnyContent] = Action.async { implicit request =>
//    val rev = reviewRepo.list()
//    rev.map( reviews => Ok(Json.toJson(reviews)))
//  }

  def deleteReview(id: Int): Action[AnyContent] = Action {
    reviewRepo.delete(id)
    Redirect("/reviews")
  }

}

case class CreateReviewForm( product: Long, user: Long, rate: Byte, text: String)
case class UpdateReviewForm(id: Long, product: Long,  user: Long, rate: Byte, text: String)
