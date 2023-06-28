package avcframewrk.util.forms.controls
















;

trait KTwoWayFlowOpsGivens1[-This0[Value <: Value0], -Value0]
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
            AnyRef
            & Cvo[Value]
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
      val Impl : KTwoWayFlowOpsGivens1[Impl, Any ]
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















