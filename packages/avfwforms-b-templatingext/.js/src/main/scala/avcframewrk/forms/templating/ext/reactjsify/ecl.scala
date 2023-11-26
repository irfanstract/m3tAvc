// package avcframewrk.forms.templating.ext.reactjsify

package avcframewrk.forms

package templating

package ext.reactjsify










import avcframewrk.forms.localutil.predefChainingOpsImplicits.{*, given}

import quoted.*

import scalajs.js



import com.raquo.airstream



object eclFrontEnd {
  ;

  type XFunctionComponent[-Props]
  = typings.react.mod.FunctionComponent[? >: Props]

  /* a work-around to these incremental-compl issues */
  Ecl

  // TODO
  inline
  def ecl
    [Props, E <: typings.react.mod.ReactElement ]
    (inline renderContents1: (props: Props) => E )
  : XFunctionComponent[Props ]
  = ${
    eclMacroImpl(renderContents1E = 'renderContents1 )
  }

  def eclMacroImpl
    [Props : Type, E <: typings.react.mod.ReactElement : Type ]
    // (using EopDebugConfig )
    (using Quotes)
    (renderContents1E: Expr[(props: Props) => E ] )
  = eclByExpr[Props, E ] (renderContents1E)

  def eclByExpr
    [Props : Type, E <: typings.react.mod.ReactElement : Type ]
    (using EopDebugConfig )
    (using Quotes)
    (renderContents1E: Expr[(props: Props) => E ] )
  // : XFunctionComponent[Props ]
  = {
    ;

    import quotes.reflect.*

    eclRenderFncExprByExpr(renderContents1E )

    .match { case fncExpr => '{
      ;
      locally[js.Function1[Props, E] ] (${ fncExpr }.apply(_) )
      .asInstanceOf[XFunctionComponent[Props ] ]
    } }
  }

  def eclRenderFncExprByExpr
    [Props : Type, E <: typings.react.mod.ReactElement : Type ]
    (using EopDebugConfig )
    (using Quotes)
    (renderContents1E: Expr[(props: Props) => E ] )
  = {
    ;
    
    import quotes.reflect.*
    
    val clsCoreExpr
    = {
      ;

      '{
        ;

        ((fnc: (props: Props) => E ) => fnc ) (props => {
          ;

          ${
            ;

            import quotes.reflect.*

            ;
            (Expr.betaReduce('{ ${renderContents1E }(props ) }) )

            /* `eopByExpr` */
            .pipeLooseSelf(expr => (
              //
              eclFrontEnd.eopByExpr(expr )
            ))

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

            .pipeLooseSelf(expr => expr )
          } : E
        } )
      }

      .match { case fncExpr => ('{
        ;

        ;

        (props: Props) => {
            ;

            // TODO
            given given_SCA
            : eclReactHookingLambdalComponentEsvAndImplicitlyPassedInstallmentalOpsDefs.%%@.mainInstance.SCA
            = eclReactHookingLambdalComponentEsvAndImplicitlyPassedInstallmentalOpsDefs.%%@.mainInstance.StateHoldEwmDInReactJs.useCarrier()
            implicit val eobsm
            = given_SCA.eobsm

            ${fncExpr }(props )
        }
      }) : Expr[(props: Props ) => E ] }
    }

    clsCoreExpr
  }

  /* a work-around to issues with incr-compile */
  (avcframewrk.forms.templating.ext.airstreamify.ByGetFromO)

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

    avcframewrk.forms.templating.ext.airstreamify.commonProtocol.runQuotativeSessionDmpably
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

                // /** 
                //  * note --
                //  * the prefix-part of the IIFE needs indirection like this,
                //  * otherwise a flawed (ie a lossy one) beta-reduction will kick in
                //  * 
                //  */
                // '{
                //     ;
                //     "no B-reduction here"
                //     (
                //       sCa: eclReactHookingLambdalComponentEsvAndImplicitlyPassedInstallmentalOpsDefs.%%@.mainInstance.SCA ,
                //     ) ?=>
                //       implicit val eobsm = sCa.eobsm
                //       ${e }
                // }

                /* deliberately pushing it to beta-reduction */
                '{
                  (
                    //

                    (
                      sCa: eclReactHookingLambdalComponentEsvAndImplicitlyPassedInstallmentalOpsDefs.%%@.mainInstance.SCA ,
                    ) ?=>
                      implicit val eobsm = sCa.eobsm
                      ${e }
                  )
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

  def runQuotativeSessionDmpably1
    //
    [R0 : Type, R2 : Type ]
    (using Quotes)
    (e: Expr[R0], main: (arg: Expr[R0]) => Expr[R2] )
    (using EopDebugConfig )
  // : Expr[R]
  = {
    ;

    avcframewrk.forms.templating.ext.airstreamify.commonProtocol.runQuotativeSessionDmpably
      //
      (e, (e, _) => {
        ;
        main(e)
      } , warnResultingCode = implicitly[EopDebugConfig ].shallWarnExpansion )
  } // `runQuotativeSessionDmpably1`

  case class EopDebugConfig(
    //
    shallWarnExpansion: Boolean
  )
  object EopDebugConfig {
    //

    given defaultInstance
    : EopDebugConfig
    = productionModeInstance

    def productionModeInstance
    : EopDebugConfig
    = EopDebugConfig(shallWarnExpansion = false )

    def debugModeInstance
    : EopDebugConfig
    = EopDebugConfig(shallWarnExpansion = true )

  }

  ;
}


















val _ = {}

