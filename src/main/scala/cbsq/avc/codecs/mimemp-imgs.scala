package cbsq.avc.codecs















protected
class asFrameItrImpl(

   srcE: Iterator[cbsq.avc.MimeMultipart.CtclQueryOps ] ,

) {

   val mediaTypeQuestion = {
      cbsq.avc.LateBoundValue.newInstance[cbsq.avc.MediaKind ]
   }
   export mediaTypeQuestion.{value => mediaType }

   assert(mediaTypeQuestion.asFuture.value.isEmpty )

   import asFrameItrImplImpl.TAnnotHandler1

   protected 
   val tAnnotHandlerQuestion = {
      cbsq.avc.LateBoundValue.newInstance[TAnnotHandler1 ]
   }
   final lazy val tAnnotHandler = {
      tAnnotHandlerQuestion
      .asFuture
      .value.get.get
   }

   def giveRealTimeRate( ): Unit = {

      tAnnotHandlerQuestion success {
         TAnnotHandler1.forRealtime()
      }
      
   }

   def giveFixedRate(v: concurrent.duration.FiniteDuration, throttle: Boolean): Unit = {

      tAnnotHandlerQuestion success {

         TAnnotHandler1.forFixedPredefinedPeriod(
            assumedFramePeriod = v ,
            throttle = throttle ,
         )

      }

   }

   import tAnnotHandler.{zipWithTimeRangesE => zipWithTAnnotTimeRangesE }

   lazy val decodingItr : cbsq.avc.BbsdAvFrameIterator = {

      val smpItr1 = {

         srcE

         .zipWithTAnnotTimeRangesE()

      }

      // /**
      //  * 
      //  * as LazyList ;
      //  * must be completely foregone past this init !
      //  * 
      //  */
      // val framesEachAsSrc = {
      //    smpItr1
      //    .to(LazyList)
      // }

      var currentAlloc1 : java.awt.image.BufferedImage = {
         new java.awt.image.BufferedImage(1, 1, java.awt.image.BufferedImage.TYPE_INT_RGB )
      }

      {
         import cbsq.avc.*

         type Dest
            >: java.awt.image.BufferedImage
            <: java.awt.image.BufferedImage

         new
         // AnyRef
         // with cbsq.avc.BbsdAvFrameIterator.OfIterAndBuf[Unit]
         BbsdAvFrameIterator 
         with SupportsSwitchingToNextFrame[Unit]
         with SupportsCurrentlyPointedFrameTRangeQuery1
         with SupportsBlittingOfCurrentlyFrameDataOntoPassedDest[Dest]
         {

            override
            def switchToNextFrame(): Unit = {

               smpItr1.nextOption()
               match {

                  case Some((data, tRange ) ) =>
                     val analysis = {
                        asFrameItrImplImpl.byImgData1(data )
                     }
                     anl1 = (analysis, tRange)

                  case None => 
                     throw new java.util.NoSuchElementException

               }
               
            }

            var anl1 : (asFrameItrImplImpl.byImgData1, asFrameItrImplImpl.TRange ) = compiletime.uninitialized

            override
            def currentFrameTRange = {

               (anl1._2 match { case (v1, v2) => (v1, v2) } )

               .map[
                  [E] =>> (
                  // E match {
                  //    case concurrent.duration.FiniteDuration => Double
                  // }
                  Double
                  ) ,
               ]({
                  // [t] => (((value) => ??? ) : (t => R[t]) )
                  // ???
                  [A] => (value: A) => (value match { case t : concurrent.duration.FiniteDuration => t.toMillis.toDouble./(1000) })
               })

            }

            override
            def renderCurrentFrameData(dest: Dest): Unit = {

               import language.unsafeNulls

               currentAlloc1 = {
                  anl1._1
                  .tryDecodeInto(dest )
               }

               tryRender()
               def tryRender(): Unit = {
                  val src = currentAlloc1
                  ({
                     val g = dest.createGraphics()
                     try g.drawRenderedImage(src, {
                        java.awt.geom.AffineTransform.getScaleInstance(
                           dest.getWidth().toDouble  / src.getWidth()  ,
                           dest.getHeight().toDouble / src.getHeight() ,
                        )
                     } )
                     finally g.dispose()
                  })
               }
               
            }

            //
            
         }
         
      }
      
   }

   // ???
   
}

protected 
object asFrameItrImplImpl
{

   type TRange
      >: ([E] =>> (E, E) )[concurrent.duration.FiniteDuration ]
      <: ([E] =>> (E, E) )[concurrent.duration.FiniteDuration ]

   def currentTime = {
      import concurrent.duration.*
      0.seconds.fromNow
   }

   def sleepUntil(t: concurrent.duration.Deadline): Unit = {
      
                              import concurrent.duration.*
                              
                              t.timeLeft 
                              match { case timeLeft => timeLeft.max(0.seconds) }
                              match { case timeLeft => Thread.sleep(timeLeft.toMillis ) }

   }

   def newEllaptionalRealTStampIterator() = {
      
               import concurrent.duration.*

               lazy val startT = {
                  currentTime
               }

               val tStampIterator = {
                  Iterator.continually[FiniteDuration](currentTime - startT )
               }

               tStampIterator
               
   }

   abstract class TAnnotHandler1 {

      def decorateIterator[E](src: Iterator[E]): Iterator[(E, TRange)]

      extension [E](src: Iterator[E]) {
         def zipWithTimeRangesE() = {
            decorateIterator(src )
         }
      }

   }
   object TAnnotHandler1
   {

      def forRealtime(
         // assumedFramePeriod : concurrent.duration.FiniteDuration,
         
      ) = {

         new TAnnotHandler1 {

            def decorateIterator[E](srcE: Iterator[E]) = {

               val tStampIterator = {
                  newEllaptionalRealTStampIterator()
               }
               
               srcE zip ({
                  tStampIterator
                  .sliding(size = 2, step = 1)
                  .map({ case Seq(t0, t1) => (t0, t1 ) }) 
               })

            }
            
         }

      }

      def forFixedPredefinedPeriod(
         assumedFramePeriod : concurrent.duration.FiniteDuration,

         throttle : Boolean ,
         
      ) = {

         def newTStampIterator() = {
            
                  Iterator.from(0)
                  
                  .map((i: Int) => {
                     
                     import concurrent.duration.*

                     (({
                        assumedFramePeriod.`*`(i )
                     }, assumedFramePeriod.`*`(i + 1 ) ) : asFrameItrImplImpl.TRange )

                  } : asFrameItrImplImpl.TRange )

         }
         
         new TAnnotHandler1 {

            def decorateIterator[E](srcE: Iterator[E]) = {

               lazy val startT = {
                  currentTime
               }

               val tStampIterator = {

                  import concurrent.duration.*

                  // import scala.jdk.DurationConverters.ScalaDurationOps

                  newTStampIterator()
                  .tapEach(tRange => {
                     if (throttle) {
                        ((startT + tRange._1) )
                        match {

                           case t =>
                              sleepUntil(t)

                        }
                     }
                  })

               }
               
               srcE
               
               .zip(tStampIterator )

            }

         }

      }
      
   }

   class byImgData1(

      data : cbsq.avc.MimeMultipart.CtclQueryOps ,

   )
   {

      /**
       * 
       * attempt decoding into given `BufferedImage`,
       * making re-alloc if necessary (Width*Height, ColorSpace, )
       * 
       */
      def tryDecodeInto(

         buffer0: java.awt.image.BufferedImage ,

      ) : java.awt.image.BufferedImage = {

         ;

         // import language.unsafeNulls

         import javax.imageio

         import imageio.ImageIO

         val dataReader = {
            data
            .payload
            .newGrossReader()
         }
         
         val dataReaderIio = {
            dataReader
            match {
               case r =>
                  new imageio.stream.MemoryCacheImageInputStream(r)
            }
            
         } : imageio.stream.ImageInputStream

         val imgr1 = {
            
            import scala.jdk.CollectionConverters.*

            ImageIO.getImageReaders(dataReaderIio).nn
            match { case s => s.asScala }
            match { case s => s.next() }

         }
         imgr1 setInput(dataReaderIio )

         val resol = (
            imgr1.getWidth(0) ,
            imgr1.getHeight(0) ,
         )

         val buffer1Pre = {
            
            Option(buffer0 )

            .filter(e => {

               true
               .&&(resol._1 <= e.getWidth() )
               .&&(resol._2 <= e.getHeight() )
               .&&({
                  import language.unsafeNulls
                  e.getColorModel().hasAlpha() == true
               })

            })
            
            .getOrElse({

               buffer0
               .newCompatibleBufferedImage1(resol = resol )

            })

         }

         val buffer1 = {
            
            imgr1
            .read(0, {
               val p = new imageio.ImageReadParam()
               p.setDestination(buffer1Pre )
               p
            })
            .nn

         }

         buffer1
         
      }
      
   }

   extension (buffer0 : java.awt.image.RenderedImage ) {

      def newCompatibleBufferedImage1(
         resol : (Int, Int) ,
         
      ) = {

               import language.unsafeNulls

               /**
                * 
                */
               val cm = {
                  buffer0
                  .getColorModel()
               }
               
               val raster = {
                  cm
                  .createCompatibleWritableRaster(resol._1, resol._2 )
               }

               new java.awt.image.BufferedImage(cm, raster, {
                  // TODO
                  cm.isAlphaPremultiplied()

               }, null )

      }

   }

}














































