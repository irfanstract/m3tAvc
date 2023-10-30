package avcframewrk.forms

package templating

package reactjs_s1













import cps.{async, await}

import scalajs.js

import com.github.plokhotnyuk.jsoniter_scala

import cps.monads.jsfuture.JSFuture

import typings.{std as dom }

import com.raquo.airstream










object rcpeSelectableIllegal {
   ;

   import quoted.*

   // @annotation.compileTimeOnly("illegal reflection")
   implicit
   inline
   def reflectiveSelectableIllegal
      [T <: AnyRef | js.Any ]
      (x: T )
   : reflect.Selectable
   = ${reflectiveSelectableIllegalImpl[T] ('{ x }) }

   def reflectiveSelectableIllegalImpl
      [T : Type ]
      (callSite: Expr[?] )
      (using Quotes )
   : Expr[reflect.Selectable ]
   = {
      import quotes.reflect.*
      report.errorAndAbort(s"illegal reflection ; [${Printer.TypeReprCode.show(TypeRepr.of[T] ) }] ${Printer.TreeCode.show(callSite.asTerm) } .", callSite )
   }

}

















