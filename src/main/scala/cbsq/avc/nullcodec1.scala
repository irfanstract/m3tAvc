package cbsq.avc











lazy
val blankingDemuxer = (
   newBlankingDemuxer()
)

object bdUtilCct {

   export IoTaskTemplating.KStartible

   export IoTaskTemplating.KTask

   @deprecated("experimental")
   def newPromisePair[R]()(using util.NotGiven[R <:< Nothing]) = {
      val r1 = (
         concurrent.Promise[R]
      )
      (r1.completeWith _, r1.future)
   }

   trait CTasking extends
      AnyRef
      // with Selectable
      with MediaDeviceOverview /* Metals */
      // with MediaCodecOverview
      // with SAbbaAndArgisWereToi
   { c: MediaDeviceOverview =>

      override
      inline
      def spawn(a: Args ): Instance =
         def logg(u: Unit = (), msg: => String): Unit =
            sys.process.stderr
            .println("[CTasking.spawn] : " + msg )
               
         logg(msg = s"initialising the task ($a)") 

         ((
            a.start()
         ), (
            logg(msg = s"done init the task ($a)")
         ))._1

      override
      type Args
         <: KStartible[? <: Instance]

      override
      type Instance
         <: java.io.Closeable & bdUtilCct.KTask[?]

      override
      val argsInitially: Args

   }

   // protected
   export IoTaskTemplating.{@@! as XTaskTemplate }

   @deprecated("experimental")
   trait CTasking1 extends
      AnyRef
      // with Selectable
      with MediaDeviceOverview /* Metals */
      // with MediaCodecOverview
      with CTasking
      // with SAbbaAndArgisWereToi
   { c: MediaDeviceOverview =>

      override
      type Args
         >: XTaskTemplate[? , Instance ]
         <: XTaskTemplate[? , Instance ]

      override
      val argsInitially: Args =
         noopInstanceTemplate

      override
      type Instance
         >: java.io.Closeable & bdUtilCct.KTask[?]
         <: java.io.Closeable & bdUtilCct.KTask[?]

      case object noopInstanceTemplate
      extends XTaskTemplate(implStart = () => {
         case object noOpTask
         extends 
         AnyRef 
         with java.io.Closeable
         with bdUtilCct.KTask[Unit]
         {

            private[noOpTask] 
            val alreadyResolved1 = concurrent.Future.unit

            def close(): Unit = {}

            val asFuture1 = alreadyResolved1

         }
         noOpTask
      })

      export bdUtilCct.XTaskTemplate

   }

}

object bdIoUtil {
   
   import java.io.{IOError, IOException}
   import java.nio.channels.Channels
   import java.io.{InputStream, BufferedInputStream, ByteArrayInputStream }
   import java.io.{Reader     , BufferedReader     , CharArrayReader      }
   import java.io.OutputStream.nullOutputStream
   import java.io.Writer.nullWriter

   export ioNullsinkings.drainAndWait

   export ioNullsinkings.countAndWait

   export ioNullsinkings.newByteCountingOutputStream

   export ioNullsinkings.BCOS

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

      val instancingLevel: MediaDeviceInstancingLevel = {
         MediaDeviceInstancingLevel.ofCompleteCodecSpace
      }

      type CharacteristicFd
         >: java.io.InputStream | java.nio.channels.SeekableByteChannel | java.io.Reader
         <: java.io.InputStream | java.nio.channels.SeekableByteChannel | java.io.Reader

      extension [A <: Args](a: A)
         def withSpecString(s: SpecString)(using ArgsDerivCompletibility[A, a.type, ardtDrvWithSpecString.type] ) =
            noopInstanceTemplate

      extension [A <: Args](a: A)

         def forUrl(s: java.net.URI | java.nio.file.Path)(using ArgsDerivCompletibility[A, a.type, ardtForUrl.type] ) =
            noopInstanceTemplate

         def forOpenedStream(s: CharacteristicFd )(using ArgsDerivCompletibility[A, a.type, ardtForOpenedStream.type] ) =
            ForOpenedStream(s)

      private
      sealed
      class ForOpenedStream(s: CharacteristicFd )
      extends
      XTaskTemplate(implStart = () => {
         import concurrent.ExecutionContext.Implicits.global
         
         // private
         def logg(u: Unit = (), msg: => String): Unit =
            sys.process.stderr
            .println("[StreamBlankingDemuxTask] : " + msg )

         var shallPropagateClosedown: Boolean =
            true

         val (resolve, asFuture) = (
            bdUtilCct.newPromisePair[Unit]()
         )

         logg(msg = s"starting the background drain-thread ($s)")
         concurrent.Future.unit
         .map(_ => {
            drainAndWait(s)
            logg(msg = s"successfully drained all from ($s)")
         })
         .transform(finally1 => util.Try((
            resolve((
               concurrent.Future.fromTry(finally1)
            ) )
         )) )

         object forOpenedStreamTaskHandle
         extends 
         AnyRef 
         with java.io.Closeable 
         with bdUtilCct.KTask[Unit]
         {

            def close(): Unit = {}

            val asFuture1 = asFuture

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
   
@main
def runBlankingDemuxingDemo(): Unit = {
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













