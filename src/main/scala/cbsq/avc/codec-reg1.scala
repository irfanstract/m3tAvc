package cbsq.avc












import MediaKind as EMediaKind







object  CodecOverview {
   
   export isunsp.{value as IsUnspecified}
   protected 
   object isunsp {
      lazy val value : Null | Product =
         case object IsUnspecified1
         IsUnspecified1
   }

}
trait CodecOverview 
{ this1 =>

   val mimeType    : Null | String
   lazy
   val fourCcName  : Null | cbsq.riffmt.FourCC =
      null 

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

   object ioUtil {
      
      type ReaderFor[B <: java.nio.Buffer | AnyVal] <: (
         AnyRef
         & java.io.Closeable
      ) = 
         B match {
            case (java.nio.ByteBuffer   | Byte  ) => java.io.InputStream
            case (java.nio.CharBuffer   | Char  ) => java.io.Reader
         }

      type AsBuffered[B <: java.io.Closeable] <: (
         AnyRef
         & java.io.Closeable
      ) = 
         B match {
            case (java.io.InputStream) => java.io.BufferedInputStream
            case (java.io.Reader     ) => java.io.BufferedReader
         }

   }
   
}
/* the definitions needed to be split, to avoid compiler crash */
sealed 
trait CodecTplIsInstantiable extends
AnyRef 
{ this1 : CodecOverview =>

   type Instance
   
   def startForUrl(href: java.net.URI): Instance

   /**
    * check if matches the
    *
    * @param src 
    */
   @`throws`[CodecTemplateOps.Mpr.MoreBytesPlease  ]("needs to buffer more bytes")
   @`throws`[CodecTemplateOps.Mpr.Mismatch         ]("clearly mismatch")
   def matchesPreRead(src: ReadableBufferedSrc): Instance

   // type ReadableBufferedSrc <: (
   //    Nothing 
   //    | java.io.BufferedInputStream 
   //    | java.io.BufferedReader
   // )
   type ReadableBufferedSrc = (
      CodecTemplateOps.ioUtil.AsBuffered[(
         this1.Rd
      )]
   )

}
object  CodecTplIsInstantiable
{

   /* test */ 
   summon[((CodecOverview) with CodecTplIsInstantiable { type Rd = java.io.Reader })#ReadableBufferedSrc <:< java.io.BufferedReader ]

}



















