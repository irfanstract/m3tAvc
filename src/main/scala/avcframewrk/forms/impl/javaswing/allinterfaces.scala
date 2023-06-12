package avcframewrk.forms.impl.javaswing









import avcframewrk.util.forms.pure.*




import abstractActionFactory.{XLabel, XF}

given ofMostInterfaces :
AnyRef
with OmiAll[MainR]
with {

   /* name imports */

   import java.awt
   import javax.swing

   import avcframewrk.forms.javaswing.actionObjUtil.setIcon

   /* givens and UnsafeNulls */

   import concurrent.ExecutionContext.Implicits.global
   import language.unsafeNulls

   /* exports */

   def renderButton(l: swing.Action) = enClosure {
      new swing.JButton(l)
   }

}

protected
opaque type MainR
   <: AnyRef
   = () => java.awt.Component

protected
def enClosure[R](run : => R ) : (() => R ) = () => run

trait OmiAll[R] extends 
AnyRef
with ButtonFactory1[javax.swing.Action, R ]
{

   export abstractActionFactory.lcafP.{renderButton as renderAbstractAction }

   //

}

private
val _ @ _ = {
   summon[(
      ofMostInterfaces.type

   )]
}




