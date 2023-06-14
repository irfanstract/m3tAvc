package cbsq.avc.quick









import java.util.{concurrent => jc }
import jc.atomic
import java.awt
import javax.swing

import avcframewrk.forms.javaswing.swingTextDocUtils
import swingTextDocUtils.setText1








// export openInteractiveFrameIterativeUiImpl.{apply as openInteractiveFrameIterativeUi }

class openInteractiveFrameIterativeUiImpl(
   src : cbsq.avc.BbsdAvInterleavedFrameIterator ,
)
(using 
   logger : cbsq.avc.PhrStagedLogging.ByDName["cbsq.avc.quick.openInteractiveFrameIterativeUiImpl$.main"] ,
   xSwing : avcframewrk.forms.impl.javaswing.allInterfacesGivens.main.type ,
)
extends AnyRef with java.io.Closeable
{

   import generalImpl.itrHelper
   
   import generalImpl.refresh

   def invokeSrcNext() : Unit = {
      import language.unsafeNulls
      
      itrHelper.invokeSrcNext()
      refresh()

   }

   generalImpl
   private  
   object generalImpl {

      val itrHelper: Eitrn = {

         Eitrn(src = src )
      }

      export itrHelper.eofEdNessState

      clearInfo()

      protected 
      def clearInfo() : Unit = {

         tStampInfoDoc setText1 "(no frame info)"
         
      }
      
      // reinitWithCurrentlyInfo
      def refresh() : Unit = {

         clearInfo()

         logger enstage(s"$src ")

         locally {
            tStampInfoDoc setText1 { s"frame T : ${src.currentFrameTRange } " }
         }
         
      }
      
      export itrHelper.eofEdNessLabel

      val tStampInfoDoc = {

         xSwing.newPlainTextDocument()
         
      }

   }

   import generalImpl.*

   uiImpl
   private  
   object uiImpl {

      import language.unsafeNulls
      
      import generalImpl.eofEdNessState

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

      f setContentPane {
         val p = new swing.JPanel(new awt.GridLayout )
         p add {
            val p = new swing.JPanel(new awt.FlowLayout )
            p add {
               val b = new swing.JTextArea(tStampInfoDoc)
               b.setEditable(false)
               b
            }
            p add {
               val b = new swing.JTextArea(eofEdNessLabel)
               b.setEditable(false)
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

      //
      
      //
      
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
      uiImpl.disposeAllWindows()
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
      uiImpl.wncQ.getValue()
   }

}

private
class Eitrn(
   // 
   src : cbsq.avc.BbsdAvInterleavedFrameIterator ,
)
(using 
   logger : cbsq.avc.PhrStagedLogging.ByDName["cbsq.avc.quick.openInteractiveFrameIterativeUiImpl$.Eitrn"] ,
   xSwing : avcframewrk.forms.impl.javaswing.allInterfacesGivens.main.type ,
)
{
      ;
      
      def invokeSrcNext() : Unit = {

         import language.unsafeNulls
         
         val e = src.switchToNextFrame()
         eofEdNessState.setSelected(e.isLeft )

         refresh()

      }

      protected 
      def clearInfo() : Unit = {

      }
      
      // reinitWithCurrentlyInfo
      def refresh() : Unit = {

         clearInfo()

         logger enstage(s"$src ")
         
      }
      
      val eofEdNessState = {

         xSwing newCheckBoxState(initiallySelected = false )

      }

      val eofEdNessLabel = {

         val e = xSwing.newPlainTextDocument()
         eofEdNessState addChangeListener (_ => {
            e setText1 { if eofEdNessState.isSelected() then "end of file" else "" }
         })
         e

      }

} /* Eitrn */

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

































