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

trait `WithSplCtxReflect1`
{ this : (eclAstRjsUtil.WithSplCtxImpl[?] & EclPreGraphOps ) =>
  ;

  trait ExtraReflectiveOpExports {
    ;

    export quotes.reflect.{Singleton as _ , *}

    // final
    // lazy val %%::! = eclAstRjsUtil.constructs
    export %%::!.{
      applyTransform as _,
      splCtx as _,
      *, given
    }

  }

  given ExtraReflectiveOpExports with {}

  transparent
  inline
  def extraReflectiveOpExports
    (using impl: ExtraReflectiveOpExports )
  : impl.type
  = impl

}

trait EclPreGraphOps
extends
AnyRef
with WithSplCtxReflect1
{
  this : (
    eclAstRjsUtil.WithSplCtxImpl[?]
  ) =>
  ;

  // import quotes.reflect.{Singleton as _ , *}

  extension (e: xReflect.Term) {
    //

    def applyTransform
        (tx: xReflect.TreeMap)
        (owner: xReflect.Symbol)
    : xReflect.Term
    = {
      ;

      import quotes.reflect.{Singleton as _ , *}

      tx.transformTerm(e)(owner = owner )
    }
  }

  final
  lazy val %%::! = eclAstRjsUtil.constructs
  import %%::!.{
    applyTransform as _,
    splCtx as _,
    *, given
  }

  extension (s: xReflect.Symbol) {
    //

    // TODO
    def isJavaDefinedClass1
    : Boolean
    = {
      ;
      (
        s.fullName.matches("java\\.\\w+\\.\\w+")
      )
    }

    def isScalaUnit
    : Boolean
    = {
      ;
      (
        s.fullName == "scala.Unit"
      )
    }
  }

  ;

  ;

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
          = {
              ;

              def toThrowWithMsg(msg: String)
              = '{ throw new AssertionError(${Expr(msg) }) }

              def toReturnUnit(msg: String)
              = '{ (${Expr(msg) }) ; () }

              s
              .match {
                //

                /** `scala.Unit` led to `AssertionError` later on here */
                case s if (s.isScalaUnit || s.isType ) =>
                  toReturnUnit {
                    s"error: cannot reference '${s.fullName }' directly in code. (BTW it's ${s.fullName } } ) "
                  }

                case s if (
                    // TODO

                    s.isNoSymbol
                    ||

                    s.isLocalDummy
                    ||

                    s.isPackageDef
                    ||
                    /** `scala.Unit` led to `AssertionError` later on here */
                    s.isType
                    ||
                    s.isScalaUnit
                    ||
                    s.isJavaDefinedClass1
                ) => {
                    toReturnUnit { s"error: cannot pass _itself_ by-value: ${s.fullName } " }
                }

                case s if (
                  !(s.isScalaUnit )
                  &&
                  !(s.isJavaDefinedClass1 )
                ) => {
                  ;

                  (
                    //

                    /** 
                     * ridiculously, rather than an `java.lang.IllegalArgumentException`,
                     * it was `AssertionError` instead
                     * 
                     */
                    util.Try({
                      Ref(s)
                    })
                    .recover({ case z : AssertionError => {
                      throw new AssertionError(s"another AssertionError thrown for Ref(s) where: ${s.fullName } ${s.flags } ", z )
                    } })
                    .get
                  )
                  .pipeLooseSelf(e => {
                    ;
                    e
                    .pipeLooseSelf(e => e.etaExpand(Symbol.spliceOwner ) )
                    .pipeLooseSelf({
                        case s if s.isExpr =>
                          s.asExpr
                        case toSRef if (!toSRef.isExpr && s.isDefDef ) =>
                          toReturnUnit { s"error: a ref to 'def', which does not thisself constitute valid Expr ; most likely requires additional arg-list : ${s.fullName } " }
                        case toSRef =>
                          val msg = s"not a valid Expr: ${Printer.TreeStructure.show(toSRef) } "
                          report.error(msg, {
                              toSRef.pos
                          } )
                          toThrowWithMsg(msg )
                    })
                  } )
                }

                case s if (
                  s.isScalaUnit
                ) =>
                  throw new AssertionError(s"another 'scala.Unit' symbol. supposedly been handled above.")

                case s if (
                  s.isJavaDefinedClass1
                ) =>
                  throw new AssertionError(s"another 'java.*' symbol. supposedly been handled above.")

                case s => {
                    toReturnUnit { s"error: cannot establish Expr: ${s.fullName } } " }
                }
              }
          }
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
















val _ = {}
