













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

}





















