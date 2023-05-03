package cbsq.avc















export cbsq.avc.{MediaKind as EMediaKind }






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

   /**
    * 
    * summoning these type-evidence(s)
    * 
    */
   identity((b: ArgsBuilderBaseOps) => {
      implicitly[b.host.type =:= this1.type]
      implicitly[b.Derived <:< Args ]
      implicitly[b.Derived <:< ArgsLeadingToBuilder[ArgsBuilderBaseOps] ]
      //
      implicitly[ArgsBuilderBaseOps <:< mdoSupertraits1.Argop ]
      // Seq[(ArgsBuilderBaseOps & MediaDeviceOverview)#Derived ]() match {
      //    case seq =>
      // }
      identity((c: ArgsBuilderBaseOps & MediaDeviceOverview) => {
         implicitly[c.Derived <:< Args ]
         implicitly[c.Derived <:< ArgsLeadingToBuilder[ArgsBuilderBaseOps] ]
         implicitly[c.DerivedBuilder <:< ArgsBuilderBaseOps ]
         // return :
         ()
      })
      // return :
      ()
   })
 
}

object mdoSupertraits1 {
      
   export mdoParamBuilders.Argop

   sealed 
   trait ArgsAndTheirBuildability
      extends 
      AnyRef
      // with Gawb
      with EArgsAndTheirBuildability
   { this1: MediaDeviceOverview =>
      
      type ArgsBuilderBaseOps <: (
         
         // mdoSupertraits1.Argop {
         //    val host : this1.type
         // }
         mdoSupertraits1.Argop 
         & EaBuilder.XDerivedTypes[this1.type]

      )
      val argsInitially : (
         ArgsLeadingToBuilder[(
            ArgsBuilderBaseOps 
            & mdoSupertraits1.Argop.Initially 
         )]
      )
      
   }
   
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
   // with Gawb
   with EArgsAndTheirBuildability
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
   type CharacteristicFd <: java.io.Closeable

   type Instance <: (
      AnyRef
      & java.io.Closeable
   )

   def spawn(args: Args): (
      Instance
   )

}

object mcdcSupertraits {
   
   export mcdcParamBuilders.Argop

   sealed 
   trait ArgsAndTheirBuildability
      extends 
      AnyRef
      // with Gawb
      with mdoSupertraits1.ArgsAndTheirBuildability
      with EArgsAndTheirBuildability
   { this1: MediaCodecProperties =>
      
      type ArgsBuilderBaseOps <: (
         
         mcdcSupertraits.Argop
         & EaBuilder.XDerivedTypes[this1.type]

      )
      val argsInitially : (
         ArgsLeadingToBuilder[(
            ArgsBuilderBaseOps 
            & mcdcSupertraits.Argop.Initially 
         )]
      )
      
   }
   
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

   export EaBuilder.XDerivedTypes
   
   trait Argop extends
      AnyRef
      with XDerivedTypes[MediaDeviceOverview]
   { thisArgsBuilder =>

      val host : MediaDeviceOverview
      
      export host.mediaKind
      
      summon[Derived <:< host.Args]
      
      summon[Derived <:< host.ArgsLeadingToBuilder[host.ArgsBuilderBaseOps] ]

      def asReset : (
         Derived 
         & host.ArgsLeadingToBuilder[DerivedBuilder & Argop.Initially]
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
object mcdcParamBuilders
{

   export mdoParamBuilders.XDerivedTypes
   
   trait Argop
      extends 
      AnyRef
      with mdoSupertraits1.Argop
      with XDerivedTypes[MediaCodecProperties]
   { thisArgsBuilder =>

      val host : MediaCodecProperties
      
      export host.encodedFormMimeType

      def asReset : (
         Derived 
         & host.ArgsLeadingToBuilder[DerivedBuilder & Argop.Initially]
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
      with mdoSupertraits1.Argop.CanGiveFullSpecString 
      { thisArgsBuilder =>
         
         def forUrl(s: java.net.URI | java.nio.file.Path): Derived
      
         def forOpenedStream(s: thisArgsBuilder.CharacteristicFd ): Derived
      
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
def mediaDvcArgsBuildersDemo(c: MediaDeviceOverview): Unit = {
   ()
   /* SHALL COMPILE */
   c.argsInitially
      .asReset
      .asReset
      .asReset
      .asReset
      .asReset
   c.argsInitially
      .withSpecString(???)
      .asReset
   c.spawn((
      c.argsInitially
         .asReset
         .withSpecString(???)
         .asReset
         .withSpecString(???)
   ))
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


















