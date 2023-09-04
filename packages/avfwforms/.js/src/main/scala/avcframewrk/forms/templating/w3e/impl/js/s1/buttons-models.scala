package avcframewrk.forms

package templating

package w3e.impl.js

package s1






















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

               stateAnim = internalStateOption
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

               stateAnim = internalStateOption
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
      stateAnim: AsyncStateChangeMonad[S]
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

      def stateSpecificCallbackAnim
      = {
         stateAnim
         .map(s => stateSpecificCallback(s) )
      }

      def stateCheckedAnim
      = {
         stateSpecificCallbackAnim
         .map[0 | 1 ]({
            case None => 0
            case Some(_) => 1
         })
      }

      def stateTitleAnim
      = {
         stateAnim
         .map(s => stateTitle(baseTitle, s) )
      }

      // TODO
      def stateSpecificCallbackAnim1
      = {
         stateSpecificCallbackAnim
         .map[Option[((editStartReq: org.scalajs.dom.Event) => Unit ) | java.net.URI ] ]({
            //

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



















val _ = {}
