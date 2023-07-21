package avcframewrk.forms.impl.generic

















;

val _ = {}

opaque type XAllComponentsList
   <: XAclImpl
   = XAclImpl

/* `avcframewrk.forms.impl.generic.XAllComponentsList` */
object XAllComponentsList
{

   // import avcframewrk.forms.impl.javaswing.allInterfacesGivens

   type OfWldcd
      >: XAllComponentsList
      <: XAllComponentsList

   // given defaultInstance: OfWldcd = {

   //    avcframewrk.util.errorchecking.WildcardTypedInstancing.ForIcdf[
   //       XAllComponentsList,
   //       allInterfacesGivens.MainR ,
   //    ](
   //       //
   //       actualFactory = allInterfacesGivens.main ,
   //    )
   // }

} /* object `XAllComponentsList` */

trait XAclImpl
{

   /**
    * 
    * the upper-bound for
    * the return-type of the "describe" methods
    * 
    */
   type RDoc

   /**
    * 
    * describe
    * a discretely-progressive content described by the given `EventIterator`
    * 
    */
   def describeDiscretelyProgressiveContent(
      c: EventIteratorByItemAndDesignation[RDoc, TsevpEventType.ofUpdate.type ] ,

   ) 
   : RDoc

   /**
    * 
    * describe
    * a rendition of discretely-progressive value described by the given `EventIterator`
    * 
    */
   def describeDiscretelyProgressiveValue[
      Value ,
      
   ](
      i1: EventIteratorByItemAndDesignation[Value, TsevpEventType.ofUpdate.type ] ,
      r: Value => RDoc ,

   ) 
   : RDoc

   /**
    * 
    * translate given UTF content.
    * can optionally mention *the locale*, otherwise will result in auto-ident for it.
    * 
    */
   def describeByUtf(
      c: String ,
      l: java.util.Locale = java.util.Locale.ROOT.nn ,

   )
   : RDoc

   def describeAwtImageObj(
      v: java.awt.Image ,

   )
   : RDoc
   
}

;


































