// package avcframewrk.forms.templating.ext.reactjsify

package avcframewrk.forms

package templating

package ext.reactjsify










import avcframewrk.forms.localutil.predefChainingOpsImplicits.{*, given}

import quoted.*

import scalajs.js



import com.raquo.airstream



;

trait EclTdfOps
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

   ;

   @deprecated
   private
   def &&&&?%(ctx1: Quotes )(s: ctx1.reflect.Symbol )
   = s.asInstanceOf[Symbol ]

   extension [mainQueryExprReturnTpe : Type ] (mainQuery: Expr[mainQueryExprReturnTpe ] ) (using Quotes )
      //

      def toDeferredToXMemoisingHook
         //
         (assumedOwner: quotes.reflect.Symbol )
      : Expr[mainQueryExprReturnTpe ]
      = {
         ;

         import quotes.reflect.{Singleton as _, * }

         // TODO
         val debugMode : Boolean = false

         // TODO
         val dependenciesArrayLiteral
         = mainQuery.renderReactJsDependenciesArray(assumedOwner = (
            // assumedOwner

            &&&&?%(summon[Quotes ] )(assumedOwner )
         ) , debugMode = debugMode )

         '{
            ;

            /** debug-only splice - convey the original code. can't do this in prod; it intensely filled up generated code */
            (${
               if false then '{

                  "the original code"
                  if false then {
                     ${
                        Printer.TreeStructure.show(mainQuery.asTerm )
                        .grouped(80 ).toIndexedSeq
                        .map(Expr(_))
                        /* cannot use `Expr.ofList` ; they didn't linebreak well the way `Block`s do */
                        .reduceRight[Expr[?] ] ((e0, e1) => '{ ${e0} ; ${e1} } )
                     } : Unit
                  }
               }

               else '{}
            } : Unit )

            /**
             * `eclWildQueryNecessitatedRedrawCallability`
             * 
             */
            ({
               ;

               ${ toSummonEobsm() }
               // .match { case eobsm => eclWildQueryNecessitatedRedrawCallability.invokeBasicOn(eobsm) }
               .pipeLooseSelf({ eobsm => eclWildQueryNecessitatedRedrawCallability.invokeBasicOn(eobsm) })
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
                  [EclReactHookSummonable.ToUseCachedValue._ForR[mainQueryExprReturnTpe ] ]
            } } )
            .apply(${mainQuery } , ${dependenciesArrayLiteral } )
         }
      }

   // implicit class ExprDeferredToXMemoisingHookOps
   extension [R : Type ] (x: Expr[R] ) (using Quotes )
      //

      def toDeferredAsExpected
         //
         (assumedOwner: quotes.reflect.Symbol )
      : Expr[R]
      = {
         ;

         import quotes.reflect.{Singleton as _, * }

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

               mainQuery
               .toDeferredToXMemoisingHook
                  (assumedOwner = assumedOwner )
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





















