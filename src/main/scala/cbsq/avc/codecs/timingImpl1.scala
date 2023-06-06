package cbsq.avc.codecs


















protected 
object timingImpl1
{

   type TRange
      >: ([E] =>> (E, E) )[concurrent.duration.FiniteDuration ]
      <: ([E] =>> (E, E) )[concurrent.duration.FiniteDuration ]

   export timingImplCurrentTimeAndSleepUntil.currentTime

   export timingImplCurrentTimeAndSleepUntil.sleepUntil

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

}

object timingImplCurrentTimeAndSleepUntil
{

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

}























































