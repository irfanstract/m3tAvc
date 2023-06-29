package avcframewrk.forms.test






class UndoRedoStackTest extends
org.scalatest.funsuite.AnyFunSuite
{

   val supposedlySingleItemTree = {
      import avcframewrk.util.forms.controls.KUndoRedoStateTree
      KUndoRedoStateTree.initially(5)
   }

   test("supposedlySingleItemTree") {
      assert(supposedlySingleItemTree.redoStates.isEmpty)
      assert(supposedlySingleItemTree.undoStates.isEmpty)
   }

   test("by default undo never throws") {
      supposedlySingleItemTree
      .afterUndo()
   }

   test("after edit, and then undo, the redo-stack becomes non-empty") {
      val c = {
         supposedlySingleItemTree
         .afterEdit(newHeadState = 3 )
         .afterUndo()
      }
      assert(c.redoStates.nonEmpty )
   }

}






