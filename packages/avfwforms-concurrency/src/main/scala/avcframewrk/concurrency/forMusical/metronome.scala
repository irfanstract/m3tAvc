package avcframewrk.concurrency.forMusical














import avcalg.plsAndTlsAsImplicit.given_plsAndTls

import reflect.Selectable.reflectiveSelectable

import concurrent.duration.*

import cps.{async, await}

// import scalajs.js

// import scalajs.js.annotation.*

// import cps.monads.jsfuture.JSFuture

// import typings.{std as dom }

import com.raquo.airstream












export Metronome.{allocateAndStart as startMetronome }

object Metronome {
   ;

   def allocateAndStart
      //
      (period: FiniteDuration )
   : Metronome._Any
   = {
      airstream.core.EventStream.periodic({
         period.toMillis
         .toInt
      } )
      .pipeLooseSelf({ case impl: (t1 & airstream.core.Observable[t]) => {
         ;

         new airstream.core.Source[t] with java.io.Closeable
         {
            ;

            val suggestedOwner
            = airstream.ownership.ManualOwner()

            given suggestedOwner.type
            = suggestedOwner

            val toObservable
            =
               impl
            //

            toObservable
            /** otherwise, events won't run */
            .pipeLooseSelf(evts => {
               evts
               .toWeakSignal /* or `scanLeft` if one can */
               .observe
            } )

            override
            def close(): Unit
            = suggestedOwner.killSubscriptions()

            ;
         }
      } } )
   }

   opaque type _Any
   <: AnyRef & airstream.core.Source[Any] & java.io.Closeable
   = airstream.core.Source[Any] & java.io.Closeable

   ;
}















