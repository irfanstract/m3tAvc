













import scalajs.js

import scalajs.js.annotation.*

import typings.{std as dom }

// @js.native
// @JSImport("./kcss.css", JSImport.Namespace )
// val kCss: Any = js.native

@main
def runSMain(): Unit
= {
   ;

   println(s"hello!")
   ()

   locally {
      ;
      
      ;

      // s"$kCss"
      // .intern().nn

      locally({ })

      ({
         // (typings.react.mod. )
         mainAppMountRoot
         .render((
            rce.describeElement(rce.example23._C , null )
         ))
      })

      dom.global.console.log("[main] starting those little things...ePercentPercentE " )

      dom.global.console.log("[main] starting 'runLocalStorageDemoAsync' " )

      ( 
         runLocalStorageDemoAsync()
         // js.Promise.resolve({ dom.global.console.warn("[main] not a real impl of'runLocalStorageDemoAsync' " ) })
      )
      .`catch`({
            //

            case z : js.JavaScriptException =>
               dom.global.console.warn(z.exception )
               // throw new MspError(z)

            case util.control.NonFatal(z : Exception) =>
               throw z
            case z =>
               throw js.JavaScriptException(z)
      })
      .`then`(_ => {
         ;

         dom.global.console.log("[main] done done with 'runLocalStorageDemoAsync' " )
      })



   }
}















