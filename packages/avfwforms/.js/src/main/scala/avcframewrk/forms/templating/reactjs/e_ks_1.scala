package avcframewrk.forms

package templating

package reactjs
















;

import scalajs.js

protected
trait KS1 private[forms] ()
{
   this : KS.type =>
   ;

   ;

   ;

   import e_ks.{*, given }

   ;

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

            // // TODO remove this pre-narrowing
            // & _RjsSubtypingGrapher.ImplAlt

            //
         ) & Singleton
         ,
         +PropsKvHandler0 <: (
            _PropsKvPairHandler.Impl
            // { val kvpRjsSubtyper : C }

            //
         ) & Singleton
         ,
         +LHandler <: (
            _ElementLiteralHandler.Impl
            // { val elhRjsSubtyper : C }

            //
         ) & Singleton
         ,
         ]
         (using val rSubtypeGrapher : C )
         (using val propsKvHandler : (_PropsKvPairHandler.Impl { val kvpRjsSubtyper: rSubtypeGrapher.type } ) & PropsKvHandler0 )
         (using val lHandler : (_ElementLiteralHandler.Impl { val elhRjsSubtyper: rSubtypeGrapher.type } ) & LHandler )
      extends
      AnyRef
      {
         ;

         ;

         import slToExprValueOfGvns.{*, given }

         ;

         /** 
          * ensure that
          * the above ctor does not eagerly narrow it to those Scalably-Typed-generated itc(s)
          * 
          */
         implicitly[(
            util.NotGiven[(
               rSubtypeGrapher.type <:< _RjsSubtypingGrapher.ImplAlt
            )]
         )]

         export rSubtypeGrapher.{
            _DataAny ,
            _ElementConstructor ,
            _ElementFromCls ,
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

   /** 
    * instances each
    * provide narrowing/specialisation of each of all these (opaque) `type`s
    * 
    */
   object _RjsSubtypingGrapher {
      ;

      ;

      trait Impl
      extends
      AnyRef
      with _DataAnyDefsImpl
      with _RjsElementsImpl
      {
         ;

         ;

         ;
      }

      trait _RjsElementsImpl
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

      /** 
       * exactly for `_DataAny`
       * 
       */
      trait _DataAnyDefsImpl
      extends
      AnyRef
      {
         ;

         ;

         type _DataAny

         ;
      }

      /**
       *  
       * (...)
       * which does these narrowing/instantiation(s) to those Scalably-Typed-generated bindings for the Definitely-Typed Package `react`
       * 
       */
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

   /** 
    * 
    * each time
    * translates an expr `'cls` and an expr `'propsAndChildrenKv`
    * into the associated-backend-specific "Element"
    * 
    */
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

   ;

   // TODO
   final
   lazy val slToExprValueOfGvns
   = singletonTypeToQuotedExprGvns

   ;
}

;
















val _ = {}