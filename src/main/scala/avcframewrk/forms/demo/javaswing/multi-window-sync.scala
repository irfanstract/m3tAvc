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
   val xSwing : avcframewrk.forms.impl.generic.XAllComponentsList.OfWldcd ,

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

   {
      
      val model = new javax.swing.DefaultBoundedRangeModel(0, 100, -2000, 2000 )

      cd add { xSwing getCustomComponent1 { new javax.swing.JSlider(model ) } }
      
      cd add { xSwing getCustomComponent1 { new javax.swing.JSlider(model ) } }

   }

   def spawnOutlet(displayTitle : String ): (
      AnyRef
      with java.io.Closeable
      with avcframewrk.util.AwaitableWithoutArg[Unit]
      //
   ) = {
      ;
      
      xSwing.open(title = displayTitle, body = {
         
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

            btnsPanel add { fic }

            btnsPanel

         } , awt.BorderLayout.PAGE_END )
         
         c
      } )
   }
   
   for (i <- Range(0, 2) ) {
      
      spawnOutlet(displayTitle = s"frame $i ;" )

   }

   private 
   lazy val fic = {
      xSwing renderFiniteItemChooser({ new javax.swing.DefaultComboBoxModel[Int]() { addElement(1) ; addElement(2) ; addElement(3) } } , formatItemForDisplay = (value: Any) => xSwing.getCustomComponent1(new javax.swing.JLabel(s"${value}") ) )
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


















