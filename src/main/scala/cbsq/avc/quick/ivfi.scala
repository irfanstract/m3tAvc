package cbsq.avc.quick









import java.util.{concurrent => jc }
import jc.atomic
import java.awt
import javax.swing








// export openInteractiveFrameIterativeUiImpl.{apply as openInteractiveFrameIterativeUi }

class openInteractiveFrameIterativeUiImpl(
   src : cbsq.avc.BbsdAvInterleavedFrameIterator ,
)
extends AnyRef with java.io.Closeable
{

   def invokeSrcNext() : Unit = {
      src.switchToNextFrame()
   }

   impl
   private  
   object impl {

      import language.unsafeNulls

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
      f setTitle "decoded frames"
      f setIconImage {
         import awt.image.*
         new BufferedImage(16, 16, BufferedImage.TYPE_INT_RGB )
      }

      val label1 = {

         (identity[swing.AbstractAction](e => {
            // no-op
         })) : swing.Action

      }

      f setContentPane {
         val p = new swing.JPanel(new awt.GridLayout )
         p add {
            val p = new swing.JPanel(new awt.FlowLayout )
            p add {
               val b = new swing.JButton(label1)
               b.setEnabled(false)
               b
            }
            p add {
               val b = new swing.JButton(label1)
               b
            }
            p add {
               new swing.JButton({
                  (new swing.AbstractAction("next") {
                     override
                     def actionPerformed(e: awt.event.ActionEvent) = {
                        invokeSrcNext()
                        refresh()
                     }

                  }) : swing.Action
               })
            }
            p
         }
         p
      }

      awt.EventQueue.invokeLater(() => { f.setSize(800, 400 ) ; f.setVisible(true) } )

      clearInfo()

      def clearInfo() : Unit = {
         label1.putValue(swing.Action.NAME, "(no frame info)")
      }
      
      // reinitWithCurrentlyInfo
      def refresh() : Unit = {
         clearInfo()
         println(s"$src ")
         label1.putValue(swing.Action.NAME, s"frame T : ${src.currentFrameTRange } ")
      }
      
      def disposeAllWindows() : Unit = {
         f.dispose()
      }
      
      val wncQ = {
         cbsq.avc.LateBoundValue.newInstance[Unit]
      }
      f addWindowListener {
         new awt.event.WindowAdapter {
            import awt.event.WindowEvent
            override def windowClosed(e: WindowEvent | Null): Unit = {
               wncQ.tryComplete(util.Success {} )
            }
         }
      }

   }

   def runCloseButtonAction() : Unit = {
      impl.disposeAllWindows()
   }

   override
   final
   def close(): Unit = {
      runCloseButtonAction()
   }

   /**
    * 
    * synchronously blocks until the window gets closed
    * 
    */
   def join(): Unit = {
      impl.wncQ.getValue()
   }

}

// def oivfiUi = {

//    new swing.plaf.PanelUI {

//       import swing.*

//       import language.unsafeNulls

//       override
//       def uninstallUI(c: JComponent ): Unit = {
//          c
//          .removeAll()
//       }

//       override
//       def installUI(c: JComponent ): Unit = {
//          ???
//       }

//       //

//    }
// }

































