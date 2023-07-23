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

         c describeCriticalityLabel(msg = c describeAwtImageDisplay(???) )
         
      } : Unit )

      //
      (() => {

         c describeCriticalityLabel(msg = c.describeDiscretelyProgressiveContent(??? ) )
         
      } : Unit )

      //
      (() => {

         c describeButton(???)
         
      } : Unit )

      ()

      //
      (() => {

         // c describeButton(c describeActible(label = ???, callback = ??? ) )

         ()

      } : Unit )

   } : Unit
   
   (c: XAclTemplativeOpsImpl { type RDoc >: AnyRef } ) => {

      XAclTemplativeOpsImpl.getDdcc(c)
      
      //
      (() => {

         c describeCriticalityLabel(msg = ??? : AnyRef )
         
      } : Unit )

   } : Unit
   
}

lazy val _ = {

   // ??? : ({ type Main[-A] = XAclTemplativeOpsByRDoc[A] })#Main[AnyRef]

   // { type Main = [C <: [+_] =>> Any ] =>> Unit }
}

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

   /**
    * 
    * an actionable.
    * 
    */
   type Actible

   def describeActible(
      label : RDoc ,
      callback : PartialFunction[Any, Unit] ,
   )
   : Actible

   val representor
   : XAclTemplativeOpsImpl.this.type
   = XAclTemplativeOpsImpl.this

   type representorS
      = representor.type

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
   
   type XItsRepresentor[+C0 <: Singleton & XAclTemplativeOpsImpl ]
      = (
         (
            (
            {
               
               val ctx
                  : C0

               type Main
                  = ctx.representorS

            }
            )
            #Main
         )
      )

   type XItsRDoc[+C0 <: Singleton & XAclTemplativeOpsImpl ]
      = (
         (
            (
            {
               
               val ctx
                  : C0

               type Main
                  = ctx.RDoc

            }
            )
            #Main
         )
      )

   // implicit
   // def getAcb(this1 : XAclTemplativeOpsImpl)
   // : avcframewrk.util.forms.pure.DefinesDoDescribeButtonA1[this1.Actible, this1.RDoc]
   // = ???
   
   type XItsXActible[+C0 <: Singleton & XAclTemplativeOpsImpl ]
      = (
         (
            (
            {
               
               val ctx
                  : C0

               type Main
                  = ctx.Actible

            }
            )
            #Main
         )
      )

}

type XImplementsDoDescribeCommonContent[+This <: Singleton & XAclTemplativeOpsImpl ]
   // >: XddccImplByReceiver[This ]
   // <: XddccImplByReceiver[This ]
   >: XddccImplByRepresentor[(XImplementsDoDescribeCommonContent.RepresentorBaseline & XAclTemplativeOpsImpl.XItsRepresentor[This ]) @annotation.unchecked.uncheckedVariance ]
   <: XddccImplByRepresentor[(XImplementsDoDescribeCommonContent.RepresentorBaseline & XAclTemplativeOpsImpl.XItsRepresentor[This ]) @annotation.unchecked.uncheckedVariance ]

object XImplementsDoDescribeCommonContent
{

   type RepresentorBaseline
      >: XAclTemplativeOpsImpl#representorS
      <: XAclTemplativeOpsImpl#representorS

   //
   
}

@deprecated
type XddccImplByReceiver[+C0 <: Singleton & XAclTemplativeOpsImpl ]
   = (
      XddccImpl[
         XAclTemplativeOpsImpl.XItsRDoc[C0 ] @annotation.unchecked.uncheckedVariance ,
         (XImplementsDoDescribeCommonContent.RepresentorBaseline & XAclTemplativeOpsImpl.XItsRepresentor[C0 ]) @annotation.unchecked.uncheckedVariance ,
      ]
   )

type XddccImplByRepresentor[Representor <: Singleton & XImplementsDoDescribeCommonContent.RepresentorBaseline ]
   = (
      ({
         val representor : Representor

         type Main
         = 
         XddccImpl[
            representor.RDoc ,
            representor.type ,
         ]
      })
      #Main
   )

protected
trait XddccImpl[
   RDoc ,
   +R <: Singleton & XImplementsDoDescribeCommonContent.RepresentorBaseline ,
]( )
extends
AnyRef
with XDefinesDoDescribeSingularElement.ByRepresentor[(XImplementsDoDescribeCommonContent.RepresentorBaseline) & R ]
// with (
//    avcframewrk.util.forms.pure.DefinesDoDescribeButtonA1[XAclTemplativeOpsImpl.XItsXActible[C0] @annotation.unchecked.uncheckedVariance , RDoc]
// )
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

   type RepresentorBaseline
      >: XImplementsDoDescribeCommonContent.RepresentorBaseline
      <: XImplementsDoDescribeCommonContent.RepresentorBaseline

   type ByRepresentor[
      +Representor <: Singleton & RepresentorBaseline ,
   ]
   = Impl[Representor]

   protected
   trait Impl[
      +Representor <: Singleton & RepresentorBaseline ,
   ](
      val representor : Representor ,
   )
   extends
   AnyRef
   with avcframewrk.util.forms.pure.DefinesDoDescribeButtonA1[Nothing, Any & representor.RDoc]
   {

      // export representor.{*}
      export representor.{RDoc, Actible}

      //

      // def describeTrigger(c: Actible)
      // : RDoc
      
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

      def describeNumericalDisplay(
         v: String | AnyVal ,
         
      )
      (using Numeric[? >: v.type <: Any ] )
      : RDoc

      def describeAwtImageDisplay(
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


































