package cbsq.avc.hw



















trait V_#@@% 
extends
cbsq.avc.BbsdAvFrameIterator 
with cbsq.avc.SupportsBlittingOfCurrentlyFrameDataOntoPassedDest[java.awt.image.BufferedImage ]
with cbsq.avc.BbsdAvFrameIterator.IOfWhichMediaKind[cbsq.avc.MediaKind.Video.type ]
{ 
   this : cbsq.avc.BbsdAvFrameIterator =>

   protected 
   def backingBufferedImg : java.awt.image.BufferedImage

   def currentFrameNativeResol : (Int, Int)

   def notifyAllImgConsumers() : Unit = {
      asJImgProducer
      .startProduction(V_#@@%.dummyImgConsumer )
   }

   @deprecated
   lazy val asJImgProducer : java.awt.image.ImageProducer = {

      def newOriginalProducer() = {
         backingBufferedImg
         .getSource().nn
      }

      new
      AnyRef
      with java.awt.image.ImageProducer
      with cbsq.avc.quick.java2d.ImageConsumerList
      {

         override
         def toString(): String = {
            s"asJImgProducer[consumers: ${getAllConsumersSc() } ;]"
         }

         override
         def requestTopDownLeftRightResend(x$0: java.awt.image.ImageConsumer | Null): Unit = {}

         /**
          * 
          * the returned interface
          * translates `STATICIMAGEDONE`s into `SINGLEFRAMEDONE`s
          * 
          */
         protected 
         def asSfdImageConsumer(c: java.awt.image.ImageConsumer) = {
            
            import language.unsafeNulls

            {
                  V_#@@%.getSustainingImageFilter()
                  /** otherwise we'd be left with the NPE-ing impl */
                  .getFilterInstance(c )
            }
            
         }

         override
         def startProduction(x$0: java.awt.image.ImageConsumer ): Unit = {
            import language.unsafeNulls

            addConsumerImpl(x$0)

            val s = newOriginalProducer()
            for (c <- getAllConsumersSc() ) {

               s addConsumer {
                  asSfdImageConsumer(c)
               }
               
            }
            s startProduction x$0

         }

      }

   }

}

object V_#@@% 
{

   extension (frameItr : V_#@@% ) {

      def getCopyOfCurrentFrame() = {
            import language.unsafeNulls
            import java.awt.image.BufferedImage
            val resol = frameItr.currentFrameNativeResol
            val buf = new BufferedImage(resol._1, resol._2, BufferedImage.TYPE_INT_ARGB )
            frameItr renderCurrentFrameData buf
            buf
      }
      
   }

   /**
    * 
    * rather than creating new `java.awt.image.ImageFilter`s everytime,
    * use this instead since the same `ImageConsumer` will not be added twice
    * 
    */
   lazy val dummyImgConsumer : java.awt.image.ImageConsumer = {
      cbsq.avc.quick.java2d.dummyImgConsumer
   }

   /**
    * 
    * an `ImageFilter` which
    * turns every `STATICIMAGEDONE` into `SINGLEFRAMEDONE`.
    * 
    */
   export cbsq.avc.quick.java2d.getSustainingImageFilter

}











































