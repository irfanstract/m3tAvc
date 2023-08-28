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
   = (
      SpiwmTwos[Any, LElemPlusPossibleData[HL] @annotation.unchecked.uncheckedVariance, Unit]
   )

   protected
   opaque type LElemPlusPossibleData[+HL]
   = LElemPlusPossibleData1[HL, Any]

   protected
   // opaque
   type LElemPlusPossibleData1[+HL, +D]
   // >: (HL, D)
   // <: AnyRef
   // =  (HL, D)
   >: HL @annotation.unchecked.uncheckedVariance
   <: HL

   // protected
   // given [HL, D]
   // : Conversion[LElemPlusPossibleData1[HL, D], (HL, D) ]
   // = identity[(HL, D)] _

   /**
    * allows them to serve as impl of `LaminarSpawnable`
    * 
    */
   given [
      //
      HL <: ln.ReactiveElement[HD & dom.Element],
      HD <: dom.Node ,
      Mdl ,
   ]
   : (
      Conversion[
         SpiwmTwos[Mdl, LElemPlusPossibleData[HL] , Unit] ,
         LaminarSpawnable[HL , HD] ,
      ]
   )
   = identity[SpiwmTwos[Mdl, LElemPlusPossibleData[HL] , Unit] ] _

   /**
    * `SpawnabilityNoArg`
    * 
    */
   // transparent inline
   given [
      //
      HL <: ln.ReactiveElement[HD & dom.Element],
      HD <: dom.Node ,
      M ,
   ]
   : SpawnabilityNoArg[LaminarSpawnable[HL, HD], LElemPlusPossibleData[HL] ]
   with {
      extension (s: LaminarSpawnable[HL, HD])
         override
         transparent inline
         def spawn()
         = {
            implicit val sp = s._1
            /* needed to desugar this `extension` dispatch, to avoid the ambiguity risking an infinite-looping */
            sp.spawn(s._2)( )
         }
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

/**
 * a pair, which's
 * a `SpawnabilityAndReconciliabilityNoArg` and a "data-model"
 * 
 * refines the tuple-type to achieve that 'dependent-typing' of `_1`
 * 
 */
private[avcframewrk]
type SpiwmTwos[+Mdl, Sp, +R]
= (
   /**
    * to avoid the "unreducible applic with wildcard args" complaint,
    * 
    * we
    * make it a conjunction of two,
    * one being a refined-type, leaving those type-param(s) wildcards, and
    * the next one being the one instantiating them as we demand
    * 
    */

   (
      (SpawnabilityAndReconciliabilityNoArg[?, ?, ? ], Any )
      {
         //
         val _1 : SpawnabilityAndReconciliabilityNoArg[_2.type, ?, ? ]
      }
   )
   & /* the not-so-interesting part */
   (SpawnabilityAndReconciliabilityNoArg[?, Sp, R], Mdl )
)

val _ = {
   ((arg : SpiwmTwos[1, 2, 3] ) => {})
   .nn
}

val laminarClearAll
= {
   import com.raquo.{laminar => ln}
   type El
      >: ln.nodes.ReactiveElement.Base & ln.nodes.ReactiveHtmlElement[?] 
      <: ln.nodes.ReactiveElement.Base & ln.nodes.ReactiveHtmlElement[?] 
   new ln.modifiers.Modifier[El ] {
      // TODO
      override
      def apply(e: El )
      = {
         e.ref
         .innerHTML_=("")
      }
   }
}













