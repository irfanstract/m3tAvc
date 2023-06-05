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

   import ewfi.*

   import cbsq.avc.{*}
   import cbsq.avc.upstream.{*}

   trait XMediaDeviceOverview extends
   AnyRef
      with MediaDeviceProperties
      with MediaDeviceBeingAtSpecificInstancingLevel
      with mdoParamBuilders.ArgsAndTheirBuildability
      with MediaDeviceArgsAndInstancing1
      with TPossiblySupportsEvents
      with FfMediaDvcTemplateOps
   {

      val instancingLevel: cbsq.avc.MediaDeviceInstancingLevel = {
         cbsq.avc.MediaDeviceInstancingLevel.ofCompleteCodecSpace
      }
      
      lazy val events: cbsq.avc.tsevp.EventIterator[EventInfo] = {
         cbsq.avc.tsevp.newEventEmitter[EventInfo]()
         ._2
      }

      val canonicalNamesImpl : collection.immutable.Iterable[String]

      /**
       * 
       * certain devices or codecs are read-only :
       * - Camera Devices and D3D Grabbing are capture-only
       * - Frame-Checksum are encode-only
       * 
       */
      val rwModes : Set[? <: ("r" | "w") ]

      lazy 
      val codeAttribsMap : Map[String, XMediaAttribShape] = {
         Map()
      }

      val argsInitially: Args = {
         "fail:"
      }

   }
   
   trait XMediaCodecOverview extends
   AnyRef
      with XMediaDeviceOverview
      with MediaCodecPropertiesMixin
      with MediaDeviceBeingAtSpecificInstancingLevel
      with mcdcParamBuilders.ArgsAndTheirBuildability
      with MediaDeviceArgsAndInstancing1
      with TPossiblySupportsEvents
      with FfCodecTemplateOps
   {

   }
   
   trait XMediaRawCodecOverview extends
   AnyRef
      with XMediaCodecOverview
      with FfRawStreamCodecTemplateOps
   {

   }
  
   trait XMediaAttribShape {

      val guaranteedExistInEncodedFormImpl : Boolean

      val necessityWhenDecodingImpl : NecessityTest

      val necessityWhenEncodingImpl : NecessityTest
      
   }

   import encodedFormsECdl.XRRW

   import encodedFormsEDcei.XedfMuuxProperties

   trait XEFDoSpawnStringOr extends 
      AnyRef
      with MediaDeviceProperties
      with MediaDeviceArgsAndInstancing1
   {
      this : (
         AnyRef
         with XMediaRawCodecOverview
      ) =>

      //

      override
      def spawn(args: Args) = {
         ;

         import language.unsafeNulls

         args match {

         case args : (String | java.net.URI) =>
            spawnStringOrUrlAddressedInstance(args)

         case input : (java.io.InputStream | java.io.Reader ) =>
            require(rwModes.filter(_ == "r").nonEmpty, s"codec/device does not support decoding. ($input)" )
            spawnDecoding(input)

         case output : (java.io.OutputStream | java.io.Writer ) =>
            require(rwModes.filter(_ == "w").nonEmpty, s"codec/device does not support encoding. ($output)" )
            spawnEncoding(output)

         }
      }

      def convertStringArgToUrl(args : String) : java.net.URI = {
         
            import language.unsafeNulls

            // TODO
            new java.net.URI(args)

      }

      def spawnStringOrUrlAddressedInstance(args : String | java.net.URI): Instance = {
         
            import language.unsafeNulls

            val url = {

               args match {

                  case url : java.net.URI =>
                     url

                  case args : String =>
                     // TODO
                     convertStringArgToUrl(args)
                     
               }
               
            } : java.net.URI

            spawnUrlAddressedInstance(url)

      }

      def spawnUrlAddressedInstance(url : java.net.URI): Instance = {
         
            import language.unsafeNulls

            url.toString() match {

               case FfRawStreamCodecTemplateOps.ReadingOrWritingUrl(dir @ ("read" | "write"), url0) =>
                  val url = new java.net.URI(url0 )
                  dir match {
                     case "read" =>
                        spawnDecoding(url.toURL().openStream() )
                     case "write" =>
                        spawnEncoding(url.toURL().openConnection().getOutputStream() )
                  }
               
            }

      }

      def spawnDecoding(
         input : XRRW["r"],
         fmtProperties: XedfMuuxProperties = new XedfMuuxProperties ,
         
      ): Instance

      def spawnEncoding(
         output : XRRW["w"],
         fmtProperties: XedfMuuxProperties = new XedfMuuxProperties ,
         
      ): Instance

   }

   /**
    * 
    * overrides `mediaKind` and `encodedFormMimeType`
    * 
    */
   trait XEFM[
      +M <: Singleton & MediaKind ,
      +EM <: Singleton & String ,
   ](
      val mediaKind : M ,

      val encodedFormMimeType : EM ,
      
   ) extends MediaCodecPropertiesMixin
   {
      //
   }

   import encodedFormsECdl.*

   import encodedFormsEDcei.*

   /**
    * 
    * quick `MediaCodecOverview` impl with given properties
    * 
    */
   def getCodecOverviewImpl(
      //

      canonicalNames: collection.immutable.Iterable[String] ,

      encodedFormMimeType : String ,
      
      mediaKind : MediaKind ,

      optionalDecodeFnc : Option[XLazyDecodingFnc | XEagerDecodingFnc ] ,
      
      optionalEncodingFnc : Option[XEagerEncodingFnc | XLazyEncodingFnc ] ,

   ) = {

      new
      AnyRef
      with XMediaRawCodecOverview
      with XEFM(mediaKind = mediaKind, encodedFormMimeType = encodedFormMimeType )
      with XEFDoSpawnStringOr
      {

         val canonicalNamesImpl: canonicalNames.type = canonicalNames

         val rwModes = {
            Seq(
               optionalDecodeFnc.map["r"](_ => "r" ) ,
               optionalEncodingFnc.map["w"](_ => "w" ) ,
            )
            .flatten["r" | "w"]
            .toSet
         }

         override
         def toString(): String = {
            s"MediaDevice[is_codec: ${this.isInstanceOf[MediaCodecProperties] }; ${this.encodedFormMimeType }; ${rwModes } ]"
         }

         override
         type Instance
            >: XDecoderInstance | XEncoderInstanceOps
            <: XDecoderInstance | XEncoderInstanceOps

         lazy
         val applyDc = {
            optionalDecodeFnc
            .collect({
               case e : XLazyDecodingFnc =>
                  e
            })
            .getOrElse(throw new java.io.IOException(s"codec doesn't support decoding") )
            
         } : XLazyDecodingFnc

         lazy 
         val applyEnc = {
            optionalEncodingFnc
            .collect({

               case e : XEagerEncodingFnc =>
                  e

               case originalFnc : XLazyEncodingFnc =>
                  originalFnc.eagerForm

            })
            .getOrElse(throw new java.io.IOException(s"codec doesn't support decoding") )
            
         } : XEagerEncodingFnc

         override
         def spawnDecoding(input : XRRW["r"], fmtProperties: XedfMuuxProperties): XDecoderInstance = {

               applyDc(input, fmtProperties )

         }

         override
         def spawnEncoding(output : XRRW["w"], fmtProperties: XedfMuuxProperties ): XEncoderInstanceOps = {

               import concurrent.ExecutionContext.Implicits.*

               new java.io.Closeable with XEncoderInstanceOps {

                  val decodedFormQuestion = {
                     LateBoundValue.newInstance[BbsdAvFrameIterator]
                  }

                  // export decodedFormQuestion.{value as decodedForm }
                  
                  decodedFormQuestion.asFuture
                  .map(decodedForm => {
                     applyEnc(decodedForm, fmtProperties, output )
                  })

                  override
                  def close(): Unit = {
                     output
                     .close()
                  }

                  def encodend_=(value : BbsdAvFrameIterator ) = {
                     decodedFormQuestion success value
                  }

               }

         }

      }

   }

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
         ;

         import cbsq.avc.quick.rmpdUtils

         val pItr = {
            import rmpdUtils.{decodeMimeMultipartStream => decodeMultipartStream }
            src decodeMultipartStream(delimitingLinePre = delimiterCPre )
         }
         
         val pc = {
            val impl = cbsq.avc.codecs.asFrameItrImpl(srcE = pItr )
            impl.giveRealTimeRate()
            impl.mediaType_=(MediaKind.Video )
            impl
         }

         pc.decodingItr
         
      }

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
               Some({
                  identity[XLazyDecodingFnc]({
                     
                     case (src : java.io.InputStream, muxProperties) =>
                        new AnyRef with java.io.Closeable with WithFrameIterator[BbsdAvFrameIterator]
                        {
                           
                           val frameIterator = {
                              src decodeAsMpJpeg(delimiterCPre = muxProperties.getMultipartDelimitingPhr() )
                           }

                           override
                           def close(): Unit = {
                              src.close()
                           }
                           
                        }
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






































