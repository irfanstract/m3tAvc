package avcframewrk.forms

package templating

package reactjs
















;

import compiletime.{ops as _, *}
import quoted.{runtime as _, *}

export avcframewrk.forms.templating.ext.ks.ksErrorAndAbort

export avcframewrk.forms.templating.ext.ks.valueFromQuotesOption

// private[avcframewrk]
object ksImplUtil
{
   ;

   // private[avcframewrk]
   object PlcPacked {
      ;

      def unapply
         [E : Type ]
         (e : Expr[Seq[E] ] )
         (using Quotes )
      = {
         ;

         //

         ;
         Some(e)
         .collect({
            case '{ Seq(${e1 } : _* ) } =>
               e1
               .asExprOf[Seq[E ] ]
         })
      }
   }

   export avcframewrk.forms.templating.ext.ks.ksImplUtil.{
      asLinebreaking as _,
      *, given
   }

   extension [V] (using ctx: Quotes) (impl: ctx.reflect.Printer[V] ) {
      //

      /** 
       * under VSCode,
       * without line-breaking like this,
       * would result in extended-duration hang in the "errors" tab
       * 
       */
      def asLinebreaking
         //
         (lineWidth : Int = 90, lineSep : String = System.lineSeparator().nn, lnCLimit: Int = 512 )
      : ctx.reflect.Printer[V]
      = (d) => {
         ;

         impl.show(d )

         .grouped(lineWidth )

         .take(lnCLimit)

         .mkString(lineSep )

         // .take({
         //    // 200
         //    // 20
         //    // 50
         //    // 300
         //    2000
         // } )
      }
   }

}














val _ = {}
