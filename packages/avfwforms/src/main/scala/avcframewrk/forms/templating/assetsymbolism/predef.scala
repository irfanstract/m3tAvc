package avcframewrk.forms

package templating

package assetsymbolism













export avcframewrk.forms.localutil.predefChainingOpsImplicits.{*, given }



import quoted.{*, given}

extension (s: String)

   /** 
    * work-around the SJS linker-specific limitation(s) -- splitting!
    * 
    */
   def toExprForSjs
      (using Quotes )
      ()
   = {
      ;
      import language.unsafeNulls
      s
      .grouped(16 * 1024 ).toSeq
      .map(Expr(_) )
      .pipeLooseSelf(exprs => {
         '{
            val chunks
            = ${Expr.ofList(exprs ) }
            chunks
            .mkString("")
         }
      } )
   }
;

given uriFromExpr [T >: java.net.URI <: java.net.URI]
: FromExpr[T]
with {
   def unapply(e: Expr[T])(using Quotes)
   = for (case '{ new java.net.URI(${Expr(addr) } : String ) } <- Some(e) ) yield {
      new java.net.URI(addr)
   }
}

given uriToExpr [T >: java.net.URI <: java.net.URI]
: ToExpr[T]
with {
   def apply(e: T)(using Quotes)
   = '{ new java.net.URI(${
      /** 
       * work-around the SJS linker-specific limitation(s) -- splitting!
       * 
       */
      ({
         ;
         import language.unsafeNulls
         e.toASCIIString()
         .toExprForSjs()
      })
    }) }
}

















val _ = {}
