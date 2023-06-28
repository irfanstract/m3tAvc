package avcframewrk.util.forms.controls

















;

object KValueChangeEvent {

   type ForValue[+Value]
      = ForArgs[Value]
      
   protected 
   trait ImplOps[+Value]
      extends 
         AnyRef
         with Cvo[Value]
   {

      val isByUndo : Boolean
      val isByRedo : Boolean

   }
   
   // protected 
   case class ForArgs[+Value](
      //

      priorValue: Value ,
      newValue  : Value ,

      isByUndo : Boolean ,
      isByRedo : Boolean ,

   )
   extends 
      AnyRef
      with ImplOps[Value]
   {

      /**
       * 
       * derived instance --
       * mapped `priorValue` and `newValue`, and
       * maintained remainder
       * 
       */
      def map[TranslatedValue](f: (newValue.type | priorValue.type) => TranslatedValue) = {

         copy[TranslatedValue](
            newValue   = f(newValue  ) ,
            priorValue = f(priorValue) ,
         )
      } 

   }

}

trait KFiniteStateTwoWayFlowOpsGivens1[-This0[Value <: Value0], -Value0]
{

   extension [Value <: Value0](c : This0[Value] ) {

      /**
       * 
       * conversion to `avcframewrk.util.EventIterator[Value]`
       * 
       * `EventIterator` is co-variant
       * 
       */
      def valueChangeEvents: (
         
         avcframewrk.util.EventIterator[(
            //
            KValueChangeEvent.ForValue[Value]
         )]
      )
      
   }

   extension [Value <: Value0](c : This0[Value] ) {

      /**
       * 
       * acknowledging that
       * the underlying implementation might support undo/redo stack,
       * commit an edit, but neither undo nor redo,
       * updating the value
       * 
       */
      def commitValueShift(
         //

         computeNewValue: Value => Value ,

      ): CvsOutcome[Value]

      /**
       * 
       * acknowledging that
       * the underlying implementation might support undo/redo stack,
       * commit an edit, but neither undo nor redo,
       * updating the value
       * 
       * to avoid the negative impacts of race-condition(s),
       * evaluation of `newValue`
       * might need to be delayed
       * 
       */
      // transparent inline
      def value_=(newValue: => Value ) = {

         c commitValueShift(_ => newValue )
      }

      private
      def compilerTestAssignedValue_=(newValue: Value ) = {

         c value_=(newValue )
      }

   }

}

/**
 * 
 * the base type
 * which the return-value of `commitValueShift` shall `extends`
 * 
 */
type CvsOutcome[+Value]
   >: Either[Unit | Throwable, Cvo[Value] ]
   <: Either[Unit | Throwable, Cvo[Value] ]

/**
 * 
 * defines a minimum set of info relevant to a successful `value_=` op
 * 
 * `priorValue`, `newValue`
 * 
 */
trait Cvo[+Value] {

   val priorValue : Value

   val newValue : Value

}

/* test */

val _ = {

   trait XWithImpl {

      type Impl[_]
      val Impl : KFiniteStateTwoWayFlowOpsGivens1[Impl, Any ]
      export Impl.*

      ([Value] => (e : Impl[Value] ) => {
         e.value_=(??? )
         e.commitValueShift(v => v )
         e.valueChangeEvents
         .foreach(v => println(v) )
      } )

   }

}

// protected 
class Kvog[Value](initialHeadValue: Value)
{

   private 
   val initialUndoRedoStack = {
      avcframewrk.util.forms.controls.KUndoRedoStateTree.initially(initialHeadValue = initialHeadValue)
   }

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

   def updateState(f: (state0: StateDigestCtx ) => StateChgEvent ) = {

      val pq = avcframewrk.util.LateBoundValue.newInstance[StateChgEvent]

      eusPre apply((f, pq) )

      pq.asFuture
      .value.toRight(new RuntimeException(s"'pq' remains unanswered. solution: ensure there's no async-ness ") ).flatMap(_.toEither )
   }

   val (eusPre, stateDigestFncEventItrPre ) = {

      avcframewrk.util.newEventEmitter[(
         
         ((StateDigestCtx) => StateChgEvent, avcframewrk.util.LateBoundValue.NhwCompleteWith[StateChgEvent] )

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

      val stateVar = {
         new java.util.concurrent.atomic.AtomicReference[State ](None )
      }

      stateDigestFncEventItrPre
      .map[State]({ case (implApplyDigestion, resolveable ) => {

         import language.unsafeNulls
         
         stateVar updateAndGet(priorState => {

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

            match { case s => resolveable.success(s ) ; s }
            
            /**
             * pack as `Some(s)`
             */
            match { case s => Some(s) : Some[StateChgEvent] }

         } )
      } })
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

}

object Kvog extends 
AnyRef
with KFiniteStateTwoWayFlowOpsGivens1[Kvog, Any ]
{

   extension [Value](c : Kvog[Value] ) {

      /**
       * 
       * conversion to `avcframewrk.util.EventIterator[Value]`
       * 
       * `EventIterator` is co-variant
       * 
       */
      override
      def valueChangeEvents = {

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

      def redoOrUndo(count: -1 | 1): Unit = {

         c.updateState((priorState : c.XUndoStack ) => {
            
            val newState = {
               count match {
                  case -1 => priorState.afterUndo()
                  case  1 => priorState.afterRedo()
               }
            }

            KValueChangeEvent.ForArgs(
               //
               priorValue = priorState ,
               newValue   = newState   ,
               isByUndo = count == -1 ,
               isByRedo = count ==  1 ,
            )
         })
      }

   }

   extension [Value](c : Kvog[Value] ) {

      def redo() = c redoOrUndo(1)

      def undo() = c redoOrUndo(-1)
      
   }

   //

}

;

;















