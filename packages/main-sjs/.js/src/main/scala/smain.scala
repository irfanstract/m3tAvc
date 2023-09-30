













@main
def runSMain(): Unit
= {
   ()
   ()
   println(s"hello!")
   ()
   locally {
      import java.util.Locale
      import org.scalajs.dom
      import com.raquo.laminar.api.L
      (if true then {
         val prz = {
            Iterator.fill(3)((z: Throwable) => {
               org.scalajs.dom.console.error(z)
            } )
            .concat({ org.scalajs.dom.console.error(s"too many exceptions logged ; no more will be emitted") ; Iterator.continually((z: Throwable) => {} ) } )
         }
         import  com.raquo.airstream.core.AirstreamError
         AirstreamError.unregisterUnhandledErrorCallback(AirstreamError.consoleErrorCallback )
         AirstreamError.registerUnhandledErrorCallback(z => { prz.next().apply(z) } )
      })
      def renderOnDomContentLoadedAlt[I](e: => dom.Element, run1: => com.raquo.laminar.nodes.ReactiveElement.Base )
      : Unit
      = {
         // scalajs.js.timers.setTimeout(3 * 1000 )(new com.raquo.laminar.nodes.RootNode(e , run1).mount() )
         L.renderOnDomContentLoaded(e, run1 )
      }
      // renderOnDomContentLoaded
      renderOnDomContentLoadedAlt(dom.document.querySelector("#app") match { case e => e.innerHTML = "" ; e } , {
         L.div()
      } )
   }
}
















