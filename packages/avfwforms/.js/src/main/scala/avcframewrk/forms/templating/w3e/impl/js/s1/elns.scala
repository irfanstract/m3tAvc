package avcframewrk.forms

package templating

package w3e.impl.js

package s1


















/** 
 * 
 * narrows `Article` to the necessary sub-type.
 * 
 */
trait ELaminarQckCore
extends
   AnyRef
   with ELaminarQckCoreABackreferencings
   with w3e.pre.ArticlesViaLspw
   with ELaminarQckCore1
   with ELSRNA
   with ELaminarQckCoreWRE
   with ELF1
   // with w3e.pre.ArticlesViaLspwmt
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

   import laminar.api.L

   ;
}

/** 
 * 
 * narrows `Article` to the necessary sub-type.
 * 
 */
trait ELaminarQckCoreHtml
extends
   AnyRef
   /* with these items item merely listed in the self-type, the IDE/editor won't show any relevant "overrides super member" markers */
   with ELaminarQckCore
   /* the mix-ins */
   with ELaminarQckCoreReMppsHtml
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
   >: LaminarSpawnable[ln.ReactiveHtmlElement[? <: dom.HTMLElement] , dom.HTMLElement ] | LaminarSpawnable[ln.ReactiveSvgElement[? <: dom.SVGElement] , dom.SVGElement ]
   <: LaminarSpawnable[ln.ReactiveHtmlElement[? <: dom.HTMLElement] , dom.HTMLElement ] | LaminarSpawnable[ln.ReactiveSvgElement[? <: dom.SVGElement] , dom.SVGElement ]

   ;
}

/**
 * 
 * .
 * 
 */
trait ELaminarQckCoreFormCtrlElemReconcKeying1
extends
   AnyRef
   /* with these items item merely listed in the self-type, the IDE/editor won't show any relevant "overrides super member" markers */
   /* that-s all */
   /* the mix-ins */
   /* that-s all */
{
   this : (
      AnyRef
      with ELaminarQckCore
      with w3e.pre.ArticlesImplByL
      with ELaminarQckCoreHtml
   ) =>
   ;

   import com.raquo.laminar.{nodes as ln}

   import org.scalajs.dom

   ;

   ;

   /** 
    * a ReconciliabilityKey for `input` for `Value#`
    * 
    */
   opaque type FKCompReconciliabilityKey
      //
      [
         Value,
         XMdlByValue[_],
      ]
   <: LReconciliativeKeyTo1[FKCompReconciliabilityKeyMinReconcilerOps[Value , XMdlByValue , Any ] ]
   =  LReconciliativeKeyTo1[FKCompReconciliabilityKeyMinReconcilerOps[Value , XMdlByValue , Any ] ]

   /** 
    * the associated-ReconciliabilityKey-associated for `input` for `Value#`
    * 
    * this narrows `SpawnedLaminar` to `ReactiveHTMLElement`.
    * currently, the support is restricted to the HTML NS
    * 
    */
   type FKCompReconciliabilityKeyMinReconcilerOps
      //
      [
         Value,
         XMdlByValue[_],
         +S ,
      ]
   >: LReconciliativeKey.ScnAllocAndReconcileAndDistillH[? <: S , Option[XMdlByValue[Value] ] , ? <: ln.ReactiveHtmlElement[? <: dom.HTMLElement ] ]
   <: LReconciliativeKey.ScnAllocAndReconcileAndDistillH[? <: S , Option[XMdlByValue[Value] ] , ? <: ln.ReactiveHtmlElement[? <: dom.HTMLElement ] ]

   implicit
   def FKCompReconciliabilityKey1[Value, XMdlByValue[_] ] 
      (a: LReconciliativeKeyTo1[FKCompReconciliabilityKeyMinReconcilerOps[Value, XMdlByValue, Any ] ] )
   : a.type & FKCompReconciliabilityKey[Value, XMdlByValue ]
   = a

   ;

   ;

   ;
}

















val _ = {}
