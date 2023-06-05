package cbsq.avc.codecs


















protected 
object encodedFormsECdl
{

   import cbsq.avc.{*}
   import cbsq.avc.upstream.{*}

   import ewfi.*

   type XDecoderInstance 
      >: java.io.Closeable & WithFrameIterator[BbsdAvFrameIterator]
      <: java.io.Closeable & WithFrameIterator[BbsdAvFrameIterator]

   trait XEncoderInstanceOps extends
   AnyRef
   with java.io.Closeable
   {

      def encodend_=(s : BbsdAvFrameIterator ) : Unit
      
   }

   type XR1[
      Dir <: "r" | "w",
      
      Chunk <: Byte | Char ,

   ] <: java.io.Closeable =
      (Dir, Chunk ) match {

         case ("r", Byte ) => (java.io.InputStream  ) | java.nio.channels.SeekableByteChannel
         case ("w", Byte ) => (java.io.OutputStream ) | java.nio.channels.SeekableByteChannel
         
         case ("r", Char ) => (java.io.Reader  ) | (java.io.Closeable & java.lang.CharSequence )
         case ("w", Char ) => (java.io.Writer  ) | (java.io.Closeable & java.lang.CharSequence )
         
      }

   type XRRW[Dir <: "r" | "w" ] = (
      XR1[Dir, Byte]
      | XR1[Dir, Char]
   )

}

protected 
object ewfi {

   /**
    * 
    * necessity-test ; use `Option[Unit]`
    * 
    */
   type NecessityTest 
      >: reflect.TypeTest[Option[Unit], ? <: Option[Unit] ]
      <: reflect.TypeTest[Option[Unit], ? <: Option[Unit] ]

   def appendableWriter(dest: Appendable) : java.io.Writer = {
      new java.io.Writer {

         def write(x$0: Array[Char] | Null, x$1: Int, x$2: Int): Unit = {
            dest append String(x$0 )
         }

         def flush() = {}
         
         def close() = {}

      }
   }

   // export cbsq.avc.{*}
   // export cbsq.avc.upstream.{*}

   trait WithFrameIterator[+R] { val frameIterator : R }  

}

protected 
object encodedFormsEDcei
{

   import cbsq.avc.{*}
   import cbsq.avc.upstream.{*}

   import ewfi.*

   import encodedFormsECdl.*

   //

   class XedfMuuxProperties
   
   trait XEagerDecodingFnc {

      def newSession(
         fmtProperties: XedfMuuxProperties,

      ) : (XRRW["w"], XDecoderInstance )      

   } 

   object XEagerDecodingFnc
   {

      extension (impl: XEagerDecodingFnc ) {

         def lazyForm : XLazyDecodingFnc = {

            import language.unsafeNulls

            identity[XLazyDecodingFnc]((src, fmtProperties) => {
               
               val session = impl newSession(fmtProperties )

               val (_, decodedFormItr) = session

               matchAndInvokeSrcTransferTo(src, session._1 )

               decodedFormItr
               
            })

         }

      }

   }

   trait XLazyDecodingFnc
   {

      /**
       * 
       * returns a decoding interface
       * 
       */
      // override
      def apply(
         src : XRRW["r"] ,
         fmtProperties: XedfMuuxProperties,
         
      ) : XDecoderInstance

   }

   trait XEagerEncodingFnc 
   {
      
      /**
       * 
       * runs encoding into/onto the given dest
       * 
       */
      // override
      def apply(
         decodedForm : BbsdAvFrameIterator,
         fmtProperties: XedfMuuxProperties,
         dest : XRRW["w"] ,

      ) : Unit

   }

   trait XLazyEncodingFnc
   {

      /**
       * 
       * returns an encoding interface
       * 
       */
      // override
      def apply(
         src : BbsdAvFrameIterator ,
         fmtProperties: XedfMuuxProperties,
         
      ) : XRRW["r"]

   }

   object XLazyEncodingFnc {
      
      extension (originalFnc : XLazyEncodingFnc ) {

         def eagerForm: XEagerEncodingFnc = {
            
               ; // TODO
               
               ((decodedFormItr, fmtProperties, dest) => {

                  val s = originalFnc(decodedFormItr, fmtProperties )
                  
                  matchAndInvokeSrcTransferTo(s, dest)
                  
               }) : XEagerEncodingFnc

         }
         
      }
      
   }

   val matchAndInvokeSrcTransferTo = {
      java.nio.CharBuffer.allocate(0x10)
      identity[(XRRW["r"], XRRW["w"] ) => Unit ]({
         
                     case (s : java.io.InputStream, dest: java.io.OutputStream ) =>
                        s transferTo dest

                     case (s : java.io.Reader, dest: java.io.Writer ) =>
                        s transferTo dest
                     case (s : java.io.Reader, dest: java.lang.Appendable ) =>
                        s transferTo appendableWriter(dest = dest )
                  
      })
   }

}

class EwfiEmdo()
{

   //

}


















































