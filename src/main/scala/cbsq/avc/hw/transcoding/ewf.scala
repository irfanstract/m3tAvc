package cbsq.avc.hw.transcoding


















object EwfTranscodFnc
{

   /**
    * 
    * a variant described by `newSession() : (feedHere, decodingItr)` -
    * decoding may happen as early as every call to `feedHere.write(...)`
    * 
    */
   trait OfImperativeInputAndTraversiveOutput[+Input, -MxP, +Output] {

      def newSession(
         fmtProperties: MxP,

      ) : (Input, Output )      
      
   }

   /**
    * 
    * a variant described by `wrap(input): convertedFormItr` -
    * generally,
    * the `input.readNextPacket()` calls
    * will only happen on-demand when pulling from `convertedFormItr`
    * 
    */
   trait OfTraversiveInputAndTraversiveOutput[-Input, -MxP, +Output] {

      /**
       * 
       * returns a transcoding interface
       * 
       */
      def apply(
         src : Input ,
         fmtProperties: MxP,
         
      ) : Output     
      
   }

   /**
    * 
    * a variant described by `wrap(output): inputInterface` -
    * 
    */
   trait OfImperativeInputAndImperativeOutput[+Input, -MxP, -Output]
   {
      
      /**
       * 
       * returns an imperative interface for encoding into/onto the given dest
       * 
       */
      // override
      def apply(
         fmtProperties: MxP,
         dest : Output ,

      ) : Input

   }
   
   /**
    * 
    * a variant which runs the piping synchronously -
    * 
    * **terminating it**: requires another thread to stop it
    * 
    */
   trait OfSynchronousPiping[-Input, -MxP, -Output, +R ]
   {
      
      /**
       * 
       * runs encoding into/onto the given dest
       * 
       */
      // override
      def apply(
         decodedForm : Input,
         fmtProperties: MxP,
         dest : Output ,

      ) : R

   }

}










































