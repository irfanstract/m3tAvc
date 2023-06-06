package cbsq.avc.upstream






















trait AvProbeCtx
{

   val fileNameQuestion = {
      LateBoundValue.newInstance[String]
   }
   export fileNameQuestion.{value => fileName }

   val encodedFormMimeTypeQuestion = {
      LateBoundValue.newInstance[String]
   }
   def encodedFormMimeType = {
      import AvProbeCtx.getValueOrNull
      encodedFormMimeTypeQuestion
      .getValueOrNull()
   }

   type DetectedCodec
      >: cbsq.avc.McdcTyper#MediaCodecOverview & cbsq.avc.FfCodecTemplateOps
      <: cbsq.avc.McdcTyper#MediaDeviceOverview

   var buf : cbsq.avc.KByteBuffer | Null = {
      null
   }
   
   var bufSize : cbsq.FileSize = compiletime.uninitialized

   val codecLookupSrcQuestion = {
      LateBoundValue.newInstance[CodecListDependentCtx]
   }
   export codecLookupSrcQuestion.{value => codecLookupSrc }
   
}

object AvProbeCtx
{
   
   // @annotation.experimental
   // protected 
   // def notImplemented: Nothing = {
   //    Predef.???
   // }

   extension [A ](q: LateBoundValue.NhwGetValue[A] ) {

      def getValueOrNull(): A | Null = {
         q
         .asFuture
         .value.fold[Null | A ](null)(_.get )
      }

   }

}

trait AvProbeCtxExtras
{

   val cexo : CodecExtraOpsProvider1

   import cexo as codecExtraOps

   def newInstance() : AvProbeCtx = {
      new AnyRef with AvProbeCtx
   }

   // @annotation.experimental
   // protected 
   // def notImplemented: Nothing = {
   //    Predef.???
   // }

   export AvProbeCtx.getValueOrNull

   extension [A <: AvProbeCtx ](this1: A ) {

      /**
       * 
       * 
       * guess the mux format.
       * 
       *
       * @param assumeTheFileAlreadyOpened
       * 
       * 
       */
      def probeInputMuxFmt(
         assumeTheFileAlreadyOpened: Boolean ,
         
      ) = {

         var score: Int = 0

         this1
         .probeInputMuxFmt2(
            
            assumeTheFileAlreadyOpened = assumeTheFileAlreadyOpened ,

            maxScore = score ,
            updateMaxScoreTo = v => { score = v } ,
            
         )
      }

      /**
       * 
       * 
       * guess the mux format.
       * afterwards,
       * `updateMaxScoreTo` will be invoked with the final score .
       * 
       *
       * @param assumeTheFileAlreadyOpened
       * 
       * @param maxScore
       *    in order to be accepted
       *    the final score will need to exceed this value.
       *    afterwards,
       *    `updateMaxScoreTo` will be invoked with the final score
       * 
       * @param updateMaxScoreTo
       *    afterwards,
       *    `updateMaxScoreTo` will be invoked with the final score
       * 
       * 
       */
      def probeInputMuxFmt2(
         assumeTheFileAlreadyOpened: Boolean ,
         maxScore: => Int ,
         updateMaxScoreTo: Int => Unit ,
         
      ): this1.DetectedCodec | Null = {

         var finalScore: Int = 0

         val fmt = {
            this1
            .probeInputMuxFmt3(
               assumeTheFileAlreadyOpened = assumeTheFileAlreadyOpened ,
               propagateFinalScore = v => { finalScore = v } ,
            )
         }

         if maxScore < finalScore then
            updateMaxScoreTo(finalScore)
            fmt
         else null
         
      }

   }

   extension [A <: AvProbeCtx ](lpd: A ) {

      /**
       * 
       * 
       * guess the mux format.
       * afterwards,
       * `propagateFinalScore` will be invoked with the final score .
       * 
       *
       * @param assumeTheFileAlreadyOpened
       * 
       * @param propagateFinalScore
       *    afterwards,
       *    this will be invoked with the final score
       * 
       * 
       */
      def probeInputMuxFmt3(
         assumeTheFileAlreadyOpened: Boolean ,
         propagateFinalScore: Int => Unit ,
         
      ): lpd.DetectedCodec | Null = {

         // var fmt1 : lpd.DetectedCodec | Null = null

         var fmt : lpd.DetectedCodec | Null = null

         var scoreMax: Int = 0
         var score   : Int = -3

         val zeroesBuf = {
            cbsq.avc.KByteBuffer.allocate(len = stdPaddingSizeInBytes : Int )
         }

         enum Nodat {
            case whenNoId3
            case whenId3AlmostGreaterProbe
            case whenId3GreaterProbe
            case whenId3GreaterMaxProbe
         }

         var nodat: Nodat = {
            Nodat.whenNoId3
         }

         import cbsq.FileSize.boxingImplicits.*

         given CodecListDependentCtx = {
            lpd.codecLookupSrc
         }

         if lpd.buf == null then {
            lpd.buf = {
               zeroesBuf
            }
         }

         if (
            10.B < lpd.bufSize
            &&
            id3V2I.matches(lpd.buf.nn, notImplemented : String)
         ) then {
            val id3Len = {
               id3V2I.getTagLength(lpd.buf.nn )
            }
            if (id3Len + 16.B < lpd.bufSize ) then {
               if lpd.bufSize < (2 * id3Len.inBytes + 16 ).B then {
                  nodat = Nodat.whenId3AlmostGreaterProbe
               }
               ({ import language.unsafeNulls ; lpd.buf     = lpd.buf     +  id3Len.inBytes.toInt  })
               ({ import language.unsafeNulls ; lpd.bufSize = lpd.bufSize + -id3Len                })
            }
            else
            if (getProbeBufMaxSize1() < id3Len ) then {
               nodat = Nodat.whenId3GreaterMaxProbe
            }
            else {
               nodat = Nodat.whenId3GreaterProbe
            }
         }

         /**
          * 
          * ```
          * while ((fmt1 = av_demuxer_iterate(&i)))
          * ```
          * 
          */
         breakably(break1 => (for fmt1 <- {
            getAllRegisteredDemuxers()
            
         } do breakably(skip1 => {

            if (fmt1.isExperimentalDevice ) then
               skip1
            if (
               !assumeTheFileAlreadyOpened == !fmt1.isMuxFnf
               &&
               { false } // TBD ; in `libavformat` this was `strcmp(fmt1->name, "image2")`
            ) then
               skip1

            score = 0

            breakably(doneC => {
               ;

               for (readProbe <- fmt1.readProbeOptional ) {
                  score = {
                     readProbe(lpd )
                  }
                  if (0 < score ) {
                     // TODO do av_log
                  }
                  if ({
                     fmt1.fileExtensions1Optional
                     .fold[Boolean](false)(fileExtensions1 => {
                        fileExtensions1 exists (lpd.isNameOfFileExtension _ )
                     })
                  }) {
                     nodat match

                        case Nodat.whenNoId3 => 
                           score = ffMax(score, 1 )
                           break1

                        case Nodat.whenId3GreaterProbe | Nodat.whenId3AlmostGreaterProbe =>
                           score = ffMax(score, AVPROBE_SCORE.ofFileNameExtensions / 2 + -1 )
                           break1

                        case Nodat.whenId3GreaterMaxProbe =>
                           score = ffMax(score, AVPROBE_SCORE.ofFileNameExtensions )
                           break1
                     
                  }

                  doneC
               }

               for (fileExtensions1 <- {
                  fmt1.fileExtensions1Optional
               }) {
                  // TODO
                  if fileExtensions1 exists (lpd.isNameOfFileExtension _ ) then {
                     score = {
                        AVPROBE_SCORE.ofFileNameExtensions
                     }
                  }

                  doneC
                  
               }

            })

            if ((
               lpd.encodedFormMimeType
               == Option(fmt1.encodedFormMimeType).getOrElse("application/x-scalavfmt-avpb-no-mimetype") 
            )) {
               if (score < AVPROBE_SCORE.ofMimeTypeMatch ) {
                  // TODO logging
                  score = AVPROBE_SCORE.ofMimeTypeMatch
               }
            }

            if (scoreMax < score ) {
               scoreMax = score
               fmt = fmt1
            }
            else
            if (score == scoreMax) {
               fmt = null
            }

            // notImplemented

         } ) ) )

         if nodat == Nodat.whenId3GreaterProbe then {
            scoreMax = ffMin(AVPROBE_SCORE.ofFileNameExtensions / 2 + -1, scoreMax)
         }
         propagateFinalScore(scoreMax )

         // notImplemented

         return fmt
         
      }

   }

   extension [A <: AvProbeCtx ](lpd: A ) {

      def isNameOfFileExtension(ext: String) : Boolean = {
         lpd.fileName endsWith ext
      }

   }

   export codecExtraOps.getAllRegisteredDemuxers

   export codecExtraOps.isExperimentalDevice

   export codecExtraOps.isMuxFnf

   export codecExtraOps.fileExtensions1Optional

   extension [
      C <: cbsq.avc.McdcTyper#MediaDeviceOverview & cbsq.avc.MediaCodecProperties ,
   ](fmt1 : C ) {

      def readProbeOptional : Option[AvProbeCtx => Int ] = {
         notImplemented
      }
      
   }

   private
   final
   lazy
   val AVPROBE_SCORE : predefinedScores.type = {
      predefinedScores
   }

   object predefinedScores {
      
         lazy val maxValue = 100

         val ofFileNameExtensions: Int = 50

         val ofMimeTypeMatch: Int = 75

         lazy val ofRetry = maxValue / 4

         lazy val ofStreamRetry = (maxValue / 4 ) + -1

   }

   export math.{
      max => ffMax ,
      min => ffMin ,
   }

   lazy 
   val stdPaddingSizeInBytes: Int = {
      32
   }
   def getProbeBufMaxSize1() : cbsq.FileSize = {
      notImplemented
   }

   extension [A <: PerMuuxIoCtxOps ](this1: A ) {

      def probeInputBuffer2(

         offset : cbsq.FileSize ,
         maxProbeSize : cbsq.FileSize ,
         
      ): Unit = {

         val probingCtx = {
            notImplemented
         } : AvProbeCtx

         var probeOffset : cbsq.FileSize = {
            import cbsq.FileSize.boxingImplicits.*
            0.B
         }

         var buf : java.nio.ByteBuffer = {
            import language.unsafeNulls
            java.nio.ByteBuffer.allocate(0x8000 ) // TODO
         }

         var probeScore : Int = {
            0
         }

         notImplemented
         
      }

   }

}











































































































