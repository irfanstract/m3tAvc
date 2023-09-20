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

   // TODO
   private[s1]
   inline
   def summonInpfaForPv
      [Value]
      //
      (using GspGoodDefaultValuation[Value ] )
      (using GivenSpinner1[Value ] )
   : SpawnabilityAndReconciliabilityNoArg[Option[BInputFunc[Value]], ? <: ln.ReactiveHtmlElement[dom.HTMLElement], Unit]
   = {
      ;

      ;
      compiletime.summonFrom({
         //

         case sgv0 : (ffRcKeying1.FormFieldStatiqueReconciliabilityKey[Value] ) =>
            ;

            val ffStaticRcKy
            = sgv0

            val describeFieldElem
            = {
               laminarSpawnableMdlFactory
                  [Option[BInputFunc[Value] ], (
                     LReconciliativeKey.ScnAllocAndReconcileAndDistillH[? , Option[BInputFunc[Value] ] , ? <: ln.ReactiveHtmlElement[? <: dom.HTMLElement ] ]
                     //
                  ) , ln.ReactiveHtmlElement[? <: dom.HTMLElement ], dom.HTMLElement ]
                  ( ffStaticRcKy )
            }

            if true then ({
               ;

               ;

               lnByModelElemReconciler1
                  (describeFieldElem = describeFieldElem )
            })
            else {
               summonInpfaForPvB[Value]
            }

         case _ =>
            // compiletime.error("no given FormFieldStatiqueReconciliabilityKey.")
            summonInpfaForPvB[Value]

      })
   }

   // private[s1] /* caused "<path> is not a legal path since (... ... ) nonfinal (... ...)" complaints */
   object ffRcKeying1
   {
      ;

      opaque type FormFieldStatiqueReconciliabilityKey[Value]
      <: LReconciliativeKeyTo1[FormFieldStatiqueReconciliabilityKeyMinReconcilerOps[Value] ]
      =  LReconciliativeKeyTo1[FormFieldStatiqueReconciliabilityKeyMinReconcilerOps[Value] ]

      type FormFieldStatiqueReconciliabilityKeyMinReconcilerOps[Value ]
      >: LReconciliativeKey.ScnAllocAndReconcileAndDistillH[? , Option[BInputFunc[Value] ] , ? <: ln.ReactiveHtmlElement[? <: dom.HTMLElement ] ]
      <: LReconciliativeKey.ScnAllocAndReconcileAndDistillH[? , Option[BInputFunc[Value] ] , ? <: ln.ReactiveHtmlElement[? <: dom.HTMLElement ] ]

      /* for them each, its initialiser shall only run once, so we make it explicitly `val`s (as `implicit val`) */

      implicit
      final
      lazy val ffStaticRcKyForString
      : FormFieldStatiqueReconciliabilityKey[String] & LReconciliativeKeyTo1[ScnAllocAndReconcileAndDistillH[ffStaticRcKyForStringImpl.HigherLevelState, ?, ? ] ]
      = ffStaticRcKyForStringImpl.higherLvlReconcKey

      implicit
      final
      lazy val ffStaticRcKyForDateTime
      : FormFieldStatiqueReconciliabilityKey[w3e.pre.StdGsps.DateTime] & LReconciliativeKeyTo1[ScnAllocAndReconcileAndDistillH[ffStaticRcKyForDateTimeImpl.HigherLevelState, ?, ? ] ]
      = ffStaticRcKyForDateTimeImpl.higherLvlReconcKey

      ;

      final
      lazy val ffStaticRcKyForStringImpl
      : allocateSpecial[String]
      = allocateSpecial[String]

      final
      lazy val ffStaticRcKyForDateTimeImpl
      : allocateSpecial[w3e.pre.StdGsps.DateTime]
      = allocateSpecial[w3e.pre.StdGsps.DateTime]

      private[s1]
      class allocateSpecial[Value] private[s1]
            (using GspGoodDefaultValuation[Value ] )
            (using GivenSpinner1[Value ] )
            ()
      {
         ;

         val lowerLvlReconcKey
         = SRNA.allocateGScanLeftAlt(None )((
            summonInpfaForPvF1[Value]
         ) )(e => e )

         val lowerLvlReconciler0
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
         val lowerLvlReconciler
         : lowerLvlReconciler0._2.type
         = lowerLvlReconciler0._2

         opaque type HigherLevelState
         <: Any
         = (
            //

            (
               ln.ReactiveHtmlElement[?] ,
               L.Var[Option[BInputFunc[Value] ] ]
               ,
            )
         )

         given HigherLevelStateLlElement
         : Conversion[HigherLevelState, ln.ReactiveHtmlElement[?] ]
         = _._1

         val higerLevelImplReconciler
         : (
            //
            SpawnabilityAndReconciliabilityNoArg[
               //
               Option[BInputFunc[Value] ] ,
               HigherLevelState ,
               Unit ,
            ]
         )
         = {
            SpawnabilityAndReconciliabilityNoArg.bySpawnabilityAndReconciliabilityFnc[
               //
               Option[BInputFunc[Value] ] ,
               HigherLevelState ,
               Unit ,
            ] (
               //
               spwImpl1 = (initialFrame ) => {
                  val s
                  = lowerLvlReconciler.spawn(None )( )
                  val sg = laminar.api.L.Var[Option[BInputFunc[Value] ] ](initialFrame )
                  sg.signal
                  .map(o => (
                     o
                     .map(desc => {
                        // desc.src
                        for {
                           value <- desc.src.toObservable
                        }
                        yield {
                           InpfaStaticInvar[Value] (value = value, propagate1 = (evtInfo, newValue) => desc.onEditToNewValue(newValue, evtInfo ) )
                        }
                     } : InpfaRefreshInvar[Value] )
                  ) )
                  .flatMap({
                     case None =>
                        L.Val(None)
                     case Some(s) =>
                        for { sV <- s } yield Some(sV)
                  })
                  .foreach(e => {
                     ;

                     // TODO
                     lowerLvlReconciler.model_=(s)(e )

                  })(using com.raquo.airstream.ownership.ManualOwner() ) // TODO
                  (s, sg)
               } ,
               reconcImpl1 = {
                  case ((s, sg), newFrame ) =>
                     sg
                     .set(newFrame )
               } ,
            )
         }

         val higherLvlReconcKey
         : (
            LReconciliativeKeyTo1[(
               //
               LReconciliativeKey.ScnAllocAndReconcileAndDistillH[
                  //

                  HigherLevelState ,
                  Option[BInputFunc[Value] ] ,
                  ln.ReactiveHtmlElement[?] ,
               ]
            )]
         )
         = {
            SRNA.allocateGScanLeftAlt(None )(higerLevelImplReconciler )(_._1 )
            // (???)
         }

         val higherLvlPosReconciler0
         = {
            ;
            higherLvlReconcKey
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

   ;

   ;
}



















