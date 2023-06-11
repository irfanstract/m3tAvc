package cbsq.avc.codecs




















class EncodedFormsNcp()
{
   
   import cbsq.avc.{*}
   import cbsq.avc.upstream.{*}

   import ewfi.*

   val ewfiCodecTypers = {
      EwfiEmdo()
   }

   import ewfiCodecTypers.*

   object endp
   {
   ;

   export ewfiCodecTypers.*
   
   import encodedFormsECdl.*

   import encodedFormsEDcei.*

   // new XMediaRawCodecOverview {}

   trait XDemuxingProcHandleOpsBase extends
                        AnyRef
                        with java.io.Closeable
                        // with WithStreams[InDemuxStreamMap { type ChannelIdent <: Int } ]
                        with WithFrameIterator[BbsdAvInterleavedFrameIterator]
   {

      //

   }

   /**
    * 
    * syntactic convenience for 
    * implementing `optionalDecodeFnc` .
    * it's ur responsibility to ensure `mediaKind` matches
    * 
    */
   def newDemuxingProc1(
      src : java.io.InputStream ,
   )(

      mediaKind : MediaKind ,

      submitDecod : java.io.InputStream => BbsdAvFrameIterator ,
      
   ) = {
      ([C <: (
         XDemuxingProcHandleOpsBase

      )] => (a : C ) => (a : a.type ) )({
         
                        ;

                        type S = (
                           BbsdAvFrameIterator
                           & SupportsSwitchingToNextFrame[BbsdAvFrameIterator.IterativeContinuity ]
                           & SupportsCurrentlyPointedFrameTRangeQuery1
                        )

                        val chFrameIterator = {
                           submitDecod(src )
                           match { case s => (s : BbsdAvFrameIterator).asInstanceOf[S] }
                        }

                        new
                        AnyRef
                        with XDemuxingProcHandleOpsBase
                        {
                           
                           override
                           val frameIterator = {
                              // TODO
                              implicit val logger = {
                                 cbsq.avc.PhrStagedLogging.whichLogsTo(emitLine = l => { println(s"[NDP frameIterator] $l") ; Right {} } )
                              }
                              // InDemuxStreamMap.empty[Int, InMuxStream]
                              // .withAddedItem1(
                              //    streamId = 1,
                              //    payload = {
                              //       // chFrameIterator.asInstanceOf[InMuxStream]
                              //       ({ case value : InMuxStream => value } : (Any => InMuxStream) ).andThen(e => e).apply({})
                              //    } ,
                              // )
                              BbsdAvInterleavedFrameIterator.multiplexingAllInSeq(
                                 streamsInitially = IndexedSeq(chFrameIterator) ,
                                 shortestStreamsExtensionalMode = 1 ,
                              )
                           }

                           override
                           def close(): Unit = {
                              src.close()
                           }
                           
                        }
                        
      })
   }

   }

   export endp.*

}

















