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
   : this1.asDescribesDoRenderCommonContent.type
   = this1.asDescribesDoRenderCommonContent

   val _ = {

      (c: XAclImpl ) => {

         //
         
      } : Unit
      
      (c: XAclImpl { type RDoc >: AnyRef } ) => {

         //
         (() => {

            c describeErrorMsg(??? : AnyRef )
            
            c describeErrorMsg(c describeAwtImageObj(???) )
            
         } : Unit )

      } : Unit
      
   }
   
}

type XImplementsDoDescribeCommonContent[+This <: Singleton & XAclImpl ]
   >: XddccByReceiver[This ]
   <: XddccByReceiver[This ]

type XddccByReceiver[+This <: Singleton & XAclImpl ]
   = (
      XddccImpl[(
         ({
            val c1 : This @annotation.unchecked.uncheckedVariance
            type T2 = c1.RDoc
            type TFinal = T2
         })
         #TFinal
      )]
   )

trait XddccImpl[RDoc ]
extends
AnyRef
{

   def describeErrorMsg(
      v: RDoc ,

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

type XImplementsDoDescribeDiscretelyProgressiveCont[+This <: Singleton & XAclImpl ]
   >: XFpDddpcByAc[This ]
   <: XFpDddpcByAc[This ]

protected
type XFpDddpcByAc[+This <: Singleton & XAclImpl ]
   = (
      avcframewrk.util.forms.pure.XDefinesDoDescribeDiscretelyProgressiveCont.IndependentlyByRDoc[(
         ({
            val c1 : This @annotation.unchecked.uncheckedVariance
            type T2 = c1.RDoc
            type TFinal = T2
         })
         #TFinal
      )]
   )

trait XddPre[+This <: XAclImpl ](val this1: This) {
   
   export this1.RDoc

}

;


































