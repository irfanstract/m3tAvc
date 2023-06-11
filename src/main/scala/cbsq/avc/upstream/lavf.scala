package cbsq.avc.upstream

















type Lavf <: LavfCtxOps[?]

/**
 * 
 * .
 * 
 */
trait LavfCtxOps[Ctx]
extends
AnyRef
with LavfInputOpenupOps[Ctx, Nothing]
with LavfRnfOps[Ctx, Nothing]
{

}

/**
 * 
 * .
 * 
 */
trait LavfInputOpenupOps[-Ctx, -Fmt]
extends
AnyRef
{

   extension (ctx: Ctx) {

      /**
       * 
       * Open an input stream and read the header.
       * The codecs are not opened.
       * 
       * setting `fmt` to `null`
       * can be translated as a request for *probing* ;
       * however,
       * depending on the fmts
       * there may be limitations to *probing*,
       * 
       */
      @`throws`[java.io.IOException ]
      def openInput(
         //
         
         fmt : Fmt | Null = null ,

         src : (String | java.net.URI) | FmtCharacteristicFd[fmt.type] ,

         otherOpts : FmtSpecificOptions[fmt.type] = { Map() } ,
         
      ) : Unit

   }

   /**
    * 
    * for true codecs
    * this would be eg type-alt like `java.io.InputStream | java.io.OutputStream` ;
    * for devices (eg capture-dvcs) which don't,
    * this might evalt to `Nothing`
    * 
    */
   type FmtCharacteristicFd[F]
   
   /**
    * 
    * fmt-specific options as Map
    * 
    * must be
    * a type which the expr `Map()` conforms to
    * 
    */
   type FmtSpecificOptions[F]
      >: Map[?, Nothing]
      <: Map[?, Any]
   
}

/**
 * 
 * `readNextFrame`
 * 
 */
trait LavfRnfOps[-AvFormatCtx, -AvPacket]
{

   extension (ctx: AvFormatCtx) {

      /**
       * 
       * read the next frame from the stream (subject to usual decoding process).
       * exactly what's encoded in the file,
       * without regard to whether the decoded frame fmt/repr is supported by the codec.
       * 
       */
      def readNextFrame(p: AvPacket) : Unit

   }
   
}



































