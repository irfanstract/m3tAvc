package cbsq.avc














sealed 
abstract 
class  BbsdAvFrameHandler 
object BbsdAvFrameHandler 
{

   val videoToolkit: BbsdAvfhVideoToolkitOps = {
      object c extends BbsdAvfhVideoToolkitOps
      c
   }

   protected
   trait BbsdAvfhVideoToolkitOps
   {

         type VideoBuffer
            >: java.awt.image.WritableRenderedImage
            <: AnyRef

         export cbsq.avc.{ColorChannelsFmt }

   }
   
   /**
    * 
    * invoke `switchBuffer`, and then (on `thisBbfh`)
    * run an interval-delimited loop of invoc of the *propagateRefresh* method
    * 
    */
   abstract class OfVideoBufferSwitchToAndRefresh extends 
      Ovbsr 
      with OSwitchOfBuf[videoToolkit.VideoBuffer, Unit ]
      with TsAndPr
   {

   }

   /**
    * 
    * invoke `switchBuffer`, and then (on the returned BBFH)
    * run an interval-delimited loop of invoc of the *propagateRefresh* method
    * 
    * `switchBuffer` can be called more-tah-once,
    * resulting in multiple independent `TsAndPr`s
    * 
    */
   abstract class OfVideoBufferWrapRefresh
      extends 
      Ovbsr 
      with OSwitchOfBuf[videoToolkit.VideoBuffer, TsAndPr ]
   {

      /**
       *  
       * [[OfVideoBufferWrapRefresh]]
       * 
       * @note multiple instances can occur
       * 
       */
      def switchBuffer(
         b: AcceptableBuffer ,
         // not using VolatileImage as it's
      ): TsAndPr

   }

   /**
    * 
    * invoke `allocate` ("allocate a video-buffer"), and then (on the returned BBFH)
    * run an interval-delimited loop of invoc of the *propagateRefresh* method
    * 
    * `allocate` can be called more-than-once,
    * resulting in multiple independent `TsAndPr`s
    * 
    */
   abstract class OfVideoBufferAllocAndRefresh
      extends 
      Ovbsr 
      with Acp[TsAndPr]

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

   /**
    * 
    * `this` defines
    * - `Timestamp`
    * - `propagateRefresh(...): Unit`
    * 
    */
   trait  TsAndPr {
      
      type Timestamp

      def propagateRefresh(
         t: Timestamp ,
      ): Unit
      
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
trait BbsdAvFrameIterator
extends
AnyRef
with BbsdAvFrameIterator.IOfWhichMediaKind[MediaKind]
{
   this : (
      BbsdAvFrameIterator
      & BbsdAvFrameIterator.IOfWhichMediaKind[MediaKind]
   ) =>

   //

}

object BbsdAvFrameIterator
{

   abstract 
   class  EBaseOps
   extends
   AnyRef
   {
      
   }

   trait OfRegOfHandler[
      H <: BbsdAvFrameHandler ,
   ] extends 
      BbsdAvFrameIterator 
   {
      
      this : (
         BbsdAvFrameIterator
         & BbsdAvFrameIterator.IOfWhichMediaKind[MediaKind]
      ) =>

      def apply(r: H ): java.io.Closeable

   }

   type OfRegOfHandlerForMediaKind[
      K <: MediaKind ,
   ] = (
      OfRegOfHandler[(
         BbsdAvFrameHandler.OfMediaKind[K]
      )]
   )

   type OfIterAndBuf[
      B <: AnyRef ,
   ] = (
      AnyRef
      with BbsdAvFrameIterator 
      with SupportsSwitchingToNextFrame[IterativeContinuity ]
      with SupportsCurrentlyPointedFrameTRangeQuery1
      with SupportsBlittingOfCurrentlyFrameDataOntoPassedDest[B]
   )

   type IterativeContinuity
      >: Either[Unit | Throwable, Unit]
      <: Either[Unit | Throwable, Unit]

   trait IOfWhichMediaKind[+K](val mediaKind : K )

}



trait SupportsSwitchingToNextFrame[+R]
{
   
   def switchToNextFrame(): R

}

object SupportsSwitchingToNextFrame
{

   /**
    * 
    * most `SupportsSwitchingToNextFrame` impl(s)
    * builds on
    * maintaining a (private) `var` and making its `switchToNextFrame` method shift its value ;
    * at the same time,
    * it's rather easy
    * to invoke a neighbouring methods like `currentFrameTRange` and `renderCurrentFrameData` 
    * without having called `switchToNextFrame` first.
    * sadly
    * if `switchToNextFrame` has not been called,
    * other methods like `currentFrameTRange` and `renderCurrentFrameData`
    * would break, and `throw`s
    * 
    * this `trait`
    * (pre)defines
    * the internal `ensureAlreadyInitialised` method
    * which
    * subclasses can simply use to ensure `switchToNextFrame` has been called at-least once
    * 
    */
   transparent trait IEnsureAlreadyCalled[+R]
   {
            //
            this : SupportsSwitchingToNextFrame[R] =>
      
            /**
             * 
             * shall have called this,
             * otherwise they'll fail with eg NPE(s) or CCE(s) or etc
             * 
             */
            protected
            def ensureAlreadyInitialised() : Unit = {
               elss
            }

            private
            lazy val elss : R = {
               switchToNextFrame()
            }
            
   }

}

trait SupportsCurrentlyPointedFrameTRangeQuery[+R <: Matchable]
{

   def currentFrameTRange : R

}

type SupportsCurrentlyPointedFrameTRangeQuery1 = (
   SupportsCurrentlyPointedFrameTRangeQuery[(Double, Double)]
)

trait SupportsBlittingOfCurrentlyFrameDataOntoPassedDest[-B <: AnyRef]
{

   def renderCurrentFrameData(dest: B): Unit

} /* SupportsBlittingOfCurrentlyFrameDataOntoPassedDest */















