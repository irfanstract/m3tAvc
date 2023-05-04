package cbsq.avc











def newBlankingDemuxer() = 
   //

   def synchronouslyDrain(s: java.io.Closeable): Unit =
      s match {
         
         case s : java.io.InputStream    => s.transferTo(java.io.OutputStream.nullOutputStream() )
         case s : java.io.Reader         => s.transferTo(java.io.Writer.nullWriter() )

         case _ => throw new java.io.IOException(s"unsupported : $s ")
      
      }

   trait SInstWereOnlyArgs extends 
      AnyRef 
   { this : MediaDeviceOverview =>

      type Args
         <: AnyRef & java.io.Closeable
      
      type Instance 
         >: Args 
         <: Args

   }
   
   sealed
   trait SAbbaAndArgisWereToi extends 
      AnyRef 
   { this1 : MediaDeviceOverview =>
      
      type Args 
         >: theOnlyArgs.type 
         <: theOnlyArgs.type

      val argsInitially: theOnlyArgs.type
      
      val theOnlyArgs : (
         
         AnyRef

      )

   }

   trait C extends 
      AnyRef
      // with Selectable 
      with MediaCodecOverview 
      // with SAbbaAndArgisWereToi
   { c =>

      final val encodedFormMimeType = "application/x-scalavfilter-discardingdemuxing"

      val mediaKind: EMediaKind.Mix.type =
         EMediaKind.Mix

      type CharacteristicFd
         >: java.io.InputStream | java.io.Reader
         <: java.io.Closeable

      type Args 
         >: Jcx[?, ?]
         <: Jcx[?, ?]

      val argsInitially: Args = 
         noopInstance
      
      // lazy val noopInstance: Args = 
      //    new Jcx(initImpl = () => {})
      case object noopInstance 
      extends Jcx(initImpl = () => {})
      
      extension [A <: argsInitially.type](a: A) 
         def withSpecString(s: SpecString)(using ArgsDeriveCusPrereq[A, a.type, ardtDrvWithSpecString.type] ) =
            noopInstance

      case object ardtDrvWithSpecString
      
      extension [A <: argsInitially.type](a: A) 
         
         def forUrl(s: java.net.URI | java.nio.file.Path)(using ArgsDeriveCusPrereq[A, a.type, ardtForUrl.type] ) =
            noopInstance
      
         def forOpenedStream(s: CharacteristicFd )(using ArgsDeriveCusPrereq[A, a.type, ardtForOpenedStream.type] ) =
            ForOpenedStream(s)
      
      case object ardtForUrl
      
      case object ardtForOpenedStream
      
      type Instance 
         >: java.io.Closeable 
         <: java.io.Closeable

      def spawn(a: Args ) =
         new Exception(s"initialising the task ($a)")
            .printStackTrace()
         a.init()
         new Exception(s"done init the task ($a)")
            .printStackTrace()
         a

      private[C] 
      class Jcx[+This, +R](
         initImpl: () => R ,
         // summary: (c: Any) => String ,
         propagateClosedownCall: () => Unit = () => {} ,
      ) extends 
      AnyRef 
      with java.io.Closeable
      {

         lazy val result : R = initImpl()

         def init(): Unit = result

         def close(): Unit = {}

         // override def toString(): String = ???

      }

      private 
      sealed 
      class ForOpenedStream(s: CharacteristicFd ) 
      extends 
      Jcx(initImpl = () => {
         new Exception(s"starting the background drain-thread ($s)")
            .printStackTrace()
         new Thread(() => {
            synchronouslyDrain(s)
            new Exception(s"successfully drained all from ($s)")
               .printStackTrace()
         } : Unit).start()
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
         .asReset
         .asReset
         .asReset
      ) )
   }

}













