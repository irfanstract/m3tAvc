package cbsq.avc

























/** 
 * 
 * to reflect the FF-Tools usage,
 * plain `String`s should be allowed
 * 
 */
trait FfMediaDvcTemplateOps extends
AnyRef
with MediaDeviceOverview
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
with MediaEndPointDeviceOverview
{
   
}




/** 
 * 
 * to reflect the FF-Tools usage,
 * we narrow  `Args` to `String` `java.net.URI` or `java.io.InputStream`
 * 
 */
trait FfMuxCodecTemplateOps extends
AnyRef
with FfMediaDvcTemplateOps
with MediaCodecPropertiesMixin
{

         type Args 
            >: String | java.net.URI | java.net.URL | java.nio.file.Path | CharacteristicFd
            <: String | java.net.URI | java.net.URL | java.nio.file.Path | CharacteristicFd

         val argsInitially: Args

         type CharacteristicFd
            <: java.io.InputStream | java.io.OutputStream

         extension [A <: Args](a: A) {
            
            override
            def forUrl(s: mcdcSupertraits.JUrlOrPath)(using ArgsDerivCompletibility[A, a.type, ardtForUrl.type] ): Args = {
               s
            }
         
            override
            def forOpenedStream(s: CharacteristicFd )(using ArgsDerivCompletibility[A, a.type, ardtForOpenedStream.type] ): Args = {
               // TODO
               s
            }
         
         }

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






















































