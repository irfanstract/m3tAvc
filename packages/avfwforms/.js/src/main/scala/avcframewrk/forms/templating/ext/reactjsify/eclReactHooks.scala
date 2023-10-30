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

      transparent
      inline
      def strFmattedExpansionOf
         [R]
         (inline r: R )
      = ${reoImpl('r) }

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

         val Expr(code)
         = reoImpl[R] (e)

         report.warning("code:".++("\n").++(code) , e )

         e
      }

      private[codeWarningUtil]
      def reoImpl
         //
         [R : Type ]
         (using Quotes )
         (e: Expr[R])
      = {
         ;
         import quotes.reflect.*

         Expr({
            Printer.TreeShortCode.show(e.asTerm )
            .prependedAll("/* GENERATED. DO NOT EDIT; CHANGES WILL GO AWAY! */\n\n")
         })
      } : Expr[String]

      ;
   }

   ;

   type Aco[+R]
   = airstream.core.Source.SignalSource[R]
   type Acr[-R]
   = airstream.core.Sink[R]

   ;

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

   import eclReactHooking.{*, given }

   import eclReactHookGsr.{*, given }

   import eclReactCachingHooksImpl.ucvImpl

   inline
   def useCachedValue
      [R]
      (presentlyValue: => R, dependencies: DependenciesArray )
   : R
   = ${(
      ucvImpl[R] (
         //
         initialValueExpr =
            '{ presentlyValue : R }
         ,
         dependenciesArrayExpr =
            '{ dependencies }
         ,
      )
   )}

   ;

   ;
}

/** 
 * `EclReactHookSummonable`
 * 
 * `eclReactHooks.useCachedValue`
 * happens to be another `inline` one ;
 * to avoid potential issues like
 * the compiler inlining it too early resulting in unexpected behv (eg same `OnRuntimeStringUuid` being reused more-than-once),
 * needs to here
 * impose some trickery
 * , currently an indirection as (an IIFE involving `stdlib.compiletime.summonInline` )
 * 
 */
object EclReactHookSummonable {
   ;

   ;

   /** 
    * NOTE --
    * IGNORE the warning `can significantly increase generated code size` ;
    * this is by design,
    * to avoid the unexpected behv (eg same/identical `OnRuntimeStringUuid` being reused at different call-sites )
    */
   ;

   /** 
    * `(value: DummyImplicit ?=> R, dependenciesArray: eclReactHooks.DependenciesArray ) => R`
    * 
    * ```
    * (value: DummyImplicit ?=> R, dependenciesArray: eclReactHooks.DependenciesArray ) => 
    *   R
    * ```
    */
   type ByRQueryAndDependenciesArrayThenDoAndReturnR[R]
   = (
      (value: DummyImplicit ?=> R, dependenciesArray: eclReactHooks.DependenciesArray ) =>
         R
   )

   final
   lazy val ToUseCachedValue
   : eclReactCachingHooksImpl.UcvSummonable.type
   = eclReactCachingHooksImpl.UcvSummonable

}

object eclReactHookingProtocolTopLevel {
   ;

   ;

   export EclReactHookSummonable.ByRQueryAndDependenciesArrayThenDoAndReturnR

   ;

   def runSpecialWithBareMinimumProtocol
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

   ;
}


















val _ = {}

