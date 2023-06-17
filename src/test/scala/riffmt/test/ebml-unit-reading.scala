package riffmt.test












class EbmlUnitReadingTest extends
org.scalatest.funsuite.AnyFunSuite
{

   import language.unsafeNulls

   import avcframewrk.util.StringOfBytes

   import cbsq.avc.codecs.*

   import matrCd.scheme.{schemeMap => matroskaSchemeMap }

   val basicZeroLengthBlob = {
      StringOfBytes.from(IArray.emptyByteIArray )
   }

   val basicFiveByteBlob = {
      StringOfBytes.from(IArray.fill(5)(0x1 ).map(_.toByte ) )
   }

   val basicEightByteBlob = {
      StringOfBytes.from(IArray.fill(8)(0x1 ).map(_.toByte ) )
   }

   val basic16ByteBlob = {
      StringOfBytes.from(IArray.fill(0x10 )(0x1 ).map(_.toByte ) )
   }

   import cbsq.riffmt.EBml
   
   import cbsq.riffmt.EBmlPrimitivesMalformationException

   // import EBml.CodeSchemeOps.TraversalDiagnostique

   given EBml.CodeSchemeOps.TraversalDiagnostique = {
      EBml.CodeSchemeOps.TraversalDiagnostique.nullaryInstance
   }

   class OK[+Value ](value : Value ) extends Throwable(s"value: $value ")

   // test(s"shall raise Exception \"expecting 16 bytes, yet only got 5\" ") {

   //    val z = {
   //       ;
   //       util.Try({
   //          ;
            
   //          val s = {
   //             matroskaSchemeMap
   //             .apply(0x73A4)
   //          }

   //          s.readAndParse({ import cbsq.riffmt.byteManipImplicits.* ; basicFiveByteBlob.newGrossReader().asMarkableStream() })

   //       })
   //       .fold(z => util.Success(z), v => util.Failure(OK(s"$v") ) )
   //       .map({ 
   //          case z : (EBmlPrimitivesMalformationException.IDueToEofException ) =>
   //             z 
   //          case z =>
   //             throw z
   //       })
   //       .get
   //    }

   //    z printStackTrace System.err
      
   // }
   
   // test(s"if given empty Bytes, shall throw EBmlMalformationException IDueToZeroLengthEofException ") {

   //    val z = {
   //       ;
   //       util.Try({
   //          ;
            
   //          val s = {
   //             matroskaSchemeMap
   //             .apply(0x73A4)
   //          }

   //          s.readAndParse({ import cbsq.riffmt.byteManipImplicits.* ; basicZeroLengthBlob.newGrossReader().asMarkableStream() })

   //       })
   //       .fold(z => util.Success(z), v => util.Failure(OK(s"$v") ) )
   //       .map({ 
   //          case z : (EBmlPrimitivesMalformationException.IDueToZeroByteEofException ) =>
   //             z 
   //          case z =>
   //             throw z
   //       })
   //       .get
   //    }

   //    z printStackTrace System.err
      
   // }
   
   // test(s" ") {

   //    val s = {
   //       matroskaSchemeMap
   //       .apply(0x73A4)
   //    }

   //    s.readAndParse({ import cbsq.riffmt.byteManipImplicits.* ; basicEightByteBlob.newGrossReader().asMarkableStream() })

   // }
   
}














