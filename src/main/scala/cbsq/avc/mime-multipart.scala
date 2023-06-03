package cbsq.avc













/**
 * 
 * MIME Multipart Parsing
 * 
 * https://www.w3.org/Protocols/rfc1341/7_2_Multipart.html 
 * 
 */
object MimeMultipart
{
   
   export mimeMultipartImplUtil.*

   export httpReadlineUtil.asXBufferedReader

   /**
    * 
    *
    * MIME Multipart whose delimiter being `"--" ++ delimitingLineContentsPre`
    * 
    * 
    * @param delimitingLineContentsPre
    * 
    */
   case class analyseDecoderConfig(
      delimitingLineContentsPre : String , // TODO

   )
   extends
   AnyRef
   {

      /**
       * 
       * syntactic sugar to
       * check whether the String `l` shall be treated as delimiter.
       * all needs to be done within the enclosing run, as
       * the returned Iterator
       * is defined to omit the delimiting lines
       * 
       */
      extension (l: String) {

         /**
          * 
          * regardless-of whether there is traling extra "--"
          * 
          */
         def isDelimitingLineContent(ignored1 : Unit = () ): Boolean = {
            isDelimitingLineContent1(terminal = false) || isDelimitingLineContent1(terminal = true )
         }

         def isTerminatingLineContent(ignored1 : Unit = () ): Boolean = {
            isDelimitingLineContent1(terminal = true )
         }

         def isDelimitingLineContent1(terminal: Boolean ): Boolean = {
            l == ("--" ++ delimitingLineContentsPre ++ (if terminal then "--" else "" ) )
         }

      }

      extension (reader : java.io.BufferedReader ) {

         /**
          * 
          * skip the next line(s) if
          * it's a delimiting-line ;
          * throw `EOFException` on end
          * 
          */
         def skipDelimitingLines() : Unit = {

            import language.unsafeNulls

            while {
               reader mark(1048576 )

               val l = {
                  Option(reader.readLine() )
                  .getOrElse(throw new java.io.EOFException )
               } : String

               if l isDelimitingLineContent() then {
                  true
               }
               else {
                  reader.reset()
                  false
               }
               
            } do {}
            
         }

      }
               
   }

   extension (src01: java.io.InputStream) {

      /**
       * 
       * divide/segment as
       * MIME Multipart whose delimiter being `"--" ++ delimitingLineContentsPre`.
       * all headers in each "segment" will be retained.
       * 
       * the standardised MIME-type for *multipart*s is
       * `multipart/&lt;yyy>; boundary=&lt;delim>` for any well-formed `delim`.
       * pass `delim` as `delimitingLineContentsPre`.
       * 
       *
       * @param delimitingLineContentsPre
       *        this will be prepended with `--` to get `s"--$delimitingLineContentsPre"`
       * 
       * 
       */
      def asMimeMultipartDecoded1(
         //
         
         delimitingLineContentsPre : String , 

         /**
          * 
          * disabled as
          * this will pre-buffer the entire input just to make that check
          * 
          */
         enforceWhitespaceOnlyRemainderChecking: Boolean = {
            false
         } ,

      ) = {

         val src0 = {
            src01 match {
               case src : (java.io.BufferedInputStream | java.io.ByteArrayInputStream ) =>
                  src
               case src =>
                  new java.io.BufferedInputStream(src)
            
            }
         } : (java.io.BufferedInputStream | java.io.ByteArrayInputStream )

         val configAnalysis = {
            analyseDecoderConfig(
               delimitingLineContentsPre = delimitingLineContentsPre ,
               
            )
         }

         import configAnalysis.isDelimitingLineContent
         import configAnalysis.isDelimitingLineContent1
         import configAnalysis.isTerminatingLineContent
         
         import configAnalysis.skipDelimitingLines
         
         @`throws`[java.io.EOFException]
         class !@()
         extends
         AnyRef
         with CtclQueryOps
         {
            
         src0 mark({
            /**
             * 
             * enough length to read all this segment headers.
             * 
             */
            4 * 1024
         })

         /**
          * 
          * do some look-ahead,
          * before `reset`-ing it
          * 
          */
         {
            if src0.read() == -1 then {
               throw new java.io.EOFException
            }
            /**
             * 
             * this should be
             * disabled as
             * this will pre-buffer the entire input just to make that check
             * 
             */
            if enforceWhitespaceOnlyRemainderChecking then {
               if (
                  (
                     src0
                     .asXBufferedReader()
                     .readAll()
                     .matches(whitespaceOnlyOrBlankRegex )
                  )
               ) then {
                  throw new java.io.EOFException("only whitespaces left")
               }
            }
         }

         src0.reset()

         val headerialAnalysis = {
            val reader = {
               src0.asXBufferedReader()
            }
            if {
               // true
               true
            } then {
               reader.skipDelimitingLines()
            }
            readHttpHeadersAndAnalyse(reader )
         }

         src0.reset()

         export headerialAnalysis.*
         
         /**
          * 
          * the headers already collected ;
          * make the `InputStream` skip all the headers
          * 
          */
         {
            val srcByteReader = {
               new java.io.DataInputStream(src0 )
            }
            Iterator.continually(srcByteReader.readByte() : Int )
            .sliding(size = 3, step = 1 )
            .takeWhile({

               case Seq(0x0A, 0x0D, 0x0A ) =>
                  false
               case _ =>
                  true
                  
            })
            .foreach(_ => {} )
         }

         src0 mark({
            /**
             * 
             * enough length to read all of the payload.
             * 
             */
            contentLength.inBytes.toInt
            .+(1024)
         })

         override
         val payload = {
            src0
            .readNBytes(contentLength.inBytes.toInt ).nn
            .toIndexedSeq
            .toBlob
         }

         src0 mark(1024 )

         {
            
            val delimStr1 = {
               val s1 = {
                  src0
                  .asXBufferedReader()
                  .linesSc()
                  .to(LazyList)
               }
               // s1.takeWhile(l => !(l isDelimitingLineContent() ) )
               s1.take({
                  s1.indexWhere(l => !(l isDelimitingLineContent() ) , from = 1 )
               })
               .mkString("\r\n")
               .++("\r\n")
            }

            Thread.`yield`()

            val eofReached1 = {
               src0.read() == -1
            }

            assert(eofReached1 || (delimStr1 contains s"--$delimitingLineContentsPre" ) , {
               s"not reached EOF yet, but ($delimStr1 vs ${s"--$delimitingLineContentsPre" })"
            })

            // src0 mark(Int.MaxValue )
            locally {
               src0.reset()
               src0.skipNBytes(delimStr1.length() )
            }

         }

         src0 mark(1024 )

         // ???

         extension (s: cbsq.ByteBlob) {
            def toPayloadString: String = {
               s"[length: ${s.length }]"
            }
         }
         
         override
         def toShortString(): String = {
            s"[headers: $headers ; payload: ${payload.toPayloadString } ]"
         }
         
         override
         def toString(): String = {
            val headersString = {
               headers
               .mkString("\r\n")
            }
            val payloadString = {
               payload.toPayloadString
            }
            s"$headersString\r\n\r\n$payloadString"
         }
         
         }

         Iterator.unfold[AnyRef & CtclQueryOps, Unit](() )(_ => {
            try {
               val r = !@()
               Some((r, () ) )
            }
            catch {
               case z : java.io.EOFException =>
                  None
            }
         })

      }

   }

   trait CtclQueryOps
   extends
   AnyRef
   {

      val payload : cbsq.ByteBlob

      @deprecated
      val contentTypeHeaderValue : String

      def toShortString(): String
      
   }

}

object mimeMultipartImplUtil
{

   export cbsq.ByteBlob.boxingImplicits.{asBlob, toBlob }

   export httpReadlineUtil.linesSc

   export httpReadlineUtil.readFullSource

   extension (src: java.io.BufferedReader ) {

      /**
       * 
       * 
       */
      transparent inline
      def readAll(): String = {
         
         src.readFullSource()
         
      }

   }

   object http {
      
      export httpMessageParsing.ValidHeaderRow

   }

   export httpMessageParsing.readHttpHeadersAll

   export httpMessageParsing.readHttpHeadersAndAnalyse

   export httpReadlineUtil.whitespaceOnlyOrBlankRegex

}

@main
def runMimeMultipartDemo(): Unit = {
   
   import MimeMultipart.*
   
   import MimeMultipart.{asXBufferedReader => toXBufferedReader }

   import cbsq.avc.quick.ffPath

   import cbsq.avc.quick.smjg.startBasicMpJpegGener1

   extension (s: java.lang.String) {
      
      def afterLpb(

         maxLineCount: Int ,
         maxLength: Int = 1048 ,

         linePrefixBraced: String = "[my content]" ,

         //
         
      ) : String = {
         
            import language.unsafeNulls

            // s"$linePrefixBraced ${s.take(maxLength) } "
            s.take(maxLength )
            .linesIterator
            .map(l => s"$linePrefixBraced $l")
            .map(s => s.replaceFirst("\\A([\\S\\s]{64})[\\S\\s]{5,}\\z", "$1...") )
            .take(maxLineCount )
            .mkString("\r\n")

      }

   }

   import cbsq.avc.quick.decodeImgFile

   util.Using.resource({
      newXResourcesManager()
   })(resm => {
   ;

   import language.unsafeNulls

   val ffp1 = {
      startBasicMpJpegGener1()
   }

   import ffp1.p

   import ffp1.pAsInputStream
   
   resm register pAsInputStream

   val pInputAll = {
      pAsInputStream
      match { 
         case src =>
            import cbsq.ByteBlob.boxingImplicits.*
            src
            .readAllBytes()
            .toIndexedSeq
            .toBlob
      }
   }

   println("original all :")
   if false then {
      println({
         pInputAll
         .newGrossReader()
         .toXBufferedReader()
         .readAll()
         .linesIterator
         .map("[content]" + _ )
         .take(96)
         .mkString("\r\n") 
      })
   }
   
   if false then

      pInputAll
      .newGrossReader()
      .toXBufferedReader()
      .lines()
      .forEach(l => println(s"[l] $l") )

   else {
      
      val r = (
         pInputAll
         .newGrossReader()
         .asMimeMultipartDecoded1(delimitingLineContentsPre = "ffmpeg" )
         .to(LazyList)
      )

      r.take({
         160
      })
      .zipWithIndex
      .map({ case (s, i) => {
         (s.toString(), i )
      } })
      .foreach({ case (s: String, i) => {
         println({
            val linePrefixBraced = {
               s"[frame $i]"
            }
            val maxLength = 848 
            val maxLineCount = 10 
            s
            .afterLpb(
               maxLineCount = maxLineCount,
               linePrefixBraced = linePrefixBraced ,
               maxLength = maxLength ,
            )
         })
      } })

      r
      .map(l => {
         import scala.reflect.Selectable.reflectiveSelectable
         import l.payload
         val img = ({
            Thread.sleep(500 )
            decodeImgFile(payload = payload )
         })
         println(s"${img }")
      })
      .take(7)
      .foreach(_ => {} )

   }

   })
}





























































