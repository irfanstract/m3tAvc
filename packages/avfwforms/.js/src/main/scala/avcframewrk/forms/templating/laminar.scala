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

val Airstream
: laminarReExports.api.A.type
= laminarReExports.api.A











