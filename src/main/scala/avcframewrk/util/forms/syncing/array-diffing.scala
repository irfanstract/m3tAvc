package avcframewrk.util.forms.syncing

















;

object ArrayDiffing {

   import language.unsafeNulls
   
   extension [E](src: collection.Iterable[E] ) {
      
      def startCollRefreshItr(dispatcher: concurrent.ExecutionContext ) = {

         val (propagateState, exportedStateItr) = {

            import avcframewrk.util.*

            newEventEmitter[collection.immutable.Iterable[E] ](
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
            
            while (istat.isRight ) util.Using.resource((() => { Thread.sleep(1000) } ) : java.io.Closeable ) (_ => {

               val state = {
                  
                  src match {
                     case s : collection.Set[etype] =>
                        Set.from(s)
                     case s =>
                        collection.immutable.Iterable.from(s)
                  }
               } : collection.immutable.Iterable[E]
               
               propagateState({
                  state
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




















