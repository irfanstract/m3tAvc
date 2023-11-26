// package avcframewrk.forms.templating.ext.reactjsify


package avcframewrk.forms

package templating

package ext.reactjsify










import avcframewrk.forms.localutil.predefChainingOpsImplicits.{*, given}

import quoted.*

import scalajs.js



import com.raquo.airstream







object eclEobs {
  ;

  ;

  import eclEods.{*, given}

  extension
    //
    [E <: typings.react.mod.ReactElement : Type ]
    (using EopDebugConfig )
    (using Quotes)
    (origExpr: Expr[E] )
  {
    //

    @deprecated("it doesn't do its thing well.")
    def airstreamify1
      //
      ()
    : Expr[E]
    = {
      ;

      import quotes.reflect.*

      origExpr

      /* apply this "Airstreamification" */
      .pipeLooseSelf(origExpr => {
        ;

        val airstreamifa
        = {
          ;
          avcframewrk.forms.templating.ext.airstreamify.ByGetFromO.analyseExprAndAirstreamify
              (origExpr , warnResultingCode = false )
        }

        val dependedAnimRefs
        = airstreamifa.srcExprs

        /** 
         * to avoid practical device b-out issues,
         * let's disallow non-constant expr(s) from taking part
         */
        dependedAnimRefs
        .tapLooseSelf(exprs => {
          for {
              expr <- exprs
          }
          do {
              val exprEvaluatedTRepr
              = (expr.asTerm ).tpe

              if !(exprEvaluatedTRepr.<:<(TypeRepr.of[scala.Singleton ] ) ) then {
                report.error(s"Implementation Restriction: cannot make non-constant reference. \n non-trivial source expr(s) \n would risk device CPU to hang-and-burnout, and yet \n such exprs cannot trivially be properly auto-memoised ; ", expr )
              }
          }
        } )

        { val l = Lambda.unapply _ }

        airstreamifa.asByActualValuesSeqIife

        .pipeLooseSelf( {
          //

          case cbExpr @ (
            eclAstRjsUtil.constructs.FromTreeExpr(e @ (
              // Lambda(paramDecls, body)
              cons
            ) )
          ) if false => {
            ;
            ???
          }

          case cbExpr => {
            ;

            '{
              ;

              val srcs
              = ${Expr.ofList(dependedAnimRefs ) }.toIndexedSeq

              ${
                ;

                import quotes.reflect.*

                '{
                  ${cbExpr }
                  .apply({
                      // TODO
                      ${
                        literateEclSpecificObsoAll(srcsExpr = '{ srcs } )
                      }
                  } : Tuple )
                }
                .pipeLooseSelf(Expr.betaReduce(_) )
              }

              ;
            }
          }
        })
      } : Expr[E] )
    }
  }

  def literateEclSpecificObsoAll
    //
    (using Quotes )
    (srcsExpr: Expr[IndexedSeq[airstream.core.Signal[?] ] ] )
  = {
    ;

    '{
        val srcs = ${srcsExpr}

        (compiletime.summonInline : eclReactObservingHooksImpl.EOBSM._Any )
        .pipeLooseSelf(ctx1 => {
          for (src <- srcs )
          yield {
              ctx1.valueOf(src )
          }
        } )
        .pipeLooseSelf(valsSeq => (
          Tuple.fromIArray(IArray(valsSeq* ) )
        ) : Tuple )
    } : Expr[Tuple ]
  }

  def literateEclSpecificObso
    //
    [Value : Type ]
    (using Quotes )
    (srcExpr: Expr[airstream.core.Signal[Value] ] )
  = {
    ;
    '{
        val src = ${srcExpr}

        (compiletime.summonInline : eclReactObservingHooksImpl.EOBSM._Any )
        .pipeLooseSelf(ctx1 => {
          ctx1.valueOf(src )
        } )
    } : Expr[Value ]
  } : Expr[Value ]

  ;
}

object eclEods {
  ;

  ;

  ;

  export eclEodProtocols.{*, given }

  // transparent
  inline
  def eop
    [R]
    (inline e: R )
  = ${eopMacroImpl('e) }

  def eopMacroImpl
    [R : Type ]
    (e: Expr[R])
    (using Quotes)
  = {
    ;
    //eopByExpr(e)

    runQuotativeSessionDmpably1
      //
      (e, eopByExpr(_) )
  }

  def eopByExpr
    [R : Type ]
    (e: Expr[R])
    (using Quotes)
    // (using EopDebugConfig )
  = {
    ;

    preProtocol1.runQuotativeSessionDmpably
      //
      (e, (e, _) => {
        ;

        import quotes.reflect.{Singleton as _ , *}

        val ctx1
        = Ecl()

        import ctx1.{given }

        import ctx1.applyTransform

        ({
            ;

            e
            .asTerm
            .applyTransform({
              ctx1.mainReliftingTreeMap()
            } )(owner = Symbol.spliceOwner )
            .applyTransform({
              ctx1.closingTreeTransform()
            } )(owner = Symbol.spliceOwner )
            .asExpr
        })
        .match {
          //
          case '{ ${e} : eReturnType & R } => {
            ;

            '{
              (${
                //

                /** 
                 * note --
                 * the prefix-part of the IIFE needs indirection like this,
                 * otherwise a flawed (ie a lossy one) beta-reduction will kick in
                 * 
                 */
                '{
                    ;
                    "no B-reduction here"
                    (
                      sCa: eclReactHookingLambdalComponentEsvAndImplicitlyPassedInstallmentalOpsDefs.%%@.mainInstance.SCA ,
                    ) ?=>
                      implicit val byEopEobsm = sCa.eobsm
                      
                      implicitly[(
                        byEopEobsm.type <:< eclReactObservingHooksImpl.EOBSM._Any
                      )]

                      ${e }
                }
              })(using
                  //
                  compiletime.summonInline ,
              )
            }
            .pipeLooseSelf(Expr.betaReduce(_) )
          }
        }
      } , warnResultingCode = false )
  }

  ;
}











