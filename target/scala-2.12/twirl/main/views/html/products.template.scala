
package views.html

import _root_.play.twirl.api.TwirlFeatureImports._
import _root_.play.twirl.api.TwirlHelperImports._
import _root_.play.twirl.api.Html
import _root_.play.twirl.api.JavaScript
import _root_.play.twirl.api.Txt
import _root_.play.twirl.api.Xml
import models._
import controllers._
import play.api.i18n._
import views.html._
import play.api.templates.PlayMagic._
import play.api.mvc._
import play.api.data._

object products extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template1[Seq[Product],play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(products: Seq[Product]):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*2.1*/("""
"""),_display_(/*3.2*/for(product <- products) yield /*3.26*/ {_display_(Seq[Any](format.raw/*3.28*/("""
  """),format.raw/*4.3*/("""<b>"""),_display_(/*4.7*/product/*4.14*/.name),format.raw/*4.19*/("""</b>
  """),_display_(/*5.4*/product/*5.11*/.description),format.raw/*5.23*/("""
  """),_display_(/*6.4*/product/*6.11*/.category),format.raw/*6.20*/("""
  """),_display_(/*7.4*/product/*7.11*/.price),format.raw/*7.17*/("""
  """),format.raw/*8.3*/("""<a href=""""),_display_(/*8.13*/controllers/*8.24*/.routes.ProductController.updateProduct(product.id)),format.raw/*8.75*/("""">Edit</a>
  <a href=""""),_display_(/*9.13*/controllers/*9.24*/.routes.ProductController.delete(product.id)),format.raw/*9.68*/("""">Delete</a>
""")))}),format.raw/*10.2*/("""
"""))
      }
    }
  }

  def render(products:Seq[Product]): play.twirl.api.HtmlFormat.Appendable = apply(products)

  def f:((Seq[Product]) => play.twirl.api.HtmlFormat.Appendable) = (products) => apply(products)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: 2020-08-05T00:34:39.570376
                  SOURCE: /home/paul/ebiznes/app/views/products.scala.html
                  HASH: bd5e9eb8d7fe096c37cc88ceabfdac93c6ae75aa
                  MATRIX: 738->1|856->26|883->28|922->52|961->54|990->57|1019->61|1034->68|1059->73|1092->81|1107->88|1139->100|1168->104|1183->111|1212->120|1241->124|1256->131|1282->137|1311->140|1347->150|1366->161|1437->212|1486->235|1505->246|1569->290|1613->304
                  LINES: 21->1|26->2|27->3|27->3|27->3|28->4|28->4|28->4|28->4|29->5|29->5|29->5|30->6|30->6|30->6|31->7|31->7|31->7|32->8|32->8|32->8|32->8|33->9|33->9|33->9|34->10
                  -- GENERATED --
              */
          