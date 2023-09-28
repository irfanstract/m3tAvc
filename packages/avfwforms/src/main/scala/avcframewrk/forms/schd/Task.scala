package avcframewrk.forms

package schd


















opaque type Task
= TaskImpl[?, [_] =>> Any ]

opaque type TaskAlsoCallable
   [+F <: AnyRef]
<: Task
= TaskImpl[?, [_] =>> F ]

given TaskFunction
   [F <: AnyRef]
: Conversion[TaskAlsoCallable[F], F ]
= e => e.asCallable

case class TaskImpl
   [State, +F[s] ]
   (
      asCallableImpl
      : (state: State) => F[State]
      ,
      state: State
      ,
   )
{
   def asCallable
   = asCallableImpl(state)
}
//

def TaskFromImpl1
   [F <: AnyRef]
: Conversion[TaskImpl[?, [_] =>> F ] , TaskAlsoCallable[F] ]
= identity[TaskImpl[?, [_] =>> F ] ] _




















