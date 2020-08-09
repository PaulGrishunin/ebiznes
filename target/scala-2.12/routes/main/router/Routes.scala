// @GENERATOR:play-routes-compiler
// @SOURCE:/home/paul/ebiznes/conf/routes
// @DATE:Sun Aug 09 20:25:09 MSK 2020

package router

import play.core.routing._
import play.core.routing.HandlerInvokerFactory._

import play.api.mvc._

import _root_.controllers.Assets.Asset

class Routes(
  override val errorHandler: play.api.http.HttpErrorHandler, 
  // @LINE:7
  ProductController_8: controllers.ProductController,
  // @LINE:21
  CategoryController_5: controllers.CategoryController,
  // @LINE:34
  UserController_9: controllers.UserController,
  // @LINE:47
  OrderController_0: controllers.OrderController,
  // @LINE:61
  BasketController_4: controllers.BasketController,
  // @LINE:72
  PaymentController_7: controllers.PaymentController,
  // @LINE:86
  QuestionController_1: controllers.QuestionController,
  // @LINE:100
  DiscountController_12: controllers.DiscountController,
  // @LINE:114
  DeliveryController_2: controllers.DeliveryController,
  // @LINE:128
  ReviewController_3: controllers.ReviewController,
  // @LINE:141
  CountController_6: controllers.CountController,
  // @LINE:143
  AsyncController_11: controllers.AsyncController,
  // @LINE:146
  Assets_10: controllers.Assets,
  val prefix: String
) extends GeneratedRouter {

   @javax.inject.Inject()
   def this(errorHandler: play.api.http.HttpErrorHandler,
    // @LINE:7
    ProductController_8: controllers.ProductController,
    // @LINE:21
    CategoryController_5: controllers.CategoryController,
    // @LINE:34
    UserController_9: controllers.UserController,
    // @LINE:47
    OrderController_0: controllers.OrderController,
    // @LINE:61
    BasketController_4: controllers.BasketController,
    // @LINE:72
    PaymentController_7: controllers.PaymentController,
    // @LINE:86
    QuestionController_1: controllers.QuestionController,
    // @LINE:100
    DiscountController_12: controllers.DiscountController,
    // @LINE:114
    DeliveryController_2: controllers.DeliveryController,
    // @LINE:128
    ReviewController_3: controllers.ReviewController,
    // @LINE:141
    CountController_6: controllers.CountController,
    // @LINE:143
    AsyncController_11: controllers.AsyncController,
    // @LINE:146
    Assets_10: controllers.Assets
  ) = this(errorHandler, ProductController_8, CategoryController_5, UserController_9, OrderController_0, BasketController_4, PaymentController_7, QuestionController_1, DiscountController_12, DeliveryController_2, ReviewController_3, CountController_6, AsyncController_11, Assets_10, "/")

  def withPrefix(addPrefix: String): Routes = {
    val prefix = play.api.routing.Router.concatPrefix(addPrefix, this.prefix)
    router.RoutesPrefix.setPrefix(prefix)
    new Routes(errorHandler, ProductController_8, CategoryController_5, UserController_9, OrderController_0, BasketController_4, PaymentController_7, QuestionController_1, DiscountController_12, DeliveryController_2, ReviewController_3, CountController_6, AsyncController_11, Assets_10, prefix)
  }

  private[this] val defaultPrefix: String = {
    if (this.prefix.endsWith("/")) "" else "/"
  }

  def documentation = List(
    ("""GET""", this.prefix, """controllers.ProductController.index"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """addproduct""", """controllers.ProductController.addProduct"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """addproducthandle""", """controllers.ProductController.addProductHandle"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """updateproduct/""" + "$" + """id<[^/]+>""", """controllers.ProductController.updateProduct(id:Long)"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """updateproducthandle""", """controllers.ProductController.updateProductHandle"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """products""", """controllers.ProductController.getProducts"""),
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
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """user/""" + "$" + """id<[^/]+>""", """controllers.UserController.getUser(id:Long)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """users""", """controllers.UserController.getUsers"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """deleteuser/""" + "$" + """id<[^/]+>""", """controllers.UserController.deleteUser(id:Long)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """addorder""", """controllers.OrderController.addOrder"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """addorderhandle""", """controllers.OrderController.addOrderHandle"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """updateorder/""" + "$" + """id<[^/]+>""", """controllers.OrderController.updateOrder(id:Long)"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """updateorderhandle""", """controllers.OrderController.updateOrderHandle"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """orders""", """controllers.OrderController.getOrders"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """order/""" + "$" + """id<[^/]+>""", """controllers.OrderController.getOrder(id:Long)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """orderusr/""" + "$" + """id<[^/]+>""", """controllers.OrderController.getOrdersUsr(id:Long)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """deleteorder/""" + "$" + """id<[^/]+>""", """controllers.OrderController.deleteOrder(id:Long)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """addtobasket/""" + "$" + """id<[^/]+>""", """controllers.BasketController.addToBasket(id:Long)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """updatebask/""" + "$" + """id<[^/]+>""", """controllers.BasketController.updateBasket(id:Long)"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """updatebaskethandle""", """controllers.BasketController.updateBasketHandle"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """deletefrombasket/""" + "$" + """id<[^/]+>""", """controllers.BasketController.deleteFromBasket(id:Long)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """addpayment""", """controllers.PaymentController.addPayment"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """addpaymenthandle""", """controllers.PaymentController.addPaymentHandle"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """updatepayment/""" + "$" + """id<[^/]+>""", """controllers.PaymentController.updatePayment(id:Long)"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """updatepaymenthandle""", """controllers.PaymentController.updatePaymentHandle"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """payment/""" + "$" + """id<[^/]+>""", """controllers.PaymentController.getPayment(id:Long)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """payments""", """controllers.PaymentController.getPayments"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """paymentord/""" + "$" + """id<[^/]+>""", """controllers.PaymentController.getPaymentOrd(id:Long)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """deletepayment/""" + "$" + """id<[^/]+>""", """controllers.PaymentController.deletePayment(id:Long)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """addquestion""", """controllers.QuestionController.addQuestion"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """addquestionhandle""", """controllers.QuestionController.addQuestionHandle"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """updatequestion/""" + "$" + """id<[^/]+>""", """controllers.QuestionController.updateQuestion(id:Int)"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """updatequestionhandle""", """controllers.QuestionController.updateQuestionHandle"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """questions""", """controllers.QuestionController.getQuestions"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """question/""" + "$" + """id<[^/]+>""", """controllers.QuestionController.getQuestion(id:Int)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """questionprod/""" + "$" + """id<[^/]+>""", """controllers.QuestionController.getQuestionProd(id:Long)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """deletequestion/""" + "$" + """id<[^/]+>""", """controllers.QuestionController.deleteQuestion(id:Int)"""),
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
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """addreviewhandle""", """controllers.ReviewController.addReviewHandle"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """updatereview/""" + "$" + """id<[^/]+>""", """controllers.ReviewController.updateReview(id:Int)"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """updatereviewhandle""", """controllers.ReviewController.updateReviewHandle"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """reviews""", """controllers.ReviewController.getReviews"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """review/""" + "$" + """id<[^/]+>""", """controllers.ReviewController.getReview(id:Int)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """deletereview/""" + "$" + """id<[^/]+>""", """controllers.ReviewController.deleteReview(id:Int)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """count""", """controllers.CountController.count"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """message""", """controllers.AsyncController.message"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """assets/""" + "$" + """file<.+>""", """controllers.Assets.versioned(path:String = "/public", file:Asset)"""),
    Nil
  ).foldLeft(List.empty[(String,String,String)]) { (s,e) => e.asInstanceOf[Any] match {
    case r @ (_,_,_) => s :+ r.asInstanceOf[(String,String,String)]
    case l => s ++ l.asInstanceOf[List[(String,String,String)]]
  }}


  // @LINE:7
  private[this] lazy val controllers_ProductController_index0_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix)))
  )
  private[this] lazy val controllers_ProductController_index0_invoker = createInvoker(
    ProductController_8.index,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.ProductController",
      "index",
      Nil,
      "GET",
      this.prefix + """""",
      """ An example controller showing a sample home page""",
      Seq()
    )
  )

  // @LINE:8
  private[this] lazy val controllers_ProductController_addProduct1_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("addproduct")))
  )
  private[this] lazy val controllers_ProductController_addProduct1_invoker = createInvoker(
    ProductController_8.addProduct,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.ProductController",
      "addProduct",
      Nil,
      "GET",
      this.prefix + """addproduct""",
      """""",
      Seq()
    )
  )

  // @LINE:10
  private[this] lazy val controllers_ProductController_addProductHandle2_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("addproducthandle")))
  )
  private[this] lazy val controllers_ProductController_addProductHandle2_invoker = createInvoker(
    ProductController_8.addProductHandle,
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

  // @LINE:11
  private[this] lazy val controllers_ProductController_updateProduct3_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("updateproduct/"), DynamicPart("id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_ProductController_updateProduct3_invoker = createInvoker(
    ProductController_8.updateProduct(fakeValue[Long]),
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

  // @LINE:13
  private[this] lazy val controllers_ProductController_updateProductHandle4_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("updateproducthandle")))
  )
  private[this] lazy val controllers_ProductController_updateProductHandle4_invoker = createInvoker(
    ProductController_8.updateProductHandle,
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

  // @LINE:15
  private[this] lazy val controllers_ProductController_getProducts5_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("products")))
  )
  private[this] lazy val controllers_ProductController_getProducts5_invoker = createInvoker(
    ProductController_8.getProducts,
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

  // @LINE:16
  private[this] lazy val controllers_ProductController_getProduct6_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("product/"), DynamicPart("id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_ProductController_getProduct6_invoker = createInvoker(
    ProductController_8.getProduct(fakeValue[Long]),
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

  // @LINE:17
  private[this] lazy val controllers_ProductController_delete7_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("delete/"), DynamicPart("id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_ProductController_delete7_invoker = createInvoker(
    ProductController_8.delete(fakeValue[Long]),
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

  // @LINE:21
  private[this] lazy val controllers_CategoryController_addCategory8_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("addcategory")))
  )
  private[this] lazy val controllers_CategoryController_addCategory8_invoker = createInvoker(
    CategoryController_5.addCategory,
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

  // @LINE:23
  private[this] lazy val controllers_CategoryController_addCategoryHandle9_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("addcategory")))
  )
  private[this] lazy val controllers_CategoryController_addCategoryHandle9_invoker = createInvoker(
    CategoryController_5.addCategoryHandle,
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

  // @LINE:24
  private[this] lazy val controllers_CategoryController_updateCategory10_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("updatecategory/"), DynamicPart("id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_CategoryController_updateCategory10_invoker = createInvoker(
    CategoryController_5.updateCategory(fakeValue[Int]),
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

  // @LINE:26
  private[this] lazy val controllers_CategoryController_updateCategoryHandle11_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("updatecategoryhandle")))
  )
  private[this] lazy val controllers_CategoryController_updateCategoryHandle11_invoker = createInvoker(
    CategoryController_5.updateCategoryHandle,
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

  // @LINE:28
  private[this] lazy val controllers_CategoryController_getCategory12_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("category/"), DynamicPart("id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_CategoryController_getCategory12_invoker = createInvoker(
    CategoryController_5.getCategory(fakeValue[Int]),
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

  // @LINE:29
  private[this] lazy val controllers_CategoryController_getCategories13_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("categories")))
  )
  private[this] lazy val controllers_CategoryController_getCategories13_invoker = createInvoker(
    CategoryController_5.getCategories,
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

  // @LINE:30
  private[this] lazy val controllers_CategoryController_deleteCategory14_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("deletecategory/"), DynamicPart("id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_CategoryController_deleteCategory14_invoker = createInvoker(
    CategoryController_5.deleteCategory(fakeValue[Int]),
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

  // @LINE:34
  private[this] lazy val controllers_UserController_addUser15_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("adduser")))
  )
  private[this] lazy val controllers_UserController_addUser15_invoker = createInvoker(
    UserController_9.addUser,
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

  // @LINE:36
  private[this] lazy val controllers_UserController_addUserHandle16_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("adduserhandle")))
  )
  private[this] lazy val controllers_UserController_addUserHandle16_invoker = createInvoker(
    UserController_9.addUserHandle,
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

  // @LINE:37
  private[this] lazy val controllers_UserController_updateUser17_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("updateuser/"), DynamicPart("id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_UserController_updateUser17_invoker = createInvoker(
    UserController_9.updateUser(fakeValue[Long]),
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

  // @LINE:39
  private[this] lazy val controllers_UserController_updateUserHandle18_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("updateuserhandle")))
  )
  private[this] lazy val controllers_UserController_updateUserHandle18_invoker = createInvoker(
    UserController_9.updateUserHandle,
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

  // @LINE:41
  private[this] lazy val controllers_UserController_getUser19_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("user/"), DynamicPart("id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_UserController_getUser19_invoker = createInvoker(
    UserController_9.getUser(fakeValue[Long]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.UserController",
      "getUser",
      Seq(classOf[Long]),
      "GET",
      this.prefix + """user/""" + "$" + """id<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:42
  private[this] lazy val controllers_UserController_getUsers20_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("users")))
  )
  private[this] lazy val controllers_UserController_getUsers20_invoker = createInvoker(
    UserController_9.getUsers,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.UserController",
      "getUsers",
      Nil,
      "GET",
      this.prefix + """users""",
      """""",
      Seq()
    )
  )

  // @LINE:43
  private[this] lazy val controllers_UserController_deleteUser21_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("deleteuser/"), DynamicPart("id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_UserController_deleteUser21_invoker = createInvoker(
    UserController_9.deleteUser(fakeValue[Long]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.UserController",
      "deleteUser",
      Seq(classOf[Long]),
      "GET",
      this.prefix + """deleteuser/""" + "$" + """id<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:47
  private[this] lazy val controllers_OrderController_addOrder22_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("addorder")))
  )
  private[this] lazy val controllers_OrderController_addOrder22_invoker = createInvoker(
    OrderController_0.addOrder,
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

  // @LINE:49
  private[this] lazy val controllers_OrderController_addOrderHandle23_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("addorderhandle")))
  )
  private[this] lazy val controllers_OrderController_addOrderHandle23_invoker = createInvoker(
    OrderController_0.addOrderHandle,
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

  // @LINE:50
  private[this] lazy val controllers_OrderController_updateOrder24_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("updateorder/"), DynamicPart("id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_OrderController_updateOrder24_invoker = createInvoker(
    OrderController_0.updateOrder(fakeValue[Long]),
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

  // @LINE:52
  private[this] lazy val controllers_OrderController_updateOrderHandle25_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("updateorderhandle")))
  )
  private[this] lazy val controllers_OrderController_updateOrderHandle25_invoker = createInvoker(
    OrderController_0.updateOrderHandle,
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

  // @LINE:54
  private[this] lazy val controllers_OrderController_getOrders26_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("orders")))
  )
  private[this] lazy val controllers_OrderController_getOrders26_invoker = createInvoker(
    OrderController_0.getOrders,
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

  // @LINE:55
  private[this] lazy val controllers_OrderController_getOrder27_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("order/"), DynamicPart("id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_OrderController_getOrder27_invoker = createInvoker(
    OrderController_0.getOrder(fakeValue[Long]),
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

  // @LINE:56
  private[this] lazy val controllers_OrderController_getOrdersUsr28_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("orderusr/"), DynamicPart("id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_OrderController_getOrdersUsr28_invoker = createInvoker(
    OrderController_0.getOrdersUsr(fakeValue[Long]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.OrderController",
      "getOrdersUsr",
      Seq(classOf[Long]),
      "GET",
      this.prefix + """orderusr/""" + "$" + """id<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:57
  private[this] lazy val controllers_OrderController_deleteOrder29_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("deleteorder/"), DynamicPart("id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_OrderController_deleteOrder29_invoker = createInvoker(
    OrderController_0.deleteOrder(fakeValue[Long]),
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

  // @LINE:61
  private[this] lazy val controllers_BasketController_addToBasket30_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("addtobasket/"), DynamicPart("id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_BasketController_addToBasket30_invoker = createInvoker(
    BasketController_4.addToBasket(fakeValue[Long]),
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

  // @LINE:63
  private[this] lazy val controllers_BasketController_updateBasket31_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("updatebask/"), DynamicPart("id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_BasketController_updateBasket31_invoker = createInvoker(
    BasketController_4.updateBasket(fakeValue[Long]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.BasketController",
      "updateBasket",
      Seq(classOf[Long]),
      "GET",
      this.prefix + """updatebask/""" + "$" + """id<[^/]+>""",
      """POST   /addbaskethandle         controllers.BasketController.addBasketHandle""",
      Seq()
    )
  )

  // @LINE:65
  private[this] lazy val controllers_BasketController_updateBasketHandle32_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("updatebaskethandle")))
  )
  private[this] lazy val controllers_BasketController_updateBasketHandle32_invoker = createInvoker(
    BasketController_4.updateBasketHandle,
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

  // @LINE:68
  private[this] lazy val controllers_BasketController_deleteFromBasket33_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("deletefrombasket/"), DynamicPart("id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_BasketController_deleteFromBasket33_invoker = createInvoker(
    BasketController_4.deleteFromBasket(fakeValue[Long]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.BasketController",
      "deleteFromBasket",
      Seq(classOf[Long]),
      "GET",
      this.prefix + """deletefrombasket/""" + "$" + """id<[^/]+>""",
      """GET    /basket                  controllers.BasketController.getBasket""",
      Seq()
    )
  )

  // @LINE:72
  private[this] lazy val controllers_PaymentController_addPayment34_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("addpayment")))
  )
  private[this] lazy val controllers_PaymentController_addPayment34_invoker = createInvoker(
    PaymentController_7.addPayment,
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

  // @LINE:74
  private[this] lazy val controllers_PaymentController_addPaymentHandle35_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("addpaymenthandle")))
  )
  private[this] lazy val controllers_PaymentController_addPaymentHandle35_invoker = createInvoker(
    PaymentController_7.addPaymentHandle,
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

  // @LINE:75
  private[this] lazy val controllers_PaymentController_updatePayment36_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("updatepayment/"), DynamicPart("id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_PaymentController_updatePayment36_invoker = createInvoker(
    PaymentController_7.updatePayment(fakeValue[Long]),
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

  // @LINE:77
  private[this] lazy val controllers_PaymentController_updatePaymentHandle37_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("updatepaymenthandle")))
  )
  private[this] lazy val controllers_PaymentController_updatePaymentHandle37_invoker = createInvoker(
    PaymentController_7.updatePaymentHandle,
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

  // @LINE:79
  private[this] lazy val controllers_PaymentController_getPayment38_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("payment/"), DynamicPart("id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_PaymentController_getPayment38_invoker = createInvoker(
    PaymentController_7.getPayment(fakeValue[Long]),
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

  // @LINE:80
  private[this] lazy val controllers_PaymentController_getPayments39_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("payments")))
  )
  private[this] lazy val controllers_PaymentController_getPayments39_invoker = createInvoker(
    PaymentController_7.getPayments,
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

  // @LINE:81
  private[this] lazy val controllers_PaymentController_getPaymentOrd40_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("paymentord/"), DynamicPart("id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_PaymentController_getPaymentOrd40_invoker = createInvoker(
    PaymentController_7.getPaymentOrd(fakeValue[Long]),
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

  // @LINE:82
  private[this] lazy val controllers_PaymentController_deletePayment41_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("deletepayment/"), DynamicPart("id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_PaymentController_deletePayment41_invoker = createInvoker(
    PaymentController_7.deletePayment(fakeValue[Long]),
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

  // @LINE:86
  private[this] lazy val controllers_QuestionController_addQuestion42_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("addquestion")))
  )
  private[this] lazy val controllers_QuestionController_addQuestion42_invoker = createInvoker(
    QuestionController_1.addQuestion,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.QuestionController",
      "addQuestion",
      Nil,
      "GET",
      this.prefix + """addquestion""",
      """product Questions""",
      Seq()
    )
  )

  // @LINE:88
  private[this] lazy val controllers_QuestionController_addQuestionHandle43_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("addquestionhandle")))
  )
  private[this] lazy val controllers_QuestionController_addQuestionHandle43_invoker = createInvoker(
    QuestionController_1.addQuestionHandle,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.QuestionController",
      "addQuestionHandle",
      Nil,
      "POST",
      this.prefix + """addquestionhandle""",
      """""",
      Seq("""nocsrf""")
    )
  )

  // @LINE:89
  private[this] lazy val controllers_QuestionController_updateQuestion44_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("updatequestion/"), DynamicPart("id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_QuestionController_updateQuestion44_invoker = createInvoker(
    QuestionController_1.updateQuestion(fakeValue[Int]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.QuestionController",
      "updateQuestion",
      Seq(classOf[Int]),
      "GET",
      this.prefix + """updatequestion/""" + "$" + """id<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:91
  private[this] lazy val controllers_QuestionController_updateQuestionHandle45_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("updatequestionhandle")))
  )
  private[this] lazy val controllers_QuestionController_updateQuestionHandle45_invoker = createInvoker(
    QuestionController_1.updateQuestionHandle,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.QuestionController",
      "updateQuestionHandle",
      Nil,
      "POST",
      this.prefix + """updatequestionhandle""",
      """""",
      Seq("""nocsrf""")
    )
  )

  // @LINE:93
  private[this] lazy val controllers_QuestionController_getQuestions46_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("questions")))
  )
  private[this] lazy val controllers_QuestionController_getQuestions46_invoker = createInvoker(
    QuestionController_1.getQuestions,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.QuestionController",
      "getQuestions",
      Nil,
      "GET",
      this.prefix + """questions""",
      """""",
      Seq()
    )
  )

  // @LINE:94
  private[this] lazy val controllers_QuestionController_getQuestion47_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("question/"), DynamicPart("id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_QuestionController_getQuestion47_invoker = createInvoker(
    QuestionController_1.getQuestion(fakeValue[Int]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.QuestionController",
      "getQuestion",
      Seq(classOf[Int]),
      "GET",
      this.prefix + """question/""" + "$" + """id<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:95
  private[this] lazy val controllers_QuestionController_getQuestionProd48_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("questionprod/"), DynamicPart("id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_QuestionController_getQuestionProd48_invoker = createInvoker(
    QuestionController_1.getQuestionProd(fakeValue[Long]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.QuestionController",
      "getQuestionProd",
      Seq(classOf[Long]),
      "GET",
      this.prefix + """questionprod/""" + "$" + """id<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:96
  private[this] lazy val controllers_QuestionController_deleteQuestion49_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("deletequestion/"), DynamicPart("id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_QuestionController_deleteQuestion49_invoker = createInvoker(
    QuestionController_1.deleteQuestion(fakeValue[Int]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.QuestionController",
      "deleteQuestion",
      Seq(classOf[Int]),
      "GET",
      this.prefix + """deletequestion/""" + "$" + """id<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:100
  private[this] lazy val controllers_DiscountController_addDiscount50_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("adddiscount/"), DynamicPart("product_id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_DiscountController_addDiscount50_invoker = createInvoker(
    DiscountController_12.addDiscount(fakeValue[Long]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.DiscountController",
      "addDiscount",
      Seq(classOf[Long]),
      "GET",
      this.prefix + """adddiscount/""" + "$" + """product_id<[^/]+>""",
      """
discount""",
      Seq()
    )
  )

  // @LINE:102
  private[this] lazy val controllers_DiscountController_addDiscountHandle51_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("adddiscounthandle")))
  )
  private[this] lazy val controllers_DiscountController_addDiscountHandle51_invoker = createInvoker(
    DiscountController_12.addDiscountHandle,
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

  // @LINE:103
  private[this] lazy val controllers_DiscountController_updateDiscount52_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("updatediscount/"), DynamicPart("id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_DiscountController_updateDiscount52_invoker = createInvoker(
    DiscountController_12.updateDiscount(fakeValue[Long]),
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

  // @LINE:105
  private[this] lazy val controllers_DiscountController_updateDiscountHandle53_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("updatediscounthandle")))
  )
  private[this] lazy val controllers_DiscountController_updateDiscountHandle53_invoker = createInvoker(
    DiscountController_12.updateDiscountHandle,
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

  // @LINE:107
  private[this] lazy val controllers_DiscountController_getDiscounts54_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("discounts")))
  )
  private[this] lazy val controllers_DiscountController_getDiscounts54_invoker = createInvoker(
    DiscountController_12.getDiscounts,
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

  // @LINE:108
  private[this] lazy val controllers_DiscountController_getDiscountpr55_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("discountpr/"), DynamicPart("id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_DiscountController_getDiscountpr55_invoker = createInvoker(
    DiscountController_12.getDiscountpr(fakeValue[Long]),
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

  // @LINE:109
  private[this] lazy val controllers_DiscountController_getDiscount56_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("discount/"), DynamicPart("id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_DiscountController_getDiscount56_invoker = createInvoker(
    DiscountController_12.getDiscount(fakeValue[Long]),
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

  // @LINE:110
  private[this] lazy val controllers_DiscountController_deleteDiscount57_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("deletediscount/"), DynamicPart("id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_DiscountController_deleteDiscount57_invoker = createInvoker(
    DiscountController_12.deleteDiscount(fakeValue[Long]),
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

  // @LINE:114
  private[this] lazy val controllers_DeliveryController_addDelivery58_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("adddelivery")))
  )
  private[this] lazy val controllers_DeliveryController_addDelivery58_invoker = createInvoker(
    DeliveryController_2.addDelivery,
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

  // @LINE:116
  private[this] lazy val controllers_DeliveryController_addDeliveryHandle59_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("adddeliveryhandle")))
  )
  private[this] lazy val controllers_DeliveryController_addDeliveryHandle59_invoker = createInvoker(
    DeliveryController_2.addDeliveryHandle,
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

  // @LINE:117
  private[this] lazy val controllers_DeliveryController_updateDelivery60_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("updatedelivery/"), DynamicPart("id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_DeliveryController_updateDelivery60_invoker = createInvoker(
    DeliveryController_2.updateDelivery(fakeValue[Long]),
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

  // @LINE:119
  private[this] lazy val controllers_DeliveryController_updateDeliveryHandle61_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("updatedeliveryhandle")))
  )
  private[this] lazy val controllers_DeliveryController_updateDeliveryHandle61_invoker = createInvoker(
    DeliveryController_2.updateDeliveryHandle,
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

  // @LINE:121
  private[this] lazy val controllers_DeliveryController_getDeliverys62_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("deliverys")))
  )
  private[this] lazy val controllers_DeliveryController_getDeliverys62_invoker = createInvoker(
    DeliveryController_2.getDeliverys,
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

  // @LINE:122
  private[this] lazy val controllers_DeliveryController_getDelivery63_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("delivery/"), DynamicPart("id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_DeliveryController_getDelivery63_invoker = createInvoker(
    DeliveryController_2.getDelivery(fakeValue[Long]),
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

  // @LINE:123
  private[this] lazy val controllers_DeliveryController_getDeliveryOrd64_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("deliveryord/"), DynamicPart("id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_DeliveryController_getDeliveryOrd64_invoker = createInvoker(
    DeliveryController_2.getDeliveryOrd(fakeValue[Long]),
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

  // @LINE:124
  private[this] lazy val controllers_DeliveryController_deleteDelivery65_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("deletedelivery/"), DynamicPart("id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_DeliveryController_deleteDelivery65_invoker = createInvoker(
    DeliveryController_2.deleteDelivery(fakeValue[Long]),
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

  // @LINE:128
  private[this] lazy val controllers_ReviewController_addReview66_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("addreview")))
  )
  private[this] lazy val controllers_ReviewController_addReview66_invoker = createInvoker(
    ReviewController_3.addReview,
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

  // @LINE:130
  private[this] lazy val controllers_ReviewController_addReviewHandle67_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("addreviewhandle")))
  )
  private[this] lazy val controllers_ReviewController_addReviewHandle67_invoker = createInvoker(
    ReviewController_3.addReviewHandle,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.ReviewController",
      "addReviewHandle",
      Nil,
      "POST",
      this.prefix + """addreviewhandle""",
      """""",
      Seq("""nocsrf""")
    )
  )

  // @LINE:131
  private[this] lazy val controllers_ReviewController_updateReview68_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("updatereview/"), DynamicPart("id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_ReviewController_updateReview68_invoker = createInvoker(
    ReviewController_3.updateReview(fakeValue[Int]),
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

  // @LINE:133
  private[this] lazy val controllers_ReviewController_updateReviewHandle69_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("updatereviewhandle")))
  )
  private[this] lazy val controllers_ReviewController_updateReviewHandle69_invoker = createInvoker(
    ReviewController_3.updateReviewHandle,
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

  // @LINE:135
  private[this] lazy val controllers_ReviewController_getReviews70_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("reviews")))
  )
  private[this] lazy val controllers_ReviewController_getReviews70_invoker = createInvoker(
    ReviewController_3.getReviews,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.ReviewController",
      "getReviews",
      Nil,
      "GET",
      this.prefix + """reviews""",
      """""",
      Seq()
    )
  )

  // @LINE:136
  private[this] lazy val controllers_ReviewController_getReview71_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("review/"), DynamicPart("id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_ReviewController_getReview71_invoker = createInvoker(
    ReviewController_3.getReview(fakeValue[Int]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.ReviewController",
      "getReview",
      Seq(classOf[Int]),
      "GET",
      this.prefix + """review/""" + "$" + """id<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:137
  private[this] lazy val controllers_ReviewController_deleteReview72_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("deletereview/"), DynamicPart("id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_ReviewController_deleteReview72_invoker = createInvoker(
    ReviewController_3.deleteReview(fakeValue[Int]),
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

  // @LINE:141
  private[this] lazy val controllers_CountController_count73_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("count")))
  )
  private[this] lazy val controllers_CountController_count73_invoker = createInvoker(
    CountController_6.count,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.CountController",
      "count",
      Nil,
      "GET",
      this.prefix + """count""",
      """ An example controller showing how to use dependency injection""",
      Seq()
    )
  )

  // @LINE:143
  private[this] lazy val controllers_AsyncController_message74_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("message")))
  )
  private[this] lazy val controllers_AsyncController_message74_invoker = createInvoker(
    AsyncController_11.message,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.AsyncController",
      "message",
      Nil,
      "GET",
      this.prefix + """message""",
      """ An example controller showing how to write asynchronous code""",
      Seq()
    )
  )

  // @LINE:146
  private[this] lazy val controllers_Assets_versioned75_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("assets/"), DynamicPart("file", """.+""",false)))
  )
  private[this] lazy val controllers_Assets_versioned75_invoker = createInvoker(
    Assets_10.versioned(fakeValue[String], fakeValue[Asset]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Assets",
      "versioned",
      Seq(classOf[String], classOf[Asset]),
      "GET",
      this.prefix + """assets/""" + "$" + """file<.+>""",
      """ Map static resources from the /public folder to the /assets URL path""",
      Seq()
    )
  )


  def routes: PartialFunction[RequestHeader, Handler] = {
  
    // @LINE:7
    case controllers_ProductController_index0_route(params@_) =>
      call { 
        controllers_ProductController_index0_invoker.call(ProductController_8.index)
      }
  
    // @LINE:8
    case controllers_ProductController_addProduct1_route(params@_) =>
      call { 
        controllers_ProductController_addProduct1_invoker.call(ProductController_8.addProduct)
      }
  
    // @LINE:10
    case controllers_ProductController_addProductHandle2_route(params@_) =>
      call { 
        controllers_ProductController_addProductHandle2_invoker.call(ProductController_8.addProductHandle)
      }
  
    // @LINE:11
    case controllers_ProductController_updateProduct3_route(params@_) =>
      call(params.fromPath[Long]("id", None)) { (id) =>
        controllers_ProductController_updateProduct3_invoker.call(ProductController_8.updateProduct(id))
      }
  
    // @LINE:13
    case controllers_ProductController_updateProductHandle4_route(params@_) =>
      call { 
        controllers_ProductController_updateProductHandle4_invoker.call(ProductController_8.updateProductHandle)
      }
  
    // @LINE:15
    case controllers_ProductController_getProducts5_route(params@_) =>
      call { 
        controllers_ProductController_getProducts5_invoker.call(ProductController_8.getProducts)
      }
  
    // @LINE:16
    case controllers_ProductController_getProduct6_route(params@_) =>
      call(params.fromPath[Long]("id", None)) { (id) =>
        controllers_ProductController_getProduct6_invoker.call(ProductController_8.getProduct(id))
      }
  
    // @LINE:17
    case controllers_ProductController_delete7_route(params@_) =>
      call(params.fromPath[Long]("id", None)) { (id) =>
        controllers_ProductController_delete7_invoker.call(ProductController_8.delete(id))
      }
  
    // @LINE:21
    case controllers_CategoryController_addCategory8_route(params@_) =>
      call { 
        controllers_CategoryController_addCategory8_invoker.call(CategoryController_5.addCategory)
      }
  
    // @LINE:23
    case controllers_CategoryController_addCategoryHandle9_route(params@_) =>
      call { 
        controllers_CategoryController_addCategoryHandle9_invoker.call(CategoryController_5.addCategoryHandle)
      }
  
    // @LINE:24
    case controllers_CategoryController_updateCategory10_route(params@_) =>
      call(params.fromPath[Int]("id", None)) { (id) =>
        controllers_CategoryController_updateCategory10_invoker.call(CategoryController_5.updateCategory(id))
      }
  
    // @LINE:26
    case controllers_CategoryController_updateCategoryHandle11_route(params@_) =>
      call { 
        controllers_CategoryController_updateCategoryHandle11_invoker.call(CategoryController_5.updateCategoryHandle)
      }
  
    // @LINE:28
    case controllers_CategoryController_getCategory12_route(params@_) =>
      call(params.fromPath[Int]("id", None)) { (id) =>
        controllers_CategoryController_getCategory12_invoker.call(CategoryController_5.getCategory(id))
      }
  
    // @LINE:29
    case controllers_CategoryController_getCategories13_route(params@_) =>
      call { 
        controllers_CategoryController_getCategories13_invoker.call(CategoryController_5.getCategories)
      }
  
    // @LINE:30
    case controllers_CategoryController_deleteCategory14_route(params@_) =>
      call(params.fromPath[Int]("id", None)) { (id) =>
        controllers_CategoryController_deleteCategory14_invoker.call(CategoryController_5.deleteCategory(id))
      }
  
    // @LINE:34
    case controllers_UserController_addUser15_route(params@_) =>
      call { 
        controllers_UserController_addUser15_invoker.call(UserController_9.addUser)
      }
  
    // @LINE:36
    case controllers_UserController_addUserHandle16_route(params@_) =>
      call { 
        controllers_UserController_addUserHandle16_invoker.call(UserController_9.addUserHandle)
      }
  
    // @LINE:37
    case controllers_UserController_updateUser17_route(params@_) =>
      call(params.fromPath[Long]("id", None)) { (id) =>
        controllers_UserController_updateUser17_invoker.call(UserController_9.updateUser(id))
      }
  
    // @LINE:39
    case controllers_UserController_updateUserHandle18_route(params@_) =>
      call { 
        controllers_UserController_updateUserHandle18_invoker.call(UserController_9.updateUserHandle)
      }
  
    // @LINE:41
    case controllers_UserController_getUser19_route(params@_) =>
      call(params.fromPath[Long]("id", None)) { (id) =>
        controllers_UserController_getUser19_invoker.call(UserController_9.getUser(id))
      }
  
    // @LINE:42
    case controllers_UserController_getUsers20_route(params@_) =>
      call { 
        controllers_UserController_getUsers20_invoker.call(UserController_9.getUsers)
      }
  
    // @LINE:43
    case controllers_UserController_deleteUser21_route(params@_) =>
      call(params.fromPath[Long]("id", None)) { (id) =>
        controllers_UserController_deleteUser21_invoker.call(UserController_9.deleteUser(id))
      }
  
    // @LINE:47
    case controllers_OrderController_addOrder22_route(params@_) =>
      call { 
        controllers_OrderController_addOrder22_invoker.call(OrderController_0.addOrder)
      }
  
    // @LINE:49
    case controllers_OrderController_addOrderHandle23_route(params@_) =>
      call { 
        controllers_OrderController_addOrderHandle23_invoker.call(OrderController_0.addOrderHandle)
      }
  
    // @LINE:50
    case controllers_OrderController_updateOrder24_route(params@_) =>
      call(params.fromPath[Long]("id", None)) { (id) =>
        controllers_OrderController_updateOrder24_invoker.call(OrderController_0.updateOrder(id))
      }
  
    // @LINE:52
    case controllers_OrderController_updateOrderHandle25_route(params@_) =>
      call { 
        controllers_OrderController_updateOrderHandle25_invoker.call(OrderController_0.updateOrderHandle)
      }
  
    // @LINE:54
    case controllers_OrderController_getOrders26_route(params@_) =>
      call { 
        controllers_OrderController_getOrders26_invoker.call(OrderController_0.getOrders)
      }
  
    // @LINE:55
    case controllers_OrderController_getOrder27_route(params@_) =>
      call(params.fromPath[Long]("id", None)) { (id) =>
        controllers_OrderController_getOrder27_invoker.call(OrderController_0.getOrder(id))
      }
  
    // @LINE:56
    case controllers_OrderController_getOrdersUsr28_route(params@_) =>
      call(params.fromPath[Long]("id", None)) { (id) =>
        controllers_OrderController_getOrdersUsr28_invoker.call(OrderController_0.getOrdersUsr(id))
      }
  
    // @LINE:57
    case controllers_OrderController_deleteOrder29_route(params@_) =>
      call(params.fromPath[Long]("id", None)) { (id) =>
        controllers_OrderController_deleteOrder29_invoker.call(OrderController_0.deleteOrder(id))
      }
  
    // @LINE:61
    case controllers_BasketController_addToBasket30_route(params@_) =>
      call(params.fromPath[Long]("id", None)) { (id) =>
        controllers_BasketController_addToBasket30_invoker.call(BasketController_4.addToBasket(id))
      }
  
    // @LINE:63
    case controllers_BasketController_updateBasket31_route(params@_) =>
      call(params.fromPath[Long]("id", None)) { (id) =>
        controllers_BasketController_updateBasket31_invoker.call(BasketController_4.updateBasket(id))
      }
  
    // @LINE:65
    case controllers_BasketController_updateBasketHandle32_route(params@_) =>
      call { 
        controllers_BasketController_updateBasketHandle32_invoker.call(BasketController_4.updateBasketHandle)
      }
  
    // @LINE:68
    case controllers_BasketController_deleteFromBasket33_route(params@_) =>
      call(params.fromPath[Long]("id", None)) { (id) =>
        controllers_BasketController_deleteFromBasket33_invoker.call(BasketController_4.deleteFromBasket(id))
      }
  
    // @LINE:72
    case controllers_PaymentController_addPayment34_route(params@_) =>
      call { 
        controllers_PaymentController_addPayment34_invoker.call(PaymentController_7.addPayment)
      }
  
    // @LINE:74
    case controllers_PaymentController_addPaymentHandle35_route(params@_) =>
      call { 
        controllers_PaymentController_addPaymentHandle35_invoker.call(PaymentController_7.addPaymentHandle)
      }
  
    // @LINE:75
    case controllers_PaymentController_updatePayment36_route(params@_) =>
      call(params.fromPath[Long]("id", None)) { (id) =>
        controllers_PaymentController_updatePayment36_invoker.call(PaymentController_7.updatePayment(id))
      }
  
    // @LINE:77
    case controllers_PaymentController_updatePaymentHandle37_route(params@_) =>
      call { 
        controllers_PaymentController_updatePaymentHandle37_invoker.call(PaymentController_7.updatePaymentHandle)
      }
  
    // @LINE:79
    case controllers_PaymentController_getPayment38_route(params@_) =>
      call(params.fromPath[Long]("id", None)) { (id) =>
        controllers_PaymentController_getPayment38_invoker.call(PaymentController_7.getPayment(id))
      }
  
    // @LINE:80
    case controllers_PaymentController_getPayments39_route(params@_) =>
      call { 
        controllers_PaymentController_getPayments39_invoker.call(PaymentController_7.getPayments)
      }
  
    // @LINE:81
    case controllers_PaymentController_getPaymentOrd40_route(params@_) =>
      call(params.fromPath[Long]("id", None)) { (id) =>
        controllers_PaymentController_getPaymentOrd40_invoker.call(PaymentController_7.getPaymentOrd(id))
      }
  
    // @LINE:82
    case controllers_PaymentController_deletePayment41_route(params@_) =>
      call(params.fromPath[Long]("id", None)) { (id) =>
        controllers_PaymentController_deletePayment41_invoker.call(PaymentController_7.deletePayment(id))
      }
  
    // @LINE:86
    case controllers_QuestionController_addQuestion42_route(params@_) =>
      call { 
        controllers_QuestionController_addQuestion42_invoker.call(QuestionController_1.addQuestion)
      }
  
    // @LINE:88
    case controllers_QuestionController_addQuestionHandle43_route(params@_) =>
      call { 
        controllers_QuestionController_addQuestionHandle43_invoker.call(QuestionController_1.addQuestionHandle)
      }
  
    // @LINE:89
    case controllers_QuestionController_updateQuestion44_route(params@_) =>
      call(params.fromPath[Int]("id", None)) { (id) =>
        controllers_QuestionController_updateQuestion44_invoker.call(QuestionController_1.updateQuestion(id))
      }
  
    // @LINE:91
    case controllers_QuestionController_updateQuestionHandle45_route(params@_) =>
      call { 
        controllers_QuestionController_updateQuestionHandle45_invoker.call(QuestionController_1.updateQuestionHandle)
      }
  
    // @LINE:93
    case controllers_QuestionController_getQuestions46_route(params@_) =>
      call { 
        controllers_QuestionController_getQuestions46_invoker.call(QuestionController_1.getQuestions)
      }
  
    // @LINE:94
    case controllers_QuestionController_getQuestion47_route(params@_) =>
      call(params.fromPath[Int]("id", None)) { (id) =>
        controllers_QuestionController_getQuestion47_invoker.call(QuestionController_1.getQuestion(id))
      }
  
    // @LINE:95
    case controllers_QuestionController_getQuestionProd48_route(params@_) =>
      call(params.fromPath[Long]("id", None)) { (id) =>
        controllers_QuestionController_getQuestionProd48_invoker.call(QuestionController_1.getQuestionProd(id))
      }
  
    // @LINE:96
    case controllers_QuestionController_deleteQuestion49_route(params@_) =>
      call(params.fromPath[Int]("id", None)) { (id) =>
        controllers_QuestionController_deleteQuestion49_invoker.call(QuestionController_1.deleteQuestion(id))
      }
  
    // @LINE:100
    case controllers_DiscountController_addDiscount50_route(params@_) =>
      call(params.fromPath[Long]("product_id", None)) { (product_id) =>
        controllers_DiscountController_addDiscount50_invoker.call(DiscountController_12.addDiscount(product_id))
      }
  
    // @LINE:102
    case controllers_DiscountController_addDiscountHandle51_route(params@_) =>
      call { 
        controllers_DiscountController_addDiscountHandle51_invoker.call(DiscountController_12.addDiscountHandle)
      }
  
    // @LINE:103
    case controllers_DiscountController_updateDiscount52_route(params@_) =>
      call(params.fromPath[Long]("id", None)) { (id) =>
        controllers_DiscountController_updateDiscount52_invoker.call(DiscountController_12.updateDiscount(id))
      }
  
    // @LINE:105
    case controllers_DiscountController_updateDiscountHandle53_route(params@_) =>
      call { 
        controllers_DiscountController_updateDiscountHandle53_invoker.call(DiscountController_12.updateDiscountHandle)
      }
  
    // @LINE:107
    case controllers_DiscountController_getDiscounts54_route(params@_) =>
      call { 
        controllers_DiscountController_getDiscounts54_invoker.call(DiscountController_12.getDiscounts)
      }
  
    // @LINE:108
    case controllers_DiscountController_getDiscountpr55_route(params@_) =>
      call(params.fromPath[Long]("id", None)) { (id) =>
        controllers_DiscountController_getDiscountpr55_invoker.call(DiscountController_12.getDiscountpr(id))
      }
  
    // @LINE:109
    case controllers_DiscountController_getDiscount56_route(params@_) =>
      call(params.fromPath[Long]("id", None)) { (id) =>
        controllers_DiscountController_getDiscount56_invoker.call(DiscountController_12.getDiscount(id))
      }
  
    // @LINE:110
    case controllers_DiscountController_deleteDiscount57_route(params@_) =>
      call(params.fromPath[Long]("id", None)) { (id) =>
        controllers_DiscountController_deleteDiscount57_invoker.call(DiscountController_12.deleteDiscount(id))
      }
  
    // @LINE:114
    case controllers_DeliveryController_addDelivery58_route(params@_) =>
      call { 
        controllers_DeliveryController_addDelivery58_invoker.call(DeliveryController_2.addDelivery)
      }
  
    // @LINE:116
    case controllers_DeliveryController_addDeliveryHandle59_route(params@_) =>
      call { 
        controllers_DeliveryController_addDeliveryHandle59_invoker.call(DeliveryController_2.addDeliveryHandle)
      }
  
    // @LINE:117
    case controllers_DeliveryController_updateDelivery60_route(params@_) =>
      call(params.fromPath[Long]("id", None)) { (id) =>
        controllers_DeliveryController_updateDelivery60_invoker.call(DeliveryController_2.updateDelivery(id))
      }
  
    // @LINE:119
    case controllers_DeliveryController_updateDeliveryHandle61_route(params@_) =>
      call { 
        controllers_DeliveryController_updateDeliveryHandle61_invoker.call(DeliveryController_2.updateDeliveryHandle)
      }
  
    // @LINE:121
    case controllers_DeliveryController_getDeliverys62_route(params@_) =>
      call { 
        controllers_DeliveryController_getDeliverys62_invoker.call(DeliveryController_2.getDeliverys)
      }
  
    // @LINE:122
    case controllers_DeliveryController_getDelivery63_route(params@_) =>
      call(params.fromPath[Long]("id", None)) { (id) =>
        controllers_DeliveryController_getDelivery63_invoker.call(DeliveryController_2.getDelivery(id))
      }
  
    // @LINE:123
    case controllers_DeliveryController_getDeliveryOrd64_route(params@_) =>
      call(params.fromPath[Long]("id", None)) { (id) =>
        controllers_DeliveryController_getDeliveryOrd64_invoker.call(DeliveryController_2.getDeliveryOrd(id))
      }
  
    // @LINE:124
    case controllers_DeliveryController_deleteDelivery65_route(params@_) =>
      call(params.fromPath[Long]("id", None)) { (id) =>
        controllers_DeliveryController_deleteDelivery65_invoker.call(DeliveryController_2.deleteDelivery(id))
      }
  
    // @LINE:128
    case controllers_ReviewController_addReview66_route(params@_) =>
      call { 
        controllers_ReviewController_addReview66_invoker.call(ReviewController_3.addReview)
      }
  
    // @LINE:130
    case controllers_ReviewController_addReviewHandle67_route(params@_) =>
      call { 
        controllers_ReviewController_addReviewHandle67_invoker.call(ReviewController_3.addReviewHandle)
      }
  
    // @LINE:131
    case controllers_ReviewController_updateReview68_route(params@_) =>
      call(params.fromPath[Int]("id", None)) { (id) =>
        controllers_ReviewController_updateReview68_invoker.call(ReviewController_3.updateReview(id))
      }
  
    // @LINE:133
    case controllers_ReviewController_updateReviewHandle69_route(params@_) =>
      call { 
        controllers_ReviewController_updateReviewHandle69_invoker.call(ReviewController_3.updateReviewHandle)
      }
  
    // @LINE:135
    case controllers_ReviewController_getReviews70_route(params@_) =>
      call { 
        controllers_ReviewController_getReviews70_invoker.call(ReviewController_3.getReviews)
      }
  
    // @LINE:136
    case controllers_ReviewController_getReview71_route(params@_) =>
      call(params.fromPath[Int]("id", None)) { (id) =>
        controllers_ReviewController_getReview71_invoker.call(ReviewController_3.getReview(id))
      }
  
    // @LINE:137
    case controllers_ReviewController_deleteReview72_route(params@_) =>
      call(params.fromPath[Int]("id", None)) { (id) =>
        controllers_ReviewController_deleteReview72_invoker.call(ReviewController_3.deleteReview(id))
      }
  
    // @LINE:141
    case controllers_CountController_count73_route(params@_) =>
      call { 
        controllers_CountController_count73_invoker.call(CountController_6.count)
      }
  
    // @LINE:143
    case controllers_AsyncController_message74_route(params@_) =>
      call { 
        controllers_AsyncController_message74_invoker.call(AsyncController_11.message)
      }
  
    // @LINE:146
    case controllers_Assets_versioned75_route(params@_) =>
      call(Param[String]("path", Right("/public")), params.fromPath[Asset]("file", None)) { (path, file) =>
        controllers_Assets_versioned75_invoker.call(Assets_10.versioned(path, file))
      }
  }
}
