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

object eclReactHooks {
   ;

   ;

   object codeWarningUtil {
      ;

      ;

      inline
      def warnExpansionOf
         [R]
         (inline r: R )
      : R
      = ${weoImpl('r) }

      private[codeWarningUtil]
      def weoImpl
         //
         [R : Type ]
         (using Quotes )
         (e: Expr[R])
      : Expr[R]
      = {
         ;
         import quotes.reflect.*
         report.warning(s"${
            Printer.TreeShortCode.show(e.asTerm )
         }", e )
         e
      }

      ;
   }

   ;

   type Aco[+R]
   = airstream.core.Source.SignalSource[R]
   type Acr[-R]
   = airstream.core.Sink[R]

   ;

   private
   def runSpecialWithMinimumProtocol
      //
      [R : Type ]
      (using Quotes )
      (warnOfResultingExpansion: Boolean )
      (rE: => Expr[R] )
   = {
      ;

      import quotes.reflect.*

      val c = rE

      if warnOfResultingExpansion then
         report.warning(s"${
            Printer.TreeShortCode.show(c.asTerm)
         }" )

      c
   }

   ;

   /* WRONG */
   @deprecated
   private[eclReactHooks]
   inline
   def byRenderFnc
      [R]
      (inline runMain: R )
   : Function1[? <: Product, ? <: Product ]
   = ${(
      brfImpl('runMain)
   )}

   /* WRONG */
   @deprecated
   private[eclReactHooks]
   def brfImpl
      //
      [R : Type ]
      (using Quotes )
      (runMainExpr: Expr[R] )
   : Expr[Function1[? <: Product, ? <: Product ] ]
   = {
      ;
      '{
         ((ctx: Product) => {
            ;

            given eclReactHooking.%%@.mainInstance.SCA
            = ???

            val rO
            = ${
               templating.ext.airstreamify.ByGetFromO.applyToExpr(runMainExpr)
            }

            ({
               rO *: EmptyTuple
            } : Product )
         } )
      }
   }

   export eclReactHooking.DependenciesArray

   inline
   def useCachedValue
      [R]
      (presentlyValue: => R, dependencies: DependenciesArray )
   : R
   = ${(
      ucvImpl[R] (
         //
         initialValueExpr = '{ presentlyValue } ,
         dependenciesArrayExpr = '{ dependencies } ,
      )
   )}

   def ucvImpl
      //
      [R : Type ]
      (using Quotes )
      (initialValueExpr: Expr[R] , dependenciesArrayExpr: Expr[DependenciesArray] )
   : Expr[R]
   = {
      ;

      import quotes.reflect.*
      
      runSpecialWithMinimumProtocol(warnOfResultingExpansion = false ) {
         ;

         // TODO
         '{
            val slot = ${
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

   import eclReactHooking.{*, given }

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

               val updatedDependenciesArray
               = ${dependenciesArrayExpr}

               def initialValue
               : R
               = ${initialValueExpr}

               (onRtAllocator ) => 
               ctx =>
               (OCA: onRtAllocator.SHEWM._Carrier._Any ) ?=>
                  import ctx.*

                  runUcvInnerHookCallFor
                     [R]
                     (uid)
                     (initialValue, updatedDependenciesArray )
                     (using onRtAllocator )
                     (using OCA )
            }))
      }

      finalExpr
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

   // TODO
   private[reactjsify]
   def generalisedSlotRef
      //
      [R : Type ]
      (using Quotes )
      (f1: Expr[(
         (onRtAllocator: %%@ ) =>
         ({
            val uid
            : OnRuntimeStringUuid._ForValue[String]
         }) =>
         (OCA : onRtAllocator.SHEWM._Carrier._Any)
         ?=> R
      ) ] )
   : Expr[R ]
   = {
      ;

      import quotes.reflect.*

      /** 
       * can safely use UUID gen this way since
       * macro expansion is just a one-time op.
       * 
       */
      val uidValue = {
         import language.unsafeNulls
         java.util.UUID.randomUUID()
         .toString()
      }

      '{
         ;

         ((uidValue: String) => {
            ;

            object ctx {
               ;

               val onRtAllocator
               : %%@.mainInstance.type
               = %%@.mainInstance

               val uid
               = {
                  OnRuntimeStringUuid(uidValue )
               }

            }

            import ctx.*

            ((
               ((
                  /** beta-reduction has bitten us here. we need to stop it from happening, by means of this extra identity prefix-or-suffix */
                  { identity(() ) ; ${f1 } }
               ))
                  (onRtAllocator )
                  (ctx )
                  (using compiletime.summonInline )
            ))
         })(${ Expr(uidValue) })
      }
      // .pipeLooseSelf(e => Expr.betaReduce(e) )
   }

   ;

   ;
}


















val _ = {}

