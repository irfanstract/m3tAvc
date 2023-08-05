













@main
def runAevgmCallbackTest1() : Unit
= {

   import avcframewrk.evm.*

   given monix.execution.Scheduler
   = monix.execution.Scheduler.global

   val pipe1 = {

      newAlgebrPipe(
         typingFnc = identity[String] ,
         multicastStrategy = monix.reactive.MulticastStrategy.replay ,
      )
   }

   pipe1._1.onNext("hi")
   pipe1._1.onNext("welcome to the testing workflow")
   pipe1._1.onNext("END")

   extension [Ev <: String](s: AsyncAlgebraicMonad[Ev] )
   {

      def printAll(
         projectId: String
         = { val v = java.lang.Double.doubleToRawLongBits(math.random() ).abs ; java.lang.Long.toHexString(v).nn }
         ,
      )
      : Unit
      = {

         pipe1._2
         .map(m => {
            println(s"[$projectId] msg: '$m'")
         })
         .subscribe(monix.reactive.observers.Subscriber.empty ) /* otherwise the callbacks will never be executed */
         
      }
      
   }

   pipe1._2
   .printAll()

   pipe1._2
   .printAll()

   java.lang.Thread.sleep(8 * 1000 )
   
}





















