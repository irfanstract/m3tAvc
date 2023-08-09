













class AevgmCallbackTest1 extends
org.scalatest.funsuite.AnyFunSuite
{
   //

   import concurrent.duration.*

   import avcframewrk.evm.*

   //

   def randomHexString
   : String
   = { val v = java.lang.Double.doubleToRawLongBits(math.random() ).abs ; java.lang.Long.toHexString(v : Long).nn }

   def awaitDuration(t: FiniteDuration )
   : Unit
   = {
      java.lang.Thread.sleep(math.max(1, t.toMillis ) )
   }

   def sameThreadScheduler
   = monix.execution.Scheduler(concurrent.ExecutionContext.parasitic )

   lazy val sharedPrintlnScheduler
   = {
      monix.execution.Scheduler.singleThread(name = "println", daemonic = true )
   }

   extension [
      Ev <: String | Product
      ,
   ](evts: AsyncAlgebraicMonad[Ev] )
   {

      def printAll(
         projectId: String
         = randomHexString
         ,
      )
      (using preChainScheduler: monix.execution.Scheduler )
      : Unit
      = {

         evts
         .force
         .map(m => {
            println(s"[$projectId] msg: '$m'")
         })
         .force(using sharedPrintlnScheduler ) /* otherwise the callbacks will never be executed */

      }

   }

   def newAsyncEnumPipe[E](typingFunc : E => Unit )
   = {

      newAlgebrPipe(
         typingFnc = typingFunc ,
         multicastStrategy = monix.reactive.MulticastStrategy.replay ,
         scheduler = sameThreadScheduler ,
      )
   }

   test("test 1") {
      //

      val pipe1 = {
         newAsyncEnumPipe(typingFunc = identity[DummyImplicit ?=> String ] )
      }

      //

      pipe1._1.onNext("hi")
      pipe1._1.onNext("welcome to the testing workflow")
      pipe1._1.onNext("END")

      {

         given monix.execution.Scheduler
            = sameThreadScheduler

         ;

         var c: String = ""

         pipe1._2
         /* enforce the dispatch of the ContextFnc */
         .map(value => value )
         /* concatenate all, with line-break */
         .reduce(_ + "\r\n" + _ )
         /* assign as the value of `c` */
         .map(value => { require(c.isEmpty(), "unexpected reassignment") ; c = value } )
         /* ensure the actual dispatch */
         .force

         /** apply this check */
         assert(c.nonEmpty && c.contains("END") )

         ()

      }

      awaitDuration(3.second )

      // {
      //    given monix.execution.Scheduler
      //       = monix.execution.Scheduler(concurrent.ExecutionContext.parasitic )
      //    ???
      // }

      awaitDuration(3.second )

   }

}





















