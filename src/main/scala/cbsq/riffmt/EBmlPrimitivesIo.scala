package cbsq.riffmt













import byteManipImplicits.*

type EBmlByteManipIoReExports = (
   ByteManipImplicitsReExports
)

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
type EBmlPrimitivesIoUtilDefs = ebmls.SpecialIoUtil

@EBmlPrimitivesDefsDeprecatedInheritance
type EBmlBigintsIoDefsReadBigInt = (
   ebmls.IoDefsReadBigInt
)

@EBmlPrimitivesDefsDeprecatedInheritance
trait EBmlBigintsIoDefs extends 
   AnyRef
   with cbsq.riffmt.ebmls.SpecialIoUtil
   with cbsq.riffmt.ebmls.UtilBigintsUtilDefs
   with cbsq.riffmt.EBmlBigintsIoDefsReadBigInt
   with cbsq.riffmt.ebmls.IoDefsBigIntWriters
   with cbsq.riffmt.ebmls.IoDefsBigIntIo
{
   
   //


}
object EBmlBigintsIoDefs {

   /**
    * 
    * the initialiser should evaluate all these code - 
    * *testing the `EBmlBigintsIoDefs` methods correctness*
    * 
    */
   trait Tested 
   { this : EBmlBigintsIoDefs =>
        
      //



      /**
       * 
       * initialisation of this `val`
       * shall run these code
       * *testing the `EBmlBigintsIoDefs` methods correctness*
       * 
       * why extra (private) `val` ?
       * normally `trait`s should never give its initialiser any side-effects ;
       * however, the way this `trait` is meant to be, 
       * the `trait`'s initialiser shall still do these job anyway
       * 
       */
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
   with EBmlRawFramesReadingIoDefsImpl
{
   this : (
      AnyRef
      with EBmlBigintsUtilDefs
      with EBmlPrimitivesIoUtilDefs
      with EBmlBigintsIoDefs
      with EBmlRbeiops
   ) =>
   
   
   opaque type EbmRawFrameElementReading[+C <: String] 
      <: Rbeiop
      = Rbeiop
   
   opaque type EbmRawFrameElement[+C <: String] 
      // <: (C, cbsq.FileSize, cbsq.ByteBlob)
      // <: readEbmlFrameImpl
      // <: EbmRawFrameElementReading[C]
      <: EbmRawFrameElementReading[C] & Rbeiop
      // = (C, cbsq.FileSize, cbsq.ByteBlob)
      = readEbmlFrameImpl
   
   object EbmRawFrameElement {

      def apply[C <: Singleton & String](v: EbmRawFrameElement[C]): v.type = v

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

      /** 
       * 
       * INVALID/TODO
       * 
       */
      // @annotation.experimental
      // private[riffmt]
      def lazilyReadEbmlFrameOfPayloadRaw(): Rbeiop = {

         val analysis1 = (
            tryReadEbmlFrameImpl(r)
         )
         
         analysis1
      }

   }
   
}

protected
sealed
trait EBmlRawFramesReadingIoDefsImpl extends 
   AnyRef
   // with EBmlRbeiops
{
   this : (
      AnyRef
      with EBmlBigintsUtilDefs
      with EBmlPrimitivesIoUtilDefs
      with EBmlBigintsIoDefs
      with EBmlRbeiops
   ) =>
   
   
   /**
    * 
    * INVALID/TODO
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
   private[riffmt]
   class tryReadEbmlFrameImpl(r: java.io.DataInput) 
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
      private
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
      
      /* technically a `def`, but treated as stable-path */
      export pl.{payloadImpl as payload}

      import ll.bytesLazyL

      override
      def getPaystringItr(): java.io.InputStream = {

         val bytesLlIterator = {
            
            bytesLazyL
            .iterator
            .map(chars => IArray.from(chars) )
         }
         
         bytesLlIterator.newChunkedByteIteratorInputStream()
      }

      ll
      private[tryReadEbmlFrameImpl]
      object ll {

         val bytesLazyLlSrcStream : java.io.DataInput | java.io.InputStream = {
            rBoundedIfNecessary
         }

         val bytesLazyL = {
            rBoundedIfNecessary readNBytesScIncremLl(payloadLength.inBytes.toInt, chunkSize = 1024 )
         }

      }

      (if false then pl) /* disabled as it'd cause synchronous evaluation */
      private[tryReadEbmlFrameImpl]
      object pl {
         
         val payloadImpl = (
            try
               IArray.concat(bytesLazyL.map(s => IArray.from(s) ) : _* ).toIndexedSeq
               .asBlob
            catch {
               
               case z : java.io.EOFException if false =>
                  throw (
                     new
                     java.io.IOException(s"malformed - <!$typeAsUtf (expectedLength)=$payloadLength> - EOF during 'payload'", z)
                     with EBmlPrimitivesMalformationException
                  )

               case z : java.io.EOFException =>
                  throw new java.io.IOException(s"corruptive InputStream implementation", z )

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
         
      }

      private[tryReadEbmlFrameImpl]
      lazy
      val rBoundedIfNecessary: java.io.DataInput | java.io.InputStream = {
         if shallRbinAvoidPreBuffering() then {
            r
         }
         else {
            import cbsq.ByteBlob
            import ByteBlob.boxingImplicits.*
            import language.unsafeNulls
            r.readNBytesSc((payloadLength.inBytes : BigDecimal).toIntExact )
            .asBlob
            .newGrossReader()
         }
      }

      private[riffmt]
      def shallRbinAvoidPreBuffering() : Boolean = {
         true
      }

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

      private[readEbmlFrameImpl] 
      val reading1 = {
         tryReadEbmlFrameImpl(r)
      }

      export reading1.typeInt
      
      val typeAsBytes = (
         (typeInt )
         .bytes
      )

      @deprecated("ill-defined")
      val typeAsUtf = {
         "!e:" + (BigInt(0x1, typeAsBytes.toArray).toString(0x10 ) )
      }
      
      export reading1.payloadLength
      
      val payload = {
         /* force actual reading */
         reading1.payload
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
   
}

trait EBmlRawFramesReadingIoDefsSelfTest
{

   this : (
      AnyRef
      with EBmlBigintsUtilDefs
      with EBmlPrimitivesIoUtilDefs
      with EBmlBigintsIoDefs
      with EBmlRbeiops
      with EBmlRawFramesReadingIoDefs
   ) =>

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
         case z : java.io.EOFException => 
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
   with EBmlRawFramesReadingIoDefsSelfTest
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

   // @deprecated("experimental")
   type EbmRawFrameElementReading[+C <: String]
   
   @deprecated("experimental")
   type EbmRawFrameElement[+C <: String]
      <: EbmRawFrameElementReading[C]
   
   trait Rbeiop {

      val typeInt : BigInt

      val payload : cbsq.ByteBlob

      def getPaystringItr(): java.io.InputStream = {
         payload
         .newGrossReader()
      }

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
export ebmls.{SpecialCharset as EBmlCharset }














