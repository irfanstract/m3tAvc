













import avcframewrk.forms.templating.reactjs.{
   < ,
   KS ,
}
import avcframewrk.forms.templating.reactjs.e_ks.{
   ksDefaultReactJsImpl ,
}

@main
def runSMain(): Unit
= {
   ;

   println(s"hello!")
   ()

   locally {
      import java.util.Locale
      import org.scalajs.dom
      
      ;

      object rce {
         /* don't use `typings.react.global.React` */
         export typings.react.mod.{
            createElement ,
            createContext ,
         }
      }

      ({
         val r = typings.reactDom.clientMod.createRoot(dom.document.querySelector("#app") )
         // (typings.react.mod. )
         (() => {
            typings.react.mod.AllHTMLAttributes.apply().style
         })
         (() => {
            import scala.reflect.Selectable.reflectiveSelectable
            val fnc
            = avcframewrk.forms.templating.reactjs.Em.apply
            System.currentTimeMillis().->(fnc )
            ({
               val e = ((e: Any) => Some[e.type](e) )("type: " + compiletime.codeOf(Some(fnc) ) )
            })
            ({
               object byPnfc {
                  export fnc.apply
               }
               // byPnfc.apply(about = ??? )
            })
            ({
               val e
               = new AnyRef with Selectable {
                  def apply
                     (key: Int = 1 )
                  : Unit
                  = {}
                  extension (e: 5) def applyToFive() : Unit = {}
               }
               Some(e)
               // val eApplied = e.apply()
               // eApplied
               ()
            })
            ({})
         })
         r
         .render((
            rce.createElement("div", null, (
               Seq()
               :+ rce.createElement("p", null, "hello!" )
               // :+ rce.createElement("a", scalajs.js.Dictionary(("href", "javascript:console.log(\"opening the tutorial...\")" )), "consider reading the tutorial for more abt it." )
               :+ (
                  <.a(
                     href = "javascript:console.log(\"opening the tutorial...\")"
                     ,
                     "consider reading the tutorial for about it."
                     ,
                     "consider reading the tutorial for about it."
                     ,
                  )
               )
               :+ (
                  <.button(`type` = "button", "do some simple action" )
               )
               :+ (
                  <.button(typ = "button", "do some simple action" )
               )
               :+ (
                  <.button(`type` = "button", "do my favourite things" )
               )
               :+ (
                  <.button(`typed` = "button", "do my favourite things" )
               )
               // :+ (
               //    <.span(`class` = "button", "do some simple action" )
               // )
               // :+ (
               //    <.label(`for` = "someButton", "do some simple action" )
               // )
               :+ (
                  <.label(htmlFor = "someButton", "do some simple action" )
               )
               :+ (
                  <.select(`child` = <.option("option side 1" ), <.option("option main 1" ) )
               )
               :+ (
                  <.select(children = Seq() :+ <.option("option side 1" ), <.option("option main 1" ) )
               )
               :+ (
                  <.button(typ = "button", "do some simple action" )
               )
               :+ (
                  <.p(attachedSnippet = "button", "do some simple action" )
               )
               :+ (
                  <.ul((
                     Seq()

                     :+ (
                        <.li(key = "button", "do my favourite things" )
                     )
                     // :+ (
                     //    <.li(key = "button" -> "", "do my favourite things" )
                     // )
                     :+ (
                        <.li(key = "button", "do my favourite things" )
                     )
                     // :+ (
                     //    <.li(key = "button" -> "", "do my favourite things" )
                     // )
                     // :+ (
                     //    <.li(ref = "button", "do those things" )
                     // )
                     // :+ (
                     //    <.li(ref = (_ => {} ) : Function1[Product, ?] , "do those things" )
                     // )
                     // :+ (
                     //    <.li(ref = ((_) => {} ) : scalajs.js.Function1[?, ?] , "do those things" )
                     // )
                     :+ (
                        <.li(key = "edothesethings", "do those things" )
                     )
                     :+ (
                        <.li(keyo = "edothesethings", "do those things" )
                     )
                     // :+ (
                     //    <.li(key = "edothesethings", "do those things" -> "bar" )
                     // )
                  ) )
               )
               // :+ (
               //    <.span(`className` = "button", children = (Seq() :+ "do some simple action" ) )
               // )
            ) : _* )
         ))
      })
   }
}

// given defaultJsxImpl
implicit val defaultJsxImpl
: KS._ImplManifest[ksDefaultReactJsImpl.type ]
= KS._ImplManifest(ksDefaultReactJsImpl )
















