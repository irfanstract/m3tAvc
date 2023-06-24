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
   xSwing : (
      // ([R] =>> avcframewrk.forms.impl.javaswing.XAllComponentsList[R] )[?]
      // avcframewrk.forms.impl.javaswing.allInterfacesGivens.main.type
      // avcframewrk.forms.impl.javaswing.allInterfacesGivens.main.type
      avcframewrk.forms.impl.javaswing.XAllComponentsList.defaultInstance.type
   ) ,
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

   // ((mnext: ([R] =>> avcframewrk.forms.impl.javaswing.XAllComponentsList[R] )[?]) => {
   //    // mnext.apply(???)
   //    mnext.open(??? )
   //    5
   //    val mne = (identity[avcframewrk.util.forms.DefinesDoOpenGiven[?, ?]](mnext ) )
   //    val mnDoOpen = (mne.open _ )
   //    // compiletime.codeOf((mne.open _ ) ) : "what"
   // })
   
   // ((mne: ([R] =>> ((R => Unit) ) )[?]) => {
   //    // mnext.apply(???)
   // })
   // // ([C[R] <: ((R => Unit) & (java.util.function.Supplier[R]) ) ] => (mne: C[?]) => {
   // //    //
   // // })
   // // ((mne: ([R] =>> ((R => Unit) & ((R, Boolean) => Unit ) ) )[?]) => {
   // //    // mnext.apply(???)
   // // })
   // ({
   //    import avcframewrk.forms.impl.javaswing.allInterfacesGivens

   //    import allInterfacesGivens.main

   //    summon[(
   //       ([R] =>> (
   //          AnyRef
   //          with avcframewrk.util.forms.pure.DefinesDoRenderButtonA1[javax.swing.Action, R ]
   //          // with XWithNjp[R ]
   //          // with ReExportsDoRenderAbstractAction
   //          // with XDefinesAllocNewCheckBoxState
   //          // with DefinesGetNewPlainOrStyledTextDoc[Any]
   //          with avcframewrk.util.forms.DefinesDoOpenGiven[R, java.io.Closeable]
   //       ))
   //       [?]

   //    )]

   //    // compiletime.codeOf({
   //    //    ;
   //    //    summon[(
   //    //       ([R] =>> (
   //    //          AnyRef
   //    //          with avcframewrk.util.forms.pure.DefinesDoRenderButtonA1[javax.swing.Action, R ]
   //    //          // with XWithNjp[R ]
   //    //          // with ReExportsDoRenderAbstractAction
   //    //          // with XDefinesAllocNewCheckBoxState
   //    //          // with DefinesGetNewPlainOrStyledTextDoc[Any]
   //    //          with avcframewrk.util.forms.DefinesDoOpenGiven[R, java.io.Closeable]
   //    //       ))
   //    //       [?]

   //    //    )]
   //    // }) : ""

   //    // type Emain = (
         
   //    //    ([R] =>> (
   //    //       AnyRef
   //    //       with avcframewrk.util.forms.pure.DefinesDoRenderButtonA1[javax.swing.Action, R ]
   //    //       // with XWithNjp[R ]
   //    //       with avcframewrk.util.forms.DefinesDoOpenGiven[R, java.io.Closeable]
   //    //    ))
   //    //    [?]
   //    // )

   //    compiletime.codeOf((e: (
   //       ([ER] =>> (
   //          AnyRef
   //          with avcframewrk.util.forms.pure.DefinesDoRenderButtonA1[javax.swing.Action, ER ]
   //          // with XWithNjp[ER ]
   //          with avcframewrk.util.forms.DefinesDoOpenGiven[ER, java.io.Closeable]
   //       ))
   //       [?]

   //    )) => {
   //       val mnDoOpen = (e.open _ )
   //       def mnNew = e.renderButton(???)
   //       val e1 = e
   //       5
   //       //
   //       ()
   //    }) : ""
      
   // })
   // ({
   //    ;
   //    type Imnet = [R] =>> ((R => Unit) & (java.util.function.Supplier[R]) )
   //    ((mne: Imnet[? >: Nothing <: Any]) => {
   //       // mnext.apply(???)
   //       val mnDoOpen = (mne.apply _ )
   //       def mnNew = mne.get()
   //       // compiletime.codeOf((mne.open _ ) ) : "what"
   //    })
   // })

   // ({
   //    ;
      
   //    import avcframewrk.forms.impl.javaswing.allInterfacesGivens

   //    import allInterfacesGivens.main

   //    type Erb = (
   //       ([R] =>> (
   //          AnyRef
   //          with avcframewrk.util.forms.pure.DefinesDoRenderButtonA1[javax.swing.Action, R ]
   //          // with XWithNjp[R ]
   //          // with ReExportsDoRenderAbstractAction
   //          // with XDefinesAllocNewCheckBoxState
   //          // with DefinesGetNewPlainOrStyledTextDoc[Any]
   //          with avcframewrk.util.forms.DefinesDoOpenGiven[R, java.io.Closeable]
   //       ))
   //       [({ type E })#E]

   //    )

   //    // compiletime.codeOf((e: Erb) => { val e1 = e.open _ } ) : ""

   //    // summon[(Erb)]

   // })

   // ((ec: ([R] =>> avcframewrk.forms.impl.javaswing.XAllComponentsList[R] )[?] ) => {
   //    // compiletime.codeOf(ec.open(_) ) : ""
   //    ec.open(ec.newAggregatingPanel() )
   // })

   {}

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

      val fSet = {
      xSwing.open(title = "decoded frames", body = {
         val p = xSwing.newAggregatingPanel()
         p add {
            val p = xSwing.newParagraphicPanel()
            p add {
               xSwing renderTextDocDisplay(tStampInfoDoc)
            }
            p add {
               xSwing renderTextDocDisplay(eofEdNessLabel)
            }
            p add {
               xSwing renderButton {
                  xSwing renderAbstractAction(label = "next", callback = e => {
                     invokeSrcNext()
                     refresh()
                  } )
               }
            }
            p
         }
         p
      })
      }
      export fSet.f

      //
      
      //
      
      def disposeAllWindows() : Unit = {
         f.dispose()
      }
      
      export fSet.{join as join1 }

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
      uiImpl.join1()
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

































