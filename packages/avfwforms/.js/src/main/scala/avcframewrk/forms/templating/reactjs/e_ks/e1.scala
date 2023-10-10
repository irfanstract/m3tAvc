package avcframewrk.forms

package templating

package reactjs

package e_ks













import scalajs.js

final
lazy val ksDefaultReactJsImpl
= {
   ;
   given ksDefaultReactJsImplImpl.type
   = ksDefaultReactJsImplImpl
   KS._Impl.Impl.apply()
}

object ksDefaultReactJsImplMethodism
{
   ;

   ;

   // protected
   // abstract
   object slMethodsImpl
   extends
   KS.SlMethodsTo(using ksDefaultReactJsImpl )
   {
      ;

      private[ksDefaultReactJsImplMethodism]
      object localImpl {
         export ksDefaultReactJsImpl.{*}
      }

      override
      transparent
      inline
      def applyDynamicNamed
         //
         [
            // C <: _ElementConstructor ,
            T1 ,
         ]
         (cls: impl._ElementConstructor )
         (inline propSeq: (String, ReactPropValueAny )* )
      // TODO
      = ${localImpl.mroDynamicRjsElementImpl(('cls ) : quoted.Expr[cls.type] )('propSeq ) }

      override
      transparent
      inline
      def applyDynamic
         //
         [
            // C <: _ElementConstructor ,
            T1 ,
         ]
         (cls: impl._ElementConstructor )
         (inline children: ReactPropValueAny* )
      // TODO
      = ${localImpl.mroDynamicRjsElementAltImpl(('cls ) : quoted.Expr[cls.type] )('children ) }

      ;
   }

   ;
}

import KS.{
   _RjsSubtypingGrapher ,
   _PropsKvPairHandler ,
   _ElementLiteralHandler ,
}

protected
object ksDefaultReactJsImplImpl
extends
AnyRef
with _RjsSubtypingGrapher.Impl
with _PropsKvPairHandler.Impl
with _ElementLiteralHandler.Impl
{

   private[avcframewrk]
   final
   lazy val PlcPacked
   = ksImplUtil.PlcPacked

   val kvpRjsSubtyper : this.type = this

   val elhRjsSubtyper : this.type = this

   type _ElementConstructor
   >: String | typings.react.mod.FunctionComponent[?] | typings.react.mod.ExoticComponent[typings.react.anon.Children ]
   <: String | typings.react.mod.FunctionComponent[?] | typings.react.mod.ExoticComponent[typings.react.anon.Children ]

   type _DataAny
   >: ReactPropValueAny
   <: ReactPropValueAny

   // TODO
   type _Element
   >: _DataAny & ReactElement.FromCls[Any]
   <: _DataAny & ReactElement.FromCls[Any]

   // TODO
   type _ElementFromCls
      [+C <: _ElementConstructor ]
   >: _Element & ReactElement.FromCls[C]
   <: _Element & ReactElement.FromCls[C]

   def mroDynamicRjsElementImpl1
      //
      [
         C <: _ElementConstructor
         : quoted.Type
         ,
      ]
      (clsExpr: quoted.Expr[C] )
      // (e: quoted.Expr[Seq[(String, _DataAny ) ] ] )
      (  e1: quoted.Expr[Seq[(String, _DataAny ) ] ] )
      (using quoted.Quotes )
   = {
      import quoted.*
      import avcframewrk.forms.templating.ext.ks.ksImplUtil.asLinebreaking
      import quotes.reflect.*
      '{
         ;

         val cls = ${clsExpr }

         val (props, children)
         = {
            byEClsHandler(cls )
            .propsAndChildrenFromApplyDyn((
               // propKvPairSeqChecked(cls )(propSeq )
               ${e1 }
            ) )
         }

         (${
            '{cls} match

            case '{ ${clsRef } : (t & String) } =>
               '{
                  ;
                  describeElement(
                     ${ clsRef },
                     props,
                     children : _* )
               }

            case '{
               ${clsRef } : (
                  typings.react.mod.FunctionComponent[propsType ]
               )
            } =>
               '{
                  ;
                  describeElement(
                     ${ clsRef },
                     props.asInstanceOf[props.type & propsType ] ,
                     children : _* )
               }

            // case '{
            //    ${clsRef } : (
            //       typings.react.mod.ExoticComponent[childrenType ]
            //    )
            // } =>
            //    '{
            //       ;
            //       // TODO
            //       describeElement(
            //          ${ clsRef }
            //          .asInstanceOf[typings.react.mod.FunctionComponent[props.type ] ]
            //          ,
            //          props ,
            //          children : _* )
            //    }

            case expr @ '{ ${clsRef } : _t } =>
               ;
               import quotes.reflect.*
               throw new IllegalArgumentException((
                  s"expr: ${Printer.TreeShortCode.asLinebreaking().show(clsRef.asTerm) } : ${Printer.TypeReprCode.asLinebreaking().show(TypeRepr.of[_t ].dealias ) } "
               ))
         } : ReactElement )
         .asInstanceOf[ReactElement.FromCls[cls.type ] ]
      }
   }

   private[reactjs]
   def byEClsHandler
      (c : _ElementConstructor)
   = {
      ;
      // TODO
      new AnyRef
      with EClsHandlerOpsImpl[?]
   }

   private[reactjs]
   trait EClsHandlerOpsImpl
      [T1] private[reactjs] ()
   {
      ;

      ;

      // protected
      def propsAndChildrenFromApplyDyn
         //
         (propSeq: Seq[(String, ReactPropValueAny ) ] )
      = {
         ;

         //

         import PropsAndChildren1.{* }

         propSeq
         .foldLeft[PropsAndChildren1 ] (({
            ;

            /** it's mutable ; shall not use the fnc-al syntax */
            val dict
            = typings.react.mod.Attributes()

            PropsAndChildren1(
               //
               attribValues = Map()
               ,
               children = IndexedSeq()
               , 
            )
         }))({
            //
            case (s0, (k, v) ) =>
               ;
               import s0.{children as children0 }

               (k *: v *: EmptyTuple)
               match {
                  //

                  case ("" | "child") *: _ *: EmptyTuple =>
                     ;
                     adding1
                     .apply(v.asInstanceOf[_ChildNode] )
                           (s0 )

                  case "children" *: v *: EmptyTuple =>
                     ;
                     addingAll
                     .apply({
                        v.asInstanceOf[collection.immutable.Iterable[Any ] ]
                     } )
                           (s0 )

                  case _ *: _ *: EmptyTuple =>
                     ;
                     addingAttrib
                     .apply((k, v) )
                           (s0 )

               }
         })
         .pipeLooseSelf(_.toTuple )
      }

      ;

      type _ChildNode
      >: ReactElement
      <: ReactElement

      ;

      case class PropsAndChildren1(
         //
         attribValues : Map[String, ReactPropValueAny ]
         ,
         children : IndexedSeq[_ChildNode]
         ,
      )
      {
         ;

         def toTupleOf2 = (attribValues, children)

         @deprecated
         def toTuple = (this.attribValuesScalablytyped, children)

         ;
      }

      object PropsAndChildren1 {
         ;

         //

         ;

         val addingAttrib
         = {
            ;
            monocle.macros.GenLens[PropsAndChildren1](_.attribValues )
            .pipeLooseSelf(l => {
               (kv: (String, ReactPropValueAny ) ) =>
               (receiver: PropsAndChildren1 ) =>
                  val (k, v) = kv
                  l
                  .modify(propsBefore => propsBefore.updated(k, v ) )(receiver)
            })
         }

         val addingAll
         = {
            ;
            monocle.macros.GenLens[PropsAndChildren1](_.children )
            .pipeLooseSelf(l => {
               (children: collection.immutable.Iterable[? >: _ChildNode <: Any ] ) =>
               (receiver: PropsAndChildren1 ) =>
                  l
                  .modify(_ :++ {
                     children
                     .flatMap({
                        case Seq(e @ _* ) =>
                           e
                           .map(e => e.asInstanceOf[_ChildNode] )
                        case e =>
                           Seq() :+ e.asInstanceOf[_ChildNode]
                     } )
                  } )(receiver)
            })
         }

         val adding1
         = {
            ;
            addingAll
            .compose(IndexedSeq().appended[_ChildNode] _ )
         }

         extension (d: PropsAndChildren1 )
            def attribValuesScalablytyped
            = {
               d.attribValues
               .foldLeft[typings.react.mod.Attributes ] ({
                  typings.react.mod.Attributes()
               })({
                  case (receiver, kv ) =>
                     (receiver.set _ ).tupled
                     .apply(kv )
               })
            }

         ;
      }

      ;

      ;
   }

   // protected[templating]
   def propKvPairSeqCheckedImpl
      //
      (clsExpr: (
         // quoted.Expr[? >: _ElementConstructor <: Any]
         quoted.Expr[? <: Any]
      ) )
      (e: quoted.Expr[Seq[(String, _DataAny ) ] ] )
      (using quoted.Quotes )
   : quoted.Expr[Seq[(String, _DataAny ) ] ]
   = {
      ;

      import quoted.*
      import quotes.reflect.*

      import ksImplUtil.VarargsOrSeqLike

      import ksImplUtil.asLinebreaking

      // TODO
      def eshow(e: Term)
      = {
         s"(${e.getClass().getName() }) ${Printer.TreeCode.asLinebreaking().show(e) } "
      }

      e
   }

   export supplementaryPccs.{given}
   // export supplementaryPccs.{denyEverythingsInstance as denyEverythingsPcc }

   ;

   export PropCheckCompulsion.{commonAttribSpellingsTutoUrl as commonAttribSpellingsTutoUrl }

   ;
}

;















val _ = {}
