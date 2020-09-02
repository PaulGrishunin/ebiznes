// @GENERATOR:play-routes-compiler
// @SOURCE:/home/paul/ebiznes/conf/routes
// @DATE:Thu Sep 03 01:38:28 MSK 2020

package router

import play.core.routing._
import play.core.routing.HandlerInvokerFactory._

import play.api.mvc._

import _root_.controllers.Assets.Asset
import _root_.utils.route.Binders._

class Routes(
  override val errorHandler: play.api.http.HttpErrorHandler, 
  // @LINE:6
  ApplicationController_12: controllers.ApplicationController,
  // @LINE:8
  SocialAuthController_0: controllers.SocialAuthController,
  // @LINE:10
  SignUpController_14: controllers.SignUpController,
  // @LINE:13
  SignInController_1: controllers.SignInController,
  // @LINE:16
  TotpController_2: controllers.TotpController,
  // @LINE:22
  TotpRecoveryController_10: controllers.TotpRecoveryController,
  // @LINE:25
  ForgotPasswordController_6: controllers.ForgotPasswordController,
  // @LINE:27
  ResetPasswordController_8: controllers.ResetPasswordController,
  // @LINE:29
  ChangePasswordController_3: controllers.ChangePasswordController,
  // @LINE:32
  ActivateAccountController_16: controllers.ActivateAccountController,
  // @LINE:40
  ProductController_17: controllers.ProductController,
  // @LINE:54
  CategoryController_13: controllers.CategoryController,
  // @LINE:67
  UserController_18: controllers.UserController,
  // @LINE:79
  OrderController_4: controllers.OrderController,
  // @LINE:92
  BasketController_9: controllers.BasketController,
  // @LINE:103
  PaymentController_15: controllers.PaymentController,
  // @LINE:116
  FavoritesController_11: controllers.FavoritesController,
  // @LINE:129
  DiscountController_20: controllers.DiscountController,
  // @LINE:142
  DeliveryController_5: controllers.DeliveryController,
  // @LINE:155
  ReviewController_7: controllers.ReviewController,
  // @LINE:167
  Assets_19: controllers.Assets,
  val prefix: String
) extends GeneratedRouter {

   @javax.inject.Inject()
   def this(errorHandler: play.api.http.HttpErrorHandler,
    // @LINE:6
    ApplicationController_12: controllers.ApplicationController,
    // @LINE:8
    SocialAuthController_0: controllers.SocialAuthController,
    // @LINE:10
    SignUpController_14: controllers.SignUpController,
    // @LINE:13
    SignInController_1: controllers.SignInController,
    // @LINE:16
    TotpController_2: controllers.TotpController,
    // @LINE:22
    TotpRecoveryController_10: controllers.TotpRecoveryController,
    // @LINE:25
    ForgotPasswordController_6: controllers.ForgotPasswordController,
    // @LINE:27
    ResetPasswordController_8: controllers.ResetPasswordController,
    // @LINE:29
    ChangePasswordController_3: controllers.ChangePasswordController,
    // @LINE:32
    ActivateAccountController_16: controllers.ActivateAccountController,
    // @LINE:40
    ProductController_17: controllers.ProductController,
    // @LINE:54
    CategoryController_13: controllers.CategoryController,
    // @LINE:67
    UserController_18: controllers.UserController,
    // @LINE:79
    OrderController_4: controllers.OrderController,
    // @LINE:92
    BasketController_9: controllers.BasketController,
    // @LINE:103
    PaymentController_15: controllers.PaymentController,
    // @LINE:116
    FavoritesController_11: controllers.FavoritesController,
    // @LINE:129
    DiscountController_20: controllers.DiscountController,
    // @LINE:142
    DeliveryController_5: controllers.DeliveryController,
    // @LINE:155
    ReviewController_7: controllers.ReviewController,
    // @LINE:167
    Assets_19: controllers.Assets
  ) = this(errorHandler, ApplicationController_12, SocialAuthController_0, SignUpController_14, SignInController_1, TotpController_2, TotpRecoveryController_10, ForgotPasswordController_6, ResetPasswordController_8, ChangePasswordController_3, ActivateAccountController_16, ProductController_17, CategoryController_13, UserController_18, OrderController_4, BasketController_9, PaymentController_15, FavoritesController_11, DiscountController_20, DeliveryController_5, ReviewController_7, Assets_19, "/")

  def withPrefix(addPrefix: String): Routes = {
    val prefix = play.api.routing.Router.concatPrefix(addPrefix, this.prefix)
    router.RoutesPrefix.setPrefix(prefix)
    new Routes(errorHandler, ApplicationController_12, SocialAuthController_0, SignUpController_14, SignInController_1, TotpController_2, TotpRecoveryController_10, ForgotPasswordController_6, ResetPasswordController_8, ChangePasswordController_3, ActivateAccountController_16, ProductController_17, CategoryController_13, UserController_18, OrderController_4, BasketController_9, PaymentController_15, FavoritesController_11, DiscountController_20, DeliveryController_5, ReviewController_7, Assets_19, prefix)
  }

  private[this] val defaultPrefix: String = {
    if (this.prefix.endsWith("/")) "" else "/"
  }

  def documentation = List(
    ("""GET""", this.prefix, """controllers.ApplicationController.index"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """signOut""", """controllers.ApplicationController.signOut"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """authenticate/""" + "$" + """provider<[^/]+>""", """controllers.SocialAuthController.authenticate(provider:String)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """signUp""", """controllers.SignUpController.view"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """signUp""", """controllers.SignUpController.submit"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """signIn""", """controllers.SignInController.view"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """signIn""", """controllers.SignInController.submit"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """totp""", """controllers.TotpController.view(userId:java.util.UUID, sharedKey:String, rememberMe:Boolean)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """enableTotp""", """controllers.TotpController.enableTotp"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """disableTotp""", """controllers.TotpController.disableTotp"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """totpSubmit""", """controllers.TotpController.submit"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """enableTotpSubmit""", """controllers.TotpController.enableTotpSubmit"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """totpRecovery""", """controllers.TotpRecoveryController.view(userID:java.util.UUID, sharedKey:String, rememberMe:Boolean)"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """totpRecoverySubmit""", """controllers.TotpRecoveryController.submit"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """password/forgot""", """controllers.ForgotPasswordController.view"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """password/forgot""", """controllers.ForgotPasswordController.submit"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """password/reset/""" + "$" + """token<[^/]+>""", """controllers.ResetPasswordController.view(token:java.util.UUID)"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """password/reset/""" + "$" + """token<[^/]+>""", """controllers.ResetPasswordController.submit(token:java.util.UUID)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """password/change""", """controllers.ChangePasswordController.view"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """password/change""", """controllers.ChangePasswordController.submit"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """account/email/""" + "$" + """email<[^/]+>""", """controllers.ActivateAccountController.send(email:String)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """account/activate/""" + "$" + """token<[^/]+>""", """controllers.ActivateAccountController.activate(token:java.util.UUID)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """registred""", """controllers.ApplicationController.registred"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """addproduct""", """controllers.ProductController.addProduct"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """addproducthandle""", """controllers.ProductController.addProductHandle"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """updateproduct/""" + "$" + """id<[^/]+>""", """controllers.ProductController.updateProduct(id:Long)"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """updateproducthandle""", """controllers.ProductController.updateProductHandle"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """products""", """controllers.ProductController.getProducts"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """products/""" + "$" + """category<[^/]+>""", """controllers.ProductController.getProductsByCat(category:Int)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """product/""" + "$" + """id<[^/]+>""", """controllers.ProductController.getProduct(id:Long)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """delete/""" + "$" + """id<[^/]+>""", """controllers.ProductController.delete(id:Long)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """addcategory""", """controllers.CategoryController.addCategory"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """addcategory""", """controllers.CategoryController.addCategoryHandle"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """updatecategory/""" + "$" + """id<[^/]+>""", """controllers.CategoryController.updateCategory(id:Int)"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """updatecategoryhandle""", """controllers.CategoryController.updateCategoryHandle"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """category/""" + "$" + """id<[^/]+>""", """controllers.CategoryController.getCategory(id:Int)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """categories""", """controllers.CategoryController.getCategories"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """deletecategory/""" + "$" + """id<[^/]+>""", """controllers.CategoryController.deleteCategory(id:Int)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """adduser""", """controllers.UserController.addUser"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """adduserhandle""", """controllers.UserController.addUserHandle"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """updateuser/""" + "$" + """id<[^/]+>""", """controllers.UserController.updateUser(id:Long)"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """updateuserhandle""", """controllers.UserController.updateUserHandle"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """user""", """controllers.ApplicationController.getUser"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """deleteuser/""" + "$" + """id<[^/]+>""", """controllers.UserController.deleteUser(id:Long)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """addorder""", """controllers.OrderController.addOrder"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """addorderhandle""", """controllers.OrderController.addOrderHandle"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """updateorder/""" + "$" + """id<[^/]+>""", """controllers.OrderController.updateOrder(id:Long)"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """updateorderhandle""", """controllers.OrderController.updateOrderHandle"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """orders""", """controllers.OrderController.getOrders"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """order/""" + "$" + """id<[^/]+>""", """controllers.OrderController.getOrder(id:Long)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """ordersusr/""" + "$" + """userid<[^/]+>""", """controllers.OrderController.getOrdersUsr(userid:Long)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """deleteorder/""" + "$" + """id<[^/]+>""", """controllers.OrderController.deleteOrder(id:Long)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """addtobasket/""" + "$" + """id<[^/]+>""", """controllers.BasketController.addToBasket(id:Long)"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """addtobaskethandle""", """controllers.ApplicationController.addToBasketHandle"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """updatebasket/""" + "$" + """id<[^/]+>""", """controllers.BasketController.updateBasket(id:Long)"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """updatebaskethandle""", """controllers.BasketController.updateBasketHandle"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """basket""", """controllers.ApplicationController.basketContent"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """deletefrombasket/""" + "$" + """id<[^/]+>""", """controllers.BasketController.deleteFromBasket(id:Long)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """addpayment""", """controllers.PaymentController.addPayment"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """addpaymenthandle""", """controllers.PaymentController.addPaymentHandle"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """updatepayment/""" + "$" + """id<[^/]+>""", """controllers.PaymentController.updatePayment(id:Long)"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """updatepaymenthandle""", """controllers.PaymentController.updatePaymentHandle"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """payment/""" + "$" + """id<[^/]+>""", """controllers.PaymentController.getPayment(id:Long)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """payments""", """controllers.PaymentController.getPayments"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """paymentord/""" + "$" + """id<[^/]+>""", """controllers.PaymentController.getPaymentOrd(id:Long)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """deletepayment/""" + "$" + """id<[^/]+>""", """controllers.PaymentController.deletePayment(id:Long)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """addfavorites""", """controllers.FavoritesController.addFavorites"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """addfavoriteshandle""", """controllers.ApplicationController.addFavoritesHandle"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """updatefavoriteshandle""", """controllers.FavoritesController.updateFavoritesHandle"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """favorites""", """controllers.ApplicationController.favoritesContent"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """favorit/""" + "$" + """id<[^/]+>""", """controllers.FavoritesController.getFavorit(id:Int)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """favoritesusr/""" + "$" + """userid<[^/]+>""", """controllers.FavoritesController.getFavoritesUsr(userid:Long)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """deletefavorites/""" + "$" + """productid<[^/]+>""", """controllers.FavoritesController.deleteFavorites(productid:Long)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """adddiscount/""" + "$" + """product_id<[^/]+>""", """controllers.DiscountController.addDiscount(product_id:Long)"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """adddiscounthandle""", """controllers.DiscountController.addDiscountHandle"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """updatediscount/""" + "$" + """id<[^/]+>""", """controllers.DiscountController.updateDiscount(id:Long)"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """updatediscounthandle""", """controllers.DiscountController.updateDiscountHandle"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """discounts""", """controllers.DiscountController.getDiscounts"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """discountpr/""" + "$" + """id<[^/]+>""", """controllers.DiscountController.getDiscountpr(id:Long)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """discount/""" + "$" + """id<[^/]+>""", """controllers.DiscountController.getDiscount(id:Long)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """deletediscount/""" + "$" + """id<[^/]+>""", """controllers.DiscountController.deleteDiscount(id:Long)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """adddelivery""", """controllers.DeliveryController.addDelivery"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """adddeliveryhandle""", """controllers.DeliveryController.addDeliveryHandle"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """updatedelivery/""" + "$" + """id<[^/]+>""", """controllers.DeliveryController.updateDelivery(id:Long)"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """updatedeliveryhandle""", """controllers.DeliveryController.updateDeliveryHandle"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """deliverys""", """controllers.DeliveryController.getDeliverys"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """delivery/""" + "$" + """id<[^/]+>""", """controllers.DeliveryController.getDelivery(id:Long)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """deliveryord/""" + "$" + """id<[^/]+>""", """controllers.DeliveryController.getDeliveryOrd(id:Long)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """deletedelivery/""" + "$" + """id<[^/]+>""", """controllers.DeliveryController.deleteDelivery(id:Long)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """addreview""", """controllers.ReviewController.addReview"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """addreviewhandle""", """controllers.ApplicationController.addReviewHandle"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """updatereview/""" + "$" + """id<[^/]+>""", """controllers.ReviewController.updateReview(id:Int)"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """updatereviewhandle""", """controllers.ReviewController.updateReviewHandle"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """review/""" + "$" + """productid<[^/]+>""", """controllers.ReviewController.review(productid:Long)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """deletereview/""" + "$" + """id<[^/]+>""", """controllers.ReviewController.deleteReview(id:Int)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """assets/""" + "$" + """file<.+>""", """controllers.Assets.versioned(file:String)"""),
    Nil
  ).foldLeft(List.empty[(String,String,String)]) { (s,e) => e.asInstanceOf[Any] match {
    case r @ (_,_,_) => s :+ r.asInstanceOf[(String,String,String)]
    case l => s ++ l.asInstanceOf[List[(String,String,String)]]
  }}


  // @LINE:6
  private[this] lazy val controllers_ApplicationController_index0_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix)))
  )
  private[this] lazy val controllers_ApplicationController_index0_invoker = createInvoker(
    ApplicationController_12.index,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.ApplicationController",
      "index",
      Nil,
      "GET",
      this.prefix + """""",
      """ Home page""",
      Seq()
    )
  )

  // @LINE:7
  private[this] lazy val controllers_ApplicationController_signOut1_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("signOut")))
  )
  private[this] lazy val controllers_ApplicationController_signOut1_invoker = createInvoker(
    ApplicationController_12.signOut,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.ApplicationController",
      "signOut",
      Nil,
      "GET",
      this.prefix + """signOut""",
      """""",
      Seq()
    )
  )

  // @LINE:8
  private[this] lazy val controllers_SocialAuthController_authenticate2_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("authenticate/"), DynamicPart("provider", """[^/]+""",true)))
  )
  private[this] lazy val controllers_SocialAuthController_authenticate2_invoker = createInvoker(
    SocialAuthController_0.authenticate(fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.SocialAuthController",
      "authenticate",
      Seq(classOf[String]),
      "GET",
      this.prefix + """authenticate/""" + "$" + """provider<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:10
  private[this] lazy val controllers_SignUpController_view3_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("signUp")))
  )
  private[this] lazy val controllers_SignUpController_view3_invoker = createInvoker(
    SignUpController_14.view,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.SignUpController",
      "view",
      Nil,
      "GET",
      this.prefix + """signUp""",
      """""",
      Seq()
    )
  )

  // @LINE:11
  private[this] lazy val controllers_SignUpController_submit4_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("signUp")))
  )
  private[this] lazy val controllers_SignUpController_submit4_invoker = createInvoker(
    SignUpController_14.submit,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.SignUpController",
      "submit",
      Nil,
      "POST",
      this.prefix + """signUp""",
      """""",
      Seq()
    )
  )

  // @LINE:13
  private[this] lazy val controllers_SignInController_view5_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("signIn")))
  )
  private[this] lazy val controllers_SignInController_view5_invoker = createInvoker(
    SignInController_1.view,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.SignInController",
      "view",
      Nil,
      "GET",
      this.prefix + """signIn""",
      """""",
      Seq()
    )
  )

  // @LINE:14
  private[this] lazy val controllers_SignInController_submit6_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("signIn")))
  )
  private[this] lazy val controllers_SignInController_submit6_invoker = createInvoker(
    SignInController_1.submit,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.SignInController",
      "submit",
      Nil,
      "POST",
      this.prefix + """signIn""",
      """""",
      Seq()
    )
  )

  // @LINE:16
  private[this] lazy val controllers_TotpController_view7_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("totp")))
  )
  private[this] lazy val controllers_TotpController_view7_invoker = createInvoker(
    TotpController_2.view(fakeValue[java.util.UUID], fakeValue[String], fakeValue[Boolean]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.TotpController",
      "view",
      Seq(classOf[java.util.UUID], classOf[String], classOf[Boolean]),
      "GET",
      this.prefix + """totp""",
      """""",
      Seq()
    )
  )

  // @LINE:17
  private[this] lazy val controllers_TotpController_enableTotp8_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("enableTotp")))
  )
  private[this] lazy val controllers_TotpController_enableTotp8_invoker = createInvoker(
    TotpController_2.enableTotp,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.TotpController",
      "enableTotp",
      Nil,
      "GET",
      this.prefix + """enableTotp""",
      """""",
      Seq()
    )
  )

  // @LINE:18
  private[this] lazy val controllers_TotpController_disableTotp9_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("disableTotp")))
  )
  private[this] lazy val controllers_TotpController_disableTotp9_invoker = createInvoker(
    TotpController_2.disableTotp,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.TotpController",
      "disableTotp",
      Nil,
      "GET",
      this.prefix + """disableTotp""",
      """""",
      Seq()
    )
  )

  // @LINE:19
  private[this] lazy val controllers_TotpController_submit10_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("totpSubmit")))
  )
  private[this] lazy val controllers_TotpController_submit10_invoker = createInvoker(
    TotpController_2.submit,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.TotpController",
      "submit",
      Nil,
      "POST",
      this.prefix + """totpSubmit""",
      """""",
      Seq()
    )
  )

  // @LINE:20
  private[this] lazy val controllers_TotpController_enableTotpSubmit11_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("enableTotpSubmit")))
  )
  private[this] lazy val controllers_TotpController_enableTotpSubmit11_invoker = createInvoker(
    TotpController_2.enableTotpSubmit,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.TotpController",
      "enableTotpSubmit",
      Nil,
      "POST",
      this.prefix + """enableTotpSubmit""",
      """""",
      Seq()
    )
  )

  // @LINE:22
  private[this] lazy val controllers_TotpRecoveryController_view12_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("totpRecovery")))
  )
  private[this] lazy val controllers_TotpRecoveryController_view12_invoker = createInvoker(
    TotpRecoveryController_10.view(fakeValue[java.util.UUID], fakeValue[String], fakeValue[Boolean]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.TotpRecoveryController",
      "view",
      Seq(classOf[java.util.UUID], classOf[String], classOf[Boolean]),
      "GET",
      this.prefix + """totpRecovery""",
      """""",
      Seq()
    )
  )

  // @LINE:23
  private[this] lazy val controllers_TotpRecoveryController_submit13_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("totpRecoverySubmit")))
  )
  private[this] lazy val controllers_TotpRecoveryController_submit13_invoker = createInvoker(
    TotpRecoveryController_10.submit,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.TotpRecoveryController",
      "submit",
      Nil,
      "POST",
      this.prefix + """totpRecoverySubmit""",
      """""",
      Seq()
    )
  )

  // @LINE:25
  private[this] lazy val controllers_ForgotPasswordController_view14_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("password/forgot")))
  )
  private[this] lazy val controllers_ForgotPasswordController_view14_invoker = createInvoker(
    ForgotPasswordController_6.view,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.ForgotPasswordController",
      "view",
      Nil,
      "GET",
      this.prefix + """password/forgot""",
      """""",
      Seq()
    )
  )

  // @LINE:26
  private[this] lazy val controllers_ForgotPasswordController_submit15_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("password/forgot")))
  )
  private[this] lazy val controllers_ForgotPasswordController_submit15_invoker = createInvoker(
    ForgotPasswordController_6.submit,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.ForgotPasswordController",
      "submit",
      Nil,
      "POST",
      this.prefix + """password/forgot""",
      """""",
      Seq()
    )
  )

  // @LINE:27
  private[this] lazy val controllers_ResetPasswordController_view16_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("password/reset/"), DynamicPart("token", """[^/]+""",true)))
  )
  private[this] lazy val controllers_ResetPasswordController_view16_invoker = createInvoker(
    ResetPasswordController_8.view(fakeValue[java.util.UUID]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.ResetPasswordController",
      "view",
      Seq(classOf[java.util.UUID]),
      "GET",
      this.prefix + """password/reset/""" + "$" + """token<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:28
  private[this] lazy val controllers_ResetPasswordController_submit17_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("password/reset/"), DynamicPart("token", """[^/]+""",true)))
  )
  private[this] lazy val controllers_ResetPasswordController_submit17_invoker = createInvoker(
    ResetPasswordController_8.submit(fakeValue[java.util.UUID]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.ResetPasswordController",
      "submit",
      Seq(classOf[java.util.UUID]),
      "POST",
      this.prefix + """password/reset/""" + "$" + """token<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:29
  private[this] lazy val controllers_ChangePasswordController_view18_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("password/change")))
  )
  private[this] lazy val controllers_ChangePasswordController_view18_invoker = createInvoker(
    ChangePasswordController_3.view,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.ChangePasswordController",
      "view",
      Nil,
      "GET",
      this.prefix + """password/change""",
      """""",
      Seq()
    )
  )

  // @LINE:30
  private[this] lazy val controllers_ChangePasswordController_submit19_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("password/change")))
  )
  private[this] lazy val controllers_ChangePasswordController_submit19_invoker = createInvoker(
    ChangePasswordController_3.submit,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.ChangePasswordController",
      "submit",
      Nil,
      "POST",
      this.prefix + """password/change""",
      """""",
      Seq()
    )
  )

  // @LINE:32
  private[this] lazy val controllers_ActivateAccountController_send20_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("account/email/"), DynamicPart("email", """[^/]+""",true)))
  )
  private[this] lazy val controllers_ActivateAccountController_send20_invoker = createInvoker(
    ActivateAccountController_16.send(fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.ActivateAccountController",
      "send",
      Seq(classOf[String]),
      "GET",
      this.prefix + """account/email/""" + "$" + """email<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:33
  private[this] lazy val controllers_ActivateAccountController_activate21_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("account/activate/"), DynamicPart("token", """[^/]+""",true)))
  )
  private[this] lazy val controllers_ActivateAccountController_activate21_invoker = createInvoker(
    ActivateAccountController_16.activate(fakeValue[java.util.UUID]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.ActivateAccountController",
      "activate",
      Seq(classOf[java.util.UUID]),
      "GET",
      this.prefix + """account/activate/""" + "$" + """token<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:35
  private[this] lazy val controllers_ApplicationController_registred22_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("registred")))
  )
  private[this] lazy val controllers_ApplicationController_registred22_invoker = createInvoker(
    ApplicationController_12.registred,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.ApplicationController",
      "registred",
      Nil,
      "GET",
      this.prefix + """registred""",
      """""",
      Seq()
    )
  )

  // @LINE:40
  private[this] lazy val controllers_ProductController_addProduct23_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("addproduct")))
  )
  private[this] lazy val controllers_ProductController_addProduct23_invoker = createInvoker(
    ProductController_17.addProduct,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.ProductController",
      "addProduct",
      Nil,
      "GET",
      this.prefix + """addproduct""",
      """GET     /                           controllers.ProductController.index""",
      Seq()
    )
  )

  // @LINE:42
  private[this] lazy val controllers_ProductController_addProductHandle24_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("addproducthandle")))
  )
  private[this] lazy val controllers_ProductController_addProductHandle24_invoker = createInvoker(
    ProductController_17.addProductHandle,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.ProductController",
      "addProductHandle",
      Nil,
      "POST",
      this.prefix + """addproducthandle""",
      """""",
      Seq("""nocsrf""")
    )
  )

  // @LINE:43
  private[this] lazy val controllers_ProductController_updateProduct25_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("updateproduct/"), DynamicPart("id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_ProductController_updateProduct25_invoker = createInvoker(
    ProductController_17.updateProduct(fakeValue[Long]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.ProductController",
      "updateProduct",
      Seq(classOf[Long]),
      "GET",
      this.prefix + """updateproduct/""" + "$" + """id<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:45
  private[this] lazy val controllers_ProductController_updateProductHandle26_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("updateproducthandle")))
  )
  private[this] lazy val controllers_ProductController_updateProductHandle26_invoker = createInvoker(
    ProductController_17.updateProductHandle,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.ProductController",
      "updateProductHandle",
      Nil,
      "POST",
      this.prefix + """updateproducthandle""",
      """""",
      Seq("""nocsrf""")
    )
  )

  // @LINE:47
  private[this] lazy val controllers_ProductController_getProducts27_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("products")))
  )
  private[this] lazy val controllers_ProductController_getProducts27_invoker = createInvoker(
    ProductController_17.getProducts,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.ProductController",
      "getProducts",
      Nil,
      "GET",
      this.prefix + """products""",
      """""",
      Seq()
    )
  )

  // @LINE:48
  private[this] lazy val controllers_ProductController_getProductsByCat28_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("products/"), DynamicPart("category", """[^/]+""",true)))
  )
  private[this] lazy val controllers_ProductController_getProductsByCat28_invoker = createInvoker(
    ProductController_17.getProductsByCat(fakeValue[Int]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.ProductController",
      "getProductsByCat",
      Seq(classOf[Int]),
      "GET",
      this.prefix + """products/""" + "$" + """category<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:49
  private[this] lazy val controllers_ProductController_getProduct29_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("product/"), DynamicPart("id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_ProductController_getProduct29_invoker = createInvoker(
    ProductController_17.getProduct(fakeValue[Long]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.ProductController",
      "getProduct",
      Seq(classOf[Long]),
      "GET",
      this.prefix + """product/""" + "$" + """id<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:50
  private[this] lazy val controllers_ProductController_delete30_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("delete/"), DynamicPart("id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_ProductController_delete30_invoker = createInvoker(
    ProductController_17.delete(fakeValue[Long]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.ProductController",
      "delete",
      Seq(classOf[Long]),
      "GET",
      this.prefix + """delete/""" + "$" + """id<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:54
  private[this] lazy val controllers_CategoryController_addCategory31_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("addcategory")))
  )
  private[this] lazy val controllers_CategoryController_addCategory31_invoker = createInvoker(
    CategoryController_13.addCategory,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.CategoryController",
      "addCategory",
      Nil,
      "GET",
      this.prefix + """addcategory""",
      """category""",
      Seq()
    )
  )

  // @LINE:56
  private[this] lazy val controllers_CategoryController_addCategoryHandle32_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("addcategory")))
  )
  private[this] lazy val controllers_CategoryController_addCategoryHandle32_invoker = createInvoker(
    CategoryController_13.addCategoryHandle,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.CategoryController",
      "addCategoryHandle",
      Nil,
      "POST",
      this.prefix + """addcategory""",
      """""",
      Seq("""nocsrf""")
    )
  )

  // @LINE:57
  private[this] lazy val controllers_CategoryController_updateCategory33_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("updatecategory/"), DynamicPart("id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_CategoryController_updateCategory33_invoker = createInvoker(
    CategoryController_13.updateCategory(fakeValue[Int]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.CategoryController",
      "updateCategory",
      Seq(classOf[Int]),
      "GET",
      this.prefix + """updatecategory/""" + "$" + """id<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:59
  private[this] lazy val controllers_CategoryController_updateCategoryHandle34_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("updatecategoryhandle")))
  )
  private[this] lazy val controllers_CategoryController_updateCategoryHandle34_invoker = createInvoker(
    CategoryController_13.updateCategoryHandle,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.CategoryController",
      "updateCategoryHandle",
      Nil,
      "POST",
      this.prefix + """updatecategoryhandle""",
      """""",
      Seq("""nocsrf""")
    )
  )

  // @LINE:61
  private[this] lazy val controllers_CategoryController_getCategory35_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("category/"), DynamicPart("id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_CategoryController_getCategory35_invoker = createInvoker(
    CategoryController_13.getCategory(fakeValue[Int]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.CategoryController",
      "getCategory",
      Seq(classOf[Int]),
      "GET",
      this.prefix + """category/""" + "$" + """id<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:62
  private[this] lazy val controllers_CategoryController_getCategories36_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("categories")))
  )
  private[this] lazy val controllers_CategoryController_getCategories36_invoker = createInvoker(
    CategoryController_13.getCategories,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.CategoryController",
      "getCategories",
      Nil,
      "GET",
      this.prefix + """categories""",
      """""",
      Seq()
    )
  )

  // @LINE:63
  private[this] lazy val controllers_CategoryController_deleteCategory37_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("deletecategory/"), DynamicPart("id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_CategoryController_deleteCategory37_invoker = createInvoker(
    CategoryController_13.deleteCategory(fakeValue[Int]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.CategoryController",
      "deleteCategory",
      Seq(classOf[Int]),
      "GET",
      this.prefix + """deletecategory/""" + "$" + """id<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:67
  private[this] lazy val controllers_UserController_addUser38_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("adduser")))
  )
  private[this] lazy val controllers_UserController_addUser38_invoker = createInvoker(
    UserController_18.addUser,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.UserController",
      "addUser",
      Nil,
      "GET",
      this.prefix + """adduser""",
      """user""",
      Seq()
    )
  )

  // @LINE:69
  private[this] lazy val controllers_UserController_addUserHandle39_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("adduserhandle")))
  )
  private[this] lazy val controllers_UserController_addUserHandle39_invoker = createInvoker(
    UserController_18.addUserHandle,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.UserController",
      "addUserHandle",
      Nil,
      "POST",
      this.prefix + """adduserhandle""",
      """""",
      Seq("""nocsrf""")
    )
  )

  // @LINE:70
  private[this] lazy val controllers_UserController_updateUser40_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("updateuser/"), DynamicPart("id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_UserController_updateUser40_invoker = createInvoker(
    UserController_18.updateUser(fakeValue[Long]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.UserController",
      "updateUser",
      Seq(classOf[Long]),
      "GET",
      this.prefix + """updateuser/""" + "$" + """id<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:72
  private[this] lazy val controllers_UserController_updateUserHandle41_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("updateuserhandle")))
  )
  private[this] lazy val controllers_UserController_updateUserHandle41_invoker = createInvoker(
    UserController_18.updateUserHandle,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.UserController",
      "updateUserHandle",
      Nil,
      "POST",
      this.prefix + """updateuserhandle""",
      """""",
      Seq("""nocsrf""")
    )
  )

  // @LINE:74
  private[this] lazy val controllers_ApplicationController_getUser42_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("user")))
  )
  private[this] lazy val controllers_ApplicationController_getUser42_invoker = createInvoker(
    ApplicationController_12.getUser,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.ApplicationController",
      "getUser",
      Nil,
      "GET",
      this.prefix + """user""",
      """""",
      Seq()
    )
  )

  // @LINE:76
  private[this] lazy val controllers_UserController_deleteUser43_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("deleteuser/"), DynamicPart("id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_UserController_deleteUser43_invoker = createInvoker(
    UserController_18.deleteUser(fakeValue[Long]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.UserController",
      "deleteUser",
      Seq(classOf[Long]),
      "GET",
      this.prefix + """deleteuser/""" + "$" + """id<[^/]+>""",
      """GET     /users                    controllers.UserController.getUsers""",
      Seq()
    )
  )

  // @LINE:79
  private[this] lazy val controllers_OrderController_addOrder44_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("addorder")))
  )
  private[this] lazy val controllers_OrderController_addOrder44_invoker = createInvoker(
    OrderController_4.addOrder,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.OrderController",
      "addOrder",
      Nil,
      "GET",
      this.prefix + """addorder""",
      """order""",
      Seq()
    )
  )

  // @LINE:81
  private[this] lazy val controllers_OrderController_addOrderHandle45_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("addorderhandle")))
  )
  private[this] lazy val controllers_OrderController_addOrderHandle45_invoker = createInvoker(
    OrderController_4.addOrderHandle,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.OrderController",
      "addOrderHandle",
      Nil,
      "POST",
      this.prefix + """addorderhandle""",
      """""",
      Seq("""nocsrf""")
    )
  )

  // @LINE:82
  private[this] lazy val controllers_OrderController_updateOrder46_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("updateorder/"), DynamicPart("id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_OrderController_updateOrder46_invoker = createInvoker(
    OrderController_4.updateOrder(fakeValue[Long]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.OrderController",
      "updateOrder",
      Seq(classOf[Long]),
      "GET",
      this.prefix + """updateorder/""" + "$" + """id<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:84
  private[this] lazy val controllers_OrderController_updateOrderHandle47_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("updateorderhandle")))
  )
  private[this] lazy val controllers_OrderController_updateOrderHandle47_invoker = createInvoker(
    OrderController_4.updateOrderHandle,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.OrderController",
      "updateOrderHandle",
      Nil,
      "POST",
      this.prefix + """updateorderhandle""",
      """""",
      Seq("""nocsrf""")
    )
  )

  // @LINE:86
  private[this] lazy val controllers_OrderController_getOrders48_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("orders")))
  )
  private[this] lazy val controllers_OrderController_getOrders48_invoker = createInvoker(
    OrderController_4.getOrders,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.OrderController",
      "getOrders",
      Nil,
      "GET",
      this.prefix + """orders""",
      """""",
      Seq()
    )
  )

  // @LINE:87
  private[this] lazy val controllers_OrderController_getOrder49_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("order/"), DynamicPart("id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_OrderController_getOrder49_invoker = createInvoker(
    OrderController_4.getOrder(fakeValue[Long]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.OrderController",
      "getOrder",
      Seq(classOf[Long]),
      "GET",
      this.prefix + """order/""" + "$" + """id<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:88
  private[this] lazy val controllers_OrderController_getOrdersUsr50_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("ordersusr/"), DynamicPart("userid", """[^/]+""",true)))
  )
  private[this] lazy val controllers_OrderController_getOrdersUsr50_invoker = createInvoker(
    OrderController_4.getOrdersUsr(fakeValue[Long]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.OrderController",
      "getOrdersUsr",
      Seq(classOf[Long]),
      "GET",
      this.prefix + """ordersusr/""" + "$" + """userid<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:89
  private[this] lazy val controllers_OrderController_deleteOrder51_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("deleteorder/"), DynamicPart("id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_OrderController_deleteOrder51_invoker = createInvoker(
    OrderController_4.deleteOrder(fakeValue[Long]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.OrderController",
      "deleteOrder",
      Seq(classOf[Long]),
      "GET",
      this.prefix + """deleteorder/""" + "$" + """id<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:92
  private[this] lazy val controllers_BasketController_addToBasket52_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("addtobasket/"), DynamicPart("id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_BasketController_addToBasket52_invoker = createInvoker(
    BasketController_9.addToBasket(fakeValue[Long]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.BasketController",
      "addToBasket",
      Seq(classOf[Long]),
      "GET",
      this.prefix + """addtobasket/""" + "$" + """id<[^/]+>""",
      """basket""",
      Seq()
    )
  )

  // @LINE:94
  private[this] lazy val controllers_ApplicationController_addToBasketHandle53_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("addtobaskethandle")))
  )
  private[this] lazy val controllers_ApplicationController_addToBasketHandle53_invoker = createInvoker(
    ApplicationController_12.addToBasketHandle,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.ApplicationController",
      "addToBasketHandle",
      Nil,
      "POST",
      this.prefix + """addtobaskethandle""",
      """""",
      Seq("""nocsrf""")
    )
  )

  // @LINE:95
  private[this] lazy val controllers_BasketController_updateBasket54_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("updatebasket/"), DynamicPart("id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_BasketController_updateBasket54_invoker = createInvoker(
    BasketController_9.updateBasket(fakeValue[Long]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.BasketController",
      "updateBasket",
      Seq(classOf[Long]),
      "GET",
      this.prefix + """updatebasket/""" + "$" + """id<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:97
  private[this] lazy val controllers_BasketController_updateBasketHandle55_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("updatebaskethandle")))
  )
  private[this] lazy val controllers_BasketController_updateBasketHandle55_invoker = createInvoker(
    BasketController_9.updateBasketHandle,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.BasketController",
      "updateBasketHandle",
      Nil,
      "POST",
      this.prefix + """updatebaskethandle""",
      """""",
      Seq("""nocsrf""")
    )
  )

  // @LINE:99
  private[this] lazy val controllers_ApplicationController_basketContent56_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("basket")))
  )
  private[this] lazy val controllers_ApplicationController_basketContent56_invoker = createInvoker(
    ApplicationController_12.basketContent,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.ApplicationController",
      "basketContent",
      Nil,
      "GET",
      this.prefix + """basket""",
      """""",
      Seq()
    )
  )

  // @LINE:100
  private[this] lazy val controllers_BasketController_deleteFromBasket57_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("deletefrombasket/"), DynamicPart("id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_BasketController_deleteFromBasket57_invoker = createInvoker(
    BasketController_9.deleteFromBasket(fakeValue[Long]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.BasketController",
      "deleteFromBasket",
      Seq(classOf[Long]),
      "GET",
      this.prefix + """deletefrombasket/""" + "$" + """id<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:103
  private[this] lazy val controllers_PaymentController_addPayment58_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("addpayment")))
  )
  private[this] lazy val controllers_PaymentController_addPayment58_invoker = createInvoker(
    PaymentController_15.addPayment,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.PaymentController",
      "addPayment",
      Nil,
      "GET",
      this.prefix + """addpayment""",
      """payment""",
      Seq()
    )
  )

  // @LINE:105
  private[this] lazy val controllers_PaymentController_addPaymentHandle59_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("addpaymenthandle")))
  )
  private[this] lazy val controllers_PaymentController_addPaymentHandle59_invoker = createInvoker(
    PaymentController_15.addPaymentHandle,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.PaymentController",
      "addPaymentHandle",
      Nil,
      "POST",
      this.prefix + """addpaymenthandle""",
      """""",
      Seq("""nocsrf""")
    )
  )

  // @LINE:106
  private[this] lazy val controllers_PaymentController_updatePayment60_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("updatepayment/"), DynamicPart("id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_PaymentController_updatePayment60_invoker = createInvoker(
    PaymentController_15.updatePayment(fakeValue[Long]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.PaymentController",
      "updatePayment",
      Seq(classOf[Long]),
      "GET",
      this.prefix + """updatepayment/""" + "$" + """id<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:108
  private[this] lazy val controllers_PaymentController_updatePaymentHandle61_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("updatepaymenthandle")))
  )
  private[this] lazy val controllers_PaymentController_updatePaymentHandle61_invoker = createInvoker(
    PaymentController_15.updatePaymentHandle,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.PaymentController",
      "updatePaymentHandle",
      Nil,
      "POST",
      this.prefix + """updatepaymenthandle""",
      """""",
      Seq("""nocsrf""")
    )
  )

  // @LINE:110
  private[this] lazy val controllers_PaymentController_getPayment62_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("payment/"), DynamicPart("id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_PaymentController_getPayment62_invoker = createInvoker(
    PaymentController_15.getPayment(fakeValue[Long]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.PaymentController",
      "getPayment",
      Seq(classOf[Long]),
      "GET",
      this.prefix + """payment/""" + "$" + """id<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:111
  private[this] lazy val controllers_PaymentController_getPayments63_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("payments")))
  )
  private[this] lazy val controllers_PaymentController_getPayments63_invoker = createInvoker(
    PaymentController_15.getPayments,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.PaymentController",
      "getPayments",
      Nil,
      "GET",
      this.prefix + """payments""",
      """""",
      Seq()
    )
  )

  // @LINE:112
  private[this] lazy val controllers_PaymentController_getPaymentOrd64_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("paymentord/"), DynamicPart("id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_PaymentController_getPaymentOrd64_invoker = createInvoker(
    PaymentController_15.getPaymentOrd(fakeValue[Long]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.PaymentController",
      "getPaymentOrd",
      Seq(classOf[Long]),
      "GET",
      this.prefix + """paymentord/""" + "$" + """id<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:113
  private[this] lazy val controllers_PaymentController_deletePayment65_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("deletepayment/"), DynamicPart("id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_PaymentController_deletePayment65_invoker = createInvoker(
    PaymentController_15.deletePayment(fakeValue[Long]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.PaymentController",
      "deletePayment",
      Seq(classOf[Long]),
      "GET",
      this.prefix + """deletepayment/""" + "$" + """id<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:116
  private[this] lazy val controllers_FavoritesController_addFavorites66_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("addfavorites")))
  )
  private[this] lazy val controllers_FavoritesController_addFavorites66_invoker = createInvoker(
    FavoritesController_11.addFavorites,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.FavoritesController",
      "addFavorites",
      Nil,
      "GET",
      this.prefix + """addfavorites""",
      """Favorites products""",
      Seq()
    )
  )

  // @LINE:118
  private[this] lazy val controllers_ApplicationController_addFavoritesHandle67_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("addfavoriteshandle")))
  )
  private[this] lazy val controllers_ApplicationController_addFavoritesHandle67_invoker = createInvoker(
    ApplicationController_12.addFavoritesHandle,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.ApplicationController",
      "addFavoritesHandle",
      Nil,
      "POST",
      this.prefix + """addfavoriteshandle""",
      """""",
      Seq("""nocsrf""")
    )
  )

  // @LINE:121
  private[this] lazy val controllers_FavoritesController_updateFavoritesHandle68_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("updatefavoriteshandle")))
  )
  private[this] lazy val controllers_FavoritesController_updateFavoritesHandle68_invoker = createInvoker(
    FavoritesController_11.updateFavoritesHandle,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.FavoritesController",
      "updateFavoritesHandle",
      Nil,
      "POST",
      this.prefix + """updatefavoriteshandle""",
      """GET     /updatefavorites/:id          controllers.FavoritesController.updateFavorites(id: Int)""",
      Seq("""nocsrf""")
    )
  )

  // @LINE:123
  private[this] lazy val controllers_ApplicationController_favoritesContent69_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("favorites")))
  )
  private[this] lazy val controllers_ApplicationController_favoritesContent69_invoker = createInvoker(
    ApplicationController_12.favoritesContent,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.ApplicationController",
      "favoritesContent",
      Nil,
      "GET",
      this.prefix + """favorites""",
      """""",
      Seq()
    )
  )

  // @LINE:124
  private[this] lazy val controllers_FavoritesController_getFavorit70_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("favorit/"), DynamicPart("id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_FavoritesController_getFavorit70_invoker = createInvoker(
    FavoritesController_11.getFavorit(fakeValue[Int]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.FavoritesController",
      "getFavorit",
      Seq(classOf[Int]),
      "GET",
      this.prefix + """favorit/""" + "$" + """id<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:125
  private[this] lazy val controllers_FavoritesController_getFavoritesUsr71_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("favoritesusr/"), DynamicPart("userid", """[^/]+""",true)))
  )
  private[this] lazy val controllers_FavoritesController_getFavoritesUsr71_invoker = createInvoker(
    FavoritesController_11.getFavoritesUsr(fakeValue[Long]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.FavoritesController",
      "getFavoritesUsr",
      Seq(classOf[Long]),
      "GET",
      this.prefix + """favoritesusr/""" + "$" + """userid<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:126
  private[this] lazy val controllers_FavoritesController_deleteFavorites72_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("deletefavorites/"), DynamicPart("productid", """[^/]+""",true)))
  )
  private[this] lazy val controllers_FavoritesController_deleteFavorites72_invoker = createInvoker(
    FavoritesController_11.deleteFavorites(fakeValue[Long]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.FavoritesController",
      "deleteFavorites",
      Seq(classOf[Long]),
      "GET",
      this.prefix + """deletefavorites/""" + "$" + """productid<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:129
  private[this] lazy val controllers_DiscountController_addDiscount73_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("adddiscount/"), DynamicPart("product_id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_DiscountController_addDiscount73_invoker = createInvoker(
    DiscountController_20.addDiscount(fakeValue[Long]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.DiscountController",
      "addDiscount",
      Seq(classOf[Long]),
      "GET",
      this.prefix + """adddiscount/""" + "$" + """product_id<[^/]+>""",
      """discount""",
      Seq()
    )
  )

  // @LINE:131
  private[this] lazy val controllers_DiscountController_addDiscountHandle74_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("adddiscounthandle")))
  )
  private[this] lazy val controllers_DiscountController_addDiscountHandle74_invoker = createInvoker(
    DiscountController_20.addDiscountHandle,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.DiscountController",
      "addDiscountHandle",
      Nil,
      "POST",
      this.prefix + """adddiscounthandle""",
      """""",
      Seq("""nocsrf""")
    )
  )

  // @LINE:132
  private[this] lazy val controllers_DiscountController_updateDiscount75_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("updatediscount/"), DynamicPart("id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_DiscountController_updateDiscount75_invoker = createInvoker(
    DiscountController_20.updateDiscount(fakeValue[Long]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.DiscountController",
      "updateDiscount",
      Seq(classOf[Long]),
      "GET",
      this.prefix + """updatediscount/""" + "$" + """id<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:134
  private[this] lazy val controllers_DiscountController_updateDiscountHandle76_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("updatediscounthandle")))
  )
  private[this] lazy val controllers_DiscountController_updateDiscountHandle76_invoker = createInvoker(
    DiscountController_20.updateDiscountHandle,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.DiscountController",
      "updateDiscountHandle",
      Nil,
      "POST",
      this.prefix + """updatediscounthandle""",
      """""",
      Seq("""nocsrf""")
    )
  )

  // @LINE:136
  private[this] lazy val controllers_DiscountController_getDiscounts77_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("discounts")))
  )
  private[this] lazy val controllers_DiscountController_getDiscounts77_invoker = createInvoker(
    DiscountController_20.getDiscounts,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.DiscountController",
      "getDiscounts",
      Nil,
      "GET",
      this.prefix + """discounts""",
      """""",
      Seq()
    )
  )

  // @LINE:137
  private[this] lazy val controllers_DiscountController_getDiscountpr78_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("discountpr/"), DynamicPart("id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_DiscountController_getDiscountpr78_invoker = createInvoker(
    DiscountController_20.getDiscountpr(fakeValue[Long]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.DiscountController",
      "getDiscountpr",
      Seq(classOf[Long]),
      "GET",
      this.prefix + """discountpr/""" + "$" + """id<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:138
  private[this] lazy val controllers_DiscountController_getDiscount79_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("discount/"), DynamicPart("id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_DiscountController_getDiscount79_invoker = createInvoker(
    DiscountController_20.getDiscount(fakeValue[Long]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.DiscountController",
      "getDiscount",
      Seq(classOf[Long]),
      "GET",
      this.prefix + """discount/""" + "$" + """id<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:139
  private[this] lazy val controllers_DiscountController_deleteDiscount80_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("deletediscount/"), DynamicPart("id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_DiscountController_deleteDiscount80_invoker = createInvoker(
    DiscountController_20.deleteDiscount(fakeValue[Long]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.DiscountController",
      "deleteDiscount",
      Seq(classOf[Long]),
      "GET",
      this.prefix + """deletediscount/""" + "$" + """id<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:142
  private[this] lazy val controllers_DeliveryController_addDelivery81_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("adddelivery")))
  )
  private[this] lazy val controllers_DeliveryController_addDelivery81_invoker = createInvoker(
    DeliveryController_5.addDelivery,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.DeliveryController",
      "addDelivery",
      Nil,
      "GET",
      this.prefix + """adddelivery""",
      """delivery""",
      Seq()
    )
  )

  // @LINE:144
  private[this] lazy val controllers_DeliveryController_addDeliveryHandle82_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("adddeliveryhandle")))
  )
  private[this] lazy val controllers_DeliveryController_addDeliveryHandle82_invoker = createInvoker(
    DeliveryController_5.addDeliveryHandle,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.DeliveryController",
      "addDeliveryHandle",
      Nil,
      "POST",
      this.prefix + """adddeliveryhandle""",
      """""",
      Seq("""nocsrf""")
    )
  )

  // @LINE:145
  private[this] lazy val controllers_DeliveryController_updateDelivery83_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("updatedelivery/"), DynamicPart("id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_DeliveryController_updateDelivery83_invoker = createInvoker(
    DeliveryController_5.updateDelivery(fakeValue[Long]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.DeliveryController",
      "updateDelivery",
      Seq(classOf[Long]),
      "GET",
      this.prefix + """updatedelivery/""" + "$" + """id<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:147
  private[this] lazy val controllers_DeliveryController_updateDeliveryHandle84_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("updatedeliveryhandle")))
  )
  private[this] lazy val controllers_DeliveryController_updateDeliveryHandle84_invoker = createInvoker(
    DeliveryController_5.updateDeliveryHandle,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.DeliveryController",
      "updateDeliveryHandle",
      Nil,
      "POST",
      this.prefix + """updatedeliveryhandle""",
      """""",
      Seq("""nocsrf""")
    )
  )

  // @LINE:149
  private[this] lazy val controllers_DeliveryController_getDeliverys85_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("deliverys")))
  )
  private[this] lazy val controllers_DeliveryController_getDeliverys85_invoker = createInvoker(
    DeliveryController_5.getDeliverys,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.DeliveryController",
      "getDeliverys",
      Nil,
      "GET",
      this.prefix + """deliverys""",
      """""",
      Seq()
    )
  )

  // @LINE:150
  private[this] lazy val controllers_DeliveryController_getDelivery86_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("delivery/"), DynamicPart("id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_DeliveryController_getDelivery86_invoker = createInvoker(
    DeliveryController_5.getDelivery(fakeValue[Long]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.DeliveryController",
      "getDelivery",
      Seq(classOf[Long]),
      "GET",
      this.prefix + """delivery/""" + "$" + """id<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:151
  private[this] lazy val controllers_DeliveryController_getDeliveryOrd87_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("deliveryord/"), DynamicPart("id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_DeliveryController_getDeliveryOrd87_invoker = createInvoker(
    DeliveryController_5.getDeliveryOrd(fakeValue[Long]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.DeliveryController",
      "getDeliveryOrd",
      Seq(classOf[Long]),
      "GET",
      this.prefix + """deliveryord/""" + "$" + """id<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:152
  private[this] lazy val controllers_DeliveryController_deleteDelivery88_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("deletedelivery/"), DynamicPart("id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_DeliveryController_deleteDelivery88_invoker = createInvoker(
    DeliveryController_5.deleteDelivery(fakeValue[Long]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.DeliveryController",
      "deleteDelivery",
      Seq(classOf[Long]),
      "GET",
      this.prefix + """deletedelivery/""" + "$" + """id<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:155
  private[this] lazy val controllers_ReviewController_addReview89_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("addreview")))
  )
  private[this] lazy val controllers_ReviewController_addReview89_invoker = createInvoker(
    ReviewController_7.addReview,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.ReviewController",
      "addReview",
      Nil,
      "GET",
      this.prefix + """addreview""",
      """product Review""",
      Seq()
    )
  )

  // @LINE:157
  private[this] lazy val controllers_ApplicationController_addReviewHandle90_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("addreviewhandle")))
  )
  private[this] lazy val controllers_ApplicationController_addReviewHandle90_invoker = createInvoker(
    ApplicationController_12.addReviewHandle,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.ApplicationController",
      "addReviewHandle",
      Nil,
      "POST",
      this.prefix + """addreviewhandle""",
      """""",
      Seq("""nocsrf""")
    )
  )

  // @LINE:158
  private[this] lazy val controllers_ReviewController_updateReview91_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("updatereview/"), DynamicPart("id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_ReviewController_updateReview91_invoker = createInvoker(
    ReviewController_7.updateReview(fakeValue[Int]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.ReviewController",
      "updateReview",
      Seq(classOf[Int]),
      "GET",
      this.prefix + """updatereview/""" + "$" + """id<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:160
  private[this] lazy val controllers_ReviewController_updateReviewHandle92_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("updatereviewhandle")))
  )
  private[this] lazy val controllers_ReviewController_updateReviewHandle92_invoker = createInvoker(
    ReviewController_7.updateReviewHandle,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.ReviewController",
      "updateReviewHandle",
      Nil,
      "POST",
      this.prefix + """updatereviewhandle""",
      """""",
      Seq("""nocsrf""")
    )
  )

  // @LINE:163
  private[this] lazy val controllers_ReviewController_review93_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("review/"), DynamicPart("productid", """[^/]+""",true)))
  )
  private[this] lazy val controllers_ReviewController_review93_invoker = createInvoker(
    ReviewController_7.review(fakeValue[Long]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.ReviewController",
      "review",
      Seq(classOf[Long]),
      "GET",
      this.prefix + """review/""" + "$" + """productid<[^/]+>""",
      """GET     /reviews                 controllers.ReviewController.getReviews""",
      Seq()
    )
  )

  // @LINE:164
  private[this] lazy val controllers_ReviewController_deleteReview94_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("deletereview/"), DynamicPart("id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_ReviewController_deleteReview94_invoker = createInvoker(
    ReviewController_7.deleteReview(fakeValue[Int]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.ReviewController",
      "deleteReview",
      Seq(classOf[Int]),
      "GET",
      this.prefix + """deletereview/""" + "$" + """id<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:167
  private[this] lazy val controllers_Assets_versioned95_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("assets/"), DynamicPart("file", """.+""",false)))
  )
  private[this] lazy val controllers_Assets_versioned95_invoker = createInvoker(
    Assets_19.versioned(fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Assets",
      "versioned",
      Seq(classOf[String]),
      "GET",
      this.prefix + """assets/""" + "$" + """file<.+>""",
      """ Map static resources from the /public folder to the /assets URL path""",
      Seq()
    )
  )


  def routes: PartialFunction[RequestHeader, Handler] = {
  
    // @LINE:6
    case controllers_ApplicationController_index0_route(params@_) =>
      call { 
        controllers_ApplicationController_index0_invoker.call(ApplicationController_12.index)
      }
  
    // @LINE:7
    case controllers_ApplicationController_signOut1_route(params@_) =>
      call { 
        controllers_ApplicationController_signOut1_invoker.call(ApplicationController_12.signOut)
      }
  
    // @LINE:8
    case controllers_SocialAuthController_authenticate2_route(params@_) =>
      call(params.fromPath[String]("provider", None)) { (provider) =>
        controllers_SocialAuthController_authenticate2_invoker.call(SocialAuthController_0.authenticate(provider))
      }
  
    // @LINE:10
    case controllers_SignUpController_view3_route(params@_) =>
      call { 
        controllers_SignUpController_view3_invoker.call(SignUpController_14.view)
      }
  
    // @LINE:11
    case controllers_SignUpController_submit4_route(params@_) =>
      call { 
        controllers_SignUpController_submit4_invoker.call(SignUpController_14.submit)
      }
  
    // @LINE:13
    case controllers_SignInController_view5_route(params@_) =>
      call { 
        controllers_SignInController_view5_invoker.call(SignInController_1.view)
      }
  
    // @LINE:14
    case controllers_SignInController_submit6_route(params@_) =>
      call { 
        controllers_SignInController_submit6_invoker.call(SignInController_1.submit)
      }
  
    // @LINE:16
    case controllers_TotpController_view7_route(params@_) =>
      call(params.fromQuery[java.util.UUID]("userId", None), params.fromQuery[String]("sharedKey", None), params.fromQuery[Boolean]("rememberMe", None)) { (userId, sharedKey, rememberMe) =>
        controllers_TotpController_view7_invoker.call(TotpController_2.view(userId, sharedKey, rememberMe))
      }
  
    // @LINE:17
    case controllers_TotpController_enableTotp8_route(params@_) =>
      call { 
        controllers_TotpController_enableTotp8_invoker.call(TotpController_2.enableTotp)
      }
  
    // @LINE:18
    case controllers_TotpController_disableTotp9_route(params@_) =>
      call { 
        controllers_TotpController_disableTotp9_invoker.call(TotpController_2.disableTotp)
      }
  
    // @LINE:19
    case controllers_TotpController_submit10_route(params@_) =>
      call { 
        controllers_TotpController_submit10_invoker.call(TotpController_2.submit)
      }
  
    // @LINE:20
    case controllers_TotpController_enableTotpSubmit11_route(params@_) =>
      call { 
        controllers_TotpController_enableTotpSubmit11_invoker.call(TotpController_2.enableTotpSubmit)
      }
  
    // @LINE:22
    case controllers_TotpRecoveryController_view12_route(params@_) =>
      call(params.fromQuery[java.util.UUID]("userID", None), params.fromQuery[String]("sharedKey", None), params.fromQuery[Boolean]("rememberMe", None)) { (userID, sharedKey, rememberMe) =>
        controllers_TotpRecoveryController_view12_invoker.call(TotpRecoveryController_10.view(userID, sharedKey, rememberMe))
      }
  
    // @LINE:23
    case controllers_TotpRecoveryController_submit13_route(params@_) =>
      call { 
        controllers_TotpRecoveryController_submit13_invoker.call(TotpRecoveryController_10.submit)
      }
  
    // @LINE:25
    case controllers_ForgotPasswordController_view14_route(params@_) =>
      call { 
        controllers_ForgotPasswordController_view14_invoker.call(ForgotPasswordController_6.view)
      }
  
    // @LINE:26
    case controllers_ForgotPasswordController_submit15_route(params@_) =>
      call { 
        controllers_ForgotPasswordController_submit15_invoker.call(ForgotPasswordController_6.submit)
      }
  
    // @LINE:27
    case controllers_ResetPasswordController_view16_route(params@_) =>
      call(params.fromPath[java.util.UUID]("token", None)) { (token) =>
        controllers_ResetPasswordController_view16_invoker.call(ResetPasswordController_8.view(token))
      }
  
    // @LINE:28
    case controllers_ResetPasswordController_submit17_route(params@_) =>
      call(params.fromPath[java.util.UUID]("token", None)) { (token) =>
        controllers_ResetPasswordController_submit17_invoker.call(ResetPasswordController_8.submit(token))
      }
  
    // @LINE:29
    case controllers_ChangePasswordController_view18_route(params@_) =>
      call { 
        controllers_ChangePasswordController_view18_invoker.call(ChangePasswordController_3.view)
      }
  
    // @LINE:30
    case controllers_ChangePasswordController_submit19_route(params@_) =>
      call { 
        controllers_ChangePasswordController_submit19_invoker.call(ChangePasswordController_3.submit)
      }
  
    // @LINE:32
    case controllers_ActivateAccountController_send20_route(params@_) =>
      call(params.fromPath[String]("email", None)) { (email) =>
        controllers_ActivateAccountController_send20_invoker.call(ActivateAccountController_16.send(email))
      }
  
    // @LINE:33
    case controllers_ActivateAccountController_activate21_route(params@_) =>
      call(params.fromPath[java.util.UUID]("token", None)) { (token) =>
        controllers_ActivateAccountController_activate21_invoker.call(ActivateAccountController_16.activate(token))
      }
  
    // @LINE:35
    case controllers_ApplicationController_registred22_route(params@_) =>
      call { 
        controllers_ApplicationController_registred22_invoker.call(ApplicationController_12.registred)
      }
  
    // @LINE:40
    case controllers_ProductController_addProduct23_route(params@_) =>
      call { 
        controllers_ProductController_addProduct23_invoker.call(ProductController_17.addProduct)
      }
  
    // @LINE:42
    case controllers_ProductController_addProductHandle24_route(params@_) =>
      call { 
        controllers_ProductController_addProductHandle24_invoker.call(ProductController_17.addProductHandle)
      }
  
    // @LINE:43
    case controllers_ProductController_updateProduct25_route(params@_) =>
      call(params.fromPath[Long]("id", None)) { (id) =>
        controllers_ProductController_updateProduct25_invoker.call(ProductController_17.updateProduct(id))
      }
  
    // @LINE:45
    case controllers_ProductController_updateProductHandle26_route(params@_) =>
      call { 
        controllers_ProductController_updateProductHandle26_invoker.call(ProductController_17.updateProductHandle)
      }
  
    // @LINE:47
    case controllers_ProductController_getProducts27_route(params@_) =>
      call { 
        controllers_ProductController_getProducts27_invoker.call(ProductController_17.getProducts)
      }
  
    // @LINE:48
    case controllers_ProductController_getProductsByCat28_route(params@_) =>
      call(params.fromPath[Int]("category", None)) { (category) =>
        controllers_ProductController_getProductsByCat28_invoker.call(ProductController_17.getProductsByCat(category))
      }
  
    // @LINE:49
    case controllers_ProductController_getProduct29_route(params@_) =>
      call(params.fromPath[Long]("id", None)) { (id) =>
        controllers_ProductController_getProduct29_invoker.call(ProductController_17.getProduct(id))
      }
  
    // @LINE:50
    case controllers_ProductController_delete30_route(params@_) =>
      call(params.fromPath[Long]("id", None)) { (id) =>
        controllers_ProductController_delete30_invoker.call(ProductController_17.delete(id))
      }
  
    // @LINE:54
    case controllers_CategoryController_addCategory31_route(params@_) =>
      call { 
        controllers_CategoryController_addCategory31_invoker.call(CategoryController_13.addCategory)
      }
  
    // @LINE:56
    case controllers_CategoryController_addCategoryHandle32_route(params@_) =>
      call { 
        controllers_CategoryController_addCategoryHandle32_invoker.call(CategoryController_13.addCategoryHandle)
      }
  
    // @LINE:57
    case controllers_CategoryController_updateCategory33_route(params@_) =>
      call(params.fromPath[Int]("id", None)) { (id) =>
        controllers_CategoryController_updateCategory33_invoker.call(CategoryController_13.updateCategory(id))
      }
  
    // @LINE:59
    case controllers_CategoryController_updateCategoryHandle34_route(params@_) =>
      call { 
        controllers_CategoryController_updateCategoryHandle34_invoker.call(CategoryController_13.updateCategoryHandle)
      }
  
    // @LINE:61
    case controllers_CategoryController_getCategory35_route(params@_) =>
      call(params.fromPath[Int]("id", None)) { (id) =>
        controllers_CategoryController_getCategory35_invoker.call(CategoryController_13.getCategory(id))
      }
  
    // @LINE:62
    case controllers_CategoryController_getCategories36_route(params@_) =>
      call { 
        controllers_CategoryController_getCategories36_invoker.call(CategoryController_13.getCategories)
      }
  
    // @LINE:63
    case controllers_CategoryController_deleteCategory37_route(params@_) =>
      call(params.fromPath[Int]("id", None)) { (id) =>
        controllers_CategoryController_deleteCategory37_invoker.call(CategoryController_13.deleteCategory(id))
      }
  
    // @LINE:67
    case controllers_UserController_addUser38_route(params@_) =>
      call { 
        controllers_UserController_addUser38_invoker.call(UserController_18.addUser)
      }
  
    // @LINE:69
    case controllers_UserController_addUserHandle39_route(params@_) =>
      call { 
        controllers_UserController_addUserHandle39_invoker.call(UserController_18.addUserHandle)
      }
  
    // @LINE:70
    case controllers_UserController_updateUser40_route(params@_) =>
      call(params.fromPath[Long]("id", None)) { (id) =>
        controllers_UserController_updateUser40_invoker.call(UserController_18.updateUser(id))
      }
  
    // @LINE:72
    case controllers_UserController_updateUserHandle41_route(params@_) =>
      call { 
        controllers_UserController_updateUserHandle41_invoker.call(UserController_18.updateUserHandle)
      }
  
    // @LINE:74
    case controllers_ApplicationController_getUser42_route(params@_) =>
      call { 
        controllers_ApplicationController_getUser42_invoker.call(ApplicationController_12.getUser)
      }
  
    // @LINE:76
    case controllers_UserController_deleteUser43_route(params@_) =>
      call(params.fromPath[Long]("id", None)) { (id) =>
        controllers_UserController_deleteUser43_invoker.call(UserController_18.deleteUser(id))
      }
  
    // @LINE:79
    case controllers_OrderController_addOrder44_route(params@_) =>
      call { 
        controllers_OrderController_addOrder44_invoker.call(OrderController_4.addOrder)
      }
  
    // @LINE:81
    case controllers_OrderController_addOrderHandle45_route(params@_) =>
      call { 
        controllers_OrderController_addOrderHandle45_invoker.call(OrderController_4.addOrderHandle)
      }
  
    // @LINE:82
    case controllers_OrderController_updateOrder46_route(params@_) =>
      call(params.fromPath[Long]("id", None)) { (id) =>
        controllers_OrderController_updateOrder46_invoker.call(OrderController_4.updateOrder(id))
      }
  
    // @LINE:84
    case controllers_OrderController_updateOrderHandle47_route(params@_) =>
      call { 
        controllers_OrderController_updateOrderHandle47_invoker.call(OrderController_4.updateOrderHandle)
      }
  
    // @LINE:86
    case controllers_OrderController_getOrders48_route(params@_) =>
      call { 
        controllers_OrderController_getOrders48_invoker.call(OrderController_4.getOrders)
      }
  
    // @LINE:87
    case controllers_OrderController_getOrder49_route(params@_) =>
      call(params.fromPath[Long]("id", None)) { (id) =>
        controllers_OrderController_getOrder49_invoker.call(OrderController_4.getOrder(id))
      }
  
    // @LINE:88
    case controllers_OrderController_getOrdersUsr50_route(params@_) =>
      call(params.fromPath[Long]("userid", None)) { (userid) =>
        controllers_OrderController_getOrdersUsr50_invoker.call(OrderController_4.getOrdersUsr(userid))
      }
  
    // @LINE:89
    case controllers_OrderController_deleteOrder51_route(params@_) =>
      call(params.fromPath[Long]("id", None)) { (id) =>
        controllers_OrderController_deleteOrder51_invoker.call(OrderController_4.deleteOrder(id))
      }
  
    // @LINE:92
    case controllers_BasketController_addToBasket52_route(params@_) =>
      call(params.fromPath[Long]("id", None)) { (id) =>
        controllers_BasketController_addToBasket52_invoker.call(BasketController_9.addToBasket(id))
      }
  
    // @LINE:94
    case controllers_ApplicationController_addToBasketHandle53_route(params@_) =>
      call { 
        controllers_ApplicationController_addToBasketHandle53_invoker.call(ApplicationController_12.addToBasketHandle)
      }
  
    // @LINE:95
    case controllers_BasketController_updateBasket54_route(params@_) =>
      call(params.fromPath[Long]("id", None)) { (id) =>
        controllers_BasketController_updateBasket54_invoker.call(BasketController_9.updateBasket(id))
      }
  
    // @LINE:97
    case controllers_BasketController_updateBasketHandle55_route(params@_) =>
      call { 
        controllers_BasketController_updateBasketHandle55_invoker.call(BasketController_9.updateBasketHandle)
      }
  
    // @LINE:99
    case controllers_ApplicationController_basketContent56_route(params@_) =>
      call { 
        controllers_ApplicationController_basketContent56_invoker.call(ApplicationController_12.basketContent)
      }
  
    // @LINE:100
    case controllers_BasketController_deleteFromBasket57_route(params@_) =>
      call(params.fromPath[Long]("id", None)) { (id) =>
        controllers_BasketController_deleteFromBasket57_invoker.call(BasketController_9.deleteFromBasket(id))
      }
  
    // @LINE:103
    case controllers_PaymentController_addPayment58_route(params@_) =>
      call { 
        controllers_PaymentController_addPayment58_invoker.call(PaymentController_15.addPayment)
      }
  
    // @LINE:105
    case controllers_PaymentController_addPaymentHandle59_route(params@_) =>
      call { 
        controllers_PaymentController_addPaymentHandle59_invoker.call(PaymentController_15.addPaymentHandle)
      }
  
    // @LINE:106
    case controllers_PaymentController_updatePayment60_route(params@_) =>
      call(params.fromPath[Long]("id", None)) { (id) =>
        controllers_PaymentController_updatePayment60_invoker.call(PaymentController_15.updatePayment(id))
      }
  
    // @LINE:108
    case controllers_PaymentController_updatePaymentHandle61_route(params@_) =>
      call { 
        controllers_PaymentController_updatePaymentHandle61_invoker.call(PaymentController_15.updatePaymentHandle)
      }
  
    // @LINE:110
    case controllers_PaymentController_getPayment62_route(params@_) =>
      call(params.fromPath[Long]("id", None)) { (id) =>
        controllers_PaymentController_getPayment62_invoker.call(PaymentController_15.getPayment(id))
      }
  
    // @LINE:111
    case controllers_PaymentController_getPayments63_route(params@_) =>
      call { 
        controllers_PaymentController_getPayments63_invoker.call(PaymentController_15.getPayments)
      }
  
    // @LINE:112
    case controllers_PaymentController_getPaymentOrd64_route(params@_) =>
      call(params.fromPath[Long]("id", None)) { (id) =>
        controllers_PaymentController_getPaymentOrd64_invoker.call(PaymentController_15.getPaymentOrd(id))
      }
  
    // @LINE:113
    case controllers_PaymentController_deletePayment65_route(params@_) =>
      call(params.fromPath[Long]("id", None)) { (id) =>
        controllers_PaymentController_deletePayment65_invoker.call(PaymentController_15.deletePayment(id))
      }
  
    // @LINE:116
    case controllers_FavoritesController_addFavorites66_route(params@_) =>
      call { 
        controllers_FavoritesController_addFavorites66_invoker.call(FavoritesController_11.addFavorites)
      }
  
    // @LINE:118
    case controllers_ApplicationController_addFavoritesHandle67_route(params@_) =>
      call { 
        controllers_ApplicationController_addFavoritesHandle67_invoker.call(ApplicationController_12.addFavoritesHandle)
      }
  
    // @LINE:121
    case controllers_FavoritesController_updateFavoritesHandle68_route(params@_) =>
      call { 
        controllers_FavoritesController_updateFavoritesHandle68_invoker.call(FavoritesController_11.updateFavoritesHandle)
      }
  
    // @LINE:123
    case controllers_ApplicationController_favoritesContent69_route(params@_) =>
      call { 
        controllers_ApplicationController_favoritesContent69_invoker.call(ApplicationController_12.favoritesContent)
      }
  
    // @LINE:124
    case controllers_FavoritesController_getFavorit70_route(params@_) =>
      call(params.fromPath[Int]("id", None)) { (id) =>
        controllers_FavoritesController_getFavorit70_invoker.call(FavoritesController_11.getFavorit(id))
      }
  
    // @LINE:125
    case controllers_FavoritesController_getFavoritesUsr71_route(params@_) =>
      call(params.fromPath[Long]("userid", None)) { (userid) =>
        controllers_FavoritesController_getFavoritesUsr71_invoker.call(FavoritesController_11.getFavoritesUsr(userid))
      }
  
    // @LINE:126
    case controllers_FavoritesController_deleteFavorites72_route(params@_) =>
      call(params.fromPath[Long]("productid", None)) { (productid) =>
        controllers_FavoritesController_deleteFavorites72_invoker.call(FavoritesController_11.deleteFavorites(productid))
      }
  
    // @LINE:129
    case controllers_DiscountController_addDiscount73_route(params@_) =>
      call(params.fromPath[Long]("product_id", None)) { (product_id) =>
        controllers_DiscountController_addDiscount73_invoker.call(DiscountController_20.addDiscount(product_id))
      }
  
    // @LINE:131
    case controllers_DiscountController_addDiscountHandle74_route(params@_) =>
      call { 
        controllers_DiscountController_addDiscountHandle74_invoker.call(DiscountController_20.addDiscountHandle)
      }
  
    // @LINE:132
    case controllers_DiscountController_updateDiscount75_route(params@_) =>
      call(params.fromPath[Long]("id", None)) { (id) =>
        controllers_DiscountController_updateDiscount75_invoker.call(DiscountController_20.updateDiscount(id))
      }
  
    // @LINE:134
    case controllers_DiscountController_updateDiscountHandle76_route(params@_) =>
      call { 
        controllers_DiscountController_updateDiscountHandle76_invoker.call(DiscountController_20.updateDiscountHandle)
      }
  
    // @LINE:136
    case controllers_DiscountController_getDiscounts77_route(params@_) =>
      call { 
        controllers_DiscountController_getDiscounts77_invoker.call(DiscountController_20.getDiscounts)
      }
  
    // @LINE:137
    case controllers_DiscountController_getDiscountpr78_route(params@_) =>
      call(params.fromPath[Long]("id", None)) { (id) =>
        controllers_DiscountController_getDiscountpr78_invoker.call(DiscountController_20.getDiscountpr(id))
      }
  
    // @LINE:138
    case controllers_DiscountController_getDiscount79_route(params@_) =>
      call(params.fromPath[Long]("id", None)) { (id) =>
        controllers_DiscountController_getDiscount79_invoker.call(DiscountController_20.getDiscount(id))
      }
  
    // @LINE:139
    case controllers_DiscountController_deleteDiscount80_route(params@_) =>
      call(params.fromPath[Long]("id", None)) { (id) =>
        controllers_DiscountController_deleteDiscount80_invoker.call(DiscountController_20.deleteDiscount(id))
      }
  
    // @LINE:142
    case controllers_DeliveryController_addDelivery81_route(params@_) =>
      call { 
        controllers_DeliveryController_addDelivery81_invoker.call(DeliveryController_5.addDelivery)
      }
  
    // @LINE:144
    case controllers_DeliveryController_addDeliveryHandle82_route(params@_) =>
      call { 
        controllers_DeliveryController_addDeliveryHandle82_invoker.call(DeliveryController_5.addDeliveryHandle)
      }
  
    // @LINE:145
    case controllers_DeliveryController_updateDelivery83_route(params@_) =>
      call(params.fromPath[Long]("id", None)) { (id) =>
        controllers_DeliveryController_updateDelivery83_invoker.call(DeliveryController_5.updateDelivery(id))
      }
  
    // @LINE:147
    case controllers_DeliveryController_updateDeliveryHandle84_route(params@_) =>
      call { 
        controllers_DeliveryController_updateDeliveryHandle84_invoker.call(DeliveryController_5.updateDeliveryHandle)
      }
  
    // @LINE:149
    case controllers_DeliveryController_getDeliverys85_route(params@_) =>
      call { 
        controllers_DeliveryController_getDeliverys85_invoker.call(DeliveryController_5.getDeliverys)
      }
  
    // @LINE:150
    case controllers_DeliveryController_getDelivery86_route(params@_) =>
      call(params.fromPath[Long]("id", None)) { (id) =>
        controllers_DeliveryController_getDelivery86_invoker.call(DeliveryController_5.getDelivery(id))
      }
  
    // @LINE:151
    case controllers_DeliveryController_getDeliveryOrd87_route(params@_) =>
      call(params.fromPath[Long]("id", None)) { (id) =>
        controllers_DeliveryController_getDeliveryOrd87_invoker.call(DeliveryController_5.getDeliveryOrd(id))
      }
  
    // @LINE:152
    case controllers_DeliveryController_deleteDelivery88_route(params@_) =>
      call(params.fromPath[Long]("id", None)) { (id) =>
        controllers_DeliveryController_deleteDelivery88_invoker.call(DeliveryController_5.deleteDelivery(id))
      }
  
    // @LINE:155
    case controllers_ReviewController_addReview89_route(params@_) =>
      call { 
        controllers_ReviewController_addReview89_invoker.call(ReviewController_7.addReview)
      }
  
    // @LINE:157
    case controllers_ApplicationController_addReviewHandle90_route(params@_) =>
      call { 
        controllers_ApplicationController_addReviewHandle90_invoker.call(ApplicationController_12.addReviewHandle)
      }
  
    // @LINE:158
    case controllers_ReviewController_updateReview91_route(params@_) =>
      call(params.fromPath[Int]("id", None)) { (id) =>
        controllers_ReviewController_updateReview91_invoker.call(ReviewController_7.updateReview(id))
      }
  
    // @LINE:160
    case controllers_ReviewController_updateReviewHandle92_route(params@_) =>
      call { 
        controllers_ReviewController_updateReviewHandle92_invoker.call(ReviewController_7.updateReviewHandle)
      }
  
    // @LINE:163
    case controllers_ReviewController_review93_route(params@_) =>
      call(params.fromPath[Long]("productid", None)) { (productid) =>
        controllers_ReviewController_review93_invoker.call(ReviewController_7.review(productid))
      }
  
    // @LINE:164
    case controllers_ReviewController_deleteReview94_route(params@_) =>
      call(params.fromPath[Int]("id", None)) { (id) =>
        controllers_ReviewController_deleteReview94_invoker.call(ReviewController_7.deleteReview(id))
      }
  
    // @LINE:167
    case controllers_Assets_versioned95_route(params@_) =>
      call(params.fromPath[String]("file", None)) { (file) =>
        controllers_Assets_versioned95_invoker.call(Assets_19.versioned(file))
      }
  }
}
