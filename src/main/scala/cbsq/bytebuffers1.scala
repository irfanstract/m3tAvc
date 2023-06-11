package cbsq
















type      Bytes   = ByteBlob
lazy val  Bytes   = ByteBlob

type ByteBlob
   = avcframewrk.util.StringOfBytes

object ByteBlob
extends
AnyRef
// with cbsq.bytemanip.OpaquelyTypedCharacterStringExtensionMethodsDefTrait.EfseOfAaob[ByteBlob, Byte]
{
   //

   export avcframewrk.util.StringOfBytes.*

   // /**
   //  * 
   //  * exactly the remaining bytes  
   //  * 
   //  */
   // def takeByteIteratorRemainder(src: Iterator[Byte]): ByteBlob = {
   //    unsafeWrapArray(src.toArray[Byte] )
   // }

   // /**
   //  * 
   //  * exactly the remaining bytes , [[java.nio.ByteBuffer]]
   //  * 
   //  */
   // def takeJbbRemainder(srcBuf: java.nio.ByteBuffer): ByteBlob = {
   //    val b1 = (
   //       new Array[Byte](srcBuf.remaining() )
   //    )
   //    srcBuf get b1
   //    unsafeWrapArray(b1 )
   // }

   /**
    * 
    * exactly the remaining bytes 
    * 
    */
   def takeJIoInputStreamRemainder(src: java.io.InputStream): ByteBlob = {
      import language.unsafeNulls /* known usage */

      val b1 = {
         /** 
          * note : always new array/buffer
          */
         src.readAllBytes()
      }
      unsafeWrapArray(b1)
   }

   // /**
   //  * 
   //  * exact copy
   //  * 
   //  */
   // inline def copyOf(src: java.io.ByteArrayOutputStream): ByteBlob = {
   //    import language.unsafeNulls /* known usage */

   //    unsafeWrapArray(buf = src.toByteArray() )
   // }

}

type Utf
   >: String <: String










export java.nio.{
   ByteBuffer ,
   ShortBuffer as JInt16Buffer ,
   IntBuffer   as JInt32Buffer ,
   LongBuffer  as JInt64Buffer ,
}

// val IBuf = java.nio.IntBuffer

// def ibee(arg: java.nio.IntBuffer.type): Unit =
//    {}

def newInt32Buffer(size: Int): JInt32Buffer = 
   import language.unsafeNulls /* known usage */
   java.nio.IntBuffer.allocate(size)

   


















