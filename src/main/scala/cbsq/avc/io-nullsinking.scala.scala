package cbsq.avc

















object ioNullsinkings {
   
   import java.io.{IOError, IOException}

   import java.nio.channels.Channels
   import java.io.{InputStream, BufferedInputStream, ByteArrayInputStream }
   import java.io.{Reader     , BufferedReader     , CharArrayReader      }
   
   import java.io.OutputStream.nullOutputStream
   import java.io.Writer.nullWriter

   def drainAndWait(s: java.io.Closeable): Unit =
      s match {

         case s : java.nio.channels.ReadableByteChannel =>
            Channels.newInputStream(s)
            .transferTo(nullOutputStream() )

         case s : InputStream   =>   s transferTo nullOutputStream()
         case s : Reader        =>   s transferTo nullWriter()

         case _ =>
            throw new IOException(s"unsupported : $s ")

      }

   def countAndWait(s: java.io.Closeable): Unit =
      s match {

         case s : java.nio.channels.ReadableByteChannel =>
            util.Using(newByteCountingOutputStream())(out => {
               Channels.newInputStream(s)
               .transferTo(out )
            })

         case s : InputStream   =>   
            util.Using(newByteCountingOutputStream())(out => {
               s transferTo out
            })

         case _ =>
            throw new IOException(s"unsupported : $s ")

      }

   def newByteCountingOutputStream(): java.io.OutputStream = {
      val counter = (
         new java.util.concurrent.atomic.AtomicLong(0)
      )
      new java.io.BufferedOutputStream((
         new BCOS(counter = counter) {

            override 
            def close(): Unit = {
               tbw
            }

            lazy val tbw = {
               def logg(msg: => String): Unit =
                  sys.process.stderr
                  .println("[ByteCountingOutputStream]: " + msg )

               logg(msg = s"total bytes written: ${counter.get() } ")
            }

         }
      ))
   }

   @deprecated("experimental")
   // protected 
   class BCOS(
      counter: java.util.concurrent.atomic.AtomicLong ,
   ) extends java.io.OutputStream {

      def write(b: Int): Unit = 
         counter.incrementAndGet()

      override
      def write(b: Array[Byte], off: Int, len: Int): Unit = 
         counter addAndGet(len - off)
      
      override
      def write(b: Array[Byte] ): Unit = 
         write(b, 0, b.length)
         
   }

}
















