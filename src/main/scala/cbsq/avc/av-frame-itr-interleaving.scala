package cbsq.avc



















trait BbsdAvInterleavedFrameIterator extends
BbsdAvFrameIterator
with SupportsSwitchingToNextFrame[BbsdAvFrameIterator.IterativeContinuity ]
with SupportsCurrentlyPointedFrameTRangeQuery1
with BbsdAvFrameIterator.IOfWhichMediaKind[MediaKind]
{

   val streams : (
      cbsq.avc.upstream.InDemuxStreamMap.OfBody[BbsdAvInterleavedFrameIterator.XPerStreamOps ]
   )
   
}
object BbsdAvInterleavedFrameIterator
{

   def multiplexingAllInSeq(

      streamsInitially : (
         IndexedSeq[MultiplexedImpl.internal.MicbItem ]
      ) ,

      shortestStreamsExtensionalMode : SupportedShortestStreamsExtensionalModeInt ,
      
   )(using cbsq.avc.PhrStagedLogging.ByDName["BbsdAvInterleavedFrameIterator$.multiplexing"] ) = {

      multiplexing(
         streamsInitially = {
            cbsq.avc.upstream.InDemuxStreamMap.enlistSeq(streamsInitially )
         } ,
         shortestStreamsExtensionalMode = shortestStreamsExtensionalMode ,
      )

   }

   type SupportedShortestStreamsExtensionalModeInt = (
      0 | 1
   )

   def multiplexing(

      streamsInitially : (
         MultiplexedImpl.Micb
      ) ,

      shortestStreamsExtensionalMode : SupportedShortestStreamsExtensionalModeInt ,
      
   )(using logger : cbsq.avc.PhrStagedLogging.ByDName["BbsdAvInterleavedFrameIterator$.multiplexing"] ) = {

      logger.enstage(term = s"initial streams : $streamsInitially" )

      logger.enstage(term = s"child stream lengths behv : $shortestStreamsExtensionalMode" )

      def propagateDiscontinuationalEvent() : Unit = {
         logger.enstage(term = "discontinuing" )
      }

      import MultiplexedImpl.internal.@@!

      val initialChannelsCount = {
         streamsInitially
         .getAllStreams()
         .size
      }

      val vsii = {

         Iterator.iterate[(@@!, Unit) ](({
            streamsInitially
            .mapValues(s => {
               s.switchToNextFrame()
            })
            @@!(
               streams = streamsInitially,
               xCurrentTValue = 0 ,
            )

         }, {} ) )({

            case (s, () ) =>

               import s.streams
               import s.runOutStreams
               import s.nonExhaustedStreams

               val t1 = s.tStamp01

               @@!(
                  streams = streams.fold(_ => nonExhaustedStreams ),
                  xCurrentTValue = t1 ,
               )
               match { case s => (s, {} ) }
               
         })

         .tapEach({ case (e, () ) => {
            logger.enstage(term = s"frame emitted: ${e }" )
         } })

         .map(_._1 )
         
         .takeWhile(s => {
            shortestStreamsExtensionalMode match {
               case 0 =>
                  s.nonExhaustedStreams.size < initialChannelsCount
               case 1 =>
                  s.nonExhaustedStreams.nonEmpty
            }
         })

         .concat({
            propagateDiscontinuationalEvent()
            Iterator()
         })

      }

      new BbsdAvInterleavedFrameIterator
      with BbsdAvFrameIterator.IOfWhichMediaKind[MediaKind.Mix.type ](mediaKind = MediaKind.Mix)
      with Ws(

         streams = {
            {
               
               streamsInitially
               
               .mapValues(channelOps => {

                  new
                  BbsdAvFrameIterator
                  with XPerStreamOpsBase
                  with SupportsBlittingOfCurrentlyFrameDataOntoPassedDest[AnyRef]
                  with IOfWhichMediaKind(mediaKind = channelOps.mediaKind )
                  {

                     override
                     def toString(): String = {
                        s"per-stream op : ${channelOps }"
                     }

                     export channelOps.currentFrameTRange
                     
                     val channelOpsCopybleAny = {
                        channelOps
                        match { case c : SupportsBlittingOfCurrentlyFrameDataOntoPassedDest[AnyRef] => c }
                     }

                     export channelOpsCopybleAny.renderCurrentFrameData

                  }

               } ) 

            }
            match { case e : cbsq.avc.upstream.InDemuxStreamMap.OfBody[s] => { e } }
         } ,

      )
      with SupportsSwitchingToNextFrame.IEnsureAlreadyCalled[Any]
      {

         override
         def toString(): String = {
            s"AvInterleavedFrameIterator @ ${state : @@! }"
         }

         override
         def switchToNextFrame(): cbsq.avc.BbsdAvFrameIterator.IterativeContinuity = {
            ;
            
            val lsnfLogger = logger enstage(term = s"switchToNextFrame()" )
            
            vsii.nextOption() match {

               case None =>
                  lsnfLogger enstage(term = s"vsii.isEmpty" )
                  lsnfLogger enstage(term = s"no more frames - returning Left {} " )
                  Left {}

               case Some(streams) =>
                  lsnfLogger enstage(term = s"streams: $streams " )
                  stateVar = streams
                  lsnfLogger enstage(term = s"got a frame - returning Right {} to indicate remainder " )
                  Right {}
                  
            }
         }

         def state = {
            ensureAlreadyInitialised()
            stateVar.nn
            stateVar
         }

         override
         def currentFrameTRange: (Double, Double) = {
            (state.tStamp00, state.tStamp10)
         }

         private 
         var stateVar : @@! = compiletime.uninitialized

      }
      match { case e => e }
      
   }

   object MultiplexedImpl
   {
      
      private[BbsdAvInterleavedFrameIterator] 
      type Micb = internal.Micb

      private[BbsdAvInterleavedFrameIterator] 
      object internal {
         
         type Micb = (
               cbsq.avc.upstream.InDemuxStreamMap.OfBody[MicbItem]
         )

         type MicbItem = (
            cbsq.avc.BbsdAvFrameIterator
            & SupportsSwitchingToNextFrame[BbsdAvFrameIterator.IterativeContinuity ]
            & SupportsCurrentlyPointedFrameTRangeQuery1
            & IOfWhichMediaKind[MediaKind]
         )

         def test1[P, Q] = {
            import cbsq.avc.upstream.InDemuxStreamMap
            summon[InDemuxStreamMap.OfIdentAndBody[P, Q] <:< (InDemuxStreamMap.OfIdent[P] & InDemuxStreamMap.OfBody[Q] ) ]
         }

         extension (s : Micb#ChannelBody) {

            def currentMinT = s.currentFrameTRange._1
            def currentMaxT = s.currentFrameTRange._2

         }

         extension [E <: Float | Double | BigDecimal](s : (E, E)) {

            def minT = s._1
            def maxT = s._2

         }

         class @@!(
            val streams: Micb ,
            xCurrentTValue : Double ,

         )
         {

            protected 
            def streamsCurrentlyTRanges = {
               streams.getAllStreams()
               .toIndexedSeq
               .map(_._3)
               .map({
                  case e : SupportsCurrentlyPointedFrameTRangeQuery1 =>
                     e
               })
               .map(s => s.currentFrameTRange )
            }
            
            val tStamp00 = {
               streamsCurrentlyTRanges.map(_.minT )
               .minOption
               .toSeq.prepended(xCurrentTValue ).max
            }
            
            // TODO
            val tStamp01 = {
               streamsCurrentlyTRanges.map(_.maxT )
               .filter(tStamp00 < _ )
               .minOption
               .getOrElse[Double](tStamp00 + 1 )
            }
            
            extension (s : streams.ChannelBody) {

               def advanceIfNecessary() : BbsdAvFrameIterator.IterativeContinuity = {
                  if (tStamp01 < s.currentMaxT ) {
                     Right {}
                  }
                  else {
                     val e = s.switchToNextFrame()
                     e
                  }
               }

            }

            advancedAll1
            object advancedAll1 {

               val result = {
                  streams.getAllStreams()
                  .toIndexedSeq
                  .map({
                     case (id, _, s) =>
                        val e = {
                           s.advanceIfNecessary()
                        }
                        (id, s, e)
                  })
               }

            }

            // TODO
            val tStamp10 = {
               streamsCurrentlyTRanges.map(_.minT )
               .minOption
               .getOrElse[Double](tStamp00 + 1 )
            }

            val runOutStreams = {
               advancedAll1.result
               .collect({
                  case (id, s, _ : Left[e, ?] ) =>
                     s
               })
            }
            
            val nonExhaustedStreams = {
               streams.getAllStreams()
               .filterNot({
                  case (_, _, s1) =>
                     runOutStreams contains s1
               })
            }

            override
            def toString(): String = {
               s"[@@! ; currentTValueInCtor: ${xCurrentTValue } ; t: ($tStamp00 to $tStamp01) ; streams: ${streams.getAllStreams() } ; ]"
            }
            
         }

      }
         
   }

   type XPerStreamOps
      >: XPerStreamOpsBase & SupportsBlittingOfCurrentlyFrameDataOntoPassedDest[AnyRef]
      <: XPerStreamOpsBase & SupportsBlittingOfCurrentlyFrameDataOntoPassedDest[AnyRef]
      
   trait XPerStreamOpsBase
   extends
   AnyRef
   with SupportsCurrentlyPointedFrameTRangeQuery1
   with IOfWhichMediaKind[MediaKind]
   {

   }

   /* as-hov trait to avoid the naming issues */
   trait Ws[
      +C <: cbsq.avc.upstream.InDemuxStreamMap.OfBody[BbsdAvInterleavedFrameIterator.XPerStreamOps ] ,

   ](val streams : C ) extends BbsdAvInterleavedFrameIterator

   export BbsdAvFrameIterator.IOfWhichMediaKind

   @deprecated
   object demo {

      def newFifthsItr() = {
         newTPeriodItr(tPeriod = 0.2 )
      }

      def newTPeriodItr(tPeriod : Double ) = {

         val tsIterator = {
            Iterator.iterate[BigDecimal](0 )(v => (v + tPeriod ) )
            .map(_.toDouble )
            .sliding(size = 2, step = 1)
            .map({ case Seq(t0, t1) => (t0, t1) })
         }

         new
         BbsdAvFrameIterator
         with SupportsSwitchingToNextFrame[BbsdAvFrameIterator.IterativeContinuity ]
         with SupportsSwitchingToNextFrame.IEnsureAlreadyCalled[Any]
         with SupportsCurrentlyPointedFrameTRangeQuery1
         with IOfWhichMediaKind(mediaKind = MediaKind.SideData )
         with SupportsBlittingOfCurrentlyFrameDataOntoPassedDest[AnyRef]
         {

            override
            def toString(): String = {
               s"[current t-range: ${currentFrameTRange } ; v: $v ]"
            }

            protected 
            def state = {
               ensureAlreadyInitialised()
               v
            }

            override def currentFrameTRange: (Double, Double) = state

            override
            def switchToNextFrame(): BbsdAvFrameIterator.IterativeContinuity = {
               tsIterator.nextOption() match {
                  case None => 
                     Left {}
                  case Some(value) => 
                     v = value
                     Right {}
               }
            }

            override
            def renderCurrentFrameData(dest: AnyRef): Unit = {
               /* ignorable unsupported op */
            }

            private 
            var v : (Double, Double) = compiletime.uninitialized

         }

      }

   }
   
}

@main
def runBbsdAvInterleavedFrameIterativeDemo() : Unit = {
   import BbsdAvInterleavedFrameIterator.demo.newTPeriodItr
   import BbsdAvInterleavedFrameIterator.multiplexingAllInSeq
   import BbsdAvInterleavedFrameIterator.multiplexing
   implicit val logger = {
      cbsq.avc.PhrStagedLogging.whichLogsTo(emitLine = l => { println(s"[main] $l") ; Right {} } )
   }
   val itr = {
      multiplexingAllInSeq(
         streamsInitially = {
            IndexedSeq()
            .appended(newTPeriodItr(tPeriod = 0.5 ) )
            .appended(newTPeriodItr(tPeriod = 0.18 ) )
         } ,
         shortestStreamsExtensionalMode = 1 ,
      )
   }
   for ((i, lg) <- Iterator.from(0).map(i => (i, logger.enstage(s"turn $i") ) ) ) {
      implicit val logger = lg

      val e = {
         Thread.sleep(1 * 1000 )
         logger enstage("=================")
         Thread.sleep(1 * 1000 )
         itr.switchToNextFrame()
      }

      logger enstage(s"$e ")
      
      logger enstage(s"itr ${itr } ")
      logger enstage(s"itr.currentFrameTRange ${itr.currentFrameTRange } ")
      for (s <- itr.streams.getAllStreams().map(_._3 ) ) {
         logger enstage(s"- s.currentFrameTRange ${s.currentFrameTRange } ")
      }

      Thread.sleep(2 * 1000 )

   }
}























