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

   // // protected
   // class given_Conversion_SpiwmTwos_LaminarSpawnable_TypeKey

   /** 
    * warning - this's add a reg into the registry (with)in the NS `LReconciliativeKey`, leading to "memory leak"!
    * 
    */
   def allocateFactory
      //
      [
         mdlT,
         SpawnedLaminar <: ln.ReactiveElement[SpawnedDOMNode] ,
         SpawnedDOMNode <: dom.Element ,
         ReconcOpR,
         UOpR ,
      ]
      (initialValue : => mdlT )
      (using c : SpawnabilityAndReconciliabilityNoArg[mdlT, SpawnedLaminar, ReconcOpR] )
      (using toUOpR : Conversion[Boolean, UOpR] = (identity[Boolean] _ ) : Conversion[Boolean, Boolean] )
   : ((mdl: mdlT ) => LaminarSpawnable[SpawnedLaminar, SpawnedDOMNode] )
   = {
      ;

      val lR
      = SRNA.allocateGScanLeft(initialMdl = initialValue )(c )
      
      locally {
         ;

         lR
         match { case lR => laminarSpawnableMdlFactory(lR ) }
         match { case f => f }
      }
   }

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

trait ELSRNA
extends
   AnyRef
   // with w3e.pre.ArticlesViaLspwmt
   /* with these items item merely listed in the self-type, the IDE/editor won't show any relevant "overrides super member" markers */
   // that's all
   /* a temporary repetition here (of below) necessary to prevent the compiler from "crashing" or serious 100%-CPU hanging */
   // with w3e.pre.ArticlesViaLspw
   // with w3e.pre.Articles
   // with w3e.pre.ArticlesViaLspw
   with w3e.pre.ArticlesImplByL
   with ELaminarQckCoreLrks
{
   this : (
      AnyRef
      with w3e.pre.Articles
      with w3e.pre.ArticlesViaLspw
      with w3e.pre.ArticlesImplByL
      // with ELaminarQckCore1
      with ELaminarQckCoreLrks
      // with ELaminarQckCoreABackreferencings
   ) =>
   ;

   import com.raquo.laminar.{nodes as ln}

   import org.scalajs.dom

   ;

   /** 
    * warning - this's add a reg into the registry (with)in the NS `LReconciliativeKey`, leading to "memory leak"!
    * 
    */
   protected[avcframewrk]
   object SRNA
   {
      ;

      export LReconciliativeKey.allocate

      def allocateGScanLeft
         //
         [
            mdlT,
            SpawnedLaminar <: ln.ReactiveElement[?],
            ReconcOpR,
         ]
         (initialMdl: => mdlT )
         (impl : SpawnabilityAndReconciliabilityNoArg[mdlT, SpawnedLaminar, ReconcOpR] )
      : (
         SRNA
         [
            mdlT,
            SpawnedLaminar,
            ReconcOpR,
         ]
      )
      = {
         ;
         allocate[mdlT, SpawnedLaminar, SpawnedLaminar, ReconcOpR ](
            //
            impl = impl,
            getWrappedNativeNode = identity[SpawnedLaminar] _ ,
            initialMdl = initialMdl ,
            //
         )
      }

      ;

      ;
   }

   protected[avcframewrk]
   opaque type SRNA
      [
         -mdlT,
         +SpawnedLaminar <: ln.ReactiveElement[?],
         +ReconcOpR,
      ]
   <: LReconciliativeKeyTo1[LReconciliativeKey.ScnAllocAndReconcileAndDistillH[?, mdlT, SpawnedLaminar ] ]
   =  LReconciliativeKeyTo1[LReconciliativeKey.ScnAllocAndReconcileAndDistillH[?, mdlT, SpawnedLaminar ] ]

   ;

   ;

}

















val _ = {}
