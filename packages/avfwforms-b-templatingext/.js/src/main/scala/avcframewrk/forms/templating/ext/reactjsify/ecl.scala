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

  export eclEods.{*, given}

  import eclEods.{*, given}

  import eclEobs.{*, given}

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
            .airstreamify1()

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

  final
  lazy val eclClientStubMethods
  : eclClientStubMethods1.type
  = valueOf

  /* I wanna get rid of this one `export` */
  export eclClientStubMethods.{*, given }

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


















val _ = {}

