package cbsq.avc














// import MediaKind as EMediaKind







/**
 * 
 * every instance of [[CodecTemplateOps]]
 * is an *effectively-stateless* interface to these aspects of a *codec* impl
 * 
 * - overviews, eg `mimeType`, `mediaKind`, `binaryFmt`
 * - instantiation by `path` or `args`
 * 
 * to get an instance decoding from desired URL,
 * use [[startForUrl]] or the related methods
 * 
 */
sealed 
trait CodecTemplateOps extends
AnyRef 
with CodecOverview 
with CodecTplIsInstantiable
{ this1 =>

   type Instance
      <: CodecInstanceOps[this1.type ]

   lazy val hasInverseCodec : Option[CodecTemplateOps ] =
      None
      

} /* interface CodecTemplateOps */
object CodecTemplateOps
{

   export %%!.ioUtil

}

protected 
trait CodecTemplateOpsMixin 
extends CodecTemplateOps

/* the definitions needed to be split, to avoid compiler crash */
/**
 * 
 * the necessary set of `startYyy` methods together with some util
 * 
 */
sealed 
trait CodecTplIsInstantiable extends
   AnyRef 
   with Ctpr
{ this1 : CodecOverview =>

}
object  CodecTplIsInstantiable
{

   /* test */ 
   {
      type CwCtpi = (
         CodecOverview with CodecTplIsInstantiable
      )
      
      summon[(CwCtpi { type Rd = java.io.InputStream })#DestibleFd <:< java.io.InputStream ]

      summon[(CwCtpi { type Rd = java.io.Reader })#DestibleFd <:< java.io.Reader ]

   }

}

protected 
trait CodecTplIsMixinInstantiable 
extends CodecTplIsInstantiable
{ this1 : CodecOverview => }

object Ctpr
{
   
}
@deprecated("experimental")
trait Ctpr extends 
   AnyRef
{ this1: CodecOverview =>

   // final val mimeType = null
   
   type Rd <: java.io.Closeable
   
   type Instance
   
   /**
    * starts, tuned by given *flags*
    * 
    * throws [[Exception]] for init-failure (eg invalid options).
    * throws [[Exception]] for file-not-found or malformed-header conds.
    * no-throw otherwise.
    *
    * @param flags 
    */
   def startC(flags: String*): Instance
   
   /**
    * starts, decoding from, or encoding to,
    * loc specified by `href`
    * 
    * uses [[startC]]'s *throws*-policy
    * 
    * note - 
    * `flags` here might be incompatible with that of [[startC]]
    *
    * @param href 
    */
   def startForUrl(
      href: java.net.URI, 
      flags: IndexedSeq[String] = IndexedSeq() ,
   ): Instance

   /**
    * 
    * starts, decoding from, or encoding to,
    * the given [[Rd]]
    * .
    * READING -
    * check whether *the header* matches, and, if so,
    * start 
    * .
    * WRITING -
    * always "return true" 
    * .
    * 
    * never throw - return `false` if "no"
    *
    * @param src 
    */
   def startForFd(src: DestibleFd): false | Instance

   /**
    * 
    * candidates for [[startForFd]]
    * 
    */
   type DestibleFd
      >: ioUtil.AsBuffered[this1.Rd ] & this1.Rd
      <: this1.Rd

}





/**
 * 
 * one-off instantiation obtained from some [[CodecTemplateOps]],
 * proxying a (possibly terminated) transcoding process
 * 
 */
sealed 
trait CodecInstanceOps[+C <: CodecTemplateOps] extends 
AnyRef 
with java.io.Closeable
with CodecPropertiesMixin
with TPossiblySupportsEvents
{ this1 =>

   val associatedCodec: C

   export associatedCodec.mimeType

   export associatedCodec.mediaKind

   override 
   def close(): Unit

   /**
    * behind discretion, may support firing of events
    */
   lazy val events : Iterator[EventInfo]
   type EventInfo <: AnyRef

}
object  CodecInstanceOps {
   
   /**
    * instance constructed with arguments `(ref: URI)`
    */
   trait FromUrl1 extends 
   AnyRef 
   with CodecInstanceOps[CodecTemplateOps]
   {
      //
   }
   
}

protected 
trait CodecInstanceOpsMixin[+C <: CodecTemplateOps] 
extends CodecInstanceOps[C]




















































