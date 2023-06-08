package cbsq.avc.codecs















extension (src : java.io.InputStream) {

   def decodeMpJpegImpl(delimiterCPre: String ) = {
      ;

      import cbsq.avc.MediaKind

      import cbsq.avc.quick.rmpdUtils

      val pItr = {
         src demuxMimeMultipartStream(delimitingLinePre = delimiterCPre )
      }
      
      val pc = {
         val impl = cbsq.avc.codecs.asFrameItrImpl(srcE = pItr )
         impl.giveRealTimeRate()
         impl.mediaType_=(MediaKind.Video )
         impl
      }

      pc.decodingItr
      
   }

}

// protected
class asFrameItrImpl(

   srcE: Iterator[cbsq.avc.MimeMultipart.CtclQueryOps ] ,

) {

   import asFrameItrImplImpl.getAnswerNow

   val mediaTypeQuestion = {
      cbsq.avc.LateBoundValue.newInstance[cbsq.avc.MediaKind ]
   }
   final lazy val mediaType = {
      mediaTypeQuestion
      .getAnswerNow(getNullCaseDefault = () => {
         throw new IllegalStateException(s"no 'mediaType' set yet. assign it first. ") 
      } )
   }
   export mediaTypeQuestion.{success => mediaType_= }
   export mediaTypeQuestion.{success => defineMediaType }

   assert(mediaTypeQuestion.asFuture.value.isEmpty )

   import asFrameItrImplImpl.TAnnotHandler1

   protected 
   val tAnnotHandlerQuestion = {
      cbsq.avc.LateBoundValue.newInstance[TAnnotHandler1 ]
   }
   final lazy val tAnnotHandler = {
      tAnnotHandlerQuestion
      .getAnswerNow(getNullCaseDefault = () => {
         throw new IllegalStateException(s"no 'tAnnotHandler' set yet. invoke a 'giveYyyRate' method first. ") 
      } )
   }

   @deprecated("experimental")
   def tAnnotHandler_=(impl: TAnnotHandler1 ): Unit = {
      tAnnotHandlerQuestion success impl
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

      {
         
         import cbsq.avc.*

         trait CrossTypeCommonOps1
         extends
         // AnyRef
         // with cbsq.avc.BbsdAvFrameIterator.OfIterAndBuf[Unit]
         BbsdAvFrameIterator 
         with SupportsSwitchingToNextFrame[BbsdAvFrameIterator.IterativeContinuity ]
         with SupportsCurrentlyPointedFrameTRangeQuery1
         {
            
         }

         mediaType match {
         //

         case mediaKind @ (_ : cbsq.avc.MediaKind.Video.type) =>
            
            type Dest
               >: java.awt.image.BufferedImage
               <: java.awt.image.BufferedImage

            var currentAlloc1 : java.awt.image.BufferedImage = {
               new java.awt.image.BufferedImage(1, 1, java.awt.image.BufferedImage.TYPE_INT_RGB )
            }

            new
            // AnyRef
            // with cbsq.avc.BbsdAvFrameIterator.OfIterAndBuf[Unit]
            BbsdAvFrameIterator 
            with CrossTypeCommonOps1
            with SupportsBlittingOfCurrentlyFrameDataOntoPassedDest[Dest]
            with BbsdAvFrameIterator.IOfWhichMediaKind(mediaKind = mediaKind )
            with V_#@@%
            {

               override
               def toString(): String = {
                  s"MIMEMP DECODING [state: ${anl1 } ; ]"
               }

               override
               def switchToNextFrame(): BbsdAvFrameIterator.IterativeContinuity = {

                  smpItr1.nextOption()
                  match {

                     case Some((data, tRange ) ) =>
                        
                        val analysis = {
                           asFrameItrImplImpl.byImgData1(data )
                        }
                        
                        currentAlloc1 = {
                           analysis
                           .tryDecodeInto(currentAlloc1 )
                        }

                        anl1 = (analysis, tRange)

                        notifyAllImgConsumers()

                        Right {}
                        
                     case None => 
                        Left {}

                  }

               }

               override
               def currentFrameNativeResol = {
                  (currentAlloc1.getWidth(), currentAlloc1.getHeight() )
               }

               override
               def currentFrameTRange: (Double, Double) = {

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

                  tryRender()
                  def tryRender(): Unit = {
                     val src = backingBufferedImg
                     asFrameItrImplImpl.blitResized(src, dest )
                  }
                  
               }

               override
               def backingBufferedImg : java.awt.image.BufferedImage = {
                  currentAlloc1
               }

               var anl1 : (asFrameItrImplImpl.byImgData1, asFrameItrImplImpl.TRange ) = compiletime.uninitialized

               //
               
            }
            
         }

      }
      
   }

   // ???
   
}

protected 
object asFrameItrImplImpl
{

   extension [E](q: cbsq.avc.LateBoundValue.NhwGetValue[? <: E] ) {

      def getAnswerNow(getNullCaseDefault: () => E ): E = {
         q
         .asFuture
         .value.getOrElse(util.Try(getNullCaseDefault() ) ).get
      }

   }

   // type TRange
   //    >: ([E] =>> (E, E) )[concurrent.duration.FiniteDuration ]
   //    <: ([E] =>> (E, E) )[concurrent.duration.FiniteDuration ]
   export timingImpl1.TRange

   export timingImpl1.currentTime

   export timingImpl1.sleepUntil

   export timingImpl1.newEllaptionalRealTStampIterator

   export timingImpl1.TAnnotHandler1

   class byImgData1(

      data : cbsq.avc.MimeMultipart.CtclQueryOps ,

   )
   {

      override
      def toString(): String = {
         s"[explicitMimeType: ${specifiedMimeTypeOptional.orNull } ; data: ${data } ]"
      }

      lazy val specifiedMimeTypeOptional = {

         (util.Try { data.contentTypeHeaderValue } )
         match {
            case util.Failure(v : java.util.NoSuchElementException) =>
               None
            case e =>
               Some(e.get )
         }
         
      } : Option[String]

      /**
       * 
       * locate and instantiate most-appropriate `ImageReader`,
       * either by `specifiedMimeTypeOptional` if non-empty or instead
       * probing from the given `ImageInputStream`
       * 
       */
      protected 
      def getPreSpecifiedImgReaderOrProbe(
         dataReaderIio : javax.imageio.stream.ImageInputStream ,

         ifExplicitMimeTypeThenAllowFallbackToProbing : Boolean = true ,
         
      ) = {
            
            import javax.imageio
            import imageio.ImageIO

            import scala.jdk.CollectionConverters.*

            Iterator()
            .concat[imageio.ImageReader]({

               specifiedMimeTypeOptional match {
                  
                  case Some(specifiedMimeType) =>

                     Iterator()

                     .concat[imageio.ImageReader]({

                        ImageIO.getImageReadersByMIMEType(specifiedMimeType).nn.asScala

                     })
                     
                     .concat[imageio.ImageReader]({

                        if ifExplicitMimeTypeThenAllowFallbackToProbing then {
                           ImageIO.getImageReaders(dataReaderIio).nn.asScala
                        }
                        else Iterator()
                        
                     })
                     
                  case None =>
                     
                     ImageIO.getImageReaders(dataReaderIio).nn.asScala

               }
               
            })
            .next()

      }

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
            
            getPreSpecifiedImgReaderOrProbe(
               dataReaderIio = dataReaderIio )

         }
         imgr1 setInput(dataReaderIio )

         val resol = (
            imgr1.getWidth(0) ,
            imgr1.getHeight(0) ,
         )

         val buffer1Pre = {
            
            Option(buffer0 )

            .filter(buf => {

               true
               .&&(resol._1 != buf.getWidth() )
               .&&(resol._2 != buf.getHeight() )
               .&&({
                  import language.unsafeNulls
                  buf.getColorModel().hasAlpha() == true
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

   export cbsq.avc.quick.java2d.ImageCopyOfs.blitResized

   export cbsq.avc.quick.java2d.ImageCopyOfs.newCompatibleBufferedImage1

   /**
    * 
    * rather than creating new `java.awt.image.ImageFilter`s everytime,
    * use this instead since the same `ImageConsumer` will not be added twice
    * 
    */
   lazy val dummyImgConsumer : java.awt.image.ImageConsumer = {
      cbsq.avc.quick.java2d.dummyImgConsumer
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
    * turns every `STATICIMAGEDONE` into `SINGLEFRAMEDONE`
    * 
    */
   export cbsq.avc.quick.java2d.getSustainingImageFilter

}

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














































