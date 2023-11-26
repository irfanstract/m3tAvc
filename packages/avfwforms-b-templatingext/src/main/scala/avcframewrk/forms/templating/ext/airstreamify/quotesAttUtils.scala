// package avcframewrk.forms.templating.ext.airstreamify

package avcframewrk.forms

package templating

package ext.airstreamify










import avcframewrk.forms.localutil.predefChainingOpsImplicits.{*, given}

import quoted.*





import com.raquo.airstream








object airstreamifyQuotesAttUtils
{
   ;

   ;

   ;

   transparent inline
   def xReflect(using Quotes )
   : quotes.reflect.type
   = quotes.reflect

   extension [R : Type] (fExpr0 : Expr[R] ) {
      //

      @deprecated("a sugar to the variant, setting 'axiomatedOwner' to 'Symbol.spliceOwner' which is unlikely what you want.")
      def applyTreeTransform
         //
         (using Quotes )
         (tx: xReflect.TreeMap )
      : Expr[R]
      = {

         import xReflect.*

         applyTreeTransform(tx, axiomatedOwner = Symbol.spliceOwner )
      }

      def applyTreeTransform
         //
         (using Quotes )
         (tx: xReflect.TreeMap, axiomatedOwner: xReflect.Symbol )
      : Expr[R]
      = {

         import xReflect.*

         ;
         tx
         .transformTerm
            ({
               fExpr0.asTerm
               .underlyingArgument
            } )(axiomatedOwner )
         .asExpr
         .asExprOf[R]
      }

      //
   }

   def combinedValuesTypeReprBy
      //
      (using Quotes)
      (srcExprs : IndexedSeq[Expr[airstream.core.Signal[?] ] ] )
   = {
      ;

      import xReflect.*

      srcExprs

      .map({
         case '{ ${_} : airstream.core.Signal[t] } =>
            '{ ??? : t }
      })
      .foldLeft[Expr[Tuple] ] ('{ EmptyTuple })({
         case (e0, '{ ${newItem } : newItemActualT }) => {
            '{ ${e0 } :* ${newItem} }
         }
      })
      .asTerm.tpe
   }

   ;
}
















