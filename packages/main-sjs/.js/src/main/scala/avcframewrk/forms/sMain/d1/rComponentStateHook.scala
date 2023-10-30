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

   export avcframewrk.forms.templating.reactjs_s1.ReactWithinRender

   export avcframewrk.forms.templating.reactjs_s1.ReactWithinRender.MemoisingHook

   export avcframewrk.forms.templating.reactjs_s1.ReactWithinRender.StateHook
   export avcframewrk.forms.templating.reactjs_s1.ReactWithinRender.RefStateHook

   export avcframewrk.forms.templating.reactjs_s1.ReactWithinRender.ReSubscriptiveHook

   export avcframewrk.forms.templating.reactjs_s1.renderfncs.AvfwDependenciesArray

   export avcframewrk.forms.templating.reactjs_s1.renderfncs.AvfwDependenciesArrayItemability

   export typings.react.mod.{
      createContext ,
   }

   export avcframewrk.forms.templating.reactjs_s1.useCallback
   export avcframewrk.forms.templating.reactjs_s1.useEventCallback
   export avcframewrk.forms.templating.reactjs_s1.useEventCallbackGeneralised

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

   type UjfThirdArg
   >: Unit
   <: Unit

   def useJsFuture
      //
      [Value ]
      (getSrc: js.Function0[js.Promise[Value] ], initialValue: => Value, ujfThirdArg: UjfThirdArg, dependencies1: AvfwDependenciesArray )
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

   def useJsFutureAndScanLeft
      //
      [Value ]
      (getSrc: js.Function0[js.Promise[Value] ], digest: (Option[Value], Option[util.Try[Value] ] ) => Value, ujfThirdArg: UjfThirdArg, dependencies1: AvfwDependenciesArray )
   : Value
   = {
      ;
      useJsFutureStatAnim(getSrc, ???, (), dependencies1 )
      .pipeLooseSelf(anim => {
         ;
         val dg1
         = useEventCallbackGeneralised(digest.tupled )

         slinky.core.facade.Hooks.useMemo(() => {
            anim
            .scanLeft[Value] (dg1(None, _) )((s0, newTr) => dg1(Some(s0), newTr ) )
         } , Nil :+ anim :+ dg1 )
      })
      .pipeLooseSelf(anim => {
         useRaqueFrpState(() => anim, {
            ;
            type eanimCap = ({ type CAP >: anim.type <: anim.type })#CAP 
            implicit val eh1
            = AvfwDependenciesArrayItemability.byIdentity[eanimCap ]
            Nil :+ (anim : eanimCap )
         } )
      } )
   }

   @deprecated
   def useJsFutureStatAnim
      //
      [Value ]
      (getSrc: js.Function0[js.Promise[Value] ], initialValue: => Nothing, ujfThirdArg: UjfThirdArg, dependencies1: AvfwDependenciesArray )
   = {
      ;
      useRaqueFrpFromStateValue(getSrc() , dependencies1 )
      .pipeLooseSelf(anim => {
         ;
         slinky.core.facade.Hooks.useMemo(() => {
            anim
            .flatMap(pr => {
               airstream.core.EventStream.fromJsPromise(pr )
               .recoverToTry
               .toWeakSignal
            } )
         } , Nil :+ anim )
      })
   }

   @deprecated
   def useRaqueFrpFromStateValue
      //
      [Value ]
      (
         upstreamValue: => Value,
         dependencies1: AvfwDependenciesArray,
         // SpecialTry: [A] => (DummyImplicit ?=> A) => Some[A],
      )
   : airstream.state.StrictSignal[Value]
   = {
      ;

      val sHold
      = {
         slinky.core.facade.Hooks.useMemo(() => {
            airstream.state.Var.fromTry[Value ](util.Try(upstreamValue ) )
         } , Nil )
      }

      slinky.core.facade.Hooks.useEffect(() => {
         ;
         util.Try(upstreamValue )
         .pipeLooseSelf(sHold.setTry(_) )

         ()
      } : Unit , Nil :+ sHold :++ dependencies1.toSeq )

      sHold.signal
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
         .pipeLooseSelf(src => {
            ;
            util.Using.resource(allocateUrfpsOwnerCloseable() )(adHocOw => {
               ;

               src
               .observe(using adHocOw )
               .now()
            })
         } )
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
      ;

      import ReactWithinRender.implicits.{*, given}

      ReactWithinRender.Efb.doneByFnc1((_: Product) => {
         ;
         val o
         = allocateUrfpsOwnerCloseable()

         val s
         = {
            ;

            getSrc()

            .recoverToTry

            .map(newValueOpt => {
               lazy val newValue = newValueOpt.get
               ;
               updateS(computeNextState = (_: Value) => { newValue } )
            } : Unit)

            .observe(using o)
         }

         o
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

   def allocateUrfpsOwnerCloseable
      ()
   = {
      ;

      new airstream.ownership.ManualOwner() with java.io.Closeable {
         override def close(): Unit = killSubscriptions()
      }
   }

}



















val _ = {}
