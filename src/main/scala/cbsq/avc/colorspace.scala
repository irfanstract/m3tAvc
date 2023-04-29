package cbsq.avc













/** 
 * 
 * the colour-channels, neglecting the storage-fmt(s) (instead, see `PixFmt`).
 * never includes *the alpha channel*; shall be separately selected.
 * 
 * */
enum ColorChannelsFmt {

   case BlueGreenRed 
   case BlueGreenYellowRed 
   
   case YCbCr 

   case CyanAndRed

   case Gray

}
object  ColorChannelsFmt {

   /**
    * 
    * alias of `BlueGreenRed`
    * 
    * */
   // lazy val RedGreenBlue = 
   //    compiletime.constValue[ColorChannelsFmt.BlueGreenRed.type] 
   lazy val RedGreenBlue: ColorChannelsFmt.BlueGreenRed.type =
      ColorChannelsFmt.BlueGreenRed

}













