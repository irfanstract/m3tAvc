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
   /* a temporary repetition here (of below) necessary to prevent the compiler from hanging */
   with ELaminarQckCoreHtml
   with w3e.pre.Articles
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

               case class A(hrefOption: Option[java.net.URI] )
               case class B(callbackOption: Option[org.scalajs.dom.Event => Unit ] )

               ;
               m.stateSpecificCallbackAnim1
               .map({
                  case (Some(s) ) =>
                     Some {
                        s match {
                           case (run : Function1[evt$, rv$] ) => B(Some(run) )
                           case (href: java.net.URI ) => A(Some(href) )
                        }
                     }
                  case None =>
                     None
               })
               .scanLeftAdapted0[([T] =>> T )[A | B] ](e => e.getOrElse(A(None) ) )({
                  case (_, Some(v)) =>
                     v
                  case (v0, None ) =>
                     v0 match {
                        case _ : A => A(None)
                        case _ : B => B(None)
                     }
               })
               .map(urlOption => () => {
                  ;
                  import L.{href as _, * }
                  urlOption
                  match {
                     case B(callbackOption) =>
                        button()
                        .amend((
                           callbackOption match {
                              //

                              case Some(run : Function1[evt$, rv$] ) =>
                                 (onClick --> run )
                              case None =>
                                 (disabled := true )
                           }
                        ))
                     case A(urlOption) =>
                        a()
                        .amend((
                           urlOption match {
                              //

                              case Some(href : java.net.URI ) =>
                                 (L.href := href.toASCIIString().nn )
                              case None =>
                                 (disabled := true )
                           }
                        ))
                  }
                  match { case e => {
                     e
                     .amend(child <-- m.stateTitleAnim.map(_.spawn() ).toLaminarObservable )
                     // .amend("non title")
                  } }
                  match { case e => {
                     e
                     .amend((if config.expectInlineHeadline then Seq(L.className := "avfw-inline" ) else Seq() ) : _* )
                  } }
               })
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
      
      s"button.avfw-inline { display: inline ; border: 0 ; padding: 0 ; background: none ; margin: 0.5ex ; text-decoration: underline ; color: #40A000 ; } "
   })
   
} // ebAvfwInlineBtnCssInit$






















