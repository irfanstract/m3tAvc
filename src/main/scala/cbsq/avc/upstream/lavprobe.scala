package cbsq.avc.upstream


















trait LavProbeOps[AvProbeCtx]
{

   def newInstance() : AvProbeCtx

   extension [A <: AvProbeCtx ](this1: A ) {

      /**
       * 
       * 
       * guess the mux format.
       * 
       *
       * @param assumeTheFileAlreadyOpened
       * 
       * 
       */
      def probeInputMuxFmt(
         assumeTheFileAlreadyOpened: Boolean ,
         
      ) = {

         var score: Int = 0

         this1
         .probeInputMuxFmt2(
            
            assumeTheFileAlreadyOpened = assumeTheFileAlreadyOpened ,

            maxScore = score ,
            updateMaxScoreTo = v => { score = v } ,
            
         )
      }

      /**
       * 
       * 
       * guess the mux format.
       * afterwards,
       * `updateMaxScoreTo` will be invoked with the final score .
       * 
       *
       * @param assumeTheFileAlreadyOpened
       * 
       * @param maxScore
       *    in order to be accepted
       *    the final score will need to exceed this value.
       *    afterwards,
       *    `updateMaxScoreTo` will be invoked with the final score
       * 
       * @param updateMaxScoreTo
       *    afterwards,
       *    `updateMaxScoreTo` will be invoked with the final score
       * 
       * 
       */
      def probeInputMuxFmt2(
         assumeTheFileAlreadyOpened: Boolean ,
         maxScore: => Int ,
         updateMaxScoreTo: Int => Unit ,
         
      ) = {

         var finalScore: Int = 0

         val fmt = {
            this1
            .probeInputMuxFmt3(
               assumeTheFileAlreadyOpened = assumeTheFileAlreadyOpened ,
               propagateFinalScore = v => { finalScore = v } ,
            )
         }

         if maxScore < finalScore then
            updateMaxScoreTo(finalScore)
            fmt
         else null
         
      }

   }

   extension [A <: AvProbeCtx ](ctx: A ) {

      /**
       * 
       * 
       * guess the mux format.
       * afterwards,
       * `propagateFinalScore` will be invoked with the final score .
       * 
       *
       * @param assumeTheFileAlreadyOpened
       * 
       * @param propagateFinalScore
       *    afterwards,
       *    this will be invoked with the final score
       * 
       * 
       */
      def probeInputMuxFmt3(
         assumeTheFileAlreadyOpened: Boolean ,
         propagateFinalScore: Int => Unit ,
         
      ): CtxDetectedCodec[ctx.type ] | Null
      
   }

   type CtxDetectedCodec[+C <: AvProbeCtx ]
      // <: cbsq.avc.McdcTyper#MediaCodecOverview & cbsq.avc.FfCodecTemplateOps
      <: cbsq.avc.McdcTyper#MediaDeviceOverview
   
   /**
    * 
    * `isFileNameEndingWithExt`
    * 
    */
   extension [A <: AvProbeCtx ](lpd: A ) {

      def isFileNameEndingWithExt(ext: String) : Boolean

   }

}

































