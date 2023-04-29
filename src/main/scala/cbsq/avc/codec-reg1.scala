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
   
}







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



















