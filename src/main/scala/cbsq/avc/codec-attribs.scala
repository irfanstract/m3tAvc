package cbsq.avc















export cbsq.avc.{MediaKind as EMediaKind } //






trait MediaDeviceBeingOfSpecificMediaType 
   extends
   AnyRef
{
   
   /**
    * 
    * tells 
    * whether 
    * this (Codec) is 
    * of *audio*, *subtitles*, *video*, or some other *media-type*, or a mux/mix thereof
    * 
    */
   val mediaKind : EMediaKind

}

trait MediaDeviceBeingAtSpecificInstancingLevel
   extends
   AnyRef
{

   /**
    * 
    * tells
    * whether
    * this Device is merely the decoder, merely the encoder, or is the whole pair of them
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

object  MediaDeviceOverview
{

}

/**
 * 
 * interface to a media capture dvc display dvc (provider).
 * 
 */
@deprecatedInheritance("intended to be sealed")
// sealed
trait MediaDeviceOverview 
extends 
AnyRef
with MediaDeviceBeingOfSpecificMediaType
with MediaDeviceBeingAtSpecificInstancingLevel
with mdoSupertraits1.ArgsAndTheirBuildability
with MediaDeviceArgsAndInstancing1
{ this1 =>
   
   /**
    * 
    * tells 
    * whether 
    * this is 
    * of *audio*, *subtitles*, *video*, or some other *media-type*, or a muux/mix thereof
    * 
    */
   val mediaKind : EMediaKind

}

/**
 * 
 * the side-`class/trait`s which the main `class/trait` `extends`
 * 
 */
object mdoSupertraits1 {
      
   sealed 
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

   // sealed 
   // abstract 
   // class KCto
   // object KCto {
   // 
   //    // given
   //    
   // }
   
}


object  MediaCodecProperties {

   export isunsp.{value as IsUnspecified}
   protected 
   object isunsp {
      lazy val value : Null | Product =
         case object IsUnspecified1
         IsUnspecified1
   }

}

/**
 * 
 * interface to a *codec*.
 * 
 * technically
 * *codec*s are just another examples of *device*s --
 * every *codec* is effectively a *device* which decode-from or encode-to b/c streams
 * 
 */
sealed
trait MediaCodecProperties 
   extends 
   AnyRef
   with MediaDeviceOverview
   with MediaDeviceBeingOfSpecificMediaType
   with MediaDeviceBeingAtSpecificInstancingLevel
   with mcdcSupertraits.ArgsAndTheirBuildability
   with MediaDeviceArgsAndInstancing1
   // with TPossiblySupportsEvents
{ this1 =>

   /**
    * 
    * the *MIME-type* 
    * assigned for *the encoded fmt*
    * 
    */
   val encodedFormMimeType  : Null | String
 
   /**
    * 
    * use one of the two base-class(es) in `java.io`,
    * to tell these two things
    * - whether this's a binary-fmt or text-fmt
    * - whether this is both-input-and-output or only either
    * 
    */
   type CharacteristicFd <: (
      java.io.Closeable
      & (
         java.io.Closeable
         | java.io.InputStream 
         | java.io.OutputStream 
         | java.nio.channels.SeekableByteChannel
         | java.io.Reader
         | java.io.Writer
         | java.io.CharArrayWriter /* MISSING `java.nio.channels.CharChannel` */
      )
   )

   summon[java.nio.channels.ByteChannel <:< java.io.Closeable]

   summon[CharacteristicFd <:< java.io.Closeable]

}

/**
 * 
 * the side-`class/trait`s which the main `class/trait` `extends`
 * 
 */
object mcdcSupertraits {
   
   sealed 
   trait ArgsAndTheirBuildability
      extends 
      AnyRef
      with Adcp
      with mdoSupertraits1.ArgsAndTheirBuildability
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

   type JUrlOrPath = (
      java.net.URI | java.nio.file.Path
   )
   
}

@deprecated("experimental")
// protected
trait MediaCodecPropertiesMixin extends MediaCodecProperties










/**
 * 
 * extra utils for [[MediaDeviceOverview]]
 * 
 */
protected 
object mdoParamBuilders {

}
/**
 * 
 * extra utils for [[MediaCodecProperties]]
 * 
 */
protected 
object mcdcParamBuilders
{

}

private
def mediaDvcArgsBuildersDemo(c: MediaDeviceOverview): Unit = {
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









trait TPossiblySupportsEvents
{

   /**
    * 
    * may optionally emit events
    * 
    */
   lazy val events : Iterator[EventInfo]
   type EventInfo <: AnyRef

}

/**
 * a mixin providing implementation of one-method and one-type in [[TPossiblySupportsEvents]],
 * delegating to the given "sourcer".
 * 
 * experimental.
 *
 * @param backingSourcer
 * 
 */
@deprecated("experimental")
// protected 
trait  TPossiblySupportsEventsForwarded[SpecificEvent <: AnyRef](
  private[TPossiblySupportsEventsForwarded] val backingSourcer : Singleton & Iterator[SpecificEvent] ,
)
   extends 
   TPossiblySupportsEvents
{
   
      /**
       * [[MediaCodecTemplateOps#events]]
       * 
       * @note
       * FOR DEVS :
       * [[backingSourcer]] is effectively a non-public symbol, so
       * don't be surprised if a future compiler version (suddenly) reject this...
       * 
       */
      override 
      lazy val events: backingSourcer.type = 
         backingSourcer
      
      type EventInfo
         >: SpecificEvent
         <: SpecificEvent

}










object   MediaCodecOverview {

   export MediaCodecProperties.IsUnspecified

}
trait    MediaCodecOverview 
extends
AnyRef
with MediaCodecPropertiesMixin
with TPossiblySupportsEvents
{

   /**
    * 
    * may optionally emit events
    * 
    * impl :
    * [[MediaCodecOverview]]s should be stateless.
    * unless this `val` is overridden, would not emit anything.
    * 
    */
   lazy val events : Iterator[EventInfo] =
      Iterator()
 
}


















