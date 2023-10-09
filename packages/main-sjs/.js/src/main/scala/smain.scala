













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
         // (() => {
         //    val fnc
         //    = avcframewrk.forms.templating.reactjs.Em.apply
         //    System.currentTimeMillis().->(fnc )
         //    ({})
         // })
         import avcframewrk.forms.templating.reactjs.<
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
















