package cbsq.riffmt.ebmls



















protected 
object rbei {
   
   /**
    * 
    * https://datatracker.ietf.org/doc/rfc8794/ 
    * 
    * read an EBML Variable-Width Unsigned Integer
    * 
    * a "note-book" constructor,
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
       * equivalent to `r.newLazyList()`, except that
       * EOF past receiving at-least a byte will be translated into a non-`EOFException` `IOException`
       * 
       */
      private[readEbmlIntegerImpl]
      val s1 = ({
         val c = new java.util.concurrent.atomic.AtomicInteger
         LazyList.continually[Byte]({
            try {
               r.readByte() 
               match { case b => c.incrementAndGet() ; b }
            }
            catch {
               case z : java.io.EOFException =>
                  if c.get() <= 0 then { throw z }
                  else throw new java.io.IOException(s"half-course EOF ; c=${c.get() }", z )
            }
         })
      }): LazyList[Byte]

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
      
      val dataBitsOnlyMaskBigInt = (
         ~(
            (-1 : BigInt)
            .<<(dataBitsArity )
         )
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

}

export rbei.readEbmlIntegerImpl





@EBmlPrimitivesDefsDeprecatedInheritance
trait IoDefsReadBigInt extends 
   AnyRef
{
   
   this : (
      AnyRef
      with cbsq.riffmt.ebmls.SpecialIoUtil
      with cbsq.riffmt.ebmls.UtilBigintsUtilDefs
   ) =>



   /**
    * 
    * https://datatracker.ietf.org/doc/rfc8794/ 
    * 
    * read an EBML Variable-Width Unsigned Integer
    * 
    * a "note-book" constructor,
    * for debugging as-well-as external worksheet usage
    * 
    * may throw `EOFException`, or other `IOException`s
    * 
    */
   // @deprecatedInheritance
   // protected 
   // sealed 
   export cbsq.riffmt.ebmls.readEbmlIntegerImpl

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
               .&(dataBitsOnlyMaskBigInt )
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
                     .&(dataBitsOnlyMaskBigInt )
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


}

















































