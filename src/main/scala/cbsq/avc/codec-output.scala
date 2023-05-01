package cbsq.avc














sealed 
abstract 
class  BbsdAvFrameHandler 
object BbsdAvFrameHandler 
{

   trait OSwitchOfBuf[
      AcceptableBufferI <: AnyRef ,
      +R ,
   ] {

      type AcceptableBuffer = AcceptableBufferI
      
      def switchBuffer(
         b: AcceptableBuffer ,
         // not using VolatileImage as it's
      ): R

   }

   trait  TsAndPr {
      
      type Timestamp

      def propagateRefresh(
         t: Timestamp ,
      ): Unit
      
   }
   
   abstract class OfVideoBufferSwitchAndRefresh extends 
      Ovbsr 
      with OSwitchOfBuf[? >: java.awt.image.WritableRenderedImage <: AnyRef, Unit ]
      with TsAndPr
   {

   }

   abstract class OfVideoBufferSwitchRefresh
      extends 
      Ovbsr 
      with OSwitchOfBuf[? >: java.awt.image.WritableRenderedImage <: AnyRef, TsAndPr ]
   {

   }

   type OfVideo 
      >: Ovbsr
      <: Ovbsr

   sealed 
   abstract class Ovbsr extends BbsdAvFrameHandler
   
   sealed 
   abstract class OfAudio extends BbsdAvFrameHandler
   
   sealed 
   abstract class OfSubtitles extends BbsdAvFrameHandler

   type OfMediaKind[K <: MediaKind] <: BbsdAvFrameHandler = 
      K match {

         case (MediaKind.Audio.type    ) => OfAudio
         
         case (MediaKind.Captions.type ) => OfSubtitles
         case (MediaKind.Video.type    ) => OfVideo

         // TODO for the missing cases

      }
   
}



// sealed 
abstract 
class  BbsdAvFrameIterator
object BbsdAvFrameIterator
{

   trait OfRegOfHandler[
      H <: BbsdAvFrameHandler ,
   ] extends 
      BbsdAvFrameIterator 
   {
      
      def apply(r: H ): java.io.Closeable

   }

   type OfRegOfHandlerForMediaKind[
      K <: MediaKind ,
   ] = (
      OfRegOfHandler[(
         BbsdAvFrameHandler.OfMediaKind[K]
      )]
   )

   trait OfIterAndBuf[
      B <: AnyRef ,
   ] extends 
      BbsdAvFrameIterator 
   {
      
      def switchToNextFrame(): Unit

      def currentFrameTRange : (Double, Double)

      def renderCurrentFrameData(dest: B): Unit

   }

}















