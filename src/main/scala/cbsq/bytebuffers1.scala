package cbsq
















// sealed 
// abstract class ByteBlob protected () {
//    val bytes: collection.immutable.ArraySeq[Byte]
// }
opaque type ByteBlob
   <: AnyRef & Matchable
   = collection.immutable.ArraySeq.ofByte
object ByteBlob {
   //

   extension (buf: ByteBlob) {

      def length = {
         import cbsq.FileSize.{B, KB, MB, GB}
         (buf : IndexedSeq[?]).length
            .toLong
            .B
      }

      def byteValues: IndexedSeq[Byte] = {
         buf
      }

   }

   extension (buf: ByteBlob) {

      def toArray: Array[Byte] = {
         buf.unsafeArray
         .clone()
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

   protected 
   def unsafeWrapArray(buf: Array[Byte]): ByteBlob = {
      import collection.immutable.ArraySeq
      ArraySeq.ofByte(buf)
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

   extension (buf: ByteBlob) {

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
    * exactly the remaining bytes , [[java.nio.ByteBuffer]]
    * 
    */
   def takeJbbRemainder(srcBuf: java.nio.ByteBuffer): ByteBlob = {
      val b1 = new Array[Byte](srcBuf.remaining() )
      srcBuf get b1
      unsafeWrapArray(b1 )
   }

   /**
    * 
    * exactly the remaining bytes 
    * 
    */
   def takeJIoInputStreamRemainder(src: java.io.InputStream): ByteBlob = {
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
   java.nio.IntBuffer.allocate(size)

   


















