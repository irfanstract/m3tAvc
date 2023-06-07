package cbsq.avc

















trait MediaDeviceArgsAndInstancing1
   extends
   AnyRef
   with Adcp
{

   type Args

   def spawn(args: Args): (
      Instance
   )
 
   type Instance <: (
      AnyRef
      & java.io.Closeable
   )

}









object MediaDeviceOverview
{

   // summon[MediaDeviceOverview <:< MediaDeviceProperties]
   
}



object   MediaCodecOverview {

   export MediaCodecProperties.IsUnspecified

   // summon[MediaCodecOverview <:< MediaDeviceOverview]

}



/**
 * 
 * defines
 * the inner-types `MediaDeviceOverview` and `MediaCodecOverview`.
 * 
 * in `libavformat`
 * "devices" and "formats" share interface
 * 
 */
trait McdcTyper
extends
   AnyRef
{

   type MediaDeviceOverview <: (
   
      AnyRef
      with MediaDeviceProperties
      with MediaDeviceBeingAtSpecificInstancingLevel
      with mdoParamBuilders.ArgsAndTheirBuildability
      with MediaDeviceArgsAndInstancing1
      with TPossiblySupportsEvents
      
   )
   
   type MediaCodecOverview <: (
      
      AnyRef
      with MediaDeviceOverview
      with MediaCodecPropertiesMixin
      with MediaDeviceBeingAtSpecificInstancingLevel
      with mcdcParamBuilders.ArgsAndTheirBuildability
      with MediaDeviceArgsAndInstancing1
      with TPossiblySupportsEvents
      
   )
   
} /* `McdcTyper` */









/**
 * 
 * extra utils for [[MediaDeviceProperties]]
 * 
 */
// protected 
object mdoParamBuilders {

   // sealed 
   trait ArgsAndTheirBuildability
      extends 
      AnyRef 
      with Adcp
      with XArdt
   { this1  =>

      /* 
       * 
       * THE DERIVATIONAL METHODS
       * 
       */
      
      extension [A <: Args](a: A) 
         def asReset(using ArgsDerivResettibility[A, a.type] ): argsInitially.type =
            argsInitially
      
      type SpecString <: String

      extension [A <: Args](a: A) 
         def withSpecString(s: SpecString)(using ArgsDerivCompletibility[A, a.type, ardtDrvWithSpecString.type] ): Args 

   }

   trait XArdt {

      @AAdcpTag
      case object ardtDrvWithSpecString

   }

}

/**
 * 
 * extra utils for [[MediaCodecProperties]]
 * 
 */
// protected 
object mcdcParamBuilders
{

   // sealed 
   trait ArgsAndTheirBuildability
      extends 
      AnyRef
      with Adcp
      with mdoParamBuilders.ArgsAndTheirBuildability
      with XArdt
   { this1: MediaCodecProperties =>
      
      /* 
       * 
       * THE DERIVATIONAL METHODS
       * 
       */
      
      extension [A <: Args](a: A) {
         
         /**
          * 
          * for given URL (actually `URI`)
          * 
          */
         def forUrl(s: JUrlOrPath)(using ArgsDerivCompletibility[A, a.type, ardtForUrl.type] ): Args
      
         /**
          * 
          * for an already-opened stream
          * 
          */
         def forOpenedStream(s: CharacteristicFd )(using ArgsDerivCompletibility[A, a.type, ardtForOpenedStream.type] ): Args
      
      }

      
   }

   trait XArdt {

      @AAdcpTag
      case object ardtForUrl

      @AAdcpTag
      case object ardtForOpenedStream

   }

   export mcdcSupertraits.JUrlOrPath
   
}









private
def mediaDvcArgsBuildersDemo[
   MediaDeviceOverview <: McdcTyper#MediaDeviceOverview ,
   
](c: MediaDeviceOverview): Unit = {
   ()
   def randomStringArg(): c.SpecString =
      ???
   /* SHALL COMPILE */
   {
      // c.argsInitially
      //    .asReset
      //    .asReset
      //    .asReset
      //    .asReset
      //    .asReset
      c.argsInitially
         .withSpecString(randomStringArg() )
         .asReset
         .withSpecString(randomStringArg() )
         .asReset
         .withSpecString(randomStringArg() )
         .asReset
      c.spawn((
         c.argsInitially
            .withSpecString(randomStringArg() )
            .asReset
            .withSpecString(randomStringArg() )
            // .withSpecString(randomStringArg() )
            .asReset
            .withSpecString(randomStringArg() )
            .asReset
      ))
   }
   implicitly[util.NotGiven[c.Args <:< Nothing] ]
   ()
}









trait MediaDeviceBeingAtSpecificInstancingLevel
   extends
   AnyRef
{

   /**
    * 
    * tells
    * whether
    * this DeviceOverview
    * denotes the whole pair of zero-or-more hands (each a grabber-or-decoder, emitter-or-encoder, postcod-filter, or else), or
    * one of the(se) hands
    * 
    * some providers may give the same handle for either level, in which case
    * eg this method will always return the same MIL(s), and `this.spawn(...)` will simply return `this`
    * 
    */
   val instancingLevel: MediaDeviceInstancingLevel

}

object MediaDeviceBeingAtSpecificInstancingLevel
{

}


enum MediaDeviceInstancingLevel {

   /* the `spawn`ed version of the "template" version */

   case ofTheDecodingHandInstance
   case ofTheEncodingHandInstance

   /* the "template" version ; defining `defaultArgs` and `spawn(...)` */

   case ofTheDecodingHandTemplate
   case ofTheEncodingHandTemplate
   
   /* the complete codec pair */

   case ofCompleteCodecSpace
   
}
object MediaDeviceInstancingLevel {

   import MediaDeviceInstancingLevel.*

   /**
    * 
    * the `spawn`ed version of the "template" version
    * 
    */
   type OfEitherTheDecodingOrEncodingHandInstance = (
        ofTheDecodingHandInstance.type 
      | ofTheEncodingHandInstance.type
   )

   /**
    * 
    * the "template" versions
    * are the pre-instantiated versions, defining `defaultArgs` and `spawn(...)`
    * 
    */
   type OfEitherTheDecodingOrEncodingHandTemplate = (
        ofTheDecodingHandTemplate.type
      | ofTheEncodingHandTemplate.type
   )

}









;




























































































































