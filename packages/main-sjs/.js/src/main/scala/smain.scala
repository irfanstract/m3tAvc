













import cps.{async, await}

import scalajs.js

import scalajs.js.annotation.*

import com.github.plokhotnyuk.jsoniter_scala

import cps.monads.jsfuture.JSFuture

import typings.std.{global as dom }

import com.raquo.airstream

import avcframewrk.forms.domNavigatorObj.storageObj.watcher.ext.toStartSomeNodeFrp.FsWatch

// @js.native
// @JSImport("./kcss.css", JSImport.Namespace )
// val kCss: Any = js.native

val _ = {
   // TODO
   // dom.console.info(s"pre-release React/Slinky polyfilling")
   // js.eval(s"ReactDOM.render = (rElem, receiver) => ReactDOMClient ;")
   // js.`import`("react-dom")
   ;
}

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

      dom.console.log("[main] starting those little things...ePercentPercentE1 " )

      ({
         ;

         dom.console.log("[main] starting 'runLocalStorageDemoAsync' " )

         ( 
            runLocalStorageDemoAsync()
            // js.Promise.resolve({ dom.console.warn("[main] not a real impl of'runLocalStorageDemoAsync' " ) })
         )
         .`catch`({
               //

               case z : js.JavaScriptException =>
                  dom.console.warn(z.exception )
                  // throw new MspError(z)

               case util.control.NonFatal(z : Exception) =>
                  throw z
               case z =>
                  throw js.JavaScriptException(z)
         })
         .`then`(_ => {
            ;

            dom.console.log("[main] done done with 'runLocalStorageDemoAsync' " )
         })
      })



   }
}

val _ = {
   js.eval(s"File.prototype.toString = function () { return ${"`[object File (${this.name} (${this.type}, ${this.size}) - last modified at ${new Date(this.lastModified)} )]`"} } ;")
}

case class XDemoAppGeneralisedAspect(r: String, l: String )

lazy val xAppDemo
: typings.react.mod.ReactElement
= {
   ;
   // xEmusAppDemo.asStReactElement
   // slinkyFormEditingAppDemo
   // slinkyAngularSlider
   // slinkyImagz
   xEmusAppDemo.asStReactElement
}

lazy val xReactJsIfyDemo
: typings.react.mod.ReactElement
= {
   ;
   ({
      ;
      val _C = avcframewrk.forms.templating.ext.reactjsify.eclSmmstComponent1
      rce.describeElement(_C, null )
   })
}

lazy val slinkyFormEditingAppDemo
= {
   ;
   ({
      ;
      val _C = {
         ;
         slinky.core.FunctionalComponent[Any ] ((_) => {
            ;
            import slinky.web.html
            html.div(
               html.p("another form element.") ,
               html.p(html.label("value", ":" , html.input() ) ) ,
            )
         } )
      }
      _C(("", "") )
      .build
   })
   .asStReactElement
}














