// package avcframewrk.forms.templating.ext.reactjsify


package avcframewrk.forms

package templating

package ext.reactjsify










import avcframewrk.forms.localutil.predefChainingOpsImplicits.{*, given}

import quoted.*

import scalajs.js



import com.raquo.airstream







object eclEodProtocols {
  ;

  ;

  def runQuotativeSessionDmpably1
    //
    [R0 : Type, R2 : Type ]
    (using Quotes)
    (e: Expr[R0], main: (arg: Expr[R0]) => Expr[R2] )
    (using EopDebugConfig )
  // : Expr[R]
  = {
    ;

    preProtocol1.runQuotativeSessionDmpably
      //
      (e, (e, _) => {
        ;
        main(e)
      } , warnResultingCode = implicitly[EopDebugConfig ].shallWarnExpansion )
  } // `runQuotativeSessionDmpably1`

  object preProtocol1 {
    ;

    export avcframewrk.forms.templating.ext.airstreamify.commonProtocol.runQuotativeSessionDmpably

    //
  }

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













