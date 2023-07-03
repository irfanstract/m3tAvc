package avcframewrk.forms.impl.javaswing












;

val _ = {}

@main
def runPopupDemo() = {

   for (_ <- Range(0, 2) ) {
   
      val ep = {
         avcframewrk.util.forms.controls.DefinesDoPrompt.byLbv[String, String, AnyRef]((title, r) => {

            import java.awt
            import javax.swing

            new ImplSpawnNewJFrame(title = title, newContentPane = () => {

               import language.unsafeNulls

               val p = new swing.JPanel(new awt.FlowLayout )

               p add({
                  val b = {
                     new swing.JButton({
                        new swing.AbstractAction("confirm") {
                           def actionPerformed(e: awt.event.ActionEvent ): Unit = { r tryComplete(util.Success("confirmed") ) } 
                        }
                     })
                  }
                  b
               })
               
               p
            } )
            
         } )
      }

      ep.prompt(title = "prompt", options = new AnyRef )
      .match {
         case r =>
            r.asFuture
            .map(v => println(s"completed: \"$v\" ") )(using concurrent.ExecutionContext.parasitic )
      }
      
   }
}

;
















