













import scalajs.js

import typings.{std as dom }

@main
def runSMain(): Unit
= {
   ;

   println(s"hello!")
   ()

   locally {
      ;
      
      ;

      ({
         // (typings.react.mod. )
         mainAppMountRoot
         .render((
            rce.describeElement(rce.example23._C , null )
         ))
      })

      dom.global.console.log("[main] starting 'runLocalStorageDemoAsync' " )

      runLocalStorageDemoAsync()
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















