package avcframewrk.fjsc












import avcframewrk.forms.localutil.predefChainingOpsImplicits.{*, given}

import quoted.*

import scalajs.js

import com.github.plokhotnyuk.jsoniter_scala









object SpclByStringInterpolAst {
  ;

  ;

  /** 
   * parse source-level literal `s"... ... ..."`.
   * 
   */
  def segmentate
    //
    (using Quotes )
    (c: Expr[String] )
  = {
    ;

    import quotes.reflect.{Singleton as SingletonRepr, *}

    c match {
      //

      case '{ StringContext(${ Varargs(Exprs(cs) ) }*).s(${ Varargs(varValueRefs ) }*) } =>
        (cs, varValueRefs )

      case '{ ${cExpr } : t & Singleton & String } =>
        (Seq("eval(", ")" ) , Nil :+ (cExpr : Expr[String ]) )

      case e =>
        report.error((
          s"""
          |unsupported expression.
          |  ${Printer.TreeShortCode.show(e.asTerm ) }
          |  ^^^^^^^
          |
          |supported formats:
          |a) interpolating string literal,
          |   For example:
          |     // EXAMPLES
          |     sp.eval({
          |       ${"s\"console.log('current time:', ${System.currentTimeMillis() } ) \" " }
          |     })
          |     sp.eval({
          |       ${"s\"console.log('bytes transferred:', ${(o: java.io.OutputStream ).bytesTrannsferred } ) \" " }
          |     })
          |b) reference to String code val,
          |   For example:
          |     sp.eval(code )
          |
          """
        ) , e )
    }
  }

  /** 
   * translate source-level literal `s"... ... ..."`.
   * 
   */
  def translate
    //
    (using Quotes )
    (c: Expr[String] )
  : Expr[?]
  = {
    ;

    import quotes.reflect.{*}

    val (cs, varValueRefs )
    = segmentate(c)

    val substituteVarRefTokens
    = {
      varValueRefs.toIndexedSeq
      .map(origExpr => {
        val origCode = Printer.TreeShortCode.show(origExpr.asTerm )
        val varName = "value_" + (nextInt64() ).toHexString
        // TODO
        s"/* `${origCode }` */ ${varName }"
      } )
    }

    val finalNativeCode
    = {
      ;
      StringContext(cs* )
      .s(substituteVarRefTokens* )
    }

    // '{
    //   ;

    //   val spCode
    //   = ${Expr(Printer.TreeShortCode.show(c.asTerm ) ) } : String

    //   throw
    //     new AssertionError((
    //       s"code: \n ${spCode } "
    //     ))
    // }

    '{
      ;

      js.eval((
        ${
          finalNativeCode
          .match { case c => {
            s"([${substituteVarRefTokens.mkString(", ") }]) => eval(${jsonQuotedString(c) } ) "
          }}
          .match { case c => Expr(c) }
        }
      ))
      .asInstanceOf[js.Function1[js.Array[?], Any ] ]
      .apply(js.Array(${Varargs(varValueRefs ) }* ) )
    }
  }

  def jsonQuotedString
    (c: String)
  : String
  = {
    ;
    s"(${jsoniter_scala.core.writeToStringReentrant(EC(code = c ) ) } )"
    .appendedAll(".code")
  }

  // no given instance of JsonValueCodec[String]
  case class EC(code: String )
  object EC { given jsoniter_scala.core.JsonValueCodec[EC] = jsoniter_scala.macros.JsonCodecMaker.make }

  def nextInt64()
  : Long
  = java.lang.Double.doubleToLongBits(math.random() )

  ;

  ;
}

















