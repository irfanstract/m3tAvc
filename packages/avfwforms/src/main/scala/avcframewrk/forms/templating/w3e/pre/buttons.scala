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

   /** 
    * `URLAction`
    * 
    * needs to be a separate NS since
    * the default-parameterisations prevent overloading `-____-`
    * 
    */
   val URLAction
   : (
      AnyRef
      & AcsfLabelledUrlTranslator[URLAction]

   ) // URLAction$

   type URLAction
   >: Action
   <: Action

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

object VarEditingActionsProv
{
   ;

   ;

} // VarEditingActionsProv$

trait VarEditingActionsProv
extends
AnyRef
{
   this : (
      AnyRef
      & Buttons
   ) =>
   ;

   ;

   import laminar.api.L

   ;

   /**
    * `Action`s which each updates the `Var`.
    * 
    */
   val VarEditingAction
   : (
      AnyRef

   )

   ;

   ;
} // VarEditingActionsProv#











