package avcframewrk.forms.javaswing
















;

@main
def runNdfDemo() : Unit = {
   
   Ndf()
}

// TODO
protected 
class Ndf()
extends java.io.Closeable
{

   val xSwing = {
      avcframewrk.forms.impl.generic.XAllComponentsList.defaultInstance
   }

   val model = {
      import avcframewrk.util.forms.controls.Kvog
      new Kvog[Int](initialHeadValue = 5 )
   }
   
   export model.stateChgEventItr

   import model.XUndoStack

   val undoStackChgItr = {
      stateChgEventItr
      .map(e => (e.newValue) : model.XUndoStack )
   }

   val undoAac = xSwing.renderAbstractAction(stateChgEvtItr = stateChgEventItr, renderLabel = (e: model.XUndoStack) => s"Undo (${e.undoStates.length } more)", callback = { case e if e.presentlyMdlState.undoStates.nonEmpty => model.undo() })
   val redoAac = xSwing.renderAbstractAction(stateChgEvtItr = stateChgEventItr, renderLabel = (e: model.XUndoStack) => s"Redo (${e.redoStates.length } more)", callback = { case e if e.presentlyMdlState.redoStates.nonEmpty => model.redo() })

   val modelValueChgDoc = {
      import avcframewrk.forms.javaswing.CvcEvent
      import avcframewrk.forms.javaswing.asAnimatedSwingTextDocument
      model.valueChgEventItr
      .map(s => CvcEvent(newValue = s.newValue ) )
      .asAnimatedSwingTextDocument()
   }

   val fH = {
      
      import language.unsafeNulls

      /* `ImplSpawnNewJFrame(title: String, newContentPane: () => java.awt.Container, newJMenuBar: () => javax.swing.JMenuBar | Null, iconImage: java.awt.Image & java.awt.image.RenderedImage)` */
      new avcframewrk.forms.impl.javaswing.ImplSpawnNewJFrame(
         //
         title = s"Document" ,

         newContentPane = () => {
            val p = new javax.swing.JPanel(new java.awt.GridLayout )
            p add { val p = new javax.swing.JEditorPane() ; p setEditable false ; p setDocument(modelValueChgDoc) ; p }
            p
         } ,
         
         newJMenuBar = () => {
            val m = new javax.swing.JMenuBar()
            m add({
               val m = new javax.swing.JMenu("File")
               m add xSwing.renderAbstractAction(label = "Open", callback = { case _ => })
               m.addSeparator()
               m add xSwing.renderAbstractAction(label = "Close", callback = { case _ => runCloseButtonAction() })
               m
            })
            m add({
               val m = new javax.swing.JMenu("Edit")
               m add undoAac
               m add redoAac
               m.addSeparator()
               m add xSwing.renderAbstractAction(label = "Copy", callback = { case _ => })
               m
            })
            m add({
               val m = new javax.swing.JMenu("Rev")
               m add xSwing.renderAbstractAction(label = "Increment", callback = { case _ => model.commitValueShift(v => v + 1 ) })
               m
            })
            m
         } ,

      )
   }

   protected 
   def closeAllFrames(): Unit = {

      fH.close()
   }

   def runCloseButtonAction(): Unit = {

      closeAllFrames()
   }

   override
   def close(): Unit = {
      
      runCloseButtonAction()
   }
   
}

;

































