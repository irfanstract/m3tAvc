package avcframewrk.util

















extension[R](f: concurrent.Future[R] ) {

   def awaitAndGetReturnValue(): R = {

      /**
       * 
       * `concurrent.Await.result(f, Duration.Infinity )`
       * would do this job.
       * 
       * however, 
       * `concurrent.Await.result(f, Duration.Infinity )`
       * doesn't play well with Java debugging, as
       * `park(...)`s can't be *suspend*ed .
       * instead,
       * make it a loop which
       * repeatedly runs the same method, with sufficiently small `duration`s
       * 
       */
      breakablyGet[R](resolve => {
         //

         while true do {
            //

            import concurrent.duration.*

            try {

               val futureObjReturnValue = {

                  concurrent.Await.result(f, 5.seconds )
                  
               } : R
               
               resolve(futureObjReturnValue)
            }
            catch {

               case z : java.util.concurrent.TimeoutException =>
                  // no-op

            }

         }

         throw new Error
         
      })
      
   }

}

def awaitFuture[R](f: concurrent.Future[R] ) = {

   f
   .awaitAndGetReturnValue()

}

def await[R](f: concurrent.Future[R] ): R = {

   f
   .awaitAndGetReturnValue()

}






extension[R](f: concurrent.Future[R] ) {

   @deprecated
   def checkHasSucceedAndGetReturnValue() : R = {

      f
      .value.getOrElse(throw new IllegalStateException("no result yet") ).get

   }

}









































