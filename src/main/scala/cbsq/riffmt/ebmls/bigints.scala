package cbsq.riffmt.ebmls

















/**
 * 
 * https://datatracker.ietf.org/doc/rfc8794/
 * 
 * BigInt -
 * analyse the size of the resulting EBML repr
 * 
 * made this a "note-book" constructor
 * 
 */
class bigIntEbmlSizeAnalyse(value: BigInt) {
   
         ;
         
         /** for computing `dataBitCount` below */
         val dataCompactedBitCount = (
            value
            .bitLength.`+`(0x1)
         )
         
         /**
          * 
          * the EBML valid number of data-bits,
          * necessarily a multiple of `0x7` (as `0x8 - 0x1` ) -- 
          * the smallest one which at-least [[dataCompactedBitCount]]
          * 
          */
         val dataBitCount = (
            collection.View.from(Iterator.from(1) ).map(_ * 0x7 )
            .find(bc => (
               dataCompactedBitCount <= bc
            ))
            .get
         )

         val totalByteCount = ({
            import Integral.Implicits.*
            (
               dataBitCount
               ./%(0x7)
            ) match {
               case (n, 0) =>
                  n
            }
         })

         val dataBitsMask = (
            ~(
               (-1 : BigInt)
               .<<(dataBitCount )
            )
         )

}

/**
 * 
 * https://datatracker.ietf.org/doc/rfc8794/
 * 
 * BigInt -
 * analyse the resulting EBML repr
 * 
 * made this a "note-book" constructor
 * 
 */
class bigIntEbmlFmatting(value: BigInt) {
      
         ;
         
         val allocAnalysis = (
            bigIntEbmlSizeAnalyse(value)
         )
         export allocAnalysis.dataBitCount
         export allocAnalysis.totalByteCount
         export allocAnalysis.dataBitsMask

         val dataBitsOnlyRepr = (

            value

            /**
             * 
             * discard all the other bits
             * 
             */
            .&((
               dataBitsMask
            ))

         )
         
         val finalRepr = (
         (
            dataBitsOnlyRepr
            /**
             * 
             * add the size-bit
             * 
             */
            .`|`((
               (0x1 : BigInt)
               .<<(dataBitCount )
            ))
            
         ) match {
            
            case b =>
               b
               /**
                * 
                * to byte-array ;
                * `.bytes` would normally keep the resulting length at minimum, so
                * it's necessary to add another bit to keep the length, and
                * later drop the leading byte
                * 
                */
               .`|`((
                  (0x1 : BigInt)
                  .<<(totalByteCount * 0x8 )
               ))
               .bytes.drop(0x1)

         } match {
            
            case b =>
               assert(b.length == totalByteCount )
               b

         }
         )
   
}

object bigIntEncodingImplicits
{
   
   /**
    *  
    * `toEbmlBytesScImpl`
    * 
    */
   extension (value: BigInt) {

      /**
       * 
       * formats the BigInt as *EBML variable-length integer* -
       * https://datatracker.ietf.org/doc/rfc8794/  
       * 
       */
      def toEbmlBytesScImpl: IndexedSeq[Byte] = {
         bigIntEbmlFmatting(value)
         .finalRepr
      }

   }

}


/**
 * 
 * defines methods for dealing with it
 * 
 * a `trait`, rather than an `object`,
 * to allow potential overriding
 * 
 */
@EBmlPrimitivesDefsDeprecatedInheritance
trait UtilBigintsUtilDefs extends 
   AnyRef
{
      
   //


   
   export cbsq.riffmt.ebmls.validateAwayAllSameBitsExample

   extension (value: BigInt) {

      /**
       * 
       * formats the BigInt as *EBML variable-length integer* -
       * https://datatracker.ietf.org/doc/rfc8794/
       * 
       * basically the inverse of the reading op
       * 
       */
      def toEbmlBytesSc: IndexedSeq[Byte] = {
         cbsq.riffmt.ebmls.bigIntEncodingImplicits.toEbmlBytesScImpl(value)
      }

   }


}


@EBmlPrimitivesDefsDeprecatedInheritance
trait IoDefsBigIntWriters extends 
   AnyRef
{
   this : (
      AnyRef
      with cbsq.riffmt.ebmls.SpecialIoUtil
      with cbsq.riffmt.ebmls.UtilBigintsUtilDefs
   ) =>



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


































