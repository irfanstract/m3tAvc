package avcframewrk.util.forms.controls















;

case class KSimpleUndoRedoStack[+Value](
   //
   headValue: Value ,
   redoStates : KEitherUndoOrRedoStateStack[Value] ,
   undoStates : KEitherUndoOrRedoStateStack[Value] ,

)
{

   export KSimpleUndoRedoStack.{apply => xNewInstance }

   def flipped = {
      copy(redoStates = undoStates, undoStates = redoStates )
   }

}

object KSimpleUndoRedoStack
{

   export xni.{apply => xNewInstance }

   protected 
   object xni {
      export KSimpleUndoRedoStack.apply
   }

   extension [Value] (existingState : KSimpleUndoRedoStack[Value] ) {

      /**
       * 
       * after undo
       * 
       */
      def afterUndo()(using CtxtualPopOutFailureCallback[existingState.type] ) : KSimpleUndoRedoStack[Value] = {

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
   
   extension [Value] (existingState : KSimpleUndoRedoStack[Value] ) {

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
   
   extension [Value] (existingState : KSimpleUndoRedoStack[Value] ) {

      def afterEdit(newHeadState: Value) = {
         
         existingState
         .copy(redoStates = newHeadState +: Nil )
         .afterRedo()
      }

   }

   def initially[K](initialHeadValue: K ) : KSimpleUndoRedoStack[initialHeadValue.type ] = {

      KSimpleUndoRedoStack[initialHeadValue.type](
         headValue = initialHeadValue ,
         redoStates = Nil ,
         undoStates = Nil ,
      )
   }
   
   given [K <: KSimpleUndoRedoStack[?] ] : CtxtualPopOutFailureCallback[K] = {

      identity[K] _
   }

   opaque type CtxtualPopOutFailureCallback[K <: KSimpleUndoRedoStack[?] ]
      <: ([A] =>> ((c: A ) => A ) )[K]
      =  ([A] =>> ((c: A ) => A ) )[K]
   
}

type KEitherUndoOrRedoStateStack[+Value]
   >: List[Value]
   <: List[Value]

;















