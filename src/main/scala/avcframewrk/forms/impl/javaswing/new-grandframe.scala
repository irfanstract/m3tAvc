package avcframewrk.forms.impl.javaswing












protected 
// abstract 
open class ImplSpawnNewJFrame(
   //

   title: String,
   newContentPane: () => java.awt.Container ,
   
   iconImage : java.awt.Image & java.awt.image.RenderedImage ,

)
extends
AnyRef
with java.io.Closeable
with avcframewrk.util.AwaitableWithoutArg[Unit]
{
   
   import java.awt
   import javax.swing

   protected 
   given concurrent.ExecutionContext = {
      concurrent.ExecutionContext.global
   }

   import language.unsafeNulls

   final
   val f = new swing.JFrame
   
   f setDefaultCloseOperation swing.WindowConstants.DO_NOTHING_ON_CLOSE
   f addWindowListener {
      new awt.event.WindowAdapter {
         import awt.event.WindowEvent
         override def windowClosing(e: WindowEvent | Null): Unit = {
            runCloseButtonAction()
         }
      }
   }

   export windowClosedownReturnQuestion.{asFuture => whenClosed }

   private
   val windowClosedownReturnQuestion = {
      avcframewrk.util.LateBoundValue.newInstance[Unit]
   }
   f addWindowListener {
      new awt.event.WindowAdapter {
         import awt.event.WindowEvent
         override def windowClosed(e: WindowEvent | Null): Unit = {
            windowClosedownReturnQuestion.tryComplete(util.Success {} )
         }
      }
   }

   f setTitle title

   f setContentPane { newContentPane() }

   f setIconImage {
      iconImage
   }
   
   awt.EventQueue.invokeLater(() => { f.setSize(800, 400 ) ; f.setVisible(true) } )

   /**
    * 
    * unconditionally
    * make all the opened windows disappear
    * 
    */
   protected
   def disposeAllWindows() : Unit = {
      awt.EventQueue.invokeLater(() => { f.dispose() } )
   }

   /**
    * 
    * synchronously await until the window gets actually closed
    * 
    */
   def join() : Unit = {
      windowClosedownReturnQuestion
      .value
   }

   /**
    * 
    * run
    * what's supposed to run whenever the "close" button gets clicked
    * 
    */
   def runCloseButtonAction() : Unit = {
      disposeAllWindows()
   }

   /**
    * 
    * `close()`.
    * 
    */
   override
   def close(): Unit = closed1

   /* ensure not running more than once */
   private 
   lazy val closed1: Unit = runCloseButtonAction()
   
}

