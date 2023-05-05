package cbsq.avc
















/**
 * 
 * utility for I/O-based task templating
 * 
 */
object IoTaskTemplating {
   
   /**
    * 
    * this `trait` 
    * defines exactly `start(): R`
    * 
    */
   trait KStartible[+R] {

      def start(): R

   }

   /**
    * 
    * this `trait` 
    * defines exactly 
    * [[java.io.Closeable `close(): Unit`]] and *asFuture*
    * 
    * @tparam R  the return-value
    * 
    */
   @deprecated("experimental")
   trait KTask[+R] extends
      AnyRef
      with java.io.Closeable
   {
      
      /**
       * 
       * terminates the task.
       * idempotent.
       * 
       * note that there's `asFuture1: Future[R]`, meaning that
       * certain "resources" will need to be left allocated.
       * 
       */
      override
      def close(): Unit 

      /**
       * 
       * a/the `Future` proxying the task's return-value
       * 
       */
      val asFuture1: concurrent.Future[R]

   }

   // @annotation.targetName("AtAtBang")
   class @@![+This, +R <: Any](

      implStart : () => R ,

   ) extends
   AnyRef
   with KStartible[R]
   {

      override
      inline 
      def start(): R =
         implStart()

   }

}










@deprecated("experimental")
@main
def atbTest() : Unit =
   new IoTaskTemplating.@@!(implStart = () => { new Exception("ATB Test").printStackTrace() })
   .start()

@deprecated("experimental")
@main
def atbBinaryCompatTest() : Unit =
   println((new IoTaskTemplating.@@!(implStart = () => {})).getClass().getName() )











