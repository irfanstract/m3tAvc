package cbsq
















sealed 
abstract class ByteBlob protected () {
   val bytes: collection.immutable.ArraySeq[Byte]
}
object ByteBlob {
   //

   protected 
   case class Basically[
      +Data <: collection.immutable.ArraySeq.ofByte ,
   ](
      bytes: Data ,
   ) extends ByteBlob

   def copyOfByteArray(srcBuf: Array[Byte]): ByteBlob =
      Basically(bytes = (
         new collection.immutable.ArraySeq.ofByte(srcBuf.clone() )
      ))

   def copyFromJInputStream(src: java.io.InputStream): ByteBlob =
      // import language.experimental.captureChecking
      Basically(bytes = (
         new collection.immutable.ArraySeq.ofByte(src.readAllBytes() )
      ))

}

type Utf = String

sealed 
abstract class FileSize protected () {
   val bytes: Long
   val int32s: Long
}
object FileSize {

   sealed trait MExactly[+BN <: Long] extends FileSize {
      val bytes: BN
   }

   protected 
   sealed case class Fsz1[+BN <: Long](bytes: BN) extends FileSize with MExactly[BN] :
      val int32s = bytes / 0x4

      override def toString(): String = {
         s"${bytes }B"
      }

   def fromByteCount[BN <: Long](v: BN): FileSize & MExactly[BN] =
      Fsz1(bytes = v)

   extension [V <: Int | Long : Integral](value: V) {

      inline def B = {
         import Numeric.Implicits.*
         cbsq.FileSize.fromByteCount(value.toLong : Long )
      }

   }

}










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

   


















