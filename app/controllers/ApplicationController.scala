package controllers

import com.mohiva.play.silhouette
import com.mohiva.play.silhouette.api.LogoutEvent
import com.mohiva.play.silhouette.api.actions._
import com.mohiva.play.silhouette.impl.providers.GoogleTotpInfo
import javax.inject.Inject
import utils.auth.DefaultEnv
import play.api.libs.json.Json
import play.api.mvc._
import utils.route.Calls
import models.UserClassRepository
import models.BasketRepository
import models.ReviewRepository
import models.FavoritesRepository

import scala.concurrent.{ ExecutionContext, Future }

/**
 * The basic application controller.
 */
class ApplicationController @Inject() (
  userRepo: UserClassRepository,
  basketRepo: BasketRepository,
  reviewRepo: ReviewRepository,
  favsRepo: FavoritesRepository,
  scc: SilhouetteControllerComponents,
  home: views.html.home
)(implicit ex: ExecutionContext) extends SilhouetteController(scc) {

  /**
   * Handles the index action.
   *
   * @return The result to display.
   */
  def index = SecuredAction.async { implicit request: SecuredRequest[EnvType, AnyContent] =>
    authInfoRepository.find[GoogleTotpInfo](request.identity.loginInfo).map { totpInfoOpt =>
      Ok(home(request.identity, totpInfoOpt))
    }
  }

  /**
   * Handles the Sign Out action.
   *
   * @return The result to display.
   */
  def signOut = SecuredAction.async { implicit request: SecuredRequest[EnvType, AnyContent] =>
    val result = Redirect(Calls.home)
    eventBus.publish(LogoutEvent(request.identity, request))
    authenticatorService.discard(request.authenticator, result)
  }

  def registred = silhouette.SecuredAction.async { implicit request: SecuredRequest[DefaultEnv, AnyContent] =>
    val provider = request.identity.loginInfo.providerID
    val key = request.identity.loginInfo.providerKey
    val user = userRepo.getByProvId(provider, key)
    user.map(user => Ok(Json.toJson(user)))
  }

  def basketContent = silhouette.SecuredAction.async { implicit request: SecuredRequest[DefaultEnv, AnyContent] =>
    val provider = request.identity.loginInfo.providerID
    val key = request.identity.loginInfo.providerKey
    userRepo.getByProvId(provider, key).flatMap(elem => {
      elem match {
        case Some(user) => {
          val basket = basketRepo.list(user.id)
          basket.map(basket => Ok(Json.toJson(basket)))
        }
        case None => Future.successful(Ok(Json.toJson("{status: \"success\"}")))
      }
    })
  }

  def addToBasketHandle = silhouette.SecuredAction.async { implicit request: SecuredRequest[DefaultEnv, AnyContent] =>
    val product = request.body.asJson.get("product").as[Long]
    val quantity = request.body.asJson.get("quantity").as[Int]

    val provider = request.identity.loginInfo.providerID
    val key = request.identity.loginInfo.providerKey
    userRepo.getByProvId(provider, key).flatMap(elem => {
      elem match {
        case Some(user) => {
          basketRepo.create(user.id, product, quantity).map { basket =>
            Ok(Json.toJson(basket))
          }
        }
        case None => Future.successful(Ok(Json.toJson("{status: \"success\"}")))
      }
    })
  }

  def addReviewHandle = silhouette.SecuredAction.async { implicit request: SecuredRequest[DefaultEnv, AnyContent] =>
    val product = request.body.asJson.get("product").as[Long]
    val rate = request.body.asJson.get("rate").as[Int]
    val text = request.body.asJson.get("text").as[String]

    val provider = request.identity.loginInfo.providerID
    val key = request.identity.loginInfo.providerKey
    userRepo.getByProvId(provider, key).flatMap(elem => {
      elem match {
        case Some(user) => {
          reviewRepo.create(product, user.id, rate, text).map { review =>
            Ok(Json.toJson(review))
          }
        }
        case None => Future.successful(Ok(Json.toJson("{status: \"success\"}")))
      }
    })
  }

  def addFavoritesHandle = silhouette.SecuredAction.async { implicit request: SecuredRequest[DefaultEnv, AnyContent] =>
    val product = request.body.asJson.get("product").as[Long]

    val provider = request.identity.loginInfo.providerID
    val key = request.identity.loginInfo.providerKey
    userRepo.getByProvId(provider, key).flatMap(elem => {
      elem match {
        case Some(user) => {
          favsRepo.create(user.id, product).map { favorites =>
            Ok(Json.toJson(favorites))
          }
        }
        case None => Future.successful(Ok(Json.toJson("{status: \"success\"}")))
      }
    })
  }
  def favoritesContent = silhouette.SecuredAction.async { implicit request: SecuredRequest[DefaultEnv, AnyContent] =>
    val provider = request.identity.loginInfo.providerID
    val key = request.identity.loginInfo.providerKey
    userRepo.getByProvId(provider, key).flatMap(elem => {
      elem match {
        case Some(user) => {
          val favorites = favsRepo.list(user.id)
          favorites.map(favorites => Ok(Json.toJson(favorites)))
        }
        case None => Future.successful(Ok(Json.toJson("{status: \"success\"}")))
      }
    })
  }

  def getUser = silhouette.SecuredAction.async { implicit request: SecuredRequest[DefaultEnv, AnyContent] =>
    val provider = request.identity.loginInfo.providerID
    val key = request.identity.loginInfo.providerKey
    userRepo.getByProvId(provider, key).flatMap(elem => {
      elem match {
        case Some(user) => {
          val us = userRepo.list(user.id)
          us.map(user => Ok(Json.toJson(user)))
        }
        case None => Future.successful(Ok(Json.toJson("{status: \"success\"}")))
      }
    })
  }
}
