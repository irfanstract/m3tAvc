package cbsq.avc











def newBlankingDemuxer() =
   //

   def synchronouslyDrain(s: java.io.Closeable): Unit =
      s match {

         case s : java.io.InputStream    => s.transferTo(java.io.OutputStream.nullOutputStream() )
         case s : java.io.Reader         => s.transferTo(java.io.Writer.nullWriter() )

         case _ => throw new java.io.IOException(s"unsupported : $s ")

      }

   trait CTasking extends
      AnyRef
      // with Selectable
      // with MediaCodecOverview
      // with SAbbaAndArgisWereToi
   { c: MediaDeviceOverview =>
      
      type Args
         >: XTaskTemplate[?, ? <: java.io.Closeable ]
         <: XTaskTemplate[?, ? <: java.io.Closeable ]

      val argsInitially: Args =
         noopInstance

      case object noopInstance
      extends XTaskTemplate(implStart = () => {
         case object noOpTask 
         extends java.io.Closeable 
         {
            def close(): Unit = {}
         }
         noOpTask
      })

      protected
      class XTaskTemplate[+This, +R <: Any](
         
         implStart : () => R ,

      ) extends
      AnyRef
      {

         inline def start(): R =
            implStart()

      }

   }

   trait C extends
      AnyRef
      // with Selectable
      with MediaCodecOverview
      with CTasking
      // with SAbbaAndArgisWereToi
   { c =>

      final val encodedFormMimeType = "application/x-scalavfilter-discardingdemuxing"

      val mediaKind: EMediaKind.Mix.type =
         EMediaKind.Mix

      type CharacteristicFd
         >: java.io.InputStream | java.io.Reader
         <: java.io.Closeable

      extension [A <: argsInitially.type](a: A)
         def withSpecString(s: SpecString)(using ArgsDerivCompletibility[A, a.type, ardtDrvWithSpecString.type] ) =
            noopInstance

      extension [A <: argsInitially.type](a: A)

         def forUrl(s: java.net.URI | java.nio.file.Path)(using ArgsDerivCompletibility[A, a.type, ardtForUrl.type] ) =
            noopInstance

         def forOpenedStream(s: CharacteristicFd )(using ArgsDerivCompletibility[A, a.type, ardtForOpenedStream.type] ) =
            ForOpenedStream(s)

      type Instance
         >: java.io.Closeable
         <: java.io.Closeable

      def spawn(a: Args ) =
         new Exception(s"initialising the task ($a)")
            .printStackTrace()
         (a.start(), (
            new Exception(s"done init the task ($a)")
               .printStackTrace()
         ))._1

      private
      sealed
      class ForOpenedStream(s: CharacteristicFd )
      extends
      XTaskTemplate(implStart = () => {
         var shallPropagateClosedown: Boolean =
            true
         new Exception(s"starting the background drain-thread ($s)")
            .printStackTrace()
         new Thread(() => {
            synchronouslyDrain(s)
            new Exception(s"successfully drained all from ($s)")
               .printStackTrace()
         } : Unit).start()
         new AnyRef with java.io.Closeable {
            def close(): Unit = {}
         }
      })

   }

   {
      new
         AnyRef
         with Selectable /* https://docs.scala-lang.org/scala3/reference/changed-features/structural-types.html */
         with C
   }

   // ()

object NbdTest {

   @main
   def main(args: String* ): Unit = {
      val dc = newBlankingDemuxer()
      dc.spawn((
         dc.argsInitially
         .forOpenedStream(new java.io.ByteArrayInputStream(Array.emptyByteArray ) )
      ) )
      dc.spawn((
         dc.argsInitially
         // .asReset
         // .asReset
         // .asReset
      ) )
   }

}













