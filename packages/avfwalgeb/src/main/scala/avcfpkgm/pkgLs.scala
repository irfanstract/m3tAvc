package avcfpkgm








import avcalg.plsAndTlsAsImplicit.{* , given}

import compiletime.*

import quoted.*








extension
  	(using ks: Quotes)
  	(s: ks.reflect.Symbol ) 
  def members
  	//
  = {
    s.declarations
  }
//

def pkgLsBySymbolicImpl
   //
   (using ks: Quotes)
   (symb : ks.reflect.Symbol )
= {
  ;

  import language.unsafeNulls

  import quotes.reflect.*

  val requireThemBeingPublic : Boolean
  = true

  symb

  .members
  .flatMap({
    ;
    val TopLevelsSyntheticNs = "(.*)\\$package\\$?".r

    def expandImpl
      //
      (nm: Symbol)
    : collection.immutable.Iterable[Symbol]
    = nm match {
      //

      case s if {
        PartialFunction.cond(s.fullName )({
          case TopLevelsSyntheticNs(_*) =>
            true
        })
      } =>
        Nil
          // :+ s /* not accessible */
          :++ (
            s
            .members
            // .flatMap(expandImpl _)
            .filterNot(s => (
              //
              s.flags
              .pipeLooseSelf(s => (
                //

                s.is(Flags.Synthetic )
                ||
                s.is(Flags.Artifact )
              ))
            ) )
          )

      case s =>
        Nil :+ s
    }

    expandImpl _
  })
  .filterNot(s => (s.flags.is(Flags.Local) ) )

  .filterNot(s => (
    (requireThemBeingPublic == true ) && (
      // "is non-public ?"
      s.flags.is(Flags.Protected | Flags.Private | Flags.PrivateLocal )
    )
  ) )

  .map((_: Symbol ).name )
  .map(s => {
    s.replaceFirst("\\$\\z", "" )
  } )

  .distinct

  .map(s => {
    s
    .replace("$", ".")
  } )

  .filterNot({
    case "<clinit>" => true
    case "<init>" => true
    case _ => false
  })

  .sorted(using avcalculus.sorting.common.commonPhoneticalOrdering )

  .filter(s => (
    s.matches((
      //
      (
        (Nil :+ "\\w" :++ (
          "!@$%^&*-+=:<>?/|"
          .grouped(1).toIndexedSeq
          .map(util.matching.Regex.quote(_) )
        ) )
        .mkString("|")
      )
      .pipeLooseSelf(chrPat => s"(?:$chrPat)+")
      // .tapLooseSelf(pattern => {
      //   report.error(pattern)
      // })
    ))
  ))

}

def pkgLsByExprImpl
   //
   (using ks: Quotes)
   (sNameExpr: Expr[String] )
= {
  ;

  import quotes.reflect.*

  val Expr(sName)
  = sNameExpr : @unchecked

  Symbol.requiredPackage(sName)

  .pipeLooseSelf(s => (
    pkgLsBySymbolicImpl(s)
  ) )
}

def pkgLsByExpr
   //
   (using ks: Quotes)
   (sNameExpr: Expr[String] )
= {
  ;
  pkgLsByExprImpl(sNameExpr )
  .pipeLooseSelf({ names => Expr(names) })
}

def pkgLsByExprAsS
   //
   (using ks: Quotes)
   (sNameExpr: Expr[String] )
= {
  ;
  pkgLsByExprImpl(sNameExpr )
  .mkString(" ")
  .pipeLooseSelf({ names => Expr(names ) })
}

inline
def pkgLs
   //
   (s: String)
= ${pkgLsByExpr('s) }

transparent inline
def pkgLsAsS
   //
   (s: String)
= ${pkgLsByExprAsS('s) }
















