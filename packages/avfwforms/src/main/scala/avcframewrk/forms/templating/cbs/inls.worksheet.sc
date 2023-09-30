// package avcframewrk.forms

// package templating

// import avcframewrk.forms.templating.{*, given }
// import avcframewrk.forms.templating.cbs.{*, given }
import avcframewrk.forms.templating.cbs.byquoted.*









def optionalSg
   [A]
   (value: A)
= Some[value.type](value )

codeOf("myself\r\n")
codeOf("me")

codeOf(("in" + "myself" ) :: Nil )

codeOf(EmptyTuple :* 5 :* 6 :* 7 )
compiletime.codeOf((EmptyTuple :* 5 :* 6 :* 7 ) )

codeOf((_ : Tuple2[?, ?] )._2 )
codeOf((d : Tuple2[?, ?] ) => d._2 )
codeOf((d : Tuple2[?, ? >: Product <: Product] ) => d._2 )
({
   val e = new Object with Selectable { val d = 5 }
   codeOf((5, e ))
})

evAstOf(("in" + "myself" ) :: Nil )

evAstOf(EmptyTuple :* 5 )
evAstOf(EmptyTuple :* 5 :* 6 :* 7 )
evAstOf(EmptyTuple :* 5 :* quoted.Expr )

optionalSg({
   evAstOf(EmptyTuple :* 5 :* quoted.Expr )
})

evAstOf((_ : Tuple2[?, ?] )._2 )
({
   val e = new Object with Selectable { val d = 5 }
   def toString() = "bar"
   evAstOf((5, e, toString _ ))
})

(gcq)

((e: String) => {
   e
})

({
   ;

   asFcRedone(identity[(e: String) => e.type ] ((e) => {
      e
   } ) )
})

({
   ;

   val myCont
   = 5

   asFcRedone(identity[(e: String) => myCont.type ] ((e) => {
      // myCont
      // e
      myCont
   } ) )
})
   















// val _ = {}
