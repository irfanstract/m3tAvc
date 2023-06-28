package avcframewrk.util.forms.controls















;

case class KUndoRedoStateTree[+Value](
   //
   headValue: Value ,
   redoStates : KUndoRedoStateTree.XHeadTailSeq[Value] ,
   undoStates : KUndoRedoStateTree.XHeadTailSeq[Value] ,

)
{

   import KUndoRedoStateTree.{apply => xNewInstance }

   def flipped = {
      copy(redoStates = undoStates, undoStates = redoStates )
   }

}

object KUndoRedoStateTree
{

   type XHeadTailSeq[+Value]
      >: List[Value]
      <: List[Value]

   import apply as xNewInstance

   protected 
   object xni {
      export KUndoRedoStateTree.apply
   }

   extension [Value] (existingState : KUndoRedoStateTree[Value] ) {

      /**
       * 
       * after undo
       * 
       */
      def afterUndo()(using CtxtualPopOutFailureCallback[existingState.type] ) : KUndoRedoStateTree[Value] = {

         existingState.undoStates match {

            case nextHeadValue +: undoDoneRemainingStates =>
               ;

               xNewInstance(
                  headValue = nextHeadValue,
                  redoStates = existingState.headValue +: existingState.redoStates ,
                  undoStates = undoDoneRemainingStates ,
               )
            
            case _ =>
               (summon[CtxtualPopOutFailureCallback[existingState.type ] ] )
               .apply(existingState )
               
         }
      }

   }
   
   extension [Value] (existingState : KUndoRedoStateTree[Value] ) {

      /**
       * 
       * after redo
       * 
       */
      def afterRedo()(using CtxtualPopOutFailureCallback[existingState.type] ) = {
         
         existingState
         .flipped
         .afterUndo()
         .flipped
      }

   }
   
   extension [Value] (existingState : KUndoRedoStateTree[Value] ) {

      def afterEdit[NewValue >: Value ](newHeadState: NewValue ) = {
         
         existingState
         .copy[Value | newHeadState.type ](redoStates = List[newHeadState.type](newHeadState ) )
         .afterRedo()
      }

   }

   /**
    * 
    * initially,
    * one'd be left with one whose `undoStates` and `redoStates` both each is *empty*
    * 
    */
   def initially[K](initialHeadValue: K ) : KUndoRedoStateTree[initialHeadValue.type ] = {

      KUndoRedoStateTree[initialHeadValue.type](
         headValue = initialHeadValue ,
         redoStates = Nil ,
         undoStates = Nil ,
      )
   }
   
   given [K <: KUndoRedoStateTree[?] ] : CtxtualPopOutFailureCallback[K] = {

      identity[K] _
   }

   opaque type CtxtualPopOutFailureCallback[K <: KUndoRedoStateTree[?] ]
      <: ([A] =>> ((c: A ) => A ) )[K]
      =  ([A] =>> ((c: A ) => A ) )[K]
   
}

;















