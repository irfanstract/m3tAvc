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
extends
AnyRef
with XAclTemplativeOpsImpl
{

   val quickTemplatingMode : XAclTemplativeOpsImpl

}

object XAclImpl
{

   implicit
   def gto(this1 : XAclImpl)
   : this1.quickTemplatingMode.type
   = {

      this1.quickTemplatingMode
   }
   
   //

}

lazy val _ = {

   (c: XAclImpl ) => {

      //

      (e : c.RDoc ) => {

         e ++ e

      } : Unit
      
      //
      (() => {

         c describeCriticalityLabel(msg = c describeAwtImageObj(???) )
         
      } : Unit )

      //
      (() => {

         c describeCriticalityLabel(msg = c.describeDiscretelyProgressiveContent(??? ) )
         
      } : Unit )

   } : Unit
   
   (c: XAclTemplativeOpsImpl { type RDoc >: AnyRef } ) => {

      //
      (() => {

         c describeCriticalityLabel(msg = ??? : AnyRef )
         
      } : Unit )

   } : Unit
   
}

// lazy val _ = {

//    ??? : ({ type Main[-A] = XAclTemplativeOpsByRDoc[A] })#Main[AnyRef]
// }

type XAclTemplativeOpsByRDoc[ActualRDoc]
   = XAclTemplativeOpsImpl { type RDoc >: ActualRDoc <: ActualRDoc }

trait XAclTemplativeOpsImpl
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

   extension (operand0: RDoc ) {

      /**
       * 
       * concat
       * 
       */
      def ++(operand1: RDoc): RDoc

   }

}

object XAclTemplativeOpsImpl
{

   implicit
   def getDddc(this1 : XAclTemplativeOpsImpl)
   : XImplementsDoDescribeDiscretelyProgressiveCont[this1.type]
   = this1.asDescribesDoRenderRefreshRatedContent
   
   implicit
   def getDdcc(this1 : XAclTemplativeOpsImpl)
   : this1.asDescribesDoRenderCommonContent.type
   = this1.asDescribesDoRenderCommonContent
   
   protected[avcframewrk] 
   type CtxBeingCAndMainBeingCtxRDoc[+C0 <: Singleton & XAclTemplativeOpsImpl ]
      = {
         
               val ctx
                  : C0

               type Main
                  = ctx.RDoc

      }

   type XRDocFrom[+C0 <: Singleton & XAclTemplativeOpsImpl ]
      >: XItsRDoc[C0]
      <: XItsRDoc[C0]

   type XItsRDoc[+C0 <: Singleton & XAclTemplativeOpsImpl ]
      = (
         (
            CtxBeingCAndMainBeingCtxRDoc[C0]
            #Main
         )
      )

}

type XImplementsDoDescribeCommonContent[+This <: Singleton & XAclTemplativeOpsImpl ]
   >: XddccImplByReceiver[This ]
   <: XddccImplByReceiver[This ]

type XddccImplByReceiver[+C0 <: Singleton & XAclTemplativeOpsImpl ]
   = XddccImpl[XAclTemplativeOpsImpl.XItsRDoc[C0 ] @annotation.unchecked.uncheckedVariance ]

trait XddccImpl[RDoc ]
extends
AnyRef
with XDefinesDoDescribeSingularElement.ByR[RDoc]
with XDefinesDoDescribePhrasalOrKeyList.ByR[RDoc]
{

   @deprecated
   def describeCriticalityLabel(
      // level: "info" | "warn" | "error" = "error" ,
      msg: RDoc ,

   )
   : RDoc
   
}

object XddccImpl {

}

object XDefinesDoDescribeSingularElement
{

   type ByR[RDoc]
      = Impl[RDoc]
      
   protected
   trait Impl[RDoc]
   {

      //
      
      /**
       * 
       * translate given UTF content.
       * can optionally mention *the locale*, otherwise will necessitate guessing.
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

   //

}

export avcframewrk.util.forms.pure.XDefinesDoDescribePhrasalOrKeyList

type XImplementsDoDescribeDiscretelyProgressiveCont[+This <: Singleton & XAclTemplativeOpsImpl ]
   >: XFpDddpcByAc[This ]
   <: XFpDddpcByAc[This ]

protected
type XFpDddpcByAc[+C0 <: Singleton & XAclTemplativeOpsImpl ]
   = (
      avcframewrk.util.forms.pure.XDefinesDoDescribeDiscretelyProgressiveCont.IndependentlyByRDoc[(
         XAclTemplativeOpsImpl.XItsRDoc[C0 @annotation.unchecked.uncheckedVariance ]
      )]
   )

trait XddPre[+This <: XAclTemplativeOpsImpl ](val this1: This) {
   
   export this1.RDoc

}

;


































