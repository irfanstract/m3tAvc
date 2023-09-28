package avcframewrk.forms

package templating

package w3e.impl.js

package s1






















/** 
 * 
 * implementative mix-in `ELaminarQckCore1`
 * 
 */
private[s1]
trait ELaminarQckCoreLaminarSpawnableAbstract1
extends
   AnyRef
   // with w3e.pre.ArticlesViaLspw
   // with ELaminarQckCoreLrksBased
   // with ELaminarQckCoreLrks
   // with w3e.pre.ArticlesViaLspwmt
   /* with these items item merely listed in the self-type, the IDE/editor won't show any relevant "overrides super member" markers */
   // with w3e.pre.Articles
   /* with these items item merely listed in the self-type,  (.....) */
   // with w3e.pre.ADefinesNativeDocNodeType0
{
   this : (
      AnyRef
      with w3e.pre.Articles
   ) =>
   ;

   import com.raquo.laminar.{nodes as ln}

   import org.scalajs.dom

   ;

   ;

   ;

   ;

   // TODO move this up in/on/to extracted new super-class
   /** 
    * spawned instance
    * 
    */
   type SpawnedArtReconcilerAndStateBagPair
   = SpawnedArtReconcilerAndStateBagPairToLD[dom.Element ]

   /** 
    * spawned instance,
    * from which the returned `ln.ReactiveElement` would conform to the given sub-type `SpawnedLaminar`
    * 
    */
   type SpawnedArtReconcilerAndStateBagPairToLL[+SpawnedLaminar <: ln.ReactiveElement[?] ]
   = SpawnedArtReconcilerAndStateBagPairImpl[Nothing, dom.Element, SpawnedLaminar ]

   /** 
    * spawned instance,
    * from which the returned `ln.ReactiveElement`'s `.ref : dom.Element` would conform to the given sub-type `SpawnedDOMNode`
    * 
    */
   type SpawnedArtReconcilerAndStateBagPairToLD[+SpawnedDOMNode <: dom.Element ]
   = SpawnedArtReconcilerAndStateBagPairImpl[Nothing, SpawnedDOMNode, ln.ReactiveElement[SpawnedDOMNode] ]

   private[s1]
   type SpawnedArtReconcilerAndStateBagPairImpl
      [
         +T0,
         +SpawnedDOMNode <: dom.Element ,
         +SpawnedLaminar <: ln.ReactiveElement[SpawnedDOMNode] ,
      ]
   <: AnyRef

   ;
}

/** 
 * 
 * implementative mix-in `ELaminarQckCoreLrksBased`
 * 
 */
trait ELaminarQckCoreLrksBased
extends
   AnyRef
   //
   with ELaminarQckCoreLrks
   with w3e.pre.ArticlesImplLReconciliativeKeyFoundPairs
{
   thisELaminarQckCoreLrks : (
      AnyRef
      & ELaminarQckCoreLrks
      // & w3e.pre.ArticlesViaLspw
   ) =>
   ;

   ;

   import com.raquo.laminar.{nodes as ln}

   import org.scalajs.dom

   ;

   ;
}

/**
 * 
 * a complement of `w3e.pre.ArticlesImplByL`,
 * which builds on Laminar
 * 
 */
trait ELaminarQckCoreLrks
extends
   AnyRef
   // with w3e.pre.ArticlesViaLspwmt
   /* with these items item merely listed in the self-type, the IDE/editor won't show any relevant "overrides super member" markers */
   with w3e.pre.ArticlesImplByL
{
   thisELaminarQckCoreLrks : (
      AnyRef
      & w3e.pre.ArticlesImplByL
   ) =>
   ;

   import com.raquo.laminar.{nodes as ln}

   import org.scalajs.dom

   ;

   ;

   /** 
    * supposed to be the main/primary data-type (or repr) in the targeted backend/fw -
    * this could be `React.Element`, `DOM.Element`, `Laminar.Element`, etc
    * 
    */
   override
   type NativeDocNode
   >: ln.ReactiveElement[?]
   <: ln.ReactiveElement[?]

   ;

   /** 
    * note -
    * avoid summon-ing `T1 =:= T2` directly as it places execssive assumptions ;
    * split it into the two `T1 <:< T2` and `T2 <:< T1` ; 
    * 
    */
   summon[NativeDocNode <:< ln.ReactiveElement[?] ]
   summon[ln.ReactiveElement[?] <:< NativeDocNode ]

   lazy val _ = {
      ;

      def gt[SpawnedLaminar <: ln.ReactiveElement[dom.Element] ]
      = summon[SpawnedLaminar <:< NativeDocNode ]

      summon[NativeDocNode <:< ln.ReactiveElement[?] ]

      ;
   }

}




































val _ = {}
