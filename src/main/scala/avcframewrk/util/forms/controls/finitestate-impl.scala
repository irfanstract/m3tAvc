package avcframewrk.util.forms.controls

















val _ = {}




;

/**
 * 
 * co-variant alias of `Kvog`
 * 
 */
type KvogByYield[+Value]
   = Kvog[? <: Value]

object Kvog extends 
AnyRef
with KFiniteStateTwoWayFlowOpsGivens1[Kvog, Any ]
{

   /**
    * 
    * the ctxtual `type`s.
    * 
    */
   trait CtxtualPredefsImpl[Value]
   extends
   AnyRef
   {
      
      import avcframewrk.util.forms.controls.KUndoRedoStateTree

      import avcframewrk.util.forms.controls.KValueChangeEvent
         
      type XUndoStack
         >: KUndoRedoStateTree[Value]
         <: KUndoRedoStateTree[Value]

      type State
         >: Option[KValueChangeEvent.ForValue[XUndoStack] ]
         <: Option[KValueChangeEvent.ForValue[XUndoStack] ]

      type StateDigestCtx
         >: XUndoStack
         <: XUndoStack

      type StateChgEvent
         >: KValueChangeEvent.ForValue[XUndoStack ]
         <: KValueChangeEvent.ForValue[XUndoStack ]

      type ValueChgEvent
         >: KValueChangeEvent.ForValue[Value ]
         <: KValueChangeEvent.ForValue[Value ]

   }

   //

   extension [Value](c : Kvog[Value] ) {

      /**
       * 
       * conversion to `avcframewrk.util.EventIterator[Value]`
       * 
       * `EventIterator` is co-variant
       * 
       */
      override
      def valueChangeEvents: avcframewrk.util.EventIterator[c.ValueChgEvent] = {

         c.valueChgEventItr
      }
      
   }

   extension [Value](c : Kvog[Value] ) {

      def commitValueShift(
         //

         computeNewValue: Value => Value ,

      ): CvsOutcome[Value] = {

         c.updateState(priorState => {
            
            val priorValue = priorState.headValue
            
            val newValue = {
               computeNewValue(priorValue)
            }

            KValueChangeEvent.ForArgs(
               //
               priorValue = priorState ,
               newValue = priorState afterEdit(newValue) ,
               isByUndo = false ,
               isByRedo = false ,
            )
         })
         .map(s => s.map(_.headValue) )
      }
      
   }

   extension [Value](c : Kvog[Value] ) {

      def redoOrUndo(direction: -1 | 1): Unit = {

         c.updateState((priorState : c.XUndoStack ) => {
            
            val newState = {
               direction match {
                  case -1 => priorState.afterUndo()
                  case  1 => priorState.afterRedo()
               }
            }

            KValueChangeEvent.ForArgs(
               //
               priorValue = priorState ,
               newValue   = newState   ,
               isByUndo = direction == -1 ,
               isByRedo = direction ==  1 ,
            )
         })
      }

   }

   extension [Value](c : Kvog[Value] ) {

      def redo() = c redoOrUndo(1)

      def undo() = c redoOrUndo(-1)
      
   }

   export kvogExtensions.*
   
}

// protected 
class Kvog[Value](initialHeadValue: Value)
extends
AnyRef
with Kvog.CtxtualPredefsImpl[Value]
{

   private 
   val initialUndoRedoStack = {
      avcframewrk.util.forms.controls.KUndoRedoStateTree.initially(initialHeadValue = initialHeadValue)
   }

   import avcframewrk.util.forms.controls.KUndoRedoStateTree

   import avcframewrk.util.forms.controls.KValueChangeEvent

   def updateState(f: (state0: StateDigestCtx ) => StateChgEvent ) = {

      /**
       * 
       * `EventIterator`
       * doesn't define synchronous(ly) inspective points, so
       * here arises a need to allocate LBV to back-propagate the finally-returned Event
       * 
       */
      val pq = avcframewrk.util.LateBoundValue.newInstance[StateChgEvent]

      eusPre apply(Esb(main = f , detour = pq ) )

      pq.asFuture
      .value.toRight(new RuntimeException(s"'pq' remains unanswered. solution: ensure there's no async-ness ") ).flatMap(_.toEither )
   }

   private[Kvog]
   case class Esb(
      //
      main : (StateDigestCtx) => StateChgEvent ,
      detour : avcframewrk.util.LateBoundValue.NhwCompleteWith[StateChgEvent] ,
   )

   final
   lazy val (eusPre, stateDigestFncEventItrPre ) = {

      avcframewrk.util.newEventEmitter[(
         
         Esb

      )](evtType = {

         /**
          * 
          * the emittes are the digest fncs, rather than the digested states themselves, so
          * this shall be `ofAction`
          * 
          */
         avcframewrk.util.TsevpEventType.ofAction
      } )
   }

   lazy val stateChgEventItr = {

      stateDigestFncEventItrPre
      .scanLeft[State](None)({

         case (priorState, (ep ) ) => {

            import ep.{main => implApplyDigestion }
            val detour = ep.detour

            priorState

            /**
             * unpack the `Option`
             */
            match {
               case s =>
                  s
                  .fold[StateDigestCtx](initialUndoRedoStack)(priorStateChgEvt => priorStateChgEvt.newValue )
            }

            /**
             * run `implApplyDigestion`
             */
            match { case s => implApplyDigestion(s) }

            match { case s => detour success(s ) ; s }
            
            /**
             * pack as `Some(s)`
             */
            match { case s => Some(s) : Some[StateChgEvent] }
            
         }

      })
      .flatMap[StateChgEvent ]({ case e : Option[s] => e })
   }

   val valueChgEventItr = {

      stateChgEventItr
      .map[ValueChgEvent]((s: StateChgEvent) => {

         s map(_.headValue)
      })
   }

   val valueChgItrImpl = {

      valueChgEventItr
      .map((s: ValueChgEvent) => {
         s.newValue
      })
   }

   this commitValueShift(v => v )

}

protected 
object kvogExtensions extends 
AnyRef
// with KFiniteStateTwoWayFlowOpsGivens1[Kvog, Any ]
{

}




;















