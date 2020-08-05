
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

object product extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template1[Product,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(product: Product):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*2.1*/("""
"""),format.raw/*3.1*/("""<li></li>
<b>"""),_display_(/*4.5*/product/*4.12*/.name),format.raw/*4.17*/("""</b>
  """),_display_(/*5.4*/product/*5.11*/.description),format.raw/*5.23*/("""
  """),_display_(/*6.4*/product/*6.11*/.price),format.raw/*6.17*/("""



"""))
      }
    }
  }

  def render(product:Product): play.twirl.api.HtmlFormat.Appendable = apply(product)

  def f:((Product) => play.twirl.api.HtmlFormat.Appendable) = (product) => apply(product)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: 2020-08-05T00:34:40.211312
                  SOURCE: /home/paul/ebiznes/app/views/product.scala.html
                  HASH: 4f6939ea3f3e6db0a4d5cc429ea2f483b5bf9ace
                  MATRIX: 732->1|844->20|871->21|910->35|925->42|950->47|983->55|998->62|1030->74|1059->78|1074->85|1100->91
                  LINES: 21->1|26->2|27->3|28->4|28->4|28->4|29->5|29->5|29->5|30->6|30->6|30->6
                  -- GENERATED --
              */
          