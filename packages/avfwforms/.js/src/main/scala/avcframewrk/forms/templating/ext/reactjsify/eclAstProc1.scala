// package avcframewrk.forms.templating.ext.reactjsify

package avcframewrk.forms

package templating

package ext.reactjsify










import avcframewrk.forms.localutil.predefChainingOpsImplicits.{*, given}

import quoted.*

import scalajs.js



import com.raquo.airstream



;

object Ecl :
   def apply
      (using splCtx1: Quotes )
      ()
   = new EclOps { val splCtx: splCtx1.type = valueOf }
trait EclOps
{
   ;

   ;

   ;

   implicit
   val splCtx: Quotes

   import quotes.reflect.{Singleton as _ , *}

   extension (e: Term)
      def applyTransform
         (tx: TreeMap)
         (owner: Symbol)
      : Term
      = {
         ;
         tx.transformTerm(e)(owner = owner )
      }

   final
   lazy val %%::! = eclAstRjsUtil.constructs
   import %%::!.{
      applyTransform as _,
      splCtx as _,
      *, given
   }

   ;

   extension (evnd: Expr[?] ) {
      //

      def renderReactJsDependenciesArray
         (assumedOwner: Symbol, debugMode: Boolean = false )
      //
      = {
         ;

         (evnd *: evnd.asTerm *: EmptyTuple ) match {
         //

         // TODO

         case '{ ${_} : (t & scala.Singleton) } *: StrictQuasiPathRef(receiver, selects ) *: _ =>
            ;

            // TODO
            '{ (Nil :+ ${receiver.asExpr } ).asInstanceOf[eclReactHooks.DependenciesArray ] }

         case _ *: exprTr *: _ =>
            ;

            // '{ ??? : eclReactHooks.DependenciesArray }

            val referredSyms
            = {
               // TODO
               eclAstRjsUtil.constructs
               .symRefTryCollect({
                  exprTr
                  /** thse could have been `Inlined`s. */
                  .underlyingArgument
               } )(assumedOwner )
               .get
            } : collection.immutable.Iterable[Symbol ]
            ;

            // TODO
            val referredSymsExpr
            = {
               ;

               referredSyms.toSeq

               /* project-map each as `Ref` to it */
               .pipeLooseSelf(s => {
                  ;
                  s
                  .pipeLooseSelf(s => {
                     if debugMode then
                        ;

                        s
                        .map(s => {
                           s
                           .asInstanceOf[Symbol]
                           .pipeLooseSelf(s => Expr(s"${s.name } more precisely ${s.fullName }") )
                        } )
                     else
                        ;

                        s
                        .map({
                           //
                           case s if s.isPackageDef => {
                              '{ s"error: is a package: ${${Expr(s.fullName ) } } " ; () }
                           }
                           case s => {
                              Ref(s)
                              .pipeLooseSelf(e => {
                                 ;
                                 e
                                 .pipeLooseSelf(e => e.etaExpand(Symbol.spliceOwner ) )
                                 .asExpr
                              } )
                           } 
                        })
                  })
                  .pipeLooseSelf(e => e )
               })

               /* the aggregate expr */
               .pipeLooseSelf(e => {
                  /* note: `ofSeq` does the wrong thing ; use `ofList` instead */
                  Expr.ofList(e)
               } )
            }

            '{
               "dependencies"
               eclReactHooks.DependenciesArray({
                  ${referredSymsExpr }
               })
            }
         }
      } : Expr[eclReactHooks.DependenciesArray]
   }

   // TODO
   private
   def toSummonEobsm
      //
      (using Quotes )
      ()
   : Expr[eclReactObservingHooksImpl.EOBSM._Any ]
   = '{ toSummonEobsmInlineEsg() }

   ;

   // implicit class SpecialStOps (term: Statement ) {
   //    //

   //    def reactify()
   //    : Statement
   //    = {
   //       ;
   //       mainReliftingTreeMap()
   //       .transformStatement(term )(Symbol.spliceOwner )
   //    }

   // }

   // TODO
   def mainReliftingTreeMap
      //
      ()
   : TreeMap
   = {
      ;

      val nhDoc
      = {
         s"""
         | 
         | to avoid bugs like `false negatives for object-literal, across redraws, resulting in constant call/firing`
         | as retold at https://react.dev/learn/removing-effect-dependencies#does-some-reactive-value-change-unintentionally
         |
         """.stripMargin
      }

      def formatNhErrorMsg
         (msg: => String, pos: Tree )
      : String
      = {
         "".++(msg ).++("\r\n").++(nhDoc )
      }

      new TreeMap {
         ;

         override
         def transformStatement
            (tree: Statement)
            (owner: Symbol)
         : Statement
         = {
            ;

            def fallbackToDefaultImpl()
            = super.transformStatement(tree )(owner = owner )

            tree match {
            //

            case eTree @ CaseClassDef(_) =>
               ;
               report.errorAndAbort((
                  formatNhErrorMsg(s"cannot define 'case class'es in React Hooks setting.", eTree )
               ) , eTree.pos )

            case eTree @ CaselyObjDef(_) =>
               ;
               report.errorAndAbort((
                  formatNhErrorMsg(s"cannot define 'case object's in React Hooks setting.", eTree )
               ) , eTree.pos )

            /** 
             * handling `ValDef`s, including if defined as `object`
             * 
             */
            case tree @ (_ : ValDef ) =>
               ;
               val owner = tree.symbol
               val tpt1 = transformTypeTree(tree.tpt)(owner)
               val rhs1 = {
                  tree.rhs
                  .map({
                     //
                     case (x0) => {
                        val xpr1 = transformTerm(x0)(owner)
                        xpr1
                     }
                  })
                  .map({
                     //
                     case SingleArgTerm(xpr1) => {
                        ;
                        xpr1.asExpr
                        .asEsg(assumedOwner = owner )
                        // /* ad-hoc early-detection of the spurious type-mismatch (bug) */
                        // .asExprOf(using { tpt1.tpe.asType match { case '[t] => Type.of[t] } } )
                        .asTerm
                     }
                     case xpr1 =>
                        xpr1
                  })
               }
               /**
                * depending on what's going on,
                * we might need to override/replace the type to be ascribed
                */
               val rhs1ActualTypeOpt
               = {
                  ;
                  rhs1
                  .map(((_: Term).tpe ) andThen (t => TypeTree.of(using t.asType ) ) )
               }
               ValDef.copy(tree)(tree.name, (
                  /**
                   * depending on what's going on,
                   * we might need to override/replace the type to be ascribed .
                   * TODO
                   */
                  {
                     // tpt1
                     // (rhs1ActualTypeOpt getOrElse tpt1 )
                     tpt1
                  }
               ), rhs1)

            case _ : Term =>
               fallbackToDefaultImpl()

            case _ @ (_ : (Term | DefDef | TypeDef | (Import | Export ) ) ) =>
               fallbackToDefaultImpl()

            /** FAILING FALLBACK */
            case eTree =>
               val expr
               = eTree.asExpr
               report.errorAndAbort((
                  new MatchError(expr)
                  .getMessage()
               ) , expr )
            }
         }

         //
      }
   }

   extension [R : Type ] (x: Expr[R] )
      def asEsg
         //
         (assumedOwner: Symbol )
      : Expr[R]
      = {
         ;

         // TODO
         val debugMode : Boolean = false

         ;
         x
         .pipeLooseSelf({
            //

            /** 
             * for a constant-or-stable expr
             * the final value
             * syncs with the change of their "prefixes" , so
             * no additional `typings.React.mod.useMemo` will be necessary
             * 
             */
            /* note: `reflect` defines `Singleton` */
            case '{ ${x1Expr } : (x1ReturnType & scala.Singleton) } => {
               ;
               '{ esgSingletonSelf(${x1Expr }) }
            }

            // TODO
            /** 
             * for exprs in general
             * 
             */
            case e @ '{ ${mainQuery } : (mainQueryExprReturnTpe) } => {
               ;

               // TODO
               val dependenciesArrayLiteral
               = mainQuery.renderReactJsDependenciesArray(assumedOwner = assumedOwner , debugMode = debugMode )

               '{
                  // TODO
                  ({
                     ;

                     ${toSummonEobsm() }
                     .scheduleRefresh({
                        eclReactObservingHooksImpl.EOBSM.app.newJsTimeout(duration = {
                           import concurrent.duration.*
                           (1.950 ).second
                        })
                     })
                  })
                  /**
                   * call to `eclReactHooks.useCachedValue`
                   * 
                   * note --
                   * `eclReactHooks.useCachedValue`
                   * happens to be another `inline` one ;
                   * to avoid potential issues like
                   * the compiler inlining it too early resulting in unexpected behv (eg same `OnRuntimeStringUuid` being reused more-than-once),
                   * needs to here
                   * impose some trickery
                   * , currently an indirection as (an IIFE involving `stdlib.compiletime.summonInline` )
                   * 
                   */
                  ({ "no B-reduction!" ; ${
                     ([T] => (tg: Type[T]) ?=> {
                        '{ compiletime.summonInline[T] }
                     })
                        [EclReactHookSummonable.ToUseCachedValue._ForR[mainQueryExprReturnTpe & R ] ]
                  } } )
                  .apply(${mainQuery } , ${dependenciesArrayLiteral } )
               }
            }

            case e @ '{ ${x1Exp } : (x1Type) } =>
               report.error((
                  s"not stable expr: [as ${
                     Printer.TypeReprCode.show(TypeRepr.of[x1Type] )
                  }] ${
                     Printer.TreeShortCode.show(x1Exp.asTerm )
                  } "
               ) , e )
               e
         })
         /*
          * 
          * see https://github.com/lampepfl/dotty/issues/13922 ,
          * showing the necessity of `changeOwner`.
          * 
          */
         .pipeLooseSelf({
            case '{ ${e} : t } =>
               e
               .asTerm
               .changeOwner(assumedOwner)
               .asExprOf[t & R ]
         })
      }
   //

   // TODO
   def closingTreeTransform
      //
      ()
   : TreeMap
   = {
      new TreeMap {}
   }

   ;
}

private
inline
def toSummonEobsmInlineEsg
   ()
= {
   ;

   import eclReactObservingHooksImpl.EOBSM

   ((ctx: EOBSM._Any ) ?=> ctx )
      (using compiletime.summonInline )
}

def esgSingletonSelf
   //
   [T <: scala.Singleton ]
   (value: T)
: T
= value


















val _ = {}
