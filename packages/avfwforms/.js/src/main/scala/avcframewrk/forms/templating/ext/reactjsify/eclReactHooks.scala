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

   type DependenciesArray

   object DependenciesArray {
      ;
   }

   type Aco[+R]
   = airstream.core.Source.SignalSource[R]
   type Acr[-R]
   = airstream.core.Sink[R]

   ;

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
      
      val c = {
         ;

         // TODO
         '{
            val slot = ${
               slotRef[R] (
                  initialValueExpr = initialValueExpr ,
                  dependenciesArrayExpr = dependenciesArrayExpr ,
               )
            }

            slot
         }
      }

      if true then
         report.warning(s"${
            Printer.TreeShortCode.show(c.asTerm)
         }" )

      c
   }

   ;

   def slotRef
      //
      [R : Type ]
      (using Quotes )
      (initialValueExpr: Expr[R] , dependenciesArrayExpr: Expr[DependenciesArray] )
   : Expr[R ]
   = {
      ;

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
         val uid
         = {
            OnRuntimeStringUuid(${ Expr(uidValue) } )
         }

         def initialValue
         : R
         = ${initialValueExpr}

         val updatedDependenciesArray
         = ${dependenciesArrayExpr}

         onRuntimeStateHoldEwm =
            onRuntimeStateHoldEwm
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
                  (initialValue , updatedDependenciesArray )
               })
            })

         ({
            val (value: R ) *: deps0 *: _
            = {
               onRuntimeStateHoldEwm.get(uid)
               .getOrElse({
                  throw new AssertionError("still None despite all these")
               })
            } : @unchecked
            value
         })
      }
   }

   /** 
    * `onRuntimeStateHoldEwm` - RUNTIME ONLY!!!
    * 
    */
   // private
   var onRuntimeStateHoldEwm
   : Map[OnRuntimeStringUuid, Esv._Any ]
   = {
      ;
      Map()
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

   ;
}


















val _ = {}

