package avcframewrk.evm











/**
 * 
 * a "monad" without any synchronously-inspective ops
 * 
 */
type AsyncAlgebraicMonad[+E1]
   >: ({ type Main[+E2] = monix.reactive.Observable[E2] } )#Main[E1]
   <: ({ type Main[+E2] = monix.reactive.Observable[E2] } )#Main[E1]

type AsyncAlgebrMonad[E1]
   = AsyncAlgebraicMonad[E1]

type AsyncAlgMonad[E1]
   = AsyncAlgebraicMonad[E1]













