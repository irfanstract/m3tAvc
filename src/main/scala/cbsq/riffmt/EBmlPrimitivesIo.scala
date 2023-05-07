package cbsq.riffmt













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
       */
      @deprecated("this will by-definition discard the necessary bits")
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
         /**
          * 
          * the return-value of `r.newLazyList()`
          * 
          */
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
         val length = (
            (leadingZeroBitCount + 1 )
            .B
         )
         val bytes = (
            // TODO
            (s1 take length.bytes.toInt )
            // BUFFER IT
            .toIndexedSeq
            // zero these bits
            .withFirstNBitsTurned(n = (leadingZeroBitCount + 1 ), v = false )
         )
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
         }
         /**
          * The VINT_DATA value MUST be expressed as a big-endian unsigned integer.
          */
         {
            val excessBitsMaskBigInt = (
               (-1 : BigInt) << (length.bytes.toInt * 0x7 )
            )
            (
               BigInt((bytes ).toArray )
               .&(excessBitsMaskBigInt.unary_~ )
            ) match {
               case v1 =>
                  if (unsigned) {
                     v1
                  } else {
                     v1
                     // drop the other bits
                     .&((excessBitsMaskBigInt.unary_~ ) )
                     // //
                     // .`|`((v1 ) & ((excessBitsMaskBigInt >> 0x1 ) ) )
                     // restore the discarded sign-bit
                     .`|`((
                        (v1 : BigInt)
                        .>>((length.bytes.toInt * 0x7 ).+(-1 ) )
                        .&(0x1)
                        .*(-1 )
                        .<<(length.bytes.toInt * 0x7 )
                     ) )
                     // // restore the discarded length-info bit-segm
                     // .`|`((0x1 : BigInt) << (length.bytes.toInt * 0x7 ) )
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

   opaque type EbmElement[+C <: String] 
      <: (C, cbsq.FileSize, cbsq.ByteBlob)
      = (C, cbsq.FileSize, cbsq.ByteBlob)
   
   object EbmElement {

      def apply[C <: Singleton & String](v: EbmElement[C]): v.type = v

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

   /**
    * 
    * https://datatracker.ietf.org/doc/rfc8794/ 
    * https://github.com/Matroska-Org/jebml 
    * 
    */
   extension (r: java.io.DataInput) {

      def readEbmlElement() : EbmElement[String] = {
         val typeInt = (
            r.readEbmlInteger(unsigned = true, invalidateAllSameBitExamples = false)
         )
         val `type` = {
            import java.nio.charset.{Charset, StandardCharsets}
            new String((typeInt ).toByteArray.map(v => v.toChar) )
         }
         val payloadLength = (
            r.readEbmlInteger(unsigned = true, invalidateAllSameBitExamples = false)
            .toLong.B
         )
         val payload = (
            r.readNBytesSc(payloadLength.bytes.toInt )
         )
         (`type`, payloadLength, cbsq.ByteBlob.copyOfByteArray(payload.toArray ) )
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














