package cbsq.avc














// import MediaKind as EMediaKind







/**
 * 
 * every instance of [[CodecTemplateOps]]
 * is a stateless interface to a codec impl
 * 
 * to get an instance decoding from desired URL,
 * use [[startForUrl]] or the related methods
 * 
 */
trait CodecTemplateOps extends
AnyRef 
with CodecOverview 
with CodecTplIsInstantiable
{ this1 =>

} /* interface CodecTemplateOps */
object CodecTemplateOps
{

   object Mpr {
      /**
       * expecting the callers to buffer more bytes
       */ 
      class MoreBytesPlease extends java.io.IOException
      /**
       * it's clear that the (buffered) data does not belong
       */ 
      class Mismatch        extends java.io.IOException
   }

   export %%!.ioUtil

}
/* the definitions needed to be split, to avoid compiler crash */
sealed 
trait CodecTplIsInstantiable extends
AnyRef 
{ this1 : CodecOverview =>

   type Instance
   
   /**
    * starts, tuned by given *flags*
    *
    * @param flags 
    */
   def startC(flags: String*): Instance
   
   /**
    * starts, from, or encoding to,
    * loc specified by `href`
    *
    * @param href 
    */
   def startForUrl(
      href: java.net.URI, 
      flags: IndexedSeq[String] = IndexedSeq() ,
   ): Instance

   /**
    * check whether *the header* matches, and, if so,
    * start
    *
    * @param src 
    */
   @`throws`[CodecTemplateOps.Mpr.MoreBytesPlease  ]("needs buffer more bytes")
   @`throws`[CodecTemplateOps.Mpr.Mismatch         ]("obvious mismatch")
   def matchesPreRead(src: ReadableBufferedSrc): Instance

   type ReadableBufferedSrc = (
      ioUtil.AsBuffered[(
         this1.Rd
      )]
   )

}
object  CodecTplIsInstantiable
{

   /* test */ 
   summon[((CodecOverview) with CodecTplIsInstantiable { type Rd = java.io.InputStream })#ReadableBufferedSrc <:< java.io.BufferedInputStream ]

   /* test */ 
   summon[((CodecOverview) with CodecTplIsInstantiable { type Rd = java.io.Reader })#ReadableBufferedSrc <:< java.io.BufferedReader ]

}



/**
 * 
 * instance constructed thru either way ; stateful
 * 
 */
trait CodecInstanceOps[+C <: CodecTemplateOps] extends 
AnyRef 
with java.io.Closeable
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




















































