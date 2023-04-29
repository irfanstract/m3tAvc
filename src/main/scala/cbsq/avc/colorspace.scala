package cbsq.avc













/** 
 * 
 * the colour-channels, neglecting the storage-fmt(s) (instead, see `PixFmt`).
 * never includes *the alpha channel*; shall be separately selected.
 * 
 * */
enum ColorChannelsFmt[+F <: ColorChannelsFmt.Properties1](
   val properties: F ,
) {

   case BlueGreenRed extends ColorChannelsFmt({
      object xpr extends ColorChannelsFmt.Properties1 {

         final val isAllAdditive = true

      }
      xpr
   })
   case BlueGreenYellowRed extends ColorChannelsFmt({
      object xpr extends ColorChannelsFmt.Properties1 {

         final val isAllAdditive = true

      }
      xpr
   })
   
   case YUV extends ColorChannelsFmt({
      object xpr extends ColorChannelsFmt.Properties1 {

         final val isAllAdditive = false

      }
      xpr
   })
   case YCbCr extends ColorChannelsFmt({
      object xpr extends ColorChannelsFmt.Properties1 {

         final val isAllAdditive = false

      }
      xpr
   })

   case CyanAndRed extends ColorChannelsFmt({
      object xpr extends ColorChannelsFmt.Properties1 {

         final val isAllAdditive = true

      }
      xpr
   })

   case Gray extends ColorChannelsFmt({
      object xpr extends ColorChannelsFmt.Properties1 {

         final val isAllAdditive = true

      }
      xpr
   })

   export properties.isAllAdditive

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

   implicitly[(BlueGreenRed   .isAllAdditive.type) <:< (true )]
   implicitly[(YCbCr          .isAllAdditive.type) <:< (false)]

   sealed trait Properties1 {
      
      /**
       * whether all the channels listed by this CCF are all mutually-additive
       * 
       * in case of Grayscale and BGR and BGYR, 
       * the total-intensity 
       * would be the sum of the intensities of all the channels, and
       * increasing the intensity of any channel 
       * will monotonically increase the total-intensity ;
       * in case of YUV and YCbCr, however,
       * that's not the case
       * 
       */
      val isAllAdditive: Boolean
      
   }

}













