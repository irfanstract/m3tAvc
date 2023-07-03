package avcframewrk.forms.impl.javaswing
















trait XDefinesAllocNewCheckBoxState
extends
AnyRef
{

   def newCheckBoxState(
      //

      initiallySelected : Boolean ,

   ) : javax.swing.ButtonModel

}







private[javaswing] 
trait ENewCheckBoxStateImpl
extends
AnyRef
with XDefinesAllocNewCheckBoxState
{

   /* name imports */

   import java.awt
   import javax.swing

   import abstractActionFactory.lcafP.{renderButton as renderAbstractAction }

   /* givens and UnsafeNulls */

   import concurrent.ExecutionContext.Implicits.global
   
   import language.unsafeNulls

   /* exports */

   override
   def newCheckBoxState(
      //

      initiallySelected : Boolean ,

   ) : swing.ButtonModel = {

      val jcb = new swing.JCheckBox
      jcb setSelected initiallySelected
      jcb.getModel()
   }

}




















