// @GENERATOR:play-routes-compiler
// @SOURCE:/home/paul/ebiznes/conf/routes
// @DATE:Fri Aug 28 21:55:45 MSK 2020

import play.api.mvc.Call


import _root_.controllers.Assets.Asset
import _root_.utils.route.Binders._

// @LINE:6
package controllers {

  // @LINE:134
  class ReverseDiscountController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:137
    def updateDiscount(id:Long): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "updatediscount/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[Long]].unbind("id", id)))
    }
  
    // @LINE:139
    def updateDiscountHandle(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "updatediscounthandle")
    }
  
    // @LINE:141
    def getDiscounts(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "discounts")
    }
  
    // @LINE:143
    def getDiscount(id:Long): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "discount/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[Long]].unbind("id", id)))
    }
  
    // @LINE:144
    def deleteDiscount(id:Long): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "deletediscount/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[Long]].unbind("id", id)))
    }
  
    // @LINE:136
    def addDiscountHandle(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "adddiscounthandle")
    }
  
    // @LINE:142
    def getDiscountpr(id:Long): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "discountpr/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[Long]].unbind("id", id)))
    }
  
    // @LINE:134
    def addDiscount(product_id:Long): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "adddiscount/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[Long]].unbind("product_id", product_id)))
    }
  
  }

  // @LINE:175
  class ReverseAssets(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:175
    def versioned(file:String): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "assets/" + implicitly[play.api.mvc.PathBindable[String]].unbind("file", file))
    }
  
  }

  // @LINE:13
  class ReverseSignInController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:13
    def view(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "signIn")
    }
  
    // @LINE:14
    def submit(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "signIn")
    }
  
  }

  // @LINE:16
  class ReverseTotpController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:20
    def enableTotpSubmit(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "enableTotpSubmit")
    }
  
    // @LINE:19
    def submit(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "totpSubmit")
    }
  
    // @LINE:17
    def enableTotp(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "enableTotp")
    }
  
    // @LINE:18
    def disableTotp(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "disableTotp")
    }
  
    // @LINE:16
    def view(userId:java.util.UUID, sharedKey:String, rememberMe:Boolean): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "totp" + play.core.routing.queryString(List(Some(implicitly[play.api.mvc.QueryStringBindable[java.util.UUID]].unbind("userId", userId)), Some(implicitly[play.api.mvc.QueryStringBindable[String]].unbind("sharedKey", sharedKey)), Some(implicitly[play.api.mvc.QueryStringBindable[Boolean]].unbind("rememberMe", rememberMe)))))
    }
  
  }

  // @LINE:22
  class ReverseTotpRecoveryController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:23
    def submit(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "totpRecoverySubmit")
    }
  
    // @LINE:22
    def view(userID:java.util.UUID, sharedKey:String, rememberMe:Boolean): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "totpRecovery" + play.core.routing.queryString(List(Some(implicitly[play.api.mvc.QueryStringBindable[java.util.UUID]].unbind("userID", userID)), Some(implicitly[play.api.mvc.QueryStringBindable[String]].unbind("sharedKey", sharedKey)), Some(implicitly[play.api.mvc.QueryStringBindable[Boolean]].unbind("rememberMe", rememberMe)))))
    }
  
  }

  // @LINE:8
  class ReverseSocialAuthController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:8
    def authenticate(provider:String): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "authenticate/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("provider", provider)))
    }
  
  }

  // @LINE:27
  class ReverseResetPasswordController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:28
    def submit(token:java.util.UUID): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "password/reset/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[java.util.UUID]].unbind("token", token)))
    }
  
    // @LINE:27
    def view(token:java.util.UUID): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "password/reset/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[java.util.UUID]].unbind("token", token)))
    }
  
  }

  // @LINE:6
  class ReverseApplicationController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:7
    def signOut(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "signOut")
    }
  
    // @LINE:6
    def index(): Call = {
      
      Call("GET", _prefix)
    }
  
  }

  // @LINE:106
  class ReversePaymentController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:106
    def addPayment(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "addpayment")
    }
  
    // @LINE:116
    def deletePayment(id:Long): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "deletepayment/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[Long]].unbind("id", id)))
    }
  
    // @LINE:114
    def getPayments(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "payments")
    }
  
    // @LINE:108
    def addPaymentHandle(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "addpaymenthandle")
    }
  
    // @LINE:115
    def getPaymentOrd(id:Long): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "paymentord/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[Long]].unbind("id", id)))
    }
  
    // @LINE:109
    def updatePayment(id:Long): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "updatepayment/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[Long]].unbind("id", id)))
    }
  
    // @LINE:113
    def getPayment(id:Long): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "payment/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[Long]].unbind("id", id)))
    }
  
    // @LINE:111
    def updatePaymentHandle(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "updatepaymenthandle")
    }
  
  }

  // @LINE:32
  class ReverseActivateAccountController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:33
    def activate(token:java.util.UUID): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "account/activate/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[java.util.UUID]].unbind("token", token)))
    }
  
    // @LINE:32
    def send(email:String): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "account/email/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("email", email)))
    }
  
  }

  // @LINE:54
  class ReverseCategoryController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:57
    def updateCategory(id:Int): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "updatecategory/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[Int]].unbind("id", id)))
    }
  
    // @LINE:54
    def addCategory(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "addcategory")
    }
  
    // @LINE:62
    def getCategories(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "categories")
    }
  
    // @LINE:56
    def addCategoryHandle(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "addcategory")
    }
  
    // @LINE:59
    def updateCategoryHandle(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "updatecategoryhandle")
    }
  
    // @LINE:61
    def getCategory(id:Int): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "category/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[Int]].unbind("id", id)))
    }
  
    // @LINE:63
    def deleteCategory(id:Int): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "deletecategory/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[Int]].unbind("id", id)))
    }
  
  }

  // @LINE:40
  class ReverseProductController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:48
    def getProductsByCat(category:Int): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "products/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[Int]].unbind("category", category)))
    }
  
    // @LINE:50
    def delete(id:Long): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "delete/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[Long]].unbind("id", id)))
    }
  
    // @LINE:49
    def getProduct(id:Long): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "product/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[Long]].unbind("id", id)))
    }
  
    // @LINE:47
    def getProducts(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "products")
    }
  
    // @LINE:45
    def updateProductHandle(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "updateproducthandle")
    }
  
    // @LINE:42
    def addProductHandle(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "addproducthandle")
    }
  
    // @LINE:43
    def updateProduct(id:Long): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "updateproduct/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[Long]].unbind("id", id)))
    }
  
    // @LINE:40
    def addProduct(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "addproduct")
    }
  
  }

  // @LINE:162
  class ReverseReviewController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:170
    def review(productid:Long): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "review/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[Long]].unbind("productid", productid)))
    }
  
    // @LINE:164
    def addReviewHandle(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "addreviewhandle")
    }
  
    // @LINE:167
    def updateReviewHandle(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "updatereviewhandle")
    }
  
    // @LINE:171
    def deleteReview(id:Int): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "deletereview/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[Int]].unbind("id", id)))
    }
  
    // @LINE:162
    def addReview(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "addreview")
    }
  
    // @LINE:165
    def updateReview(id:Int): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "updatereview/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[Int]].unbind("id", id)))
    }
  
  }

  // @LINE:148
  class ReverseDeliveryController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:148
    def addDelivery(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "adddelivery")
    }
  
    // @LINE:151
    def updateDelivery(id:Long): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "updatedelivery/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[Long]].unbind("id", id)))
    }
  
    // @LINE:156
    def getDelivery(id:Long): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "delivery/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[Long]].unbind("id", id)))
    }
  
    // @LINE:158
    def deleteDelivery(id:Long): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "deletedelivery/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[Long]].unbind("id", id)))
    }
  
    // @LINE:150
    def addDeliveryHandle(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "adddeliveryhandle")
    }
  
    // @LINE:155
    def getDeliverys(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "deliverys")
    }
  
    // @LINE:157
    def getDeliveryOrd(id:Long): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "deliveryord/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[Long]].unbind("id", id)))
    }
  
    // @LINE:153
    def updateDeliveryHandle(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "updatedeliveryhandle")
    }
  
  }

  // @LINE:25
  class ReverseForgotPasswordController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:25
    def view(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "password/forgot")
    }
  
    // @LINE:26
    def submit(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "password/forgot")
    }
  
  }

  // @LINE:67
  class ReverseUserController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:69
    def addUserHandle(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "adduserhandle")
    }
  
    // @LINE:67
    def addUser(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "adduser")
    }
  
    // @LINE:74
    def getUser(id:Long): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "user/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[Long]].unbind("id", id)))
    }
  
    // @LINE:70
    def updateUser(id:Long): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "updateuser/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[Long]].unbind("id", id)))
    }
  
    // @LINE:75
    def getUsers(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "users")
    }
  
    // @LINE:76
    def deleteUser(id:Long): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "deleteuser/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[Long]].unbind("id", id)))
    }
  
    // @LINE:72
    def updateUserHandle(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "updateuserhandle")
    }
  
  }

  // @LINE:29
  class ReverseChangePasswordController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:29
    def view(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "password/change")
    }
  
    // @LINE:30
    def submit(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "password/change")
    }
  
  }

  // @LINE:120
  class ReverseFavoritesController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:120
    def addFavorites(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "addfavorites")
    }
  
    // @LINE:122
    def addFavoritesHandle(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "addfavoriteshandle")
    }
  
    // @LINE:130
    def deleteFavorites(id:Int): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "deletefavorites/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[Int]].unbind("id", id)))
    }
  
    // @LINE:128
    def getFavorit(id:Int): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "favorit/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[Int]].unbind("id", id)))
    }
  
    // @LINE:125
    def updateFavoritesHandle(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "updatefavoriteshandle")
    }
  
    // @LINE:129
    def getFavoritesUsr(id:Long): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "favoritesusr/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[Long]].unbind("id", id)))
    }
  
    // @LINE:123
    def updateFavorites(id:Int): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "updatefavorites/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[Int]].unbind("id", id)))
    }
  
    // @LINE:127
    def getFavorites(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "favorites")
    }
  
  }

  // @LINE:80
  class ReverseOrderController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:90
    def deleteOrder(id:Long): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "deleteorder/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[Long]].unbind("id", id)))
    }
  
    // @LINE:82
    def addOrderHandle(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "addorderhandle")
    }
  
    // @LINE:85
    def updateOrderHandle(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "updateorderhandle")
    }
  
    // @LINE:80
    def addOrder(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "addorder")
    }
  
    // @LINE:87
    def getOrders(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "orders")
    }
  
    // @LINE:88
    def getOrder(id:Long): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "order/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[Long]].unbind("id", id)))
    }
  
    // @LINE:83
    def updateOrder(id:Long): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "updateorder/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[Long]].unbind("id", id)))
    }
  
    // @LINE:89
    def getOrdersUsr(id:Long): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "ordersusr/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[Long]].unbind("id", id)))
    }
  
  }

  // @LINE:94
  class ReverseBasketController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:99
    def updateBasketHandle(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "updatebaskethandle")
    }
  
    // @LINE:97
    def updateBasket(id:Long): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "updatebasket/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[Long]].unbind("id", id)))
    }
  
    // @LINE:94
    def addToBasket(id:Long): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "addtobasket/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[Long]].unbind("id", id)))
    }
  
    // @LINE:102
    def deleteFromBasket(id:Long): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "deletefrombasket/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[Long]].unbind("id", id)))
    }
  
  }

  // @LINE:10
  class ReverseSignUpController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:10
    def view(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "signUp")
    }
  
    // @LINE:11
    def submit(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "signUp")
    }
  
  }


}
