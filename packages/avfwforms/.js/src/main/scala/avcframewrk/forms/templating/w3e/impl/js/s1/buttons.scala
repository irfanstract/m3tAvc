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
   /* with these items item merely listed in the self-type, the IDE/editor won't show any relevant "overrides super member" markers */
   with w3e.pre.Buttons
{
   this : (
      AnyRef
      with w3e.pre.Buttons
      with ELaminarQckCoreHtml
   ) =>
   ;

   import com.raquo.laminar.{nodes as ln}

   import org.scalajs.dom

   ;

   override
   opaque
   type ButtonArt
   <: LaminarSpawnable[SpawnedButton , dom.HTMLElement ]
   =  LaminarSpawnable[SpawnedButton , dom.HTMLButtonElement ]

   protected[avcframewrk]
   opaque type SpawnedButton
   <: ln.ReactiveHtmlElement[? <: dom.HTMLElement]
   = ln.ReactiveHtmlElement[dom.HTMLButtonElement]

   // given [T1]
   // : SpawnabilityAndReconciliabilityNoArg[ButtonArt, ButtonArtSpawned, Unit ]
   // = {
   //    given SpawnabilityNoArg[ButtonArt, ButtonArtSpawned]
   //    with {
   //       extension (this1 : ButtonArt)
   //    }
   //    ???
   // }

   // given [T1]
   // : Reconciliability[SpawnedButton, ButtonArt, Unit ]
   // with {
   //    extension (this1: SpawnedButton)
   //       def model_=(newM : ButtonArt )
   // }

   private[avcframewrk]
   case class Edsb[S, +T]
   (
      //
      stateOption: avcframewrk.evm.AsyncAlgebraicMonad[S]
      ,
      protected val
      stateCheck: S => (0 | 0.5 | 1)
      ,
      baseTitle: T
      ,
      private val
      stateTitle: (baseTitle: T @annotation.unchecked.uncheckedVariance, state: S ) => T
      ,
   )
   {

      val stateCheckedOption
      = {
         stateOption
         .map[0 | 0.5 | 1 ](stateCheck )
      }

      val stateTitleOption
      = {
         stateOption
         .map(s => stateTitle(baseTitle, s) )
      }

   }

   ;
}

// private[avcframewrk]
// // erased
// val bhATyper
// : (
//    ([T] =>> ([T] =>> { type CAP >: T <: T } )[([A] =>> (A & LaminarBasedNativeElementRef.LlNessAs[A] ) )[T] ] )
//    [(
//       //
//       org.scalajs.dom.html.Button
//       | org.scalajs.dom.html.Button
//       | org.scalajs.dom.html.Anchor
//       | org.scalajs.dom.html.Input
//       | org.scalajs.dom.html.Select
//    )]
// )
// = ([A] => () => new AnyRef().asInstanceOf[A] ).apply()

// private[avcframewrk]
// type BHA
// = bhATyper.CAP

// trait EbButtons
// extends
// AnyRef
// with SEnablednessDefs.OfHalfUnitScales
// {
//    this : (
//       AnyRef
//       & EbAndReconcilability
//       & SEnablednessDefs.OfHalfUnitScales
//    ) =>
//    //

//    //

//    ;

//    ;

//    private[avcframewrk]
//    def newClickEvent()
//    : AnyRef & Product
//    = {

//       case object clickEvent extends
//          AnyRef
//       clickEvent
//    }

//    //

//    private[avcframewrk]
//    // erased
//    val bhATyper
//    : (
//       ([T] =>> ([T] =>> { type CAP >: T <: T } )[([A] =>> (A & LaminarBasedNativeElementRef.LlNessAs[A] ) )[T] ] )
//       [(
//          //
//          org.scalajs.dom.html.Button
//          | org.scalajs.dom.html.Button
//          | org.scalajs.dom.html.Anchor
//          | org.scalajs.dom.html.Input
//          | org.scalajs.dom.html.Select
//       )]
//    )
//    = ([A] => () => new AnyRef().asInstanceOf[A] ).apply()

//    private[avcframewrk]
//    type BHA
//    = bhATyper.CAP

//    given given_AcsfLabelledCallbackTranslator_Edsb[SjsEOps]
//    : AcsfLabelledCallbackTranslator[ButtonOrAHrefDesc1[?, SjsEOps ] ]
//    with {
//       ;

//       // TODO
//       opaque type TitleCoding[-Title ]
//          <: (value: Title @annotation.unchecked.uncheckedVariance ) => (value.type & String )
//          =  (value: Title @annotation.unchecked.uncheckedVariance ) => (value.type & String )

//       implicit def stringAcTitling[Title <: String]
//       = identity[(value: Title) => (value.type & String ) ](vl => vl )

//       export AcsfReadinessIndCodings1.whichTranslatesToHalfs.{*, given}

//       export AcCallbackCtxIndependentCodings1.ofOpcev.{*, given}

//       export AcReturnIndependentCodings1.whichTranslatesToEitheres.{*, given}

//       override
//       def apply
//          [
//             //
//             AcModelState ,
//             IsReady : CReadinessCoding ,
//             Title : TitleCoding ,
//             P : CallbackCtxCoding ,
//             R : ReturnCoding ,

//          ]
//          (
//             //
//             internalStateOption : avcframewrk.evm.AsyncAlgebraicMonad[AcModelState]
//             ,
//             isReadyState : AcModelState => IsReady
//             ,
//             baseTitle: Title
//             ,
//             updatedTitle: (baseTitle: Title, internalState: AcModelState ) => Title
//             ,
//          )
//          (doTheMainThing: PartialFunction[P, R] )
//          = {
//             def elementFromString(v: String): SjsEOps = ???
//             val elementFromTitle = {
//                (summon[TitleCoding[Title] ].apply _ ) andThen (elementFromString _ )
//             }
//             def elementAsT(v: SjsEOps): Title = ???
//             // TODO
//             ButtonOrAHrefDesc1[AcModelState, SjsEOps ](
//                //
//                edsb = 
//                Edsb[AcModelState, SjsEOps ](
//                   stateOption = internalStateOption ,
//                   stateCheck = isReadyState.andThen(summon[CReadinessCoding[IsReady ] ].translate _ ) ,
//                   baseTitle = elementFromTitle(baseTitle) ,
//                   stateTitle = { case (e, newState) => elementFromTitle(updatedTitle(elementAsT(e), newState) ) } ,
//                )
//                ,
//                callback = 
//                   // TODO
//                   (outerEvt : AnyRef & Product ) => util.Try({ val evtInfo = summon[CallbackCtxCoding[P] ].apply() : P ; doTheMainThing(evtInfo) })
//                ,
//             )
//          }

//    }

//    private[avcframewrk]
//    case class Edsb[S, +T]
//    (
//       //
//       stateOption: avcframewrk.evm.AsyncAlgebraicMonad[S]
//       ,
//       protected val
//       stateCheck: S => (0 | 0.5 | 1)
//       ,
//       baseTitle: T
//       ,
//       private val
//       stateTitle: (baseTitle: T @annotation.unchecked.uncheckedVariance, state: S ) => T
//       ,
//    )
//    {

//       val stateCheckedOption
//       = {
//          stateOption
//          .map[0 | 0.5 | 1 ](stateCheck )
//       }

//       val stateTitleOption
//       = {
//          stateOption
//          .map(s => stateTitle(baseTitle, s) )
//       }

//    }

//    case class ButtonOrAHrefDesc1[S, +T](
//       edsb: Edsb[S, T] ,
//       callback: (evt: AnyRef & Product) => util.Try[Unit] ,
//    )
//    extends
//    AnyRef
//    {
//       //

//       val headlineDescr
//       = edsb.baseTitle

//    }


//    class ReroutiblePipe1[S]() {

//       val (ss, outputStream) = {
//          avcframewrk.evm.AsyncAlgebraicItemStream.newReroutiblePipe[S]()
//       }

//       export ss.{onNext => setInputStream }
//       export ss.{onComplete => closePipe }

//       def setStaticValue(value: S)
//       = setInputStream(monix.reactive.Observable(value) )
      
//    }

//    trait TElemOps
//       extends
//       AnyRef
//       with TElemOps.WithDlw[com.raquo.laminar.nodes.ReactiveElement[?] ]
//       with java.io.Closeable
//    {
//       //

//       override
//       def close(): Unit = {
//       }

//    }

//    object  TElemOps {
//       ;

//       trait WithDlw[+R] { val dlw : R }

//       type WhichReturns[+R]
//       = TElemOps & WithDlw[R]

//       given [R](using DummyImplicit)
//       : DevLaminarNodeRetrievability[TElemOps.WhichReturns[R], ?]
//       with {
//          extension (receiver: TElemOps.WhichReturns[R])
//             // transparent inline
//             def devLaminarNode = receiver.dlw
//       }

//    } // TElemOps$

//    // trait

//    // given given_SpawnabilityAndReconciliabilityNoArg_Edsb_Unit[TElem , State]
//    //    (using titleElemSpawnability : SpawnabilityAndReconciliabilityNoArg[TElem, TElemOps.WhichReturns[com.raquo.laminar.nodes.ReactiveHtmlElement[org.scalajs.dom.HTMLElement ] ], Unit ] )
//    // : SpawnabilityAndReconciliabilityNoArg[Edsb[State, TElem], ?, Unit]
//    // = {
//    //    ;
//    //    class Lx()
//    //    extends
//    //    AnyRef
//    //    with TElemOps
//    //    with java.io.Closeable
//    //    {

//    //       val statePipe = new ReroutiblePipe1[State]
//    //       val titleValueUpdatePipe = new ReroutiblePipe1[TElem]
//    //       val enablednessUpdatePipe = new ReroutiblePipe1[Boolean]

//    //       private[Lx]
//    //       val e = {
//    //          import laminar.api.L.*
//    //          button(
//    //             //
//    //             // TODO
//    //             child <-- {
//    //                titleValueUpdatePipe.outputStream
//    //                .scan[Option[TElemOps] ](None )({
//    //                   case (Some(e0), e) =>
//    //                      e0
//    //                      Some()
//    //                   case (_, e) =>
//    //                      val eSpawned = e.spawn()
//    //                      Some(eSpawned )
//    //                })
//    //                .toLaminarEventStream()
//    //             }
//    //             ,
//    //          )
//    //       }

//    //       val dlw = e

//    //       def implModelSwitch(newModel: Edsb[State, TElem] )
//    //       : Unit
//    //       = {
//    //          ;
//    //          ({ import laminar.api.L.* ; e.amend(newModel.baseTitle.asInstanceOf[String] ) }) // TODO
//    //          titleValueUpdatePipe.setInputStream(newModel.stateTitleOption )
//    //          statePipe.setInputStream(newModel.stateOption )
//    //          enablednessUpdatePipe.setInputStream(newModel.stateCheckedOption.map({ case v : java.lang.Number => (0.33 < v.doubleValue() ) }) )
//    //       }

//    //       override
//    //       def close(): Unit = {
//    //          util.Try[Unit]({
//    //             statePipe.closePipe()
//    //          })
//    //          .recover(_.printStackTrace() )
//    //       }

//    //       ;
//    //       // TODO
//    //    } // Lx
//    //    new AnyRef with SpawnabilityAndReconciliabilityNoArg[Edsb[State, TElem], Lx, Unit]
//    //    {
//    //       ;
         
//    //       extension (this1: Edsb[State, TElem] )
//    //          def spawn()
//    //          = {
//    //             val e = new Lx
//    //             e.model_=(this1)
//    //             e
//    //          }

//    //       extension (this1: Lx )
//    //          def model_=(newModel: Edsb[State, TElem] )
//    //          = this1.implModelSwitch(newModel = newModel )
         
//    //    }
//    // } // given_SpawnabilityAndReconciliabilityNoArg_Edsb__Unit

// }

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






















