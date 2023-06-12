package avcframewrk.util.forms.pure

















// trait ButtonActionFactory

type LabelledCallbackButtonFactory[-Label, -Callback >: PartialFunction[Any, Nothing], +R ] = (

   LabelledCallbackButtonFactory1[Label, Callback, R ]
   
)

trait LabelledCallbackButtonFactory1[-Label, -Callback, +R] extends
Any
// with ButtonActionFactory
{

   def renderButton(label: Label, callback: Callback ) : R
   
}

trait ButtonFactory1[-Action, +R] extends
Any
{

   def renderButton(c: Action ) : R

}

lazy val emptyPartialFunc = {

   PartialFunction.empty[Any, Nothing]
}


































