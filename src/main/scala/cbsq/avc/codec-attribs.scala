package cbsq.avc















export cbsq.avc.{MediaKind as EMediaKind } //






object  MediaDeviceOverview
{

}

// sealed
trait MediaDeviceOverview 
extends 
AnyRef
with mdoSupertraits1.ArgsAndTheirBuildability
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

   type Instance <: (
      AnyRef
      & java.io.Closeable
   )

   def spawn(args: Args): (
      Instance
   )
 
}

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

// sealed
trait MediaCodecProperties 
   extends 
   AnyRef
   with MediaDeviceOverview
   with mcdcSupertraits.ArgsAndTheirBuildability
   // with TPossiblySupportsEvents
{ this1 =>

   /**
    * 
    * tells 
    * whether 
    * this (Codec) is 
    * of *audio*, *subtitles*, *video*, or some other *media-type*, or a mux/mix thereof
    * 
    */
   val mediaKind : EMediaKind

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

   type Instance <: (
      AnyRef
      & java.io.Closeable
   )

   def spawn(args: Args): (
      Instance
   )

}

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
         
         def forUrl(s: JUrlOrPath)(using ArgsDerivCompletibility[A, a.type, ardtForUrl.type] ): Args
      
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

protected
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


















