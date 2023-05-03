package cbsq.avc












/**
 * 
 * the common px fmts
 * 
 */
sealed 
abstract 
class  PixelFmt  extends 
   AnyRef 
   with Product
   with PixelFmt.CommonPxFmtOps
{
   
}
object  PixelFmt {

   // /* a work-around to unexpected widening and "type mismatch: expecting Singleton" */
   // extension [A](v: A) 
   //    def unary_+ : v.type = v

   // case YuvFamilyPixelFmt      [+Dsc <: YuvFamilyPixelFmt.Desc ](desc: Dsc)

   // case ArgbFamilyPixelFmt     [+Dsc <: ArgbFamilyPixelFmt.Desc](desc: Dsc)

   // case GrayscaleFamilyPixelFmt[+Dsc <: GrayscaleFamilyPixelFmt.Desc](desc: Dsc)

   export reflect.ClassTag
   
   case 
   object ofABgr32 extends 
   ArgbFamilyPixelFmt 
   with XPbd[Int]
   with XHasAlpha[true] 
   
   case 
   object ofARgb32 extends 
   ArgbFamilyPixelFmt 
   with XPbd[Int]
   with XHasAlpha[true] 
   
   case 
   object of0Bgr32 extends 
   ArgbFamilyPixelFmt
   with XPbd[Int]
   with XHasAlpha[false] 

   case 
   object of0Rgb32 extends 
   ArgbFamilyPixelFmt
   with XPbd[Int]
   with XHasAlpha[false] 

   case 
   object ofBgr0h32 extends 
   ArgbFamilyPixelFmt
   with XPbd[Int]
   with XHasAlpha[false] 

   /**
    * 
    * the *statics* of each `case` shall implement this common protocol.
    * 
    */
   sealed 
   trait FamilyDefCompanion {

      type Desc <: CommonPxFmtOps

   }

   sealed 
   trait YuvFamilyPixelFmt extends 
   PixelFmt
   with YuvFamilyPixelFmt.Desc

   object YuvFamilyPixelFmt extends 
   AnyRef
   with FamilyDefCompanion
   {
      
      sealed trait Desc extends 
      AnyRef
      with CommonPxFmtOps
      {

         final val colorSpace: ColorChannelsFmt.YUV.type =
            ColorChannelsFmt.YUV

         val pixelBitDepth: ClassTag[?]

      }
      
   }

   sealed 
   abstract 
   class ArgbFamilyPixelFmt extends 
   PixelFmt
   with ArgbFamilyPixelFmt.Desc

   object  ArgbFamilyPixelFmt extends 
   AnyRef
   with FamilyDefCompanion
   {

      sealed trait Desc extends 
      AnyRef
      with CommonPxFmtOps
      {

         final val colorSpace: ColorChannelsFmt.BlueGreenRed.type =
            ColorChannelsFmt.BlueGreenRed

         val pixelBitDepth    : ClassTag[?]
         val hasAlphaChannel  : Boolean

      }

   }
   
   sealed 
   trait GrayscaleFamilyPixelFmt extends 
   PixelFmt
   with GrayscaleFamilyPixelFmt.Desc

   object GrayscaleFamilyPixelFmt extends 
   AnyRef
   with FamilyDefCompanion
   {
      
      sealed trait Desc extends 
      AnyRef
      with CommonPxFmtOps
      {

         final val colorSpace: ColorChannelsFmt.Gray.type =
            ColorChannelsFmt.Gray

         val pixelBitDepth: ClassTag[?]

      }
      
   }

   sealed 
   trait CommonPxFmtOps {
      
      val pixelBitDepth: ClassTag[?]

      val colorSpace: ColorChannelsFmt[?]
      
      val hasAlphaChannel  : Boolean

   }

   trait XPbd[V : ClassTag] extends 
   CommonPxFmtOps { final val pixelBitDepth = summon[ClassTag[V]] }

   trait XHasAlpha[+V <: Singleton & Boolean : ValueOf] extends 
   CommonPxFmtOps { final val hasAlphaChannel = valueOf[V] }

   trait XCsp[+V <: Singleton & ColorChannelsFmt[?] : ValueOf] extends 
   CommonPxFmtOps { final val colorSpace = valueOf[V] }

   // export consts.*

   extension (c: PixelFmt)
      
      def upperCasedName: String =
         val M = "\\Aof(?=[A-Z0-9])(.*)\\z".r
         c.toString() match
            case M(name) =>
               name.toUpperCase(java.util.Locale.ROOT )
            case v =>
               v
         


   override def toString(): String = "pixelFmts"

}










