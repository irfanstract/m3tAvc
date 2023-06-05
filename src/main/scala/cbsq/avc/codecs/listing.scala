package cbsq.avc.codecs


















protected 
object encodedFormsECdl
{

   import cbsq.avc.{*}
   import cbsq.avc.upstream.{*}

   import ewfi.*

   type XDecoderInstance 
      >: java.io.Closeable & WithFrameIterator[BbsdAvFrameIterator]
      <: java.io.Closeable & WithFrameIterator[BbsdAvFrameIterator]

   trait XEncoderInstanceOps extends
   AnyRef
   with java.io.Closeable
   {

      def encodend_=(s : BbsdAvFrameIterator ) : Unit
      
   }

   trait XEagerDecodingFnc {

      def newSession() : (XRRW["w"], XDecoderInstance )      

   } 

   trait XLazyDecodingFnc extends 
   ((XRRW["r"] ) => XDecoderInstance ) {

      /**
       * 
       * returns a decoding interface
       * 
       */
      override
      def apply(src : XRRW["r"] ) : XDecoderInstance

   }

   trait XEagerEncodingFnc extends 
   ((BbsdAvFrameIterator, XRRW["w"] ) => Unit ) 
   {
      
      /**
       * 
       * runs encoding into/onto the given dest
       * 
       */
      override
      def apply(decodedForm : BbsdAvFrameIterator, src : XRRW["w"] ) : Unit

   }

   trait XLazyEncodingFnc extends 
   ((BbsdAvFrameIterator) => XRRW["r"] ) {

      /**
       * 
       * returns an encoding interface
       * 
       */
      override
      def apply(src : BbsdAvFrameIterator ) : XRRW["r"]

   }

   type XR1[
      Dir <: "r" | "w",
      
      Chunk <: Byte | Char ,

   ] <: java.io.Closeable =
      (Dir, Chunk ) match {

         case ("r", Byte ) => (java.io.InputStream  ) | java.nio.channels.SeekableByteChannel
         case ("w", Byte ) => (java.io.OutputStream ) | java.nio.channels.SeekableByteChannel
         
         case ("r", Char ) => (java.io.Reader  )
         case ("w", Char ) => (java.io.Writer  )
         
      }

   type XRRW[Dir <: "r" | "w" ] = (
      XR1[Dir, Byte]
      | XR1[Dir, Char]
   )

}

protected 
object ewfi {

   /**
    * 
    * necessity-test ; use `Option[Unit]`
    * 
    */
   type NecessityTest 
      >: reflect.TypeTest[Option[Unit], ? <: Option[Unit] ]
      <: reflect.TypeTest[Option[Unit], ? <: Option[Unit] ]

   // export cbsq.avc.{*}
   // export cbsq.avc.upstream.{*}

   trait WithFrameIterator[+R] { val frameIterator : R }  

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

   def getCodecOverviewImpl(
      mediaKind : MediaKind ,

      encodedFormMimeType : String ,
      
      optionalDecodeFnc : Option[XLazyDecodingFnc | XEagerDecodingFnc ] ,
      
      optionalEncodingFnc : Option[XEagerEncodingFnc | XLazyEncodingFnc ] ,

   ) = {

      new
      AnyRef
      with XMediaRawCodecOverview
      with XEFM(mediaKind = mediaKind, encodedFormMimeType = encodedFormMimeType )
      {

         val rwModes = {
            Seq(
               optionalDecodeFnc.map["r"](_ => "r" ) ,
               optionalEncodingFnc.map["w"](_ => "w" ) ,
            )
            .flatten["r" | "w"]
            .toSet
         }

         type Instance
            >: XDecoderInstance | XEncoderInstanceOps
            <: XDecoderInstance | XEncoderInstanceOps

         def spawn(args: Args) = {
            ;

            import language.unsafeNulls

            args match {

            case args : (String | java.net.URI) =>
               
               val url = {

                  args match {

                     case url : java.net.URI =>
                        url

                     case url : String =>
                        // TODO
                        new java.net.URI(url)
                        
                  }
                  
               } : java.net.URI

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

            case input : XRRW["r"] =>
               spawnDecoding(input)

            case output : XRRW["w"] =>
               spawnEncoding(output)

            }
         }

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
                  ((decodedFormItr, dest) => {

                     val s = originalFnc(decodedFormItr )
                     
                     (s, dest) match

                        case (s : java.io.InputStream, dest: java.io.OutputStream ) =>
                           s transferTo dest
                        case (s : java.io.Reader, dest: java.io.Writer ) =>
                           s transferTo dest
                     
                  }) : XEagerEncodingFnc

            })
            .getOrElse(throw new java.io.IOException(s"codec doesn't support decoding") )
            
         } : XEagerEncodingFnc

         def spawnDecoding(input : XRRW["r"]): XDecoderInstance = {

               applyDc(input )

         }

         def spawnEncoding(output : XRRW["w"]): XEncoderInstanceOps = {

               import concurrent.ExecutionContext.Implicits.*

               new java.io.Closeable with XEncoderInstanceOps {

                  val decodedFormQuestion = {
                     LateBoundValue.newInstance[BbsdAvFrameIterator]
                  }

                  // export decodedFormQuestion.{value as decodedForm }
                  
                  decodedFormQuestion.asFuture
                  .map(decodedForm => {
                     applyEnc(decodedForm, output )
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

   trait XMediaAttribShape {

      val guaranteedExistInEncodedFormImpl : Boolean

      val necessityWhenDecodingImpl : NecessityTest

      val necessityWhenEncodingImpl : NecessityTest
      
   }

   // TODO
   new AnyRef with MediaDeviceAttributeTyper1 with CodecExtraOpsProvider1
   {
   
   mce =>

   override
   type MediaDeviceAttribute
      >: XMediaAttribShape
      <: XMediaAttribShape
   
   override
   def getAllRegisteredDevices()(using CodecListDependentCtx) = {
      Seq()
   }

   override
   def getAllRegisteredDemuxers()(using CodecListDependentCtx) = {
      Seq()
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
      def getCanonicalNames() : collection.immutable.Iterable[String] = Seq()

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






































