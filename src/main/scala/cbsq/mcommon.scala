package cbsq












/**
 * 
 * demonstrates a suggested set of additional "predefs"
 * 
 */
object mCommons 
{
   
   export collection.mutable.{Buffer as Sequencer }
   export collection.mutable.{ArrayBuffer as ArraySequencer }

   @annotation.experimental
   def ??? = scala.Predef.???

   export concurrent.Future
   export concurrent.{Promise as Resolvable}

   export util.control.NonLocalReturns

   export concurrent.duration.Duration

   export java.time.{Duration as JDuration}

   object CAS {

      export java.util.concurrent.SynchronousQueue
      export java.util.concurrent.BlockingQueue
      export java.util.concurrent.BlockingDeque
      export java.util.concurrent.{LinkedBlockingDeque, ArrayBlockingQueue}
      
      export java.util.concurrent.Semaphore
      export java.util.concurrent.locks.{ReadWriteLock, ReentrantReadWriteLock }

      import java.util.concurrent.{atomic as jca}

      export jca.{AtomicReference        }
      export jca.{AtomicLong             }
      export jca.{AtomicInteger          }
      export jca.{AtomicBoolean          }
      export jca.{AtomicStampedReference }
      export jca.{AtomicLongArray        }

      export java.lang.invoke.VarHandle.{fullFence}
      
      export java.lang.ref.Reference.reachabilityFence

   }

   export java.net.URI
   export java.net.{InetAddress, InetSocketAddress }

   @annotation.compileTimeOnly("please use 'URI' instead")
   object URL

   export cbsq.ByteBlob

}






