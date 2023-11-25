
package avcframewrk.forms

package templating

package ext.ks


















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

   object KvTupleOrigine {
      ;

      ;

      // type _Any
      // = Impl[T]

      // type _To[T0 <: Any & Tuple ]
      // = _Any & Impl[T0]

      // protected
      // trait Impl[T0 <: Any & Tuple ]
      // {
      //    def handle
      //       [T <: T0]
      //       (e : Expr[T] )
      //    : Expr[T0 ]
      // }

      // transparent
      // inline
      // def applyTo
      //    [T]
      //    (using _To[T] )
      //    (inline a: T )
      // : T
      // = ???

      transparent
      inline
      def applyToTuple2
         [V1, V2]
         (inline a: (V1, V2) )
      : (V1, V2)
      = ${applyToTuple2Impll('a) }

      def applyToTuple2Impll
         [V1: Type, V2: Type ]
         (aRef: Expr[(V1, V2)] )
         (using Quotes)
      : Expr[(V1, V2)]
      = {
         import quotes.reflect.*
         // import pipeLooseSelf
         aRef
         .pipeLooseSelf[(Expr[V1], Expr[V2] )] ({
            case '{((${e1} : t1 & V1 ) -> (${e2} : t2 & V2 ) ) } =>
               (e1, e2)
            case '{(${e1} : t1 & V1, ${e2} : t2 & V2 ) } =>
               (e1, e2)
            case e =>
               ('{ ${e }._1 } , '{ ${e }._2 } )
            case e =>
               throw new java.lang.IllegalArgumentException({
                  new MatchError(e).getMessage()
               })
         })
         .pipeLooseSelf[Expr[(V1, V2)] ] ({
            // case (e1, e2) if false =>
            //    '{
            //       ((val1: Any, val2: Any ) => {
            //          (val1, val2)
            //             : (val1.type, val2.type )
            //       } )
            //       .apply(${e1}, ${e2} )
            //    }
               
            case ('{ ${e1} : e1Type & (V1) }, '{ ${e2} : e2Type & (V2) } ) =>
               None
               .orElse({
                  for {
                     // case pVwExpr0 <- {
                     //    Expr.summon[ValueOf[(e1Type, e2Type ) ] ]
                     //    .orElse[Expr[ValueOf[(e1Type, e2Type ) ] ] ] ({
                     //       (Expr.summon[ValueOf[(e1Type ) ] ] zip Expr.summon[ValueOf[(e2Type ) ] ] )
                     //       .map({
                     //          case (e1, e2) =>
                     //             '{ ValueOf(${e1}.value -> ${e2}.value ) }
                     //       })
                     //    })
                     //    .orElse({ throw new IllegalStateException(s"no ValueOf for ${Type.show[(e1Type, e2Type )] } ") })
                     // }
                     case pExpr <- {
                        Expr.summonTupleValue2[e1Type, e2Type]
                        .collect({
                           case e @ ('{ ${_} : (t & (e1Type & V1, e2Type & V2 ) ) }) =>
                              e
                           case e =>
                              throw new IllegalStateException(s"not conform : ${Printer.TreeShortCode.asLinebreaking().show(e.asTerm ) } ")
                        })
                     }
                  }
                  yield pExpr
               })
               .getOrElse((
                  //
                  ('{
                     import ttSoming.Some

                     def someS
                        (e: Any)
                     = Some[e.type](e )

                     ({ val xs = someS(${e1 } ) })

                     ([T1, T2] => (p: (Some[T1] , Some[T2] ) ) => {
                        (p._1.value, p._2.value )
                     } : (T1, T2) )
                        ((someS(${e1 } ) , someS(${e2 } ) ) )
                  })
                  .asExprOf[(e1Type, e2Type ) & (V1, V2)]
               ))
         })
         .pipeLooseSelf(<:<.refl[Expr[(V1, V2)] ] )
      }

      object ttSoming {
         ;

         case class Some
            [A](value: A )

      }

      ;
   }

   protected
   implicit class _LocalQuotesUtil
      (iReceiver: Expr.type )
      (using Quotes )
   {
      ;

      import quotes.reflect.*

      ;

      def summonTupleValue2
         [
            e1Type : Type ,
            e2Type : Type ,
         ]
      : Option[Expr[(e1Type, e2Type)]]
      = {
         ;

         Expr.summon[ValueOf[(e1Type, e2Type ) ] ]
         .orElse[Expr[ValueOf[(e1Type, e2Type ) ] ] ] ({
            (Expr.summon[ValueOf[(e1Type ) ] ] zip Expr.summon[ValueOf[(e2Type ) ] ] )
            .map({
               case (e1, e2) =>
                  '{ ValueOf(${e1}.value -> ${e2}.value ) }
            })
         })
         .map(wrapperExpr => '{ ${wrapperExpr }.value } )
      }

      ;
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
