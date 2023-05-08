package cbsq











sealed 
abstract class FileSize protected () {

   val bytes: Long

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
      s"${bytes }bytes"
   }

}
object FileSize {

   extension (v: FileSize) {

      inline def bits =
         v.bytes * 0x8

   }

   sealed trait MExactly[+BN <: Long] 
   extends FileSize
   {
      val bytes: BN
   }

   protected 
   sealed 
   case class Fsz1[+BN <: Long](bytes: BN) 
   extends 
   FileSize 
   with MExactly[BN] 
   {

      val int32s = {
         bytes
         .toDouble
         ./(0x4)
         // .toDouble
      }

   }

   extension (v: FileSize) {

      inline def int16s = {
         v.bytes
         .toDouble
         ./(0x2)
         // .toDouble
      }

   }

   extension (v: FileSize) {

      inline def int64s = {
         v.bytes
         .toDouble
         ./(0x8)
         .toDouble
      }

   }

   def fromByteCount[BN <: Singleton & Long](v: BN): FileSize & MExactly[BN] =
      Fsz1(bytes = v)

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









