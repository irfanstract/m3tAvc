// package avcframewrk.forms.templating.ext.reactjsify

package avcframewrk.forms

package templating

package ext.reactjsify










import avcframewrk.forms.localutil.predefChainingOpsImplicits.{*, given}

import quoted.*

import scalajs.js



import com.raquo.airstream





;

// protected
object eclClientStubMethods1 {
  ;

  /* I wanna get rid of this one `export` */
  export eclFrontEndTakeGsgvStubDefs.{
    preTakeGsgvInline1 ,
  }

  export eclFrontEndTakeGsgvStubDefs.{
    takeGsgv ,
    takeGsgvM ,
  }

  /** `do not wrap or rewrite` */
  def eclAsm
    [A]
    (value: A )
  : value.type
  = value

}

// private
// private[avcframewrk]
/* can't be `private` due to possible `summon`s */
object eclFrontEndTakeGsgvStubDefs {
  ;

  ;

  import eclEods.{*, given}

  import eclEobs.{*, given}

  ;

  transparent
  inline
  def preTakeGsgvInline1()
  : Unit
  = {
    ;
    java.lang.System.currentTimeMillis()
    // toSummonEobsmInlineEsg()
    // takeGsgv(??? )
    java.lang.System.currentTimeMillis()
  }

  /** 
   * `takeGsgv` - a stub `get the Signal's presently value` .
   * STUB-ONLY
   * 
   * primarily intended for calls from ECL blocks ;
   * failed to work properly if it were real (inline) methods,
   * due to
   * premature inlining of calls to `inline` methods
   * despite being (with)in a block passed as `inline` arg
   * 
   */
  def takeGsgv
    [E]
    (src: airstream.core.Signal[E])
  : E
  = {
    ;
    throw
      new UnsupportedOperationException({
        s"not inlined. \n .only meant for use with supporting decorators - \n those rewriting calls to 'takeGsgv' into calls to 'takeGsgvM'"
      })
  }

  /** 
   * the real version of `takeGsgv` .
   * exercises a `compiletime.summonInline[EOBSM]`, and therefore
   * cannot be reliably called directly from ECL blocks
   * due to premature inlining of calls to `inline` methods despite the containing block being an `inline` param/arg
   * 
   */
  // transparent /* necessary for proper working */
  inline
  def takeGsgvM
    [E]
    (src: airstream.core.Signal[E])
  : E
  = ${takingGsgvMacroImpl('{ (src, () ) }) }

  private
  def takingGsgvMacroImpl
    //
    [E : Type]
    (using Quotes )
    (srcs: Expr[(airstream.core.Signal[E] , Unit )] )
  : Expr[E]
  = '{
    val (src *: _) = ${srcs }
    // val src = ${srcs }._1 /* was a necessary fallback as the AST transformer didn't support `match`es */

    {
      ;

      type EOBSM = eclReactObservingHooksImpl.EOBSM._Any
      ((ctx1 : EOBSM ) ?=> {
        ;

        eclReactObservingHooksImpl.takeGsgv(src )
      } )(using {
        // TODO clean this up

        // compiletime.summonInline[EOBSM ]
        // compiletime.summonFrom({
        //   case tc: EOBSM => tc
        //   case tc: GsgvNf._Any => ???
        //   case _ =>
        //     GsgvNf.mainInstance
        //     (???)
        // })
        // summonInTakingGsgvEobsm()
        // ${ java.lang.System.currentTimeMillis() ; '{ compiletime.summonInline[EOBSM ] } }
        // ${ java.lang.System.currentTimeMillis() ; '{ toSummonEobsmInlineEsg() } }
        // GsgvNf.mainInstance

        summonInTakingGsgvEobsm()
      } : EOBSM )
    }
  }

  transparent /* necessary for proper working */
  inline
  def summonInTakingGsgvEobsm
    ()
  = {
    ;

    type EOBSM = eclReactObservingHooksImpl.EOBSM._Any

    // TODO clean this up
    {
      ;

      // compiletime.summonInline[EOBSM ]
      // compiletime.summonFrom({
      //   case tc: EOBSM => tc
      //   case tc: GsgvNf._Any => ???
      //   case _ =>
      //     GsgvNf.mainInstance
      //     (???)
      // })
      // toSummonEobsmInlineEsg()

      compiletime.summonFrom({
        case tc: EOBSM => tc
        case tc: GsgvNf._Any => ???
        case _ =>
          GsgvNf.mainInstance
          (???)
      })
    } : EOBSM
  }

  object GsgvNf {
    ;

    type _Any
    inline given mainInstance(using DummyImplicit)
    : _Any
    = ${applyMacroImpl() }

    def applyMacroImpl
      (using Quotes)
      ()
    : Expr[_Any]
    = {
      ;

      // throw new AssertionError
      //   ("no given instance of EOBSM was found. check for possible illegal call - supposed to be inside an ECL-or-EOP block.")
      // '{ ??? }

      throw new AssertionError
        ("no given instance of EOBSM was found. check for possible illegal call - supposed to be inside an ECL-or-EOP block.")
    }
  }

  ;
}













