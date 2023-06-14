package cbsq.avc.codecs




















protected 
object ewfi {

   /**
    * 
    * necessity-test ; use `Option[Unit]`
    * 
    */
   type NecessityTest 
      >: reflect.TypeTest[Option[Unit], ? <: Option[Unit] ]
      <: reflect.TypeTest[Option[Unit], ? <: Option[Unit] ]

   import avcframewrk.util.characterstreams.asCharPipe

   def getAppendableImplWriter(dest: Appendable) : java.io.Writer = {
      
      dest.asCharPipe()
   }

   // export cbsq.avc.{*}
   // export cbsq.avc.upstream.{*}
   export cbsq.avc.LateBoundValue
   export cbsq.avc.upstream.Duration

   export cbsq.avc.hw.transcoding.EwfTranscodFnc

   export cbsq.avc.MediaKind

   trait WithFrameIterator[+R] { val frameIterator : R }  

   trait WithStreams[+R] { val streams : R }  

}


















































