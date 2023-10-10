package avcframewrk.forms

package templating

package reactjs

package e_ks


















;

import scalajs.js

private
object StdPropsCheckCompulsion
{
   ;

   import compiletime.*
   import quoted.*

   ;

   import PropCheckCompulsion.{*, given }

   ;

   ;

   def jsxIntrinsicElements
      //
      (using quoted.Quotes)
   = new jsxIntrinsicElementsImpl

   private[reactjs]
   class jsxIntrinsicElementsImpl
      //
      [SplCtx <: quoted.Quotes & Singleton ]
      (using val x$1 : SplCtx)
   {
         ;

         import quotes.reflect.*

         ;

         val stJsxRtIntrinsicElementsSymb
         = {
            ;

            TypeRepr.of[typings.react.mod.JSX.IntrinsicElements ].classSymbol.get
         }

         /**
          * at/in (the Scalably-Typed binding of) `JSX.IntrinsicElements`
          * 
          */
         val ieSymbols
         = {
            ;

            import language.unsafeNulls

            stJsxRtIntrinsicElementsSymb
            .fieldMembers
            /* sort according to a modified phonetic rule . TODO normalise those European letters */
            .sorted(using (
               xModifiedPhoneticalSimpleNameOrdering
            ))
         }

         /** 
          * lookup
          * the corresponding field
          * at/in (the Scalably-Typed binding of) `JSX.IntrinsicElements`
          * 
          */
         def findJsxRtIntrnsicSymbol
            (c: String )
         = {
            ;
            ieSymbols
            .find(s => ( s.name == c ) )
         }

         def apply
            //
            (c: String )
         = get(c).get

         def get
            //
            (c: String )
         = {
            ;
            findJsxRtIntrnsicSymbol(c )
            .map(s => ({
               ;

               import ieUtil.XTypeBox

               val fullPropsTypeBox
               = {
                  s.tree
                  .asInstanceOf[ValDef]
                  .tpt
                  .tpe
                  .asType
                  .pipeLooseSelf({ case '[t] => {
                     new XTypeBox[t]
                  } })
               }

               new AnyRef with Selectable
               with ieUtil.XPerEntryOps.ForBackingTypeBoxes._ForT(fullPropsTypeBox = fullPropsTypeBox)
               {
                  ;

                  // type FullProps
                  // >: fullPropsTypeBox.CAP
                  // <: fullPropsTypeBox.CAP

                  // implicit
                  // def fullPropsTypeTag
                  // : Type[FullProps]
                  // = {
                  //    fullPropsTypeBox.given_Type_CAP
                  // }

                  // def fullPropsType
                  // = {
                  //    fullPropsTypeTag
                  // }

                  // def fullPropsTypeRepr
                  // = {
                  //    TypeRepr.of[FullProps ]
                  // }

                  // TODO
                  lazy val allPropsS
                  : List[Symbol]
                  = {
                     fullPropsTypeRepr
                     .baseClasses
                     .flatMap(_.fieldMembers )
                     .sorted(using xModifiedPhoneticalSimpleNameOrdering )
                  }

                  def allPropNames
                  = {
                     allPropsS
                     .map(_.name )
                  }

                  // TODO
                  lazy val allPropsNameToS
                  = {
                     allPropsS
                     .map(s => (s.name -> s ) )
                     .toMap
                  }

                  def selectPropNames
                     //
                     (f: collection.immutable.Iterable[String] => Seq[String ] )
                  = {
                     ;
                     new Selectable
                     {
                        //

                        val asPropSList
                        = {
                           ;

                           allPropNames
                           .toIndexedSeq
                           .pipeLooseSelf(s0 => {
                              val s1 = f(s0).toIndexedSeq
                              val falseItems
                              = s1.filterNot(s0.contains _ )
                              for { _ <- falseItems }
                              do { throw new IllegalArgumentException(s"false items: ${falseItems.length } " ) }
                              s1
                           })
                           .map(s => (allPropsNameToS.apply(s) ) )
                        }

                        def asApplyDynamicNamedParamKvTupleTypeRepr
                        = {
                           ;

                           (for {
                              s <- asPropSList.toList
                           }
                           yield {
                              val sDecl = s.tree.asInstanceOf[ValDef]
                              val sName = s.name
                              val sValueTypeRepr = sDecl.tpt.tpe
                              val sValueType = sValueTypeRepr.asType
                              AppliedType(TypeRepr.of[Tuple2 ], Nil :+ Expr(sName ).asTerm.tpe :+ sValueTypeRepr )
                           } )
                           .pipeLooseSelf(t => {
                              t
                              .reduce(OrType.apply _ )
                           })
                        }

                        def asPropFactoryExpr
                        = {
                           ;

                           asPropSList
                           .pipeLooseSelf(sList => {
                              ;

                              /** 
                               * a MT out of the described field(s) in exact order
                               * 
                               */
                              val mt
                              = {
                                 ;

                                 MethodType(sList.toList.map(_.name ) )(_ => {
                                    for {
                                       s <- sList.toList
                                    }
                                    yield {
                                       val sDecl = s.tree.asInstanceOf[ValDef]
                                       val sValueTypeRepr = sDecl.tpt.tpe
                                       val sValueType = sValueTypeRepr.asType
                                       sValueTypeRepr
                                    }
                                 } , _ => fullPropsTypeRepr )
                              }

                              ;
                              mt
                              .pipeLooseSelf(mt => {
                                 ;

                                 Typed(Lambda(Symbol.spliceOwner, mt, (_, paramRefs) => {
                                    ;

                                    // TODO
                                    ('{ {
                                       ;

                                       /** 
                                        * a `js.Dictionary` containing the expected KV pairs
                                        * 
                                        */
                                       js.Dictionary(${
                                          ;

                                          Expr.ofSeq({
                                             ;

                                             sList
                                             .zipWithIndex
                                             .map({
                                                case (s, sI) =>
                                                   val sName = s.name
                                                   '{ (
                                                      ${Expr(sName ) }
                                                      ->
                                                      ${paramRefs.apply(sI ).asExpr }
                                                   ) }
                                             })

                                             .map(<:<.refl )
                                          })
                                       } : _* )
                                    } })
                                    .pipeLooseSelf({
                                       ;
                                       mt.resType
                                       .asType
                                       .pipeLooseSelf({ case '[t] => {
                                          ;
                                          (e: Expr[js.Dictionary[?] ] ) =>
                                             '{
                                                // ((_: Any ).asInstanceOf[t ] ).apply(${e } )
                                                ${e.asExprOf[t] } : t
                                             }
                                       } })
                                    } )
                                    .asTerm
                                 } ) , {
                                    Refinement(TypeRepr.of[scala.PolyFunction] , "apply", mt )
                                    .asType
                                    .pipeLooseSelf({ case '[t] => TypeTree.of[t] })
                                 } )
                                 .asExpr
                              })
                           })
                        }

                        //
                     }
                  }

                  // def selectPropNamesAsPropSList
                  //    //
                  //    (f: collection.immutable.Iterable[String] => Seq[String ] )
                  // = {
                  //    selectPropNames(f).asPropSList
                  // }

                  // def selectPropNamesAsPropFactoryExpr
                  //    //
                  //    (f: collection.immutable.Iterable[String] => Seq[String ] )
                  // = {
                  //    selectPropNames(f).asPropFactoryExpr
                  // }

                  ;
               }
            }).pipeLooseSelf({
               def byf(c1: Any): (c.type, c1.type) = (c, c1)
               c1 => byf(c1)
            }))
         }

         private[reactjs]
         object ieUtil {
            ;

            class XTypeBox
               [t ]
               (using tTag : Type[t] )
            {
               ;

               type CAP = t
               given given_Type_CAP
               : Type[CAP]
               = tTag
            }

            object XPerEntryOps {
               ;

               ;

               object ForBackingTypeBoxes {
                  ;

                  trait _ForT
                     [t]
                     (val fullPropsTypeBox : XTypeBox[t] )
                  {
                     ;

                     ;

                     type FullProps
                     >: fullPropsTypeBox.CAP
                     <: fullPropsTypeBox.CAP

                     implicit
                     def fullPropsTypeTag
                     : Type[FullProps]
                     = {
                        fullPropsTypeBox.given_Type_CAP
                     }

                     def fullPropsType
                     = {
                        fullPropsTypeTag
                     }

                     def fullPropsTypeRepr
                     = {
                        TypeRepr.of[FullProps ]
                     }

                     ;
                  }

                  ;
               }

               ;
            }

            // trait SPropNmsResultOps
            // {
            //    ;

            //    val asPropSList
            //    : IndexedSeq[Symbol]

            //    def asPropFactoryExpr
            //    : Expr[Any]

            //    ;
            // }

            ;
         }

         new AnyRef
         with Selectable
         {
            ;
         }
   }

   // /** 
   //  * optional
   //  * one of
   //  * the mandated early-searched instances
   //  * 
   //  */
   // private[forms]
   // // transparent
   // // inline
   // def conformantCheckerForCommons11Option
   //    [Key <: String , Value >: Any <: Any ]
   //    // (ctx: CcoLookupCtx.ByKey[? <: String] )
   //    (ctx: CcoLookupCtx.ByKey[? <: Key ] )
   // : Option[_CheckingFnc.ByPropNameAndValue[Key, Value] ]
   // = {
   //    ;

   //    import ctx.{key as ccTargetPropKey }

   //    ;

   //    val SCF
   //    = _CheckingFnc.apply[Key, Value].andThen(Some(_) )

   //    def blockingAskRewrite
   //       //
   //       (valueExpr : quoted.Expr[Value ], ccLookupCaseActualKey: String )
   //       (finalName: String )
   //       (using cQuotes: quoted.Quotes)
   //    : Unit
   //    = {
   //       ;

   //       ;

   //       import compiletime.*
   //       import quoted.*
   //       import cQuotes.reflect.*

   //       report.error((
   //          (
   //             Seq()
   //             :+ s"mis-named property '${ccLookupCaseActualKey }' ;"
   //             :+ s"use '${finalName }' instead."
   //             :+ "=== "
   //             :+ s"React and ReactDOM \nrenames some attrib names, including these ones,"
   //             :+ s"like <<'${ccLookupCaseActualKey }' becomes '${finalName }'>> ."
   //             :+ s"for more info, including the proper supported <e>s and attribs,"
   //             :+ s"see ${commonAttribSpellingsTutoUrl } ."
   //             :+ s"Note: "
   //             :+ s"maybe the '${ccLookupCaseActualKey }' attrib you intended \nactually has different name (eg not '${ccLookupCaseActualKey }' but instead something else )? -"
   //             :+ s"check the FW/lib u're using's docs for the right syntax-and-spelling. "
   //          ).mkString("\r\n")
   //       ), valueExpr )
   //    }

   //    def toAskLookBackActualFwDocs
   //       //
   //       (ccLookupCaseActualKey: String )
   //       ( )
   //    : String
   //    = {
   //       ;

   //       (
   //          Seq()
   //          :+ s"maybe the '${ccLookupCaseActualKey }' attrib you intended \nactually has different name (eg not '${ccLookupCaseActualKey }' but instead something else )? -"
   //          :+ s"check the FW/lib u're using's docs for the right syntax-and-spelling. "
   //       ).mkString("\r\n")
   //    }

   //    ;

   //    (ccTargetPropKey, () )
   //       match {
   //       //

   //       case (k1 : "class", () ) => SCF(quotes ?=> (_, valueExpr) => {
   //          ;
   //          blockingAskRewrite(valueExpr = valueExpr, ccLookupCaseActualKey = k1 )(finalName = "className" )
   //       } )

   //       case (k1 : "for", () ) => SCF(quotes ?=> (_, valueExpr) => {
   //          ;
   //          blockingAskRewrite(valueExpr = valueExpr , ccLookupCaseActualKey = k1 )(finalName = "htmlFor" )
   //       } )

   //       case (k1 : "key", () ) => SCF(quotes ?=> (_, valueExpr) => {
   //          ;
   //          import quotes.reflect.{*}

   //          if !valueExpr.isExprOf[String | Double ] then
   //             // report.error(s"not statically String nor Double: ${Printer.TreeShortCode.show(valueExpr.asTerm ) } ")
   //             ;
   //             report.error((
   //                (
   //                   Seq()
   //                   :+ s"unsupported 'key' value: "
   //                   :+ s"  ${ Printer.TreeShortCode.show(valueExpr.asTerm ) } "
   //                   :+ s"; not the expected '(_ : String | long float )' . "
   //                   :+ s"=== "
   //                   :+ s"value of 'key' \nneeds be one of those two types (String or 'long float') - "
   //                   :+ s"React's reconciler \ndoes not support any more-complicated \"key object\"s . "
   //                   :+ s"see also https://react.dev/learn#rendering-lists for in-depth . "
   //                   :+ s"Note: "
   //                   :+ s"maybe the 'key' attrib you intended \nactually has different name (eg not '${k1 }' but instead 'authKey' or 'productKey' or 'unlockNextLevelGmKey' or something else )? -"
   //                   :+ s"check the FW/lib u're using's docs for the right syntax-and-spelling. "
   //                ).mkString("\r\n")
   //             ) , valueExpr )
   //       } )

   //       case (k1 : "ref", () ) => SCF(quotes ?=> (_, valueExpr) => {
   //          ;
   //          import quotes.reflect.{*}

   //          if (
   //             !valueExpr.isExprOf[AnyRef | Function1[?, ?] | js.Function ]
   //             ||
   //             valueExpr.isExprOf[String | AnyVal | java.lang.Number ]
   //          ) then
   //             // report.error(s"not statically String nor Double: ${Printer.TreeShortCode.show(valueExpr.asTerm ) } ")
   //             ;
   //             report.error((
   //                (
   //                   Seq()
   //                   :+ s"unsupported 'ref' value: "
   //                   :+ s"  ${ Printer.TreeShortCode.show(valueExpr.asTerm ) } "
   //                   :+ s"; not the expected 'React.Ref' . "
   //                   :+ s"=== "
   //                   :+ s"value of 'ref' \nneeds be one of those two types (CallbackRef or MutableRefObject) - "
   //                   :+ s"see also https://react.dev/learn#rendering-lists for in-depth . "
   //                   :+ s"Note: "
   //                   :+ s"maybe the 'key' attrib you intended \nactually has different name (eg not '${k1 }' but instead something else )? -"
   //                   :+ s"check the FW/lib u're using's docs for the right syntax-and-spelling. "
   //                ).mkString("\r\n")
   //             ) , valueExpr )
   //       } )

   //       case (k1 : "", () ) => SCF(quotes ?=> (_, valueExpr) => {
   //          ;
   //          import quotes.reflect.{*}

   //          if (
   //             !valueExpr.isExprOf[([E] =>> (E | (collection.immutable.Iterable[E] & Seq[E] ) ) )[typings.react.mod.ReactElement | String | AnyVal ] ]
   //             // ||
   //             // valueExpr.isExprOf[String | AnyVal | java.lang.Number ]
   //          ) then
   //             // report.error(s"not statically String nor Double: ${Printer.TreeShortCode.show(valueExpr.asTerm ) } ")
   //             ;
   //             report.error((
   //                (
   //                   Seq()
   //                   :+ s"unsupported 'children' value: "
   //                   :+ s"  ${ Printer.TreeShortCode.show(valueExpr.asTerm ) } "
   //                   :+ s"; not the expected (ReactNode or Seq thereof ) . "
   //                   :+ s"=== "
   //                   :+ s"value of 'children' \nneeds be one of those two types (ReactNode or Seq thereof ) - "
   //                   :+ s"see also https://react.dev/learn#rendering-lists for in-depth . "
   //                   :+ s"Note: "
   //                   :+ s"maybe the 'child' or 'children' attrib you intended \nactually has different name (eg not '${k1 }' but instead something else )? -"
   //                   :+ s"check the FW/lib u're using's docs for the right syntax-and-spelling. "
   //                ).mkString("\r\n")
   //             ) , valueExpr )
   //       } )

   //       case _ =>
   //          None

   //    }
   // }

   export supplementaryPccs.commonAttribSpellingsTutoUrl
   
   def xModifiedPhoneticalSimpleNameOrdering
      //
      (using ctx : Quotes)
   = {
      ;

      Ordering.by
         (((_: ctx.reflect.Symbol ).name ) )
         (using avcframewrk.forms.xModifiedPhoneticalOrdering )
   }

   ;
}

object supplementaryPccs
{
   ;

   val commonAttribSpellingsTutoUrl
   = "https://react.dev/reference/react-dom/components/common"

   // lazy
   // val denyEverythingsInstance
   // : PropCheckCompulsion._CheckingFnc.ByPropNameAndValue[String, Any ]
   // = {
   //    PropCheckCompulsion._CheckingFnc(splctx ?=> (kExpr, vlExpr) => {
   //       splctx.reflect.report.error((
   //          Seq()
   //          :+ s"not allowed "
   //          mkString("\n")
   //       ))
   //    })
   // }

   // given PropCheckCompulsion._CheckingFnc.ByPropNameAndValue["typ", Any ]
   // = {
   //    PropCheckCompulsion._CheckingFnc(splctx ?=> (kExpr, vlExpr) => {
   //       splctx.reflect.report.error((
   //          Seq()
   //          :+ s"unsupported attrib : Laminar HTML attrib 'typ'. "
   //          :+ s"no such rename <<'type' to 'typ'>> imposed here. "
   //          :+ s"for the correct syntax-or-spelling, \nsee ${commonAttribSpellingsTutoUrl } . "
   //          mkString("\n")
   //       ))
   //    })
   // }

}

;


















val _ = {}
