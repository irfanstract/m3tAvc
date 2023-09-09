package avcframewrk.forms

package templating

package w3e.impl.js.s1















/**
 * like "pipe"s, but
 * instead of individual items we pass `Observable`s instead
 * 
 */
def newValueUpdateRepipe[R](
   //
   prototype
      : (value: R) => Any
   ,
   initialValue
      : R
   ,
)
= {
   ;

   implicit val scheduler
   = trySameThreadScheduler()

   laminar.api.L.Var[AsyncStateChangeMonad[R] ](laminar.api.L.Val(initialValue ) )
   match { case pipe => {
      (pipe.writer, {
         pipe.signal
         .flatMap(_.toLaminarObservable )
         match { case e => e : AsyncStateChangeMonad[R] }
      } )
   } }
} // newValueUpdateRepipe

/**
 * the consumer-side itc ref will never change identity ; only the impl will change .
 * like "pipe"s, but
 * instead of individual fnc(s) we pass `Observable`s emitting fnc(s) instead .
 * 
 */
def newCallbackImplUpdateRepipe
   [
      A,
      R,
   ]
   (
      //
      prototype
         : (arg: A) => R
      ,
      initialImpl
         : A => R
      = (_: Any) => { throw new IllegalStateException(s"no initial impl") }
      ,
   )
= {
   ;

   type F
   = (argOrCtx: A) => R

   implicit val scheduler
   = trySameThreadScheduler()

   newValueUpdateRepipe(
      //
      prototype = (a: A => R ) => {} ,
      initialValue = initialImpl ,
   )
   match { case (_1, _2) => {
      ;

      var vle
      : F
      = initialImpl

      _2
      .map(c => { vle = c } )
      .toLaminarObservable
      .replaceAllExceptionsWithConstException()

      locally[(_1.type, F )](_1, { (arg: A) => vle.apply(arg) } )
   } }
} // newCallbackImplUpdatePipe

















val _ = {}
