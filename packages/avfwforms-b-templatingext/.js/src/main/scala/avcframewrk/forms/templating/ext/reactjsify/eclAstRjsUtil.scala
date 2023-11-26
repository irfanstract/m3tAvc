// package avcframewrk.forms.templating.ext.reactjsify

package avcframewrk.forms

package templating

package ext.reactjsify










import avcframewrk.forms.localutil.predefChainingOpsImplicits.{*, given}

import quoted.*

import avcframewrk.forms.templating.ext.airstreamify.airstreamifyQuotesAttUtils.xReflect

import scalajs.js



import com.raquo.airstream








;

trait `WithSplCtxReflect1`
{ this : (eclAstRjsUtil.WithSplCtxImpl[?] & EclPreGraphOpsPre ) =>
  ;

  // trait ExtraReflectiveOpExports {
  //   ;

  //   export quotes.reflect.{Singleton as _ , *}

  //   // final
  //   // lazy val %%::! = eclAstRjsUtil.constructs
  //   export %%::!.{
  //     applyTransform as _,
  //     splCtx as _,
  //     *, given
  //   }

  // }
  type ExtraReflectiveOpExports
  >: ExtraReflectiveOpExports1[splCtx.type ]
  <: ExtraReflectiveOpExports1[splCtx.type ]

  // given ExtraReflectiveOpExports with {}
  given (
    // ExtraReflectiveOpExports
    ExtraReflectiveOpExports1[splCtx.type ]
  )
  = {
    // a workaround
    implicit val %%::! = eclAstRjsUtil.constructs(using splCtx )

    ExtraReflectiveOpExports1
  }

  transparent
  inline
  def extraReflectiveOpExports
    //
    [C <: Singleton & Quotes ]
    (using impl: ExtraReflectiveOpExports1[C] )
  : impl.type
  = impl

}

given ExtraReflectiveOpExports1
  [C <: Singleton & Quotes ](using given_C : C )
  (using %%::! : eclAstRjsUtil.constructs[C ] )
: AnyRef with {
  ;

  ;

  export given_C.reflect.{Singleton as _ , *}

  ;

  export %%::!.{
    applyTransform as _,
    splCtx as _,
    *, given
  }

  ;

  val TreeAsInlined
  = {
     PartialFunction.fromFunction(<:<.refl[Term] ).andThen(tree => tree.underlyingArgument )
  }

  val AstOfTermRSourceCode
  = PartialFunction.fromFunction(<:<.refl[Tree] ).andThen(tree => Printer.TreeShortCode.show(tree) )

  val Ast1
  = PartialFunction.fromFunction(<:<.refl[Tree] ).andThen(tree => Printer.TreeStructure.show(tree) )

  val PolymorphicApply
  = {
     PartialFunction.fromFunction(<:<.refl[Term] )
     .andThen({ case Apply(TypeApply(f1, typeArgs), a2) => (f1, typeArgs, a2) })
  }

  ;
}

trait EclPreGraphOpsPre
extends
AnyRef
{
  this : (
    eclAstRjsUtil.WithSplCtxImpl[?]
  ) =>
  ;

  ;

  ;

  // import quotes.reflect.{Singleton as _ , *}

  extension (e: xReflect.Term) {
    //

    def applyTransform
        (tx: xReflect.TreeMap)
        (owner: xReflect.Symbol)
    : xReflect.Term
    = {
      ;

      import quotes.reflect.{Singleton as _ , *}

      tx.transformTerm(e)(owner = owner )
    }
  }

  final
  lazy val %%::! = eclAstRjsUtil.constructs

  import %%::!.{
    applyTransform as _,
    splCtx as _,
    *, given
  }

  extension (s: xReflect.Symbol) {
    //

    // TODO
    def isJavaDefinedClass1
    : Boolean
    = {
      ;
      (
        s.fullName.matches("java\\.\\w+\\.\\w+")
      )
    }

    def isScalaUnit
    : Boolean
    = {
      ;
      (
        s.fullName == "scala.Unit"
      )
    }
  }

  extension (s: xReflect.Symbol) {
    //

    /** 
     * `makeTermChRef`.
     * 
     */
    def makeTermChRef()
    : Expr[?]
    = {
      ;

      import xReflect.*

      ;

      def toThrowWithMsg(msg: String)
      = '{ throw new AssertionError(${Expr(msg) }) }

      def toReturnUnit(msg: String)
      = '{ (${Expr(msg) }) ; () }

      s
      .match {
        //

        /** `scala.Unit` led to `AssertionError` later on here */
        case s if (s.isScalaUnit || s.isType ) =>
          toReturnUnit {
            s"error: cannot reference '${s.fullName }' directly in code. (BTW it's ${s.fullName } } ) "
          }

        case s if (
            // TODO

            s.isNoSymbol
            ||

            s.isLocalDummy
            ||

            s.isPackageDef
            ||
            /** `scala.Unit` led to `AssertionError` later on here */
            s.isType
            ||
            s.isScalaUnit
            ||
            s.isJavaDefinedClass1
        ) => {
            toReturnUnit { s"error: cannot pass _itself_ by-value: ${s.fullName } " }
        }

        case s if (
          !(s.isScalaUnit )
          &&
          !(s.isJavaDefinedClass1 )
        ) => {
          ;

          (
            //

            /** 
             * ridiculously, rather than an `java.lang.IllegalArgumentException`,
             * it was `AssertionError` instead
             * 
             */
            util.Try({
              Ref(s)
            })
            .recover({ case z : AssertionError => {
              throw new AssertionError(s"another AssertionError thrown for Ref(s) where: ${s.fullName } ${s.flags } ", z )
            } })
            .get
          )
          .pipeLooseSelf(e => {
            ;
            e
            .pipeLooseSelf(e => e.etaExpand(Symbol.spliceOwner ) )
            .pipeLooseSelf({
                case s if s.isExpr =>
                  s.asExpr
                case toSRef if (!toSRef.isExpr && s.isDefDef ) =>
                  toReturnUnit { s"error: a ref to 'def', which does not thisself constitute valid Expr ; most likely requires additional arg-list : ${s.fullName } " }
                case toSRef =>
                  val msg = s"not a valid Expr: ${Printer.TreeStructure.show(toSRef) } "
                  report.error(msg, {
                      toSRef.pos
                  } )
                  toThrowWithMsg(msg )
            })
          } )
        }

        case s if (
          s.isScalaUnit
        ) =>
          throw new AssertionError(s"another 'scala.Unit' symbol. supposedly been handled above.")

        case s if (
          s.isJavaDefinedClass1
        ) =>
          throw new AssertionError(s"another 'java.*' symbol. supposedly been handled above.")

        case s => {
            toReturnUnit { s"error: cannot establish Expr: ${s.fullName } } " }
        }
      }
    }

    //
  }

  ;
  //
}
















val _ = {}
