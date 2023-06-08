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

   export cbsq.avc.hw.transcoding.EwfTranscodFnc

   export cbsq.avc.MediaKind

   trait WithFrameIterator[+R] { val frameIterator : R }  

   trait WithStreams[+R] { val streams : R }  

}


















































