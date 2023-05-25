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
               lazy val s : EBml.FramePayloadScheme.XSc {
                  val schemeMap : Map[BigInt, (
                     EBml.FramePayloadScheme { 
                        // type Instance <: Seq[EBml.FramePayloadScheme.OfMulti[?, ?]#Instance ]
                     }
                  )]
               } = ({
                  import EBml.{CodeSchemeOps, FramePayloadScheme, CodeUnitScheme}
                  import EBml.CodeSchemeOps.{Lazy}
                  import cbsq.riffmt.ebmls.{totalDtdAnalyse, elementDtdAnalyse}
                  // given byteManipImplicits.OctetReadingOp[BigInt] = r => {
                  //    r.readEbmlInteger(unsigned = true, invalidateAllSameBitExamples = false)
                  // }
                  // given byteManipImplicits.OctetWritedownOp[BigInt] = (r, v) => {
                  //    r writeEbmlInteger(v)
                  // }
                  lazy val genericFramePayloadScheme = {
                     FramePayloadScheme.ofOneOrMoreOfAnyOf1C(c = Lazy(s.schemeMap ) )
                  }
                  lazy val rawBytesScheme = (
                     CodeUnitScheme.OfStr(
                        encodedLength = CodeSchemeOps.cHasVariableLength,
                        enc = EBmlCharset.RawOctetString,
                        defaultEncodedValue = {
                           // TODO
                           ""
                        } ,
                     )
                  )
                  lazy val utfScheme = (
                     CodeUnitScheme.OfStr(
                        encodedLength = CodeSchemeOps.cHasVariableLength,
                        enc = EBmlCharset.Utf8,
                        defaultEncodedValue = {
                           // TODO
                           ""
                        } ,
                     )
                  )
                  def appropriateScheme1(c: elementDtdAnalyse ) = {
                     // TODO
                     c.mValueTypeSimpleName match {

                        case "master" =>
                           genericFramePayloadScheme
                           
                        case "utf-8" =>
                           utfScheme

                        case "string" =>
                           rawBytesScheme

                        case "binary" =>
                           rawBytesScheme

                        case "uinteger" | "integer" =>
                           rawBytesScheme

                        case "date" =>
                           rawBytesScheme

                        case "float" =>
                           rawBytesScheme

                     }
                  }
                  /* https://matroska.org/technical/elements.html */
                  new FramePayloadScheme.XSc {

                     /* `cbsq.avc.codecs.matrCd` */
                     val schemeMap = ({
                        import cbsq.SlfOnEveryValue.implicits.*
                        import byteManipImplicits.*
                        def debug1() : Unit = {
                           java.lang.ref.Reference.reachabilityFence(BigInt )
                        }
                        val intrinsicElems1 = {
                        Map[Int, (
                           FramePayloadScheme & CodeUnitScheme.XLengthOverrideable { 
                              // type Instance <: Seq[FramePayloadScheme.OfMulti[?, ?]#Instance ]
                           }
                        )](

                           /* VOID */
                           0xEC -> (
                              CodeUnitScheme.OfStr(encodedLength = (0x4).B.self, enc = EBmlCharset.RawOctetString, defaultEncodedValue = {
                                 // TODO
                                 ""
                              })
                           ) ,

                           /* CRC-32 */
                           0xBF -> (
                              CodeUnitScheme.OfStr(encodedLength = (0x4).B.self, enc = EBmlCharset.RawOctetString, defaultEncodedValue = {
                                 // TODO
                                 ""
                              })
                           ) ,

                        )
                        }
                        Map[Int, (
                           FramePayloadScheme & CodeUnitScheme.XLengthOverrideable { 
                              // type Instance <: Seq[FramePayloadScheme.OfMulti[?, ?]#Instance ]
                           }
                        )]()
                        .concat(intrinsicElems1 )
                        .concat[(
                           FramePayloadScheme & CodeUnitScheme.XLengthOverrideable { 
                              // type Instance <: Seq[FramePayloadScheme.OfMulti[?, ?]#Instance ]
                           }
                        )]({
                           // TODO
                           cbsq.avc.codecs.matrCd.entries
                           .map(e => (e.clsId.toInt, appropriateScheme1(e) ) )
                           .toMap
                        })
                        .map({
                           case (k, v) =>
                              (k: BigInt, v)
                        })
                     })

                  }
               })
               val e = (
                  s.schemeMap(0x18538067)
                  .readAndParse(r)(using EBml.CodeSchemeOps.TraversalDiagnostique.nullaryInstance )
               )
               println(e.toString() )
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




