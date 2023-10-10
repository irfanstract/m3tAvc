package avcframewrk.forms

package templating

package reactjs
















;

import compiletime.{ops as _, *}
import quoted.{runtime as _, *}

extension (quotesReflectReportingModule: Quotes#reflectModule#reportModule )
   transparent inline
   def ksErrorAndAbort(msg: => String, subjectedArea: Expr[Any] )
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

/** 
 * a `Quotes`-specific  way to achieve an instance of a single-instance type `I#`
 * 
 */
def valueFromQuotesOption
   [I <: Singleton ]
   (using Type[I] )
   (using Quotes)
: Option[I]
= {
   ;

   import quotes.reflect.*

   None
   .orElse(Type.valueOfConstant[I] )
   .orElse({
      for {
         case TermRef(prefixT, name) <- Some(TypeRepr.of[I] )
         // prefixObj <- Type.valueOfConstant(using prefixT.asType.asInstanceOf[Type[? <: Any ] ] )
         // _ <- Option.when(prefixT.sym) {}
         cS <- prefixT.classSymbol
         r <- {
            ;

            // ;
            // report
            // .ksErrorAndAbort(s"[KS] TermRef(${prefixT }, '$name' ) -> (in ${cS.fullName } ) ; ", implRef )
            /** reflection is unavailable on SJS .. hope that the SJS compiler don't pick this LOC up */
            ({
               import language.unsafeNulls
               for {
                  r1 <- {
                     ;

                     // java.lang.invoke.MethodHandles.lookup()
                     // .in(java.lang.Class.forName(cS.fullName ) )
                     java.lang.Class.forName({
                        cS.fullName
                        .replace("-", "$minus")
                     })
                     .getFields()
                     .find(_.getName().startsWith("MODUL") )
                     .map(_.get(null ) )
                  }
               }
               yield {
                  ;

                  r1
                  .pipeLooseSelf(e => e.getClass().getMethod(name).invoke(e) )
                  .asInstanceOf[I]
               }
            })
         }
      }
      yield {
         r
      }
   } )
}

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
