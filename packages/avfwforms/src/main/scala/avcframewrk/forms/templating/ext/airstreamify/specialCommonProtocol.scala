// package avcframewrk.forms.templating.ext.airstreamify

package avcframewrk.forms

package templating

package ext.airstreamify










import avcframewrk.forms.localutil.predefChainingOpsImplicits.{*, given}

import quoted.*





import com.raquo.airstream



object commonProtocol {
   ;

   ;

   ;

   // private[templating]
   def runQuotativeSessionDmpably
      //
      [R : Type, R0 ]
      (using splCtx: Quotes)
      (fExpr0: Expr[R0], fExpr: (expr0: Expr[R0], _1: EmptyTuple.type ) => Expr[R ], warnResultingCode: Boolean )
   : Expr[R ]
   = {
      ;

      import quotes.reflect.*

      val mainExpr
      = {
         fExpr(expr0 = fExpr0, _1 = EmptyTuple )
      } : Expr[R]

      if warnResultingCode then {
         ;

         def warnExpr
            (mainExpr: Expr[?])
         : Unit
         = {
            ;

            report.warning(s"(${
               ;
               Printer.TreeStructure
               .show(mainExpr.asTerm )
               .take(380)
               ""
            }): \n ${
               // Printer.TreeCode
               Printer.TreeShortCode
               .show(mainExpr.asTerm )
               .pipeLooseSelf(str => {
                  import language.unsafeNulls
                  str
                  .split("\n").toIndexedSeq
                  .map(s => s.grouped(120).mkString("\n") )
                  .mkString("\n")
               } )
            }" , fExpr0 )
         }

         // warnExpr(fExpr0 )
         warnExpr(mainExpr )
      }

      mainExpr
   }

   ;
}



















val _ = {}

