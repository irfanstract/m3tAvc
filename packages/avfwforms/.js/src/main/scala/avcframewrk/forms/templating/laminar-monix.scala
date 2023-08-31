package avcframewrk.forms.templating

















implicit
object AirstreamFromMonix
{

   extension [Item](src : monix.reactive.Observable[Item]) {

      @deprecated
      def toLaminarObservable()
      : Airstream.Source[Item]
      = AirstreamFromMonix(src)

      def toLaminarEventStream()
      : Airstream.EventStream[Item]
      = AirstreamFromMonix(src)

   } // [Item](src : monix.reactive.Observable[Item]) toLaminarObservable

   def apply[Item](src : monix.reactive.Observable[Item])
   : Airstream.EventStream[Item]
   = {
      ;

      // TODO
      ;

      val pv
      = {
         laminar.api.L.Var[Option[Item] ](None )
      }

      val frontEnd = {
         ;
         pv.signal
         .changes
         .collect({
            case Some(v) =>
               v
         })
      }
  
      src
      .map(v => { pv.writer.onNext(Some(v) ) } )
      .subscribe()(using monix.execution.Scheduler.global )

      frontEnd
   } // apply[Item](src : monix.reactive.Observable[Item])

   private[AirstreamFromMonix]
   final
   lazy val sameThreadMonixScheduler
   : monix.execution.Scheduler
   = monix.execution.Scheduler(concurrent.ExecutionContext.parasitic )

} // AirstreamFromMonix$


















