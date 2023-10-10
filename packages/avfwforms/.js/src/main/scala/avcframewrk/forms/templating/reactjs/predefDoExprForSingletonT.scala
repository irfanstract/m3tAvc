package avcframewrk.forms

package templating

package reactjs
















;

object singletonTypeToQuotedExprGvns
{
   ;

   ;

   import compiletime.*
   import quoted.*

   ;

   ;

   @deprecated
   given picklingInstance
      [T : ValueOf : Type ]
   : ToExpr[T]
   with {
      def apply(t: T)(using Quotes )
      = {
         import quotes.reflect.*
         '{
            given tSinglecy
            : ValueOf[T]
            = ${
               Expr.summon[ValueOf[T] ]
               .getOrElse(report.ksErrorAndAbort("cannot re-resolve the ValueOf[T]") )
            }
            valueOf[T]
         }
      }
   }

   @deprecated
   // transparent
   inline
   given unpicklingInstance
      [T ]
   : FromExpr[T]
   = {
      ;
      val r
      = summonFrom({ case e : ValueOf[T] => Some(e) ; case _ => None })
      new FromExpr[T]
      {
         def unapply(t: Expr[T] )(using quoted.Quotes )
         = for ( r1 <- r ) yield {
            given r1.type = r1
            valueOf[T]
         }
      }
   }

   @deprecated
   object tvoImplicits
   {
      ;

      ;

      given vwOfT[T : Type ] (using Quotes )
      : ValueOf[T]
      = {
         import quotes.reflect.*
         ( for (value <- Type.valueOfConstant[T] ) yield ValueOf(value ) )
         .getOrElse(report.ksErrorAndAbort(s"no Type.valueOfConstant[T]. \neligible types include (... ...) ") )
      }

      ;
   }

}

;
















val _ = {}
