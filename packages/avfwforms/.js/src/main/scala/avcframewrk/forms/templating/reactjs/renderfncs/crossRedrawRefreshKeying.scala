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

   protected
   opaque type _Impl
   // >: Seq[?]
   <: Any
   =  Seq[?]

   extension (dependencies: _Any)
      def toSeq
      : Seq[?]
      = dependencies

      def toNative()
      : typings.react.mod.DependencyList
      = js.Array(dependencies : _* )

   ;

   /** 
    * a "box-ing" conv,
    * requiring `given` `AvfwDependenciesArrayItemability._For[E]` to yield,
    * to avoid bugs like `false negatives for object-literal, across redraws, resulting in constant call/firing`
    * as retold at https://react.dev/learn/removing-effect-dependencies#does-some-reactive-value-change-unintentionally
    * .
    * 
    * can't put `(using AvfwDependenciesArrayItemability._For[E] )` explicitly on sig, as
    * that resulted in unhelpful, opaque "type-mismatch" abort.
    * instead, by making this method `inline` and deffering the "summon" into being `summonInline`,
    * at-least we get the necessary good error-reporting `no given instance of AvfwDependenciesArrayItemability.For[E] was found`.
    * 
    */
   inline
   given fromSeqOf[E]
      // (using AvfwDependenciesArrayItemability._For[E] )
   : Conversion[Seq[E] , _Any ]
   = ${ fsoImpl[E] }

   private[reactjs]
   def fsoImpl
      //
      [E : quoted.Type ]
      (using quoted.Quotes )
   = {
      ;

      import quoted.*
      import quotes.reflect.*
      import avcframewrk.forms.templating.ext.ks.ksImplUtil.asLinebreaking

      ;

      if {
         None
         .orElse({
            Expr.summon[Conversion[Unit, "deserves allAcceptingInstanceTrust"] ]
            None
         } )
         .orElse({
            Expr.summon[AvfwDependenciesArrayItemability._For[E] ]
         })
         .isEmpty
      } then {
         ;
         report.error((
            Nil
            :+ s"cannot summon conversion from Seq[E] to AvfwDependenciesArray."
            :+ s"type E was: "
            :+ Printer.TypeReprCode.asLinebreaking().show(TypeRepr.of[E] ).indent(2 ).nn
            :+ s"as pointed at https://react.dev/learn/removing-effect-dependencies#does-some-reactive-value-change-unintentionally , "
            :+ s"we need to limit elements of DependencyList to eligible data-type(s). "
            :+ s"to prevent serious bugs, including nonterminating-loop . "
            :+ s"make sure an implicit AvfwDependenciesArrayItemability[E] exists,"
            :+ s"and try again."
            // :+ s"Seq[E](... ... ...) "
            mkString("\n")
         ))
      }

      ;
      '{
         ;
         locally[Conversion[Seq[E] , _Any ] ] {
            ;

            identity[Seq[E] ] _
         }
      }
   }

   // private[reactjs]
   // given allAcceptingInstanceTrust
   // : Conversion[Unit, "deserves allAcceptingInstanceTrust"]
   // = _ => ???

}

/** 
 * 
 * to avoid bugs like `false negatives for object-literal, across redraws, resulting in constant call/firing`
 * as retold at https://react.dev/learn/removing-effect-dependencies#does-some-reactive-value-change-unintentionally
 * 
 */
object AvfwDependenciesArrayItemability
{
   ;

   ;

   type _Any
   = _Impl[?]

   type _For[-T]
   = _Impl[? >: T]

   protected
   class _Impl[-T ]

   ;

   def pretendFor[T]
   : _For[T]
   = new _Impl[T]

   ;

   /** 
    * for primitive-types and `Unit`
    * 
    */
   given forPrimitiveTypeInstances[T]
   : _For[Double | Float | Long | Int | Short | Char | Byte | Boolean | Unit ]
   = pretendFor

   /** 
    * for String(s), assuming being in JS env
    * 
    */
   given forStrings
   : _For[String ]
   = pretendFor

   ;

   // // TODO remove this
   // @deprecated
   // private[reactjs]
   // given trustedAssumptiveUniversalDefaultInstance
   //    // (using util.NotGiven[Conversion[Unit, "no trustedAssumptiveUniversalDefaultInstance, please"] ])
   // : AvfwDependenciesArrayItemability._For[Any]
   // = {
   //    AvfwDependenciesArrayItemability.pretendFor
   // }

   // TODO remove this
   // @deprecated
   private[reactjs]
   given allAcceptingInstanceTrust
   : Conversion[Unit, "deserves allAcceptingInstanceTrust"]
   = _ => ???

   @deprecated
   given trustedAssumptiveUniversalDefaultInstance
      (using allAcceptingInstanceTrust.type )
   : AvfwDependenciesArrayItemability._For[Any]
   = {
      AvfwDependenciesArrayItemability.pretendFor
   }
   ;
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