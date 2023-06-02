package cbsq.avc.upstream


















object codecExtraOps

trait CodecExtraOpsProvider1 
extends
   AnyRef
   with cbsq.avc.McdcTyper
{

   extension (fmt1 : MediaDeviceOverview ) {

      def isExperimentalDevice : Boolean = {
         // TODO
         false
      }

   }

   extension (fmt1 : MediaDeviceOverview ) {

      /**
       * 
       * you'll need to use one of these names
       * to refer to the codec.
       * 
       */
      def getCanonicalNames() : collection.immutable.Iterable[String] = {
         notImplemented
      }

      /**
       * 
       * the localised name, supposedly a bit long
       * 
       */
      def getLocalizedName(locale: java.util.Locale ) : String = {
         // TODO
         fmt1 match {

            case fmt1 : cbsq.avc.MediaCodecProperties =>
               s"codec (mime-type: ${fmt1.encodedFormMimeType } ; impl: ${fmt1.getClass().getName() } ; )"
               
            case _ =>
               s"codec (impl: ${fmt1.getClass().getName() } ; )"

         }
      }

   }

   extension [P](prop : P ) {

      /**
       * 
       * whether
       * it's a obliged/required field in encoded forms
       * (eg typically mux fmts oblige/require video streams to specify framerate)
       * 
       */
      def isRequiredPropertyInEncodedForms() : Boolean = {
         notImplemented
      }

      /**
       * 
       * whether
       * programmes can explicitly specify it when decoding
       * 
       */
      def isCustomisableWhenDecoding() : Boolean = {
         notImplemented
      }

      /**
       * 
       * whether
       * programmes can explicitly specify it when encoding
       * 
       */
      def isCustomisableWhenEncoding() : Boolean = {
         notImplemented
      }

   }

   extension (fmt1 : MediaDeviceOverview ) {

      transparent inline
      def isEndpointDevice = fmt1.isInstanceOf[cbsq.avc.MediaEndPointDeviceProperties]

      transparent inline
      def isCodec = fmt1.isInstanceOf[cbsq.avc.MediaCodecProperties]

   }

   extension (fmt1 : MediaDeviceOverview & cbsq.avc.MediaCodecProperties ) {

      /**
       * corresponds to `libavfmt`'s `AVFMT_NOFILE`
       */
      def isMuxFnf(using CodecListDependentCtx): Boolean = {
         notImplemented
      }

      def fileExtensions1Optional(using CodecListDependentCtx) : Option[collection.immutable.Iterable[String] ] = {
         notImplemented
      }
      
   }

   def getAllRegisteredDemuxers()(using CodecListDependentCtx) : collection.Iterable[MediaCodecOverview & cbsq.avc.FfCodecTemplateOps ] = {
      notImplemented
   }

   def getAllRegisteredDevices()(using CodecListDependentCtx) : collection.Iterable[MediaCodecOverview & cbsq.avc.FfCodecTemplateOps ] = {
      notImplemented
   }

}

/**
 * 
 * instances of this class
 * maintains a list/registry of codecs, and
 * is essential for some methods around here
 * 
 * as specified thru the `using` parameters
 * (this is idiomatic `concurrent.Future` as does `quoted.Quotes` as does SBT )
 * 
 */
// TODO remove this
trait CodecListDependentCtx




































































