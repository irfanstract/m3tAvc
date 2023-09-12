package avcframewrk.forms

package templating

















type AsyncEventMonad[+A]
   = EventMonad[A]

opaque type EventMonad[+A]
   <: (
      AnyRef
      // & com.raquo.airstream.core.EventStream[A]
   )
   =  com.raquo.airstream.core.EventStream[A]

object EventMonad
{
   ;

   def apply
      [A]
      (impl: com.raquo.airstream.core.EventStream[A] )
      /* to avoid problems while compiling, please don't put explicit type-ascription */
   = comRaquoAirstreamEventStreamAdapter[A].apply(impl)

   /** a boxing conversion */
   given comRaquoAirstreamEventStreamAdapter[A]
   : Conversion[com.raquo.airstream.core.EventStream[A] , EventMonad[A] ]
   = identity[com.raquo.airstream.core.EventStream[A] ] _

   extension [A] (this10: EventMonad[A] ) {
      //

      private
      def this11
      /* widen the type, to build on the opaque alias */
      : EventMonad[A] & com.raquo.airstream.core.BaseObservable[EventMonad, A]
      = this10

      private
      def this111
      /* widen the type, to build on the opaque alias */
      : EventMonad[A] & com.raquo.airstream.core.EventStream[A] & com.raquo.airstream.core.BaseObservable[EventMonad, A]
      = this10

      export this11.{given }

      export this111.{
      //   changes ,
        compose ,
      //   composeAll ,
      //   composeChanges ,
      //   currentValueFromParent ,
        debugWith ,
      //   defaultDisplayName ,
        displayName ,
        setDisplayName ,
        distinct ,
        distinctBy ,
        distinctByFn ,
        distinctByRef ,
        distinctErrors ,
        distinctTry ,
      //   removeExternalObserver ,
      //   addExternalObserver ,
      //   removeExternalObserverNow ,
        flatMap ,
        foldLeft ,
        foldLeftRecover ,
        foreach ,
      //   addInternalObserver ,
      //   removeInternalObserver ,
      //   removeInternalObserverNow ,
      //   isSafeToRemoveObserver ,
      //   isStarted ,
      //   lastUpdateId ,
        map ,
        mapTo ,
        mapToStrict ,
        mapToUnit ,
        matchStreamOrSignal ,
      //   maybeDisplayName ,
      //   maybePendingObserverRemovals ,
      //   maybeWillStart ,
      //   now ,
      //   numAllObservers ,
      //   observe ,
        addObserver ,
      //   onAddedExternalObserver ,
      //   onStart ,
      //   onStop ,
      //   onWillStart ,
      //   getOrCreatePendingObserverRemovals ,
      //   protectedAccessEvidence ,
        recover ,
        recoverIgnoreErrors ,
        recoverToTry ,
        scanLeft as scanLeft0 , /* amended below */
        scanLeftRecover ,
        throwFailure ,
      //   topoRank ,
      //   tryNow ,
        toObservable as toObservable0 /* TODO */ ,
        toSignalIfStream ,
        toStreamIfSignal ,
        toWeakSignal as toWeakSignal0 , /* amended below */
      }

      def scanLeft[State](seed: => State )(doDigest: (State, A) => State )
      : AsyncStateChangeMonad[State]
      = {
         this111.scanLeft0(seed)(doDigest )
         match { case c => c : AsyncStateChangeMonad[State] }
      }

      def toWeakSignal
      = {
         (this10.toWeakSignal0 )
         match { case s => AsyncStateChangeMonad(s) }
      }

   }

   ;
} // EventMonad$


























val _ = {}
