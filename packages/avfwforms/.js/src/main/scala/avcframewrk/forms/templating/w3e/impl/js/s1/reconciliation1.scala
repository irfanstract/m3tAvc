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

      // TODO remove this
      private[s1]
      def lEAlt
      = {
         // if this.lE != scalajs.js.undefined then {}
         // else { throw cst }
         assert((     lE ) != scalajs.js.undefined , s"'lE' remained undefined , for ${this }" )
         assert((this.lE ) != scalajs.js.undefined , s"'this.lE' remained undefined , for ${this }" )
         this.lE
      }

      // // TODO remove this
      // private
      // val cst
      // = { new CstError(s"for ${this }") }

      // TODO remove this
      lEAlt

   }

   extension [HL] (this1: XScanLeftReconciliativeOps[HL, ?, ?] ) {
      //

      transparent
      inline def wrappedLaminarElem
      : HL
      // = this1.lE
      = this1.lEAlt

      //
   }

   extension [HL <: ln.ReactiveElement[?] ] (h: XScanLeftReconciliativeOps[HL, ?, ?] ) {
      //

      /** 
       * an early check against the anticipated (spurious) `ClassCastException` ;
       * needs renaming into "YyyError", otherwise
       * , being an `Exception`, DevTools won't properly recosnstruct the src file-names
       * (stack-traces of `Exception`(s) only pointed to `sjs.rt.AnonFunction`s ; we'wre left with nothing helpful )
       * (Scala JS)
       * 
       */
      transparent
      inline
      def wrappedLaminarElemLst
      = {
         ;

         locally((
            util.Try((
               h.wrappedLaminarElem
               .amend() /* this `.amend()` is necessary, to reproduce the issue */
            ))
            .recover(z => throw (z match {
               case z : ClassCastException =>
                  new LlrConHException(s"spurious non-conformance while eval-ing 'h.wrappedLaminarElem' ('h': ${h} ) ($z) ; make sure ur app doesn't do unsafe-cast(s), and try again! ")
               case util.control.NonFatal(z) =>
                  new LlrConHException(s"other exception ($z) ; make sure ur app doesn't do unsafe-cast(s), and try again! ")
            }))
            .get
         ) )

         h.wrappedLaminarElem
      }

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
         match { case e => assert((e : XScanLeftReconciliativeOps[?, ?, ?] ).wrappedLaminarElem != scalajs.js.undefined, s"for ${e } " ) ; e }
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

   // TODO
   inline given llrConH[T]
   : AnyRef with {

      lazy val creationStackTrace
      = {
         e
         .getStackTrace().nn.toIndexedSeq
         .take((
            // 5
            /* for `scalac` this'd be : */
            15
         ))
         .map(_.toString() )
         .map((
            _
            // .prependedAll("  at") /* breaks the DevTools' stack-trace-to-src-file nav */
            .prependedAll("right at ")
         ))
         .:+("...") /* "more" */
         .map("  " + _ ) /* indentation */
         .prepended("itc created")
         .mkString("", "\r\n", "\r\n")
      }

      val e: Throwable = new Error()

      // object c {}

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
      (using llrConH[Any] )
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

            match { case h => {

               /** 
                * an early check against the anticipated (spurious) `ClassCastException` ;
                * needs renaming into "YyyError", otherwise
                * , being an `Exception`, DevTools won't properly recosnstruct the src file-names
                * (stack-traces of `Exception`(s) only pointed to `sjs.rt.AnonFunction`s ; we'wre left with nothing helpful )
                * (Scala JS)
                * 
                */
               h.wrappedLaminarElemLst

               h
            } }
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
                  // .delay(5 * 1000) // TODO remove this LOC
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
                  // TODO
                  .recoverToTry
                  .map(e => {
                     ({ if unmountIfFailure(e) then unmountOnFailureDone })
                     e
                     .recover({
                        case util.control.NonFatal(z) =>
                           org.scalajs.dom.console
                           .infoExceptionCollapsed(z)
                           org.scalajs.dom.console
                           .infoExceptionCollapsed(summon[llrConH[?] ].e, headline = "SST:" )
                           throw new LlrConHException(s"exception while updating ; <${wrappedLaminarElement.ref.tagName }> ; ${summon[llrConH[?] ].creationStackTrace } ; ${z} ", z )
                     })
                     .get
                  })
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

   // transparent inline
   def spawnLlrScanConv
      [
         ContentModelBase,
         Spawned,
         ReconcOpR >: Unit <: Unit ,
      ]
      (src: laminar.api.L.Signal[ContentModelBase] )(using spawner : SpawnabilityAndReconciliabilityNoArg[ContentModelBase, Spawned, ReconcOpR ])
   : laminar.api.L.Signal[Spawned]
   = {
      ;

      src
      .scanLeft[Spawned](v0 => v0.spawn() )((c, newModel ) => { c.model_=(newModel ) ; c } )
   }

   // TODO
   private
   object unmountOnFailureDone
   {
      org.scalajs.dom.console.warn(new Exception(s"unmounted the component, due to an exception") )
   }
   
   ;
} // ELaminarQckCoreFailsafeReconcilers

protected[avcframewrk]
type LlrConHException
= LlrConHError

/** 
 * needs renaming into "YyyError", otherwise
 * , being an `Exception`, DevTools won't properly recosnstruct the src file-names
 * (stack-traces of `Exception`(s) only pointed to `sjs.rt.AnonFunction`s ; we'wre left with nothing helpful )
 * (Scala JS)
 * 
 */
private[s1]
class LlrConHError(msg: String, cause: Null | Throwable = null )
extends
   RuntimeException(msg, cause )
{
}

private[s1]
class CstError(msg: String) extends Exception(msg)

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
