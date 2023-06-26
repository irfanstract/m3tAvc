package avcframewrk.forms.impl.generic

















;

val _ = {}

opaque type XAllComponentsList[R]
   >: avcframewrk.forms.impl.javaswing.XAllComponentsList[R]
   <: avcframewrk.forms.impl.javaswing.XAllComponentsList[R]
   = avcframewrk.forms.impl.javaswing.XAllComponentsList[R]

/* `avcframewrk.forms.impl.generic.XAllComponentsList` */
object XAllComponentsList
{

   given defaultInstance : impl.epm.valuePallete.type = {

      { import scala.reflect.Selectable.reflectiveSelectable ; impl.epm.valuePallete }
   }

   private [XAllComponentsList]
   object impl {

      val epm = {

         new avcframewrk.util.errorchecking.WildcardTypedInstancing.::![XAllComponentsList ] {
            
            opaque type Value
               = avcframewrk.forms.impl.javaswing.allInterfacesGivens.MainR

            final val valuePallete : XAllComponentsList[Value]
               = avcframewrk.forms.impl.javaswing.allInterfacesGivens.main

         }
      }

   }

} /* object `XAllComponentsList` */

;


































