package avcframewrk.forms

package templating

package w3e.impl.js

package s1



















/** 
 * 
 * 
 */
trait ELaminarQckCoreWRE
extends
   AnyRef
   // with w3e.pre.ArticlesViaLspwmt
   /* with these items item merely listed in the self-type, the IDE/editor won't show any relevant "overrides super member" markers */
   with w3e.pre.Articles
   /* a temporary repetition here (of below) necessary to prevent the compiler from "crashing" or serious 100%-CPU hanging */
   with ELaminarQckCoreABackreferencings
   with w3e.pre.ArticlesViaLspw
   with ELaminarQckCore1
   with ELSRNA
{
   this : (
      AnyRef
      with ELaminarQckCore
      with w3e.pre.Articles
   ) =>
   ;

   import com.raquo.laminar.{nodes as ln}

   import org.scalajs.dom

   import laminar.api.L

   /** 
    * a concise way to write a `SpawnabilityAndReconciliabilityNoArg` impl this way
    * 
    */
   @deprecated
   private[avcframewrk]
   def %%%%%
      [XModel]
      (f1: () => ln.ReactiveHtmlElement[dom.HTMLElement] )
   = {
      ;

      ({
         import aBackreferencings.{given Conversion[?, ?] }

         summon[Conversion[f1.type, SpawnabilityAndReconciliabilityNoArg[XModel, ? <: ln.ReactiveHtmlElement[dom.HTMLElement] , Unit ] ] ]
         .apply(f1 )
      })
   }

   def lnByModelElemReconciler1
      //
      [
         //
         XM
         <: Option[?]
         ,
         E
         >: dom.HTMLElement
         <: dom.HTMLElement
         ,
      ]
      // describeFieldElem: (subArtMdl: Option[BInputFunc[Value]]) => LaminarSpawnable[ln.ReactiveHtmlElement[ <: HTMLElement], HTMLElement]
      (describeFieldElem: (subArtMdl: XM ) => LaminarSpawnable[ln.ReactiveHtmlElement[? <: E], E] )
      // 
      (using <:<[None.type, XM] )
   = {
      ;

      val sp10
      = {
         summon[SpawnabilityAndReconciliabilityNoArg[LaminarSpawnable[ln.ReactiveHtmlElement[? <: E], E], ?, ? ] ]
         // TODO
         .withAfterReconcileIntercept({ case e => e._3 })
         /* `asTypeTupelified` */
         .asTypeTupelified
      }
      import sp10.{_2 as sp1 }

      // TODO
      class XSB extends
         aBackreferencings.XEAndStateBag(ec = { L.span })
         with aBackreferencings.XEAndStateBagCm[XM , Unit ]
      {
         ;

         override
         def close(): Unit
         = {}

         ;
         val peer
         = sp1.spawn(describeFieldElem(None ) )( )
         ;

         wrappedLaminarElement
         .amend(laminarInSpawneddLL(peer) , { import L.{given} ; L.span("✨") } )
         ;

         override
         def model_=(mdl: XM )
         = sp1.model_=(peer)(describeFieldElem(mdl ) )

         // ???

         ;
      }

      %%%%%[XM ](() => { new XSB().wrappedLaminarElement } )
   }

   ;
}

















val _ = {}
