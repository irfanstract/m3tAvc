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

final
lazy val eclCodeWarningUtil
: codeWarningUtil.type
= codeWarningUtil

object eclReactHooks {
   ;

   ;

   final
   lazy val codeWarningUtil
   : eclCodeWarningUtil.type
   = eclCodeWarningUtil

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

            given eclReactHookingLambdalComponentEsvAndImplicitlyPassedInstallmentalOpsDefs.%%@.mainInstance.SCA
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

   export eclReactHookingLambdalComponentEsvAndImplicitlyPassedInstallmentalOpsDefs.DependenciesArray

   import eclReactHookingLambdalComponentEsvAndImplicitlyPassedInstallmentalOpsDefs.{*, given }

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
 * `EclKitReactHookSummonable`
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
object EclKitReactHookSummonable {
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

   export EclKitReactHookSummonable.ByRQueryAndDependenciesArrayThenDoAndReturnR

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

