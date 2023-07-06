package avcframewrk.forms.impl.javaswing












// protected 
// abstract 
open class ImplSpawnNewJFrame(
   //

   title: => String,

   newJMenuBar   : () => (javax.swing.JMenuBar | Null) = () => { null } ,

   newContentPane: () => java.awt.Container ,
   
   iconImage : java.awt.Image & java.awt.image.RenderedImage = {

      avcframewrk.forms.impl.javaswing.defaultAppIconImg
   } ,

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

   /**
    * 
    * nothing in the AWT/Swing spec
    * strongly specify the handing of `throw`n exceptions ;
    * to avoid unexpected effects on Swing,
    * it's worth slapping-in a step of asynchronicity ;
    * 
    * BTW above has `given` `concurrent.ExecutionContext`
    * 
    */
   protected 
   def asAsyncClientSideUnitBlock[U](r: => U ): Unit = {

      concurrent.Future.unit
      .foreach(_ => r )
   }

   final
   val f = new swing.JFrame
   
   f setDefaultCloseOperation swing.WindowConstants.DO_NOTHING_ON_CLOSE
   f addWindowListener {
      new awt.event.WindowAdapter {
         import awt.event.WindowEvent
         override def windowClosing(e: WindowEvent | Null): Unit = {
            asAsyncClientSideUnitBlock {
            ;
            runCloseButtonAction()
            }
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
            asAsyncClientSideUnitBlock {
            ;
            windowClosedownReturnQuestion.tryComplete(util.Success {} )
            }
         }
      }
   }

   f setTitle title

   f setContentPane { newContentPane() }

   f setJMenuBar { newJMenuBar() }

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

