
import cbsq.avc.*







PixelFmt.ArgbFamilyPixelFmt

PixelFmt.YuvFamilyPixelFmt

PixelFmt

{
   object C extends Selectable {
      // export PixelFmt.*
   }
   C
}

// ""

PixelFmt.getClass().getName()

// pixelfmts

PixelFmt.ofABgr32
PixelFmt.ofABgr32.upperCasedName
PixelFmt.of0Rgb32.upperCasedName
PixelFmt.ofABgr32.hasAlphaChannel
summon[PixelFmt.ofABgr32.hasAlphaChannel.type <:< true]
new Selectable {
   export PixelFmt.*
}
{
   object C extends Selectable {
      export PixelFmt.ofABgr32.hasAlphaChannel
   }
   C
}
{
   // // inline def inl(inline v: Any)(using quoted.Quotes) = '{ v }
   // inline def s1 =
   //    ${ quoted.Expr((PixelFmt.ofAbgr32.hasAlphaChannel) ) }
   // s1
}
// PixelFmt.consts

// cbsq.avc.KPBB

((c: BbsdAvFrameHandler.OfVideoBufferAllocAndRefresh) => {
   c.allocate(
      resolution = (32, 32), 
      colorSpace = ColorChannelsFmt.BlueGreenRed, 
      pixFmt = PixelFmt.ofARgb32 ,
   )
} )

((c: BbsdAvFrameHandler.OfVideoBufferAllocAndRefresh) => {
   // c.allocate((32, 32), colorSpace = ColorChannelsFmt.YUV, pixFmt = PixelFmt.ofArgb32 )
} )






