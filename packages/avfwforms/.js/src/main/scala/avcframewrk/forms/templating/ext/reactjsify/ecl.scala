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
   = {
      locally[js.Function1[Props, E] ] (props => {
         ;

         // TODO
         given given_SCA
         : eclReactHookingLambdalComponentEsvAndImplicitlyPassedInstallmentalOpsDefs.%%@.mainInstance.SCA
         = eclReactHookingLambdalComponentEsvAndImplicitlyPassedInstallmentalOpsDefs.%%@.mainInstance.StateHoldEwmDInReactJs.useCarrier()
         import given_SCA.eobsm

         eclFrontEnd.eop {
            ;

            ({ "no B-reduction, please!" ; renderContents1 })(props )
         }

      } )
      .asInstanceOf[XFunctionComponent[Props ] ]
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

