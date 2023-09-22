package avcframewrk.forms

package templating

package w3e.impl.js

package s1




















/**
 * 
 * .
 * 
 */
private[w3e]
trait ELaminarQckInputElemsReconcNativesExt
extends
   AnyRef
   /* */
   with ENativeElementsD1
   with ELaminarQckButtonsReconcNatives
   /* due to the self-types */
   with ELaminarQckInputElemsDataTypesPre
   /* a temporary repetition here (of below) necessary to prevent the compiler from hanging */
   with ELaminarQckCoreHtml
   with ELaminarQckButtonsReconcCtls
   with ELaminarQckButtonsActionModelling
   with ELaminarQckButtonsActionModellingTwo
   with w3e.pre.Articles
   with w3e.pre.Buttons
   with avcframewrk.forms.templating.w3e.impl.js.s1.ELaminarQckPlainStringConts
   with ELaminarQckCoreFailsafeReconcilers
   with ELaminarQckCoreFailsafeReconcilersArt
{
   thisArticlesAllocator : (
      AnyRef
      with w3e.pre.Articles
      with ELaminarQckCoreHtml
      with ELaminarQckButtonsActionModelling
      with ELaminarQckButtonsActionModellingTwo
      with ELaminarQckInputElemsReconcNativesModels
      with ENativeElementsD1
      with ELaminarQckCoreFailsafeReconcilers
      with ELaminarQckCoreFailsafeReconcilersArt
   ) =>
   ;

   import com.raquo.laminar.{nodes as ln}

   import org.scalajs.dom

   import laminar.api.L

   ;

   ;

   ;

   ;

   /**
    * sequence-based (`InpfaRefresh` via `BInputFunc`)
    * 
    */
   // private[s1]
   def summonInpfaForPv11
      [Value]
      //
      (using (ffRcKeying1.FKCompReconciliabilityKey[Value, BInputFunc] ) )
   = {
      ;

      val fKInpCompRcKy
      = summon[ffRcKeying1.FKCompReconciliabilityKey[Value, BInputFunc ] ]

      val describeFieldElem
      = {
         laminarSpawnableMdlFactory
            [
               //
               Option[BInputFunc[Value] ], (
                  LReconciliativeKey.ScnAllocAndReconcileAndDistillH[
                     //
                     ? ,
                     Option[BInputFunc[Value] ] ,
                     ? <: ln.ReactiveHtmlElement[? <: dom.HTMLElement ] ,
                  ]
                  //
               ) ,
               ln.ReactiveHtmlElement[? <: dom.HTMLElement ],
               dom.HTMLElement,
            ]
            ( fKInpCompRcKy )
      }

      describeFieldElem
   }

   /* "<path> is not a legal path since (... ... ) nonfinal (... ...)" complaints */
   private[s1]
   type ffRcKeying1S
   = ffRcKeying1.type

   private[s1]
   object ffRcKeying1
   {
      ;

      export thisArticlesAllocator.{
         FKCompReconciliabilityKey ,
         FKCompReconciliabilityKeyMinReconcilerOps ,
      }

      ;

      /* 
       * 
       * for these each,
       * since they're `allocateIt`s,
       * its initialiser shall only run once
       * ;
       * to
       * prevent the RHS(es) from running the second time,
       * we
       * make it explicitly `val`s (as `implicit val`), which necessarily provides that guarantee,
       * rather than plain `given`s
       * 
       */

      implicit
      final
      lazy
      val   iSpecialPerFrameBasedReconcKeyString : LReconciliativeKeyInpfaStatic[String] = flAllocateSpecialPerFrameBasedReconcKey

      implicit
      final
      lazy
      val   iSpecialPerFrameBasedReconcKeyDateTime : LReconciliativeKeyInpfaStatic[w3e.pre.StdGsps.DateTime] = flAllocateSpecialPerFrameBasedReconcKey

      /** 
       * a ReconciliabilityKey for `input` for `String#`
       * 
       */
      implicit
      final
      lazy val iSpecialBDescrBasedReconcKeyForString
      : (
         iAllocatedSpecialForString.repipingReconcKey.type
         & FKCompReconciliabilityKey[String, BInputFunc ]
      )
      = iAllocatedSpecialForString.repipingReconcKey

      /** 
       * a ReconciliabilityKey for `input` for `DateTime#`
       * 
       */
      implicit
      final
      lazy val iSpecialBDescrBasedReconcKeyForDateTime
      : (
         iAllocatedSpecialForDateTime.repipingReconcKey.type
         & FKCompReconciliabilityKey[w3e.pre.StdGsps.DateTime , BInputFunc ]
      )
      = iAllocatedSpecialForDateTime.repipingReconcKey

      ;

      ;

      /* 
       * these handful each
       * covers more than just the `LReconciliativeKey` ;
       * it also exposes the associated defs,
       * might be of use in future
       * 
       */

      implicit
      final
      lazy val iAllocatedSpecialForString
      : iAllocateSpecial[String]
      = iAllocateSpecial[String]

      implicit
      final
      lazy val iAllocatedSpecialForDateTime
      : iAllocateSpecial[w3e.pre.StdGsps.DateTime]
      = iAllocateSpecial[w3e.pre.StdGsps.DateTime]

      ;

      private[s1]
      class iAllocateSpecial[Value] private[s1]
            (using GspGoodDefaultValuation[Value ] )
            (using GivenSpinner1[Value ] )
            /**
             * the lower-level 'class'
             * shall be
             * the one which is frame-based (`InpfaStatic`), rather than being sequence-based (`InpfaRefresh`)
             * 
             */
            (using val lowerLvlReconcKey : (
               //

               LReconciliativeKeyTo1[(
                  FKCompReconciliabilityKeyMinReconcilerOps[Value, InpfaStaticInvar, ln.ReactiveHtmlElement[? <: dom.HTMLElement ] ]
               )]
            ) )
            ()
      {
         ;

         val perFrameReconciler0
         = {
            ({
               ;
               lowerLvlReconcKey
               .toScnAllocAndReconcileAndDistillH
               .given_SpawnabilityAndReconciliabilityNoArg_Md_TIntermediateState
            })
            match { case s: SpawnabilityAndReconciliabilityNoArg[t1, t2, t3] => s: SpawnabilityAndReconciliabilityNoArg[t1, ? <: t2, t3] }
            match { case s => s.asTypeTupelified }
         }
         /* can't use `import` */
         val perFrameReconciler
         : perFrameReconciler0._2.type
         = perFrameReconciler0._2

         val repipingImplReconciler
            /* can't make the type inferred, due to the resulting Cyclic Error .. */
         : (
            SpawnabilityAndReconciliabilityNoArg[
               //
               Option[BInputFunc[Value] ] ,
               RepipeModeCompStateBag ,
               Unit ,
            ]
         )
         = {
            ;

            SpawnabilityAndReconciliabilityNoArg.bySpawnabilityAndReconciliabilityFnc[
               //
               Option[BInputFunc[Value] ] ,
               RepipeModeCompStateBag ,
               Unit ,
            ] (
               //

               //
               spwImpl1 = (initialDescrOption ) => {
                  ;

                  // TODO
                  implicit
                  val subscrAssignee
                  = com.raquo.airstream.ownership.ManualOwner()

                  val frameCounter = L.Var[Int](0)

                  val e1
                  = perFrameReconciler.spawn(None )( )

                  val internalReconcileTo
                  = {
                     (perFrameReconciler.model_=(e1) _ )
                     match { case f : Function1[aType, r] => {
                        f.compose((a: aType ) => { frameCounter.update(_ + 1 ) ; a } )
                     } }
                  }

                  val repipeCounter = L.Var[Int](0)

                  val repiping1
                  = L.Var[Option[BInputFunc[Value] ] ](initialDescrOption )

                  repiping1.signal
                  .foreach(mdlOption => { repipeCounter.update(_ + 1 ) } )

                  repiping1.signal

                  .flatMap({

                     case None =>
                        for { _ <- L.Val(() ) }

                        yield () => {
                           internalReconcileTo(None )
                        }

                     case Some(desc) =>
                        ;

                        val eFrames
                        = desc.frames

                        for {
                           eFrame <- eFrames
                        }
                        yield (() => {
                           internalReconcileTo(Some(eFrame ) )
                        } )

                  })
                  .foreach(_.apply() )

                  val e11 = {
                     ;

                     import L.{given}

                     def xNewCounterComponent
                        (src: L.Source[Int] )
                     = {
                        L.span(L.child <-- src.toObservable.map(_.toString() ) )
                     }

                     L.span(e1, (
                        L.span("[", (
                           L.span(s"frames:", xNewCounterComponent(src = frameCounter ), L.title := "the frame-count" )
                        ) , ";" , (
                           L.span(s"repipes:", xNewCounterComponent(src = repipeCounter ), L.title := "the count of switching across the src BInputFunc(s) " )
                        ) , L.button("Repipe", L.onClick --> (_ => { repiping1.update(identity _ ) } ) ) , "]" )
                     ) )
                  }

                  RepipeModeCompStateBag((e11, repiping1) )
               } ,

               //
               reconcImpl1 = {
                  //

                  case (s0, newDescrOption ) =>
                     ;
                     s0.btnModelOption_=(newDescrOption )

                  //
               } ,

               //
            )
         }

         val repipingReconcKey
         = {
            SRNA.allocateGScanLeftAlt
               (None )
               (repipingImplReconciler )
               (_.wrappedLaminarElemI )
         }

         case class RepipeModeCompStateBag(impl : (
            //

            (
               ln.ReactiveHtmlElement[?] ,
               L.Var[Option[BInputFunc[Value] ] ]
               ,
            )
         ) )
         {
            ;

            export impl.{_1 as wrappedLaminarElemI }

            export impl._2.{set as btnModelOption_= }

         }

         val repipingPosReconciler0
         = {
            ;
            repipingReconcKey
            .toScnAllocAndReconcileAndDistillH
            .given_SpawnabilityAndReconciliabilityNoArg_Md_TIntermediateState
            .asTypeTupelified
         }

         // TODO
      }

      ;

      // TODO

      ;
   }

   ;

   /**
    * the lower-level 'class'
    * shall be
    * the one which is frame-based (`InpfaStatic`), rather than being sequence-based (`InpfaRefresh`)
    * 
    */
   def flAllocateSpecialPerFrameBasedReconcKey
      //
      [Value]
      (using GspGoodDefaultValuation[Value ] )
      (using GivenSpinner1[Value ] )
   : LReconciliativeKeyInpfaStatic[Value]
   = {
      ;

      ;
      SRNA.allocateGScanLeftAlt
         (None )
         ((
            summonInpfaForPvF1[Value]
         ) )
         (e => e )
   }

   ;

   ;

   // TODO
   @deprecated
   private[s1]
   inline
   def summonInpfaForPv
      [Value]
      //
      (using GivenSpinner1[Value ] )
      (using GspGoodDefaultValuation[Value ] )
   : SpawnabilityAndReconciliabilityNoArg[Option[BInputFunc[Value]], ? <: ln.ReactiveHtmlElement[dom.HTMLElement], Unit]
   = {
      ;

      import ffRcKeying1.{given }

      ;
      compiletime.summonFrom({
         //

         case fKInpCompRcKy : (
            // ffRcKeying1.FKCompReconciliabilityKey[Value] /* caused "<path> is not a legal path since (... ... ) nonfinal (... ...)" complaints */
            ffRcKeying1S#FKCompReconciliabilityKey[Value, BInputFunc ]
         ) =>
            ;

            ({ given fKInpCompRcKy.type = fKInpCompRcKy ; summonInpfaForPv1[Value] })

         case _ =>
            // compiletime.error("no given FKCompReconciliabilityKey.")
            summonInpfaForPvB[Value]

      })
   }

   // TODO
   @deprecated
   private[s1]
   def summonInpfaForPv1
      [Value]
      //
      (using GivenSpinner1[Value ] )
      (using GspGoodDefaultValuation[Value ] )
      (using (ffRcKeying1.FKCompReconciliabilityKey[Value, BInputFunc ] ) )
   : SpawnabilityAndReconciliabilityNoArg[Option[BInputFunc[Value]], ? <: ln.ReactiveHtmlElement[dom.HTMLElement], Unit]
   = {
      ;

      if true then ({
         ;

         val describeFieldElem
         = summonInpfaForPv11[Value]

         lnByModelElemReconciler1
            (describeFieldElem = describeFieldElem )
      })
      else {
         summonInpfaForPvB[Value]
      }
   }

   ;

   type LReconciliativeKeyInpfaStatic[Value]
   = (
      //
      (
         LReconciliativeKeyTo1[(
            FKCompReconciliabilityKeyMinReconcilerOps[Value, InpfaStaticInvar, ln.ReactiveHtmlElement[? <: dom.HTMLElement ] ]
         )]
      )
   )

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

   /** 
    * adaptor to convert to `FKCompReconciliabilityKey`
    * 
    */
   // implicit
   def FKCompReconciliabilityKey1[Value, XMdlByValue[_] ]
   : Conversion[
      //
      LReconciliativeKeyTo1[FKCompReconciliabilityKeyMinReconcilerOps[Value, XMdlByValue, Any ] ] ,
      FKCompReconciliabilityKey[Value, XMdlByValue ] ,
   ]
   = identity[FKCompReconciliabilityKey[Value, XMdlByValue ] ] _

   ;
}



















