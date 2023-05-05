package cbsq.avc











lazy
val blankingDemuxer = (
   newBlankingDemuxer()
)

object bdUtilCct {

   /**
    * 
    * this `trait` 
    * defines exactly `start(): R`
    * 
    */
   trait KStartible[+R] {

      def start(): R

   }

   /**
    * 
    * this `trait` 
    * defines exactly 
    * [[java.io.Closeable `close(): Unit`]] and *asFuture*
    * 
    * @tparam R  the return-value
    * 
    */
   trait KTask[+R] extends
      AnyRef
      with java.io.Closeable
   {
      
      /**
       * 
       * terminates the task.
       * idempotent.
       * 
       * note that there's `asFuture1: Future[R]`, meaning that
       * certain "resources" will need to be left allocated.
       * 
       */
      override
      def close(): Unit 

      /**
       * 
       * a/the `Future` proxying the task's return-value
       * 
       */
      val asFuture1: concurrent.Future[R]

   }

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
         new Exception(s"initialising the task ($a)")
            .printStackTrace()
         (a.start(), (
            new Exception(s"done init the task ($a)")
               .printStackTrace()
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
   class XTaskTemplate[+This, +R <: Any](

      implStart : () => R ,

   ) extends
   AnyRef
   with KStartible[R]
   {

      override
      inline def start(): R =
         implStart()

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
               new Exception(s"total bytes written: ${counter.get() } ")
               .printStackTrace()
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

         var shallPropagateClosedown: Boolean =
            true

         val (resolve, asFuture) = (
            bdUtilCct.newPromisePair[Unit]()
         )

         new Exception(s"starting the background drain-thread ($s)")
            .printStackTrace()
         concurrent.Future.unit
         .map(_ => {
            drainAndWait(s)
            new Exception(s"successfully drained all from ($s)")
               .printStackTrace()
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
def runNbdTest()(args: String* ): Unit = {
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













