package avcframewrk.util

















// non-open, yet non-sealed
class ByteBufferInputStream(src : java.nio.ByteBuffer )
extends
java.io.InputStream
{

   import language.unsafeNulls

   override
   def toString(): String = {

      s"ByteBufferInputStream($src )"
   }

   override
   def reset(): Unit = {
      src position(rewposVar.get() )
   }

   private[util] 
   val rewposVar = {
      new java.util.concurrent.atomic.AtomicInteger(0)
   }

   override def markSupported(): Boolean = true

   override
   def mark(readlimit: Int): Unit = {

      val presentlyPos = {

         src.position()
         
      } : Int

      rewposVar set presentlyPos
   }

   override
   def read(): Int = {
      
      if src.hasRemaining() then {

         val value = src.get() : Byte

         0xFF & value.toInt
      }
      else -1
   }

   /**
    * 
    * .
    * 
    */
   override
   def read(b: Array[Byte] | Null, off: Int, expectedLen: Int): Int = {

      if !(src.hasRemaining() ) then -1
      else {

         val finalLengthVal = {
            math.min(src.remaining() , expectedLen )
         }

         val initialPos = {

            src.position()
            
         } : Int

         runReadbPreSrcGetTask()

         try {

            src get(b, off, finalLengthVal )
          
            if !((initialPos + finalLengthVal ) == src.position() ) then {
               throw {
                  (new java.util.ConcurrentModificationException(s"final 'src.position()' become unsexpected val ") )
               }
            }
  
         }
         catch {
            case z : Exception =>
               throw new java.io.IOException(z)
         }

         finalLengthVal
      }
   }

   /**
    * 
    * run optional tasks, eg to simulate race-condition
    * 
    */
   private[avcframewrk]
   def runReadbPreSrcGetTask(): Unit = {}

   /**
    * 
    * .
    * 
    */
   override
   def read(b: Array[Byte] | Null): Int = {

      read(b, 0, b.length )
   }

}













































