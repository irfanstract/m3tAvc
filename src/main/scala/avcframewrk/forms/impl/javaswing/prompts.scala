package avcframewrk.forms.impl.javaswing












;

val _ = {}

object BasicDefinesDoPrompt {

   {
      import avcframewrk.util.forms.controls.DefinesDoPrompt.ByTitleAndOptionsCallback.*
      // summon[GivenRepackerByValue[[Value] =>> (ValueOf[Unit] ?=> Value ) ] ]
      // summon[GivenRepackerByValue[[Value] =>> (ValueOf[Unit] ?=> Value ) ] ] : GivenRepackerByValue[?]
      // givenImmediateRepacker : GivenRepackerByValue[?]
   }

   def apply[Value](renderMainContentPane: (tryComplete : util.Try[Value] => Unit ) => java.awt.Container ) = {

      avcframewrk.util.forms.controls.DefinesDoPrompt.ByTitleAndOptionsCallback[Value, String, AnyRef]((title, r) => {

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

def getSingleConfirmButtonEp() = {

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

@main
def runPopupDemo(): Unit = {

   val ep = {
      
      getSingleConfirmButtonEp()
   }

   import ep.{prompt => promptAsync }

   util.Try({
      
      for (i <- Range(0, 3) ) {
      
         promptAsync(title = s"dialogue ${"#" + i } prompt", options = new AnyRef )
         .match {
            case r =>
               // r.asFuture
               concurrent.Future.successful[r.type](r)
               .map(v => println(s"prompt ${"#" + i } completed: \"$v\" ") )(using concurrent.ExecutionContext.parasitic )
         }
         
      }

   })
   .recover(_.printStackTrace() )
}

@main
def runMultipleChoiceProbDemo(): Unit = {

   val ep = {
      
      getSingleConfirmButtonEp()
   }

   import avcframewrk.util.forms.controls.MultipleChoiceProblem

   object @@ {

      @annotation.unchecked.uncheckedStable
      def em : AnyRef = ???

   }
   

   val ep1 = {

      val e = MultipleChoiceProblem.BasicOptionsTranslativeFnc.ByIsolatedResolver.`given_**@_CC`[collection.immutable.Iterable ]

      MultipleChoiceProblem.BasicOptionsTranslativeFnc.ByIsolatedResolver(using e )([Item] => (r: e.SpawningImpl.CtxOps[Item] ) => {

         println(r.setDescriptor )

         for (option <- r.setDescriptor.defaultOption ) {
            r.tryComplete(util.Success { Seq(option) } )
         }

         new AnyRef with MultipleChoiceProblem.DefinesDoReassignSelectedItems.ByCcE[collection.immutable.Iterable, Item ]
         {

            val dsiImpl = {
               identity[MultipleChoiceProblem.DefinesDoReassignSelectedItems.ByCcE[collection.immutable.Iterable, Item ] ] { case _ => }
            }

            export dsiImpl.setSelectedItems

         }
      } : (AnyRef & MultipleChoiceProblem.DefinesDoReassignSelectedItems.ByCcE[collection.immutable.Iterable, Item ] ) )
   }

   ep1.apply(allOptions = IndexedSeq(null, 3, 4, 5 ) )
   
   ep1.apply(allOptions = IndexedSeq(null, 3, 4, 5, 6, 7 ), defaultItem = 3 )
   
   util.Try({
      ep1.apply(allOptions = IndexedSeq(null, 3, 4, 5, 6, 7 ), arity = MultipleChoiceProblem.ArityPrecisely(121, 123), defaultItem = 3 )
   })
   match { case util.Failure(z) => {
      println("failed, as expected" )
      z printStackTrace(System.out)
   } }
}

;
















