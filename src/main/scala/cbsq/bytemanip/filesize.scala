package cbsq.bytemanip
















sealed 
abstract class FileSize protected () {

   val inBytes: Long

   /**
    * 
    * the count of `int32`s, which will be non-integral for non-even examples
    * 
    * note:
    * this usage tends to encourage assumption of MSB-first-ness, but
    * most runtimes are LSB-first
    * 
    */
   val int32s: Double
   
   /**
    * 
    * *str-format*s this `FileSize` as appropriate
    * 
    */
   override
   def toString(): String = {
      s"${inBytes }bytes"
   }

}
object FileSize {

   extension (v: FileSize) {

      inline def bits =
         v.inBytes * 0x8

   }

   sealed trait MExactly[+BN <: Long] 
   extends FileSize
   {
      val inBytes: BN
   }

   protected 
   sealed 
   case class Fsz1[+BN <: Long](inBytes: BN) 
   extends 
   FileSize 
   with MExactly[BN] 
   {

      require(0 <= inBytes, s"inBytes: $inBytes " )

      val int32s = {
         inBytes
         .toDouble
         ./(0x4)
         // .toDouble
      }

   }

   extension (v: FileSize) {

      inline def int16s = {
         v.inBytes
         .toDouble
         ./(0x2)
         // .toDouble
      }

   }

   extension (v: FileSize) {

      inline def int64s = {
         v.inBytes
         .toDouble
         ./(0x8)
         .toDouble
      }

   }

   def fromByteCount[BN <: Singleton & Long](v: BN): FileSize & MExactly[BN] =
      require(0 <= v, s"value: $v " )
      Fsz1(inBytes = v)

   export boxingImplicits.*

   object boxingImplicits {
      
   /**
    * 
    * enables usages like `5MB`, `24KB`, etc
    * 
    * not `1000`, but `1024`.
    * 
    */
   extension [V <: Int | Long : Integral](value: V) {
      
      inline def B = {
         import cbsq.SlfOnEveryValue.implicits.self
         import Numeric.Implicits.*
         FileSize.fromByteCount(value.toLong.self )
      }

      inline def KB = {
         import Numeric.Implicits.*
         (value.toLong * 1024 ).B
      }

      inline def MB = {
         import Numeric.Implicits.*
         (value.toLong * 1024 * 1024 ).B
      }

      inline def GB = {
         import Numeric.Implicits.*
         (value.toLong * 1024 * 1024 * 1024 ).B
      }

   }

   }

   /* arithmetic usages */

   extension (v: FileSize) {

      def unary_- = {
         (v.inBytes)
         .unary_-
         .B
      }
      
      def unary_+ = {
         (v.inBytes)
         .B
      }
      
   }

   extension (v1: FileSize) {

      def +(v2: FileSize) : FileSize = {
         (v1.inBytes + v2.inBytes )
         .B
      }

   }

   extension (v1: FileSize) {

      def -(v2: FileSize) : FileSize = {
         v1 + -v2
      }

   }

   extension (v1: FileSize) {

      def *:(v2: Double) : FileSize = {
         (v2 * v1.inBytes )
         .toLong
         .B
      }

   }

   extension (v1: FileSize) {

      def /(v2: Double) : FileSize = {
         (v1.inBytes.toDouble / v2 )
         .toLong
         .B
      }

   }

   /**
    * 
    * otherwise `<` `>=` etc won't work.
    * 
    */
   given [C <: FileSize]: Ordering[C] = (
      Ordering.by((v: FileSize) => v.inBytes )
   )

   /**
    * 
    * manually-writen auto-boxing to `OrderingOps`.
    * 
    * avoids the need for writing `import Ordering.implicits.*`.
    * 
    */
   given [C <: FileSize]: Conversion[FileSize, math.Ordering[FileSize]#OrderingOps ] = {
      (v: FileSize) => (
         summon[Ordering[FileSize] ]
         .mkOrderingOps(v )
      )
   }

}



























