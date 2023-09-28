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
   with ELaminarQckCorePfr2Rffr
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
   with ELaminarQckCoreFormCtrlElemReconcKeying1
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
      with ELaminarQckCoreFormCtrlElemReconcKeying1
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
      = FKCompReconciliabilityKey1(iAllocatedSpecialForString.repipingReconcKey )

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
      = FKCompReconciliabilityKey1(iAllocatedSpecialForDateTime.repipingReconcKey )

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

         import extraPffr2RffrGivenUnpck.{defaultPffr2RffrGivenUnpck as defaultPffr2RffrGivenUnpck }

         private[s1]
         val impl1
         : (
            Pffr2RffrGiven[InpfaStaticInvar[Value], ? <: ln.ReactiveHtmlElement[? <: dom.HTMLElement], Unit, defaultPffr2RffrGivenUnpck.type ]#contraFlatMap1OImpl[BInputFunc[Value] ]
         )
         = {
            ;

            lowerLvlReconcKey
            .toScnAllocAndReconcileAndDistillH
            .given_SpawnabilityAndReconciliabilityNoArg_Md_TIntermediateState

            .pffr2Rffr((desc : BInputFunc[Value] ) => desc.frames )

            match { case e => e }
         }

         export impl1.{
            perFrameReconciler0 ,
            perFrameReconciler ,
         }

         export impl1.repipingImplReconciler

         val repipingReconcKey
         = {
            SRNA.allocateGScanLeftAlt
               (None )
               (repipingImplReconciler )
               (_.wrappedLaminarElemI )
         }

         export impl1.RepipeModeCompStateBag

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

   ;
}



















