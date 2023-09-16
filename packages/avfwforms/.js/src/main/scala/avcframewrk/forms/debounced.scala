package avcframewrk.forms











def startThrottledService
   [A, U]
   (periodMillis: Int = 30 * 1000 )
   (main: A => U )
= {
   ;

   object A {
      export com.raquo.airstream.eventbus.EventBus
      export com.raquo.airstream.core.Observer
   }
   val eb = A.EventBus[A]()
   eb.events
   .throttle(periodMillis )
   .map(main )
   .addObserver(A.Observer.empty )(com.raquo.airstream.ownership.ManualOwner() )
   eb.writer
}















