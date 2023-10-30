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

object eclReactCachingHooksImpl {
   ;

   import eclReactHookingProtocolTopLevel.ByRQueryAndDependenciesArrayThenDoAndReturnR

   import eclReactHookingLambdalComponentEsvAndImplicitlyPassedInstallmentalOpsDefs.DependenciesArray

   import eclReactHookingProtocolTopLevel.runSpecialWithBareMinimumProtocol

   import eclReactHookingLambdalComponentEsvAndImplicitlyPassedInstallmentalOpsDefs.{*, given }

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
      (onRtAllocator: eclReactHookingLambdalComponentEsvAndImplicitlyPassedInstallmentalOpsDefs.%%@ ) =>
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
