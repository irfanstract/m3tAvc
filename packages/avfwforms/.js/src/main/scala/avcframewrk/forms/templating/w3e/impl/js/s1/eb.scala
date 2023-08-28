package avcframewrk.forms

package templating

package w3e.impl.js

package s1

















/* we intended it `import` or `private export` */
export rendering.reconciliabilityC.*

trait ELaminarQckCore
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

   /**
    * `Article`
    * 
    * we can't make this opaque here, as
    * that'd close all the remaning ways to express the necessary specialisations
    * 
    */
   override
   type Article
   // = () => ArticleSpawned
   <: LaminarSpawnable[ln.ReactiveHtmlElement[? <: dom.HTMLElement] | ln.ReactiveSvgElement[? <: dom.SVGElement] , dom.HTMLElement | dom.SVGElement ]

   /**
    * `LaminarSpawnable`
    * 
    * opaque.
    * we provided a `given` `Spawnability` instead
    * 
    */
   protected
   opaque
   type LaminarSpawnable[
      +HL <: ln.ReactiveElement[HD & dom.Element],
      +HD <: dom.Node ,
   ]
   = () => HL

   /**
    * allows zero-arg fnc(s) to serve as impl of `LaminarSpawnable`
    * 
    */
   given [
      //
      HL <: ln.ReactiveElement[HD & dom.Element],
      HD <: dom.Node ,
   ]
   : Conversion[() => HL, LaminarSpawnable[HL, HD] ]
   = identity[() => HL] _

   /**
    * `SpawnabilityNoArg`
    * 
    */
   // transparent inline
   given [
      //
      HL <: ln.ReactiveElement[HD & dom.Element],
      HD <: dom.Node ,
   ]
   : SpawnabilityNoArg[LaminarSpawnable[HL, HD], HL ]
   with {
      extension (s: LaminarSpawnable[HL, HD])
         override
         transparent inline
         def spawn()
         = s.apply()
   }

   ;
}

trait ELaminarQckCoreHtml
extends
   AnyRef
   /* with these items item merely listed in the self-type, the IDE/editor won't show any relevant "overrides super member" markers */
   with ELaminarQckCore
{
   this : (
      AnyRef
      with ELaminarQckCore
   ) =>
   ;

   import com.raquo.laminar.{nodes as ln}

   import org.scalajs.dom

   override
   type Article
   >: LaminarSpawnable[ln.ReactiveHtmlElement[? <: dom.HTMLElement] , dom.HTMLElement ]
   <: LaminarSpawnable[ln.ReactiveHtmlElement[? <: dom.HTMLElement] , dom.HTMLElement ]

   ;
}














