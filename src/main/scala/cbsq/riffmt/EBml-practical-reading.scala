package cbsq.riffmt









// @annotation.experimental
@main
// protected 
def ebmlPracticalTest1(): Unit = {

   ebmlPracticalTest1Impl(
      //
      eagerness = {
         epr.Eagerness.toBeEager
      } ,
      
   )
}

// @annotation.experimental
@main
// protected 
def ebmlPracticalTest1Lazy(): Unit = {

   ebmlPracticalTest1Impl(
      //
      eagerness = {
         epr.Eagerness.toBeLazy
      } ,
      
   )
}

object epr {

   export cbsq.riffmt.ebmsGenericUtils.Eagerness

}

def ebmlPracticalTest1Impl(
   //

   eagerness : epr.Eagerness ,

): Unit = {
   import language.unsafeNulls /* due to the extended usage of non-Scala API(s) */

   val path = (
      new java.io.File("C:\\Users\\62857\\Documents\\2022-1105-2249.webm")
      .toURI()
   )
   import byteManipImplicits.*
   import EBmlPrimitivesIo.*
   util.Using.resource(path.toURL().openStream() )(r0 => {
      val r = (
         new java.io.DataInputStream(r0)
      )
      (2 : Int) match {
         
      case 2 =>
         locally {
            println("DOCTYPE" )
            val e = (
               r.readEbmlFrameOfPayloadRaw()
            )
            println(e.toString() )
            println({
               import java.nio.charset.{StandardCharsets, Charset }
               new String((e.payload.byteValues.map((_.toChar)) ).toArray )
            } )
         }
         try {
            {
               println("CONTENTS" )
               val e = cbsq.avc.codecs.demuuxMatroskaFile(r )(eagerness = eagerness )
               if { 
                  // eagerness == epr.Eagerness.toBeLazy
                  // false
                  eagerness == epr.Eagerness.toBeLazy
               } then {
                  println("traversing with logging")
                  runEbmlDemonstrativeTransversal(e, logging = { cbsq.avc.PhrStagedLogging.whichLogsTo(e => { println(s"[itr] $e") ; Right {} } ) } )
               }
               if { 
                  eagerness == epr.Eagerness.toBeLazy
               } then {
                  // println("traversing, without lonngin")
                  println(s"traversing, without logging")
                  var lc = new java.util.concurrent.atomic.AtomicLong
                  runEbmlDemonstrativeTransversal(e , logging = cbsq.avc.PhrStagedLogging.whichLogsTo({ case _ => { lc.incrementAndGet() ; Right {} } }) )
                  println(s"log linecount: ${lc.get() } ")
               }
               println(e.toString() replaceAll ({ import scala.util.matching.Regex.quote ; s"(\\w{64})\\w{3,}(?:${quote("...") })?" }, "$1...") take (10 * 1024 ) )
            }
         }
         catch {
            case z =>
               throw z ;
         }
         

      }
   })
   // ???
}

extension (r: java.io.InputStream) {
   
// private
def newCountingBufferedStream( ) = {
   new java.io.BufferedInputStream(r) {

            val tct = {
               new java.util.concurrent.atomic.AtomicLong(0)
            }

            def tctLog() : Unit = {
               if (({
                  val newValue = (
                     (System.currentTimeMillis() / 1000 )
                     ./(2)
                  )
                  tct.compareAndSet(newValue + -1 , newValue )
               })) {
                  sys.process.stderr.println(s"bytes read: ${statRead.get() }")
               }
            }

            val statRead = new java.util.concurrent.atomic.AtomicLong(0)

            lazy val logged: Unit = {
                     println((
                        new Exception(s"total read is ${statRead.get() } ; " )
                     ))
            }

            override
            def read(b: Array[Byte]): Int = {
               read(b, 0, b.length)
            }

            override 
            def read(b: Array[Byte], off: Int, len: Int): Int = {
               tctLog()
               try {
                  val actualLen = (
                     // TODO
                     super.read(b, off, (
                        // len
                        math.min(0x64000, len)
                     ))
                  )
                  (({
                     if (actualLen < 0 ) {
                        logged
                     }
                     actualLen
                  }), { if (0 <= actualLen) statRead.addAndGet(actualLen) })._1
               } catch {
                  case z : java.lang.Exception =>
                     logged
                     throw z
               }
            }

            override
            def close(): Unit = {
               try {
                  super.close()
               } finally {
                  logged
               }
            }

         }
}

}

def runEbmlDemonstrativeTransversal(
   c: (
      // cbsq.riffmt.EBml.FramePayloadScheme.FScOps#Instance
      (cbsq.riffmt.EBml.FramePayloadScheme#Instance | Seq[cbsq.riffmt.EBml.FramePayloadScheme#Instance] )
   ) ,
   
   logging : cbsq.avc.PhrStagedLoggingOps = {
      cbsq.avc.PhrStagedLogging.noOpInstance
   } ,
   
) : Unit = {
                     ;
                     
                     identity {}

                     extension (c: AnyRef) {

                        def toStringBetter() : String = {
                           
                           import language.unsafeNulls
                           
                           c.toString()
                           .linesIterator.toIndexedSeq.headOption.getOrElse("")
                           .grouped(80).toSeq
                           .zipWithIndex.map({ case (line, i) => (if 0 < i then "  " else "") + line })
                           .mkString("\r\n")
                        }

                     }
                     
                     val xCanUseToString : Boolean = {
                        true
                     }
                     
                     c
                     match {

                        case c : collection.immutable.ArraySeq.ofByte =>
                           import cbsq.ByteBlob.boxingImplicits.*
                           if xCanUseToString then logging enstage(s"Bytes: ${c.toBlob.toStringBetter() }" )

                        case c : cbsq.riffmt.EBml.FramePayloadScheme.`elements_@&%!`.Element =>
                           val lgItem = {
                              if xCanUseToString then logging enstage(s"Elem: ${c.toStringBetter() }" )
                              else logging enstage(s"Elem: <${c.classSimpleName } ...>" )
                           }
                           runEbmlDemonstrativeTransversal(c.children, logging = lgItem )

                        case c : Seq[cItem] =>
                           logging enstage(s"Seq" )
                           for ((child, i) <- c.map(_.asInstanceOf[cbsq.riffmt.EBml.FramePayloadScheme#Instance] ).zipWithIndex ) {
                              val lgItem = logging enstage(s"$i: ")
                              runEbmlDemonstrativeTransversal(child, logging = lgItem  )
                           }

                        case _ =>
                           // no-op

                     }
}




