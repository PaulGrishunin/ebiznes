// @GENERATOR:play-routes-compiler
// @SOURCE:/home/paul/ebiznes/conf/routes
// @DATE:Mon Aug 17 23:07:44 MSK 2020

import play.api.mvc.Call


import _root_.controllers.Assets.Asset

// @LINE:7
package controllers {

  // @LINE:102
  class ReverseDiscountController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:105
    def updateDiscount(id:Long): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "updatediscount/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[Long]].unbind("id", id)))
    }
  
    // @LINE:107
    def updateDiscountHandle(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "updatediscounthandle")
    }
  
    // @LINE:109
    def getDiscounts(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "discounts")
    }
  
    // @LINE:111
    def getDiscount(id:Long): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "discount/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[Long]].unbind("id", id)))
    }
  
    // @LINE:112
    def deleteDiscount(id:Long): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "deletediscount/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[Long]].unbind("id", id)))
    }
  
    // @LINE:104
    def addDiscountHandle(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "adddiscounthandle")
    }
  
    // @LINE:110
    def getDiscountpr(id:Long): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "discountpr/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[Long]].unbind("id", id)))
    }
  
    // @LINE:102
    def addDiscount(product_id:Long): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "adddiscount/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[Long]].unbind("product_id", product_id)))
    }
  
  }

  // @LINE:148
  class ReverseAssets(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:148
    def versioned(file:Asset): Call = {
      implicit lazy val _rrc = new play.core.routing.ReverseRouteContext(Map(("path", "/public"))); _rrc
      Call("GET", _prefix + { _defaultPrefix } + "assets/" + implicitly[play.api.mvc.PathBindable[Asset]].unbind("file", file))
    }
  
  }

  // @LINE:143
  class ReverseCountController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:143
    def count(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "count")
    }
  
  }

  // @LINE:74
  class ReversePaymentController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:74
    def addPayment(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "addpayment")
    }
  
    // @LINE:84
    def deletePayment(id:Long): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "deletepayment/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[Long]].unbind("id", id)))
    }
  
    // @LINE:82
    def getPayments(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "payments")
    }
  
    // @LINE:76
    def addPaymentHandle(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "addpaymenthandle")
    }
  
    // @LINE:83
    def getPaymentOrd(id:Long): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "paymentord/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[Long]].unbind("id", id)))
    }
  
    // @LINE:77
    def updatePayment(id:Long): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "updatepayment/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[Long]].unbind("id", id)))
    }
  
    // @LINE:81
    def getPayment(id:Long): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "payment/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[Long]].unbind("id", id)))
    }
  
    // @LINE:79
    def updatePaymentHandle(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "updatepaymenthandle")
    }
  
  }

  // @LINE:22
  class ReverseCategoryController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:25
    def updateCategory(id:Int): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "updatecategory/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[Int]].unbind("id", id)))
    }
  
    // @LINE:22
    def addCategory(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "addcategory")
    }
  
    // @LINE:30
    def getCategories(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "categories")
    }
  
    // @LINE:24
    def addCategoryHandle(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "addcategory")
    }
  
    // @LINE:27
    def updateCategoryHandle(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "updatecategoryhandle")
    }
  
    // @LINE:29
    def getCategory(id:Int): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "category/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[Int]].unbind("id", id)))
    }
  
    // @LINE:31
    def deleteCategory(id:Int): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "deletecategory/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[Int]].unbind("id", id)))
    }
  
  }

  // @LINE:88
  class ReverseQuestionController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:95
    def getQuestions(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "questions")
    }
  
    // @LINE:96
    def getQuestion(id:Int): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "question/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[Int]].unbind("id", id)))
    }
  
    // @LINE:90
    def addQuestionHandle(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "addquestionhandle")
    }
  
    // @LINE:93
    def updateQuestionHandle(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "updatequestionhandle")
    }
  
    // @LINE:91
    def updateQuestion(id:Int): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "updatequestion/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[Int]].unbind("id", id)))
    }
  
    // @LINE:98
    def deleteQuestion(id:Int): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "deletequestion/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[Int]].unbind("id", id)))
    }
  
    // @LINE:88
    def addQuestion(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "addquestion")
    }
  
    // @LINE:97
    def getQuestionProd(id:Long): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "questionprod/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[Long]].unbind("id", id)))
    }
  
  }

  // @LINE:7
  class ReverseProductController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:16
    def getProductsByCat(category:Int): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "products/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[Int]].unbind("category", category)))
    }
  
    // @LINE:18
    def delete(id:Long): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "delete/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[Long]].unbind("id", id)))
    }
  
    // @LINE:17
    def getProduct(id:Long): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "product/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[Long]].unbind("id", id)))
    }
  
    // @LINE:15
    def getProducts(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "products")
    }
  
    // @LINE:13
    def updateProductHandle(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "updateproducthandle")
    }
  
    // @LINE:10
    def addProductHandle(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "addproducthandle")
    }
  
    // @LINE:11
    def updateProduct(id:Long): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "updateproduct/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[Long]].unbind("id", id)))
    }
  
    // @LINE:8
    def addProduct(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "addproduct")
    }
  
    // @LINE:7
    def index(): Call = {
      
      Call("GET", _prefix)
    }
  
  }

  // @LINE:130
  class ReverseReviewController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:132
    def addReviewHandle(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "addreviewhandle")
    }
  
    // @LINE:137
    def getReviews(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "reviews")
    }
  
    // @LINE:135
    def updateReviewHandle(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "updatereviewhandle")
    }
  
    // @LINE:138
    def getReview(id:Int): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "review/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[Int]].unbind("id", id)))
    }
  
    // @LINE:139
    def deleteReview(id:Int): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "deletereview/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[Int]].unbind("id", id)))
    }
  
    // @LINE:130
    def addReview(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "addreview")
    }
  
    // @LINE:133
    def updateReview(id:Int): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "updatereview/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[Int]].unbind("id", id)))
    }
  
  }

  // @LINE:116
  class ReverseDeliveryController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:116
    def addDelivery(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "adddelivery")
    }
  
    // @LINE:119
    def updateDelivery(id:Long): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "updatedelivery/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[Long]].unbind("id", id)))
    }
  
    // @LINE:124
    def getDelivery(id:Long): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "delivery/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[Long]].unbind("id", id)))
    }
  
    // @LINE:126
    def deleteDelivery(id:Long): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "deletedelivery/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[Long]].unbind("id", id)))
    }
  
    // @LINE:118
    def addDeliveryHandle(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "adddeliveryhandle")
    }
  
    // @LINE:123
    def getDeliverys(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "deliverys")
    }
  
    // @LINE:125
    def getDeliveryOrd(id:Long): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "deliveryord/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[Long]].unbind("id", id)))
    }
  
    // @LINE:121
    def updateDeliveryHandle(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "updatedeliveryhandle")
    }
  
  }

  // @LINE:35
  class ReverseUserController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:37
    def addUserHandle(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "adduserhandle")
    }
  
    // @LINE:35
    def addUser(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "adduser")
    }
  
    // @LINE:42
    def getUser(id:Long): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "user/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[Long]].unbind("id", id)))
    }
  
    // @LINE:38
    def updateUser(id:Long): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "updateuser/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[Long]].unbind("id", id)))
    }
  
    // @LINE:43
    def getUsers(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "users")
    }
  
    // @LINE:44
    def deleteUser(id:Long): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "deleteuser/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[Long]].unbind("id", id)))
    }
  
    // @LINE:40
    def updateUserHandle(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "updateuserhandle")
    }
  
  }

  // @LINE:145
  class ReverseAsyncController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:145
    def message(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "message")
    }
  
  }

  // @LINE:48
  class ReverseOrderController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:58
    def deleteOrder(id:Long): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "deleteorder/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[Long]].unbind("id", id)))
    }
  
    // @LINE:50
    def addOrderHandle(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "addorderhandle")
    }
  
    // @LINE:53
    def updateOrderHandle(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "updateorderhandle")
    }
  
    // @LINE:48
    def addOrder(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "addorder")
    }
  
    // @LINE:55
    def getOrders(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "orders")
    }
  
    // @LINE:56
    def getOrder(id:Long): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "order/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[Long]].unbind("id", id)))
    }
  
    // @LINE:51
    def updateOrder(id:Long): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "updateorder/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[Long]].unbind("id", id)))
    }
  
    // @LINE:57
    def getOrdersUsr(id:Long): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "orderusr/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[Long]].unbind("id", id)))
    }
  
  }

  // @LINE:62
  class ReverseBasketController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:67
    def updateBasketHandle(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "updatebaskethandle")
    }
  
    // @LINE:65
    def updateBasket(id:Long): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "updatebasket/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[Long]].unbind("id", id)))
    }
  
    // @LINE:62
    def addToBasket(id:Long): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "addtobasket/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[Long]].unbind("id", id)))
    }
  
    // @LINE:70
    def deleteFromBasket(id:Long): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "deletefrombasket/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[Long]].unbind("id", id)))
    }
  
  }


}
