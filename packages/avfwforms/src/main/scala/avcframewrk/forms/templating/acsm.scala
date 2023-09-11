package avcframewrk.forms

package templating
















opaque type AsyncStateChangeMonad[+A]
   <: (
      AnyRef
      // & com.raquo.airstream.core.Signal[A]
   )
   =  com.raquo.airstream.core.Signal[A]
   /* what about `StrictSignal` ? */

object AsyncStateChangeMonad
{
   ;

   given [A]
   : Conversion[com.raquo.airstream.core.Signal[A] , AsyncStateChangeMonad[A] ]
   = identity[com.raquo.airstream.core.Signal[A] ] _

   extension [A] (this10: AsyncStateChangeMonad[A] ) {
      //

      private
      def thisAscm
      /* widen the type, to build on the opaque alias */
      : com.raquo.airstream.core.BaseObservable[AsyncStateChangeMonad, A]
      = this10

      private
      def thisS
      : com.raquo.airstream.core.Signal[A]
      = this10

      /*  */
      export thisAscm.{
         //

         map ,
         mapTo ,
         mapToStrict ,
         mapToUnit ,
         matchStreamOrSignal ,

         flatMap ,
         // foldLeft ,
         // foldLeftRecover ,
         foreach ,

         //
      }
      export thisAscm.{given}
      export thisS.{
         //

         changes ,
         // combineSeq ,
         compose ,
         composeAll ,
         composeChanges ,
         // currentValueFromParent ,
         debugWith ,
         // defaultDisplayName ,
         displayName ,
         setDisplayName ,
         distinct ,
         distinctBy ,
         distinctByFn ,
         distinctByRef ,
         distinctErrors ,
         distinctTry ,
         // removeExternalObserver ,
         // addExternalObserver ,
         // removeExternalObserverNow ,
         foldLeft ,
         foldLeftRecover ,
         // flatMap , /* refined above */
         // foldLeft ,
         // foldLeftRecover ,
         // foreach ,
         // fromCustomSource ,
         // fromFuture ,
         // fromJsPromise ,
         // fromTry ,
         // fromValue ,
         // addInternalObserver ,
         // removeInternalObserver ,
         // removeInternalObserverNow ,
         // isSafeToRemoveObserver ,
         // isSafeToRemoveObserver_= ,
         // isStarted ,
         // lastUpdateId ,
         // map , /* refined above */
         // mapTo ,
         // mapToStrict ,
         // mapToUnit ,
         // matchStreamOrSignal ,
         // maybeDisplayName ,
         // // maybeDisplayName_= ,
         // maybePendingObserverRemovals ,
         // // maybePendingObserverRemovals_= ,
         // maybeWillStart ,
         // nextUpdateId ,
         // now ,
         // numAllObservers ,
         observe ,
         addObserver ,
         // onAddedExternalObserver ,
         // onStart ,
         // onStop ,
         // onWillStart ,
         // getOrCreatePendingObserverRemovals ,
         // protectedAccessEvidence ,
         recover ,
         recoverIgnoreErrors ,
         recoverToTry ,
         scanLeft as scanLeftAdapted0 , /* redefined below */
         scanLeftRecover as scanLeftRecover0 ,
         // sequence ,
         throwFailure ,
         // topoRank ,
         // tryNow ,
         // toCombinableSignal ,
         // toDebuggableSignal ,
         toObservable ,
         // toSignalCompanionCombineSyntax ,
         toSignalIfStream ,
         // toSplittableOneSignal ,
         // toSplittableOptionSignal ,
         // toSplittableSignal ,
         toStreamIfSignal ,
         // toTupleSignal2 ,
         // toTupleSignal3 ,
         // toTupleSignal4 ,
         // toTupleSignal5 ,
         // toTupleSignal6 ,
         // toTupleSignal7 ,
         // toTupleSignal8 ,
         // toTupleSignal9 ,
         toWeakSignal ,

         //
      }

      def scanLeft[State](seed: => State )(doDigest: (State, A) => State )
      : AsyncStateChangeMonad[State]
      = {
         this10
         .scanLeftAdapted0
            [State]
            (initialVal => doDigest(seed, initialVal) )
            (doDigest )
      }

      def toLaminarObservable
      : com.raquo.airstream.core.Signal[A]
      = thisS

   }

   ;
} // AsyncStateChangeMonad$

opaque type EventMonad[+A]
   <: (
      AnyRef
      // & com.raquo.airstream.core.EventStream[A]
   )
   =  com.raquo.airstream.core.EventStream[A]

object EventMonad
{
   ;

   given [A]
   : Conversion[com.raquo.airstream.core.EventStream[A] , EventMonad[A] ]
   = identity[com.raquo.airstream.core.EventStream[A] ] _

   extension [A] (this10: EventMonad[A] ) {
      private
      def this11
      /* widen the type, to build on the opaque alias */
      : EventMonad[A] & com.raquo.airstream.core.BaseObservable[EventMonad, A]
      = this10

      export this11.{given }

      export this11.{
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
        scanLeft ,
        scanLeftRecover ,
        throwFailure ,
      //   topoRank ,
      //   tryNow ,
        toObservable ,
        toSignalIfStream ,
        toStreamIfSignal ,
        toWeakSignal ,
      }

   }

   ;
} // EventMonad$

type AsyncEventMonad[+A]
   = EventMonad[A]















val _ = {}
