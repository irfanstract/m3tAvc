package avcframewrk.forms.templating

















object AirstreamFromMonix
{

   def apply[Item](src : monix.reactive.Observable[Item])
   : Airstream.EventStream[Item]
   = {
      ;

      // TODO
      ;

      var subscriptionsMap
      : Map[Int, AnyRef & monix.execution.Cancelable ]
      = Map.empty

      def unsubscribeFor(sI: Int)
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
            shouldStart = sI => true ,

            //
            start = {
               case (fireValue, fireError, getSI, _ ) =>
                  ;

                  val sI = getSI()

                  subscriptionsMap = {
                     subscriptionsMap.updatedWith(sI)({
                        case None =>
                           ;

                           val s = {
                              given sameThreadMonicScheduler.type = sameThreadMonicScheduler
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
            stop = (sI) => {
               unsubscribeFor(sI)
            } ,

            //
         )
      }

      frontEnd
   }

   private[AirstreamFromMonix]
   final
   lazy val sameThreadMonicScheduler
   : monix.execution.Scheduler
   = monix.execution.Scheduler(concurrent.ExecutionContext.parasitic )

} // AirstreamFromMonix$


















