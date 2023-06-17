package cbsq.riffmt















// trait EBmlIndexImports extends 
// AnyRef 
// with EBmlPrimitivesIoReExports 
// {
//    export EBml.*
// }

object EBml extends 
   AnyRef 
   with EBsd
   with EBmlByteManipIoReExports
   with EBmlPrimitivesIoReExports

// trait EBmlExports extends 
//    AnyRef 
//    with EBsd
//    with EBmlByteManipIoReExports
//    with EBmlPrimitivesIoReExports
// {
// 
// }

@main
def ebmlImplTest(): Unit =
   ebmlIoImplTest()
   EBml.toString()
   ebmlSchemalImplTest()

@main
def ebmlSchemalImplTest(): Unit =
   EBml.FramePayloadScheme.OfNumber.toString()
   {
      import byteManipImplicits.*
      given Conversion[java.io.DataInputStream, java.io.BufferedInputStream] = {
         class AwfulImplicitDisbStreamConversionException extends
         UnsupportedOperationException((
            "awful implicit conversion 'DataInputStream => BufferedInputStream'"
         ))          
         (inp => {
            sys.process.stderr.println((
               new AwfulImplicitDisbStreamConversionException
            ))
            new java.io.BufferedInputStream(inp)
         })
      }
      implicit val trav = EBml.CodeSchemeOps.TraversalDiagnostique.nullaryInstance
      // locally {
      //    val s1 = EBml.FramePayloadScheme.OfNumber.of[Long](defaultValue = -1 )
      //    println((
      //       s1.readAndParse((
      //          IndexedSeq[Int](-1, -1, -1, -1, -1, -1, -1, -1).map(_.toByte)
      //          .asBlob
      //          .newGrossReader()
      //          .asMarkableStream()
      //       ))
      //    ))
      //    println((
      //       s1.readAndParse((
      //          IndexedSeq[Int](-1, -1, -1, -1, -1, -2, -1, -1).map(_.toByte)
      //          .asBlob
      //          .newGrossReader()
      //          .asMarkableStream()
      //       ))
      //    ))
      //    println((
      //       s1.readAndParse((
      //          IndexedSeq[Int](-1, -1, -1, -2, -1, -1, -1, -1).map(_.toByte)
      //          .asBlob
      //          .newGrossReader()
      //          .asMarkableStream()
      //       ))
      //    ))
      // }
      // println((
      //    EBml.FramePayloadScheme.OfNumber.of[Double](defaultValue = 0)
      //    .readAndParse((
      //       IndexedSeq[Int](-1, -1, -1, -2, -1, -2, -1, -1).map(_.toByte)
      //       .asBlob
      //       .newGrossReader()
      //       .asMarkableStream()
      //    ))
      // ))
      // println((
      //    EBml.FramePayloadScheme.OfNumber.of[Double](defaultValue = 0)
      //    .readAndParse((
      //       IndexedSeq[Int](-1, -25, -1, -2, -1, -2, -1, -1).map(_.toByte)
      //       .asBlob
      //       .newGrossReader()
      //       .asMarkableStream()
      //    ))
      // ))
      // try {
      //    util.Try({ throw new InterruptedException })
      //    throw new AssertionError
      // } catch {
      //    case z : InterruptedException =>
      //       println(z)
      // }
      // println((
      //    util.Try((
      //       EBml.FramePayloadScheme.OfNumber.of[Double](defaultValue = 0)
      //       .readAndParse((
      //          IndexedSeq[Int](-1, -25, -1, -2, -1 ).map(_.toByte)
      //          .asBlob
      //          .newGrossReader()
      //          .asMarkableStream()
      //       ))
      //    ))
      //    .failed
      //    .map({ case e : java.io.EOFException => e })
      // ))
   }

























