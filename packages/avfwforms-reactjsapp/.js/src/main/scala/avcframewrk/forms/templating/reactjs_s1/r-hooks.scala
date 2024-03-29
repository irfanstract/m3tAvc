package avcframewrk.forms

package templating

package reactjs_s1













import scalajs.js

import org.scalajs.dom

import dom.console

;

object ReactWithinRender {
   ;

   ;

   ;

   ;

   /** for API users - an entry-point */
   export renderfncs.Efb

   /** for API users - an entry-point */
   export Efb.ofValueDoneByByNameEv

   /** for API users - an entry-point */
   object implicits
   {
      ;
      export MemoisingHook.implicits.{*, given }
      export ReSubscriptiveHook.uvImplicits.{*, given }
   }

   ;

   ;

   // TODO
   export renderfncs.{StateHook, RefStateHook}

   // TODO
   export renderfncs.MemoisingHook

   export renderfncs.applyMemoisingHook

   export renderfncs.useRefHolder

   /** 
    * a hook to handle diffing across consecutive redraws
    * 
    * you might actually not need to use this at all.
    * 
    */
   export renderfncs.ConsecutiveRedrawDigestiveHook

   /** 
    * you meant `ConsecutiveRedrawDigestiveHook`
    * 
    */
   final
   lazy val CrossRedrawDigestiveHook
   : ConsecutiveRedrawDigestiveHook.type
   = ConsecutiveRedrawDigestiveHook

   export renderfncs.EffectHook

   export renderfncs.ReSubscriptiveHook

   /** 
    * `RjsImperativeHandlePropagativeHook`
    * 
    * note - you might not need this
    * 
    */
   object RjsImperativeHandlePropagativeHook {
      ;

      export typings.react.mod.{useImperativeHandle as use1 }

   }

   export avfwReactHooksDataTypesDefs.AvfwDependenciesArray

   ;
}

/** 
 * we separate these defs from the usages
 * 
 */
private
object avfwReactHooksDataTypesDefs {
   ;

   export renderfncs.AvfwDependenciesArray

}

export typings.react.mod.{
   useState as useStateHook0 ,
   useReducer as useDigestHook0 ,
}

export typings.react.mod.{
   useMemo as useMemoisingHook ,
   useCallback as useCallback ,
}
def useEventCallback
   //
   [Evt]
   (run: Evt => Unit )
= useEventCallbackGeneralised(run)
def useEventCallbackGeneralised
   //
   [Evt, R]
   (run: Evt => R  )
= {
   // typings.react.experimentalMod.reactAugmentingMod.experimentalUseEffectEvent(run )
   ({
      ;
      typings.react.mod.useRef[run.type](run )
      .pipeLooseSelf(ref => {
         ref.current = run
         renderfncs.MemoisingHook.useForCallback((evt: Evt) => ref.current.apply(evt) , {
            implicit val p = renderfncs.AvfwDependenciesArrayItemability.byIdentity[Any]
            Nil :+ ref
         } )
      } )
   })
}

;













val _ = {}