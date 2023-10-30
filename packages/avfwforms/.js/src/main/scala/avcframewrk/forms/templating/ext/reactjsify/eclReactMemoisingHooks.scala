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

object eclReactObservingHooksImpl {
   ;

   import eclReactHookingProtocolTopLevel.ByRQueryAndDependenciesArrayThenDoAndReturnR

   import eclReactHooking.DependenciesArray

   import eclReactHookingProtocolTopLevel.runSpecialWithBareMinimumProtocol

   import eclReactHooking.{*, given }

   import eclReactHookGsr.{*, given }

   ;

   ;

   object EOBSM
   {
      ;

      type _Any
      = _Impl[?]

      protected
      trait _Impl[T0] {
         ;

         def valueOf
            //
            [T]
            (s: airstream.core.Signal[T] )
         : T

         /** 
          * essential for ad-hoc `.observe`s.
          * 
          * __do not__ call `.killSubscriptions()`.
          * 
          * for implementers --
          * 
          * `airstream.ownership.Owner`
          * 
          */
         val adHocSubscriptionalManager
         : airstream.ownership.Owner

         @deprecated
         def scheduleRefresh
            //
            (fnc: => (
               /* here's `Unit` corresponds to `js`' `void` */
               js.Promise[Unit]
            ) )
         : Unit

         def scheduleRefreshByCb
            //
            (fnc: (
               ([ResolverSynchronousR] =>> ((complete: () => ResolverSynchronousR ) => ResolverSynchronousR ) )
               [Unit ]
            ) )
         : Unit

         ;
      }

      object app {
         ;

         /* TODO RESOURCE LEAKING CAVEAT */
         /* TODO switch to clause-interweaved sig */
         @deprecated
         def valueOf
            [S]
            (using EOBSM._Any )
            (src: airstream.core.Signal[S] )
         : S
         = {
            // TODO
            src
            .observe(using summon[EOBSM._Any ].adHocSubscriptionalManager )
            .now()
         }

         def newJsTimeout
            //
            (duration: concurrent.duration.FiniteDuration )
         : js.Promise[Unit]
         = {
            newJsVoidCallbackPromise(cont => js.timers.setTimeout(duration )(cont() ) )
         }

         def newJsVoidCallbackPromise
            //
            (doResolve: (
               ([ResolverSynchronousR] =>> ((complete: () => ResolverSynchronousR ) => ResolverSynchronousR ) )
               [Unit ]
            ) )
         = js.Promise[Unit] ((cb, _) => doResolve(complete = () => cb(() ) ) )

      }

      ;
   }

   // /** `GetSignalValue` */
   // object GsgHookSummonable {
   //    ;

   //    opaque type _ForR[R]
   //    <: ByRQueryAndDependenciesArrayThenDoAndReturnR[R]
   //    =  ByRQueryAndDependenciesArrayThenDoAndReturnR[R]

   //    inline given [R]
   //    : _ForR[R]
   //    = ${gsgHookLambda[R] }

   // }

   // def gsgHookLambda
   //    //
   //    [R : Type]
   //    (using Quotes)
   // //
   // = {
   //    ;
   //    import quotes.reflect.*

   //    '{
   //       ;

   //       "by gsgHookLambda"

   //       locally((_eop : EOBSM._Any) ?=> {
   //          ;

   //          locally[ByRQueryAndDependenciesArrayThenDoAndReturnR[R] ] {
   //             ;

   //             (value, dependencies) =>
   //                ???
   //          }
   //       })(using compiletime.summonInline )
   //    }
   // }

   ;

}

object eclReactCachingHooksImpl {
   ;

   import eclReactHookingProtocolTopLevel.ByRQueryAndDependenciesArrayThenDoAndReturnR

   import eclReactHooking.DependenciesArray

   import eclReactHookingProtocolTopLevel.runSpecialWithBareMinimumProtocol

   import eclReactHooking.{*, given }

   import eclReactHookGsr.{*, given }

   ;

   ;

   //
   object UcvSummonable {
      ;

      opaque type _ForR[R]
      <: ByRQueryAndDependenciesArrayThenDoAndReturnR[R]
      =  ByRQueryAndDependenciesArrayThenDoAndReturnR[R]

      inline given [R]
      : _ForR[R]
      = ${ucvLambda[R] }

   }

   ;

   def ucvLambda
      //
      [R : Type]
      (using Quotes)
   //
   = {
      ;
      import quotes.reflect.*

      '{
         locally[ByRQueryAndDependenciesArrayThenDoAndReturnR[R] ] {
            ;

            (value, dependencies) =>
               eclReactHooks.useCachedValue(value, dependencies )
         }
      }
   }

   def ucvImpl
      //
      [R : Type ]
      (using Quotes )
      (initialValueExpr: Expr[R] , dependenciesArrayExpr: Expr[DependenciesArray] )
   : Expr[R]
   = {
      ;

      import quotes.reflect.*

      runSpecialWithBareMinimumProtocol(warnOfResultingExpansion = false ) {
         ;

         // TODO
         '{
            val slot = ${
               ;

               literateUcvHook[R] (
                  initialValueExpr = initialValueExpr ,
                  dependenciesArrayExpr = dependenciesArrayExpr ,
               )
            }

            slot
         }
      }
   }

   ;

   /** 
    * code properly
    * the UCV hook call site
    * 
    */
   def literateUcvHook
      //
      [R : Type ]
      (using Quotes )
      (initialValueExpr: Expr[R] , dependenciesArrayExpr: Expr[DependenciesArray] )
   : Expr[R ]
   = {
      ;

      import quotes.reflect.*

      lazy val finalExpr = {
         ;

         generalisedSlotRef
            [R]
            (('{
               ;

               literatedUcvHookGsrCe(${initialValueExpr }, ${dependenciesArrayExpr } )
            }) , assumedPos = Position.ofMacroExpansion )
      }

      finalExpr
   }

   /** 
    * internally used above ,
    * extracted
    * to minimise clutter (ie "hard to reason of") on the generated code
    * 
    */
   // private
   def literatedUcvHookGsrCe
      //
      [R ]
      (initialValue: => R, updatedDependenciesArray: DependenciesArray )
      //
   = {
      ;
      (onRtAllocator: eclReactHooking.%%@ ) =>
      (ctx: GsrPerCallSitePathDependedDefs[?] ) =>
      (OCA: onRtAllocator.SHEWM._Carrier._Any ) ?=>
         ;

         import ctx.{onRtAllocator as _ , *}

         runUcvInnerHookCallFor
            [R]
            (uid)
            (initialValue, updatedDependenciesArray )
            (using onRtAllocator )
            (using OCA )
   }

   /** 
    * `runUcvInnerHookCallFor`
    * 
    * extracted
    * to minimise clutter (ie "hard to reason of") on the generated code
    * 
    */
   // private[reactjsify]
   def runUcvInnerHookCallFor
      //
      [R]
      (uid: OnRuntimeStringUuid._Any )
      (initialValue: => R, updatedDependenciesArray: => DependenciesArray )
      (using onRtAllocator: %%@ )
      (using OCA : onRtAllocator.SHEWM._Carrier._Any )
   = {
         ;

         "init the mapping for this key"

         onRtAllocator
         .initStHldEwMappingFor[R] (uid)(initialValue, updatedDependenciesArray )
         ;

         "query the mapping for this key"

         val (value: R ) *: _
         = {
            onRtAllocator.stateHoldEwm.get(uid)
            .getOrElse({
               throw new AssertionError(s"still no mapping for this key, despite all these")
            })
         } : @unchecked

         "returning"

         value
   }

   extension (onRtAllocator : %%@)
   {
      //

      /** 
       * update the mapping for the given key
       * 
       */
      def initStHldEwMappingFor
         //
         [R]
         (using onRtAllocator.SHEWM._Carrier._Any )
         (uid: OnRuntimeStringUuid._Any )
         (presentlyValue: => R, updatedDependenciesArray: DependenciesArray )
      : Unit
      = {
         ;

         onRtAllocator.stateHoldEwm =
            onRtAllocator.stateHoldEwm
            .updatedWith(uid )(o => {
               ;

               "recompute unless it stays the same"

               o
               /** 
                * recompute unless
                * `dependenciesArray` stays contentually the same
                */
               .filter(o => {
                  o.dependenciesArray == updatedDependenciesArray
               })
               .orElse[Esv._Any ] (Some {
                  ;
                  (presentlyValue , updatedDependenciesArray )
               })
            })
         ;

         assert(onRtAllocator.stateHoldEwm.keySet.contains(uid ) )
      }
   }

   ;
}


















val _ = {}
