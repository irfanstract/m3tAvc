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

object  MediaDeviceProperties
{

}

/**
 * 
 * interface to a media capture dvc display dvc (provider).
 * 
 */
@deprecatedInheritance("intended to be sealed")
// sealed
trait MediaDeviceProperties 
extends 
AnyRef
with MediaDeviceBeingOfSpecificMediaType
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
      
   // sealed 
   // abstract 
   // class KCto
   // object KCto {
   // 
   //    // given
   //    
   // }
   
}


/**
 * 
 * a capture device or display device
 * does not take file/URL arguments
 * 
 */
trait MediaEndPointDeviceProperties extends
AnyRef
with MediaDeviceProperties
{

   require((
      !(this.isInstanceOf[MediaCodecProperties] )
   ) , s"an 'end-point device' cannot additionally be a 'codec'. (${this.getClass().getName() }) " )
   
}

object MediaEndPointDeviceProperties
{

   //
   
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
   with MediaDeviceProperties
   with MediaDeviceBeingOfSpecificMediaType
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
         | (java.nio.channels.Channel & CharSequence) /* MISSING `java.nio.channels.CharChannel` */
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
   
   type JUrlOrPath = (
      java.net.URI | java.nio.file.Path
   )
   
}

@deprecated("experimental")
// protected
trait MediaCodecPropertiesMixin extends MediaCodecProperties










trait TPossiblySupportsEvents
{

   /**
    * 
    * may optionally emit events
    * 
    */
   lazy val events : EventIterator[EventInfo]
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
  private[TPossiblySupportsEventsForwarded] val backingSourcer : Singleton & EventIterator[SpecificEvent] ,
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



















