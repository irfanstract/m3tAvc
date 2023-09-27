package avcframewrk.forms

package templating

package w3e.impl.js

package s1















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
   // with ELaminarQckCoreHtmlArticleDecorsExt
{
   this : (
      AnyRef
      with w3e.pre.Buttons
      with ELaminarQckCoreHtml
      with ELaminarQckButtonsReconc
      with ELaminarQckPlainStringConts
      // with ELaminarQckCoreHtmlArticleDecorsExt
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
      // TODO
      locally[ButtonArt] ({
         ;

         ({ summon[BfSnaConfig] match { case s => ((), s.expectInlineHeadline) } })
         match {
            case ((), true )  => inlineDbbaFac.apply(a )
            case ((), false ) => skippableDbbaFac.apply(a )
         }
      })
   }

   // TODO
   private
   final
   lazy val skippableDbbaFac
   = {
      ;

      allocateDbbaFac(config = BfSnaConfig(expectInlineHeadline = false ) )
   }

   // TODO
   private
   final
   lazy val inlineDbbaFac
   = {
      ;

      allocateDbbaFac(config = BfSnaConfig(expectInlineHeadline = true ) )
   }

   // TODO
   private
   def allocateDbbaFac(config: BfSnaConfig )
   : ((model: Action ) => ButtonArt )
   = {
      ;

      // TODO
      given config.type
      = config
      given_SpawnabilityAndReconciliabilityNoArg_Action_ReactiveHtmlElement_Unit

      val lspw
      = {
         summon[SpawnabilityAndReconciliabilityNoArg[Action, ?, ?] ]
         .withAfterSpawnIntercept((e, _) => e.asInstanceOf[ln.ReactiveHtmlElement[? <: dom.HTMLElement] & SpawnedButtonL ] )
      }

      lazy val defaultNoOpAction
      = URLAction(baseTitle = "")({ case _ => new java.net.URI("javascript", s"void(0)", null ) })

      SRNA.allocateGScanLeft(defaultNoOpAction )(lspw )
      match { case k => laminarSpawnableMdlFactory(k) }
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

      // TODO
      private
      def asHavingDirectActionImpl(action: Action)
      : Article
      = {
         ;

         given BfSnaConfig
         = BfSnaConfig(expectInlineHeadline = true )

         ;
         action
         match { case a : ActionDescImpl[t1, t2] => a }
         match { case a : ActionDescImpl[t1, t2] => a.withGivenConstantTitle(mainLineContents ) }
         match { case a => describeButtonByActionGiven1(a) }

         // mainLineContents
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
   with ELaminarQckButtonsReconcNatives
   with ELaminarQckButtonsReconcAbcdCbRenderability
   with ELaminarQckButtonsReconcCtls
   /* a temporary repetition here (of below) necessary to prevent the compiler from hanging */
   with ELaminarQckCoreHtml
   with w3e.pre.Articles
   with ELaminarQckCoreFailsafeReconcilers
{
   this : (
      AnyRef
      with w3e.pre.Articles
      with ELaminarQckCoreHtml
      with ELaminarQckButtonsActionModelling
      with ELaminarQckButtonsActionModellingTwo
      with ENativeElementsD1
      with ELaminarQckCoreFailsafeReconcilers
   ) =>
   ;

   import com.raquo.laminar.{nodes as ln}

   import org.scalajs.dom

   ;

   ;

   ;

   /**
    * 
    * a locally-adjusted itc for scan-left (see `IterableOnceOps`) reconciliation
    * 
    */
   private
   trait XScanLeftReconciliativeOps1[ContentModel]
   {
      ;

      val lE
      : ln.ReactiveHtmlElement[dom.HTMLElement]

      def tryUpdateTo
         (m : ContentModel )
      : Either[XScanLeftReconciliativeOps1[ContentModel] , Unit]

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

      ;

      // final
      lazy
      val ((), lAbcReconciler)
      = {
         ;

         import laminar.api.L

         ;

         import CallbackTypeL.{A, B, C }

         import abcdCallbackRenderablility1.{*, given }

         ;

         val reconciler
         = {
            llrConv(L.span )((
               //

               (identity[(A | B | C , Article ) ] _ )
               .andThen({
                  case (l, title) =>
                     spawnAndGetOptReconciler(urlOption = l , title = title ) 
               })
            ))
         }

         ((), reconciler )
      }

      extension (m: ButtonContentModel ) {
         //

         def renderLaminar()
         : laminar.api.L.Signal[ln.ReactiveHtmlElement[dom.HTMLElement ] ]
         = {
            ;

            import laminar.api.L

            ;

            import CallbackTypeL.{A, B, C }

            import abcdCallbackRenderablility1.{*, given }

            // TODO
            (m.stateSpecificCallbackAnim1.unlifted combineWith m.stateTitleAnim.toLaminarObservable )

            .map(<:<.refl[(A | B | C, Article ) ] )

            match { case s => {
               ;
               val reconciler
               = {
                  lAbcReconciler
               }

               spawnLlrScanConv(s match { case s => s } )(using reconciler )
            } }

            match { case s => s }
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
            .startChildrenListUpdateNow(((_: Any, item: ln.ReactiveHtmlElement[dom.HTMLElement] ) => {
               ;

               item
            }) , initialDataValue = L.span() )
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

   ;

   ;

   ;

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






















