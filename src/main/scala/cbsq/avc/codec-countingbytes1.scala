package cbsq.avc









lazy val countingByteCodec = {
   
   import language.unsafeNulls

   import bdIoUtil.drainAndWait

   import bdUtilCct.{CTasking, CTasking1 }
   
   trait C extends
      AnyRef
      with MediaCodecOverview
      with CTasking1
   { c =>

      final val encodedFormMimeType = "application/x-scalavfilter-bytecountingtransmuxer"

      val mediaKind: EMediaKind.Mix.type =
         EMediaKind.Mix

      /* we deliberately choose `U_R_I`, not `U_R_L`. */

      type CharacteristicFd
         >: java.io.InputStream | java.nio.channels.SeekableByteChannel | java.io.Reader
         <: java.io.InputStream | java.nio.channels.SeekableByteChannel | java.io.Reader

      extension [A <: Args](a: A)
         def withSpecString(s: SpecString)(using ArgsDerivCompletibility[A, a.type, ardtDrvWithSpecString.type] ) =
            XTaskTemplate(implStart = () => startForUrl(new java.net.URI(s) ) )

      extension [A <: Args](a: A) {
         
         def forUrl(s: java.net.URI | java.nio.file.Path)(using ArgsDerivCompletibility[A, a.type, ardtForUrl.type] ) =
            XTaskTemplate(implStart = () => startForUrl(s) )

         def forOpenedStream(s: CharacteristicFd )(using ArgsDerivCompletibility[A, a.type, ardtForOpenedStream.type] ) =
            XTaskTemplate(implStart = () => startForOpenedStream(s,  propagateClosedown = s.close _) )

      }

      def startForUrl(s0: java.net.URI | java.nio.file.Path ): Instance =
         val s = (
            ((s0 match {
               
               case s0 : java.net.URI => 
                  s0
               case s0 : java.nio.file.Path => 
                  s0.toUri()

            }) : java.net.URI )
            .toURL().openStream()
         )
         startForOpenedStream(s, propagateClosedown = s.close _ )

      def startForOpenedStream(s: CharacteristicFd, propagateClosedown: () => Unit ): Instance =
         import concurrent.ExecutionContext.Implicits.*
         lazy val ppc1 = {
            propagateClosedown()
         }
         def main() = {
            // private
            def logg(u: Unit = (), msg: => String): Unit =
               sys.process.stderr
               .println("[StreamByteCountingDemuxer] : " + msg )
            try {
               logg(msg = "[bytecounting-demux] applying")
               bdIoUtil.countAndWait(s)
               logg(msg = "[bytecounting-demux] done")
            } finally {
               ppc1
            }
         }
         val asFuture = (
            concurrent.Future[Unit]({
               main()
            })
         )
         new 
         AnyRef 
         with java.io.Closeable 
         with bdUtilCct.KTask[Unit]
         {

            def close(): Unit = {
               ppc1
            }

            val asFuture1 = asFuture
            
         }

   }

   {
      new
         AnyRef
         with Selectable /* https://docs.scala-lang.org/scala3/reference/changed-features/structural-types.html */
         with C
   }

}

@main
def runCountingBytesDemuxTest(args: String* ): Unit = {
   import language.unsafeNulls

   import concurrent.ExecutionContext.Implicits.*
   import concurrent.duration.*
   class XIOE extends java.io.IOException("not supported")
   val throwstream = {
      val s = java.io.InputStream.nullInputStream()
      s.close()
      s
   }

   val dc = (
      countingByteCodec
   )

   util.Using.resource((
      dc.spawn((
         dc.argsInitially
         .forOpenedStream(new java.io.ByteArrayInputStream(new Array[Byte](0x100 ) ) )
      ) )
   ))(task => {
         concurrent.Await.result(task.asFuture1, 20.minutes)
   })
   util.Using.resource((
      dc.spawn((
         dc.argsInitially
         // .asReset
         // .asReset
         // .asReset
      ) )
   ))(task => {
         concurrent.Await.result(task.asFuture1, 20.minutes)
   })
   util.Using.resource((
      dc.spawn((
         dc.argsInitially
         .forOpenedStream(new java.io.ByteArrayInputStream(new Array[Byte](0x1000 ) ) )
      ) )
   ))(task => {
         concurrent.Await.result(task.asFuture1, 20.minutes)
   })
   {
      util.Try[Unit]({
         util.Using.resource({
            dc.spawn((
               dc.argsInitially
               .forOpenedStream((
                  throwstream
               ))
            ) )
         })(task => {
               concurrent.Await.result(task.asFuture1, 20.minutes)
         })
      })
      .recover({

         case z: InterruptedException =>
            z.printStackTrace() 
            
         case z: XIOE => 
            new Exception("caught intentional exception", z)
            .printStackTrace()

         case z: Exception =>
            z.printStackTrace() 

      })
   }
}












