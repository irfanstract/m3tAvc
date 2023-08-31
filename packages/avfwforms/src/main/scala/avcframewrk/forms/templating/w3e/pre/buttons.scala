package avcframewrk.forms

package templating

package w3e.pre












trait Buttons
extends
AnyRef
with Articles
{

   type Action

   val Action
   : (
      AnyRef
      & AcsfLabelledCallbackTranslator[Action]
   )

   type ButtonArt
      <: Article

   def describeButtonByAction(action: Action)
   : ButtonArt

   extension (mainLineContents: Article) {

      /**
       * with clickability leading to the specified Action
       * 
       */
      def asHavingDirectAction(action: Action)
      : Article
      = {
         (mainLineContents ++ describeButtonByAction(action ) )
      }

   } // (mainLineContents: Article) asHavingDirectAction(action: Action)

}











