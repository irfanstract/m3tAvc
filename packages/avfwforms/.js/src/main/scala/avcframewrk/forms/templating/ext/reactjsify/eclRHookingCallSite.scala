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
object eclReactHooking {
   ;

   ;

   type DependenciesArray

   object DependenciesArray {
      ;
   }

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
         carrier.s_=(newValue )
      }

      transparent inline
      def stateHoldEwm
         //
         (using carrier : SHEWM._Carrier._Any )
      = carrier.s

      type SCA
      = SHEWM._Carrier._Any

      object SHEWM {
         ;

         type _S
         >: Map[OnRuntimeStringUuid, Esv._Any ]
         <: Map[OnRuntimeStringUuid, Esv._Any ]

         object _Carrier {
            ;
            trait _Any {
               def s: _S
               def s_=(newValue: _S ): Unit 
            }
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
