













import cps.{async, await}

import scalajs.js

import scalajs.js.annotation.*

import com.github.plokhotnyuk.jsoniter_scala

import cps.monads.jsfuture.JSFuture

import typings.{std as dom }

import com.raquo.airstream

import avcframewrk.forms.domNavigatorObj.storageUsageUtil.FsWatch

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
            xAppDemo
         ))
      })

      dom.global.console.log("[main] starting those little things...ePercentPercentE1 " )

      ({
         ;

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
      })



   }
}

val _ = {
   js.eval(s"File.prototype.toString = function () { return ${"`[object File (${this.name} (${this.type}, ${this.size}) - last modified at ${new Date(this.lastModified)} )]`"} } ;")
}

case class XDemoAppGeneralisedAspect(r: String, l: String )

lazy val xAppDemo
: rce.ReactElement
= {
   ;
   val _C = {
      ;
      val _C1 = {
         rce.ReactProductEditComponent.forValueT[(
           XDemoAppGeneralisedAspect
         )]
      }
      val value
      = {
         XDemoAppGeneralisedAspect(r = "R", l = "L")
      }
      rce.ReactComponent1.describe((_: Any) => {
         rce.describeElement(_C1, rce.ReactProductEditComponent.propsIValue(value) )
      })
   }
   rce.describeElement(_C, null )
}














