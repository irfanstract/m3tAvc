// package avcframewrk.forms.templating.ext.reactjsify

package avcframewrk.forms

package templating

package ext.reactjsify










import avcframewrk.forms.localutil.predefChainingOpsImplicits.{*, given}

import quoted.*





import scalajs.js

import com.raquo.airstream



import typings.{std as domItc }
import typings.std.{global as dom }
import typings.std.{global as window }



;

private
object eclReactHookingLambdalComponentEsvAndImplicitlyPassedInstallmentalOpsDefs {
   ;

   ;

   type DependenciesArray
   = eclReactHooksDependencyArraysRelatedDefs.DependenciesArray

   final
   lazy val DependenciesArray
   : eclReactHooksDependencyArraysRelatedDefs.DependenciesArray.type
   = eclReactHooksDependencyArraysRelatedDefs.DependenciesArray

   trait %%@ {
      ;

      ;

      /** 
       * `stateHoldEwm` - RUNTIME ONLY!!!
       * 
       */
      private[reactjsify]
      inline
      def stateHoldEwm_=
         //
         (newValue: SHEWM._S )
         (using carrier: SHEWM._Carrier._Any )
      : Unit
      = {
         carrier.shgc.s_=(newValue )
      }

      transparent inline
      def stateHoldEwm
         //
         (using carrier : SHEWM._Carrier._Any )
      = carrier.shgc.s

      type SCA
      = SHEWM._Carrier._Any

      final
      lazy val SHEWM
      : StateHoldEwmD.type
      = StateHoldEwmD

      object StateHoldEwmD
      {
         ;

         type _S
         >: Map[OnRuntimeStringUuid, Esv._Any ]
         <: Map[OnRuntimeStringUuid, Esv._Any ]

         // TODO
         object _Carrier
         {
            ;

            type _Any
            = _Impl

            protected
            trait _Impl
            {
               this1 =>
               ;

               // export shgc.{s, s_=}

               val shgc
               : _StateHookGlobCarrier._Any

               implicit def eobsm
               : eclReactObservingHooksImpl.EOBSM._Any

               ;
            }

            ;
         }

         // TODO
         object _StateHookGlobCarrier
         {
            ;

            type _Any
            = _Impl

            protected
            trait _Impl {
               ;

               def s: _S
               def s_=(newValue: _S )
               : Unit

               ;
            }

            ;
         }

         ;
      }

      object StateHoldEwmDInReactJs {
         ;

         ;

         import eclReactObservingHooksImpl.EOBSM

         ;

         // TODO
         def useCarrier
            //
            ()
         : StateHoldEwmD._Carrier._Any
         = {
            ;

            // TODO
            // val (_, triggerRedraw)
            // = postAux.useXMonotonicOnlyRedrawTrigger()
            postAux.useXPeriodicRefresh()

            val pr1 = {
               ;

               typings.react.mod.useMemo(() => {
                  ;

                  EOBSM.PersistingPeer.allocate()
               } , js.Array() )
            }

            typings.react.mod.useDeferredValue({
               ;

               val eobsmImpl
               = {
                  ;

                  EOBSM.apply1(
                     //
                     persistingPeer =
                        pr1
                     ,
                     processDeferredRedrawSchedule =
                        schd =>
                           schd
                           .`then`(_ => {
                              // triggerRedraw()
                              ;
                           } )
                     ,
                  )
               }

               val shgcImpl
               =
                  new StateHoldEwmD._StateHookGlobCarrier._Any
                  {
                     ;

                     var s: StateHoldEwmD._S
                     = Map()

                     def eobsm
                     = eobsmImpl

                     ;
                  }

               new StateHoldEwmD._Carrier._Any
               {
                  ;

                  val shgc
                  = shgcImpl

                  def eobsm
                  = eobsmImpl

                  ;
               }
            } )
         }

         private[StateHoldEwmDInReactJs]
         object postAux {
            ;

            ;

            def useXMonotonicOnlyRedrawTrigger()
            = {
               val js.Tuple2(capturedV, setS)
               = typings.react.mod.useState[BigInt] (() => (0 : BigInt) )
               (capturedV, {
                  ;

                  typings.react.mod.useMemo(() => (
                     (() => {
                        setS(presentlyV0 => (
                           Set(presentlyV0, capturedV + 1 )
                           .max
                        ) )
                     } )
                  ) , js.Array(capturedV, setS ) )
               })
            }

            def useXPeriodicRefresh()
            = {
               ;

               // TODO
               val (c, triggerRedraw)
               = postAux.useXMonotonicOnlyRedrawTrigger()

               typings.react.mod.useEffect(() => {
                  ;
                  
                  js.timers.setTimeout(2 * 1000 ) {
                     triggerRedraw()
                  }

                  ()
               } , js.Array(c ) )
            }

            ;
         }

         ;
      }

      ;
   }

   object %%@ {
      ;

      ;

      final
      lazy val mainInstance
      : %%@
      = {
         new AnyRef with %%@
      }

      ;
   }

   object Esv {
      ;

      type _Any
      >: (Any, DependenciesArray)
      <: (Any, DependenciesArray)

      type WhichReturnsValueT
         [+Value]
      = _ForValueTLAndU[Nothing, Value]

      type _ForValueT
         [Value]
      = _ForValueTLAndU[Value, Value]

      type _ForValueTLAndU
         [-ValueL <: ValueU, +ValueU]
      >: (ValueL, DependenciesArray) @annotation.unchecked.uncheckedVariance
      <: (ValueU, DependenciesArray)

      extension [Value] (d: _Any & _ForValueTLAndU[Value, Value] )
         def value
         : Value
         = d._1
         def dependenciesArray
         : DependenciesArray
         = d._2

      ;
   }

   ;

   type OnRuntimeStateHold

   type OnRuntimeStringUuid
   = OnRuntimeStringUuid._Any

   object OnRuntimeStringUuid {
      ;

      opaque type _Any
      <: String
      = String

      opaque type _ForValue[+Value <: String ]
      <: _Any
      = String

      def apply
         (value: String)
      : _ForValue[value.type]
      = value
   }

   ;
}


















val _ = {}
