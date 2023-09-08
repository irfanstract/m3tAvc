package avcframewrk.forms

package templating

package w3e.impl.js

package s1





















/**
 * a pair, which's
 * a `SpawnabilityAndReconciliabilityNoArg` and a "data-model"
 * 
 * refines the tuple-type to achieve that 'dependent-typing' of `_1`
 * 
 */
export templating.rendering.SpiwmTwos

export templating.rendering.{spawnThisSpiwmTwos, doSpiwmTwoReconciliationOf }

val _ = {
   ((arg : SpiwmTwos[1, 2, 3] ) => {})
   .nn
}

trait ELaminarQckCoreFailsafeReconcilers
extends
   AnyRef
   /* a temporary repetition here (of below) necessary to prevent the compiler from hanging */
   with ELaminarQckCoreABackreferencings
{
   this : (
      AnyRef
      & ELaminarQckCoreABackreferencings
   ) =>
   ;

   import com.raquo.laminar.{nodes as ln}

   import org.scalajs.dom

   ;

   ;

   extension [HL, Md0, UOpR] (this1: SpawnabilityAndReconciliabilityNoArg[Md0, HL, UOpR ] ) {
      //

      /**
       * pre-`map`-ed version of the `SpawnabilityAndReconciliabilityNoArg`,
       * very much what `Function1#compose` and `com.raquo.airstream.Observer#contraMap` does
       * 
       */
      def compose
         [Md1]
         (f: Md1 => Md0 )
      : SpawnabilityAndReconciliabilityNoArg[Md1, HL, UOpR]
      = {
         SpawnabilityAndReconciliabilityNoArg.bySpawnabilityAndReconciliabilityFnc(
            //
            spwImpl1 = (mdl: Md1) => (mdl match { case mdl => f(mdl) } match { case mdl => this1.spawn(mdl)( ) } )
            ,
            reconcImpl1 = (thisJ, mdl) => (mdl match { case mdl => f(mdl) } match { case mdl => this1.model_=(thisJ)(mdl ) } )
         )
      }

      //
   }

   /**
    * 
    * a locally-adjusted itc for scan-left (see `IterableOnceOps`) reconciliation
    * 
    */
   private[s1]
   trait XScanLeftReconciliativeOps
      [
         +HL ,
         ContentModel1,
         +UOpR ,
      ]
      (
         //
         private[s1]
         val lE
         : HL
         ,
      )
      (using val given_TypeTest_ContentModel1 : reflect.Typeable[ContentModel1 ] )
   {
      ;

      type ContentModel
      = ContentModel1

      def updateTo
         (m : ContentModel )
      : UOpR

   }

   extension [HL] (this1: XScanLeftReconciliativeOps[HL, ?, ?] ) {
      //

      transparent
      inline def wrappedLaminarElem
      : HL
      = this1.lE

      //
   }

   extension [HL, Md, UOpR] (this1: SpawnabilityAndReconciliabilityNoArg[Md, HL, UOpR ] ) {
      //

      def spawnAsXsr
         (using reflect.Typeable[Md] )
         (v: Md)
      : XScanLeftReconciliativeOps[HL, Md, UOpR ]
      = {
         val e = this1.spawn(v)()
         ;
         ;
         new XScanLeftReconciliativeOps[e.type, Md, UOpR ](lE = e ) { def updateTo(m: Md) = this1.model_=(lE)(m) }
      }

      //
   }

   extension [HL, Md, UOpR] (using supp: SpawnabilityAndReconciliabilityNoArg[Md, HL, UOpR ] )(md: Md) {
      //

      def spawnSelfAsXsr
         (using reflect.Typeable[Md] )
      = supp.spawnAsXsr(md)

      //
   }

   extension [HL, Md, UOpR] (this1: SpawnabilityAndReconciliabilityNoArg[Md, HL, UOpR ] ) {
      //

      /**
       * an `ExplicitFunction1` wrapper over it.
       * to be used with `llrConv`.
       * 
       */
      def spawnFncXsr
         [Md1 <: Md ]
         (using c: reflect.Typeable[Md1] )
      = this1.spawnAsXsr(using c ) _

      //
   }

   @deprecated("this variant is unlikely what you want.")
   def llrConv1
      [
         ContentModelBase
         : reflect.Typeable
         ,
         ContainerNative <: org.scalajs.dom.HTMLElement ,
         UOpR ,
      ]
      (container : com.raquo.laminar.tags.HtmlTag[ContainerNative] )
      (spwAndReconc: SpawnabilityAndReconciliabilityNoArg[ContentModelBase, ? <: ln.ReactiveHtmlElement[?] , UOpR ] )
   = {
      ;

      llrConv
         (container )
         (spawnAsScReconciler = (c: ContentModelBase ) => spwAndReconc.spawnAsXsr(c) )
   }

   /**
    * a `SpawnabilityAndReconciliabilityNoArg` which is a fail-safe impl -
    * it will first try reconciling with the last `SpawnedAsScReconciler` falling back to running `spawnAsScReconciler` the second time
    * 
    * 
    * @param container the Laminar `HtmlTag` over the intended container e/c
    * 
    */
   def llrConv
      [
         SpawnedAsScReconciler <: XScanLeftReconciliativeOps[? <: ln.ReactiveHtmlElement[?], ?, UOpR ]
         ,
         ContentModelBase
         ,
         ContainerNative <: org.scalajs.dom.HTMLElement ,
         UOpR ,
      ]
      (container : com.raquo.laminar.tags.HtmlTag[ContainerNative] )
      (spawnAsScReconciler: (mdl: ContentModelBase ) => SpawnedAsScReconciler)
   : SpawnabilityAndReconciliabilityNoArg[ContentModelBase, ? <: ln.ReactiveHtmlElement[ContainerNative], UOpR]
   = {
      ;

      import laminar.api.L

      ;

      ;

      def reconcileOrRecreate(scMaybe : Option[SpawnedAsScReconciler], newMdl: ContentModelBase)
      : SpawnedAsScReconciler
      = {
         ;

         ;

         /**
          * at the first turn `scMaybe` would be `None`, and
          * even then
          * it's possible `sc.TypeTest` point(ed) to a `type` which `newMdl` doesn't conform to
          * 
          */
         (for {

            /** at the first turn `scMaybe` would be `None` */
            sc <- scMaybe

            /** it's possible `sc.TypeTest` point(ed) to a `type` which `newMdl` doesn't conform to */
            case sc.given_TypeTest_ContentModel1(newMdl) <- Some(newMdl)
         }
         yield {
            sc.updateTo(newMdl)
            sc
         } )

         .getOrElse[SpawnedAsScReconciler ] ({
            spawnAsScReconciler(newMdl )
         })
      }

      def newContentModelLmVar()
      = {
         ;

         L.Var[Option[(ContentModelBase) ] ](None)

         match { case v => {
            (
               v.writer.contramap((e: ContentModelBase ) => Some(e) ) ,
               v.signal ,
            )
         } }
      }

      class XEAndStateBag1() extends
      aBackreferencings.XEAndStateBag(ec = { container })
      with aBackreferencings.XEAndStateBagCm[ContentModelBase, Unit ]
      {
         ;

         import laminar.api.L

         ;

         override
         def close(): Unit
         = {
            closeAllOf(Seq() :+ cL )
         }

         val cL
         = {
            ;

            val (mdlSetter, mdlOptionAnim)
            = {

               newContentModelLmVar()
            }
            ;

            wrappedLaminarElement
            .amend((

               L.child

               .<--({

                  mdlOptionAnim
                  .changes
                  .collect({ case Some(v) => v })
                  .scanLeft[Option[SpawnedAsScReconciler] ](None)({
                     //

                     case (scMaybe, newMdl) =>
                        ;

                        reconcileOrRecreate(scMaybe, newMdl )
                        match { case r => Some(r) }

                     //
                  })
                  .map(o => (o.map(_.wrappedLaminarElem) getOrElse L.span() ) )
                  .map(e => e )
               })

            ))

            mdlSetter
         }

         override
         def model_=(newMdl: ContentModelBase)
         : Unit
         = {
            cL
            .onNext(newMdl )
         }

         ;
      }

      ({
         ;

         aBackreferencings.given_Conversion_C_SpawnabilityAndReconciliabilityNoArg_1[ContentModelBase, UOpR, ln.ReactiveHtmlElement[ContainerNative], ContainerNative ]
         .apply(() => new XEAndStateBag1().wrappedLaminarElement )
      })
   }
   
   ;
} // ELaminarQckCoreFailsafeReconcilers

trait ELaminarQckCoreFailsafeReconcilersArt
extends
   AnyRef
   /* a temporary repetition here (of below) necessary to prevent the compiler from hanging */
   with ELaminarQckCoreABackreferencings
   with ELaminarQckCoreFailsafeReconcilers
   with ELaminarQckCore
   with ELaminarQckCoreHtml
{
   this : (
      AnyRef
      & ELaminarQckCoreABackreferencings
      & ELaminarQckCoreFailsafeReconcilers
      & ELaminarQckCore
      & ELaminarQckCoreHtml
   ) =>
   ;

   import com.raquo.laminar.{nodes as ln}

   import org.scalajs.dom

   ;

   ;

   ;

   def llrConvToArt
      [
         SpawnedAsScReconciler <: XScanLeftReconciliativeOps[? <: ln.ReactiveHtmlElement[?], ?, UOpR ]
         ,
         ContentModelBase
         ,
         ContainerNative <: org.scalajs.dom.HTMLElement ,
         UOpR >: Unit <: Unit ,
      ]
      (container : com.raquo.laminar.tags.HtmlTag[ContainerNative] )
      (spawnAsScReconciler: (mdl: ContentModelBase ) => SpawnedAsScReconciler)
      (initialDataValue: ContentModelBase )
   : Article
   = {
      ;

      val art = llrConv(container)(spawnAsScReconciler)

      {
         ;

         type artSc
         = ({ type Main[T] = T match { case SpawnabilityAndReconciliabilityNoArg[?, sc, ?] => sc } })#Main[art.type ]

         // (art, initialDataValue ) : Article

         // summon[(
         //    Conversion[
         //       //

         //       ? <: (
         //          // SpiwmTwos[ContentModelBase, ?, ? ]
         //          // &
         //          // (SpawnabilityAndReconciliabilityNoArg[ContentModelBase, LElemPlusPossibleData[? <: ln.ReactiveHtmlElement[?] ], ? ], Any )
         //          (SpawnabilityAndReconciliabilityNoArg[ContentModelBase, ?, ? ], Any )
         //       ) ,
         //       ?
         //       <: LaminarSpawnable[ln.ReactiveHtmlElement[dom.HTMLElement], dom.HTMLElement]
         //       ,
         //    ]
         // ) ]
         // given_Conversion_SpiwmTwos_LaminarSpawnable[ln.ReactiveHtmlElement[dom.HTMLElement], dom.HTMLElement, ContentModelBase ]
         given_Conversion_SpiwmTwos_LaminarSpawnable[artSc, dom.HTMLElement, ContentModelBase ]
         .apply(((initialDataValue, art) : (initialDataValue.type, art.type) ).swap )
      }
   }

   ;
}


















val _ = {}
