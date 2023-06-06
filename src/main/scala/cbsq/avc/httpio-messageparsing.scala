package cbsq.avc
















object httpMessageParsing
{
   
   export httpReadlineUtil.linesSc
   export httpReadlineUtil.readFullSource

   export httpReadlineUtil.whitespaceOnlyOrBlankRegex

   import httpMessageParsing as http

   /**
    * 
    * `ValidHeaderRow`
    * 
    */
   val ValidHeaderRow = {
      "\\s*(\\w[\\w\\-]*)\\s*\\:\\s*(\\S[\\S\\s]*?)\\s*".r
   }

   extension (s: java.io.BufferedReader) {

      /**
       * 
       * reads the next lines as HTTP headers -
       * the next lines
       * will be slurped until including the next whitespace-only line.
       * 
       * meant to be used with `mark` and `reset`.
       * 
       */
      def readHttpHeadersAll() = {

         import language.unsafeNulls

         Iterator.continually(s.readLine() )
         .takeWhile({
            case l: String =>
               !(l matches whitespaceOnlyOrBlankRegex ) 
            case null =>
               false
         })
         .to(Vector )
         .tapEach({
            case ValidHeaderRow(key, value) =>
         })

      }

   }

   /**
    * 
    * `readHttpHeadersAll` .
    * does not automatically call `src.reset()` ;
    * the responsibility is on callers.
    * 
    */
   class readHttpHeadersAndAnalyse(src: java.io.BufferedReader)
   {

         ;
         
         export http.ValidHeaderRow

         /**
          * 
          * the headers, each as `(key, value)`.
          * maintains the original ordering.
          * 
          */
         val headersAsTuples = {
            import language.unsafeNulls

            src
            .readHttpHeadersAll()
            .toVector
            .map({
               case ValidHeaderRow(key, valueString) =>
                  ( key.toLowerCase(java.util.Locale.ROOT) , valueString )
            })
            
         }

         /**
          * 
          * the headers.
          * 
          */
         val headersAsMap = {

            headersAsTuples
            .toMap
            
         }

         /**
          * 
          * the headers, (re)formatted.
          * 
          */
         val headers = {

            headersAsTuples
            .map({
               case (key, valueString) =>
                  s"$key : $valueString "
            })
            
         }

         /**
          * 
          * the header `Content-Length` field value
          * 
          */
         lazy val contentLength = {

            import cbsq.FileSize.boxingImplicits.*
            
            import language.unsafeNulls

            headersAsTuples
            .collectFirst({

               case ("content-length", valueInBytesStr ) =>
                  val valueInBytes = {
                     BigInt(valueInBytesStr )
                  }
                  valueInBytes
                  
            })
            .orElse({
               throw new java.io.IOException(s"no Content-Length header; (presently : ${headers })")
            })
            .filter(v => (0 < v ) )
            .get
            .toLong
            .B

         }

         lazy val contentTypeHeaderValue = {

            headersAsMap
            .apply("content-type")

         }
               
   }

}

object httpReadlineUtil
{

   extension (src: java.io.InputStream ) {

      /**
       * 
       * assumes it's in US-ASCII and then
       * returns a `BufferedReader`-based proxy
       * 
       */
      def asXBufferedReader() = {
         
         import language.unsafeNulls

         src
         match { case s => new java.io.InputStreamReader(s, java.nio.charset.StandardCharsets.US_ASCII ) }
         // TODO
         match { case s => new java.io.BufferedReader(s) }
         
      }

   }

   extension (s: java.io.BufferedReader) {

      /**
       * 
       * `.lines().asScala()`
       * 
       */
      def linesSc() = {
         
         import scala.jdk.CollectionConverters.*

         import language.unsafeNulls

         s.lines()
         .iterator().asScala

      }

   }

   extension (src: java.io.BufferedReader ) {

      /**
       * 
       * 
       */
      def readFullSource(): String = {
         
         import language.unsafeNulls

         val dest = new java.io.StringWriter
         src transferTo dest
         dest.toString()
         
      }

   }
   
   final
   lazy val whitespaceOnlyOrBlankRegex = ({
      "\\A\\s*\\z"
   })

}

























































