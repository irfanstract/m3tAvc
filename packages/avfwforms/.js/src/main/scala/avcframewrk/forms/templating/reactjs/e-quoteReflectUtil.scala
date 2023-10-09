package avcframewrk.forms

package templating

package reactjs
















;

extension (quotesReflectReportingModule: quoted.Quotes#reflectModule#reportModule )
   transparent inline
   def ksErrorAndAbort(msg: => String, subjectedArea: quoted.Expr[Any] )
   : Nothing
   = ksErrorAndAbort(msg)
   def ksErrorAndAbort(msg: => String )
   : Nothing
   = {
      throw {
         object ksErrorException extends Exception(msg)
         ksErrorException
      }
   }

// private[avcframewrk]
object ksImplUtil
{
   ;

   import compiletime.*
   import quoted.*

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

   def plcPackQuotedVarargs
      [E : Type ]
      (expr: Expr[Seq[E] ] )
      (using Quotes)
   : Expr[Seq[E] ]
   = {
      import quotes.reflect.*
      expr
      match {
         // case Varargs(exprs) =>
         //    Expr.ofSeq(exprs)
         case Varargs[E](exprs) =>
            Expr.ofSeq(exprs)
         case e =>
            throw
               ({
                  e match {
                     case CrookedVarargs() =>
                        ;
                        new IllegalArgumentException({
                           s"[plcPackQuotedVarargs crooked varargs] ${Printer.TreeShortCode.asLinebreaking().show(e.asTerm ) } "
                        } )
                     case _ =>
                        ;
                        new IllegalArgumentException({
                           s"[plcPackQuotedVarargs match error] ${Printer.TreeShortCode.asLinebreaking().show(e.asTerm ) } "
                        } )
                  }
               })
      }
   }

   object VarargsOrSeqLike
   {

      def unapply
         [T : Type ]
         (expr: Expr[Seq[T] ] )
         (using Quotes)
      : Option[Seq[Expr[T]]]
      = {
         ;

         import quotes.reflect.*

         expr

         match {
            //

            case Varargs(e) =>
               Some(e)

            case '{ Seq[t](${ Varargs[T](e) } : _*) } =>
               /** oh god */
               Some {
                  e
               }

            case _ =>
               None
         }
      }
   }

   object CrookedVarargs
   {

      def unapply
         [T : Type ]
         (expr: Expr[Seq[T] ] )
         (using Quotes)
      // : Option[Seq[Expr[T]]]
      : Boolean
      = {
         ;

         import quotes.reflect.*

         expr

         match {
            //

            case e if {
               Printer.TreeCode.show(e.asTerm )
               .pipeLooseSelf({ val P = (util.matching.Regex.quote(".$asInstanceOf$[_* & _*]") + "\\s*" + "\\z" ).r.unanchored ; <:<.refl[String].andThen(P.unapplySeq(_) ) }.andThen(_.nonEmpty ) )
            } =>
               true

            case _ =>
               // None
               false
         }
      }
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
