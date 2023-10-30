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

      '{
         ;

         locally[Function1[Props, E] ] (props => {
            ;

            // TODO
            given given_SCA
            : eclReactHookingLambdalComponentEsvAndImplicitlyPassedInstallmentalOpsDefs.%%@.mainInstance.SCA
            = eclReactHookingLambdalComponentEsvAndImplicitlyPassedInstallmentalOpsDefs.%%@.mainInstance.StateHoldEwmDInReactJs.useCarrier()
            import given_SCA.eobsm

            val r = ${
               ;
               (Expr.betaReduce('{ ${renderContents1E }(props ) }) )
               .pipeLooseSelf(expr => (
                  //
                  eclFrontEnd.eopByExpr(expr )
               ))
            } : E

            r
         } )
      }
      .pipeLooseSelf(fncExpr => ('{
         ;
         
         ;

         (props: Props) => ${
            ;
            val analysis
            = {
               ;
               avcframewrk.forms.templating.ext.airstreamify.ByGetFromO.analyseExprAndAirstreamify
                  ('{ ${fncExpr }.apply(props ) } , warnResultingCode = false )
            }
            ;
            '{
               ;

               val srcs
               = ${Expr.ofList(analysis.srcExprs ) }.toIndexedSeq

               ${analysis.asByActualValuesSeqIife }
               .apply({
                  // TODO
                  srcs
                  .map(_.asInstanceOf[airstream.state.StrictSignal[?] ] )
                  .map(_.now() )
                  .pipeLooseSelf(valuesSeq => Tuple.fromIArray(IArray(valuesSeq * ) ) )
                  .pipeLooseSelf(e => e : Tuple )
               })

               ;
            }
         }
      }) : Expr[(props: Props ) => E ] )
      .pipeLooseSelf(fncExpr => '{
         ;
         locally[js.Function1[Props, E] ] (${ fncExpr }.apply(_) )
         .asInstanceOf[XFunctionComponent[Props ] ]
      })
   }

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

