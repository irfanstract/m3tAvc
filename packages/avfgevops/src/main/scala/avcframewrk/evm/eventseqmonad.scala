package avcframewrk.evm

















/**
 * 
 * a "monad" for asynchronously-emitted "event product"s
 * 
 */
type EventSequenceMonad[+E <: Product]
   >: AsyncAlgMonad[E]
   <: AsyncAlgMonad[E]

type EventSeqMonad[+E <: Product]
   = EventSequenceMonad[E]

type EventMonad[+E <: Product]
   = EventSequenceMonad[E]

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

/**
 * 
 * a fresh/independent/new pipe (`EventSequenceMonad`) ;
 * the first itc being for the producer-side,
 * the second itc being for the consumer-side
 * 
 * *subscriber*s can come later than items emitted, so
 * it'd be necessary to define the expected behv, by setting `multicastStrategy`
 * 
 * 
 * @param typingFnc a work-around to programmers forgetting to define `E1` explicitly
 * 
 * @param multicastStrategy [[monix.reactive.MulticastStrategy]]
 * 
 * @param scheduler `monix.execution.Scheduler`
 * 
 */
def newEventSequencePipe[
   E1 <: Product ,
]
(
   typingFnc: E1 => Unit ,

   multicastStrategy
   : monix.reactive.MulticastStrategy[E1]
   ,

   scheduler
   : monix.execution.Scheduler
   = monix.execution.Scheduler.Implicits.global
   ,

)
= {

   val (p1, p20) = newAlgebrPipe[E1](typingFnc = identity[E1], multicastStrategy = multicastStrategy )

   (p1, p20)
}

lazy val _ = {

   emptyAsyncEventSequenceMonad
   .map(_ => "hi" )
   .map(_ => "hi" )
   .map(_ => "hi" )
   .map(_ => "hi" )
}















