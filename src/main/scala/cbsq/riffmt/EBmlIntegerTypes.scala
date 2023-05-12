package cbsq.riffmt
















import byteManipImplicits.*

import deprecatedInheritance as EBmlPrimitivesDefsDeprecatedInheritance

@EBmlPrimitivesDefsDeprecatedInheritance
trait EBmlBigintsUtilDefs extends 
   AnyRef
{
      
   //


   
   /**
    * 
    * validates that it's not an all-same-bits example
    * 
    */
   // inline 
   def validateAwayAllSameBitsExample(bytes: IndexedSeq[Byte]): Unit = {
         require((
            (
               bytes
               .toBits
               .takeRight(bytes.length * 0x7)
               .toSet
               .toSeq
            ) match {
               case Seq(false | true ) => 
                  false
               case _ => 
                  true
            }
         ), s"reserved all-same-bits syntax, ${bytes }" )
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


}

































