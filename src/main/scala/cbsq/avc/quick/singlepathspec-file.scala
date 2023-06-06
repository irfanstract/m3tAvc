package cbsq.avc.quick


















object SinglePathSpecFile
{

   def getValueFrom(configFileUrl: java.nio.file.Path | java.net.URI | java.net.URL) : String = {

      getValueFromUrl({

         configFileUrl.toURLGeneric()
         
      })

   }

   extension (configFileUrl: "error" | java.nio.file.Path | java.net.URI | java.net.URL) {

      def toURLGeneric(): java.net.URL = {
         
         import language.unsafeNulls
         
         configFileUrl
         match {
            
            case s : java.nio.file.Path =>
               s.toUri().toURL()

            case s : java.net.URI => s.toURL()
            case s : java.net.URL => s

            case "error" =>
               throw new java.io.IOException

         }
         
      }

   }

   def getValueFromUrl(configFileUrl: java.net.URL) : String = {

      import language.unsafeNulls
      
      import cbsq.avc.httpReadlineUtil.*

      val configFileContents = {
         configFileUrl
         .openStream()
         .asXBufferedReader()
         .readFullSource()
      }

      getValueFromFullSrcText(configFileContents )

   }

   def getValueFromFullSrcText(configFileContents: String) : String = {
      
      import language.unsafeNulls
      
      configFileContents
      .linesIterator.toIndexedSeq
      .collect({
         val S1 = "\\s*([\\S\\s]+?)\\s*".r
         ({ case S1(s) => s }) : PartialFunction[String, String]
      })
      match { case Seq(v) => v : String }

   }

}



































