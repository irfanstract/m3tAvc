package avcframewrk.forms

package schd














opaque type OneTimeTask
<: Task
= Task

opaque type OneTimeTaskAlsoCallable
   [+F <: AnyRef ]
<: OneTimeTask & TaskAlsoCallable[F]
= OneTimeTask & TaskAlsoCallable[F]

def oneTimeTaskTo
   [R]
   (main: => R )
: OneTimeTaskAlsoCallable[() => R ]
= {
   object ran { val returnVal = main }
   TaskFromImpl1[() => ran.returnVal.type ]
   .apply((
      //

      TaskImpl[Unit, [_] =>> (() => ran.returnVal.type ) ](
         //
         asCallableImpl = _ => () => ran.returnVal ,
         state = () ,
      )
   ))
}

//




opaque type RepetibleTask
<: Task
= Task

opaque type RepetibleTaskAlsoCallable
   [+F <: AnyRef ]
<: RepetibleTask & TaskAlsoCallable[F]
= RepetibleTask & TaskAlsoCallable[F]


def RepetibleTaskTaskFromFunctionI
   [F <: AnyRef]
   (using rff : RFF[F] )
: Conversion[F, RepetibleTaskAlsoCallable[F] ]
= {
   (TaskFromImpl1[F].apply _ )
   .compose((impl: TaskImpl[Unit, [_] =>> F ] ) => impl )
   .compose((impl: F ) => {
      TaskImpl[Unit, [_] =>> F ] (
         //
         state = () ,
         asCallableImpl = _ => impl,
      )
   } )
   match { case f => f.apply _ }
}

def RepetibleTaskTaskFromFunction
   [F <: AnyRef]
   (impl: F )
   (using rff : RFF[F] )
= RepetibleTaskTaskFromFunctionI[F].apply(impl )






// given Conversion















