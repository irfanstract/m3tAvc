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
                  .getOrElse(report.errorAndAbort("cannot re-resolve the ValueOf[T]") )
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
            .getOrElse(report.errorAndAbort(s"no Type.valueOfConstant[T]. \neligible types include (... ...) ") )
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

      transparent
      inline
      def applyDynamicNamed
         //
         [
            C <: _ElementConstructor ,
         ]
         (cls: C )
         (inline propSeq: (String, _DataAny )* )
      = ${mroDynamicRjsElementImpl(clsExpr = '{ cls } )('{ Seq(propSeq : _* ) } ) }

      transparent
      inline
      def applyDynamic
         //
         [
            C <: _ElementConstructor ,
         ]
         (cls: C )
         (inline children: (_DataAny )* )
      = ${mroDynamicRjsElementAltImpl(clsExpr = '{ cls } )('{ Seq(children : _* ) } ) }

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

      class Impl
         [C <: _ImplImpl.Impl & Singleton ]
         (using val ksDefaultImplImpl : C )
      extends
      AnyRef with ImplCtxsAndThereofTypeReexports
      {
         ;

         ;

         def mroDynamicRjsElementAltImpl
            //
            [
               C <: _ElementConstructor
               : quoted.Type
               ,
            ]
            (clsExpr: quoted.Expr[C] )
            (e: quoted.Expr[Seq[(_DataAny ) ] ] )
            (using quoted.Quotes )
            (using quoted.Type[_DataAny] )
         = {
            ;

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
            (e: quoted.Expr[Seq[(String, _DataAny ) ] ] )
            (using quoted.Quotes )
         = {
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

// private[avcframewrk]
object ksImplUtil
{
   ;

   // private[avcframewrk]
   object PlcPacked {
      ;

      def unapply
         [E : quoted.Type ]
         (e : quoted.Expr[Seq[E] ] )
         (using quoted.Quotes )
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

}

export KS.{Sl as KSAsSelectableImpl }













val _ = {}
