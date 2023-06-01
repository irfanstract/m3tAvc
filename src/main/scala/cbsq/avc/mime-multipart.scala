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
   
   export cbsq.ByteBlob.boxingImplicits.{asBlob, toBlob }

   extension (s: java.io.BufferedReader) {

      def linesSc() = {
         
         import scala.jdk.CollectionConverters.*

         import language.unsafeNulls

         s.lines()
         .iterator().asScala

      }

   }

   extension (src: java.io.BufferedReader ) {

      def readAll(): String = {
         
         import language.unsafeNulls

         val dest = new java.io.StringWriter
         src transferTo dest
         dest.toString()
         
      }

   }

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

      }

   }

   /**
    * 
    * `readHttpHeadersAll` .
    * does not automatically call `src.reset()` ;
    * the responsibility is on callers.
    * 
    */
   class xAnalyseHeaders(src: java.io.BufferedReader)
   {

         val headers = {
            import language.unsafeNulls

            src
            .readHttpHeadersAll()
            
         }

         lazy val contentLength = {

            import cbsq.FileSize.boxingImplicits.*
            
            import language.unsafeNulls

            val ContentLengthSpecLine = {
               "(?i)\\s*(content-length)\\s*\\:\\s*(\\d+)\\s*".r
            }

            headers
            .collectFirst({
               case ContentLengthSpecLine(_, valueInBytes ) =>
                  BigInt(valueInBytes )
            })
            .orElse({
               throw new java.io.IOException(s"no Content-Length header; ${headers }")
            })
            .filter(v => (0 < v ) )
            .get
            .toLong
            .B

         }
               
   }

   val ssMaxValue: Int = {
      16777216
   }

   extension (src0: java.io.InputStream) {

      /**
       * 
       * divide/segment as
       * MIME Multipart whose delimiter being `"--" ++ delimitingLineContents`.
       * all headers in each "segment" will be retained.
       * 
       * requires the *mark-and-reset* support.
       * 
       *
       * @param delimitingLineContents
       * 
       */
      def asMimeMultipartDecoded1(
         delimitingLineContents : String , // TODO

      ) = {

         val delimitingLine = {
            "--" ++ delimitingLineContents
         }

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
            def isXDelimiter(ignored1 : Unit = () ): Boolean = {
               isXDelimiter1(terminal = false) || isXDelimiter1(terminal = true )
            }

            def isXTerminalDelimiter(ignored1 : Unit = () ): Boolean = {
               isXDelimiter1(terminal = true )
            }

            def isXDelimiter1(terminal: Boolean ): Boolean = {
               l == (delimitingLine + (if terminal then "--" else "" ) )
            }

         }
         
         @`throws`[java.io.EOFException]
         class !@() {
            
         src0 mark(Int.MaxValue )

         if src0.read() == -1 then {
            throw new java.io.EOFException
         }
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

         src0.reset()

         val headerialAnalysis = {
            val reader = {
               src0.asXBufferedReader()
            }
            if {
               // true
               true
            } then {
               import language.unsafeNulls
               while {
                  reader mark(1048576 )
                  val l = Option(reader.readLine() ).getOrElse(throw new java.io.EOFException )
                  if l isXDelimiter() then {
                     true
                  }
                  else {
                     reader.reset()
                     false
                  }
               } do {
                  //
               }
            }
            xAnalyseHeaders(reader )
         }

         src0.reset()

         export headerialAnalysis.*
         
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

         val payload = {
            src0
            .readNBytes(contentLength.inBytes.toInt ).nn
            .toIndexedSeq
            .toBlob
         }

         src0 mark(Int.MaxValue )

         val delimStr1 = {
            val s1 = {
               src0
               .asXBufferedReader()
               .linesSc()
               .to(LazyList)
            }
            // s1.takeWhile(l => !(l isXDelimiter() ) )
            s1.take({
               s1.indexWhere(l => !(l isXDelimiter() ) , from = 1 )
            })
            .mkString("\r\n")
            .++("\r\n")
         }

         Thread.`yield`()

         val eofReached1 = {
            src0.read() == -1
         }

         assert(eofReached1 || (delimStr1 contains delimitingLine ) , {
            s"not reached EOF yet, but ($delimStr1 vs $delimitingLine)"
         })

         // src0 mark(Int.MaxValue )
         locally {
            src0.reset()
            src0.skipNBytes(delimStr1.length() )
         }

         src0 mark(Int.MaxValue )

         // ???

         extension (s: cbsq.ByteBlob) {
            def toPayloadString: String = {
               s"[length: ${s.length }]"
            }
         }
         
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

         Iterator.unfold[AnyRef { val payload : cbsq.ByteBlob ; }, Unit](() )(_ => {
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

   val whitespaceOnlyOrBlankRegex = ({
      "\\A\\s*\\z"
   })

}

@main
def runMimeMultipartDemo(): Unit = {
   
   import language.unsafeNulls

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

   import MimeMultipart.*
   
   import MimeMultipart.{asXBufferedReader => toXBufferedReader }
   
   extension (p: ProcessBuilder) {

      def loadEnv() : p.type = {
         
         import language.unsafeNulls

         p.environment()
         .putAll(System.getenv() )
         // p.environment()
         // .compute("Path", { case (_, s00) => {
         //    val s0 = Option(s00).getOrElse("")
         //    val s1 = {
         //       s"$s0;C:\\Users\\62857\\X-Dev-Runtimes\\ffmpeg-2022-10-17-git-3bd0bf76fb-full_build\\bin;"
         //    }
         //    s1
         // } } )
         p

      }
      
      def printEnv() : p.type = {
         
         import language.unsafeNulls

         System.err.println(p.environment() )
         p
         
      }
      
   }
   
   util.Using.resource({
      newXResourcesManager()
   })(resm => {
   ;

   val p = {
      ProcessBuilder()
      .redirectError(ProcessBuilder.Redirect.INHERIT )
      .loadEnv()
      .printEnv()
      .command((
         Seq()
         // :+ "cmd.exe"
         // :+ "ffmpeg"
         :+ "C:\\Users\\62857\\X-Dev-Runtimes\\ffmpeg-2022-10-17-git-3bd0bf76fb-full_build\\bin\\ffmpeg"
         :++ Seq("-loglevel", "info")
         :++ Seq("-f", "lavfi", "-i", "testsrc=duration=5.3:size=qcif:rate=3")
         :++ Seq("-f", "mpjpeg", "pipe:")
      ) : _* )
      .start()
   }
   resm.register(p)(using _.destroy() )

   val pInputAll = {
      p.getInputStream()
      match { 
         case src =>
            import cbsq.ByteBlob.boxingImplicits.*
            src
            .readAllBytes()
            .toIndexedSeq
            .toBlob
      }
   }
   def pInput1 = {
      pInputAll
      // match { case s => new String(s.byteValues.toArray, java.nio.charset.StandardCharsets.US_ASCII ) }
      // match { case s => new java.io.StringReader(s) }
      // match { case s => new java.io.BufferedReader(s) }\
      match { case s => new java.io.ByteArrayInputStream(s.byteValues.toArray ) }
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

      pInput1
      .toXBufferedReader()
      .lines()
      .forEach(l => println(s"[l] $l") )

   else {
      
      val r = (
         pInput1
         .asMimeMultipartDecoded1(delimitingLineContents = "ffmpeg" )
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
         val payload = l.payload
         val img = ({
            Thread.sleep(700 )
            javax.imageio.ImageIO.read({
               payload
               .newGrossReader()
            })
         })
         println(s"${img }")
      })
      .take(7)
      .foreach(_ => {} )

   }

   })
}





























































