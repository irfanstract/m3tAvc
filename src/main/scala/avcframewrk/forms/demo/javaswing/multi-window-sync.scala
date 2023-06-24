package avcframewrk.forms.demo.javaswing














@main
def runMultiWindowSyncDemo() : Unit = {

   runMultiWindowSyncDemoImpl()
}

class runMultiWindowSyncDemoImpl(
   //

)
(using 
   // givens

   private
   val xSwing : avcframewrk.forms.impl.javaswing.allInterfacesGivens.main.type ,

)
extends
AnyRef
{

   import cbsq.avc.newXResourcesManager
   
   import java.awt
   import javax.swing

   import concurrent.ExecutionContext.Implicits.global

   //

   import avcframewrk.forms.javaswing.actionObjUtil.setIcon

   import language.unsafeNulls

   //

   private[runMultiWindowSyncDemoImpl]
   val cd = xSwing.newParagraphicPanel()

   def spawnOutlet(displayTitle : String ): xSwing.spawnNewJFrame = {
      ;
      
      xSwing.spawnNewJFrame(title = displayTitle, contentPane = {
         
         val c = xSwing.newFourAsidesContentPanel()

         c add cd

         val uNextBtnAction = {

               xSwing renderAbstractAction(label = "next", callback = e => (
                  //

                  runUNextBtnAction()
                  
               ) )
         }

         val spawnNewOutletBtnAction = {

               xSwing renderAbstractAction(label = s"spawn new outlet", callback = e => (
                  //

                  spawnOutlet(displayTitle = s"extra window")
                  
               ) )
         }

         c addOne({

            val btnsPanel = xSwing.newParagraphicPanel()

            btnsPanel add { xSwing renderButton(uNextBtnAction ) }

            btnsPanel add { xSwing renderButton(spawnNewOutletBtnAction ) }

            btnsPanel

         } , awt.BorderLayout.PAGE_END )
         
         c
      } )
   }
   
   for (i <- Range(0, 2) ) {
      
      spawnOutlet(displayTitle = s"frame $i ;" )

   }

   def runUNextBtnAction(): Unit = {

      val dateStr = {
         java.time.LocalDateTime.now()
         .toString()
      }

      cd add {
         xSwing renderButton {
            xSwing renderAbstractAction(label = s"(date: $dateStr)", callback = { case _ => } )
         }
      }
      
   }

}


















