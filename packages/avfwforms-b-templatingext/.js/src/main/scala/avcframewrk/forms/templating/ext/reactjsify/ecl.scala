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
      eclByExpr(renderContents1E = 'renderContents1 )
   }

   def eclByExpr
      [Props : Type, E <: typings.react.mod.ReactElement : Type ]
      (using Quotes)
      (renderContents1E: Expr[(props: Props) => E ] )
   // : XFunctionComponent[Props ]
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
                  (Expr.betaReduce('{ ${renderContents1E }(props ) }) )

                  /* `eopByExpr` */
                  .pipeLooseSelf(expr => (
                     //
                     eclFrontEnd.eopByExpr(expr )
                  ))

                  /* apply this "Airstreamification" */
                  .pipeLooseSelf(origExpr => {
                     ;

                     val analysis
                     = {
                        ;
                        avcframewrk.forms.templating.ext.airstreamify.ByGetFromO.analyseExprAndAirstreamify
                           (origExpr , warnResultingCode = false )
                     }

                     val srcExprs
                     = analysis.srcExprs

                     /** 
                      * to avoid practical device b-out issues,
                      * let's disallow non-constant expr(s) from taking part
                      */
                     srcExprs
                     .tapLooseSelf(exprs => {
                        for {
                           expr <- exprs
                        }
                        do {
                           val exprEvaluatedTRepr
                           = (expr.asTerm ).tpe

                           if !(exprEvaluatedTRepr.<:<(TypeRepr.of[scala.Singleton ] ) ) then {
                              report.error(s"Implementation Restriction: can only make constant reference. \n non-trivial source expr(s) would risk dvc b-out, and cannot trivially be auto-memoised ; \n we're disallowing those, as Impl Restriction ", expr )
                           }
                        }
                     } )

                     '{
                        ;

                        val srcs
                        = ${Expr.ofList(srcExprs ) }.toIndexedSeq

                        ${analysis.asByActualValuesSeqIife }
                        .apply({
                           // TODO
                           ${
                              literateEclSpecificObsoAll(srcsExpr = '{ srcs } )
                           }
                        } : Tuple )

                        ;
                     }
                  } : Expr[E] )

                  .pipeLooseSelf(expr => expr )
               } : E
            } )
         }

         .pipeLooseSelf(fncExpr => ('{
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
         }) : Expr[(props: Props ) => E ] )
      }

      clsCoreExpr
      .pipeLooseSelf(fncExpr => '{
         ;
         locally[js.Function1[Props, E] ] (${ fncExpr }.apply(_) )
         .asInstanceOf[XFunctionComponent[Props ] ]
      })
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
   = ${eopByExpr('e) }

   def eopByExpr
      [R : Type ]
      (e: Expr[R])
      (using Quotes)
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
            match {
            case '{ ${e} : eReturnType & R } => {
               ;
               '{
                  /** 
                   * note --
                   * the prefix-part of the IIFE needs indirection like this,
                   * otherwise a flawed (ie a lossy one) beta-reduction will kick in
                   * 
                   */
                  ({
                     ;
                     "no B-reduction here"
                     (
                        sCa: eclReactHookingLambdalComponentEsvAndImplicitlyPassedInstallmentalOpsDefs.%%@.mainInstance.SCA ,
                     ) ?=>
                        implicit val eobsm = sCa.eobsm
                        ${e }
                  })(using
                     //
                     compiletime.summonInline ,
                  )
               }
            }
            }
         } , warnResultingCode = false )
   }

   ;
}


















val _ = {}

