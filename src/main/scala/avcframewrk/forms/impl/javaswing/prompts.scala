package avcframewrk.forms.impl.javaswing












;

val _ = {}

object BasicDefinesDoPrompt {

   def apply[Value](renderMainContentPane: (tryComplete : util.Try[Value] => Unit ) => java.awt.Container ) = {

      avcframewrk.util.forms.controls.DefinesDoPrompt.byLbvS[Value, String, AnyRef]((title, r) => {

         import java.awt
         import javax.swing

         import r.{tryComplete }

         val main = {
            ;
            new ImplSpawnNewJFrame(title = title, newContentPane = () => {

               renderMainContentPane(tryComplete _ )
            } )
         }

         main.whenClosed
         .foreach(_ => r.tryComplete(util.Failure(new java.io.IOException(s"rejected (topic: '$title')") ) ) )(using concurrent.ExecutionContext.parasitic )

         r.onClose
         .foreach(returnVal => { main.close() } : Unit )(using concurrent.ExecutionContext.parasitic )

         main
      } )
   }

}

@main
def runPopupDemo() = {

   val ep = {
      
      BasicDefinesDoPrompt[String](tryComplete => {

         import java.awt
         import javax.swing

         {

               import language.unsafeNulls

               val p = new swing.JPanel(new awt.FlowLayout )

               p add({
                  new swing.JButton({
                     renderAbstractAction(label = "confirm", callback = { case _ => tryComplete(util.Success("confirmed") ) } )
                  })
               })
               
               p
         }
      })
   }

   import ep.{prompt => promptAsync }

   for (i <- Range(0, 3) ) {
   
      promptAsync(title = s"dialogue ${"#" + i } prompt", options = new AnyRef )
      .match {
         case r =>
            // r.asFuture
            concurrent.Future.successful[r.type](r)
            .map(v => println(s"prompt ${"#" + i } completed: \"$v\" ") )(using concurrent.ExecutionContext.parasitic )
      }
      
   }
}

;
















