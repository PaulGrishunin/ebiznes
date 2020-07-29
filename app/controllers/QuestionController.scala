package controllers

import javax.inject._
import models.{User, UserRepository, Product, ProductRepository, Question, QuestionRepository}
import play.api.data.Form
import play.api.data.Forms._
import play.api.libs.json.Json
import play.api.mvc._

import scala.concurrent.{ExecutionContext, Future}
import scala.util.{Failure, Success}

@Singleton
class QuestionController @Inject()(userRepo: UserRepository, productRepo: ProductRepository, questRepo: QuestionRepository, cc: MessagesControllerComponents)(implicit ec: ExecutionContext) extends MessagesAbstractController(cc) {
  
  val questionForm: Form[CreateQuestionForm] = Form {
    mapping(
      "user_id" -> longNumber,
      "product_id" -> longNumber,
      "content" -> nonEmptyText,
      "answer" -> nonEmptyText,
    )(CreateQuestionForm.apply)(CreateQuestionForm.unapply)
  }

  val updateQuestionForm: Form[UpdateQuestionForm] = Form {
    mapping(
      "id" -> number,
      "user_id" -> longNumber,
      "product_id" -> longNumber,
      "content" -> nonEmptyText,
      "answer" -> nonEmptyText,
    )(UpdateQuestionForm.apply)(UpdateQuestionForm.unapply)
  }

  def addQuestion = Action {
    Ok("Your new application is ready.")
  }

  def addQuestionHandle = Action.async { implicit request =>
    val user_id = request.body.asJson.get("user_id").as[Long]
    val product_id = request.body.asJson.get("product_id").as[Long]
    val content = request.body.asJson.get("content").as[String]
    val answer = request.body.asJson.get("answer").as[String]

    questRepo.create(user_id, product_id, content, answer).map { question =>
      Ok(Json.toJson(question))
    }
  }

  def updateQuestion(id: Int): Action[AnyContent] = Action.async { implicit request =>
    val question = questRepo.getByIdOption(id)
    question.map(question => Ok(Json.toJson(question)))
  }

  def updateQuestionHandle = Action.async { implicit request =>
    val id = request.body.asJson.get("id").as[Int]
    val user_id = request.body.asJson.get("user_id").as[Long]
    val product_id = request.body.asJson.get("product_id").as[Long]
    val content = request.body.asJson.get("content").as[String]
    val answer = request.body.asJson.get("answer").as[String]

    questRepo.update(id, Question(id, user_id, product_id, content, answer)).map { question =>
      Ok(Json.toJson(Question(id, user_id, product_id, content, answer)))
    }
  }

  def getQuestion(id: Int): Action[AnyContent] = Action.async { implicit request =>
    val question = questRepo.getByIdOption(id)
    question.map( question => Ok(Json.toJson(question)))
  }

  def getQuestions: Action[AnyContent] = Action.async { implicit request =>
    val que = questRepo.list()
    que.map( questions => Ok(Json.toJson(questions)))
  }

  def getQuestionProd(product_id: Long): Action[AnyContent] = Action.async { implicit request =>
    val questprod = questRepo.getByProduct_Id(product_id)
    questprod.map( question => Ok(Json.toJson(question)))
  }

  def deleteQuestion(id: Int): Action[AnyContent] = Action {
    questRepo.delete(id)
    Redirect("/questions")
  }

}

case class CreateQuestionForm( user_id: Long, product_id: Long, content: String, answer: String)
case class UpdateQuestionForm(id: Int, user_id: Long, product_id: Long, content: String, answer: String)
