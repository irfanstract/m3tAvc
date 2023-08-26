package avcframewrk.forms.templating















/*
 * 
 * Laminar.
 * 
 * not able to `export` `package`s.
 * 
 */
protected
object laminarReExports {

   object api {
      //

      export com.raquo.laminar.api.{L, A, features}
      
   }

   // export com.raquo.laminar.DomApi

   //

}

val Laminar
: laminarReExports.type
= laminarReExports
val laminar
: laminarReExports.type
= laminarReExports

implicit
object LaminarBasedNativeElementRef
{

   //

   opaque type LlNessAs[+R]
      = Any

   @deprecated
   type LlNess
      = LlNessAs[Any]

   extension [R](e: R) {

      def asJsDynamic
      : scalajs.js.Dynamic
      = {
         ;
         e.asInstanceOf[scalajs.js.Dynamic]
      }

   }

   @deprecated
   def init
      [R <: org.scalajs.dom.Node ]
      (e: com.raquo.laminar.nodes.ReactiveNode[R] )
   : e.ref.type & LlNessAs[R]
   = e.setupBackreferenceAndGetReferent()

   extension [R <: org.scalajs.dom.Node](e: com.raquo.laminar.nodes.ReactiveNode[R] ) {

      def setupBackreference
      : e.type
      = {
         ;

         e.ref
         .asJsDynamic.lll_=(e.asInstanceOf[scalajs.js.Any ] )

         e
      }

      def setupBackreferenceAndGetReferent()
      : e.ref.type & LlNessAs[R]
      = {
         setupBackreference
         refWithLlness
      }

      def refWithLlness
      : e.ref.type & LlNessAs[R]
      = {
         ;

         e.ref
      }

   } // setupBackreference refWithLlness

   extension [R <: org.scalajs.dom.Element](e: org.scalajs.dom.Element & LlNessAs[R] ) {

      def devLaminarWrapperE
      : com.raquo.laminar.nodes.ReactiveElement[e.type]
      = {
         ;

         e
         .asJsDynamic.lll
         .asInstanceOf[com.raquo.laminar.nodes.ReactiveElement[e.type] ]
         .nn
      }

   } // Element devLaminarWrapper

   extension [R <: org.scalajs.dom.html.Element](e: org.scalajs.dom.html.Element & LlNessAs[R] ) {

      def devLaminarWrapperEH
      : com.raquo.laminar.nodes.ReactiveHtmlElement[e.type]
      = {
         ;

         e
         .asJsDynamic.lll
         .asInstanceOf[com.raquo.laminar.nodes.ReactiveHtmlElement[e.type] ]
         .nn
      }

   } // HtmlElement devLaminarWrapper

} // LaminarBasedNativeElementRef$

extension [E <: org.scalajs.dom.Node ](receiver: E ) {
   //

   def bindAfw
      [
         ActualValue,
         Src[+Vl],
         Mod[Vl1, Vl2],
      ]
      (key: Mod[ActualValue, ActualValue], valueSrc: Src[ActualValue] )
      (using sup1: BAfw[receiver.type, [Vl] =>> Mod[Vl, Vl] , Src] )
   : sup1.BR[receiver.type, ActualValue]
   = sup1.apply[Nothing, ActualValue](receiver)(key = key, valueSrc = valueSrc)
   
} // [E] (receiver: E ) def bindAfw
trait BAfw[-This1, -ModI[Vl], -SrcI[Vl]]
{

   type Mod[Vl] = ModI[Vl] @annotation.unchecked.uncheckedVariance
   type Src[Vl] = SrcI[Vl] @annotation.unchecked.uncheckedVariance
   type This = This1 @annotation.unchecked.uncheckedVariance

   type BR[+Receiver, Value]

   def apply[T81, Value](receiver: This)(key: Mod[Value], valueSrc: Src[Value] )
   : BR[receiver.type, Value]

}
object BAfw {
   ;

   given [This1 <: This10, This10 >: org.scalajs.dom.html.Element <: org.scalajs.dom.html.Element ]
   : BAfw[(This10 & LaminarBasedNativeElementRef.LlNessAs[This10 ] ) , [V] =>> com.raquo.laminar.keys.HtmlProp[V, ?], laminar.api.L.Source ]
   with {
      type BR[+Receiver, Value]
         >: com.raquo.laminar.nodes.ReactiveHtmlElement[Receiver & This10 ]
         <: com.raquo.laminar.nodes.ReactiveHtmlElement[Receiver & This10 ]
      override
      def apply[T81, Value](receiver: This)(key: Mod[Value], valueSrc: Src[Value] )
      = {
         receiver.devLaminarWrapperEH
         .amend(key <-- valueSrc )
      }
   }

}

val Airstream
: laminarReExports.api.A.type
= laminarReExports.api.A











