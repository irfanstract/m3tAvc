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

      type StartIndex
         >: com.raquo.airstream.custom.CustomSource.StartIndex
         <: com.raquo.airstream.custom.CustomSource.StartIndex

      var subscriptionsMap
      : Map[StartIndex, AnyRef & monix.execution.Cancelable ]
      = Map.empty

      def unsubscribeFor(sI: StartIndex )
      = {
         ;

         subscriptionsMap =
            subscriptionsMap
            .tapEach({ case (`sI`, s) => s.cancel() ; case _ => })
            .removed(sI)
      }

      val frontEnd = {
         ;
         Airstream.EventStream.fromCustomSource[Item](
            //

            //
            shouldStart = {
               case _ =>
                  true
            } ,

            //
            start = {
               case (fireValue, fireError, getSI, _ ) =>
                  ;

                  val sI = getSI() : StartIndex

                  subscriptionsMap = {
                     subscriptionsMap.updatedWith(sI)({
                        case None =>
                           ;

                           val s = {
                              // given sameThreadMonixScheduler.type = sameThreadMonixScheduler
                              given monix.execution.Scheduler = monix.execution.Scheduler.global
                              src
                              .map(fireValue)
                              .onErrorHandle(fireError )
                              .subscribe()
                           }

                           Some(s)

                        case Some(s) =>
                           /* can't Subscribe more than once */
                           throw new IllegalStateException(s"for i=${sI} ")
                     })
                  }

            },

            //
            stop = (sI: StartIndex) => {
               unsubscribeFor(sI)
            } ,

            //
         )
      }

      frontEnd
   } // apply[Item](src : monix.reactive.Observable[Item])

   // private[AirstreamFromMonix]
   // final
   // lazy val sameThreadMonixScheduler
   // : monix.execution.Scheduler
   // = monix.execution.Scheduler(concurrent.ExecutionContext.parasitic )

} // AirstreamFromMonix$


















