package avcframewrk.fjsc













import avcframewrk.forms.localutil.predefChainingOpsImplicits.{*, given}

import quoted.*

import scalajs.js









transparent
inline
def eval(inline s: String )
= evalOpq(s)

inline
def evalOpq(inline s: String )
: Any
= ${translativeMacro1Impl('s) }

def translativeMacro1Impl
  (using Quotes)
  (s: Expr[String] )
= SpclByStringInterpolAst.translate(s)










