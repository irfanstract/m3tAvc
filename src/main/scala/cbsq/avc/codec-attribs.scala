package cbsq.avc















export cbsq.avc.{MediaKind as EMediaKind }






object  MediaDeviceOverview
{
   
   export mdoUsages.Argop

   sealed 
   trait ArgsAndTheirBuildability
      extends 
      AnyRef
      // with Gawb
      with EArgsAndTheirBuildability
   { this1: MediaDeviceOverview =>
      
      type ArgsBuilderBaseOps <: (
         
         // MediaDeviceOverview.Argop {
         //    val host : this1.type
         // }
         MediaDeviceOverview 
         & EaBuilder.XDerivedTypes[this1.type]

      )
      val argsInitially : (
         ArgsLeadingToBuilder[(
            ArgsBuilderBaseOps 
            & MediaDeviceOverview.Argop.Initially 
         )]
      )
      
   }
   
}

sealed
trait MediaDeviceOverview 
extends 
AnyRef
with MediaDeviceOverview.ArgsAndTheirBuildability
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

   // val argsBuilderInitially : (

   //    MediaDeviceOverview.Argop.Initially {
   //       val host : this1.type
   //    }

   // )
   // given argsBuildable[
   //    Builder <: ArgsBuilderBaseOps,
   // ]: Conversion[ArgsLeadingToBuilder[Builder ], Builder ]
 
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

   sealed 
   trait ArgsAndTheirBuildability
      extends 
      AnyRef
      // with Gawb
      with MediaDeviceOverview.ArgsAndTheirBuildability
      with EArgsAndTheirBuildability
   { this1: MediaCodecProperties =>
      
      type ArgsBuilderBaseOps <: (
         
         MediaCodecProperties 
         & EaBuilder.XDerivedTypes[this1.type]

      )
      val argsInitially : (
         ArgsLeadingToBuilder[(
            ArgsBuilderBaseOps 
            & MediaCodecProperties.Argop.Initially 
         )]
      )
      
   }
   
}
sealed
trait MediaCodecProperties 
   extends 
   AnyRef
   with MediaDeviceOverview 
   // with Gawb
   with EArgsAndTheirBuildability
   with MediaCodecProperties.ArgsAndTheirBuildability
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

   // val argsBuilderInitially : (
     
   //   MediaCodecProperties.Argop.Initially {
   //      val host : this1.type
   //   }
   
   // )
   
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

   export EaBuilder.XDerivedTypes
   
   trait Argop extends
      AnyRef
      with XDerivedTypes[MediaDeviceOverview]
   { thisArgsBuilder =>

      val host : MediaDeviceOverview
      
      export host.mediaKind

      def asReset : (
         Derived & Argop.Initially
      )

   }
   object Argop 
      extends 
      AnyRef
      with CodecsArgop1TypeStatique[Argop]
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

   export mdoUsages.XDerivedTypes
   
   trait Argop
      extends 
      AnyRef
      with MediaDeviceOverview.Argop
      with XDerivedTypes[MediaCodecProperties]
   { thisArgsBuilder =>

      val host : MediaCodecProperties
      
      export host.encodedFormMimeType

      def asReset : (
         Derived & Argop.Initially
      )

      export host.CharacteristicFd

   }
   object Argop 
      extends 
      AnyRef
      with CodecsArgop1TypeStatique[Argop]
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
trait CodecsArgop1TypeStatique[Argop] {
   
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

// private trait Acl {
//    type E
//    given eBoxing: Conversion[E, collection.Iterable[E]]
//    val defaultE: E
// }
// def onAcl(c: Acl): Unit =
//    c.defaultE
//    .head
//    .head
//    .head
private
def onAcl(c: MediaDeviceOverview): Unit =
   /* SHALL COMPILE */
   c.argsInitially
      .asReset
      .asReset
      .asReset
      .asReset
      .asReset









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


















