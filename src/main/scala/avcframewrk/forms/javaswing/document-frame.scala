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

   val modelValueChgDoc = {
      import avcframewrk.forms.javaswing.CvcEvent
      import avcframewrk.forms.javaswing.asAnimatedSwingTextDocument
      model.valueChgEventItr
      .map(s => CvcEvent(newValue = s.newValue ) )
      .asAnimatedSwingTextDocument()
   }

   val fH = {
      xSwing.open({
         xSwing.getCustomComponent1({
            import language.unsafeNulls
            val p = new javax.swing.JRootPane()
            p setJMenuBar({
               val m = new javax.swing.JMenuBar()
               m add({
                  val m = new javax.swing.JMenu("Edit")
                  m add xSwing.renderAbstractAction(label = "Undo", callback = { case _ => model.undo() })
                  m add xSwing.renderAbstractAction(label = "Redo", callback = { case _ => model.redo() })
                  m.addSeparator()
                  m add xSwing.renderAbstractAction(label = "Increment", callback = { case _ => model.commitValueShift(v => v + 1 ) })
                  m
               })
               m
            })
            p setContentPane {
               val p = new javax.swing.JPanel(new java.awt.GridLayout )
               p add { val p = new javax.swing.JEditorPane() ; p setEditable false ; p setDocument(modelValueChgDoc) ; p }
               p
            }
            p
         })
      })
   }

   override
   def close(): Unit = {
      fH.close()
   }
   
}

;

































