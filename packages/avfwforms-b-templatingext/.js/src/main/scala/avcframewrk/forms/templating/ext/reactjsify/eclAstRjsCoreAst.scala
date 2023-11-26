// package avcframewrk.forms.templating.ext.reactjsify

package avcframewrk.forms

package templating

package ext.reactjsify










import avcframewrk.forms.localutil.predefChainingOpsImplicits.{*, given}

import quoted.*

import avcframewrk.forms.templating.ext.airstreamify.airstreamifyQuotesAttUtils.xReflect

import scalajs.js



import com.raquo.airstream








;

trait EclPreGraphOps
extends
AnyRef
with EclPreGraphOpsPre
with WithSplCtxReflect1
{
  this : (
    eclAstRjsUtil.WithSplCtxImpl[?]
  ) =>
  ;

  ;

  ;

  ;

  import %%::!.{
    applyTransform as _,
    splCtx as _,
    *, given
  }

  // implicit class ExprDeferredToXHooksDependencyArrayExtractiveOps
  extension (evnd: Expr[?] ) {
    //

    def renderReactJsDependenciesArray
        (assumedOwner: xReflect.Symbol, debugMode: Boolean = false )
    //
    = {
        ;

        import xReflect.*

        extension (s: xReflect.Symbol) {
          //

          /** 
           * `makeTermRefInProdSpecially`.
           * ignores `debugMode`, unconditionally behaving as in production mode.
           * 
           */
          def makeTermRefInProdSpecially
          : Expr[Any]
          = s.makeTermChRef()
        }

        (evnd *: evnd.asTerm *: EmptyTuple )

        .match {
        //

        // TODO

        case '{ ${_} : (t & scala.Singleton) } *: StrictQuasiPathRef(receiver, selects ) *: _ =>
          ;

          // TODO
          '{ (Nil :+ ${(receiver : Tree ).asExpr } ).asInstanceOf[eclReactHooks.DependenciesArray ] }

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
                      .map(_.makeTermRefInProdSpecially )
                })
                .pipeLooseSelf(e => e )
              } : Seq[Expr[Any ] ] )

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















