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
   /* a temporary treat necessary to prevent the compiler from hanging */
   with ELaminarQckCoreHtml
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

   // TODO
   export edsbs.Edsb

   // TODO
   private[avcframewrk]
   def given_SpawnabilityAndReconciliabilityNoArg_ButtonArt_SpawnedButton_Unit [T1]
   : SpawnabilityAndReconciliabilityNoArg[Edsb[?, Article ] , SpawnedButton, Unit ]
   = {
      ;

      type SpawnedButton
         >: ln.ReactiveHtmlElement[dom.HTMLButtonElement]
         <: ln.ReactiveHtmlElement[dom.HTMLButtonElement]

      type ButtonContentModel
         >: Edsb[?, Article ]
         <: Edsb[?, Article ]

      // { given_Conversion_LElemPlusPossibleData1_HL_D[SpawnedButtonL, Any ] }
      // { val s = summon[Conversion[LElemPlusPossibleData1[SpawnedButtonL, Any ] , ? ] ] }

      val _ = {}

      val aBackreferencings1
      = summon[aBackreferencings.type ]

      trait XEAndStateBag1
      {
         this : aBackreferencings1.XEAndStateBag[org.scalajs.dom.HTMLButtonElement ] =>
         ;

         import laminar.api.L

         override
         def close(): Unit = {
            ;

            /* a hack, to make the `close()` ing of each sub unconditional */
            closeAllOf(Seq() :+ labelRendPipe1 :+ enablednessSetter1 :+ callbackImplSetter1 )
         }

         /**
          * Laminar doesn't provide native support for re-routings of `Observable`s,
          * so
          * we'll need to leave it to Monix's `switch` or `switchMap`
          * 
          * 
          */
         ;

         // summon[Article <:< SpiwmTwos[Any, Any, Any] ]

         val labelRendPipe1
         = {
            ;
            L.child
            .startChildrenListUpdateNow((_: Any, item: Any ) => {
               ???
            })
         }

         // val labelRendPipe
         // = { ??? }

         // ; ???

         val enablednessSetter1
         = { L.disabled.startAttribNow((v: 0 | 0.5 | 1 ) => (v match { case v : java.lang.Number => (0.33 < v.doubleValue() ) } ) ) }

         // ; ???

         val callbackImplSetter1
         = { L.onClick.startCallbackUpdateNow() }

         // ; ???

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
         
      }
      class XEAndStateBag() extends
      aBackreferencings1.XEAndStateBag(ec = { laminar.api.L.button })
      with XEAndStateBag1
      {
         ;

         ;
      }
      
      val reconcImpl = {
         new Reconciliability[SpawnedButton, ButtonContentModel, Unit]
         {
            extension (this1: SpawnedButton)
               def model_=(newModel: ButtonContentModel )
               = {
                  this1.avfwBackreferent[XEAndStateBag]
                  .model_=(newModel )
               }
         }
      } // reconcImpl$

      val spwImpl = {
         new SpawnabilityNoArg[ButtonContentModel, SpawnedButton ]
         {
            extension (this1: ButtonContentModel)
               def spawn()
               = {
                  val c = XEAndStateBag()
                  reconcImpl.model_=(c.wrappedLaminarElement )(this1 )
                  c.wrappedLaminarElement
               }
         }
      } // spwImpl$

      new AnyRef with SpawnabilityAndReconciliabilityNoArg[ButtonContentModel, SpawnedButton, Unit ]
      {
         export reconcImpl.model_=
         export spwImpl.spawn
      }
   }

   // given [T1]
   // : Reconciliability[SpawnedButton, ButtonArt, Unit ]
   // with {
   //    extension (this1: SpawnedButton)
   //       def model_=(newM : ButtonArt )
   // }

   ;
}

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






















