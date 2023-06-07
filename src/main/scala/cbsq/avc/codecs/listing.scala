package cbsq.avc.codecs


















@main
def runCodecListingDemo() : Unit = {
   codecListing
   .getAllRegisteredDevices()
   .toSeq
   .map(e => e.toString() )
   .prepended("[")
   .appended("]")
   .foreach(println(_) )
}

// TODO
lazy val codecListing = {

   import cbsq.avc.{*}
   import cbsq.avc.upstream.{*}

   import ewfi.*

   val ewfiCodecTypers = {
      EwfiEmdo()
   }

   import ewfiCodecTypers.*

   import encodedFormsECdl.*

   import encodedFormsEDcei.*

   // new XMediaRawCodecOverview {}

   extension (ctx : XedfMuuxProperties) {

      /**
       * 
       * this excludes the leading `--`.
       * 
       */
      def getMultipartDelimitingPhr() : String = {
         // TODO
         "ffmpeg"
      }

   }
   
   extension (src : java.io.InputStream) {

      def decodeAsMpJpeg(delimiterCPre: String ) = {
         src decodeMpJpegImpl(delimiterCPre = delimiterCPre )
      }

   }

   trait XDemuxingProcHandleOpsBase extends
                        AnyRef
                        with java.io.Closeable
                        // with WithStreams[InDemuxStreamMap { type ChannelIdent <: Int } ]
                        with WithFrameIterator[BbsdAvInterleavedFrameIterator]
   {

      //

   }

   /**
    * 
    * syntactic convenience for 
    * implementing `optionalDecodeFnc` .
    * it's ur responsibility to ensure `mediaKind` matches
    * 
    */
   def newDemuxingProc1(
      src : java.io.InputStream ,
   )(

      mediaKind : MediaKind ,

      submitDecod : java.io.InputStream => BbsdAvFrameIterator ,
      
   ) = {
      ([C <: (
         XDemuxingProcHandleOpsBase

      )] => (a : C ) => (a : a.type ) )({
         
                        ;

                        type S = (
                           BbsdAvFrameIterator
                           & SupportsSwitchingToNextFrame[BbsdAvFrameIterator.IterativeContinuity ]
                           & SupportsCurrentlyPointedFrameTRangeQuery1
                        )

                        val chFrameIterator = {
                           submitDecod(src )
                           match { case s => (s : BbsdAvFrameIterator).asInstanceOf[S] }
                        }

                        new
                        AnyRef
                        with XDemuxingProcHandleOpsBase
                        {
                           
                           override
                           val frameIterator = {
                              // TODO
                              // InDemuxStreamMap.empty[Int, InMuxStream]
                              // .withAddedItem1(
                              //    streamId = 1,
                              //    payload = {
                              //       // chFrameIterator.asInstanceOf[InMuxStream]
                              //       ({ case value : InMuxStream => value } : (Any => InMuxStream) ).andThen(e => e).apply({})
                              //    } ,
                              // )
                              BbsdAvInterleavedFrameIterator.multiplexingAllInSeq(
                                 streamsInitially = IndexedSeq(chFrameIterator) ,
                                 shortestStreamsExtensionalMode = 1 ,
                              )
                           }

                           override
                           def close(): Unit = {
                              src.close()
                           }
                           
                        }
                        
      })
   }

   val allCodecs = (
      Seq()

      :+ {
         getCodecOverviewImpl(
            //
            canonicalNames = Seq("mpjpeg") ,
            encodedFormMimeType = "application/x-libavformat-mpjpeg" ,
            mediaKind = MediaKind.Video ,
            optionalDecodeFnc = {
               // Some({
               //    identity[XTraversiveDecoder]({
                     
               //       case (src : java.io.InputStream, muxProperties) =>
                        
               //          newDemuxingProc1(src)(
               //             mediaKind = MediaKind.Video,
               //             submitDecod = src => { src decodeAsMpJpeg(delimiterCPre = muxProperties.getMultipartDelimitingPhr() ) } ,
               //          )
                        
               //    })
               // })
               None 
            } ,
            optionalEncodingFnc = None ,
         )
      }
      
      :+ {
         getCodecOverviewImpl(
            //
            canonicalNames = Seq("ignorecodec") ,
            encodedFormMimeType = "application/x-scalavfmt-discardallfrominputanddecodenothing" ,
            mediaKind = MediaKind.Video ,
            optionalDecodeFnc = {
               Some({
                  identity[XTraversiveDecoder]({
                     
                     case (src : java.io.InputStream, muxProperties) =>
                        
                        // TODO
                        Predef.???
                        
                  })
               })
            } ,
            optionalEncodingFnc = None ,
         )
      }
      
   )

   // TODO
   new AnyRef with MediaDeviceAttributeTyper1 with CodecExtraOpsProvider1
   {
   
   mce =>

   override
   type MediaDeviceAttribute
      >: XMediaAttribShape
      <: XMediaAttribShape
   
   override
   def getAllRegisteredDevices() = {
      allCodecs
   }

   override
   def getAllRegisteredDemuxers()(using CodecListDependentCtx) = {
      getAllRegisteredDevices()
      .collect({
         case e : XMediaCodecOverview =>
            e
      })
   }

   type MediaDeviceOverview
      >: XMediaDeviceOverview
      <: XMediaDeviceOverview
      
   type MediaCodecOverview
      >: XMediaCodecOverview
      <: XMediaCodecOverview
   
   extension (fmt1 : MediaDeviceOverview ) {

      /**
       * 
       * you'll need to use one of these names
       * to refer to the codec.
       * 
       */
      override
      def getCanonicalNames() : collection.immutable.Iterable[String] = {
         fmt1.canonicalNamesImpl
      }

   }

   extension (fmt1 : MediaCodecOverview ) {

      override
      def getCodecRws(): fmt1.rwModes.type = fmt1.rwModes

   }

   extension (fmt1 : MediaDeviceOverview ) {

      override
      def getCodeAttributesMap() : Map[String, MediaDeviceAttribute ] = {
         fmt1.codeAttribsMap
      }

   }

   extension [P <: MediaDeviceAttribute ](prop : P ) {

      /**
       * 
       * whether
       * it's a obliged/required field in encoded forms
       * (eg typically mux fmts oblige/require video streams to specify framerate)
       * 
       */
      def isRequiredPropertyInEncodedForms() : Boolean = {
         prop.guaranteedExistInEncodedFormImpl
      }

      /**
       * 
       * whether
       * programmes can explicitly specify it when decoding
       * 
       */
      def isCustomisableWhenDecoding() : Boolean = {
         (prop.necessityWhenDecodingImpl.unapply _).unlift
         .isDefinedAt(Some(()) )
      }

      /**
       * 
       * whether
       * programmes can explicitly specify it when encoding
       * 
       */
      def isCustomisableWhenEncoding() : Boolean = {
         (prop.necessityWhenEncodingImpl.unapply _).unlift
         .isDefinedAt(Some(()) )
      }

   }
   
   }
}






































