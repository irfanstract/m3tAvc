package avcframewrk.forms

package templating

package reactjs
















;

import scalajs.js

protected
object KS1 {
   ;

   ;

   ;

   import e_ks.{*, given }

   import KS.{*, given }

   ;

   export KS1.{*, given}

   /** 
    * instances each
    * provide the full impl, impl of those `applyDynamicNamed` and `applyDynamic` methods .
    * note --
    * cannot directly run instance methods in the top-level splice (ie the `${...}s`) in macro(s), so
    * needs a helper below, see below
    * 
    */
   object _Impl {
      ;

      type _Any
      = Impl[?, ?, ?]

      // type SS[+A] =
      //    (Singleton & A)

      class Impl
         [
         //
         +C <: (
            _RjsSubtypingGrapher.Impl

            // TODO remove this pre-narrowing
            & _RjsSubtypingGrapher.ImplAlt

            //
         ) & Singleton
         ,
         +PropsKvHandler0 <: (
            _PropsKvPairHandler.Impl
            { val kvpRjsSubtyper : C }

            //
         ) & Singleton
         ,
         +LHandler <: (
            _ElementLiteralHandler.Impl
            { val elhRjsSubtyper : C }

            //
         ) & Singleton
         ,
         ]
         (using val rSubtypeGrapher : C )
         (using val propsKvHandler : PropsKvHandler0 )
         (using val lHandler : LHandler )
      extends
      AnyRef
      {
         ;

         ;

         import slToExprValueOfGvns.{*, given }

         ;

         export rSubtypeGrapher.{
            _DataAny ,
            _ElementConstructor ,
         }

         export lHandler.{
            mroDynamicRjsElementImpl1 ,
         }
         export propsKvHandler.{
            propKvPairSeqCheckedImpl ,
         }

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

         ;
      }

      ;
   }

   object _RjsSubtypingGrapher {
      ;

      ;

      trait Impl
      extends
      AnyRef
      with _DataAnyDefsImpl
      {
         ;

         ;

         type _ElementConstructor

         // TODO
         type _Element
         <: _DataAny

         // TODO
         type _ElementFromCls
            [+C <: _ElementConstructor]
         <: _Element

         ;
      }

      trait _DataAnyDefsImpl
      extends
      AnyRef
      {
         ;

         ;

         type _DataAny

         ;
      }

      trait ImplAlt
      extends
      AnyRef
      with Impl
      {
         ;

         ;

         type _ElementConstructor
         >: String
         <: (
            // AnyVal | AnyRef
            String
         )

         // TODO
         type _Element
         >: _DataAny & ReactElement.FromCls[Any]
         <: _DataAny & ReactElement.FromCls[Any]

         // TODO
         type _ElementFromCls
            [+C <: _ElementConstructor ]
         >: _Element & ReactElement.FromCls[C]
         <: _Element & ReactElement.FromCls[C]

         override
         type _DataAny
         // TODO remove this pre-bounding
         >: ReactPropValueAny
         <: ReactPropValueAny

         ;
      }

      ;
   }

   object _PropsKvPairHandler
   {
      ;

      ;

      trait Impl
      extends
      AnyRef
      {
         // this : (
         //    // _RjsSubtypingGrapher.Impl
         //    _ElementLiteralHandler.Impl
         // ) =>

         ;

         val kvpRjsSubtyper
         : _RjsSubtypingGrapher.Impl
         // // : this.type
         // // = this

         import kvpRjsSubtyper.*

         ;

         ;

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

   object _ElementLiteralHandler
   {
      ;

      ;

      trait Impl
      extends
      AnyRef
      // with _RjsSubtypingGrapher.Impl
      {
         // this : (_RjsSubtypingGrapher.Impl) =>

         ;

         val elhRjsSubtyper
         : _RjsSubtypingGrapher.Impl
         // : this.type
         // = this

         import elhRjsSubtyper.*

         ;

         ;

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
         : quoted.Expr[_ElementFromCls[C] ]

         ;
      }

      ;
   }

   ;

   ;
}

;
















val _ = {}