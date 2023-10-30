// package avcframewrk.forms.templating.ext.reactjsify

package avcframewrk.forms

package templating

package ext.reactjsify










import avcframewrk.forms.localutil.predefChainingOpsImplicits.{*, given}

import quoted.*

import scalajs.js



import com.raquo.airstream








;

trait EclPreGraphOps
{
   this : (
      eclAstRjsUtil.WithSplCtxImpl[?]
   ) =>
   ;

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

   ;

   // implicit class ExprDeferredToXHooksDependencyArrayExtractiveOps
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
               eclAstRjsUtil.lexicalEscapeAnalytics
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

   ;
}
















val _ = {}
