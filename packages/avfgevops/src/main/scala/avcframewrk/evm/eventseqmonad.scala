package avcframewrk.evm

















/**
 * 
 * a "monad" for asynchronously-emitted "event product"s
 * 
 */
type EventSeqMonad[+E <: Product]
   >: AsyncAlgMonad[E]
   <: AsyncAlgMonad[E]

/**
 * 
 * a `EventSeqMonad` which does not yield any event.
 * 
 */
def emptyAsyncEventSequenceMonad
: EventSeqMonad[Nothing]
= {
   // TODO
   Seq()
   .withFilter(_ => true )
   .asInstanceOf[EventSeqMonad[Nothing] ]
}

lazy val _ = {

   emptyAsyncEventSequenceMonad
   .map(_ => "hi" )
   .map(_ => "hi" )
   .map(_ => "hi" )
   .map(_ => "hi" )
}















