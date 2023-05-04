package cbsq.avc











def newBlankingDemuxer() = 
   //

   def synchronouslyDrain(s: java.io.Closeable): Unit =
      s match
         case s : java.io.InputStream    => s.readAllBytes()
         case s : java.io.BufferedReader => s.lines().forEach(_ => {})
         case s : java.io.Reader         => new java.io.BufferedReader(s).lines().forEach(_ => {})
         case _ => throw new java.io.IOException(s"unsupported : $s ")
      

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
      with SAbbaAndArgisWereToi
   { c =>

      final val encodedFormMimeType = "application/x-scalavfilter-discardingdemuxing"

      val mediaKind: EMediaKind.Mix.type =
         EMediaKind.Mix

      type CharacteristicFd
         >: java.io.InputStream | java.io.Reader
         <: java.io.Closeable

      val argsInitially: theOnlyArgs.type = 
         theOnlyArgs
      
      extension [A <: argsInitially.type](a: A) 
         def withSpecString(s: SpecString)(using A <:< argsInitially.type) =
            theOnlyArgs
      
      extension [A <: argsInitially.type](a: A) 
         
         def forUrl(s: java.net.URI | java.nio.file.Path) =
            theOnlyArgs
      
         def forOpenedStream(s: CharacteristicFd ) =
            new Thread(() => {
               synchronouslyDrain(s)
               new Exception(s"successfully drained all from ($s)")
               .printStackTrace()
            } : Unit).start()
            theOnlyArgs
      
      type Instance 
         >: java.io.Closeable 
         <: java.io.Closeable

      def spawn(a: Args ) =
         theOnlyArgs

      object theOnlyArgs extends 
      AnyRef
      with java.io.Closeable
      {

         // val host: c.type = c

         def close(): Unit = {}

      }

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
   }

}













