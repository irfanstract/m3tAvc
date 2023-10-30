package avcframewrk.forms.sMain.d1















import scalajs.js

import typings.{std as dom }

import com.raquo.airstream

import java.util.Locale

;

;

trait RceCoreHooks
{
   rce =>
   //

   /* don't use `typings.react.global.React` */
   ;

   export avcframewrk.forms.templating.reactjs.ReactWithinRender

   export avcframewrk.forms.templating.reactjs.ReactWithinRender.MemoisingHook

   export avcframewrk.forms.templating.reactjs.ReactWithinRender.StateHook
   export avcframewrk.forms.templating.reactjs.ReactWithinRender.RefStateHook

   export avcframewrk.forms.templating.reactjs.ReactWithinRender.ReSubscriptiveHook

   export avcframewrk.forms.templating.reactjs.renderfncs.AvfwDependenciesArray

   export avcframewrk.forms.templating.reactjs.renderfncs.AvfwDependenciesArrayItemability

   export typings.react.mod.{
      createContext ,
   }

   export avcframewrk.forms.templating.reactjs.useCallback
   export avcframewrk.forms.templating.reactjs.useEventCallback

   def useValueChangeLogging
      //
      [Value]
      (v: => Value, msg: => String )
   : Unit
   = {
      typings.react.mod.useEffect(() => {
         dom.global.console.log(msg)
      }, js.Array(v) )
   }

}

trait RceAsyncAndFrpHooks
extends
AnyRef
{
   rce : (
      RceCoreHooks
   ) =>
   ;

   ;

   def useJsFuture
      //
      [Value ]
      (getSrc: js.Function0[js.Promise[Value] ], initialValue: Value, unit1: Unit, dependencies1: AvfwDependenciesArray )
   : Value
   = {
      ;

      useRaqueFrpState[Value] (() => {
         ;

         val pr
         = getSrc()

         airstream.core.Signal.fromJsPromise(pr, initialValue )
      } , dependencies1 )
   }

   def useRaqueFrpState
      //
      [Value ]
      (getSrc: js.Function0[airstream.core.Signal[Value] ], dependencies1: AvfwDependenciesArray )
   : Value
   = {
      val Tuple2(s, updateS)
      = ReactWithinRender.StateHook.useWithInitialValue[Value] ({
         // TODO
         getSrc()
         .observe(using airstream.ownership.ManualOwner() )
         .now()
      })
      useRaqueFrpStateUpdateEvents
         [Value]
         (getSrc, dependencies1 )
         (computeNextState => updateS((v) => computeNextState(v) ) )
      s
   }

   def useRaqueFrpStateUpdateEvents
      //
      [Value ]
      (getSrc: js.Function0[airstream.core.Signal[Value] ], dependencies1: AvfwDependenciesArray )
      (updateS : (computeNextState: (priorState: Value) => Value) => Unit )
   : Unit
   = {
      import ReactWithinRender.implicits.{*, given}
      ReactWithinRender.Efb.doneByFnc1((_: Product) => {
         ;
         val o
         = airstream.ownership.ManualOwner()
         val s
         = {
            getSrc()
            .map(newValue => {
               updateS(computeNextState = (_: Value) => newValue )
            } : Unit)
            .observe(using o)
         }
         locally[java.io.Closeable](() => o.killSubscriptions() )
      }, dependencies = dependencies1 )
      // .useReSubscriptiveEffectHook(onEvtDispatchMdWhen = {
      //    // ReactWithinRender.EffectHook._When.Deferredly()
      //    ???
      // } )
      .pipeLooseSelf(b => {
         ReactWithinRender.implicits.useReSubscriptiveEffectHook(b)(onEvtDispatchMdWhen = {
            ReactWithinRender.EffectHook._When.Deferredly()
            // ???
         } )
      })
   }

}



















val _ = {}
