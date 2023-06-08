package cbsq.riffmt









@annotation.experimental
@main
protected 
def ebmlPracticalTest1(): Unit = {
   import language.unsafeNulls /* due to the extended usage of non-Scala API(s) */

   val path = (
      new java.io.File("C:\\Users\\62857\\Documents\\2022-12-06-170043085--22317149878557285.webm")
      .toURI()
   )
   import byteManipImplicits.*
   import EBmlPrimitivesIo.*
   util.Using.resource(path.toURL().openStream() )(r0 => {
      val r = (
         new java.io.DataInputStream(r0)
      )
      (2 : Int) match {
         
      case 1 =>
         for (_ <- () :: Nil) {
            val e = (
               r.readEbmlFrameOfPayloadRaw()
            )
            println(e.toString() )
            println({
               import java.nio.charset.{StandardCharsets, Charset }
               new String((e.payload.byteValues.map((_.toChar)) ).toArray )
            } )
            println({
               import java.nio.charset.{StandardCharsets, Charset }
               new String((e.payload ).toArray, StandardCharsets.UTF_8 )
            } )
         }
         try {
            while (true) {
               val e = (
                  r.readEbmlFrameOfPayloadRaw()
               )
               println((e.typeInt.toString(0x10), e.payloadLength))
            }
         } catch {
            case z : (java.io.EOFException | EBmlPrimitivesMalformationException) =>
               println(z)
         }

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
            ((r: UnpickleInputStream) => {
               println("CONTENTS" )
               import cbsq.avc.codecs.matrCd.{scheme => s, entries => sE}
               import cbsq.avc.codecs.matroskaSegmentElementScheme
               val e = (
                  matroskaSegmentElementScheme
                  .readAndParse(r)(using {
                     EBml.CodeSchemeOps.TraversalDiagnostique.nullaryInstance
                     .withFullSchemeInfo( sE)
                     .withCustomErrorHandler({
                        
                        case _ =>
                           Seq()

                     })
                  } )
               )
               println(e.toString() replaceAll ({ import scala.util.matching.Regex.quote ; s"(\\w{64})\\w{3,}(?:${quote("...") })?" }, "$1...") take (10 * 1024 ) )
            })({
               // import EBmlPrimitivesIo.asMarkableStream
               r
               // .newTimedInputStream()
               .newCountingBufferedStream()
               .asMarkableStream()
            } )
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




