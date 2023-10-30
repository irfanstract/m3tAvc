package avcframewrk.forms

package domNavigatorObj.storageUsageUtil













import cps.{async, await }

import scalajs.js

import typings.{std as domItc }
import typings.std.{global as dom }

import cps.monads.jsfuture.{JSFuture, given }

import com.raquo.airstream





;

object FsWatchFrpTwoWay {
  ;

  ;

  ;

  object CtxtualSetterStyle
  {
    ;

    ;

    type _Any
    = _Impl

    type _ForValueT
      [ValueT]
    = _Impl { }

    protected
    trait _Impl {
      ;

      type Setter

      type ReadjustedValueAndSetterPair1[+Value ]

      type SetterSynchronousReturnValue
      >: Unit | js.Promise[Unit]
      <: Unit | js.Promise[Unit]

      def fromValueAndSetter
        //
        [Value ]
        (value: Value, updateTo: Value => SetterSynchronousReturnValue )
      : ReadjustedValueAndSetterPair1[value.type]

      extension [Value] (pair: ReadjustedValueAndSetterPair1[Value] ) {
        //

        def value
        : Value

        def chgTo(value: Value)
        : SetterSynchronousReturnValue
      }

      type DerivedInstanceForValueT
        //
        [ValueT]
      <: _Any & _ForValueT[ValueT]

      implicit
      def derivedInstanceForValueT
        //
        [ValueT]
      : DerivedInstanceForValueT[ValueT]

      ;
    }

    ;

    given defaultInstance
      [ValueT ]
    : (_ForValueOnlyInstanceImpl & _ForValueT[ValueT] )
    = valueOnlyInstance[ValueT ]

    ;

    protected
    trait _ForValueOnlyInstanceImpl
    extends
    AnyRef
    with _Impl
    {
      ;

      type ReadjustedValueAndSetterPair1[+Value]
      >: Value @annotation.unchecked.uncheckedVariance
      <: Value

      def fromValueAndSetter
        //
        [Value ]
        (value: Value, updateTo: Value => SetterSynchronousReturnValue )
      : value.type
      = value

      extension [Value] (pair: ReadjustedValueAndSetterPair1[Value] ) {
        //

        def value
        : pair.type
        = pair

        @deprecated
        def chgTo(value: Value)
        : Unit
        = {}
      }

      type DerivedInstanceForValueT
        //
        [ValueT]
      <: _Any & _ForValueOnlyInstanceImpl & _ForValueT[ValueT]

      implicit
      def derivedInstanceForValueT
        //
        [ValueT]
      : DerivedInstanceForValueT[ValueT]

    }

    def valueOnlyInstance
      //
      [ValueT ]
    : _ForValueOnlyInstanceImpl & _ForValueT[ValueT]
    = {
      new AnyRef with _ForValueOnlyInstanceImpl
      with Selectable
      {
        ;

        type DerivedInstanceForValueT
          //
          [ValueT]
        >: _Any & _ForValueOnlyInstanceImpl & _ForValueT[ValueT]
        <: _Any & _ForValueOnlyInstanceImpl & _ForValueT[ValueT]

        def derivedInstanceForValueT
          //
          [ValueT]
        = valueOnlyInstance[ValueT]

      }
    }

    ;
  }

  ;
}
















val _ = {}
