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
   KS.SlClsAndApplyArgsMethodsTo(using ksDefaultReactJsImpl )
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
      (  argsKvExpr: quoted.Expr[Seq[(String, _DataAny ) ] ] )
      (using quoted.Quotes )
   : quoted.Expr[_ElementFromCls[C] ]
   = {
      import quoted.*
      import avcframewrk.forms.templating.ext.ks.ksImplUtil.asLinebreaking
      import quotes.reflect.*
      ;

      new %%%!( )
      .main[C](clsExpr = clsExpr )(argsKvExpr )
   }

   private
   class %%%!
      //
      ( )
      (using val splctx : quoted.Quotes )
   {
      ;

      ;

      import quoted.*
      import avcframewrk.forms.templating.ext.ks.ksImplUtil.asLinebreaking
      import quotes.reflect.*
      ;

      ;

      def main
         //
         [
            C <: _ElementConstructor
            : Type
            ,
         ]
         (clsExpr: Expr[C] )
         (  argsKvExpr: Expr[Seq[(String, _DataAny ) ] ] )
      = {
         ;

         ;

         lazy val jsxIntrinsicElements
         = {
            StdPropsCheckCompulsion.jsxIntrinsicElements
         }

         (for {
            (ccs1 @ ccs) <-
               util.Try({ jsxIntrinsicElements })
         }
         yield {
            ;

            val argKvExprsOption
            = {
               (for {
                  argKvExprs <- Varargs.unapply(argsKvExpr)
               }
               yield {
                  argKvExprs
               })
               .orElse({
                  ;
                  report.warning((
                     s"args cannot be parsed as varargs, which means, no checking! \n  ${Printer.TreeShortCode.asLinebreaking().show(argsKvExpr.asTerm ) } "
                  ))
                  None
               })
            }

            val eCheckExpr1 = {
               ;

               None
               .orElse({
                  ;

                  (for {
                     case '{ ${Expr(cls) } : String } <- Some(clsExpr)
                     clsH <- ccs.get(cls )
                  } yield {

                     def checkNamedArgTypeConforms
                        (k: String, kExpr: Expr[?])
                        (valueExpr: Expr[?])
                     = {
                        ;

                        val valueExprTp = valueExpr.asTerm.tpe

                        {
                           ;

                           clsH._2.allPropsNameToS.get(k)
                           .fold({
                              report.error(s"not found: prop $k \n  $k = ${Printer.TreeShortCode.asLinebreaking().show(valueExpr.asTerm ) } \n  ^^^\ncheck the spelling right and \ntry again " , kExpr )
                           })(s => {
                              ;

                              (valueExprTp.asType *: s.tree.asInstanceOf[ValDef].tpt.tpe.asType *: EmptyTuple)
                              .pipeLooseSelf({ case ('[actualT] *: '[expectedT] *: EmptyTuple) => {
                                 None
                                 .orElse(Expr.summon[actualT <:< expectedT ] )
                              } })
                           })
                        }
                        // TODO
                     }

                     // TODO
                     for {
                        argKvExprs <- argKvExprsOption
                     }
                     yield {
                        for {
                           case '{ (${kExpr @ Expr(k) } : String, ${valueExpr } ) } <- (
                              argKvExprs
                           )
                           _ <- Option.when(!k.matches("key|ref|child|children|") )({ })
                        }
                        yield {
                           ;
                           checkNamedArgTypeConforms(k, kExpr = kExpr )(valueExpr = valueExpr )
                        }
                     }
                     '{}
                  } )
               })
               .orElse({
                  ;

                  (for {
                     case '{ ${clsExpr } : AvfwReactFunctionComponent[t] } <- Some(clsExpr)
                     // clsH <- ccs.get(cls )
                  } yield {
                     report.warning((
                        s"props needs to conform to the FunctionComp props type ${Printer.TypeReprCode.asLinebreaking().show(TypeRepr.of[t] ) } "
                     ))
                     // TODO
                     clsExpr
                     '{}
                  } )
               })
               .fold[Expr[? <: Any] ]({
                  ;
                  report.warning((
                     //

                     Seq()
                     :+ s"cannot resolve prop-type for '${Printer.TreeCode.asLinebreaking().show(clsExpr.asTerm ) }' . "
                     :+ s"no static-checking can be done . "
                     mkString("\n")
                  ) )
                  '{}
               })(e => e)
            }

            '{
               ;

               ${eCheckExpr1 }

               val clsHandler = {
                  byEClsHandler(${clsExpr } )
               }

               import clsHandler.{constructor1 as cls }

               val (props, children )
               = {
                  clsHandler
                  .propsAndChildrenFromApplyDyn((
                     // propKvPairSeqChecked(cls )(propSeq )
                     ${argsKvExpr }
                  ) )
               }

               (${
                  ;

                  ;

                  // TODO
                  // ${ccs1 }
                  ;

                  lazy val finalCallExpr
                  = {
                     ;

                     '{
                        ;

                        (${rceCurriedRightAfterCls('{ cls } ) })
                        .apply(props = props , children = children )
                     }
                  } : Expr[ReactElement]

                  Option.when(true)(finalCallExpr )

                  finalCallExpr
               } : ReactElement )
               .asInstanceOf[ReactElement.FromCls[cls.type ] ]
            }
         }
         )
         .recover({ case z : MatchError => {
            throw {
               ;

               import language.unsafeNulls

               new AssertionError(z)
            }
         } })
         .get
      }

      def rceCurriedRightAfterCls
         //
         (clsRef : Expr[_ElementConstructor] )
      = {
         ;

         '{
            locally[(props : typings.react.mod.Attributes, children: Seq[ReactNode]) => ReactElement ] ((props, children) => {
               ;

               ${
                  ;

                  clsRef match

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

                  case expr =>
                     ;
                     import quotes.reflect.*
                     throw new AssertionError((
                        s"expr: : ${Printer.TreeCode.asLinebreaking().show(expr.asTerm ) } "
                     ))
               }
            })
         }
      }

      ;

      ;
   }

   private[reactjs]
   def byEClsHandler
      (c : _ElementConstructor)
   = {
      ;
      // TODO
      new AnyRef
      with EClsHandlerOpsImpl[?]
      // with Selectable
      {
         ;

         val constructor1
         : c.type
         = c
      }
   }

   private[reactjs]
   trait EClsHandlerOpsImpl
      [T1] private[reactjs] ()
   {
      ;

      ;

      val constructor1
      : _ElementConstructor

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
         .pipeLooseSelf(p => (
            EmptyTuple
            :* p.attribValuesScalablytyped
            :* p.children
         ) )
      }

      ;

      type _ChildNode
      >: ReactElement
      <: ReactElement

      ;

      case class PropsAndChildren1(
         //
         attribValues : Map[String, PropsAndChildren1.XExprOrRl[ReactPropValueAny] ]
         ,
         children : IndexedSeq[PropsAndChildren1.XExprOrRl[_ChildNode] ]
         ,
      )
      {
         ;

         @deprecated
         protected[PropsAndChildren1 ]
         def toTupleOf2 = (attribValues, children)

         @deprecated
         protected[PropsAndChildren1 ]
         def toTuple = (this.attribValuesScalablytyped, children)

         ;
      }

      object PropsAndChildren1 {
         ;

         //

         ;

         type XExprOrRl
            [+R]
         >: R @annotation.unchecked.uncheckedVariance
         <: R

         val addingAttrib
         = {
            ;
            monocle.macros.GenLens[PropsAndChildren1](_.attribValues )
            .pipeLooseSelf(l => {
               (kv: (String, XExprOrRl[ReactPropValueAny] ) ) =>
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
               (children: collection.immutable.Iterable[? >: XExprOrRl[_ChildNode] <: XExprOrRl[Any] ] ) =>
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
            .compose(IndexedSeq().appended[XExprOrRl[_ChildNode] ] _ )
         }

         extension (d: PropsAndChildren1 )
            def attribValuesScalablytyped
            = {
               d.attribValues
               .foldLeft[XExprOrRl[typings.react.mod.Attributes ] ] ({
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
