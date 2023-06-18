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

type ButtonFactory1[-Action, +R]
   >: DefinesDoRenderButtonA1[Action, R]
   <: DefinesDoRenderButtonA1[Action, R]

trait DefinesDoRenderButtonA1[-A1, +R] extends
Any
{

   def renderButton(c: A1 ) : R

}

lazy val emptyPartialFunc = {

   PartialFunction.empty[Any, Nothing]
}


































