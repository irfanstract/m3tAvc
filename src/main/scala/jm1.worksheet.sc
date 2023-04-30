
// import language.experimental.pureFunctions

import cbsq.avc.PixelFmt
import cbsq.avc.ColorChannelsFmt






// import cbsq.numerics 



List()

// List(7, compiletime.erasedValue)

// (((value) => {
//    ""
// }) : (Tuple -> "") )
// def f(m: Tuple -> "") =
//    ()

ColorChannelsFmt.BlueGreenRed

{
   transparent inline def cc1(): ColorChannelsFmt.BlueGreenRed.type =
      ColorChannelsFmt.BlueGreenRed
   () => cc1()
}

cbsq.FileSize.fromByteCount(0x32 )

java.nio.ByteBuffer.allocate(0x100)
java.nio.ByteBuffer.allocateDirect(0x100)




Seq.range(0, 0x10)
   .scanLeft[cbsq.avc.KByteBuffer](cbsq.avc.KByteBuffer.allocate(len = 0x80))({
      case (s0, _) =>
         s0 &:+ 0xC
   })

cbsq.avc.integer(3)

cbsq.riffmt.FourCC.metaInstance
cbsq.riffmt.FourCC("SFNT")
cbsq.riffmt.FourCC("TIFF")
cbsq.riffmt.FourCC("MKVD")

cbsq.ByteBlob

{
   import cbsq.avc.{CodecOverview, CodecTemplateOps, CodecTplIsInstantiable }
   (
      Seq[((CodecOverview) with CodecTplIsInstantiable { type Rd = java.io.Reader }) ]() ,
      Seq[((CodecOverview) with CodecTplIsInstantiable { type Rd = java.io.Reader })#Rd ]() ,
      Seq[((CodecOverview) with CodecTplIsInstantiable { type Rd = java.io.Reader })#ReadableBufferedSrc ]() ,
   )
}

{
   val reg = 
      cbsq.avc.codecs.newFccCodeRegistry
   new reg.#%% {
      override
      lazy val mimeTypes = (
         Set(
            "application/x-matroskavideos-advancedprofile" ,
            "application/x-matroskavideos-advancedprofile-es" ,
         )
      )
   }
   new reg.#%% {
      override
      lazy val mimeTypes = (
         Set(
            "application/x-whatwg-webm" ,
         )
      )
   }
   reg.registereds
}

{
   // import quoted.*
   5
   // ${ '{ 5 } }
}

([T] => () => {
   object impl {
      type ReadableBufferedSrc >: T <: T
   }
   impl
}).apply[(
   Iterator[String]
)]()

valueOf["string-1"]
compiletime.constValue["string-1"]
summon[ValueOf["string-1"]]
((v => v) : ((v: Any) => v.type ) )(valueOf["string-1"] )
Seq(valueOf["string-1"] )
Seq(res20 )

{
   if 0 < 5 then 
      true
   else 
      false
}



