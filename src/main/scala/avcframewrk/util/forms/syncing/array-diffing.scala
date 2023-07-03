package avcframewrk.util.forms.syncing

















;

object ArrayDiffing
{

   //

}

object ContinuousArrayDiffing {

   import language.unsafeNulls

   export ContinuousGenericDiffing.{startPeriodicSnapshotItr => startGenericPeriodicSnapshotItr }
   
   extension [E](src: collection.Iterable[E] ) {
      
      def startPeriodicSnapshotItr(dispatcher: concurrent.ExecutionContext ) = {

         { () => (src match { case src : (collection.Set[?] | collection.Map[?, ?]) => Set.from[E](src) ; case src => IndexedSeq from src }) }
         .startGenericPeriodicSnapshotItr(dispatcher = dispatcher )
      }

   }
    
}

;




















