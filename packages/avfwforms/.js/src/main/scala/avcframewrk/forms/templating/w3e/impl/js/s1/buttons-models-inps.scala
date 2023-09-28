package avcframewrk.forms

package templating

package w3e.impl.js

package s1



















private[avcframewrk]
trait ELaminarQckButtonsActionModellingInps
extends
   AnyRef
   with EActionDescImpls
   with ELaminarQckButtonsActionModelling
   with EdGlobalEventInfoItcUni
   with ELaminarQckButtonsActionModellingInpsUtil
   /* with these items item merely listed in the self-type, the IDE/editor won't show any relevant "overrides super member" markers */
   with w3e.pre.VarEditingActionsProv
   /* a temporary repetition here (of below) necessary to prevent the compiler from hanging */
   // with ELaminarQckCoreHtml
{
   sgvs : (
      AnyRef
      with ELaminarQckButtonsActionModelling
      with ELaminarQckButtonsActionModellingTwo
      with w3e.pre.Articles
      with w3e.pre.Buttons
      with w3e.pre.PlainTxtContents
      // with ELaminarQckCoreHtml
      // with ELaminarQckPlainStringConts
      with w3e.pre.PlainTxtContents
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
                  typ = spn ,
                  src = operand ,
                  onEditToNewValue0 = Some { (newValue: Value, _) => operand.toObserver.onNext(newValue ) } ,
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
         onShallEditStart
         : (
            (lastValue: Value, host: BInputFunc[Value] ) =>
               Unit
         )
         ,
         typ
         : sgvs.GivenSpinner1[Value]
         ,
         src : (
            ([V] =>> (laminar.api.L.SignalSource[V] ) )[Value]
            // & laminar.api.L.Sink[Value]
         )
         ,
         onUndoOrRedoKeyEventCOption
         : Option[(evtInfo: org.scalajs.dom.Event) => Unit ]
         = None
         ,
         onEditToNewValue0
         : Option[(newValue: Value, chgEvtInfo: org.scalajs.dom.Event) => Unit ]
         ,
      )
   extends
      AnyRef
      with (() => Unit )
      with ((EdsbEventInfo) => Unit )
   {
      ;

      @deprecated
      val t
      : typ.type
      = typ

      val onEditToNewValue
      = {
         onEditToNewValue0
         .getOrElse((_: Any, _: Any) => {} )
      }

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

} // ELaminarQckButtonsActionModellingInps

private[avcframewrk]
trait ELaminarQckButtonsActionModellingInpsUtil
{
   ;

   ;

   extension [T1, T2] (
      //

      src0 : (
         ([V] =>> (laminar.api.L.SignalSource[V] ) )[(T1, T2)]
         & laminar.api.L.Sink[(T1, T2)]
      )
   ) {
      //

      def swapZipMap()
      : (
         //
         AnyRef
         with laminar.api.L.SignalSource[(T2, T1)]
         with laminar.api.L.Sink[(T2, T1)]
      )
      = {
         new
            AnyRef
            with laminar.api.L.SignalSource[(T2, T1)]
            with laminar.api.L.Sink[(T2, T1)]
         {
            ;
            val toObservable = src0.toObservable.map(_.swap)
            val toObserver = src0.toObserver.contramap((_: (T2, T1) ).swap )
            ;
         }
      }

      //
   }

   extension [Item, T] (
      //

      src0 : (
         ([V] =>> (laminar.api.L.SignalSource[V] ) )[(T, Item)]
         & laminar.api.L.Sink[(T, Item)]
      )
   )
   {
      //

      def unliftAsTimeTagging
         (getTFor: (value: Item) => T )
      : (
         //
         AnyRef
         with laminar.api.L.SignalSource[Item]
         with laminar.api.L.Sink[Item]
      )
      = {
         ;
         new
            AnyRef
            with laminar.api.L.SignalSource[(Item)]
            with laminar.api.L.Sink[Item]
         {
            ;
            val toObservable = src0.toObservable.map(_._2)
            val toObserver = src0.toObserver.contramap((value: Item) => { val t = getTFor(value ) ; (t, value) } )
         }
      }

      //
   }

   ;
} // ELaminarQckButtonsActionModellingInpsUtil

















val _ = {}
