













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
            ) : _* )
         ))
      })
   }
}
















