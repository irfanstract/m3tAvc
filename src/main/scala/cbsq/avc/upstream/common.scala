package cbsq.avc.upstream















//export collection.mutable.{Buffer as Sequencer }
//export collection.mutable.{ArrayBuffer as ArraySequencer }
//
//@annotation.experimental
//def ??? = scala.Predef.???
//
//export java.time.Duration
//
//object CAS {
//
//   export java.util.concurrent.SynchronousQueue
//   export java.util.concurrent.BlockingQueue
//   export java.util.concurrent.BlockingDeque
//   export java.util.concurrent.{LinkedBlockingDeque, ArrayBlockingQueue}
//   
//   export java.util.concurrent.Semaphore
//   export java.util.concurrent.locks.{ReadWriteLock, ReentrantReadWriteLock }
//
//   import java.util.concurrent.{atomic as jca}
//
//   export jca.{AtomicReference        }
//   export jca.{AtomicLong             }
//   export jca.{AtomicInteger          }
//   export jca.{AtomicBoolean          }
//   export jca.{AtomicStampedReference }
//   export jca.{AtomicLongArray        }
//
//   export java.lang.invoke.VarHandle.{fullFence}
//   
//   export java.lang.ref.Reference.reachabilityFence
//
//}
//
//export java.net.URI
//export java.net.{InetAddress, InetSocketAddress }
//
//export cbsq.ByteBlob
//

export cbsq.mCommons.{
   URL => _,
   Resolvable => _ ,
   * ,
}

type Resolvable[Value] = (
   AnyRef
   & cbsq.avc.LateBoundValue.NhwCompleteWith[Value]
   & cbsq.avc.LateBoundValue.NhwGetValue[Value]
)

// @annotation.experimental
protected 
def notImplemented: Nothing = {
   Predef.???
}

export cbsq.avc.LateBoundValue

extension[Value](this1: Resolvable[Value] )
{
   
   /**
    * return value if already resolved, throw otherwise
    * 
    */
   transparent inline def valueOrFail: Value =
      java.lang.Thread.sleep(7L)
      this1.asFuture.value match {
         case None => 
            throw IllegalStateException("unresolved")
         case Some(util.Failure(z)) => 
            throw z
         case Some(util.Success(value)) => 
            value
      }

   /**
    * return value if resolved, otherwise
    * block until timeout (in which case throws)
    * 
    */
   transparent inline def valueOrTimeout(timeout: Duration): Value =
      concurrent.Await.result(this1.asFuture, timeout)

}

export cbsq.avc.ColorChannelsFmt
export cbsq.avc.PixelFmt
export cbsq.avc.{KBuffer, KByteBuffer }











