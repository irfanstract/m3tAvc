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
      
   } // API

   object nodes {
      //

      export com.raquo.laminar.nodes.{
         ChildNode ,
         CommentNode ,
         TextNode ,
         ParentNode ,
         RootNode ,
         ReactiveNode ,
         ReactiveElement ,
         ReactiveHtmlElement ,
         ReactiveSvgElement ,
      }

      ;
   } // nodes

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

val Airstream
: laminarReExports.api.A.type
= laminarReExports.api.A











