













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
         import avcframewrk.forms.templating.reactjs.<
         r
         .render((
            rce.createElement("div", null, (
               Seq()
               :+ rce.createElement("p", null, "hello!" )
               // :+ rce.createElement("a", scalajs.js.Dictionary(("href", "javascript:console.log(\"opening the tutorial...\")" )), "consider reading the tutorial for more abt it." )
               :+ (
                  rce.createElement(
                     "a",
                     typings.react.mod.Attributes().set("href" , "javascript:console.log(\"opening the tutorial...\")" ) ,
                     "consider reading the tutorial for more abt it." ,
                  )
               )
               :+ (
                  <.button(`type` = "button", "do some simple action" )
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
               // :+ (
               //    <.span(`className` = "button", children = (Seq() :+ "do some simple action" ) )
               // )
            ) : _* )
         ))
      })
   }
}
















