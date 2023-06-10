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
                        
                        case z : (java.io.IOException) if {

                           {
                              def get(): Boolean = {

                                 import language.unsafeNulls

                                 if z.isInstanceOf[java.io.EOFException] then {
                                    return true
                                 }
                                 
                                 if z.getMessage() contains "no scheme for" then {
                                    return false
                                 }
                                 
                                 return true

                              }
                              get()
                           }
                        } =>
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















































