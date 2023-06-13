package cbsq.avc.codecs

















/**
 * 
 * synchronously,
 * fully demuux Matroska file from given input,
 * blocking until the EOF.
 * 
 */
def fullyDemuuxMatroskaFile(r : java.io.InputStream ) = {

   demuuxMatroskaFile(r)(
      //

      eagerness = {
         cbsq.riffmt.ebmsGenericUtils.Eagerness.toBeEager
      } ,

   )

}

def iterativelyDemuuxMatroskaFile(r : java.io.InputStream ) = {

   demuuxMatroskaFile(r)(
      //

      eagerness = {
         cbsq.riffmt.ebmsGenericUtils.Eagerness.toBeLazy
      } ,

   )
   
}

def demuuxMatroskaFile(r : java.io.InputStream )(
   // 

   eagerness : cbsq.riffmt.ebmsGenericUtils.Eagerness ,   

) = {
   ;

   import cbsq.riffmt.*
   
   import byteManipImplicits.*
   import EBmlPrimitivesIo.*

   import language.unsafeNulls

   {
            ((r: UnpickleInputStream) => {
               
               import cbsq.avc.codecs.matrCd.{scheme => s, entries => sE}

               import cbsq.avc.codecs.matroskaSegmentElementScheme
               
               (
                  matroskaSegmentElementScheme

                  .readAndParseAlt(
                     //

                     src = r ,

                     eagerness = eagerness ,

                  )(using {

                     EBml.CodeSchemeOps.TraversalDiagnostique.nullaryInstance

                     .withFullSchemeInfo( sE)

                     .withCustomErrorHandler({
                     //

                     type XEvt >: Any <: Any

                     val XTolerableExc = identity[PartialFunction[XEvt, Unit ] ] {
                        
                        case z : (EBmlPrimitivesMalformationException.IDueToPayloadEofException) =>

                     }

                     identity[PartialFunction[XEvt, Seq[Any] ] ] {
                        
                        case z @ XTolerableExc(_) =>
                           Seq()

                     }
                     
                     })

                  } )

               )
               
            })({

               r
               .newCountingBufferedStream()
               .asMarkableStream()
               
            } )
   }
   
}















































