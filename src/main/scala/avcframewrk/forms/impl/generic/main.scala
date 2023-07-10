package avcframewrk.forms.impl.generic

















;

val _ = {}

opaque type XAllComponentsList[R]
   // >: avcframewrk.forms.impl.javaswing.XAllComponentsList[R]
   <: avcframewrk.forms.impl.javaswing.XAllComponentsList[R]
   = avcframewrk.forms.impl.javaswing.XAllComponentsList[R]

/* `avcframewrk.forms.impl.generic.XAllComponentsList` */
object XAllComponentsList
{

   import avcframewrk.forms.impl.javaswing.allInterfacesGivens

   type OfWldcd
      >: ({ type Instance ; type Factory <: XAllComponentsList[Instance] })#Factory
      <: ({ type Instance ; type Factory <: XAllComponentsList[Instance] })#Factory

   given defaultInstance: OfWldcd = {

      avcframewrk.util.errorchecking.WildcardTypedInstancing.ForIcdf[
         XAllComponentsList,
         allInterfacesGivens.MainR ,
      ](
         //
         actualFactory = allInterfacesGivens.main ,
      )
   }

} /* object `XAllComponentsList` */

;


































