package cbsq.avc















class newXResourcesManager()
extends
AnyRef with java.io.Closeable
{
   
   private[newXResourcesManager] 
   val toAwaitUntilClosed = {
      new java.util.concurrent.Semaphore(0)
   }

   private[newXResourcesManager] 
   val m1Pre : concurrent.Future[util.Using.Manager] = {

      val p = concurrent.Promise[util.Using.Manager]

      locally {
         
         concurrent.ExecutionContext.global
         .execute(() => {

            util.Using.Manager(m => {
               import language.unsafeNulls /* to use the JDK stuffs */

               p success m

               toAwaitUntilClosed.acquire()
               
            })
            
         })
         
      }
      
      p.future
      
   }
   private[newXResourcesManager] 
   final
   lazy val m1 = {
      concurrent.Await.result(m1Pre, atMost = concurrent.duration.Duration.Inf )
   }

   export m1.{apply as register}

   /**
    * 
    * cause all registered items to be "close"d,
    * by closing the `Using.Manager`,
    * by "releasing" the Semaphore.
    * 
    */
   protected 
   def closeTheInternalManager(): Unit = {
      import language.unsafeNulls /* to use the JDK stuffs */

      toAwaitUntilClosed.release()
      
   }

   /**
    * 
    * cause
    * all registered items to be "close"d,
    * .
    * 
    */
   override
   def close(): Unit = {
      closeTheInternalManager()
   }

}











@main
def runResourceManagementDemo(): Unit = {
   
   val rm = newXResourcesManager()

   println("[runResourceManagementDemo]")

   rm register (new java.io.Closeable { override def close(): Unit = { println("disposal 1") } })
   rm register (new java.io.Closeable { override def close(): Unit = { println("disposal 2") } })
   rm register (new java.io.Closeable { override def close(): Unit = { println("disposal 3") } })
   rm register (new java.io.Closeable { override def close(): Unit = { println("disposal 4") } })
   rm register (new java.io.Closeable { override def close(): Unit = { println("disposal 5") } })

   Thread.sleep(3 * 1000 )

   util.Using.resource(rm)(_ => {
      //
   })

   Thread.sleep(3 * 1000 )

}



















