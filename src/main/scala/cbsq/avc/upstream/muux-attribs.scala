package cbsq.avc.upstream


















object codecExtraOps

trait CodecExtraOpsProvider1 
extends
   AnyRef
   with cbsq.avc.McdcTyper
   with MediaDeviceAttributeTyper1
{

   def getAllRegisteredDemuxers()(using CodecListDependentCtx) : collection.immutable.Iterable[MediaCodecOverview & cbsq.avc.FfCodecTemplateOps ] = {
      getAllRegisteredDevices()
      .map({
         case c : MediaCodecOverview =>
            c
      })
      .filter(c => {
         c.getCodecRws().toSet["r" | "w"] contains "r"
      })
   }

   def getAllRegisteredDevices() : collection.immutable.Iterable[MediaDeviceOverview & cbsq.avc.FfCodecTemplateOps ]

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
      def getCanonicalNames() : collection.immutable.Iterable[String]

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

   extension (fmt1 : MediaDeviceOverview ) {

      transparent inline
      def isEndpointDevice = fmt1.isInstanceOf[cbsq.avc.MediaEndPointDeviceProperties]

      transparent inline
      def isCodec = fmt1.isInstanceOf[cbsq.avc.MediaCodecProperties]

   }

   extension (fmt1 : MediaDeviceOverview ) {

      def getCodeAttributesMap() : Map[String, MediaDeviceAttribute ] = {
         Map()
      }

   }

   extension (fmt1 : MediaCodecOverview ) {

      def getCodecRws() : Set[? <: ("r" | "w") ]

   }

   extension (fmt1 : MediaDeviceOverview & cbsq.avc.MediaCodecProperties ) {

      /**
       * corresponds to `libavfmt`'s `AVFMT_NOFILE`
       */
      def isMuxFnf(using CodecListDependentCtx): Boolean = {
         false
      }

      def fileExtensions1Optional(using CodecListDependentCtx) : Option[collection.immutable.Iterable[String] ] = {
         None
      }
      
   }

}

trait MediaDeviceAttributeTyper1 
extends
   AnyRef
{

   type MediaDeviceAttribute

   extension [P <: MediaDeviceAttribute ](prop : P ) {

      /**
       * 
       * whether
       * it's a obliged/required field in encoded forms
       * (eg typically mux fmts oblige/require video streams to specify framerate)
       * 
       */
      def isRequiredPropertyInEncodedForms() : Boolean

      /**
       * 
       * whether
       * programmes can explicitly specify it when decoding
       * 
       */
      def isCustomisableWhenDecoding() : Boolean

      /**
       * 
       * whether
       * programmes can explicitly specify it when encoding
       * 
       */
      def isCustomisableWhenEncoding() : Boolean

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




































































