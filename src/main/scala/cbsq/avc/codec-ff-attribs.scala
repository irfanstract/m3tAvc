package cbsq.avc

























/** 
 * 
 * to reflect the FF-Tools usage,
 * plain `String`s should be allowed
 * 
 */
trait FfMediaDvcTemplateOps extends
AnyRef
with MediaDeviceProperties
with mdoParamBuilders.ArgsAndTheirBuildability
{

      override
      type Args >: String

      extension [A <: Args](a: A) {

         override
         def withSpecString(s: SpecString)(using ArgsDerivCompletibility[A, a.type, ardtDrvWithSpecString.type] ): Args = {
            s
         }

      }

}





/** 
 * 
 * end-pt dvc
 * 
 */
trait FfMediaEndPointDeviceTemplateOps extends
AnyRef
with FfMediaDvcTemplateOps
with MediaDeviceProperties
with MediaEndPointDeviceProperties
with mdoParamBuilders.ArgsAndTheirBuildability
{
   
}




/** 
 * 
 * codec, regardless whether mux or per-stream,
 * 
 */
trait FfCodecTemplateOps extends
AnyRef
with FfMediaDvcTemplateOps
with MediaCodecPropertiesMixin
with mcdcParamBuilders.ArgsAndTheirBuildability
{

}

/** 
 * 
 * codec, regardless whether mux or per-stream,
 * dealing with raw-stream(s) from given `IoStream` or *path/URL*
 * 
 * to reflect the FF-Tools usage,
 * we narrow  `Args` to `String` `java.net.URI` or `java.io.InputStream`
 * 
 */
trait FfRawStreamCodecTemplateOps extends
AnyRef
with FfCodecTemplateOps
with MediaCodecPropertiesMixin
with mcdcParamBuilders.ArgsAndTheirBuildability
{

         type Args 
            >: String | java.net.URI | CharacteristicFd

         val argsInitially: Args

         // type CharacteristicFd
         //    <: java.io.InputStream | java.io.OutputStream

         extension [A <: Args](a: A) {
            
            override
            def forUrl(s: mcdcSupertraits.JUrlOrPath)(using ArgsDerivCompletibility[A, a.type, ardtForUrl.type] ): Args = {
               
               import language.unsafeNulls

               /**
                * `s.toURI()`
                */
               val s1 = {

                  s match {
                     case path : java.nio.file.Path   => path.toUri()
                     case path : java.net.URI         => path
                  }

               } : java.net.URI

               /**
                * with the "read"-or-"write" anntn
                */
               val s2 = {
                  (s1 : java.net.URI)
                  .toString()
                  .replaceFirst("\\A(read|write):", {
                     import scala.util.matching.Regex.quoteReplacement
                     "$1" + quoteReplacement(":")
                  })
                  match { case s => new java.net.URI(s) }
               }

               s2

            }
         
            override
            def forOpenedStream(s: CharacteristicFd )(using ArgsDerivCompletibility[A, a.type, ardtForOpenedStream.type] ): Args = {
               // TODO
               s
            }
         
         }

}




/** 
 * 
 * mux codec
 * 
 * to reflect the FF-Tools usage,
 * we narrow  `Args` to `String` `java.net.URI` or `java.io.InputStream`
 * 
 */
trait FfMuxCodecTemplateOps extends
AnyRef
with FfRawStreamCodecTemplateOps
with MediaCodecPropertiesMixin
{

}




/** 
 * 
 * stream codec
 * 
 */
trait FfPerStreamCodecTemplateOps extends
AnyRef
with FfCodecTemplateOps
with MediaCodecPropertiesMixin
{

         // type CharacteristicFd
         //    <: java.io.InputStream | java.io.OutputStream

}

/** 
 * 
 * stream codec for non-delimited streams
 * 
 */
trait FfUnpacketisedPerStreamCodecTemplateOps extends
AnyRef
with FfPerStreamCodecTemplateOps
with MediaCodecPropertiesMixin
with FfRawStreamCodecTemplateOps
{

         // type CharacteristicFd
         //    <: java.io.InputStream | java.io.OutputStream

}





@deprecated("experimental")
trait FfMuxCodecTemplateOps1(
   
   getInitialArgs: (c: FfMuxCodecTemplateOps) => c.Args = {
      (ctx) => {
         new java.net.URI("not-found:")
      }
   } ,

) extends
AnyRef
with FfMuxCodecTemplateOps
{

         override   
         val argsInitially: Args = {
            // new java.net.URI("not-found:")
            getInitialArgs(this)
         }

}






















































