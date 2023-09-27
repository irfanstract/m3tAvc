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

   import laminar.api.L

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
   def allocateDbbaFac
      (config: BfSnaConfig )
   : ((model: Action ) => ButtonArt )
   = {
      ;

      // TODO
      given config.type
      = config

      ;

      ;
      // ???

      val lspw 
      = {
         ;

         import CallbackTypeL.{*, given}
         import abcdCallbackRenderablility1.ftm

         ({
            ;

            abcDbbaFacPreByAnim

            .compose({
               // <:<.refl[(A | B | C, Article ) ]
               // .andThen({ case (a, headline) => (a, ftm, headline ) })
               (acD: Action ) => {
                  acD.animFramesB
                  .map({ case (a, headline) => (a, ftm, headline ) })
               }
            })

            .compose(<:<.refl )
         })
      }

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






















