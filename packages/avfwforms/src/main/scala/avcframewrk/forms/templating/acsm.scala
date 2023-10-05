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

   def apply
      [A]
      (impl: com.raquo.airstream.core.Signal[A] )
      /* to avoid problems while compiling, please don't put explicit type-ascription */
   = comRaquoAirstreamSignalAdapter[A].apply(impl)

   /** a boxing conversion */
   given comRaquoAirstreamSignalAdapter[A]
   : Conversion[com.raquo.airstream.core.Signal[A] , AsyncStateChangeMonad[A] ]
   = identity[com.raquo.airstream.core.Signal[A] ] _

   extension [A] (this10: AsyncStateChangeMonad[A] ) {
      //

      /** aux - F-bounded */
      private
      def thisAscm
      /* widen the type, to build on the opaque alias */
      : com.raquo.airstream.core.BaseObservable[AsyncStateChangeMonad, A]
      = this10

      /** aux - F-bounded */
      private
      def thisAscm1
      /* widen the type, to build on the opaque alias */
      : com.raquo.airstream.core.BaseObservable[AsyncStateChangeMonad, A] & com.raquo.airstream.core.Signal[A] & AsyncStateChangeMonad[A]
      = this10

      /** aux - static */
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

         changes as changes0 , /* the original name to be redefined below */
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
         scanLeft as scanLeftAdapted0 , /* the original name to be redefined below */
         scanLeftRecover as scanLeftRecoverAdapted , /* the original name to be redefined below */
         // sequence ,
         throwFailure ,
         // topoRank ,
         // tryNow ,
         // toCombinableSignal ,
         // toDebuggableSignal ,
         toObservable as toObservable0 , /* the original name to be redefined below */
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

      def changes
      : EventMonad[A]
      = {
         /* note: implicit conversion */
         thisS.changes0
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

      /** 
       * select only updates which satisfies the cond, yield as `Some[U]` ;
       * if none yet matches, stay at `None`
       * 
       */
      def collectUpdatesEachOption
         [U]
         (f: PartialFunction[A, U] )
      : AsyncStateChangeMonad[Option[U] ]
      = {
         ;
         val fLifted = f.lift
         ;
         this10
         .scanLeftAdapted0(fLifted)((formerLocalState, newUpstreamState) => {
            ;
            (fLifted.apply(newUpstreamState) orElse formerLocalState )
         })
      }

      /** our cover of `toObservable` - exclusively in terms of the local type-def */
      def toObservable
      : AsyncStateChangeMonad[A]
      = thisAscm1

      /** `toLaminarObservable`, without any F-Bounding */
      def toLaminarObservable
      : com.raquo.airstream.core.Signal[A]
      = thisS

      /** `toLaminarObservable`, with F-Bounding */
      def toLaminarObservable1
      : (
         com.raquo.airstream.core.BaseObservable[[A] =>> (
            //
            AsyncStateChangeMonad[A]
            & com.raquo.airstream.core.Signal[A]
         ) , A]
         & com.raquo.airstream.core.Signal[A]
         & AsyncStateChangeMonad[A]
      )
      = thisAscm1

   }

   ;
} // AsyncStateChangeMonad$















val _ = {}
