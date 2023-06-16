package cbsq.riffmt























object ebmlSchemesUtilChronography
{
   
            export  concurrent.duration.{Deadline, Duration, FiniteDuration }

            export  concurrent.duration.{DurationDouble, DurationLong, DurationInt }

            import  System.currentTimeMillis

            export cbsq.riffmt.epochChronography.forAmtSinceEpoch

            /** 
             * 
             * `Deadline(0.seconds)`
             * 
             */ 
            val deadlineZero = (
               Deadline(0.second)
            )
            
            /**
             * 
             * the EBML RFC/spec 
             * defines this to be `the 1st of January 2001, 00:00`
             * 
             */
            val globalBaseDate = (
               {
                  locally {
                     // TODO
                     forAmtSinceEpoch((
                        ((2001 - 1970 ) * ((365.25 * 86400 ).toDouble + 0.5 ) )
                        .toLong
                        .second
                     ) )
                  }
               }
            ) : concurrent.duration.Deadline

}

// def ***%(e: EBmlByteManipIoReExports) = {
//    e.isAtEof()
//    object eio {
//       export byteManipImplicits.isAtEof
//    }
//    eio.isAtEof()
//    byteManipImplicits.isAtEof()
// }
// def ***%@(e: EBmlPrimitivesIoReExports) = {
//    e.isAtEof()
// }

protected 
object ebmlSchemesPrimitivesIo
{
      //
   
      /**
       * 
       * the EBML RFC/spec 
       * defines this to be `the 1st of January 2001, 00:00`
       * 
       */
      export ebmlSchemesUtilChronography.globalBaseDate

      export ebmsGenericUtils.readNBytesEbmSc

      extension (r: java.io.InputStream | java.io.DataInput) {

         /**
          * 
          * reads and interprets EBml Date Fmt as specified
          *
          * @param supposedReadingLength the exact expected number of bytes
          * 
          */
         def readEbmlDateBytes(
            //
            
            supposedReadingLength: Long ,
            
         ): concurrent.duration.Deadline = {

            import  concurrent.duration.*

            val parsedValue = (
               // TODO
               {
                  
                  val rawBytes = ({
                     
                     r readNBytesEbmSc(supposedReadingLength.toInt )
                  })

                  BigInt(rawBytes.toArray )
               }
            ) : BigInt

            globalBaseDate `+` (
               // TODO
               (parsedValue )
               .toLong.nanoseconds
            )

         }
         
      }

}

/**
 * 
 * `EBml.CodeSchemeOps` shall `extends` this `trait`
 * 
 */
protected trait chvl extends 
   AnyRef 
{
   
      import language.unsafeNulls /* due to the extended usage of non-Scala API(s) */
      
      /**
       * 
       * extending `Singleton` is necessary,
       * so that the inferred types become the exact argument value types
       * 
       * ```
       * applyRelevantMod(mode = 3)
       * ```
       * 
       */
      type S[+T] = Singleton & T

      export ebmsGenericUtils.Lze

      export ebmsGenericUtils.Lazy
 
      /**
       * 
       * the EBML RFC/spec 
       * defines this to be `the 1st of January 2001, 00:00`
       * 
       */
      export ebmlSchemesUtilChronography.globalBaseDate

      export ebmsGenericUtils.readNBytesEbmSc

      export ebmlSchemesPrimitivesIo.readEbmlDateBytes

      /**
       * 
       * a specia-value denoting "can be any length"
       * 
       */
      case object cHasVariableLength

      object cStdDataTypeSizingUtil {

         import byteManipImplicits.*

         def getLengthOfDataType[C](c: reflect.ClassTag[C]): cHasVariableLength.type | cbsq.FileSize = {
            import reflect.ClassTag.*
            val bigIntClassTag = reflect.classTag[BigInt     ]
            val bigDcmClassTag = reflect.classTag[BigDecimal ]
            val dcdClassTag = reflect.ClassTag[concurrent.duration.Deadline]
            c match
               
               case Unit  => 0.B

               case Byte  => ( 0x01).B
               case Char  => ( 0x02).B
               case Short => ( 0x02).B
               case Int   => ( 0x04).B
               case Long  => ( 0x08).B

               case `bigIntClassTag` => cHasVariableLength

               case Float   => ( 0x04).B
               case Double  => ( 0x08).B

               case `bigDcmClassTag` => cHasVariableLength

               case `dcdClassTag` => (0x08 ).B

            
         }

      }

}

// protected 
object ebmsGenericUtils extends 
   AnyRef 
   // with EBmlByteManipIoReExports
   // with EBmlPrimitivesIoReExports
{
      ;
      
      export cbsq.riffmt.ebmls.Lze

      export cbsq.riffmt.ebmls.Lazy
 
      export avcframewrk.util.Eagerness

      extension (v: String) {

         // TODO
         def utfEncodedAsUrl: java.net.URI = {

            import avcframewrk.util.encodedAsUrl

            import language.unsafeNulls

            v.encodedAsUrl

         }
         
      }
      
      extension (b: cbsq.ByteBlob) {
         
         def encodedAs(enc: EBmlCharset): cbsq.ByteBlob | java.net.URI = {
               ;
               
               import language.unsafeNulls

               enc match {
                  
                  case EBmlCharset.EBmlBigInt => 
                     // TODO
                     // BigInt(b.byteValues.toArray )
                     // .toString()
                     b
                  
                  case EBmlCharset.RawOctetString => 
                     b
                     
                  case EBmlCharset.Utf8 => 
                     new String(b.byteValues.toArray, java.nio.charset.StandardCharsets.UTF_8 ).utfEncodedAsUrl
                  case EBmlCharset.AsciiString => 
                     new String(b.byteValues.toArray, java.nio.charset.StandardCharsets.US_ASCII ).utfEncodedAsUrl
                     
               }
               
         }

      }

      export cbsq.riffmt.byteManipImplicits.readNBytesEbmSc

      import byteManipImplicits.newMarkResetTurn

      import byteManipImplicits.MarkableInputStreamImpl

      export byteManipImplicits.checkNotAtEof

      {

         @throws[java.io.EOFException]
         def checkNotAtEof(): Unit = {

         }

      }

}

protected 
object ebsr
{

   export avcframewrk.util.controlFlow.breakablyGet

   {

      //

   }

   export avcframewrk.util.controlFlow.breakably

   {

      //
      
   }

}


































