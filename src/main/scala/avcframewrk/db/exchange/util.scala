package avcframewrk.db.exchange




















object localUtil
{

   /**
    * 
    * dispatch, and forget about it.
    * `throw`n exceptions will be logged.
    * 
    */
   def dispatchAndForget[R](f : () => R ): Unit = {

      startAndForget { f() }
   }

   /**
    * 
    * start, and forget about it.
    * `throw`n exceptions will be logged.
    * 
    */
   def startAndForget[R](r : => R ) : Unit = {

            doAsynchronously(r)

            match { case f => {
               
               /** ensure that any `throw`n exception gets logged */
               f.logIfFailing()

               /* do not return it */
            } }
   }
   
   @deprecated
   def evaAsynchronously[R](r : => R ) : concurrent.Future[R] = {

            doAsynchronously(r)

            match { case f => {
               
               /** ensure that any `throw`n exception gets logged */
               f.logIfFailing()

               /** return it */
               f
            } }
   }

   def dispatch[R](r : () => R ) : concurrent.Future[R] = {

      doAsynchronously { r() }
   }

   def doAsynchronously[R](r : => R ) : concurrent.Future[R] = {

            concurrent.Future.unit
            .map((_: Unit) => {
               r
            })(using concurrent.ExecutionContext.global )
   }

   def computeAsynchronously[R](r : => R ) : concurrent.Future[R] = {

      doAsynchronously { r }
   }
   
   extension (f : concurrent.Future[?] ) {

      /** ensure that any `throw`n exception gets logged */
      def logIfFailing() : Unit = {

         {
                  implicit val ec = concurrent.ExecutionContext.parasitic
                  f
                  .transform(tr => util.Success(tr) )
                  .foreach(_.get )
         }
      }

   }

   extension (dest : java.io.Writer) {

      /**
       * 
       * a `PrintWriter`-based (with `autoFlush` being TRUE ) proxy
       * 
       */
      def asPrintWriter() : java.io.PrintWriter = {

         new java.io.PrintWriter(dest, true )
      }

   }

   /**
    * 
    * .
    * 
    */
   export GivenPipedStreamFactory.ofBytes.{instantiate => newByteStreamPipe }

   /**
    * 
    * factory for
    * pair of `(PipedWriter, PipedReader)`s
    * 
    */
   trait GivenPipedStreamFactory[+I1, +I2]
   {

      /**
       * 
       * allocate a pair of those, for given *buffer size* --
       * when returned,
       * the two will have already been (inter)connected
       * 
       * don't forget to place the `flush()` calls as
       * on some VM(s)
       * absence of that will result in spurious `sleep()` calls
       * 
       * 
       * @param bufferSize for the constructor
       * 
       */
      def instantiate(bufferSize : Int = 1024 ) : (I1, I2)

   }

   object GivenPipedStreamFactory
   {

      given ofBytes : GivenPipedStreamFactory[java.io.PipedOutputStream, java.io.PipedInputStream] = {
         (bufferSize ) => {
            ;
            
            import language.unsafeNulls

            val i1 = new java.io.PipedOutputStream
            val i2 = new java.io.PipedInputStream(i1, bufferSize )
            (i1, i2)
         }
      }
      
      given ofUtf : GivenPipedStreamFactory[java.io.PipedWriter, java.io.PipedReader] = {
         (bufferSize) => {
            ;
            
            import language.unsafeNulls

            val i1 = new java.io.PipedWriter
            val i2 = new java.io.PipedReader(i1, bufferSize)
            (i1, i2)
         }
      }
      
   }

   object stdCharsets {

      import language.unsafeNulls

      export java.nio.charset.StandardCharsets.*

   }

}













