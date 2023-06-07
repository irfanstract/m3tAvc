package cbsq.avc.quick


















object smjg
{

   import cbsq.avc.httpReadlineUtil

   import cbsq.avc.MimeMultipart

   import httpReadlineUtil.*
   
   import httpReadlineUtil.{asXBufferedReader => toXBufferedReader }

   extension (p: ProcessBuilder) {

      def loadEnv() : p.type = {
         
         import language.unsafeNulls

         p.environment()
         .putAll(System.getenv() )
         p

      }
      
      def printEnv() : p.type = {
         
         import language.unsafeNulls

         System.err.println(p.environment() )
         p
         
      }
      
   }
   
   export cbsq.avc.quick.ffPath

   class startBasicMpJpegGener1()
   {
      ;

      import language.unsafeNulls
      
      val p = {
         ProcessBuilder()
         .redirectError(ProcessBuilder.Redirect.INHERIT )
         .loadEnv()
         .printEnv()
         .command((
            Seq()
            // :+ "cmd.exe"
            // :+ "ffmpeg"
            :+ java.nio.file.FileSystems.getDefault().getPath(ffPath, "ffmpeg").toString()
            :++ Seq("-loglevel", "info")
            :++ (
               Seq()
               :+ "-re"
               :+ "-f" :+ "lavfi"
               :+ "-i" :+ "testsrc=duration=6.3:size=176*144:rate=3"
            )
            :++ (
               Seq()
               :+ "-f" :+ "mpjpeg"
               :+ "-flush_packets" :+ "1"
               :+ "-rtbufsize" :+ "8000"
               :+ "pipe:"
            )
         ) : _* )
         .start()
      }

      val pAsInputStream = {
         p.getInputStream()
      }
   
   }

}































