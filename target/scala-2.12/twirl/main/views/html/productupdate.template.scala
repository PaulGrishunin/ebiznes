
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

object productupdate extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template4[Form[UpdateProductForm],Seq[Category],MessagesRequestHeader,Flash,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(product: Form[UpdateProductForm],category: Seq[Category])(implicit request: MessagesRequestHeader, flash: Flash):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {
/*3.2*/import helper._


Seq[Any](format.raw/*2.1*/("""
"""),format.raw/*4.1*/("""
"""),_display_(/*5.2*/flash/*5.7*/.get("success").getOrElse("")),format.raw/*5.36*/("""

"""),_display_(/*7.2*/form(routes.ProductController.updateProductHandle())/*7.54*/ {_display_(Seq[Any](format.raw/*7.56*/("""
  """),_display_(/*8.4*/helper/*8.10*/.CSRF.formField),format.raw/*8.25*/("""
  """),format.raw/*9.3*/("""<input name="id" id="id" value=""""),_display_(/*9.36*/product("id")/*9.49*/.value),format.raw/*9.55*/("""" type="hidden" />
  """),_display_(/*10.4*/inputText(product("name"))),format.raw/*10.30*/("""
  """),_display_(/*11.4*/inputText(product("description"))),format.raw/*11.37*/("""

  """),format.raw/*13.3*/("""<select name="category" id="category">
  """),_display_(/*14.4*/for(cat <- category) yield /*14.24*/{_display_(Seq[Any](format.raw/*14.25*/("""
    """),_display_(/*15.6*/if(cat.id.toString==product("category").value.getOrElse(0))/*15.65*/ {_display_(Seq[Any](format.raw/*15.67*/("""
      """),format.raw/*16.7*/("""<option value=""""),_display_(/*16.23*/cat/*16.26*/.id),format.raw/*16.29*/("""" selected>"""),_display_(/*16.41*/cat/*16.44*/.name),format.raw/*16.49*/("""</option>
    """)))}/*17.6*/else/*17.10*/{_display_(Seq[Any](format.raw/*17.11*/("""
      """),format.raw/*18.7*/("""<option value=""""),_display_(/*18.23*/cat/*18.26*/.id),format.raw/*18.29*/("""">"""),_display_(/*18.32*/cat/*18.35*/.name),format.raw/*18.40*/("""</option>
    """)))}),format.raw/*19.6*/("""

  """)))}),format.raw/*21.4*/("""
  """),format.raw/*22.3*/("""</select>
  """),_display_(/*23.4*/inputText(product("price"))),format.raw/*23.31*/("""
  """),format.raw/*24.3*/("""<div class="buttons">
    <input type="submit" value="Update Product"/>
  </div>
""")))}),format.raw/*27.2*/("""
"""))
      }
    }
  }

  def render(product:Form[UpdateProductForm],category:Seq[Category],request:MessagesRequestHeader,flash:Flash): play.twirl.api.HtmlFormat.Appendable = apply(product,category)(request,flash)

  def f:((Form[UpdateProductForm],Seq[Category]) => (MessagesRequestHeader,Flash) => play.twirl.api.HtmlFormat.Appendable) = (product,category) => (request,flash) => apply(product,category)(request,flash)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: 2020-08-05T00:34:41.065964
                  SOURCE: /home/paul/ebiznes/app/views/productupdate.scala.html
                  HASH: c39a4a10a5f6674cf48483d8539d78bf0c4e8fd8
                  MATRIX: 796->1|982->117|1026->115|1053->133|1080->135|1092->140|1141->169|1169->172|1229->224|1268->226|1297->230|1311->236|1346->251|1375->254|1434->287|1455->300|1481->306|1529->328|1576->354|1606->358|1660->391|1691->395|1759->437|1795->457|1834->458|1866->464|1934->523|1974->525|2008->532|2051->548|2063->551|2087->554|2126->566|2138->569|2164->574|2197->589|2210->593|2249->594|2283->601|2326->617|2338->620|2362->623|2392->626|2404->629|2430->634|2475->649|2510->654|2540->657|2579->670|2627->697|2657->700|2769->782
                  LINES: 21->1|24->3|27->2|28->4|29->5|29->5|29->5|31->7|31->7|31->7|32->8|32->8|32->8|33->9|33->9|33->9|33->9|34->10|34->10|35->11|35->11|37->13|38->14|38->14|38->14|39->15|39->15|39->15|40->16|40->16|40->16|40->16|40->16|40->16|40->16|41->17|41->17|41->17|42->18|42->18|42->18|42->18|42->18|42->18|42->18|43->19|45->21|46->22|47->23|47->23|48->24|51->27
                  -- GENERATED --
              */
          