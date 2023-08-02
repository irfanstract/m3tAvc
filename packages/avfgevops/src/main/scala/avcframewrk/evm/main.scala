package avcframewrk.evm

val _ = {}













/**
 * 
 * a "monad" without any synchronously-inspective ops
 * 
 */
type AsyncItemMonad[+E]
   >: aimImpl.Main[E]
   <: aimImpl.Main[E]

/**
 * 
 * a "monad" for asynchronously-emitted "event product"s
 * 
 */
type EventMonad[+E <: Product]
   >: AsyncItemMonad[E]
   <: AsyncItemMonad[E]

def emptyEvtMonad: EventMonad[Nothing]
= {
   // TODO
   Seq()
   .asInstanceOf[AsyncItemMonad[Nothing] ]
}

val aimImpl
: { type Main[+E] <: collection.WithFilter[E, Main ] }
= {
   new AnyRef()
   .asInstanceOf[{ type Main[+E] <: collection.WithFilter[E, Main ] } ]
}













