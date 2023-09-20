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
   this : (
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
      (using (ffRcKeying1.FKInpCompReconciliabilityKey[Value] ) )
   = {
      ;

      val fKInpCompRcKy
      = summon[ffRcKeying1.FKInpCompReconciliabilityKey[Value] ]

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

      /** 
       * a ReconciliabilityKey for `input` for `Value#`
       * 
       */
      opaque type FKInpCompReconciliabilityKey[Value]
      <: LReconciliativeKeyTo1[FKInpCompReconciliabilityKeyMinReconcilerOps[Value] ]
      =  LReconciliativeKeyTo1[FKInpCompReconciliabilityKeyMinReconcilerOps[Value] ]

      /** 
       * the associated-ReconciliabilityKey-associated for `input` for `Value#`
       * 
       * this narrows `SpawnedLaminar` to `ReactiveHTMLElement`.
       * currently, the support is restricted to the HTML NS
       * 
       */
      type FKInpCompReconciliabilityKeyMinReconcilerOps[Value ]
      >: LReconciliativeKey.ScnAllocAndReconcileAndDistillH[? , Option[BInputFunc[Value] ] , ? <: ln.ReactiveHtmlElement[? <: dom.HTMLElement ] ]
      <: LReconciliativeKey.ScnAllocAndReconcileAndDistillH[? , Option[BInputFunc[Value] ] , ? <: ln.ReactiveHtmlElement[? <: dom.HTMLElement ] ]

      ;

      /* for them each, its initialiser shall only run once, so we make it explicitly `val`s (as `implicit val`) rather than plain `given`s */

      /** 
       * a ReconciliabilityKey for `input` for `String#`
       * 
       */
      implicit
      final
      lazy val fKInpCompRcKyForString
      : (
         fKInpCompRcKyForStringImpl.repipingReconcKey.type
         & FKInpCompReconciliabilityKey[String]
      )
      = fKInpCompRcKyForStringImpl.repipingReconcKey

      /** 
       * a ReconciliabilityKey for `input` for `DateTime#`
       * 
       */
      implicit
      final
      lazy val fKInpCompRcKyForDateTime
      : (
         fKInpCompRcKyForDateTimeImpl.repipingReconcKey.type
         & FKInpCompReconciliabilityKey[w3e.pre.StdGsps.DateTime]
      )
      = fKInpCompRcKyForDateTimeImpl.repipingReconcKey

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
      lazy val fKInpCompRcKyForStringImpl
      : ffkAllocateSpecial[String]
      = ffkAllocateSpecial[String]

      implicit
      final
      lazy val fKInpCompRcKyForDateTimeImpl
      : ffkAllocateSpecial[w3e.pre.StdGsps.DateTime]
      = ffkAllocateSpecial[w3e.pre.StdGsps.DateTime]

      ;

      private[s1]
      class ffkAllocateSpecial[Value] private[s1]
            (using GspGoodDefaultValuation[Value ] )
            (using GivenSpinner1[Value ] )
            ()
      {
         ;

         /**
          * the lower-level 'class'
          * shall be
          * the one which is frame-based (`InpfaStatic`), rather than being sequence-based (`InpfaRefresh`)
          * 
          */
         val lowerLvlReconcKey
         = {
            ;
            SRNA.allocateGScanLeftAlt
               (None )
               ((
                  summonInpfaForPvF1[Value]
               ) )
               (e => e )
         }

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

         case class HigherLevelState(impl : (
            //

            (
               ln.ReactiveHtmlElement[?] ,
               L.Var[Option[BInputFunc[Value] ] ]
               ,
            )
         ) )
         {
            export impl.{_1 as s }
            export impl.{_2 as sg }
         }

         // given HigherLevelStateLlElement
         // : Conversion[HigherLevelState, ln.ReactiveHtmlElement[?] ]
         // = _.s

         val repipingImplReconciler
            /* can't make the type inferred, due to the resulting Cyclic Error .. */
         : (
            SpawnabilityAndReconciliabilityNoArg[
               //
               Option[BInputFunc[Value] ] ,
               HigherLevelState ,
               Unit ,
            ]
         )
         = {
            ;

            SpawnabilityAndReconciliabilityNoArg.bySpawnabilityAndReconciliabilityFnc[
               //
               Option[BInputFunc[Value] ] ,
               HigherLevelState ,
               Unit ,
            ] (
               //

               //
               spwImpl1 = (initialFrame ) => {
                  ;

                  // TODO
                  implicit
                  val subscrAssignee
                  = com.raquo.airstream.ownership.ManualOwner()

                  val s
                  = perFrameReconciler.spawn(None )( )

                  val repiping1
                  = laminar.api.L.Var[Option[BInputFunc[Value] ] ](initialFrame )

                  repiping1.signal

                  .map(o => (
                     for { s <- o }
                     yield s.frames
                  ) )
                  .flatMap({
                     case None =>
                        L.Val(None)
                     case Some(s) =>
                        for { sV <- s }
                        yield Some(sV)
                  })

                  .foreach(e => {
                     ;

                     // TODO
                     perFrameReconciler.model_=(s)(e )

                  }) 

                  HigherLevelState((s, repiping1) )
               } ,

               //
               reconcImpl1 = {
                  //

                  case (s0, newFrame ) =>
                     import s0.{s, sg}
                     sg
                     .set(newFrame )

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
               (_.s )
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

      ;
      compiletime.summonFrom({
         //

         case fKInpCompRcKy : (
            // ffRcKeying1.FKInpCompReconciliabilityKey[Value] /* caused "<path> is not a legal path since (... ... ) nonfinal (... ...)" complaints */
            ffRcKeying1S#FKInpCompReconciliabilityKey[Value]
         ) =>
            ;

            ({ given fKInpCompRcKy.type = fKInpCompRcKy ; summonInpfaForPv1[Value] })

         case _ =>
            // compiletime.error("no given FKInpCompReconciliabilityKey.")
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
      (using (ffRcKeying1.FKInpCompReconciliabilityKey[Value] ) )
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

   ;
}



















