package avcframewrk.forms.javaswing
















;

@main
def runNdfDemo() : Unit = {
   
   // Ndf()

   ???
}

// TODO
// protected 
// class Ndf()
// extends java.io.Closeable
// {

//    val xSwing = {
//       avcframewrk.forms.impl.generic.XAllComponentsList.defaultInstance
//    }

//    val model = {
//       import avcframewrk.util.forms.controls.Kvog
//       new Kvog[Int](initialHeadValue = 5 )
//    }
   
//    export model.stateChgEventItr

//    type XUndoStack
//       >: model.XUndoStack
//       <: model.XUndoStack

//    val undoStackStateItr = {
//       stateChgEventItr
//       .map(e => (e.newValue) : XUndoStack )
//    }

//    val undoAac = xSwing.renderAbstractAction(stateChgEvtItr = stateChgEventItr map(evt => evt.map((e) => (e : XUndoStack ) ) ), renderLabel = (e: XUndoStack) => s"Undo (${e.undoStates.length } more)", callback = { case e if e.presentlyMdlState.undoStates.nonEmpty => model.undo() })
//    val redoAac = xSwing.renderAbstractAction(stateChgEvtItr = stateChgEventItr map(evt => evt.map((e) => (e : XUndoStack ) ) ), renderLabel = (e: XUndoStack) => s"Redo (${e.redoStates.length } more)", callback = { case e if e.presentlyMdlState.redoStates.nonEmpty => model.redo() })

//    val modelValueChgDoc = {
//       import avcframewrk.forms.javaswing.CvcEvent
//       import avcframewrk.forms.javaswing.asAnimatedSwingTextDocument
//       model.valueChgEventItr
//       .map(s => CvcEvent(newValue = s.newValue ) )
//       .asAnimatedSwingTextDocument()
//    }

//    extension (s: XUndoStack ) {

//       def formatXUndoStackState(): String = {

//             (
//                IndexedSeq((true, s.headValue ) )
//                .prependedAll(s.redoStates.reverse map(e => (false, e) ) )
//                .appendedAll(s.undoStates map(e => (false, e) ) )
//             )
//             .map({ case (active, v) => "" + (if active then "->" else "  " ) + s"$v" })
//             .mkString("\r\n")
//       }

//    }

//    val modelUndoStackStructureDoc = {
//       import avcframewrk.forms.javaswing.CvcEvent
//       import avcframewrk.forms.javaswing.asAnimatedSwingTextDocument
//       model.stateChgEventItr
//       .map[avcframewrk.util.forms.controls.KValueChangeEvent.ForValue[XUndoStack] ](e => e.map(s => s ) )
//       .map(e => (
//          e.map(s => {
//             s.formatXUndoStackState()
//          })
//       ))
//       .map(s => CvcEvent(newValue = s.newValue ) )
//       .asAnimatedSwingTextDocument()
//    }

//    val fH = {
      
//       import language.unsafeNulls

//       /* `ImplSpawnNewJFrame(title: String, newContentPane: () => java.awt.Container, newJMenuBar: () => javax.swing.JMenuBar | Null, iconImage: java.awt.Image & java.awt.image.RenderedImage)` */
//       new avcframewrk.forms.impl.javaswing.ImplSpawnNewJFrame(
//          //
//          title = s"Document" ,

//          newContentPane = () => {

//             (identity [(mode: Int ) => java.awt.Container] {

//                case 0 =>
//                   val p = new javax.swing.JPanel(new java.awt.GridLayout )
//                   p add { val p = new javax.swing.JEditorPane() ; p setEditable false ; p setDocument(modelValueChgDoc) ; p }
//                   p
                  
//                case 1 =>
//                   val p = new javax.swing.JPanel(new java.awt.GridLayout )
//                   p add { val p = new javax.swing.JEditorPane() ; p setEditable false ; p setDocument(modelValueChgDoc) ; p }
//                   p add { val p = new javax.swing.JTextArea() ; p setEditable false ; p setDocument(modelUndoStackStructureDoc) ; p }
//                   p

//             })(mode = 1 )
//          } ,
         
//          newJMenuBar = () => {
//             val m = new javax.swing.JMenuBar()
//             m add({
//                val m = new javax.swing.JMenu("File")
//                m add xSwing.renderAbstractAction(label = "Open", callback = { case _ => })
//                m.addSeparator()
//                m add xSwing.renderAbstractAction(label = "Close", callback = { case _ => runCloseButtonAction() })
//                m
//             })
//             m add({
//                val m = new javax.swing.JMenu("Edit")
//                m add undoAac
//                m add redoAac
//                m.addSeparator()
//                m add xSwing.renderAbstractAction(label = "Copy", callback = { case _ => })
//                m
//             })
//             m add({
//                val m = new javax.swing.JMenu("Rev")
//                m add xSwing.renderAbstractAction(label = "Increment", callback = { case _ => model.commitValueShift(v => v + 1 ) })
//                m
//             })
//             m
//          } ,

//       )
//    }

//    protected 
//    def closeAllFrames(): Unit = {

//       fH.close()
//    }

//    def runCloseButtonAction(): Unit = {

//       closeAllFrames()
//    }

//    override
//    def close(): Unit = {
      
//       runCloseButtonAction()
//    }
   
// }

;

































