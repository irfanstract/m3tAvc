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

   inline
   def apply
      //
      [R]
      (inline f: R )
   : airstream.core.Signal[R]
   = ${ impl1('f, warnResultingCode = false ) }

   @deprecated
   inline
   def applyAndWarn
      //
      [R]
      (inline f: R )
   : airstream.core.Signal[R]
   = ${ impl1('f, warnResultingCode = true ) }

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
   def impl1
      //
      [R : Type ]
      (fExpr0: Expr[R ], warnResultingCode: Boolean )
      (using Quotes)
   : Expr[airstream.core.Signal[R] ]
   = {
      ;

      import quotes.reflect.*

      val mainExpr
      = Implementative().airstreamify(fExpr0 )

      if warnResultingCode then {
         ;

         def warnExpr
            (mainExpr: Expr[?])
         : Unit
         = {
            ;

            report.warning(s"(${
               ;
               Printer.TreeStructure
               .show(mainExpr.asTerm )
               .take(380)
               ""
            }): \n ${
               // Printer.TreeCode
               Printer.TreeShortCode
               .show(mainExpr.asTerm )
               .pipeLooseSelf(str => {
                  import language.unsafeNulls
                  str
                  .split("\n").toIndexedSeq
                  .map(s => s.grouped(120).mkString("\n") )
                  .mkString("\n")
               } )
            }" , fExpr0 )
         }

         // warnExpr(fExpr0 )
         warnExpr(mainExpr )
      }

      mainExpr
   }

   private[templating]
   class Implementative
      (using val splCtx : Quotes )
      ()
   {
      ;

      import quotes.reflect.*

      ;

      ;
      class AnalyseAndAirstrify
         //
         [R : Type ]
         (private val fExpr0Pre: Expr[R ] )
      {
         ;

         ;

         /* avoiding the extra boundary `Inlined` */
         val '{ ${fExpr0} }
         = '{ ${ fExpr0Pre } }
         ;

         private
         var srcImplExprs0
         : Seq[Expr[airstream.core.Signal[?] ] ]
         = Seq()

         def srcExprs
         = srcImplExprs0

         def srcArrayRefE
         = {
            ;
            '{ {Seq(${Varargs(srcExprs ) } : _* ) } }
         }

         protected
         def combinedValuesTypeRepr
         = {
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

         ;
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
                     srcImplExprs0 :+ '{ ${ srcExpr.asExprOf[airstream.core.Signal[?] ] } }

                  '{ ${srcEmittedValRefAtE(i) }.asInstanceOf[Value ] }
               }

               fExpr0
               /* apply tx as necessary */
               .pipeLooseSelf(fExpr0 => {
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

                        (tree, Some(tree).collect({ case term if term.isExpr => term.asExpr }) ) match {
                        //

                        /* re-write every call to `stubs.pick(...)` */
                        case _ *: Some('{ (${_} : ImplementativeCtxOps.dummyInstance.type ).pick[actualSrcValueT] (${ srcExpr }) } ) *: _ =>
                           ;
                           // TODO
                           doInternSrcRef(srcExpr )
                           .asTerm

                        case _ =>
                           super.transformTerm(tree)(owner)
                        }
                     }
                  } )
                  .transformTerm(fExpr0.asTerm )(Symbol.spliceOwner )
                  .asExpr
                  .asExprOf[R]
               })
            }
         }

         // TODO
         val fExpr10
         = {
            ;

            val fwdBaseType
            : Type[AnyRef]
            = {
               ;
               // Type.of[Tuple] // causes compiler crash "Could not find proxy for actualValues1: Product in"
               Type.of[AnyRef ]
            }

            given Type[fwdBaseType.Underlying ]
            = {
               fwdBaseType
            }

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
            // .pipeLooseSelf(e => {} )
            .pipeLooseSelf(e => {
               '{
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
         ;
         val finalExpr
         = xAnalysis.fExpr1
         // ('{
         //    lazy val _
         //    = "was:" -> ${fExpr0Pre }
         //    ${finalExpr }
         // }) *: {
         //    new AnyRef with Selectable { export xAnalysis.{*, given} }
         // } *: EmptyTuple
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

// object oTuples {
//    ;

//    import Structure.*

//    object Structure {
//       ;

//       type OEmptyTuple
//       = EmptyTuple.type

//       opaque type ONonEmptyTupleOf[+T]
//       <: *:[T, ?]
//       =  *:[T, ?]

//       type OTupleOf[+T]
//       >: OEmptyTuple | ONonEmptyTupleOf[T]
//       <: OEmptyTuple | ONonEmptyTupleOf[T]

//       type OTuple
//       >: OTupleOf[Any]
//       <: OTupleOf[Any]
//    }

//    object Op {
//       ;

//       /** Fold a tuple `(T1, ..., Tn)` into `F[T1, F[... F[Tn, Z]...]]]` */
//       type OFold[Tup <: OTuple, Z, F[_, _]] = Tup match
//         case EmptyTuple => Z
//         case h *: t => F[h, OFold[t, Z, F]]

//    }

//    ;
// }
final lazy val oTuples: {
   type Main[+E]
   <: EmptyTuple.type | (Tuple & *:[E, Main[E] ])
}
= ???




















val _ = {}

