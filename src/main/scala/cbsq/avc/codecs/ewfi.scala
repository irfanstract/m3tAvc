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

   type XR1[
      Dir <: "r" | "w",
      
      Chunk <: Byte | Char ,

   ] <: java.io.Closeable =
      (Dir, Chunk ) match {

         case ("r", Byte ) => (java.io.InputStream  ) | java.nio.channels.SeekableByteChannel
         case ("w", Byte ) => (java.io.OutputStream ) | java.nio.channels.SeekableByteChannel
         
         case ("r", Char ) => (java.io.Reader  )
         case ("w", Char ) => (java.io.Writer  ) | (java.io.Closeable & java.lang.Appendable )
         
      }

   type XRRW[Dir <: "r" | "w" ] = (
      XR1[Dir, Byte]
      | XR1[Dir, Char]
   )

}

protected 
object encodedFormsEDcei
{

   import cbsq.avc.{*}
   import cbsq.avc.upstream.{*}

   import ewfi.*

   import encodedFormsECdl.*

   //

   /**
    * 
    * a variant described by `wrap(input): decodingItr` -
    * generally,
    * the `input.readNBytes()` calls
    * will only happen on-demand when pulling from `decodingItr`
    * 
    * **closing the stream**: invoke `input.close()`
    * 
    */
   abstract
   class XTraversiveInputOutputDecoder
   extends
   EwfTranscodFnc.OfTraversiveInputAndTraversiveOutput[XRRW["r"], XedfMuuxProperties, XDecoderInstance ]
   {

      /**
       * 
       * returns a decoding interface
       * 
       */
      override
      def apply(
         src : XRRW["r"] ,
         fmtProperties: XedfMuuxProperties,
         
      ) : XDecoderInstance

   }

   object XTraversiveInputOutputDecoder
   {

      //
      
   }

   /**
    * 
    * a variant described by `newSession() : (feedHere, decodingItr)` -
    * decoding may happen as early as every call to `feedHere.write(...)`
    * 
    * **closing the stream**: invoke `feedHere.close()`
    * 
    */
   abstract
   class XImperativeInputTraversiveOutDecoder
   extends
   EwfTranscodFnc.OfImperativeInputAndTraversiveOutput[XRRW["w"], XedfMuuxProperties, XDecoderInstance ]
   {

      override
      def newSession(
         fmtProperties: XedfMuuxProperties,

      ) : (XRRW["w"], XDecoderInstance )      

   } 

   object XImperativeInputTraversiveOutDecoder
   {

      extension (impl: XImperativeInputTraversiveOutDecoder ) {

         def lazyForm : XTraversiveInputOutputDecoder = {

            import language.unsafeNulls

            identity[XTraversiveInputOutputDecoder]({

               case (src, fmtProperties) => {
                  
                  val session = impl newSession(fmtProperties )

                  val (_, decodedFormItr) = session

                  matchAndInvokeSrcTransferTo(src, session._1 )

                  decodedFormItr
                  
               }
               
            })

         }

      }

   }

   /**
    * 
    * a variant described by `wrap(unencodedFormItr): encodedBytesReader` -
    * generally,
    * the encoding-calls
    * will only happen on-demand when pulling from `encodedBytesReader`
    * 
    * **closing the stream**: invoke `encodedBytesReader.close()`
    * 
    */
   abstract
   class XTraversiveInputOutputEncoder
   extends
   XLefSupertrait
   {

      /**
       * 
       * returns an encoding interface
       * 
       */
      override
      def apply(
         src : BbsdAvFrameIterator ,
         fmtProperties: XedfMuuxProperties,
         
      ) : XRRW["r"]

   }

   object XTraversiveInputOutputEncoder {
      
      extension (originalFnc : XTraversiveInputOutputEncoder ) {

         def eagerForm: XSynchronousInputOutputEncoder = {
            originalFnc.ldfEagerForm
         }
         
      }
      
   }

   type XLefSupertrait = (
      EwfTranscodFnc.OfTraversiveInputAndTraversiveOutput[BbsdAvFrameIterator, XedfMuuxProperties, XRRW["r"] ]
   )

   extension (originalFnc : XLefSupertrait ) {

      def ldfEagerForm: XSynchronousInputOutputEncoder = {
         
            ; // TODO
            
            identity[XSynchronousInputOutputEncoder]({

               case (decodedFormItr, fmtProperties, dest) => {

                  val s = originalFnc(decodedFormItr, fmtProperties )
                  
                  matchAndInvokeSrcTransferTo(s, dest)
                  
               }
               
            })

      }
      
   }
   
   /**
    * 
    * a variant which synchronously run the encoding, writing into `dest` -
    * 
    * **closing the stream**: from a different thread, invoke `dest.close()`
    * 
    */
   abstract
   class XSynchronousInputOutputEncoder 
   extends
   EwfTranscodFnc.OfSynchronousPiping[BbsdAvFrameIterator, XedfMuuxProperties, XRRW["w"], Unit ]
   {
      
      /**
       * 
       * runs encoding into/onto the given dest
       * 
       */
      override
      def apply(
         decodedForm : BbsdAvFrameIterator,
         fmtProperties: XedfMuuxProperties,
         dest : XRRW["w"] ,

      ) : Unit

   }

   object XSynchronousInputOutputEncoder
   {

      //
      
   }

   /**
    * 
    * for a small number of fmts
    * a amall number of props
    * will not be written into the file-contents stream but instead specified via eg the HTTP header.
    * currently we haven't come with a good interface for that (yet), but
    * for now every good `class`es which define/shape data-structures for that shall `extends` this `abstract class`
    * 
    */
   class XedfMuuxProperties
   
   val matchAndInvokeSrcTransferTo = {
      java.nio.CharBuffer.allocate(0x10)
      identity[(src: XRRW["r"], dest: XRRW["w"] ) => Unit ]({
         
                     case (s : java.io.InputStream, dest: java.io.OutputStream ) =>
                        s transferTo dest

                     case (s : java.io.Reader, dest: java.io.Writer ) =>
                        s transferTo dest
                     case (s : java.io.Reader, dest: java.lang.Appendable ) =>
                        s transferTo getAppendableImplWriter(dest = dest )
                  
      })
   }

}

class EwfiEmdo()
{

   import cbsq.avc.{*}
   import cbsq.avc.upstream.{*}

   import ewfi.*

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

      optionalDecodeFnc : Option[XTraversiveInputOutputDecoder | XImperativeInputTraversiveOutDecoder ] ,
      
      optionalEncodingFnc : Option[XSynchronousInputOutputEncoder | XTraversiveInputOutputEncoder ] ,

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
               case e : XTraversiveInputOutputDecoder =>
                  e
            })
            .getOrElse(throw new java.io.IOException(s"codec doesn't support decoding") )
            
         } : XTraversiveInputOutputDecoder

         lazy 
         val applyEnc = {
            optionalEncodingFnc
            .collect({

               case e : XSynchronousInputOutputEncoder =>
                  e

               case originalFnc : XTraversiveInputOutputEncoder =>
                  originalFnc.ldfEagerForm

            })
            .getOrElse(throw new java.io.IOException(s"codec doesn't support decoding") )
            
         } : XSynchronousInputOutputEncoder

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

}


















































