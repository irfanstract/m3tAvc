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

   val asDescribesDoRenderRefreshRatedContent : XImplementsDoDescribeDiscretelyProgressiveCont[this.type]

   val asDescribesDoRenderCommonContent : XImplementsDoDescribeCommonContent[this.type]

}

object XAclImpl
{

   implicit
   def getDddc(this1 : XAclImpl)
   : XImplementsDoDescribeDiscretelyProgressiveCont[this1.type]
   = this1.asDescribesDoRenderRefreshRatedContent
   
   implicit
   def getDdcc(this1 : XAclImpl)
   : XImplementsDoDescribeCommonContent[this1.type]
   = this1.asDescribesDoRenderCommonContent
   
}

trait XImplementsDoDescribeCommonContent[+This <: XAclImpl ]
extends
AnyRef
{

   this : (
      AnyRef
      & XddPre[This]
      
   ) =>

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

trait XImplementsDoDescribeDiscretelyProgressiveCont[+This <: XAclImpl ]
extends
AnyRef
{

   this : (
      AnyRef
      & XddPre[This]
      
   ) =>

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

}

trait XddPre[+This <: XAclImpl ](val this1: This) {
   
   export this1.RDoc

}

;


































