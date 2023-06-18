package avcframewrk.util.forms.pure

















// trait ButtonActionFactory

type LabelledCallbackButtonFactory[-Label, -Callback >: PartialFunction[Any, Nothing], +R ] = (

   LabelledCallbackButtonFactory1[Label, Callback, R ]
   
)

// TODO demote into TB-type (Tightly-Bounded)
trait LabelledCallbackButtonFactory1[-Label, -Callback, +R] extends
Any
// with ButtonActionFactory
{

   def renderButton(label: Label, callback: Callback ) : R
   
}

type Lcbf1[-Label, -Callback, +R] = (
   DefinesDoRenderButtonA2[Label, Callback, R] {
      def renderButton(label: Label, callback: Callback ) : R
   }
)

trait DefinesDoRenderButtonA2[-A1, -A2, +R] extends
Any
{

   def renderButton(arg1: A1, arg2: A2 ) : R

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


































