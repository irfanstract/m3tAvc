













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
         import avcframewrk.forms.templating.ext.givmk.impl.{
            predefChainingOps ,
         }
         import avcframewrk.forms.templating.ext.givmk.impl.{
            allocateLlTagReconciler ,
            LlKeyOrPropSetReconciliability1 ,
            LlPropAnimableSettibility ,
            rcKeyingDefiner1
         }
         import LlKeyOrPropSetReconciliability1.{*}
         // L.div()
         ({
            ;
            import avcframewrk.forms.templating.laminar.api.L
            import L.{given}
            val r = {
               allocateLlTagReconciler(L.button )
               .toScnAllocAndReconcileAndDistillH
            }
            ({
               implicit val o
               = com.raquo.airstream.ownership.ManualOwner()
               object _Lg {
                  org.scalajs.dom.console.log("anim init")
               }
               val eS = {
                  r
                  .pipeExactSelf(e => {
                     e : rcKeyingDefiner1.ScnAllocAndReconcileAndDistillH[r.IntermediateState, r.Mdl, r.HLI ]
                  })
                  .spawnMd((
                     //
                     //
                     byAttrAssignList((
                        Seq()
                        .toSeq
                        .toSet
                     ))
                  ) )
                  // r.spawnMdAsL(??? )
               }
               val dataTypAttr
               = L.dataAttr("type")
               L.EventStream.periodic(1500 )
               .delay(3000 )
               .scanLeft[(Int, Boolean)]((0, false))({ case ((_, v), i) => (i, v.unary_! ) } )
               .map({
                  e => { _Lg ; e }
               })
               .foreach({ case (i, efl) => {
                  ;

                  r.reconcile(eS, (
                     //

                     //
                     byAttrAssignList((
                        Seq()
                        .:+(AttrKeyAndValuePair((L.typ, "button") ) )
                        .:+(AttrKeyAndValuePair((dataTypAttr, i.toHexString ) ) )
                        .:+(AttrKeyAndValuePair((L.disabled, efl ) ) )
                        .toSeq
                        .toSet
                     ))
                  ) )
               }})
               val e = r.distillLHandle(eS)
               e.amend("run the main action")
               e
            })
         })
      } )
   }
}
















