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

      private
      def asJsDynamic
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
   = {
      ;

      e.setupBackreference

      e.refWithLlness
   }

   extension [R <: org.scalajs.dom.Node](e: com.raquo.laminar.nodes.ReactiveNode[R] ) {

      def setupBackreference
      : e.type
      = {
         ;

         e.ref
         .asJsDynamic.lll_=(e.asInstanceOf[scalajs.js.Any ] )

         e
      }

      def refWithLlness
      : e.ref.type & LlNessAs[R]
      = {
         ;

         e.ref
      }

   }

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

   }

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

   }

}

val Airstream
: laminarReExports.api.A.type
= laminarReExports.api.A











