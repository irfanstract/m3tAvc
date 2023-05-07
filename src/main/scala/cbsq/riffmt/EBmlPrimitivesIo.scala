package cbsq.riffmt













trait EBmlPrimitivesIoImports {

   export EBmlPrimitivesIo.*

}

object EBmlPrimitivesIo
{
   
   import byteManipImplicits.*


   
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
         totalSize.bytes.toInt
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
         (s1 take totalSize.bytes.toInt )
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
               require((
                  bytes.toBits.toSet[Boolean].toSeq match {
                     case Seq(false | true ) => 
                        false
                     case _ => 
                        true
                  }
               ), s"reserved all-same-bits syntax, ${bytes }" )
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
                     // .`|`((0x1 : BigInt) << (length.bytes.toInt * 0x7 ) )
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

   /**
    * 
    * basically the inverse of the reading op
    * 
    */
   extension (value: BigInt) {

      def toEbmlBytesSc: IndexedSeq[Byte] = {
         (
            value
            .bytes
            .prepended[Byte]((value.signum match { case -1 => -1 ; case _ => 0 }).toByte )
         ) match {
            case vb =>
               identity(())
               (
                  (
                     value
                     // discard the leftmost n bits
                     .&((
                        (-1 : BigInt)
                        .<<((vb.length * 0x8 ).`-`(vb.length ) )
                        //
                        .unary_~
                     ) )
                     // `1`-ify that one bit
                     .|((0x1 : BigInt) << ((vb.length ) * 0x7) )
                  )
                  // .`|`((vb(0).toInt : BigInt ) << ((0x8).`*`(vb.length ).`+`(-1 ) ) )
                  .bytes
               )
         }
      }

   }

   implicit def eib[CC[A] <: collection.SeqOps[A, CC, CC[A] ] ](src: CC[Byte]): (
      AnyRef
      & I0LdB[CC[Byte] ]
   ) = {
      (
         new 
         AnyRef with Selectable 
         with I0LdB[CC[Byte] ]
         {
            
            def withFirstNBitsTurned(zlbN: Int, newV: Boolean): CC[Byte] = {
               src
                  // EXPAND INTO BIT-SEQ
                  .toBits
                  // REPLACE THESE N BITS
                  .drop(zlbN )
                  .prependedAll(IndexedSeq.fill[Boolean](zlbN )(newV: Boolean) )
                  // CONVERT INTO BYTE-SEQ
                  .toBytes
            }

         }
      )
   }
   trait I0LdB[+R] {
      def withFirstNBitsTurned(n: Int, v: Boolean): R
   }

   {
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

   opaque type EbmElement[+C <: String] 
      // <: (C, cbsq.FileSize, cbsq.ByteBlob)
      <: readEbmlElementImpl
      // = (C, cbsq.FileSize, cbsq.ByteBlob)
      = readEbmlElementImpl
   
   object EbmElement {

      def apply[C <: Singleton & String](v: EbmElement[C]): v.type = v

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
    */
   // protected 
   class readEbmlElementImpl(r: java.io.DataInput) 
   extends 
   AnyRef
   with Rbeiop
   {
      
      val typeInt = (
         r.readEbmlInteger(unsigned = true, invalidateAllSameBitExamples = false)
      )

      val typeAsBytes = (
         (typeInt )
         .bytes
      )

      @deprecated("ill-defined")
      val typeAsUtf = {
         // import java.nio.charset.{Charset, StandardCharsets}
         // new String((
         //    typeAsBytes
         //    .map((_.toChar) : (Byte => Char ) )
         // ).toArray )
         "C#" + (BigInt(0x1, typeAsBytes.toArray).toString(0x10 ) )
      }
      
      val payloadLength = (
         r.readEbmlInteger(unsigned = true, invalidateAllSameBitExamples = false)
         .toLong.B
      )
      
      val payload = (
         r.readNBytesSc(payloadLength.bytes.toInt )
      )

      def payloadNaiveStr = {
         new String(payload.map(_.toChar).toArray )
      }

      override 
      def toString(): String = {
         s"<${typeAsUtf} (length)=${payloadLength }>${payloadNaiveStr.take(0x200) }"
      }
      
   }
   extension (r: java.io.DataInput) {

      @deprecated("is 'readEbmlFrame' ")
      transparent inline
      def readEbmlElement() = {
         r.readEbmlFrame()
      }

      /**
       * 
       * an EBML "element" (i'd call them "frames" instead).
       * consists of the three - 
       * `class : BigInt` then `payloadLength : BigInt` then `payload : RawOctetString` .
       * 
       * https://github.com/Matroska-Org/jebml 
       * 
       */
      def readEbmlFrame() : EbmElement[String] = {
         val analysis1 = (
            readEbmlElementImpl(r)
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
         .readEbmlElement()
      ))
      println((
         (IndexedSeq[Int](0x40,0x3, 0x82, 2, 3 ).map(_.toByte) ).toNewFd()
         .readEbmlElement()
      ))
      util.Try({
         println((
            (IndexedSeq[Int](0x40,0x3, 0x82, 2 ).map(_.toByte) ).toNewFd()
            .readEbmlElement()
         ))
      })
      .failed
      .collect({ case z : java.io.EOFException => z })
      .get
      println((
         (IndexedSeq[Int](0x80,0x82, 0x3, 2 ).map(_.toByte) ).toNewFd()
         .readEbmlElement()
      ))
      println((
         (IndexedSeq[Int](0x80,0x82, 0x3, 2, 3 ).map(_.toByte) ).toNewFd()
         .readEbmlElement()
      ))
   }

   trait Rbeiop {

      val typeInt : BigInt

      val payload : IndexedSeq[Byte]
      val payloadLength : cbsq.FileSize
      
   }

   sealed 
   case class Wrbeiop[
      +SpecificTypeInt <: Singleton & BigInt ,
   ](

      val typeInt   : (SpecificTypeInt    ) ,
      val payload   : (IndexedSeq[Byte]   ) ,
      
   ) extends  Rbeiop 
   {

      val payloadLength = (
         payload
         .length
         .B
      )

   }

   extension (r: java.io.DataOutput) {

      /**
       * 
       * push
       * an EBML "element" (i'd call them "frames" instead) ;
       * consists of the three - 
       * `class : BigInt` then `payloadLength : BigInt` then `payload : RawOctetString` .
       * 
       * the logical inverse of `readEbmlFrame` -
       * https://github.com/Matroska-Org/jebml 
       * 
       */
      def writeEbmlFrame(desc : Wrbeiop[?] ) = {
         r writeEbmlInteger(desc.typeInt )
         r writeEbmlInteger(desc.payloadLength.bytes : BigInt )
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
               ))
            ))
         } )
         .testifyOutput()
      ))
   }




   private 
   class PF extends Throwable
   
}

@main
def ebmlIoImplTest(): Unit = {
   EBmlPrimitivesIo.toString()
   ({
      import byteManipImplicits.* 
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
   
}














