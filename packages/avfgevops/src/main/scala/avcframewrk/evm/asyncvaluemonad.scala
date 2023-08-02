package avcframewrk.evm











/**
 * 
 * a "monad" without any synchronously-inspective ops
 * 
 */
type AsyncEnumerativeMonad[+E1]
   >: (avcframewrk.evm.xutil.CwfMonadTypeAsMain )#Main[E1]
   <: (avcframewrk.evm.xutil.CwfMonadTypeAsMain )#Main[E1]













