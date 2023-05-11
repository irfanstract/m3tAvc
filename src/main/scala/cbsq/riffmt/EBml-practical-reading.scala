package cbsq.riffmt









@annotation.experimental
@main
protected 
def ebmlPracticalTest1(): Unit = {
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
            ((r: SicingInputStream) => {
               println("CONTENTS" )
               lazy val s : EBml.FramePayloadScheme.XSc {
                  val schemeMap : Map[BigInt, (
                     EBml.FramePayloadScheme { 
                        // type Instance <: Seq[EBml.FramePayloadScheme.OfMulti[?, ?]#Instance ]
                     }
                  )]
               } = ({
                  import EBml.{CodeSchemeOps, FramePayloadScheme, CodeUnitScheme}
                  import CodeSchemeOps.{Lazy}
                  // given byteManipImplicits.OctetReadingOp[BigInt] = r => {
                  //    r.readEbmlInteger(unsigned = true, invalidateAllSameBitExamples = false)
                  // }
                  // given byteManipImplicits.OctetWritedownOp[BigInt] = (r, v) => {
                  //    r writeEbmlInteger(v)
                  // }
                  new FramePayloadScheme.XSc {

                     val schemeMap = ({
                        import cbsq.SlfOnEveryValue.implicits.*
                        import byteManipImplicits.*
                        def debug1() : Unit = {
                           java.lang.ref.Reference.reachabilityFence(BigInt )
                        }
                        Map[Int, (
                           FramePayloadScheme & CodeUnitScheme.XLengthOverrideable { 
                              // type Instance <: Seq[FramePayloadScheme.OfMulti[?, ?]#Instance ]
                           }
                        )](

                           // 0xBF -> (
                           //    CodeUnitScheme.OfStr(encodedLength = (0x4).B.self, enc = EBmlCharset.RawOctetString, defaultEncodedValue = {
                           //       // TODO
                           //       ""
                           //    })
                           //    // new AnyRef with FramePayloadScheme {}
                           //    // CodeUnitScheme.alwaysFailingInstance(() => {
                           //    //    debug1()
                           //    //    "deliberate unrolling"
                           //    // })
                           // ) ,

                           0xBF -> (
                              CodeUnitScheme.OfStr(encodedLength = (0x4).B.self, enc = EBmlCharset.RawOctetString, defaultEncodedValue = {
                                 // TODO
                                 ""
                              })
                           ) ,

                           /* SEGMENT */

                           0x18538067 -> (
                              FramePayloadScheme.ofOneOrMoreOfAnyOf1C(c = Lazy(s.schemeMap ) )
                           ) ,

                           // 0x114D9B74 -> (
                           //    FramePayloadScheme.ofOneOrMoreOfAnyOf1C(c = Lazy(s.schemeMap ) )
                           //    // CodeUnitScheme.alwaysFailingInstance(() => {
                           //    //    debug1()
                           //    //    "deliberate unrolling"
                           //    // })
                           // ) ,

                           /* SEEKING */

                           0x114D9B74 -> (
                              FramePayloadScheme.ofOneOrMoreOfAnyOf1C(c = Lazy(s.schemeMap ) )
                           ) ,

                           0x4DBB -> (
                              FramePayloadScheme.ofOneOrMoreOfAnyOf1C(c = Lazy(s.schemeMap ) )
                           ) ,

                           0x53AB -> (
                              CodeUnitScheme.OfStr(
                                 encodedLength = CodeSchemeOps.cHasVariableLength,
                                 enc = EBmlCharset.RawOctetString,
                                 defaultEncodedValue = "" ,
                              )
                           ) ,

                           0x53AC -> (
                              // TODO
                              CodeUnitScheme.OfStr(encodedLength = CodeSchemeOps.cHasVariableLength, enc = EBmlCharset.EBmlBigInt, defaultEncodedValue = "")
                           ) ,

                        )
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
               // import EBmlPrimitivesIo.asSicingStream
               newCountingBufferedStream(r).asSicingStream()
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

private
def newCountingBufferedStream(r: java.io.InputStream) = {
   new java.io.BufferedInputStream(r) {

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
               try {
                  val actualLen = super.read(b, off, len)
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




