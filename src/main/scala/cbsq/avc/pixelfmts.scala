package cbsq.avc












/**
 * 
 * the common px fmts
 * 
 */
enum PixelFmt {

   case YuvFamilyPixelFmt      [+Desc](desc: Desc)
   case ArgbFamilyPixelFmt     [+Dsc <:      ArgbFamilyPixelFmt.Desc](desc: Dsc)
   case GrayscaleFamilyPixelFmt[+Dsc <: GrayscaleFamilyPixelFmt.Desc](desc: Dsc)

}
object  PixelFmt {
   
   export reflect.ClassTag
   
   object  ArgbFamilyPixelFmt extends 
   AnyRef
   with FamilyDefCompanion
   {

      sealed trait Desc {
         val pixelBitDepth: ClassTag[?]
         val hasAlphaChannel: Boolean
      }

      case class Desc1[
         +BD <: ClassTag[Byte] | ClassTag[Short] | ClassTag[Int] ,
         +HasAlphaChnl <: Boolean ,
      ](
         pixelBitDepth: BD ,
         hasAlphaChannel: HasAlphaChnl,
      ) extends Desc 

   }
   
   object GrayscaleFamilyPixelFmt extends 
   AnyRef
   with FamilyDefCompanion
   {
      
      sealed trait Desc {
         val pixelBitDepth: ClassTag[?]
      }
      
   }

   /**
    * 
    * they each shall implement this common protocol.
    * 
    */
   trait FamilyDefCompanion {

      type Desc <: {
         val pixelBitDepth: ClassTag[?]
      }

   }

}







