package avcframewrk.forms

package templating

package w3e.impl.js

package s1
















/** 
 * 
 * 
 */
trait ELF1
extends
   AnyRef
   // with ELaminarQckCoreABackreferencings
   // with w3e.pre.ArticlesViaLspw
   // with ELaminarQckCore1
   // with ELSRNA
   // with ELaminarQckCoreWRE
   // with w3e.pre.ArticlesViaLspwmt
{
   this : (
      AnyRef
      with w3e.pre.Articles
      with ELaminarQckCoreABackreferencings
      with w3e.pre.ArticlesViaLspw
      with ELaminarQckCore1
      with ELSRNA
      with ELaminarQckCoreWRE
   ) =>
   ;

   import com.raquo.laminar.{nodes as ln}

   import org.scalajs.dom

   import laminar.api.L

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

   ;

   ;

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

   extension [
      Mdl,
      Spw <: ln.ReactiveHtmlElement[? <: dom.HTMLElement] ,
      U ,
   ] (f00: SpawnabilityAndReconciliabilityNoArg[Mdl, Spw, U ] ) {
      //

      def allocateReconcKey
         (defaultMdl: Mdl )
      : SRNA[Mdl, Spw, U ]
      = {
         ;

         val f01
         = f00.allocateReconcKeyAlt(defaultMdl )(identity(_) )

         f01
      }

      //
   }

   extension [ 
      Mdl,
      Spw0 ,
      U ,
   ] (f00: SpawnabilityAndReconciliabilityNoArg[Mdl, Spw0, U ] ) {
      //

      def allocateReconcKeyAlt
         [
            //
            Spw1 <: ln.ReactiveHtmlElement[? <: dom.HTMLElement]
            ,
         ]
         (defaultMdl: Mdl )
         (gex: Spw0 => Spw1 )
      : SRNA[Mdl, Spw1, U ]
      = {
         ;

         val f01
         = SRNA.allocateGScanLeftAlt((defaultMdl ) )(f00 )(gex )

         f01
      }

      //
   }

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
         allocateGScanLeftAlt
            (initialMdl )
            (impl )
            (identity[SpawnedLaminar] _ )
      }

      /* generalisation where `SpawnedCompStateBag`s doesn't need to be `ANativeNode`s */
      def allocateGScanLeftAlt
         //
         [
            mdlT,
            SpawnedLaminar <: ln.ReactiveElement[?],
            S ,
            ReconcOpR,
         ]
         (initialMdl: => mdlT )
         (impl : SpawnabilityAndReconciliabilityNoArg[mdlT, S, ReconcOpR] )
         (getNativeNode: S => SpawnedLaminar )
      : (
         LReconciliativeKeyTo1[(
            LReconciliativeKey.ScnAllocAndReconcileAndDistillH[S , mdlT, SpawnedLaminar ]
         ) ]
      )
      = {
         ;
         allocate[mdlT, S, SpawnedLaminar, ReconcOpR ](
            //
            impl = impl,
            getWrappedNativeNode = getNativeNode ,
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
         +SpawnedLaminar <: ln.ReactiveElement[?] ,
         +ReconcOpR,
      ]
   <: LReconciliativeKeyTo1[LReconciliativeKey.ScnAllocAndReconcileAndDistillH[?, mdlT, SpawnedLaminar ] ]
   =  LReconciliativeKeyTo1[LReconciliativeKey.ScnAllocAndReconcileAndDistillH[?, mdlT, SpawnedLaminar ] ]

   ;

   ;

}

















val _ = {}
