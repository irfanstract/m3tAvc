// package avcframewrk.forms.templating.ext.airstreamify

package avcframewrk.forms

package templating

package ext.airstreamify










import avcframewrk.forms.localutil.predefChainingOpsImplicits.{*, given}

import quoted.*





import com.raquo.airstream



object ByGetFromO {
   ;

   ;

   @deprecated
   // transparent
   inline
   def applyAndWarn
      //
      [R]
      (inline f: R )
   : airstream.core.Signal[R]
   = ${ impl1('f, warnResultingCode = true ) }

   /** 
    * run these code after the necessary transform
    * 
    */
   // transparent
   inline
   def apply
      //
      [R]
      (inline f: R )
   : airstream.core.Signal[R]
   = ${ impl1('f, warnResultingCode = false ) }

   /** 
    * a/the relevantly-transformed version of the given `Expr`
    * 
    */
   def applyToExpr
      //
      [R: Type ]
      (using Quotes)
      (fExpr0: Expr[R] )
   : Expr[airstream.core.Signal[R] ]
   = {
      ;
      impl1(fExpr0, warnResultingCode = false )
   }

   private[templating]
   def impl1
      //
      [R : Type ]
      (fExpr0: Expr[R ], warnResultingCode: Boolean )
      (using Quotes)
   : Expr[airstream.core.Signal[R] ]
   = {
      commonProtocol.runQuotativeSessionDmpably(
         //
         fExpr0 ,
         (fExpr0, _) => {
            Implementative().airstreamify(fExpr0 )
         } ,
         warnResultingCode = warnResultingCode
         ,
      )
   }

   def analyseExprAndAirstreamify
      //
      [R : Type ]
      (fExpr0: Expr[R ], warnResultingCode: Boolean )
      (using Quotes)
   = {
      ;
      Implementative()
      .pipeLooseSelf(ctx => {
         ctx.AnalyseAndAirstrify(fExpr0 )
      } : ctx.AnalyseAndAirstrify[R] )
   }

   ;

   final
   lazy val stubs
   : ImplementativeCtxOps.dummyInstance.type
   = ImplementativeCtxOps.dummyInstance

   object ImplementativeCtxOps {
      ;

      ;

      final
      lazy val dummyInstance
      : _Any
      = ???

      type _Any
      = _Impl[Any]

      // @capability
      protected
      trait _Impl[+T] {
         ;

         ;

         def pick
            //
            [Value]
            (src: airstream.core.Signal[Value] )
         : Value
         
         ;
      }

      ;
   }

   private[templating]
   class Implementative
      (using val splCtx : Quotes )
      ()
   {
      ;

      ;

      import quotes.reflect.*

      extension [R : Type] (fExpr0 : Expr[R] ) {
         //

         def applyTreeTransform
            //
            (tx: TreeMap )
         : Expr[R]
         = {
            ;
            tx
            .transformTerm(fExpr0.asTerm )(Symbol.spliceOwner )
            .asExpr
            .asExprOf[R]
         }

         //
      }

      ;

      ;

      def validateStubCallReceiverT
         //
         [stubI <: ImplementativeCtxOps._Any : Type ]
         (errorFeedbackTarget : Expr[?] )
      = {
         ;

         Some(Type.of[stubI] )
         .collect({
            case '[t & ByGetFromO.stubs.type ] =>
         })
         .getOrElse[Unit] ({
            report.error((
               s"""
               invalid stub call (T: ${Printer.TypeReprCode.show(TypeRepr.of[stubI] ) } ) . 
               only obvious calls on 'ByGetFromO.stubs' are supported here . 
               the receiver needs to be direct ; avoid extracting into a variable ; 
               """
               .stripMargin
            ), errorFeedbackTarget )
         })
      }

      ;
      private[Implementative]
      class AnalyseAndPreAirstrify
         //
         [R : Type ]
         (
            private val fExpr0Pre: Expr[R ] ,
            private val fwdBaseType : Type[Tuple] ,
         )
      {
         ;

         /* avoiding the extra boundary `Inlined` */
         val '{ ${fExpr0} }
         = '{ ${ fExpr0Pre } }
         ;

         private[Implementative]
         var srcImplExprs0
         : Seq[Expr[airstream.core.Signal[?] ] ]
         = Seq()

         ;
         private
         def fExpr1Inner
            //
            (srcEmittedValArrayRefE: Expr[IndexedSeq[?] ] )
         : Expr[R]
         = '{
            ;

            val srcEmittedValList
            = ${srcEmittedValArrayRefE }

            ${
               ;

               def srcEmittedValRefAtE
                  //
                  (i: Int)
               = {
                  ;

                  '{ srcEmittedValList.apply(${Expr[Int](i) }) }
               }

               def doInternSrcRef
                  [Value : Type ]
                  (srcExpr : Expr[airstream.core.Signal[Value] ] )
               : Expr[Value ]
               = {
                  ;

                  /** */
                  val i
                  = srcImplExprs0.length

                  srcImplExprs0 =
                     srcImplExprs0 :+ {
                        ;
                        srcExpr : Expr[airstream.core.Observable[Any] ]
                        srcExpr
                     }

                  '{ ${srcEmittedValRefAtE(i) }.asInstanceOf[Value ] }
               }

               fExpr0
               /* apply substitution to every valid calls to those stub methods */
               .applyTreeTransform({
                  ;

                  (new TreeMap {
                     // TODO
                     ;

                     override
                     def transformTerm
                        (tree: Term)
                        (owner: Symbol)
                     : Term
                     = {
                        ;

                        // given Quotes
                        // = owner.asQuotes

                        (
                           tree
                           *:
                           Some(tree)
                           .collect({
                              case term if term.isExpr =>
                                 term.asExpr
                           })
                           *:
                           EmptyTuple
                        )
                        match {
                        //

                        /* re-write every call to `stubs.pick(...)` */
                        case _ *: (
                           Some((
                              r @ '{
                                 (${_} : (stubI & ImplementativeCtxOps._Any ) )
                                 .pick[actualSrcValueT] (${ srcExpr })
                              } 
                           ))
                        ) *: _ =>
                           ;

                           validateStubCallReceiverT
                              [(stubI & ImplementativeCtxOps._Any )]
                              (errorFeedbackTarget = r )

                           // TODO
                           doInternSrcRef(srcExpr )
                           .asTerm

                        case _ =>
                           super.transformTerm(tree)(owner)
                        }
                     }
                  } )
               })
            }
         }

         val asByActualValuesSeqIife
         = {
            ;

            ;

            Lambda(Symbol.spliceOwner, {
               MethodType
                  (Nil :+ "actualValues1")
                  (_ => (Nil :+ TypeRepr.of[fwdBaseType.Underlying ] ), _ => TypeRepr.of[R] )
            }, { case (closureOwner, srcEmittedValArrayRef +: _ ) => {
               ;

               ({
                  ;

                  val srcEmittedValArrayRefE
                  = {
                     srcEmittedValArrayRef.asExpr.asExprOf[fwdBaseType.Underlying ]
                     .pipeLooseSelf(e => '{
                        { ${e }.asInstanceOf[Tuple] }
                     } )
                     .pipeLooseSelf(e => '{
                        // ${
                        //    combinedValuesTypeRepr.asType match
                        //    case '[t] =>
                        //       '{ ${e }.asInstanceOf[t] }
                        // }
                        ${e }
                        .toList.toIndexedSeq.map(<:<.refl[Any] )
                     } )
                  }

                  fExpr1Inner(srcEmittedValArrayRefE = srcEmittedValArrayRefE  )
               })
               .asTerm
               .changeOwner(closureOwner )
            } } )
            .asExpr.asExprOf[(actualValues: fwdBaseType.Underlying ) => R ]
         }

         ;
      }

      def combinedValuesTypeReprBy
         //
         (srcExprs : IndexedSeq[Expr[airstream.core.Signal[?] ] ] )
      = {
         ;

         srcExprs

         .map({
            case '{ ${_} : airstream.core.Signal[t] } =>
               '{ ??? : t }
         })
         .foldLeft[Expr[Tuple] ] ('{ EmptyTuple })({
            case (e0, '{ ${newItem } : newItemActualT }) => {
               '{ ${e0 } :* ${newItem} }
            }
         })
         .asTerm.tpe
      }

      class AnalyseAndAirstrify
         //
         [R : Type ]
         (private val fExpr0Pre: Expr[R ] )
      {
         ;

         ;

         val fwdBaseType
         : Type[Tuple]
         = {
            ;
            Type.of[Tuple]
         }

         given Type[fwdBaseType.Underlying ]
         = {
            fwdBaseType
         }

         protected
         val prePhase
         = AnalyseAndPreAirstrify(
            //
            fExpr0Pre,
            fwdBaseType = fwdBaseType ,
         )

         export prePhase.fExpr0

         val srcImplExprs0
         = prePhase.srcImplExprs0

         import prePhase.fExpr1Inner

         export prePhase.asByActualValuesSeqIife

         val srcExprs
         = srcImplExprs0.toIndexedSeq

         val srcArrayRefE
         = {
            ;
            '{ {Seq(${Varargs(srcExprs ) } : _* ) } }
         }

         // protected
         val combinedValuesTypeRepr
         = {
            combinedValuesTypeReprBy
               (srcExprs = srcExprs )
         }

         val srcsCombinedExprBuildExpr
         = '{ new Selectable {
            ;

            ;

            val srcs
            = ${ srcArrayRefE }

            assert(srcs.length == ${Expr(srcExprs.length ) } )

            val srcsCombined
            = {
               ;

               airstream.core.Signal.combineSeq(srcs )

               .map(s => {
                  Tuple.fromIArray(IArray(s : _* ) )
               })
               .map(${
                  ;
                  combinedValuesTypeRepr.asType
                  match { case '[t & Tuple] => {
                     type T1
                     = t & Tuple

                     '{
                        ((vals: Tuple ) => {
                           vals.asInstanceOf[T1]
                        } )
                     }
                  } }
               })
            }

            ;
         }}

         // TODO
         val fExpr10
         = {
            ;

            asByActualValuesSeqIife

            // .pipeLooseSelf(e => {} )
            .pipeLooseSelf(e => {
               '{
                  ;

                  val srcsCombinedExprBuild
                  = ${srcsCombinedExprBuildExpr }

                  import srcsCombinedExprBuild.{*}

                  srcsCombined
                  .map({
                     <:<.refl[Tuple]
                     .andThen({
                        /* the main processing fnc */
                        ${ e }
                     })
                  } )
               }
            })
         }

         val fExpr1
         : Expr[airstream.core.Signal[R] ]
         = {
            fExpr10
            // .asExprOf[airstream.core.Signal[R] ]
         }

         ;
      }

      // TODO
      def airstreamify
         //
         [R : Type ]
         (fExpr0Pre: Expr[R ] )
      = {
         ;

         val xAnalysis
         = AnalyseAndAirstrify(fExpr0Pre)

         val finalExpr
         = xAnalysis.fExpr1

         finalExpr
      }

      ;
   }

   extension [Value] (src: airstream.core.Observable[Value] )
      @deprecated
      def asSignalSneakily
      = src.asInstanceOf[airstream.core.Signal[Value] ]

   ;

   /** 
    * 
    * 
    */
   def pickVirtually
      //
      [Value]
      (src: airstream.state.StrictSignal[Value] )
   : Value
   = {
      ;
      src.now()
   }

   // def pickAllVirtually
   //    //
   //    [Values <: Tuple ]
   //    (srcs: Tuple.Map[Values, [e] =>> airstream.core.Signal[e] ] )
   // : Values
   // = {
   //    ;
   //    src.now()
   // }

   ;
}




















val _ = {}

