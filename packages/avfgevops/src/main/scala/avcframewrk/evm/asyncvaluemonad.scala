package avcframewrk.evm











/**
 * 
 * a "monad" without any synchronously-inspective ops
 * 
 */
type AsyncAlgebraicMonad[+E1]
   >: ({ type Main[+E2] = monix.reactive.Observable[E2] } )#Main[E1]
   <: ({ type Main[+E2] = monix.reactive.Observable[E2] } )#Main[E1]

extension [E1](src : AsyncAlgebraicMonad[E1] )
{

   /**
    * 
    * analogously to `force` in `LazyList`,
    * enforces the evaluation of the whole path/chain, and then return `this`
    * 
    * requires a *given* `monix.execution.Scheduler`
    * 
    */
   def force(using monix.execution.Scheduler )
   : AsyncAlgebraicMonad[E1]
   = {

      src.subscribe() /* use the `given` */

      src
   }

} // AsyncAlgebraicMonad.force

type AsyncAlgebrMonad[E1]
   = AsyncAlgebraicMonad[E1]

type AsyncAlgMonad[E1]
   = AsyncAlgebraicMonad[E1]

@deprecated
// export AsyncAlgebraicItemStream.{newPipe => newAlgebrPipe } /* cannot use this idiom; it discarded the default args */
def newAlgebrPipe[E1](
   typingFnc: E1 => Unit ,

   multicastStrategy
   : MonixMulticastStrategy[E1]
   ,

   scheduler
   : monix.execution.Scheduler
   = monix.execution.Scheduler.Implicits.global
   ,
   
)
= AsyncAlgebraicItemStream.newPipe[E1](typingFnc = typingFnc, multicastStrategy = multicastStrategy, scheduler = scheduler)

object AsyncAlgebraicItemStream
{
;

/**
 * 
 * a fresh/independent/new pipe (`AsyncAlgebraicMonad`) ;
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
def newPipe[E1](
   typingFnc: E1 => Unit ,

   multicastStrategy
   : MonixMulticastStrategy[E1]
   ,

   scheduler
   : monix.execution.Scheduler
   = monix.execution.Scheduler.Implicits.global
   ,
   
)
: (
   /* first, the producer-side itc */
   monix.reactive.Observer[E1]
   ,

   /* second, the consumer-side itc */
   AsyncAlgebraicMonad[E1]
   ,
   
)
= {

   val core1 = {
      
      import monix.{reactive => m }

      given scheduler.type
         = scheduler

      m.subjects.ConcurrentSubject[E1](multicastStrategy )
      
   }

   (core1, core1 )
} // newPipe

} // AsyncAlgebraicItemStream$

/**
 * 
 * was initially implemented as `monix.reactive.MulticastStrategy`.
 * 
 */
type MonixMulticastStrategy[+E]
   >: monix.reactive.MulticastStrategy[E]
   <: monix.reactive.MulticastStrategy[E]

object MonixMulticastStrategy {

   /**
    * 
    * for async sequencing with high latency
    * 
    */
   def forAsyncEnum[E]
   = monix.reactive.MulticastStrategy.replay[BTA[E] ]

   /**
    * 
    * for async sequencing with high latency
    * 
    */
   val ForAsyncEnum
   : monix.reactive.MulticastStrategy.Replay.type
   = monix.reactive.MulticastStrategy.Replay

   /**
    * 
    * for async sequencing with high latency,
    * bounded to certain quantity
    * 
    */
   val ForAsyncEnumLimited
   : monix.reactive.MulticastStrategy.ReplayLimited.type
   = monix.reactive.MulticastStrategy.ReplayLimited

   def forUpdates[E]
   = monix.reactive.MulticastStrategy.replayLimited[BTA[E] ](capacity = 1 )

   def whichRestrictsToSubscription[E]
   = monix.reactive.MulticastStrategy.publish[BTA[E] ]

   type BTA[+E]
      <: Nothing

} // MonixMulticastStrategy$













