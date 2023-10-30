package avcframewrk.forms

package templating

package w3e.pre
















trait ArticlesViaLspw
extends
   AnyRef
   /* with these items item merely listed in the self-type, the IDE/editor won't show any relevant "overrides super member" markers */
   with w3e.pre.Articles
{
   this : (
      AnyRef
      with w3e.pre.Articles
   ) =>
   ;

   import com.raquo.laminar.{nodes as ln}

   import org.scalajs.dom

   ;

   /**
    * `Article`
    * 
    * we can't make this opaque here, as
    * that'd close all the remaning ways to express the necessary specialisations
    * 
    */
   override
   type Article
   <: (
      //

      // LaminarSpawnable[
      //    //
      //    ln.ReactiveHtmlElement[? <: dom.HTMLElement] | ln.ReactiveSvgElement[? <: dom.SVGElement]
      //    ,
      //    dom.HTMLElement | dom.SVGElement
      //    ,
      // ]

      /**
       * note that
       * this type-alt
       * will not prevent subclasses from internally implementing "HTMLElement"s and "SVGElement"s at once -
       * this only requires "that each be one of these two"
       * 
       */
      LaminarSpawnable[
         //
         ln.ReactiveHtmlElement[? <: dom.HTMLElement]
         ,
         dom.HTMLElement
         ,
      ]
      |
      LaminarSpawnable[
         //
         ln.ReactiveSvgElement[? <: dom.SVGElement]
         ,
         dom.SVGElement
         ,
      ]
   )

   /**
    * `LaminarSpawnable`
    * 
    * opaque.
    * we provided a `given` `Spawnability` instead
    * 
    */
   protected
   type LaminarSpawnable[
      +SpawnedLaminar <: ln.ReactiveElement[SpawnedDOMNode & dom.Element],
      +SpawnedDOMNode <: dom.Node ,
   ]

}

















val _ = {}
