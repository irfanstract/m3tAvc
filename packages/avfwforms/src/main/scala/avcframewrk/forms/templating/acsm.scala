package avcframewrk.forms

package templating
















opaque type AsyncStateChangeMonad[+A]
   <: (
      AnyRef
      // & com.raquo.airstream.core.Signal[A]
   )
   =  com.raquo.airstream.core.Signal[A]
   /* what about `StrictSignal` ? */

object AsyncStateChangeMonad
{
   ;

   given [A]
   : Conversion[com.raquo.airstream.core.Signal[A] , AsyncStateChangeMonad[A] ]
   = identity[com.raquo.airstream.core.Signal[A] ] _

   extension [A] (this10: AsyncStateChangeMonad[A] ) {
      def this11
      /* widen the type, to build on the opaque alias */
      : com.raquo.airstream.core.Signal[A] & com.raquo.airstream.core.BaseObservable[AsyncStateChangeMonad, A]
      = this10

      export this11.{
         scanLeft as _,
         *, given ,
      }

      /* `scanLeft` was excluded above ; exposing it here renamed */
      export this11.{scanLeft as scanLeftAdapted0 }

      def scanLeft[State](seed: => State )(doDigest: (State, A) => State )
      : AsyncStateChangeMonad[State]
      = {
         this10.scanLeftAdapted0[State](_ => seed)(doDigest )
      }

      def toLaminarObservable
      : com.raquo.airstream.core.Signal[A]
      = this11

   }

   ;
} // AsyncStateChangeMonad$

opaque type EventMonad[+A]
   <: (
      AnyRef
      & com.raquo.airstream.core.EventStream[A]
   )
   =  com.raquo.airstream.core.EventStream[A]

object EventMonad
{
   ;

   given [A]
   : Conversion[com.raquo.airstream.core.EventStream[A] , EventMonad[A] ]
   = identity[com.raquo.airstream.core.EventStream[A] ] _

   extension [A] (this10: EventMonad[A] ) {
      def this11
      /* widen the type, to build on the opaque alias */
      : com.raquo.airstream.core.BaseObservable[EventMonad, A]
      = this10

      export this11.{*, given }

   }

   ;
} // EventMonad$

type AsyncEventMonad[+A]
   = EventMonad[A]















val _ = {}
