package avcframewrk.forms

package templating

package reactjs

package e_ks













import scalajs.js

case class PropsAndChildren1(
   //
   attribValues : Map[String, ReactPropValueAny ]
   ,
   children : IndexedSeq[ReactElement]
   ,
)
{
   ;

   def toTupleOf2 = (attribValues, children)

   @deprecated
   def toTuple = (this.attribValuesScalablytyped, children)

   ;
}

object PropsAndChildren1 {
   ;

   //

   ;

   val addingAttrib
   = {
      ;
      monocle.macros.GenLens[PropsAndChildren1](_.attribValues )
      .pipeLooseSelf(l => {
         (kv: (String, ReactPropValueAny ) ) =>
         (receiver: PropsAndChildren1 ) =>
            val (k, v) = kv
            l
            .modify(propsBefore => propsBefore.updated(k, v ) )(receiver)
      })
   }

   val addingAll
   = {
      ;
      monocle.macros.GenLens[PropsAndChildren1](_.children )
      .pipeLooseSelf(l => {
         (children: collection.immutable.Iterable[? >: ReactElement <: Any ] ) =>
         (receiver: PropsAndChildren1 ) =>
            l
            .modify(_ :++ {
               children
               .flatMap({
                  case Seq(e @ _* ) =>
                     e
                     .map(e => e.asInstanceOf[ReactElement] )
                  case e =>
                     Seq() :+ e.asInstanceOf[ReactElement]
               } )
            } )(receiver)
      })
   }

   val adding1
   = {
      ;
      addingAll
      .compose(IndexedSeq().appended[ReactElement] _ )
   }

   extension (d: PropsAndChildren1 )
      def attribValuesScalablytyped
      = {
         d.attribValues
         .foldLeft[typings.react.mod.Attributes ] ({
            typings.react.mod.Attributes()
         })({
            case (receiver, kv ) =>
               (receiver.set _ ).tupled
               .apply(kv )
         })
      }

   ;
}

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