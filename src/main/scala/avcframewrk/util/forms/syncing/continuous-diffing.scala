package avcframewrk.util.forms.syncing

















;

object ContinuousGenericDiffing {

   import language.unsafeNulls
   
   //

   extension [S](getCurrentState: () => S ) {

      export gcs_%%%!.*

      private[ContinuousGenericDiffing]
      def gcs_%%%! = new EcsImpl(getCurrentState = getCurrentState )

   }

   private
   class EcsImpl [S](getCurrentState: () => S ) {

      def currentState: S = {

         getCurrentState()
      }
      
      def startPeriodicSnapshotItr(dispatcher: concurrent.ExecutionContext ) = {

         val (propagateState, exportedStateItr) = {

            import avcframewrk.util.*

            newEventEmitter[S ](
               //
               evtType = TsevpEventType.ofUpdate ,
            )
         }

         /**
          * 
          * value either `1` (GO_AHEAD) or `-1` (CEASE)
          * 
          * no atomicity guarantees necessary
          * 
          */
         @volatile
         val s = new java.util.concurrent.atomic.AtomicReference[Either[Unit, Unit] ](Right(() ) )

         /**
          * 
          * .
          * 
          */
         def istat: Either[Unit, Unit] = {
            s.get()
         }

         concurrent.Future({
            
            /**
             * 
             * repeatedly, with interval/latency,
             * scan
             *  
             */
            while (istat.isRight ) util.Using.resource((() => { Thread.sleep(1000) } ) : java.io.Closeable ) (_ => {

               val reading1 = {
                  
                  currentState

               }
               
               propagateState({
                  reading1
               })
               
            })

         } : Unit )(using dispatcher )
         
         object prodCtrl extends
         AnyRef with java.io.Closeable {

            override
            def close(): Unit = {
               
               s set(Left(() ) )
               
            }

         }

         (prodCtrl, exportedStateItr)         
      }

   }

}

;

















