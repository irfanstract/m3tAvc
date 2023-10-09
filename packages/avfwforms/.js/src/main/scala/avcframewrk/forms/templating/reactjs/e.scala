package avcframewrk.forms

package templating

package reactjs













import scalajs.js

val <
// : KS
// = new AnyRef
= new KSAsSelectableImpl(new AnyRef)

opaque type KS
<: Any
= AnyRef
object KS
{
   ;

   import language.dynamics

   ;

   ;

   object slToExprValueOfGvns {
      ;

      import compiletime.*
      import quoted.*

      @deprecated
      given picklingInstance[T : ValueOf : Type ]
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
      given unpicklingInstance[T ]
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

      object tvoImplicits {
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

   implicit class Sl(receiver: KS )
   extends
   AnyRef
   // with Selectable
   with Dynamic
   {
      ;

      import slToExprValueOfGvns.{*, given }

      transparent
      inline
      def applyDynamicNamed
         //
         [
            C <: _ElementConstructor ,
         ]
         (cls: C )
         (inline propSeq: (String, _DataAny )* )
      = ${mroDynamicRjsElementImpl(clsExpr = '{ cls } )('propSeq ) }

      transparent
      inline
      def applyDynamic
         //
         [
            C <: _ElementConstructor ,
         ]
         (cls: C )
         (inline children: (_DataAny )* )
      = ${mroDynamicRjsElementAltImpl(clsExpr = '{ cls } )('children ) }

      ;
   }

   /** 
    * if found,
    * legal
    * 
    */
   class Voibility[-C, -N <: Int ]

   export ksDefaultReactJsImpl.{*}

   object _Impl {
      ;

      type _Any
      = Impl[?]

      class Impl
         [C <: _ImplImpl.Impl & Singleton ]
         (using val ksDefaultImplImpl : C )
      extends
      AnyRef with ImplCtxsAndThereofTypeReexports
      {
         ;

         ;

         import slToExprValueOfGvns.{*, given }

         ;

         def mroDynamicRjsElementAltImpl
            //
            [
               C <: _ElementConstructor
               : quoted.Type
               ,
            ]
            (clsExpr: quoted.Expr[C] )
            (e0: quoted.Expr[Seq[(_DataAny ) ] ] )
            (using quoted.Quotes )
            (using quoted.Type[_DataAny] )
         = {
            ;

            val e = ksImplUtil.plcPackQuotedVarargs(e0)

            mroDynamicRjsElementImpl1(clsExpr = clsExpr )({
               ;

               '{ ${ e }.map(("", _ ) ) }
            })
         }

         def mroDynamicRjsElementImpl
            //
            [
               C <: _ElementConstructor
               : quoted.Type
               ,
            ]
            (clsExpr: quoted.Expr[C] )
            (e0: quoted.Expr[Seq[(String, _DataAny ) ] ] )
            (using quoted.Quotes )
            (using quoted.Type[_DataAny] )
         = {
            ;

            val e = ksImplUtil.plcPackQuotedVarargs(e0)

            mroDynamicRjsElementImpl1(clsExpr = clsExpr )({
               ;

               propKvPairSeqCheckedImpl(clsExpr = clsExpr )(e)
            })
         }

         export ksDefaultImplImpl.{
            mroDynamicRjsElementImpl1 ,
            propKvPairSeqCheckedImpl ,
         }

         @annotation.experimental
         private[forms]
         def e3(e: _ElementConstructor )
         : ksDefaultImplImpl._ElementConstructor
         = e

         ;
      }

      protected
      trait ImplCtxsAndThereofTypeReexports
      {
         ;

         val ksDefaultImplImpl : _ImplImpl.Impl

         export ksDefaultImplImpl.{
            _DataAny ,
            _ElementConstructor ,
         }

         ;
      }

      ;
   }

   object _ImplImpl {
      ;

      trait Impl
      {
         ;

         ;

         type _ElementConstructor

         type _DataAny

         def mroDynamicRjsElementImpl1
            //
            [
               C <: _ElementConstructor
               : quoted.Type
               ,
            ]
            (clsExpr: quoted.Expr[C] )
            (  e1: quoted.Expr[Seq[(String, _DataAny ) ] ] )
            (using quoted.Quotes )
         : quoted.Expr[ReactElement.FromCls[C] ]

         def propKvPairSeqCheckedImpl
            //
            (clsExpr: (
               // quoted.Expr[? >: _ElementConstructor <: Any]
               quoted.Expr[? <: Any]
            ) )
            (e: quoted.Expr[Seq[(String, _DataAny ) ] ] )
            (using quoted.Quotes )
         : quoted.Expr[Seq[(String, _DataAny ) ] ]

         ;
      }

      ;
   }

}

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

export KS.{Sl as KSAsSelectableImpl }













val _ = {}
