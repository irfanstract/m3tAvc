package avcframewrk.util.forms.pure

















// trait ButtonActionFactory

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

trait DefinesDoDescribeButtonA2[
   -A1,
   -A2,
   +R,
]
extends
Any
{

   def describeButton(
      arg1: A1 ,
      arg2: A2 ,
   ) : R

} /* trait DefinesDoDescribeButtonA2 */

trait DefinesDoRenderButtonA1[-A1, +R] extends
Any
{

   def renderButton(c: A1 ) : R

}

trait DefinesDoDescribeButtonA1[
   -A1,
   +R,
]
extends
Any
{

   def describeButton(c: A1 ) : R

} /* trait DefinesDoDescribeButtonA1 */


































