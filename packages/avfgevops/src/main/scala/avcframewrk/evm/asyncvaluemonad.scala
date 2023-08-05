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
def newAlgebrPipe[E1](
   typingFnc: E1 => Unit ,

   multicastStrategy
   : monix.reactive.MulticastStrategy[E1]
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
}

/**
 * 
 * was initially implemented as `monix.reactive.MulticastStrategy`.
 * 
 */
type MonixMulticastStrategy[+E]
   = monix.reactive.MulticastStrategy[E]













