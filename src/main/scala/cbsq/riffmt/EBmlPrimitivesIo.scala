package cbsq.riffmt













import byteManipImplicits.*

trait EBmlByteManipIoReExports extends 
   AnyRef
   with ByteManipImplicitsReExports

trait EBmlPrimitivesIoReExports {

   export EBmlPrimitivesIo.*

}

object EBmlPrimitivesIo extends 
   AnyRef
   // with EBmlByteManipIoReExports
   with EBmlBigintsUtilDefs
   with EBmlPrimitivesIoUtilDefs
   with EBmlBigintsIoDefs
   with EBmlBigintsIoDefs.Tested
   with EBmlRbeiops
   with EBmlRawFramesIoDefs
{
   
   //

   opaque type Bytes
      <: AnyRef & Matchable
      // <: IndexedSeq[Byte]
      = IndexedSeq[Byte]


   
   
   
   
   

   //
   



}

trait EBmlPrimitivesMalformationException 
extends java.io.IOException

import deprecatedInheritance as EBmlPrimitivesDefsDeprecatedInheritance

@EBmlPrimitivesDefsDeprecatedInheritance
trait EBmlPrimitivesIoUtilDefs
{
   
   //

   extension (r: java.io.DataInput) {

      /**
       * 
       * `readUpToCond`
       * 
       */
      def readUpToCondEb(p: Byte => Boolean) = {
         r readUpToCond(p)
      }

   }

}

@EBmlPrimitivesDefsDeprecatedInheritance
trait EBmlBigintsIoDefs extends 
   AnyRef
   with EBmlPrimitivesIoUtilDefs
   with EBmlBigintsUtilDefs
{
   
   //



   /**
    * 
    * https://matroska.org/technical/elements.html 
    * https://datatracker.ietf.org/doc/rfc8794/ 
    * 
    */
   extension (r: java.io.DataInput) {

      /**
       * 
       * the "length" (*count of bytes*) as the spec says,
       * 
       * avoid using this method ;
       * this method consumes some input, but does not return/expose enough takeaway from it
       * 
       */
      @deprecated("this method consumes some input, but does not return/expose enough takeaway from it")
      def readEbmlIntegerLength(): Int = {
         val lengthInfoBits = {
            r readUpToCondEb((b: Byte) => ((b: Byte) != 0 ) )
         }
         val lengthInfoBits1 = (
            lengthInfoBits
            .flatMap[Boolean]((b: Byte) => (
               b.intBits8
            ) )
         )
         (lengthInfoBits1 indexWhere((v: Boolean) => v : Boolean ) ) + 1
      }

   }

   /**
    * 
    * https://matroska.org/technical/elements.html 
    * https://datatracker.ietf.org/doc/rfc8794/ 
    * 
    * read an EBML Variable-Width Unsigned Integer
    * 
    * extracted into this independent class,
    * for debugging as-well-as external worksheet usage
    * 
    * may throw `EOFException`, or other `IOException`s
    * 
    */
   @deprecatedInheritance
   // protected 
   // sealed 
   class readEbmlIntegerImpl(r: java.io.DataInput) {
      
      /**
       * 
       * the return-value of `r.newLazyList()`
       * 
       */
      private[readEbmlIntegerImpl]
      val s1 = (
         r.newByteSeq()
      ): LazyList[Byte]

      /**
       * 
       * `s1`
       * 
       * pull bytes until the first non-zero byte
       * 
       */
      val firstNonzeroByteIndex = (
         s1 indexWhere((b: Byte) => ((b: Byte) != 0 ) )
      )
      
      val leadingZeroBitCount = (
         (s1 take (firstNonzeroByteIndex + 1) )
         .toBits
         .indexWhere((v: Boolean) => (v: Boolean) )
      )

      val totalSize = (
         (leadingZeroBitCount + 1 )
         .B
      )

      val dataBitsArity = (
         totalSize.inBytes.toInt
         * 0x7
      )
      
      /**
       * 
       * a BigInt which bitwisely select the excess bits
       * 
       */
      val excessBitsMaskBigInt = (
         (-1 : BigInt) << dataBitsArity
      )

      val bytes = (
         (s1 take totalSize.inBytes.toInt )
         // BUFFER IT
         .toIndexedSeq
      )

      // TODO rid-of the inefficiency
      lazy 
      val bytesCleaned = (
         bytes
         // zero these bits
         .withFirstNBitsTurned(n = (leadingZeroBitCount + 1 ), v = false )
      )
      
   }

   /**
    * 
    * https://matroska.org/technical/elements.html 
    * https://datatracker.ietf.org/doc/rfc8794/ 
    * 
    */
   extension (r: java.io.DataInput) {
      
      /**
       * 
       * EBML Variable-Width ID
       *
       * @param invalidateAllSameBitExamples as the spec reserves certain usages of the all-same-bits instances
       * 
       */
      def readEbmlIdInteger(
         // unsigned: Boolean, 
         invalidateAllSameBitExamples: Boolean ,
      ): BigInt = {
         val analysis1 = (
            readEbmlIntegerImpl(r)
         )
         import analysis1.{bytes, *}
         BigInt(0x1, bytes.toArray )
      }
      
      /**
       * 
       * EBML Variable-Width Unsigned Integer
       *
       * @param unsigned `true`
       * @param invalidateAllSameBitExamples as the spec reserves certain usages of the all-same-bits instances
       * 
       */
      def readEbmlInteger(
         unsigned: Boolean, 
         invalidateAllSameBitExamples: Boolean ,
      ): BigInt = {
         val analysis1 = (
            readEbmlIntegerImpl(r)
         )
         import analysis1.{bytes => _, bytesCleaned => bytes, *}   /* if extracted into class, replace with 'export' */ 
         {
            if (invalidateAllSameBitExamples) {
               validateAwayAllSameBitsExample(bytes = bytes)
            }
            (
               BigInt((bytes ).toArray )
               .&(excessBitsMaskBigInt.unary_~ )
            ) match {
               case v1 =>
                  if (unsigned) {
                     v1
                  } else {
                     (
                     v1
                     /**
                      * zero-ify these bits
                      */
                     .&(~excessBitsMaskBigInt )
                     // //
                     // .`|`((v1 ) & ((excessBitsMaskBigInt >> 0x1 ) ) )
                     /**
                      * loop the left-most bit
                      */
                     .`|`((
                        (v1 : BigInt)
                        .>>(-1 + dataBitsArity ).&(0x1)
                        .*(-1 )
                        .<<(dataBitsArity )
                     ) )
                     // // restore the discarded length-info bit-segm
                     // .`|`((0x1 : BigInt) << (length.inBytes.toInt * 0x7 ) )
                     )
                  }
            }
         } : BigInt
      }

   }

   /**
    * 
    * https://matroska.org/technical/elements.html 
    * https://datatracker.ietf.org/doc/rfc8794/ 
    * 
    */
   extension (r: java.io.DataOutput) {

      def writeEbmlInteger(value: BigInt): Unit = {
         val valBytes = {
            value.toEbmlBytesSc
         }
         r write valBytes.toArray
      }

   }


}
object EBmlBigintsIoDefs {

   trait Tested 
   { this : EBmlBigintsIoDefs =>
        
      //



      private 
      val tested: Unit = {
         Seq[(IndexedSeq[Byte], BigInt)](
            IndexedSeq[Int](0xC0 ).map(_.toByte) -> (0x40 : BigInt) ,
            IndexedSeq[Int](0xA0 ).map(_.toByte) -> (0x20 : BigInt) ,
            IndexedSeq[Int](0xA3 ).map(_.toByte) -> (0x23 : BigInt) ,
            IndexedSeq[Int](0x40, 0 ).map(_.toByte) -> (0 : BigInt) ,
            IndexedSeq[Int](0x60, 0 ).map(_.toByte) -> ((0x20 : BigInt) << 0x8 ) ,
            // IndexedSeq[Int](0x60, 0 ).map(_.toByte) -> (0 : BigInt) ,
            IndexedSeq[Int](0x10, 0, 0, 0 ).map(_.toByte) -> (0 : BigInt) ,
            IndexedSeq[Int](0x04, 0, 0, 0, 0, 0 ).map(_.toByte) -> (0 : BigInt) ,
            IndexedSeq[Int](0x04, 0, 0, 0, 0, 72 ).map(_.toByte) -> (72 : BigInt) ,
            IndexedSeq[Int](0x01, 0, 0, 0, 0, 0, 0, 0x1 ).map(_.toByte) -> (1 : BigInt) ,
         )
         .foreach({

            case (sbs, expectedValue) =>
               val r = (
                  sbs.toNewFd()
               )

               val actualValue = (
                  r.readEbmlInteger(unsigned = true, invalidateAllSameBitExamples = false )
               ): BigInt

               val aevSummary = (
                  s"actual ${actualValue}, expected ${expectedValue}, ${sbs } "
               )
               
               assert(actualValue == expectedValue, aevSummary )

               assert(r.read() == -1 )

               println(aevSummary : String )
               
         })
         Seq[IndexedSeq[Byte]](
            // IndexedSeq[Int](0xFF, 0xFF, 0xFF).map(_.toByte) ,
            // IndexedSeq[Byte](0, 0) ,
            // IndexedSeq[Byte](0, 0, 0x3) ,
         )
         .map(sbs => {
            try {
               sbs.toNewFd()
               .readEbmlInteger(unsigned = false, invalidateAllSameBitExamples = true)
               throw new PF
            } catch {
               case z : (PF | IllegalArgumentException) =>
                  assert(!(z.isInstanceOf[PF]), s"${sbs } unexpectedly passed")
                  z
            }
         })
         .foreach(z => (
            println(z)
         ))
      }

   }

}

@EBmlPrimitivesDefsDeprecatedInheritance
trait EBmlRawFramesReadingIoDefs extends 
   AnyRef
   with EBmlRbeiops
{
   this : (
      AnyRef
      with EBmlBigintsUtilDefs
      with EBmlPrimitivesIoUtilDefs
      with EBmlBigintsIoDefs
      with EBmlRbeiops
   ) =>
   
   
   opaque type EbmRawFrameElement[+C <: String] 
      // <: (C, cbsq.FileSize, cbsq.ByteBlob)
      <: readEbmlFrameImpl
      // = (C, cbsq.FileSize, cbsq.ByteBlob)
      = readEbmlFrameImpl
   
   object EbmRawFrameElement {

      def apply[C <: Singleton & String](v: EbmRawFrameElement[C]): v.type = v

   }

   /**
    * 
    * https://datatracker.ietf.org/doc/rfc8794/ 
    * https://github.com/Matroska-Org/jebml 
    * 
    * an EBML "element" (i'd call them "frames" instead).
    * consists of the three - 
    * `class : BigInt` then `payloadLength : BigInt` then `payload : RawOctetString` .
    * 
    * does not parse the *payload* at all ;
    * a responsibility for caller to do that
    * 
    */
   // protected 
   class readEbmlFrameImpl(r: java.io.DataInput) 
   extends 
   AnyRef
   with Rbeiop
   {
      
      val typeInt = {
         /**
          * 
          * note :
          * `r.readEbmlInteger` would strip the leading "00...1" bits, so
          * those bits will need to be manually restored
          * 
          */
         ({
            try {
               r.readEbmlIdInteger(invalidateAllSameBitExamples = false)
            } catch {
               case z : java.io.EOFException =>
                  /* we haven't got anything yet */
                  throw (
                     // z : java.io.EOFException
                     new java.io.EOFException(s"while computing 'typeInt'")
                  )
            }
         }) 
      }

      val typeAsBytes = (
         (typeInt )
         .bytes
      )

      @deprecated("ill-defined")
      val typeAsUtf = {
         "!e:" + (BigInt(0x1, typeAsBytes.toArray).toString(0x10 ) )
      }
      
      val payloadLength = {
         try (
            r.readEbmlInteger(unsigned = true, invalidateAllSameBitExamples = false)
            .toLong.B
         )
         catch {
            case z : java.io.EOFException =>
               throw (
                  new
                  java.io.IOException(s"malformed - <$typeAsUtf  > - EOF during 'payloadLength'" /* discarding the cause */ )
                  with EBmlPrimitivesMalformationException
               )
         }
      }
      
      val payload = (
         try
            (r readNBytesSc(payloadLength.inBytes.toInt ) )
            .asBlob
         catch {
            case z : java.io.EOFException =>
               throw (
                  new
                  java.io.IOException(s"malformed - <!$typeAsUtf (expectedLength)=$payloadLength> - EOF during 'payload'", z)
                  with EBmlPrimitivesMalformationException
               )
         }
      ) match {
         case e =>
            val (actualLength, expectedLength) = {
               (e.length, payloadLength)
            }
            if (actualLength.inBytes < expectedLength.inBytes ) {
               throw (
                  new
                  java.io.IOException(s"malformed - 'payload' had less size, $actualLength vs $expectedLength " )
                  with EBmlPrimitivesMalformationException
               )
            }
            e
      }

      def payloadNaiveStr = {
         // new String((payload.byteValues).map(_.toChar).toArray )
         BigInt({
            payload.byteValues
            .prepended[Byte](0x10.toByte )
         }.toArray )
         .toString(0x10 )
         .drop(0x2 )
         .prependedAll("(hexdc)")
      }

      override 
      def toString(): String = {
         s"<${typeAsUtf} (length)=${payloadLength }>${payloadNaiveStr.take(0x200) }"
      }
      
   }
   extension (r: java.io.DataInput) {

      /**
       * 
       * read an EBML "element" (i'd call them "frames" instead), the raw payload simply returned.
       * consists of the three - 
       * `class : BigInt` then `payloadLength : BigInt` then `payload : RawOctetString` .
       * 
       * https://github.com/Matroska-Org/jebml 
       * 
       */
      def readEbmlFrameOfPayloadRaw() : EbmRawFrameElement[String] = {
         val analysis1 = (
            readEbmlFrameImpl(r)
         )
         import analysis1.{typeAsUtf }
         import analysis1.{payloadLength, payload }
         // (typeAsUtf, payloadLength, cbsq.ByteBlob.copyOfByteArray(payload.toArray ) )
         analysis1
      }

   }

   {
      Void.TYPE
      println((
         (IndexedSeq[Int](0x40,0x3, 0x80 ).map(_.toByte) ).toNewFd()
         .readEbmlFrameOfPayloadRaw()
      ))
      println((
         (IndexedSeq[Int](0x40,0x3, 0x82, 2, 3 ).map(_.toByte) ).toNewFd()
         .readEbmlFrameOfPayloadRaw()
      ))
      util.Try({
         println((
            (IndexedSeq[Int](0x40,0x3, 0x82, 2 ).map(_.toByte) ).toNewFd()
            .readEbmlFrameOfPayloadRaw()
         ))
      })
      .failed
      .collect({ 
         case z : EBmlPrimitivesMalformationException => 
            println(z) 
      }).get
      println((
         (IndexedSeq[Int](0x80,0x82, 0x3, 2 ).map(_.toByte) ).toNewFd()
         .readEbmlFrameOfPayloadRaw()
      ))
      println((
         (IndexedSeq[Int](0x80,0x82, 0x3, 2, 3 ).map(_.toByte) ).toNewFd()
         .readEbmlFrameOfPayloadRaw()
      ))
   }

}

@EBmlPrimitivesDefsDeprecatedInheritance
trait EBmlRawFramesIoDefs extends 
   AnyRef
   with EBmlRbeiops
   with EBmlRawFramesReadingIoDefs
{
   this : (
      AnyRef
      with EBmlBigintsUtilDefs
      with EBmlPrimitivesIoUtilDefs
      with EBmlBigintsIoDefs
   ) =>

   
   
   extension (r: java.io.DataOutput) {

      /**
       * 
       * push
       * an EBML "element" (i'd call them "frames" instead) ;
       * consists of the three - 
       * `class : BigInt` then `payloadLength : BigInt` then `payload : RawOctetString` .
       * 
       * the logical inverse of `readEbmlFrameOfPayloadRaw` -
       * https://github.com/Matroska-Org/jebml 
       * 
       */
      def writeEbmlFrame(desc : Wrbeiop[?] ) = {
         r writeEbmlInteger(desc.typeInt )
         r writeEbmlInteger(desc.payloadLength.inBytes : BigInt )
         r write((desc.payload).toArray )
      }
   }

   {
      println((
         ((r: java.io.DataOutput) => {
            r.writeEbmlFrame((
               Wrbeiop(typeInt = ((v => v) : ((v: Any) => v.type) )(0x5 : BigInt), payload = (
                  (Int.MaxValue : BigInt)
                  .bytes
                  .asBlob
               ))
            ))
         } )
         .testifyOutput()
      ))
   }

}

@EBmlPrimitivesDefsDeprecatedInheritance
trait EBmlRbeiops
{

   @deprecated("experimental")
   type EbmRawFrameElement[+C <: String]
   
   trait Rbeiop {

      val typeInt : BigInt

      val payload : cbsq.ByteBlob
      val payloadLength : cbsq.FileSize
      
   }

   sealed 
   case class Wrbeiop[
      +SpecificTypeInt <: Singleton & BigInt ,
   ](

      val typeInt   : (SpecificTypeInt    ) ,
      
      val payload   : (cbsq.ByteBlob      ) ,
      
   ) extends  Rbeiop 
   {

      val payloadLength = (
         payload
         .byteValues
         .length
         .B
      )

   }

}

private 
class PF extends Throwable

@main
def ebmlIoImplTest(): Unit = {
   EBmlPrimitivesIo.toString()
   ({
      // 
      import EBmlPrimitivesIo.* 
      ({
         toEbmlBytesSc(-3)
      } : IndexedSeq[Byte]).toNewFd().readEbmlInteger(unsigned = false, invalidateAllSameBitExamples = false)
   })
}




/**
 * 
 * the limited set of the "charset"s 
 * introduced to base the unification in `EBml.Schema`
 * 
 * https://datatracker.ietf.org/doc/rfc8794/ 
 * 
 */
enum EBmlCharset {

   case Utf8
   case AsciiString
   case RawOctetString
   
   case EBmlBigInt
   
}














