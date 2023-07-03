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

} /* `KValueChangeEvent` */

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

object KFiniteStateTwoWayFlowOpsGivens1 {

   /**
    * 
    * the base type
    * which the return-value of `commitValueShift` shall `extends`
    * 
    */
   type CvsOutcome[+Value]
      >: Either[Unit | Throwable, CvsSuccessSummary.ByValue[Value] ]
      <: Either[Unit | Throwable, CvsSuccessSummary.ByValue[Value] ]

   //
   
   /**
    * 
    * defines a minimum set of info relevant to a successful `value_=` op
    * 
    * `priorValue`, `newValue`
    * 
    */
   object CvsSuccessSummary {

      type ByValue[+Value]
         = Impl[Value]
      
      protected
      trait Impl[+Value] extends
         AnyRef
         with DefinesPriorValueAndNewValue[Value]
      
   }

}

/**
 * 
 * the base type
 * which the return-value of `commitValueShift` shall `extends`
 * 
 */
export KFiniteStateTwoWayFlowOpsGivens1.{CvsOutcome as CvsOutcome }

/**
 * 
 * defines a minimum set of info relevant to a successful `value_=` op
 * 
 * `priorValue`, `newValue`
 * 
 */
@deprecated("this was named after 'CvsOutcome', but I'm unhappy with the naming.")
protected
type Cvo[+Value] = KFiniteStateTwoWayFlowOpsGivens1.CvsSuccessSummary.ByValue[Value]

trait DefinesPriorValueAndNewValue[+Value] {

   val priorValue : Value

   val newValue : Value

} /* `Cvo` */

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

;

;















