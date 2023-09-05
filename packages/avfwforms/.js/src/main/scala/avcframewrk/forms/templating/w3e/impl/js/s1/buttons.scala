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

   ebAvfwInlineBtnCssInit

   ;
} // ELaminarQckButtons

private
trait ELaminarQckButtonsReconc
extends
   AnyRef
   /* */
   with ENativeElementsD1
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
      with ENativeElementsD1
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

   ;

   /**
    * 
    * a locally-adjusted itc for scan-left (see `IterableOnceOps`) reconciliation
    * 
    */
   private
   trait XScanLeftReconciliativeOps[ContentModel]
   {
      ;

      val lE
      : ln.ReactiveHtmlElement[dom.HTMLElement]

      def tryUpdateTo
         (m : ContentModel )
      : Either[XScanLeftReconciliativeOps[ContentModel] , Unit]

   }

   ;

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

      ;

      extension [acv1$] (ed: BInputFunc[?]) {
         //

         def valueAnim
         = ed.src.toObservable

         def llc[ExpectedValue1]()
         = {
            ;

            import laminar.api.L

            import L.{given}

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

      object CallbackTypeL {
         ;

         /** `anchor` */
         case class A(hrefOption: Option[java.net.URI] )
         
         /** `button` */
         case class B(callbackOption: Option[org.scalajs.dom.Event => Unit ] )
         
         /** following `A` and `B`, is `C` . `BInputFunc` */
         case class C(edTypeOption: Option[BInputFunc[?] ] ) { export edTypeOption.{get => edType } }

      }

      extension (src : AsyncStateChangeMonad[Option[(org.scalajs.dom.Event => Unit ) | java.net.URI ] ] ) {
         //

         /** 
          * 
          * unlifts the `Signal[Option[Function1 | URI ] ]` into being `Signal[A | B | C ]`
          * 
          */
         def unlifted
         = {
            ;

            import laminar.api.L

            ;

            import CallbackTypeL.{A, B, C }

            src

            .map({
               case (Some(s) ) =>
                  Some {
                     //

                     /** 
                      * NOTE -
                      * there's some overlap between these case(s)
                      * (eg `BInputFunc` `extends` `Function0` as well )
                      * , so
                      * case-ordering is significant here
                      * 
                      */
                     s match {

                        //
                        case (edType : BInputFunc[t1] ) =>
                           C(edTypeOption = Some(edType ) )

                        //
                        case (run : Function1[evt$, rv$] ) =>
                           B(Some(run) )
                        
                        //
                        case (href: java.net.URI ) =>
                           A(Some(href) )

                        //
                     }
                  }
               case None =>
                  None
            })
            .scanLeftAdapted0[([T] =>> T )[A | B | C ] ](e => e.getOrElse(A(None) ) )({
               case (_, Some(v)) =>
                  v
               case (v0, None ) =>
                  v0 match {
                     case _ : A => A(None)
                     case _ : B => B(None)
                     case _ : C => C(None)
                  }
            })
         }

         //
      }

      ;

      object abcdCallbackRenderablility1
      {
         ;

         import laminar.api.L

         ;

         import CallbackTypeL.{A, B, C }

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

         def renderFromScratch(urlOption : A | B | C, title: Article )
         = {
            ;

            ;

            ;
            urlOption
            match {
               case C(edTypeOption ) =>
                  ;
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
                           L.span(L.child <-- L.Val(title.spawn() ) )
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
                  .amend(L.child <-- L.Val(title.spawn() ) )
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
                  .amend(L.child <-- L.Val(title.spawn() ) )
            }
            match { case e => {
               ebAvfwInlineBtnCssInit
               e
               .amend(L.className := (if config.expectInlineHeadline then ("avfw-inline" ) else ("avfw-offtopic") ) )
            } }
         }

         ;
      }

      extension (m: ButtonContentModel ) {
         //

         def renderLaminar()
         = {
            ;

            import laminar.api.L

            ;

            import CallbackTypeL.{A, B, C }

            // TODO
            (m.stateSpecificCallbackAnim1.unlifted combineWith m.stateTitleAnim.toLaminarObservable )
            .map({
               ;

               import abcdCallbackRenderablility1.renderFromScratch

               { case (urlOption, title) => () => renderFromScratch(urlOption = urlOption, title = title ) }
            })
         }

      }

      // { given_Conversion_LElemPlusPossibleData1_HL_D[SpawnedButtonL, Any ] }
      // { val s = summon[Conversion[LElemPlusPossibleData1[SpawnedButtonL, Any ] , ? ] ] }

      val _ = {}

      class XEAndStateBag() extends
      aBackreferencings.XEAndStateBag(ec = { laminar.api.L.span })
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
            .startChildrenListUpdateNow((
               //

               identity[(
                  ([C] =>> ((Option[C], ( ) => C ) => C ) )
                  [ln.ReactiveHtmlElement[dom.HTMLElement] ]
               )]((existingLElemOption, updatedArt ) => {
                  updatedArt
                  .apply( )
               })
            ) , initialDataValue = ( ) => L.span() )
         } // cRendPipe1$

         def model_=(m: ButtonContentModel )
         : Unit
         = {
            import laminar.api.L

            ;

            // labelRendPipe1
            // .onNext(m.stateTitleAnim )

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
   
   org.scalajs.dom.console.log(s"[ebAvfwInlineBtnCssInit]")
   
   avcframewrk.forms.addGlobalCss({
      ;

      (
         //

         Seq()

         :+ s"button, input { padding-block: 0.75ex ; } "

         :+ s"button.avfw-inline, a.avfw-inline, input.avfw-inline { display: inline ; } "

         :+ s"button.avfw-inline, a.avfw-inline, input.avfw-inline { padding-block: 0.7ex ; padding-block-end: 1.5ex ; margin-block: -0.4ex ; } "
         :+ s"button.avfw-inline, input.avfw-inline { margin-block-end: -1ex ; } "

         :+ s"button.avfw-inline { padding-inline: 1ex ; } "

         :+ s"button.avfw-inline { background: transparent ; background: rgba(0, 0, 0, 0.02) ; } "

         :+ s"button.avfw-inline { margin-inline: -1ex ; } "

         // :+ s"button.avfw-inline { font-weight: bolder ; } "

         :+ s"button, a { text-decoration: underline ; } "

         :+ s"button.avfw-inline { text-decoration-style: double ; } "

         :+ s"button.avfw-offtopic { user-select: none !important ; } "
      )
      .mkString("\r\n\r\n")
   })
   
} // ebAvfwInlineBtnCssInit$






















