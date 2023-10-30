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
   =
      new eclAstRjsUtil.WithSplCtxImpl[splCtx1.type]
      with EclPreGraphOps
      with EclOps
//

trait EclOps
{
   this : (
      eclAstRjsUtil.WithSplCtxImpl[? ]
      & EclPreGraphOps
   ) =>
   ;

   ;

   ;

   import quotes.reflect.{Singleton as _ , *}

   // final
   // lazy val %%::! = eclAstRjsUtil.constructs
   import %%::!.{
      applyTransform as _,
      splCtx as _,
      *, given
   }

   ;

   // implicit class ExprDeferredToXMemoisingHookOps
   extension [R : Type ] (x: Expr[R] )
      def toDeferredToXMemoisingHook
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
   private
   def toSummonEobsm
      //
      (using Quotes )
      ()
   : Expr[eclReactObservingHooksImpl.EOBSM._Any ]
   = '{ toSummonEobsmInlineEsg() }

   ;

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
             * handling `ValDef`s and possibly `DefDef`s, including if defined as `object`
             * 
             */
            case _ @ &%%!(tree *: _ *: o *: _ ) =>
               ;
               import o.{rhs0, tpt0}
               val owner = tree.symbol
               val tpt1 = transformTypeTree(tpt0)(owner)
               val rhs1 = {
                  rhs0
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
                        .toDeferredToXMemoisingHook(assumedOwner = owner )
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

         /** 
          * for both `ValDef` and `DefDef`
          * 
          */
         object &%%! {
            ;

            ;

            def unapply
               (tree: ValDef | DefDef )
            //
            = {
               ;
               trait Ier extends Selectable
               {
                  ;

                  val s = tree.symbol

                  val tpt0 : TypeTree

                  val rhs0 : Option[Term]

                  ;
               }
               Some(tree)
               .collect[(
                  // tree.type
                  ValDef | DefDef
                  , (() => Any ) *: EmptyTuple.type
                  , Ier
               )] ({
                  //
                  case tree @ (_ : ValDef) =>
                     ;
                     (
                        tree
                        *:
                        ((() => ??? ) *: EmptyTuple)
                        *: {
                           new Ier {
                              ;

                              val tpt0 = tree.tpt
                              val rhs0 = tree.rhs

                           }
                        }
                        *:
                           EmptyTuple
                     )
               })
            }

            ;
         }

         //
      }
   }

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
