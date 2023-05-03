package cbsq.avc















export cbsq.avc.{MediaKind as EMediaKind }






object  MediaDeviceOverview
{
   
   export mdoUsages.Argop
   
}

sealed
trait MediaDeviceOverview 
extends 
AnyRef
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

   val argsBuilderInitially : (
      MediaDeviceOverview.Argop {
         val host : this1.type
      }
   )
 
}


object  MediaCodecProperties {

   export isunsp.{value as IsUnspecified}
   protected 
   object isunsp {
      lazy val value : Null | Product =
         case object IsUnspecified1
         IsUnspecified1
   }

   export mcdcUsages.Argop

}
sealed
trait MediaCodecProperties 
extends 
AnyRef
with MediaDeviceOverview 
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
   type CharacteristicFd <: java.io.Closeable

   val argsBuilderInitially : (
      MediaCodecProperties.Argop {
         val host : this1.type
      }
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
object mdoUsages {
   
   trait Argop 
   { thisArgsBuilder =>

      val host : MediaDeviceOverview
      
      type Derived <: (
         Argop {
            val host : thisArgsBuilder.host.type
         }
      )

      export host.mediaKind

      def asReset : (
         Derived & Argop.Initially
      )

   }
   object Argop 
      extends 
      AnyRef
      with ArgopTypeStatique[Argop]
   {

      trait CanGiveFullSpecString
      extends 
      AnyRef
      with Argop
      {
         
         type SpecString <: String

         def withSpecString(s: SpecString) : Derived

      }
      
      type Initially = (
         Argop 
         & CanGiveFullSpecString
      )
      
   }

}
/**
 * 
 * extra utils for [[MediaCodecProperties]]
 * 
 */
protected 
object mcdcUsages
{
   
   trait Argop
   extends 
   AnyRef
   with MediaDeviceOverview.Argop
   { thisArgsBuilder =>

      val host : MediaCodecProperties
      
      type Derived <: (
         Argop {
            val host : thisArgsBuilder.host.type
         }
      )

      export host.encodedFormMimeType

      def asReset : (
         Derived & Argop.Initially
      )

      export host.CharacteristicFd

   }
   object Argop 
      extends 
      AnyRef
      with ArgopTypeStatique[Argop]
   {

      trait CanGiveFullSpecString
      extends 
      AnyRef
      with Argop
      with MediaDeviceOverview.Argop.CanGiveFullSpecString 
      { thisArgsBuilder =>
         
         def forUrl(s: java.net.URI | java.nio.file.Path): Derived
      
         def forOpenStream(s: thisArgsBuilder.CharacteristicFd ): Derived
      
      }
      
      type Initially = (
         Argop
         & CanGiveFullSpecString
      )
      
   }

}

/**
 * 
 * this `trait` is to enforce this/these invariants between those.
 * 
 */
sealed 
trait ArgopTypeStatique[Argop] {
   
   /**
    * 
    * the form-or-state which `host.argsBuilderInitially` shall conforms to
    * 
    */
   type Initially = (
      Argop 
      & CanGiveFullSpecString
   )
   
   /**
    * 
    * the form-or-state of being "derivable to complete-args"
    * 
    */
   type CanGiveFullSpecString <: (
      Argop 
   )
   
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


















