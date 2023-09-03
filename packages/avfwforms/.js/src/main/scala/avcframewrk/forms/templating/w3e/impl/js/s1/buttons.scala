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
   with ELaminarQckButtonsActionModellingTwo
   /* with these items item merely listed in the self-type, the IDE/editor won't show any relevant "overrides super member" markers */
   with w3e.pre.Buttons
   with w3e.pre.VarEditingActionsProv
   /* a temporary treat necessary to prevent the compiler from hanging */
   with ELaminarQckButtonsReconc
   // with ELaminarQckCoreHtml
   with ELaminarQckCoreHtmlArticleDecorsExt
{
   this : (
      AnyRef
      with w3e.pre.Buttons
      with ELaminarQckCoreHtml
      with ELaminarQckButtonsReconc
      with ELaminarQckPlainStringConts
      with ELaminarQckCoreHtmlArticleDecorsExt
   ) =>
   ;

   import com.raquo.laminar.{nodes as ln}

   import org.scalajs.dom

   ;

   extension (mainLineContents: Article) {

      override
      def asHavingDirectAction(action: Action)
      : Article
      = asHavingDirectActionImpl(mainLineContents )(action )

   } // (mainLineContents: Article) asHavingDirectAction(action: Action)

   def describeButtonByAction(a: Action)
   : ButtonArt
   = {
      given BfSnaConfig
      = BfSnaConfig(expectInlineHeadline = false )
      describeButtonByActionGiven1(a)
   }

   private[avcframewrk]
   def describeButtonByActionGiven1
      (a: Action)
      (using BfSnaConfig )
   : ButtonArt
   = {
      (summon[SpawnabilityAndReconciliabilityNoArg[Action, ?, ?] ] , a )
      match { case r => r : ([NativeE <: dom.HTMLElement ] =>> LaminarSpawnable[ln.ReactiveHtmlElement[NativeE], NativeE ] )[dom.HTMLElement] }
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
         dom.HTMLElement
         ,
      ]
   )

   protected[avcframewrk]
   opaque
   type SpawnedButtonL
   = ln.ReactiveHtmlElement[dom.HTMLElement]

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

   extension (mainLineContents: Article) {

      private
      def asHavingDirectActionImpl(action: Action)
      : Article
      = {
         ;

         given BfSnaConfig
         = BfSnaConfig(expectInlineHeadline = true )

         ;
         action
         match { case a : Edsb[t1, t2] => a }
         match { case a : Edsb[t1, t2] => {
            a
            .copy[t1, Article](stateTitle = (_, _) => mainLineContents )
            .copy(baseTitle = mainLineContents )
         } }
         match { case a => describeButtonByActionGiven1(a) }
      }

   } // (mainLineContents: Article) asHavingDirectActionImpl(action: Action)

   ;
} // ELaminarQckButtons

private
trait ELaminarQckButtonsReconc
extends
   AnyRef
   /* a temporary repetition here (of below) necessary to prevent the compiler from hanging */
   with ELaminarQckCoreHtml
   with w3e.pre.Articles
{
   this : (
      AnyRef
      with w3e.pre.Articles
      with ELaminarQckCoreHtml
      with ELaminarQckButtonsActionModelling
      with ELaminarQckButtonsActionModellingTwo
   ) =>
   ;

   import com.raquo.laminar.{nodes as ln}

   import org.scalajs.dom

   ;

   ;

   private[avcframewrk]
   case class BfSnaConfig(
      //
      expectInlineHeadline : Boolean
      ,
   )

   // TODO
   private[avcframewrk]
   given [T0]
      (using config : BfSnaConfig)
   : (
      SpawnabilityAndReconciliabilityNoArg[
         Action ,
         ln.ReactiveHtmlElement[org.scalajs.dom.HTMLElement ],
         Unit,
      ]
   )
   = {
      ;

      type SpawnedButton
         >: ln.ReactiveHtmlElement[dom.HTMLElement]
         <: ln.ReactiveHtmlElement[dom.HTMLElement]

      type ButtonContentModel
         >: Action
         <: Action

      object CallbackTypeL {
         ;

         case class A(hrefOption: Option[java.net.URI] )
         case class B(callbackOption: Option[org.scalajs.dom.Event => Unit ] )
         case class C(edTypeOption: Option[BInputFunc[?] ] ) { export edTypeOption.{get => edType } }

      }

      extension (m: ButtonContentModel ) {
         //

         def renderLaminar()
         = {
            ;

            import laminar.api.L

            ;

            import CallbackTypeL.*

            // TODO
            m.stateSpecificCallbackOption1
            .map({
               case (Some(s) ) =>
                  Some {
                     s match {
                        case (edType : BInputFunc[t1] ) =>
                           C(edTypeOption = Some(edType ) )
                        case (run : Function1[evt$, rv$] ) =>
                           B(Some(run) )
                        case (href: java.net.URI ) =>
                           A(Some(href) )
                     }
                  }
               case None =>
                  None
            })
            .scanLeft[([T] =>> T )[A | B | C ] ](e => e.getOrElse(A(None) ) )({
               case (_, Some(v)) =>
                  v
               case (v0, None ) =>
                  v0 match {
                     case _ : A => A(None)
                     case _ : B => B(None)
                     case _ : C => C(None)
                  }
            })
            .map(urlOption => () => {
               ;

               ;
               import L.{
                  href as _,
                  input as _,
                  a as _ ,
                  button ,
                  disabled ,
                  // * ,
                  given ,
               }

               ;
               urlOption
               match {
                  case C(edTypeOption ) =>
                     ;
                     extension [acv1$] (ed: BInputFunc[?]) {
                        //

                        def valueAnim
                        = ed.src.toObservable

                        def llc[ExpectedValue1]()
                        = {
                           ;

                           L.controlled(
                              //
                              L.value <-- ed.valueAnim.map(_.toString() )
                              ,
                              (
                                 L.onInput
                                 .mapToValue
                                 // .map(v => {
                                 //    org.scalajs.dom.console.log("inputed value raw: ", v )
                                 //    v
                                 // } )
                                 .map(ed.t.parse.lift ).collect({ case Some(v) => v })
                                 .map(v => {
                                    if v.isInstanceOf[Boolean] then {
                                       org.scalajs.dom.console.log("inputed value parsed: ", v )
                                    }
                                    v
                                 } )
                                 -->
                                 (ed.src.toObserver.onNext _ )
                              ) ,
                           ) 
                        }

                        //
                     }
                     edTypeOption
                     .map(e => (e, e.t, true ) )
                     match {

                        case Some(ed: BInputFunc[acv1$], edType : given_GivenSpinner_Boolean.type, enabled ) =>
                           L.input( L.typ := "checkbox" )
                           .amend(disabled := !enabled  )
                           // .amend(L.value <-- ed.valueAnim.map(_.toString() ) )
                           .amend(
                              //
                              L.checked <-- ed.valueAnim.map(_.asInstanceOf[Boolean ] ) 
                              ,
                              L.onChange.mapToChecked.map(_.asInstanceOf[acv1$] ) --> (ed.src.toObserver.onNext _ )
                              ,
                           )

                        case Some(ed: BInputFunc[acv1$], edType : w3e.pre.StdGsps.ofSnb.given_GivenSpinner_DateTime.type , enabled ) =>
                           L.input( L.typ := "date" )
                           .amend(disabled := !enabled  )
                           .amend((
                              ed.llc()
                           ))

                        case Some(ed: BInputFunc[acv1$], edType : w3e.pre.StdGsps.ofSnb.given_GivenSpinner_Number[?] , enabled ) =>
                           L.input( L.typ := "number" )
                           .amend(disabled := !enabled  )
                           .amend((
                              ed.llc()
                           ))

                        case Some(ed: BInputFunc[acv1$], edType : given_GivenSpinner_String.type, enabled ) =>
                           L.input( )
                           .amend(disabled := !enabled  )
                           .amend((
                              ed.llc()
                           ))

                        case _ =>
                           L.input(disabled := true )
                     }
                     match {
                        case e =>

                           L.label(e, (
                              L.span(L.child <-- m.stateTitleOption.map(_.spawn() ) )
                              .amend(":" )
                              .amend((
                                 L.span()
                                 .amend(L.styleAttr := (
                                    ""
                                    + s"display: inline-block ; position: relative ; inline-size: 11em ; vertical-align: text-top ;"
                                    + s"background: rgba(255, 255, 0, 0.15 ) ; "
                                 ) )
                                 .amend(edTypeOption.fold(Seq() )(e => Seq[com.raquo.laminar.modifiers.Inserter.Base ](L.span(L.child <-- e.src.toObservable.map(_.toString() ) ) ) ) : _* )
                              ))
                           ) )
                     }
                  case B(callbackOption) =>
                     button() /* never, never use `<a>` for call-back buttons */
                     .amend(L.typ := "button" ) /* necessary, as `<form>`s set the default to `submit` */
                     .amend((
                        callbackOption match {
                           //

                           case Some(run : Function1[evt$, rv$] ) =>
                              (L.onClick --> run )
                           case None =>
                              (disabled := true )
                        }
                     ))
                     .amend(L.child <-- m.stateTitleOption.map(_.spawn() ) )
                  case A(urlOption) =>
                     L.a()
                     .amend((
                        urlOption match {
                           //

                           case Some(href : java.net.URI ) =>
                              (L.href := href.toASCIIString().nn )
                           case None =>
                              (disabled := true )
                        }
                     ))
                     .amend(L.child <-- m.stateTitleOption.map(_.spawn() ) )
               }
               match { case e => {
                  ebAvfwInlineBtnCssInit
                  e
                  .amend((if config.expectInlineHeadline then Seq(L.className := "avfw-inline" ) else Seq() ) : _* )
               } }
            })
         }

      }

      // { given_Conversion_LElemPlusPossibleData1_HL_D[SpawnedButtonL, Any ] }
      // { val s = summon[Conversion[LElemPlusPossibleData1[SpawnedButtonL, Any ] , ? ] ] }

      val _ = {}

      val aBackreferencings1
      = summon[aBackreferencings.type ]

      class XEAndStateBag() extends
      aBackreferencings1.XEAndStateBag(ec = { laminar.api.L.span })
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
               :+ cRendPipe1
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
         val cRendPipe1
         = {
            ;
            L.child
            .startChildrenListUpdateNow(((_: Any, item: () => ln.ReactiveHtmlElement[dom.HTMLElement] ) => {
               item
               .apply()
            }) , initialDataValue = () => L.span() )
         } // cRendPipe1$

         def model_=(m: ButtonContentModel )
         : Unit
         = {
            import laminar.api.L

            ;

            // labelRendPipe1
            // .onNext(m.stateTitleOption )

            cRendPipe1
            .onNext({
               ;

               m
               .renderLaminar()
            })

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

   /* a mixin which overrides these methods */
   private[ELaminarQckButtonsActionModelling]
   sealed
   trait CallbackOrUrlActionFactoryCommonGivens
   extends
   AnyRef
   with AcsfTitleIndependentCodings1
   with AcsfReadinessIndCodings1
   with AcsfDispatchTimeCtxIndependentCodings1
   with AcsfReturnIndependentCodings1
   {

      ;

      export given_AcTitleIndependentCodings1.{*, given}

      export AcsfReadinessIndCodings1.whichTranslatesToHalfs.{*, given}

      export AcCallbackCtxIndependentCodings1.ofOpcev.{*, given}

      export AcReturnIndependentCodings1.whichTranslatesToEitheres.{*, given}

      protected
      def elementFromTitle
         [Title : TitleCoding]
         (title: Title)
      = {
         ;

         summon[TitleCoding[Title] ]
         .apply(title )
      }

   }

   // TODO
   override
   val URLAction
   : (
      AnyRef
      & AcsfLabelledUrlTranslator[Action]
   )
   = {
      ;

      new
         AnyRef
         with AcsfLabelledUrlTranslator[Action]
         with CallbackOrUrlActionFactoryCommonGivens
      {
         ;

         override
         def apply
            [
               //
               AcModelState ,
               Title : TitleCoding ,
               R <: java.net.URI ,

            ]
            (
               //
               internalStateOption : AsyncStateChangeMonad[AcModelState]
               ,
               baseTitle: Title
               ,
               updatedTitle: AcsfBaseTitleAndInternalStateCallback[Title, AcModelState, Title ]
               ,
            )
            (byS: PartialFunction[AcModelState, R] )
         = {

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

                     byS.lift
                     .apply(s )
                  }
               ,
            )
         }

         ;
      }
   }

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
         with CallbackOrUrlActionFactoryCommonGivens
      {
         ;

         ;

         ;

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
               internalStateOption : AsyncStateChangeMonad[AcModelState]
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

private
trait ELaminarQckButtonsActionModellingTwo
extends
   AnyRef
   /* with these items item merely listed in the self-type, the IDE/editor won't show any relevant "overrides super member" markers */
   with w3e.pre.VarEditingActionsProv
   /* a temporary repetition here (of below) necessary to prevent the compiler from hanging */
   // with ELaminarQckCoreHtml
{
   sgvs : (
      AnyRef
      with w3e.pre.Articles
      with w3e.pre.Buttons
      with w3e.pre.PlainTxtContents
      // with ELaminarQckCoreHtml
      with ELaminarQckButtonsActionModelling
   ) =>
   ;

   import com.raquo.laminar.{nodes as ln}

   import org.scalajs.dom

   ;

   ;

   ;

   export w3e.pre.StdGsps.ofSnb.{*, given}

   ;

   val VarEditingAction
   : (
      AnyRef
      & (
         [Value] =>
         (baseTitle: String | Article ) =>
         (operand: ({ val L : laminar.api.L.type ; type LSS = L.SignalSource[Value] & L.Sink[Value] })#LSS ) =>
         (GivenSpinner[Value] ) ?=>
            Action
      )
   )
   = {
      ;

      (

         [Value] =>
         (baseTitle: String | Article ) =>
         (operand: ({ val L : laminar.api.L.type ; type LSS = L.SignalSource[Value] & L.Sink[Value] })#LSS ) =>
         (spn: GivenSpinner[Value] ) ?=>
         {
            ;

            val headline
            = {
               ;

               baseTitle
               match {
                  case baseTitle : String =>
                     PlainLocaleStringPlainTxtArticle(java.util.Locale.ROOT.nn , baseTitle )
                  case baseTitle : Article =>
                     baseTitle
               }
               match { case e => e : Article }
            }

            val a = {
               BInputFunc[Value](
                  //
                  onShallEditStart = { case _ => ??? } ,
                  src = operand ,
                  t = spn ,
               )
            }

            Edsb(
               stateOption = laminar.api.L.Val(() ) ,
               baseTitle = headline ,
               stateTitle = { case _ => headline } ,
               stateSpecificCallback = { case _ => Some(a) } ,
            )
         }
      )
   }

   ;

   private[w3e]
   case class BInputFunc
      [Value]
      (
         //
         onShallEditStart : (
            (lastValue: Value, host: BInputFunc[Value] ) =>
               Unit
         )
         ,
         src : (
            ([V] =>> (laminar.api.L.SignalSource[V] ) )[Value]
            & laminar.api.L.Sink[Value]
         )
         ,
         t : sgvs.GivenSpinner1[Value]
         ,
      )
   extends
      AnyRef
      with (() => Unit )
      with ((org.scalajs.dom.Event) => Unit )
   {
      ;

      def valueAnim
      = src.toObservable

      ;

      def apply(clickEvt: org.scalajs.dom.Event )
      = apply()

      def apply(): Unit
      = {
         ;

         onShallEditStart
         .apply(
            //
            src.toObservable
            match { case s : laminar.api.L.StrictSignal[t] => (s.now() : t ).asInstanceOf[Value] }
            match { case s => s }
            ,
            BInputFunc.this
            ,
         )
      }

      ;
   }

   ;
} // ELaminarQckButtonsActionModellingTwo

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
      stateOption: AsyncStateChangeMonad[S]
      ,
      baseTitle: T
      ,
      private val
      stateTitle: (baseTitle: T @annotation.unchecked.uncheckedVariance, state: S ) => T
      ,
      // TODO
      stateSpecificCallback: S => Option[(() => Unit ) | java.net.URI ]
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
         .map[Option[((editStartReq: org.scalajs.dom.Event) => Unit ) | java.net.URI ] ]({
            //

            case Some(cb : ELaminarQckButtonsActionModellingTwo#BInputFunc[v]) =>
               Some(cb)

            case Some(cb : Function0[t1]) =>
               Some({
                  cb
                  match {
                     case _ =>
                        (e: org.scalajs.dom.Event ) => cb()
                  }
               })

            case Some(cb : (java.net.URI )) =>
               Some(cb)

            case None =>
               None

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

given ebAvfwInlineBtnCssInit
: AnyRef
with {
   ;

   ;

   org.scalajs.dom.console.log(s"[ebAvfwInlineBtnCssInit]")

   avcframewrk.forms.addGlobalCss({
      ;

      s"button.avfw-inline { display: inline ; border: 0 ; padding: 0 ; background: none ; margin: 0.5ex ; text-decoration: underline ; color: #40A000 ; } "
   })

}






















