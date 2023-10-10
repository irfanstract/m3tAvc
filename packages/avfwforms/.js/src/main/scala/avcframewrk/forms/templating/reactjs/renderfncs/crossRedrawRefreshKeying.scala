package avcframewrk.forms

package templating

package reactjs

package renderfncs













import scalajs.js

import org.scalajs.dom

import dom.console

;

;

;

type AvfwDependenciesArray
= AvfwDependenciesArray._Any

object AvfwDependenciesArray
{
   ;

   type _Any
   = _Impl

   opaque type _Impl
   >: Seq[?]
   =  Seq[?]

   extension (dependencies: _Impl)
      def toSeq
      : Seq[?]
      = dependencies

      def toNative()
      : typings.react.mod.DependencyList
      = js.Array(dependencies : _* )

}

;

/** 
 * 
 * Effect Builder Pattern
 * 
 * there are 2 different formats for a no-arg `initFnc` -
 * (+) a by-name one, and (+) a `Function0` one .
 * to keep everything else so-on decoupled from the user-chosen fmt,
 * we impl this
 * 
 * ```
 * // `useMemo()`
 * // necessitates deferring it as `Function0`
 * Efb.byFunction0(() => (... ) , Nil :+ ... ... )
 * // however,
 * // the front-ends in this front-end lib
 * // unlifts it into by-name(s) instead
 * Efb.byByNameEv((... ) , Nil :+ ... ... )
 * 
 * ```
 * 
 */
object Efb {
   ;

   ;

   // @annotation.experimental
   // def ofConstant
   //    [R]
   //    (r: R , dependencies: AvfwDependenciesArray )
   // = {
   //    ofValueDoneByByNameEv[r.type] (r , dependencies )
   //    // match { case finalVal => {
   //    //    if finalVal != r then
   //    //       throw new IllegalStateException(s"inconsistency: aint($finalVal == $r ) " )
   //    // } }
   // }

   def ofValueDoneByByNameEv
      [R]
      (r: => R , dependencies: AvfwDependenciesArray )
   = doneByFnc0(() => r , dependencies )

   def forFnc
      [F <: scala.Function0[?] | scala.Function1[?, ?] ]
      (f: F , dependencies: AvfwDependenciesArray )
   = ofValueDoneByByNameEv(f , dependencies )

   def doneByFnc0
      [R]
      (f: () => R , dependencies: AvfwDependenciesArray )
   : _AsDoneByFunction0[R ]
   = _Impl[scala.Function0 , R ]((f , dependencies ) )

   def doneByFnc1
      [R, A]
      (f: A => R , dependencies: AvfwDependenciesArray )
   : _AsDoneByFunction1[A, R]
   = _Impl[[r] =>> (A => r ) , R ]((f , dependencies ) )

   ;

   opaque type _Any
   >: _Impl[? <: [_] =>> _CBase , ? ]
   <: Any
   =  _Impl[? <: [_] =>> _CBase , ? ]

   extension (b0: (
      _Any
   ) ) {
      def b1
      // : b0.type
      = b0
      export b1.{evf, dependencies }
   }

   protected
   type _ByCcAndR
      [+C[+r] <: _CBase, +R ]
   = _Impl[C, R ]

   type _AsDoneByFunction0
      [+R]
   = _ByCcAndR[[r] =>> Function0[? <: r] , R ]

   type _AsDoneByFunction1
      [-A, +R]
   = _ByCcAndR[[r] =>> Function1[? >: A, ? <: r] , R ]

   ;

   type _CBase
   >: AnyRef
   <: AnyRef

   protected
   case class _Impl
      [+C[+r] <: _CBase, +R ]
      (c: (C[R] , AvfwDependenciesArray ) )
   {
      export c.{_1 as evf }
      export c.{_2 as dependencies }
   }

   ;

   ;
}

;

;

;













val _ = {}