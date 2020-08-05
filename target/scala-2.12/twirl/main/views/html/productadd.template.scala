
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

object productadd extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template4[Form[CreateProductForm],Seq[Category],MessagesRequestHeader,Flash,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(product: Form[CreateProductForm],category: Seq[Category])(implicit request: MessagesRequestHeader, flash: Flash):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {
/*3.2*/import helper._


Seq[Any](format.raw/*2.1*/("""
"""),format.raw/*4.1*/("""
"""),_display_(/*5.2*/flash/*5.7*/.get("success").getOrElse("")),format.raw/*5.36*/("""

"""),_display_(/*7.2*/form(routes.ProductController.addProductHandle())/*7.51*/ {_display_(Seq[Any](format.raw/*7.53*/("""
  """),_display_(/*8.4*/helper/*8.10*/.CSRF.formField),format.raw/*8.25*/("""
  """),_display_(/*9.4*/inputText(product("name"))),format.raw/*9.30*/("""
  """),_display_(/*10.4*/inputText(product("description"))),format.raw/*10.37*/("""

  """),format.raw/*12.3*/("""<select name="category" id="category">
  """),_display_(/*13.4*/for(cat <- category) yield /*13.24*/{_display_(Seq[Any](format.raw/*13.25*/("""
    """),format.raw/*14.5*/("""<option value=""""),_display_(/*14.21*/cat/*14.24*/.id),format.raw/*14.27*/("""">"""),_display_(/*14.30*/cat/*14.33*/.name),format.raw/*14.38*/("""</option>
  """)))}),format.raw/*15.4*/("""
  """),format.raw/*16.3*/("""</select>

  """),_display_(/*18.4*/inputText(product("price"))),format.raw/*18.31*/("""

  """),format.raw/*20.3*/("""<div class="buttons">
    <input type="submit" value="Add Product"/>
  </div>
""")))}),format.raw/*23.2*/("""
  """),format.raw/*24.3*/("""https://github.com/kprzystalski/ebiznes
"""))
      }
    }
  }

  def render(product:Form[CreateProductForm],category:Seq[Category],request:MessagesRequestHeader,flash:Flash): play.twirl.api.HtmlFormat.Appendable = apply(product,category)(request,flash)

  def f:((Form[CreateProductForm],Seq[Category]) => (MessagesRequestHeader,Flash) => play.twirl.api.HtmlFormat.Appendable) = (product,category) => (request,flash) => apply(product,category)(request,flash)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: 2020-08-05T00:34:40.020861
                  SOURCE: /home/paul/ebiznes/app/views/productadd.scala.html
                  HASH: fa5ed06bb550a9ee8c94d86419d2fc3406e3a250
                  MATRIX: 793->1|979->117|1023->115|1050->133|1077->135|1089->140|1138->169|1166->172|1223->221|1262->223|1291->227|1305->233|1340->248|1369->252|1415->278|1445->282|1499->315|1530->319|1598->361|1634->381|1673->382|1705->387|1748->403|1760->406|1784->409|1814->412|1826->415|1852->420|1895->433|1925->436|1965->450|2013->477|2044->481|2153->560|2183->563
                  LINES: 21->1|24->3|27->2|28->4|29->5|29->5|29->5|31->7|31->7|31->7|32->8|32->8|32->8|33->9|33->9|34->10|34->10|36->12|37->13|37->13|37->13|38->14|38->14|38->14|38->14|38->14|38->14|38->14|39->15|40->16|42->18|42->18|44->20|47->23|48->24
                  -- GENERATED --
              */
          