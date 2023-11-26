
package avcframewrk.forms

package templating

package ext.slinkify










import avcframewrk.forms.localutil.predefChainingOpsImplicits.{*, given}

import quoted.*

import com.raquo.airstream

import scalajs.js



// import avcframewrk.forms.templating.re










// TODO
object publicly
{
  ;

  /* work-around issues with incr compilation */
  lazy val _ = templating.ext.reactjsify.EclKit

  inline
  def ecl1
    [Props, E <: slinky.core.facade.ReactElement ]
    (inline renderContents1: (props: Props) => E, epb1: publicly.type = publicly )
  = ${ eclMacroImpl(renderContents1E = 'renderContents1 ) }

  inline
  def ecl
    [
      Props,
      // E <: slinky.core.facade.ReactElement,
    ]
    (inline renderContents1: (
      (props: Props) =>
        // E
        slinky.core.facade.ReactElement
    ) )
  = ${ eclMacroImpl(renderContents1E = 'renderContents1 ) }

  private
  def eclMacroImpl
    [Props : Type, E <: slinky.core.facade.ReactElement : Type ]
    (using Quotes)
    (renderContents1E: Expr[(props: Props) => E ] )
  = eclByExpr[Props, E ] (renderContents1E )

  def eclByExpr
    [Props : Type, E <: slinky.core.facade.ReactElement : Type ]
    (using Quotes)
    (renderContents1E: Expr[(props: Props) => E ] )
  // : XFunctionComponent[Props ]
  = {
    ;

    import quotes.reflect.*

    given templating.ext.reactjsify.eclFrontEnd.EopDebugConfig
    = templating.ext.reactjsify.eclFrontEnd.EopDebugConfig.debugModeInstance

    templating.ext.reactjsify.eclFrontEnd.runQuotativeSessionDmpably1(renderContents1E, expr => {
      ;

      eclRenderFncExprByExpr(expr )

      .match { case renderFncExpr => '{
        ;
        slinky.core.FunctionalComponent[Props] (${renderFncExpr } )
      } }
    } )
  }

  def eclRenderFncExprByExpr
    [Props : Type, E <: slinky.core.facade.ReactElement : Type ]
    (using templating.ext.reactjsify.eclFrontEnd.EopDebugConfig )
    (using Quotes)
    (renderContents1E: Expr[(props: Props) => E ] )
  = {
    ;

    import quotes.reflect.*

    // type ExprTA[R] = ({ type CAP >: Expr[R] <: Expr[R] })#CAP
    object ExprFromTermTree {
      def unapply(e: Expr[?]) = Some(e.asTerm.underlyingArgument )
      def apply(e: Term) = Some(e ).collect({ case e if e.isExpr => e.asExpr }).get
    }
    object ExprAsTermTree {
      def unapply(e: Term) = Some(e ).collect({ case e if e.isExpr => e.asExpr })
      def apply(e: Expr[?]) = e.asTerm.underlyingArgument
    }

    '{
      ((props: Props) => (
        /* this time we deliberately invoke beta-reduction */
        ${
          '{ ${renderContents1E }(props) }
          .pipeLooseSelf(Expr.betaReduce(_))
          .pipeLooseSelf({ case '{ ${e} : eType } => e.asTerm.changeOwner(Symbol.spliceOwner).asExprOf[eType] })
          .pipeLooseSelf({
            ;

            {
              //
              case ExprFromTermTree(Block(ss, ExprAsTermTree('{ ${r} : rSelfType }) ) ) =>
                ExprFromTermTree(Block(ss, ExprAsTermTree('{ ${r } match { case e => e.asInstanceOf[typings.react.mod.ReactElement ] } } ) ) )
                .asExprOf[typings.react.mod.ReactElement ]
              case e =>
                '{ ${e}.asInstanceOf[typings.react.mod.ReactElement ] } 
            }
          })
          .pipeLooseSelf(<:<.refl[(
            Expr[typings.react.mod.ReactElement]
          )] )
        }
      ) )
    }

    .match { case expr => {
      templating.ext.reactjsify.eclFrontEnd.eclRenderFncExprByExpr(expr)
    } }

    .match { case f0 => {
      ;
      '{
        ((props: Props) => (
          // /* this time we deliberately invoke beta-reduction */
          // ${ '{ ${f0 }(props ) } pipeLooseSelf(Expr.betaReduce(_)) }

          ${ '{ ({ "no B-reduction" ; ${f0 } })(props ) } pipeLooseSelf(Expr.betaReduce(_)) }

          .asInstanceOf[slinky.core.facade.ReactElement ]
        ) )
      }
    } }
  }

  // // transparent
  // inline
  // def eop
  //   [R]
  //   (inline e: R )
  // = ${eopByExpr('e) }

  // // TODO
  // def eopByExpr
  //   [R : Type ]
  //   (e: Expr[R])
  //   (using Quotes)
  // = templating.ext.reactjsify.eclFrontEnd.eopByExpr(e)

}















