package cbsq.avc















export cbsq.avc.{MediaKind as EMediaKind }







object  CodecProperties {

   export isunsp.{value as IsUnspecified}
   protected 
   object isunsp {
      lazy val value : Null | Product =
         case object IsUnspecified1
         IsUnspecified1
   }

   @annotation.experimental
   def mv = Seq[IsUnspecified.type]()

}
sealed
trait CodecProperties 
extends 
AnyRef
// with TPossiblySupportsEvents
{ this1 =>

  val mimeType  : Null | String

  val mediaKind : EMediaKind

  def isNotBusy: Boolean =
    true
   
  /**
   * 
   * use one of the two base-class(es) in `java.io`,
   * to tell whether this's a binary-fmt or text-fmt
   * 
   */
  type Rd <: java.io.Closeable

}

protected
trait CodecPropertiesMixin extends CodecProperties







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
       * [[CodecTemplateOps#events]]
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







object   CodecOverview {

  export CodecProperties.IsUnspecified

}
trait    CodecOverview 
extends
AnyRef
with CodecPropertiesMixin
with TPossiblySupportsEvents
{

  /**
   * 
   * may optionally emit events
   * 
   * impl :
   * [[CodecOverview]]s should be stateless.
   * unless this `val` is overridden, would not emit anything.
   * 
   */
  lazy val events : Iterator[EventInfo] =
     Iterator()

}


















