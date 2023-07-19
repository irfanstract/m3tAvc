package cbsq.avc.quick









import java.util.{concurrent => jc }
import jc.atomic
import java.awt
import javax.swing

import avcframewrk.forms.javaswing.swingTextDocUtils
import swingTextDocUtils.setText1








// export openInteractiveFrameIterativeUiImpl.{apply as openInteractiveFrameIterativeUi }

// class openInteractiveFrameIterativeUiImpl(
//    src : cbsq.avc.BbsdAvInterleavedFrameIterator ,
// )
// (using 
//    logger : cbsq.avc.PhrStagedLogging.ByDName["cbsq.avc.quick.openInteractiveFrameIterativeUiImpl$.main"] ,
//    xSwing : avcframewrk.forms.impl.generic.XAllComponentsList.OfWldcd ,
// )
// extends AnyRef with java.io.Closeable
// {

//    import generalImpl.itrHelper
   
//    import generalImpl.refresh

//    def invokeSrcNext() : Unit = {
//       import language.unsafeNulls
      
//       itrHelper.invokeSrcNext()
//       refresh()

//    }

//    generalImpl
//    private  
//    object generalImpl {

//       val itrHelper: Eitrn = {

//          Eitrn(src = src )
//       }

//       export itrHelper.eofEdNessState

//       clearInfo()

//       protected 
//       def clearInfo() : Unit = {

//          tStampInfoDoc setText1 "(no frame info)"
         
//       }
      
//       // reinitWithCurrentlyInfo
//       def refresh() : Unit = {

//          clearInfo()

//          logger enstage(s"$src ")

//          locally {
//             tStampInfoDoc setText1 { s"frame T : ${src.currentFrameTRange } " }
//          }
         
//       }
      
//       export itrHelper.eofEdNessLabel

//       val tStampInfoDoc = {

//          // xSwing.newPlainTextDocument()
         
//       }

//    }

//    import generalImpl.*

//    uiImpl
//    private  
//    object uiImpl {

//       import language.unsafeNulls
      
//       import generalImpl.eofEdNessState

//       // val fSet = {
//       // xSwing.open(title = "decoded frames", body = {
//       //    val p = xSwing.newAggregatingPanel()
//       //    p add {
//       //       val p = xSwing.newParagraphicPanel()
//       //       p add {
//       //          xSwing renderTextDocDisplay(tStampInfoDoc)
//       //       }
//       //       p add {
//       //          xSwing renderTextDocDisplay(eofEdNessLabel)
//       //       }
//       //       p add {
//       //          xSwing renderButton {
//       //             xSwing renderAbstractAction(label = "next", callback = e => {
//       //                invokeSrcNext()
//       //                refresh()
//       //             } )
//       //          }
//       //       }
//       //       p
//       //    }
//       //    p
//       // })
//       // }
//       // export fSet.f

//       //
      
//       //
      
//       def disposeAllWindows() : Unit = {
//          // f.dispose()
//       }
      
//       // export fSet.{join as join1 }

//    }

//    def runCloseButtonAction() : Unit = {
//       uiImpl.disposeAllWindows()
//    }

//    override
//    final
//    def close(): Unit = {
//       runCloseButtonAction()
//    }

//    // /**
//    //  * 
//    //  * synchronously blocks until the window gets closed
//    //  * 
//    //  */
//    // def join(): Unit = {
//    //    uiImpl.join1()
//    // }

// }

// private
// class Eitrn(
//    // 
//    src : cbsq.avc.BbsdAvInterleavedFrameIterator ,
// )
// (using 
//    logger : cbsq.avc.PhrStagedLogging.ByDName["cbsq.avc.quick.openInteractiveFrameIterativeUiImpl$.Eitrn"] ,
//    xSwing : avcframewrk.forms.impl.generic.XAllComponentsList.OfWldcd ,
// )
// {
//       ;
      
//       def invokeSrcNext() : Unit = {

//          import language.unsafeNulls
         
//          val e = src.switchToNextFrame()
//          eofEdNessState.setSelected(e.isLeft )

//          refresh()

//       }

//       protected 
//       def clearInfo() : Unit = {

//       }
      
//       // reinitWithCurrentlyInfo
//       def refresh() : Unit = {

//          clearInfo()

//          logger enstage(s"$src ")
         
//       }
      
//       val eofEdNessState = {

//          xSwing newCheckBoxState(initiallySelected = false )

//       }

//       val eofEdNessLabel = {

//          val e = xSwing.newPlainTextDocument()
//          eofEdNessState addChangeListener (_ => {
//             e setText1 { if eofEdNessState.isSelected() then "end of file" else "" }
//          })
//          e

//       }

// } /* Eitrn */

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

val _ = {}

































