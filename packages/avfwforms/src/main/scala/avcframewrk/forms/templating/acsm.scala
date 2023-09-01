package avcframewrk.forms

package templating
















type AsyncStateChangeMonad[+A]
   >: com.raquo.airstream.core.Signal[A]
   <: com.raquo.airstream.core.Signal[A]
   /* what about `StrictSignal` ? */

type EventMonad[+A]
   >: com.raquo.airstream.core.EventStream[A]
   <: com.raquo.airstream.core.EventStream[A]

type AsyncEventMonad[+A]
   = EventMonad[A]















val _ = {}
