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

   extension (operand0: RDoc ) {

      /**
       * 
       * concat
       * 
       */
      def ++(operand1: RDoc): RDoc

   }

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

         (e : c.RDoc ) => {

            e ++ e

         } : Unit
         
      } : Unit
      
      (c: XAclImpl { type RDoc >: AnyRef } ) => {

         //
         (() => {

            c describeErrorMsg(??? : AnyRef )
            
            c describeErrorMsg(c describeAwtImageObj(???) )
            
         } : Unit )

         //
         (() => {

            c describeErrorMsg(c.describeDiscretelyProgressiveContent(??? ) )
            
         } : Unit )

      } : Unit
      
   }
   
}

type XImplementsDoDescribeCommonContent[+This <: Singleton & XAclImpl ]
   >: XddccImplByReceiver[This ]
   <: XddccImplByReceiver[This ]

type XddccImplByReceiver[+C0 <: Singleton & XAclImpl ]
   = (
      (
         ({

            val ctx
               : C0 @annotation.unchecked.uncheckedVariance

            type Main
               = XddccImpl[ctx.RDoc ]
         })
         #Main
      )
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

   /**
    * 
    * a prosal list,
    * with the orderedness depends on the `CC` which `children` implements,
    * 
    */
   def describePhrasalList(
      children: collection.immutable.Iterable[RDoc] ,
      header: RDoc ,

   )
   : RDoc
   
   /**
    * 
    * a list of values each together with label,
    * with the orderedness depends on the `CC` which `children` implements,
    * 
    */
   def describeKeyList[
      Value ,
   ](
      dataSet: (
         XDataListDescriptorByItem[Value]
      ) ,
      renderItemByKey: Value => RDoc ,

   )
   : RDoc

   type XDataListDescriptor

   val XDataListDescriptor
   : (
      AnyRef
      & XDldFactoryImpl[XDataListDescriptorByItem ]
   )

   type XDataListDescriptorByItem[+Item]
      <: XDataListDescriptor

}

trait XDldFactoryImpl[+ROf <: [Item] =>> Any ]
{

   def apply[
      Value ,
   ](
      keySet: (
         ([CC <: [Item] =>> collection.Iterable[Item] ] =>> (
            CC[AnyVal] | CC[String]
         ))[[E] =>> (Seq[E] | Set[E] ) ]
      ) ,
      getItemByKey: Any => Value ,

   )
   : ROf[Value]

}

type XImplementsDoDescribeDiscretelyProgressiveCont[+This <: Singleton & XAclImpl ]
   >: XFpDddpcByAc[This ]
   <: XFpDddpcByAc[This ]

protected
type XFpDddpcByAc[+C0 <: Singleton & XAclImpl ]
   = (
      ({
         
         val ctx
            : C0 @annotation.unchecked.uncheckedVariance
         type Main
            = (
               avcframewrk.util.forms.pure.XDefinesDoDescribeDiscretelyProgressiveCont.IndependentlyByRDoc[(
                  ctx.RDoc
               )]
            )

      })
      #Main
   )

trait XddPre[+This <: XAclImpl ](val this1: This) {
   
   export this1.RDoc

}

;


































