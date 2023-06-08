package cbsq.avc.codecs

















/**
 * 
 * synchronously,
 * fully demuux Matroska file from given input,
 * blocking until the EOF.
 * 
 */
def fullyDemuuxMatroskaFile(r : java.io.InputStream ) = {
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

                  .readAndParse(r)(using {

                     EBml.CodeSchemeOps.TraversalDiagnostique.nullaryInstance

                     .withFullSchemeInfo( sE)

                     .withCustomErrorHandler({
                        
                        case z : (java.io.IOException) =>
                           Seq()

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















































