package avcframewrk.forms

package templating

package ext.givmk


















opaque type ButtonModelAllocator
<: ButtonModelAllocatorImpl
= ButtonModelAllocatorImpl

protected
trait ButtonModelAllocatorImpl
extends
AnyRef
   with TypeBoxLikeAllocatorImpl[Nothing, Any]
{
   ;
   ;
   ;
}

def callbackButtonModel
   (using btnModelAlloc : ButtonModelAllocator )
   (using cbConv : CallbackButtonConv[btnModelAlloc.CAP] )
   (f: cbConv.FMin )
= cbConv.apply(f)

opaque type CallbackButtonConv[+R]
<: CallbackButtonConvImpl[R, AnyRef, Unit | Boolean ]
=  CallbackButtonConvImpl[R, AnyRef, Unit | Boolean ]

protected
trait CallbackButtonConvImpl[+ArtR, +FArg0, -FReturn0]
{
   ;

   type FMin
   >: (PartialFunction[FArg0 , FReturn0] ) @annotation.unchecked.uncheckedVariance
   <: (PartialFunction[FArg0 , FReturn0] ) @annotation.unchecked.uncheckedVariance

   def apply
      [F <: FMin ]
      (f: F )
   : ArtRFromF[f.type ]

   type ArtRFromF
      [+F <: FMin]
   <: ArtR

   ;
}




















val _ = {}