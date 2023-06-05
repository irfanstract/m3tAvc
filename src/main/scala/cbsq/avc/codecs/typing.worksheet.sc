




([P] => (e : Seq[Runnable] ) => (_ : reflect.Typeable[P]) ?=> {
   e
   .map({
      case e : P =>
         e
   })
} )

// class pq
object pq {
   
   def eBarQuote()(using quoted.Quotes ) = {
      '{ "bar" }
   }

}
{
   import language.unsafeNulls
   // classOf[pq]
   pq.getClass()
   .getDeclaredMethods()
   .toIndexedSeq
}

// inline def eBar = {
//    ${
//       pq.eBarQuote()
//    }
// }

// eBar

// inline def twscQ[ReturnValue : quoted.ToExpr](inline e: ReturnValue ) = {
//    ${quoted.Expr(() => "bar" ) }
// }




