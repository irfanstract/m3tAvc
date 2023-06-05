package cbsq.avc.codecs


















// TODO
lazy val codecListing = {

   import cbsq.avc.*
   import cbsq.avc.upstream.*

   /**
    * 
    * necessity-test ; use `Option[Unit]`
    * 
    */
   type NecessityTest 
      >: reflect.TypeTest[Option[Unit], ? <: Option[Unit] ]
      <: reflect.TypeTest[Option[Unit], ? <: Option[Unit] ]

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
      val rwModes : Set["r" | "w"]

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

   // new XMediaRawCodecOverview {}

   trait XMediaAttribShape {

      val guaranteedExistInEncodedForm : Boolean

      val necessityWhenDecoding : NecessityTest

      val necessityWhenEncoding : NecessityTest
      
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
         prop.guaranteedExistInEncodedForm
      }

      /**
       * 
       * whether
       * programmes can explicitly specify it when decoding
       * 
       */
      def isCustomisableWhenDecoding() : Boolean = {
         (prop.necessityWhenDecoding.unapply _).unlift
         .isDefinedAt(Some(()) )
      }

      /**
       * 
       * whether
       * programmes can explicitly specify it when encoding
       * 
       */
      def isCustomisableWhenEncoding() : Boolean = {
         (prop.necessityWhenEncoding.unapply _).unlift
         .isDefinedAt(Some(()) )
      }

   }
   
   }
}






































