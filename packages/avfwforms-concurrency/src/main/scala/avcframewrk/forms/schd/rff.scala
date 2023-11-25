package avcframewrk.forms

package schd











type RFF[-F]
= RFF.ByReturnTypeAndFullType[Any, F ]

object RFF {
   ;

   opaque type ByReturnTypeAndFullType[+R, -F]
   <: { type ReturnValue <: R }
   = { type ReturnValue <: R }

   protected[schd]
   def impl[R, F]
   = new {}.asInstanceOf[RFF.ByReturnTypeAndFullType[R, F ] ]

   given forFunction0[R]
   : RFF.ByReturnTypeAndFullType[R, () => R]
   = impl

   given forFunction1[R]
   : RFF.ByReturnTypeAndFullType[R, Function1[?, R] ]
   = impl

   given forFunction2[R]
   : RFF.ByReturnTypeAndFullType[R, Function2[?, ?, R] ]
   = impl

   given forFunction3[R]
   : RFF.ByReturnTypeAndFullType[R, Function3[?, ?, ?, R] ]
   = impl

   ;

   ;
}










val _ = {}
