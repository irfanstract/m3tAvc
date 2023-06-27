package avcframewrk.forms.javaswing
















;

val _ = {}

/* `=====@===!` */
@main
def runBavslDemo() : Unit = {

   val xSwing = summon[avcframewrk.forms.impl.generic.XAllComponentsList.defaultInstance.type]

   val c = {
      import javax.swing
      import language.unsafeNulls
      val model = new swing.DefaultBoundedRangeModel(0, 25, -1000, 1000)
      val modelValueChgEvtItr = {
         (model)
         .asAvslValueChangeEventItr()
      }
      val p = xSwing.newAggregatingPanel()
      p add {
         ;
         val p = xSwing.newParagraphicPanel()
         p add { xSwing getCustomComponent1 { new swing.JSlider(model) } }
         p add { xSwing getCustomComponent1 { new swing.JSlider(model) } }
         p
      }
      p add {
         ;
         val p = xSwing.newAggregatingPanel()
         p add { xSwing renderTextDocDisplay { (modelValueChgEvtItr ).asAnimatedSwingTextDocument() } }
         p add { xSwing getCustomComponent1 { new swing.JSlider(model) } }
         p
      }
      p
   }

   xSwing.`open`({
      c
   })
}

;






















