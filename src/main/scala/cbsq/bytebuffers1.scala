package cbsq
















type      Bytes   = ByteBlob
lazy val  Bytes   = ByteBlob

opaque type ByteBlob
   <: AnyRef & Matchable
   = collection.immutable.ArraySeq.ofByte

object ByteBlob {
   //

   extension (buf: ByteBlob) {

      private
      def lengthImpl = {
         import cbsq.FileSize.boxingImplicits.*
         (buf : IndexedSeq[?]).length
            .toLong
            .B
      }

      def length = {
         buf.lengthImpl
      }

      def lengthInBytes = {
         buf.lengthImpl
         .inBytes
      }

   }

   extension (buf: ByteBlob) {

      def byteValues: IndexedSeq[Byte] = {
         buf
      }

   }

   extension (buf: ByteBlob) {

      def slice(start: Int, end: Int) = {
         buf.byteValues
         .slice(start, `end`)
         .toBlob
      }

      def splitAt(i: Int) = {
         (
            buf.byteValues.take(i).toBlob ,
            buf.byteValues.drop(i).toBlob ,
         )
      }
   }

   extension (buf: ByteBlob) {

      def toArray: Array[Byte] = {
         buf.unsafeArray
         .clone()
      }

   }

   export boxingImplicits.*

   object boxingImplicits {

      extension (buf: IndexedSeq[Byte]) {

         def asBlob: Bytes = {
            Bytes(buf)
         }
         
         def toBlob: Bytes = {
            buf.asBlob
         }
         
      }

   }

   /**
    * 
    * exact
    * 
    */
   def apply(data: IndexedSeq[Byte]): ByteBlob = {
      from(data = data )
   }

   /**
    * 
    * exact
    * 
    */
   def from(data: IndexedSeq[Byte]): ByteBlob = {
      data match
         case data : collection.immutable.ArraySeq.ofByte =>
            data
         case _ =>
            unsafeWrapArray(data.toArray[Byte] )
      
   }

   /**
    * 
    * exact copy
    * 
    */
   inline def copyOf(srcBuf: collection.Iterable[Byte]): ByteBlob = {
      unsafeWrapArray((
         srcBuf
         .toArray[Byte]
      ))
   }

   /**
    * 
    * exact copy
    * 
    */
   def copyOfByteArrayRange(b: Array[Byte], off: Int, len: Int): ByteBlob = {
      unsafeWrapArray((
         b
         .view
         .slice(off, off + len)
         .toArray[Byte] /* guaranteed to be different Array ref */
      ))
   }

   /**
    * 
    * exact copy
    * 
    */
   def copyOfByteArray(srcBuf: Array[Byte]): ByteBlob = {
      unsafeWrapArray(srcBuf.clone() )
   }

   /**
    * 
    * exact copy
    * 
    */
   inline def copyOf(srcBuf: Array[Byte]): ByteBlob = {
      copyOfByteArray(srcBuf = srcBuf )
   }

   /**
    * 
    * `unsafeWrapArray`
    * 
    */
   @deprecated("unsafe")
   // protected 
   def unsafeWrapArray(buf: Array[Byte]): ByteBlob = {
      import collection.immutable.ArraySeq
      ArraySeq.ofByte(buf)
   }

   extension (buf: ByteBlob) {

      /**
       * 
       * `unsafeWrapArray`
       * 
       */
      @deprecated("experimental")
      def backingByteArray: Array[Byte] = {
         buf.unsafeArray
      }

   }

   extension (buf : ByteBlob) {

      @deprecated("experimental")
      inline
      def newDirectReader() = {
         new java.io.ByteArrayInputStream((
            buf.unsafeArray
         ))
      }

      def newByteWiseReader(): java.io.InputStream & java.io.DataInput = {
         new java.io.DataInputStream((
            newDirectReader()
         ))
      }

      def newGrossReader() : java.io.InputStream = {
         newDirectReader()
      }

   }

   /**
    * 
    * exactly the remaining bytes  
    * 
    */
   def takeByteIteratorRemainder(src: Iterator[Byte]): ByteBlob = {
      unsafeWrapArray(src.toArray[Byte] )
   }

   /**
    * 
    * exactly the remaining bytes , [[java.nio.ByteBuffer]]
    * 
    */
   def takeJbbRemainder(srcBuf: java.nio.ByteBuffer): ByteBlob = {
      val b1 = (
         new Array[Byte](srcBuf.remaining() )
      )
      srcBuf get b1
      unsafeWrapArray(b1 )
   }

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

   /**
    * 
    * exact copy
    * 
    */
   inline def copyOf(src: java.io.ByteArrayOutputStream): ByteBlob = {
      import language.unsafeNulls /* known usage */

      unsafeWrapArray(buf = src.toByteArray() )
   }

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

   


















