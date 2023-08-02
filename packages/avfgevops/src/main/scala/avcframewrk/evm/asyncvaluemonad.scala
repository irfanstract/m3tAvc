package avcframewrk.evm











/**
 * 
 * a "monad" without any synchronously-inspective ops
 * 
 */
type AsyncAlgMonad[+E1]
   >: (avcframewrk.evm.xutil.CwfMonadTypeAsMain )#Main[E1]
   <: (avcframewrk.evm.xutil.CwfMonadTypeAsMain )#Main[E1]













