package cbsq.avc.codecs




















protected 
object ewfi {

   /**
    * 
    * necessity-test ; use `Option[Unit]`
    * 
    */
   type NecessityTest 
      >: reflect.TypeTest[Option[Unit], ? <: Option[Unit] ]
      <: reflect.TypeTest[Option[Unit], ? <: Option[Unit] ]

   def getAppendableImplWriter(dest: Appendable) : java.io.Writer = {
      
      /** `java.io.Writer` already `implements` `Appendable` */
      dest match {

         case dest : java.io.Writer =>
            dest

         case _ =>
            new java.io.Writer {

               override
               def write(x$0: Array[Char] | Null, x$1: Int, x$2: Int): Unit = {
                  dest append String(x$0, x$1, x$2 )
               }

               override
               def flush() = {
                  import language.unsafeNulls
                  for (dest <- Option(dest).collect({ case e : java.io.Flushable => e }) ) {
                     dest.flush()
                  }
               }
               
               override
               def close() = {
                  import language.unsafeNulls
                  for (dest <- Option(dest).collect({ case e : java.io.Closeable => e }) ) {
                     dest.close()
                  }
               }

               override
               def toString(): String = {
                  s"AppendableWriter($dest)"
               }

            }
            
      }
   }

   // export cbsq.avc.{*}
   // export cbsq.avc.upstream.{*}
   export cbsq.avc.LateBoundValue
   export cbsq.avc.upstream.Duration

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

   export cbsq.avc.MediaKind

   trait WithFrameIterator[+R] { val frameIterator : R }  

   trait WithStreams[+R] { val streams : R }  

}


















































