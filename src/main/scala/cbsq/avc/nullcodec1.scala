package cbsq.avc











export lBd.{value as blankingDemuxer } /* stable-path */
protected object lBd {
   lazy
   val value = (
      newBlankingDemuxer()
   )
}

object bdUtilCct {

   trait KStartible[+R] {

      def start(): R

   }

   trait CTasking extends
      AnyRef
      // with Selectable
      with MediaDeviceOverview /* Metals */
      // with MediaCodecOverview
      // with SAbbaAndArgisWereToi
   { c: MediaDeviceOverview =>

      type Args
         <: KStartible[? <: java.io.Closeable]

      val argsInitially: Args

      def spawn(a: Args ) =
         new Exception(s"initialising the task ($a)")
            .printStackTrace()
         (a.start(), (
            new Exception(s"done init the task ($a)")
               .printStackTrace()
         ))._1

      type Instance
         >: java.io.Closeable
         <: java.io.Closeable

   }

   @deprecated("experimental")
   trait CTasking1 extends
      AnyRef
      // with Selectable
      with MediaDeviceOverview /* Metals */
      // with MediaCodecOverview
      with CTasking
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
      with KStartible[R]
      {

         inline def start(): R =
            implStart()

      }

   }

}

object bdIoUtil {

   def drainAndWait(s: java.io.Closeable): Unit =
      import java.io.{IOError, IOException}
      import java.nio.channels.Channels
      import java.io.{InputStream, BufferedInputStream, ByteArrayInputStream }
      import java.io.{Reader     , BufferedReader     , CharArrayReader      }
      import java.io.OutputStream.nullOutputStream
      import java.io.Writer.nullWriter
      s match {

         case s : java.nio.channels.ReadableByteChannel =>
            Channels.newInputStream(s)
            .transferTo(nullOutputStream() )

         case s : java.io.InputStream   =>   s transferTo nullOutputStream()
         case s : java.io.Reader        =>   s transferTo nullWriter()

         case _ =>
            throw new IOException(s"unsupported : $s ")

      }

}

@deprecated
def newBlankingDemuxer() =
   //

   import bdIoUtil.drainAndWait

   import bdUtilCct.{CTasking, CTasking1 }

   trait C extends
      AnyRef
      // with Selectable
      with MediaCodecOverview
      with CTasking1
      // with SAbbaAndArgisWereToi
   { c =>

      final val encodedFormMimeType = "application/x-scalavfilter-discardingdemuxing"

      val mediaKind: EMediaKind.Mix.type =
         EMediaKind.Mix

      type CharacteristicFd
         >: java.io.InputStream | java.nio.channels.SeekableByteChannel | java.io.Reader
         <: java.io.InputStream | java.nio.channels.SeekableByteChannel | java.io.Reader

      extension [A <: Args](a: A)
         def withSpecString(s: SpecString)(using ArgsDerivCompletibility[A, a.type, ardtDrvWithSpecString.type] ) =
            noopInstance

      extension [A <: Args](a: A)

         def forUrl(s: java.net.URI | java.nio.file.Path)(using ArgsDerivCompletibility[A, a.type, ardtForUrl.type] ) =
            noopInstance

         def forOpenedStream(s: CharacteristicFd )(using ArgsDerivCompletibility[A, a.type, ardtForOpenedStream.type] ) =
            ForOpenedStream(s)

      private
      sealed
      class ForOpenedStream(s: CharacteristicFd )
      extends
      XTaskTemplate(implStart = () => {
         import concurrent.ExecutionContext.Implicits.global

         var shallPropagateClosedown: Boolean =
            true

         new Exception(s"starting the background drain-thread ($s)")
            .printStackTrace()
         summon[concurrent.ExecutionContext ]
         .execute(() => {
            drainAndWait(s)
            new Exception(s"successfully drained all from ($s)")
               .printStackTrace()
         } : Unit)

         object forOpenedStreamTaskHandle
         extends AnyRef with java.io.Closeable {

            def close(): Unit = {}

         }
         forOpenedStreamTaskHandle
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
      val dc = (
         blankingDemuxer
      )
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













