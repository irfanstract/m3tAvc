package avcframewrk.forms

package templating

package w3e.impl.js

package s1






















private
trait ELaminarQckButtonsActionModelling
extends
   AnyRef
   with EActionDescImpls
   /* with these items item merely listed in the self-type, the IDE/editor won't show any relevant "overrides super member" markers */
   with w3e.pre.Buttons
   /* a temporary treat necessary to prevent the compiler from hanging */
   // with ELaminarQckPlainStringContsReconc
{
   this : (
      AnyRef
      with ELaminarQckButtonsActionModellingTwo
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
      >: ActionDescImpl[?, Article]
      <: ActionDescImpl[?, Article]

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

            ActionDescImpl[AcModelState, Article ](
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

            ActionDescImpl[AcModelState, Article ](
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
   : w3e.pre.given_AcTitleIndependentCodings1[this.type]
   = w3e.pre.given_AcTitleIndependentCodings1(this)

   extension [t1, t2] (a: ActionDescImpl[t1, t2] ) {
      //

      def withGivenConstantTitle(mainLineContents: Article )
      = {
         ;
         a
         .copy(stateTitle = identity[(Any, Any) => mainLineContents.type ]((_, _) => mainLineContents ) )
         .copy(baseTitle = mainLineContents )
      }

      //
   }

   ;
} // ELaminarQckButtonsActionModelling

private[avcframewrk]
trait EActionDescImpls
extends
   AnyRef
   with EdGlobalEventInfoItcUni
{
   this : (
      AnyRef
      & ELaminarQckButtonsActionModellingTwo
   ) =>
   ;

   ;

   case class ActionDescImpl[S, +T]
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

      def stateTitleAnim
      = {
         stateAnim
         .map(s => stateTitle(baseTitle, s) )
      }

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

   }

}

private[avcframewrk]
trait ELaminarQckButtonsActionModellingTwo
extends
   AnyRef
   with EActionDescImpls
   with ELaminarQckButtonsActionModelling
   with EdGlobalEventInfoItcUni
   /* with these items item merely listed in the self-type, the IDE/editor won't show any relevant "overrides super member" markers */
   with w3e.pre.VarEditingActionsProv
   /* a temporary repetition here (of below) necessary to prevent the compiler from hanging */
   // with ELaminarQckCoreHtml
{
   sgvs : (
      AnyRef
      with ELaminarQckButtonsActionModelling
      with w3e.pre.Articles
      with w3e.pre.Buttons
      with w3e.pre.PlainTxtContents
      // with ELaminarQckCoreHtml
      with ELaminarQckPlainStringConts
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

            ActionDescImpl(
               stateAnim = laminar.api.L.Val(() ) ,
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
      with ((EdsbEventInfo) => Unit )
   {
      ;

      def valueAnim
      = src.toObservable

      ;

      def apply(clickEvt: EdsbEventInfo )
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

   implicit class ActionDescImplSsca1 [S, T] (val this1: ActionDescImpl[S, T] )
   {
      ;

      import this1.*

      ;


      // TODO
      def stateSpecificCallbackAnim1
      = {
         stateSpecificCallbackAnim
         .map[Option[((editStartReq: EdsbEventInfo ) => Unit ) | java.net.URI ] ]({
            //

            case Some(cb : BInputFunc[v]) =>
               Some(cb)

            case Some(cb : Function0[t1]) =>
               Some({
                  cb
                  match {
                     case _ =>
                        (e: EdsbEventInfo ) => cb()
                  }
               })

            case Some(cb : (java.net.URI )) =>
               Some(cb)

            case None =>
               None

         })
      }

      //
   } // ActionDescImplSsca1

   ;
} // ELaminarQckButtonsActionModellingTwo

private[avcframewrk]
trait EdGlobalEventInfoItcUni
{
   ;

   ;

   /**
    * would have pointed to W3's `Event`, but
    * apart from Scala JS
    * there's no other def left
    * 
    */
   type EdsbEventInfo

   ;

   ;

   ;
}



















val _ = {}
