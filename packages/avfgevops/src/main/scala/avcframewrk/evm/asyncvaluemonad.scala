package avcframewrk.evm











/**
 * 
 * a "monad" without any synchronously-inspective ops
 * 
 */
type AsyncAlgebraicMonad[+E1]
   >: (avcframewrk.evm.xutil.CwfMonadTypeAsMain )#Main[E1]
   <: (avcframewrk.evm.xutil.CwfMonadTypeAsMain )#Main[E1]

type AsyncAlgMonad[E1]
   = AsyncAlgebraicMonad[E1]













