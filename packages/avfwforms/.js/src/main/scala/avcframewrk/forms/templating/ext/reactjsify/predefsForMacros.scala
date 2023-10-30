// package avcframewrk.forms.templating.ext.reactjsify

package avcframewrk.forms

package templating

package ext.reactjsify










import avcframewrk.forms.localutil.predefChainingOpsImplicits.{*, given}

import quoted.*

















object codeWarningUtil {
   ;

   ;

   transparent
   inline
   def strFmattedExpn
      [R]
      (inline r: R )
   = ${reoImpl('r) }

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

import scalajs.js

object System {
   ;
   def currentTimeMillis
      ()
   : Long
   = js.Date.now().toLong
}









