package avcframewrk.forms

package templating

package w3e.impl.js

package s1















object SEnablednessDefs {
   ;

   trait OfHalfUnitScales
   {

      this : (
         AnyRef
         // & EbAndReconcilability
      ) =>

      ;

      // import SjsEOps.{*, given}

      ;

      extension (e: ({ type Main[E] = E & LaminarBasedNativeElementRef.LlNessAs[E] })#Main[org.scalajs.dom.html.Element ] ) {

         def enabledness_=(vl: 0 | 0.5 | 1 )
         : Unit
         = {
            e.devLaminarWrapperEH
            .amend(enablednessL := vl )
            // e
            // .bindAfw(enablednessL, Some[vl.type](vl) )
         }

         @deprecated
         def enabledD_=(vl: 0 | 0.5 | 1 )
         : Unit
         = {
            enabledness_=(vl)
         }

      }

      object enablednessL {
         import laminar.api.L
         import org.scalajs.dom

         def :=(vl: 0 | 0.5 | 1 )
         : L.Setter[com.raquo.laminar.nodes.ReactiveHtmlElement[dom.html.Element] ]
         = {
            L.Setter[com.raquo.laminar.nodes.ReactiveHtmlElement[dom.html.Element] ]({
               case e => { e.amend(L.disabled := (vl match { case 0 => false ; case 0.5 | 1 => true } ) ) }
            })
         }

      }

   }

}

trait ELaminarQckButtons
extends
   AnyRef
   with ELaminarQckButtonsActionModelling
   /* with these items item merely listed in the self-type, the IDE/editor won't show any relevant "overrides super member" markers */
   with w3e.pre.Buttons
   /* a temporary treat necessary to prevent the compiler from hanging */
   with ELaminarQckButtonsReconc
   // with ELaminarQckCoreHtml
{
   this : (
      AnyRef
      with w3e.pre.Buttons
      with ELaminarQckCoreHtml
      with ELaminarQckButtonsReconc
      with ELaminarQckPlainStringConts
   ) =>
   ;

   import com.raquo.laminar.{nodes as ln}

   import org.scalajs.dom

   ;

   def describeButtonByAction(a: Action)
   : ButtonArt
   = {
      (summon[SpawnabilityAndReconciliabilityNoArg[Action, ?, ?] ] , a )
      match { case r => r : ([NativeE <: dom.HTMLButtonElement ] =>> LaminarSpawnable[ln.ReactiveHtmlElement[NativeE], NativeE ] )[dom.HTMLButtonElement] }
      // ; ???
   }

   override
   opaque
   type ButtonArt
   <: Article
   = (
      LaminarSpawnable[
         ln.ReactiveHtmlElement[? <: dom.HTMLElement] &
         SpawnedButtonL
         ,
         dom.HTMLButtonElement
         ,
      ]
   )

   protected[avcframewrk]
   opaque
   type SpawnedButtonL
   = ln.ReactiveHtmlElement[dom.HTMLButtonElement]

   protected[avcframewrk]
   opaque
   type SpawnedButton
   // >: SpawnedButtonL
   <: SpawnedButtonL
   = SpawnedButtonL

   // given [T1]
   // : Reconciliability[SpawnedButton, ButtonArt, Unit ]
   // with {
   //    extension (this1: SpawnedButton)
   //       def model_=(newM : ButtonArt )
   // }

   ;
} // ELaminarQckButtons

private
trait ELaminarQckButtonsReconc
extends
   AnyRef
   /* a temporary repetition here (of below) necessary to prevent the compiler from hanging */
   with ELaminarQckCoreHtml
{
   this : (
      AnyRef
      with w3e.pre.Articles
      with ELaminarQckCoreHtml
      with ELaminarQckButtonsActionModelling
   ) =>
   ;

   import com.raquo.laminar.{nodes as ln}

   import org.scalajs.dom

   ;

   ;

   // TODO
   private[avcframewrk]
   given [T0]
   : (
      SpawnabilityAndReconciliabilityNoArg[
         Action ,
         ln.ReactiveHtmlElement[org.scalajs.dom.HTMLButtonElement ],
         Unit,
      ]
   )
   = {
      ;

      type SpawnedButton
         >: ln.ReactiveHtmlElement[dom.HTMLButtonElement]
         <: ln.ReactiveHtmlElement[dom.HTMLButtonElement]

      type ButtonContentModel
         >: Action
         <: Action

      // { given_Conversion_LElemPlusPossibleData1_HL_D[SpawnedButtonL, Any ] }
      // { val s = summon[Conversion[LElemPlusPossibleData1[SpawnedButtonL, Any ] , ? ] ] }

      val _ = {}

      val aBackreferencings1
      = summon[aBackreferencings.type ]

      class XEAndStateBag() extends
      aBackreferencings1.XEAndStateBag(ec = { laminar.api.L.button })
      {
         // this : aBackreferencings1.XEAndStateBag[org.scalajs.dom.HTMLButtonElement ] =>
         ;

         import laminar.api.L

         override
         def close(): Unit = {
            ;

            /* a hack, to make the `close()` ing of each sub unconditional */
            closeAllOf((
               Seq()
               :+ labelRendPipe1
               :+ enablednessSetter1
               :+ callbackImplSetter1
            ))

            ;
         }

         /**
          * Laminar doesn't provide native support for re-routings of `Observable`s,
          * so
          * we'll need to leave it to Monix's `switch` or `switchMap`
          * 
          * 
          */
         ;

         // TODO
         val labelRendPipe1
         = {
            ;
            L.child
            .startChildrenListUpdateNow((_: Any, item: Article ) => {
               item
               .spawn()
            })
         }

         val enablednessSetter1
         = {
            L.disabled
            .startAttribNow((v: 0 | 0.5 | 1 ) => {
               v
               match { case v : java.lang.Number => v.doubleValue() }
               match { case v => 0.33 < v }
            } )
         }

         val callbackImplSetter1
         = { L.onClick.startCallbackUpdateNow() }

         def model_=(m: ButtonContentModel )
         : Unit
         = {
            import laminar.api.L

            ;

            labelRendPipe1
            .onNext(m.stateTitleOption )

            enablednessSetter1
            .onNext(m.stateCheckedOption )

            callbackImplSetter1
            .onNext(m.stateSpecificCallbackOption1 )

            // TODO more
         }

         ;

         ;
         
         ;
      }

      SpawnabilityAndReconciliabilityNoArg.bySpawnabilityAndReconciliabilityFnc(
         //
         spwImpl1 = (mdl : ButtonContentModel ) => {
            val c = XEAndStateBag()
            c.model_=(mdl)
            c.wrappedLaminarElement
         }
         ,
         reconcImpl1 = (this1 : SpawnedButton, newModel) => {
            ;
            this1.avfwBackreferent[XEAndStateBag]
            .model_=(newModel )
         }
         ,
      )
   }

} // ELaminarQckButtonsReconc

private
trait ELaminarQckButtonsActionModelling
extends
   AnyRef
   /* with these items item merely listed in the self-type, the IDE/editor won't show any relevant "overrides super member" markers */
   with w3e.pre.Buttons
   /* a temporary treat necessary to prevent the compiler from hanging */
   // with ELaminarQckPlainStringContsReconc
{
   this : (
      AnyRef
      with w3e.pre.Buttons
      with w3e.pre.Articles
      // with ELaminarQckCore
      // with ELaminarQckCoreHtml
      // with ELaminarQckButtonsReconc
      with ELaminarQckPlainStringConts
   ) =>
   ;

   override
   type Action
      >: Edsb[?, Article]
      <: Edsb[?, Article]

   // TODO
   override
   val Action
   : (
      AnyRef
      & AcsfLabelledCallbackTranslator[Action]
   )
   = {
      ;

      new
         AnyRef
         with AcsfLabelledCallbackTranslator[Action]
      {
         ;

         ;

         ;

         export given_AcTitleIndependentCodings1.{*, given}

         export AcsfReadinessIndCodings1.whichTranslatesToHalfs.{*, given}

         export AcCallbackCtxIndependentCodings1.ofOpcev.{*, given}

         export AcReturnIndependentCodings1.whichTranslatesToEitheres.{*, given}

         ;

         override
         def apply
            [
               //
               AcModelState ,
               IsReady : CReadinessCoding ,
               Title : TitleCoding ,
               P : CallbackCtxCoding ,
               R : ReturnCoding ,

            ]
            (
               //
               internalStateOption : avcframewrk.evm.AsyncAlgebraicMonad[AcModelState]
               ,
               isReadyState : AcModelState => IsReady
               ,
               baseTitle: Title
               ,
               updatedTitle: (baseTitle: Title, internalState: AcModelState ) => Title
               ,
            )
            (doTheMainThing: PartialFunction[P, R] )
         = {
            ;

            val elementFromTitle = summon[TitleCoding[Title] ].apply _

            extension (s: AcModelState ) {
               //

               def isReadyStateB() : Boolean
               = {
                  isReadyState(s)
                  match { case bl => summon[CReadinessCoding[IsReady] ].translate(bl) }
                  match { case v : java.lang.Number => 0.33 < v.doubleValue() }
               }

            }

            Edsb[AcModelState, Article ](
               //

               stateOption = internalStateOption
               ,
               // stateCheck = isReadyState.andThen(summon[CReadinessCoding[IsReady ] ].translate _ )
               // ,
               baseTitle = elementFromTitle(baseTitle)
               ,
               stateTitle = {
                  case (baseTitleR, newState) =>
                     elementFromTitle({
                        updatedTitle({
                           // elementAsT(e)
                           baseTitle
                        }, newState)
                     } )
               }
               ,
               stateSpecificCallback =
                  (s: AcModelState ) => {
                     ;

                     val evtInfo = summon[CallbackCtxCoding[P] ].apply()

                     if s.isReadyStateB() then {
                        Some(() => {
                           ;
                           doTheMainThing(evtInfo )
                        } )
                     }
                     else None
                  }
               ,
            )

            //
         }

      }
   } // Action$

   protected[avcframewrk]
   given given_AcTitleIndependentCodings1
   : AcTitleIndependentCodings1
   with {
      ;

      opaque type TitleCoding[-Title ]
         <: (value: Title @annotation.unchecked.uncheckedVariance ) => Article
         =  (value: Title @annotation.unchecked.uncheckedVariance ) => Article

      implicit def stringAcTitling[Title <: String]
      = {
         identity[(value: Title) => Article ](vl => {
            PlainLocaleStringPlainTxtArticle(java.util.Locale.ROOT.nn, vl )
         })
      }

   }

   ;
} // ELaminarQckButtonsActionModelling

// TODO
export edsbs.Edsb

private[avcframewrk]
final
lazy val edsbs
= new AnyRef with Edsbs

private[avcframewrk]
trait Edsbs
{
   ;

   case class Edsb[S, +T]
   (
      //
      stateOption: avcframewrk.evm.AsyncAlgebraicMonad[S]
      ,
      baseTitle: T
      ,
      private val
      stateTitle: (baseTitle: T @annotation.unchecked.uncheckedVariance, state: S ) => T
      ,
      // TODO
      stateSpecificCallback: S => Option[(() => Unit )]
      ,
   )
   {

      def stateSpecificCallbackOption
      = {
         stateOption
         .map(s => stateSpecificCallback(s) )
      }

      def stateCheckedOption
      = {
         stateSpecificCallbackOption
         .map[0 | 1 ]({
            case None => 0
            case Some(_) => 1
         })
      }

      def stateTitleOption
      = {
         stateOption
         .map(s => stateTitle(baseTitle, s) )
      }

      // TODO
      def stateSpecificCallbackOption1
      = {
         stateSpecificCallbackOption
         .map[org.scalajs.dom.Event => Unit ]({
            case Some(cb) =>
               (e) =>
                  cb()
            case None =>
               (_) => { throw new IllegalStateException(s"not available") }
         })
      }

   }

}

type BHA
= (
   //
         //
         org.scalajs.dom.html.Button
         | org.scalajs.dom.html.Button
         | org.scalajs.dom.html.Anchor
         | org.scalajs.dom.html.Input
         | org.scalajs.dom.html.Select
)






















