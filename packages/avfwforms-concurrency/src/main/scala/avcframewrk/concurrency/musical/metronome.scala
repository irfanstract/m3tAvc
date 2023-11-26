package avcframewrk.concurrency.musical














import avcalg.plsAndTlsAsImplicit

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
   }

   opaque type _Any
   <: AnyRef & airstream.core.Source[Any]
   = airstream.core.EventStream[Any]

   implicit class _Ops(val r: _Any) {
      ;
      export r.{map, foreach}
   }

   ;
}















