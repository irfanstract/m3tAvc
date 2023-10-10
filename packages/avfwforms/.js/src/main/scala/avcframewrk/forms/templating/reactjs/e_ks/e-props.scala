package avcframewrk.forms

package templating

package reactjs

package e_ks













import scalajs.js

object PropCheckFnc {
   ;

   ;

   opaque type ByPropNameAndValue
      [-Key <: String, -Value]
   <: AnyRef
   = (
      (keyExpr : quoted.Expr[Key], valueExpr: quoted.Expr[Value]) =>
      (quoted.Quotes) ?=>
         CheckReturnValue
   )

   type CheckReturnValue
   >: Unit
   <: Unit

   extension [Key <: String, Value] (receiver: ByPropNameAndValue[Key, Value] )
      private def applyPre: receiver.type = receiver
      export applyPre.{apply as run }

   /** 
    * an instance implemented as follows.
    * 
    */
   def apply
      //
      [Key <: String, Value]
      (impl: (
         (quoted.Quotes) ?=>
         (keyExpr : quoted.Expr[Key], valueExpr: quoted.Expr[Value]) =>
            CheckReturnValue
      ))
   : ByPropNameAndValue[Key, Value ]
   = {
      (keyExpr : quoted.Expr[Key], valueExpr: quoted.Expr[Value]) =>
      (quotesImpl: quoted.Quotes) ?=>
         impl(keyExpr = keyExpr , valueExpr = valueExpr )
   } : (
      /* by Implementation Restriction with "curried dependent context function type"s */
      (quoted.Expr[Key], quoted.Expr[Value]) =>
      (quoted.Quotes) ?=>
         CheckReturnValue
   )

   /** 
    * an instance which does not do any checking.
    * 
    */
   def ignorantInstance
      //
   : ByPropNameAndValue[String, Any ]
   = apply((_, _) => {} )

   ;
}













val _ = {}