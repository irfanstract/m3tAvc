package avcframewrk.util.characterstreams
















extension (dest: Appendable) {

   def asCharPipe() : java.io.Writer = {

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

}






























