package cbsq.riffmt














// object  FourCC
// {
// 
//    def apply[Value <: String](v: Value): FourCC =
//       Instance1[v.type](value = v)
// 
//    export Instance1.unapply
// 
//    protected 
//    case class Instance1[+S <: String](value: S) extends 
//    FourCC
//    
// }
// sealed abstract class FourCC extends 
// AnyRef 
// with Matchable
// 
/**
 * 
 * a *FourCC tag* is a 4-byte sequence denoting a RIFF's payload fmt.
 * 
 */
enum FourCC {

   @deprecated
   case ByString[+S <: String](value: S)
   
}
object FourCC {

   lazy val metaInstance =
      applyForNormalised(value = "RIFF")
   
   // implicit 
   // def apply1[S <: String]()(using V : ValueOf[S], aside1 : Conversion[Float, Float] ): ByString[String] =
   //    apply(valueOf[S] )
   def apply[S <: String](value: S): ByString[String] =
      applyForNormalised(value = value.toUpperCase(java.util.Locale.ROOT) )
   export FourCC.ByString.{unapply }
   
   protected 
   def applyForNormalised[S <: String](value: S): FourCC.ByString[value.type] =
      require((
         (value: String).toUpperCase(java.util.Locale.ROOT) 
         == value
      ) )
      require((
         (value: String).length() 
         == 4
      ), s"string length not 4 ; $value")
      /* return */
      FourCC.ByString(value = value)

}









