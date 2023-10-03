package avcframewrk.forms

package templating

package ext.givmk

package impl


















;

import scalajs.js

import org.scalajs.dom

import com.raquo.laminar.{nodes as ln }

import laminar.api.L

object LlAttr {
   ;

   ;

   type ForValue
      [V]
   = ForValueLU[V, V]

   type ForValueLU
      [-VL <: VU, +VU ]
   >: (
      //

      com.raquo.laminar.keys.HtmlProp[? >: VL <: VU, ? ]
      | com.raquo.laminar.keys.HtmlAttr[? >: VL <: VU]
      |
      com.raquo.laminar.keys.SvgAttr[? >: VL <: VU]
   )
   <: (
      //

      com.raquo.laminar.keys.HtmlProp[? >: VL <: VU, ? ]
      | com.raquo.laminar.keys.HtmlAttr[? >: VL <: VU]
      |
      com.raquo.laminar.keys.SvgAttr[? >: VL <: VU]
   )

   extension [V] (peer: ForValueLU[V, Any] ) {
      //

      // transparent inline
      def <--!
         (hub : L.Source[V] )
      // : com.raquo.laminar.modifiers.KeyUpdater[? <: ln.ReactiveElement[?] , ? <: ForValueLU[V, Any], V ]
      = {
         ;

         peer
         .pipeLooseSelf({
            case peer : com.raquo.laminar.keys.HtmlAttr[V] =>
               peer.<--(hub.toObservable )
            case peer : com.raquo.laminar.keys.HtmlProp[V, ?] =>
               peer.<--(hub.toObservable )
            case peer : com.raquo.laminar.keys.SvgAttr[V] =>
               peer.<--(hub.toObservable )
         })
      }

      //
   }

   ;
}

export LlPropAnimableSettibility.asAnimablySettibleProp

object LlPropAnimableSettibility
{
   ;

   ;

   case class GivenDefaultSequencingImpl
      //
      [
         -
         K <: LlAttr.ForValue[V]
         ,
         V
         ,
      ]
      (initialSImpl: () => L.Signal[V] )

   ;

   def initialS
      [V]
      (using gds: GivenDefaultSequencingImpl[?, V ] )
   = gds.initialSImpl()

   ;

   extension [V] (byLA: LlAttr.ForValue[V] ) {
      //

      def asAnimablySettibleProp
         //
         // (e: ln.ReactiveElement[?] )
         (using reflect.Typeable[V] )
         ( )
         (using GivenDefaultSequencingImpl[byLA.type , V ] )
      = {
         new AnyRef with AsUpdatableImpl[V, ln.ReactiveElement[?] ]( )
         {
            ;

            override
            def <--(newS: L.Signal[V] )
            = {
               ;
               new
                  com.raquo.laminar.modifiers.KeySetter
                  [byLA.type , L.Signal[V], ln.ReactiveElement[?] ]
                  (byLA, newS, {
                     (e, key, newS) => {
                        ;
                        key.implAssign(e )(newS = newS )
                     }
                  } )
            }

         }
      }

      //
   }

   ;

   protected[templating]
   sealed
   trait AsUpdatableImpl
      [V, E <: ln.ReactiveElement[?] ]
      (using gds: GivenDefaultSequencingImpl[?, V ] )
      ( )
   {
      ;

      def <--(newS: L.Signal[V] )
      : com.raquo.laminar.modifiers.Modifier[E]

      transparent inline
      def :=(newVal: V )
      : com.raquo.laminar.modifiers.Modifier[E]
      = <--(L.Val[newVal.type](newVal) )

      transparent inline
      def asReset
      : com.raquo.laminar.modifiers.Modifier[E]
      = <--(initialS )

      ;
   }

   ;

   extension [V] (byLA: LlAttr.ForValue[V] ) {
      //

      private
      def implAssign
         //
         (using reflect.Typeable[V] )
         (e: ln.ReactiveElement[?] )
         (newS: L.Signal[V] )
         (using GivenDefaultSequencingImpl[byLA.type, V ] )
      = {
         <--?%.forKey(byLA )
         .forEWithInitialSeq(e)(initialS = initialS )
         .toObserver.onNext(newS )
      }

      //
   }

   ;
}

object <--?%
{
   ;

   ;

   protected
   object s1
   extends
   AnyRef
   with LlEaKoT
   {
      ;

      ;

      override
      type KeyObjTrait
      >: LlAttr.ForValueLU[Nothing, Any ]
      <: LlAttr.ForValueLU[Nothing, Any ]

      protected
      val cache
      = {
         newJsWeakMap[KeyObjTrait , _Cand[?] ]
      }

      protected
      lazy val sc
      = {
         ;
         given_Console_alt
         // .subConsole("avcframewrk.forms.templating.ext.givmk.impl.<--?%")
      }

      protected
      def scForLlAttr
         (key: KeyObjTrait )
      = {
         ;
         sc
         .subConsole(s"[for ${key }]")
      }

      def forKey
         [
            V
            : reflect.Typeable
            ,
         ]
         (key: KeyObjTrait & LlAttr.ForValue[V] )
      = {
         cache.updateWith(key )(o => {
            o
            .orElse({
               scForLlAttr(key)
               .info(s"init ")
               ({
                  new _Cand[V](key )
               })
            } pipeLooseSelf(Some(_) ) )
         } )
         .get
         .pretendedAsForT[V]
      }

      ;
   }

   export s1.KeyObjTrait

   export s1.forKey

   protected
   class _Cand
      [V ] private[<--?%]
      (using val vCt : reflect.Typeable[V] )
      (peer: LlAttr.ForValue[V] )
   extends
   AnyRef
   with LlEaKoT
   {
      this1 =>
      ;

      ;

      ;

      override
      type KeyObjTrait
      >: ln.ChildNode[?]
      <: ln.ChildNode[?]

      private
      def initLink1
         (initialS: => L.Signal[V] )
         (e: KeyObjTrait )
      = {
         ;

         val hub = XVerFlatteningVar[V](initialS )
         peer
         .<--!(hub )
         .pipeLooseSelf({
            case mod : com.raquo.laminar.modifiers.Modifier[actualETyp] =>
               mod.apply(e.asInstanceOf[actualETyp] )
         })
         hub
      }

      def forEWithInitialSeq
         (e: KeyObjTrait )
         (initialS: => L.Signal[V] )
      = {
         ;
         cache.updateWith(e )(o => {
            o
            .orElse({
               initLink1(initialS = initialS )(e )
               .pipeLooseSelf(Some(_) )
            } )
         } )
         .get
      }

      def pretendedAsForT
         [
            V1
            : reflect.Typeable
            ,
         ]
      : this1.type & _Cand[V1]
      = {
         this1
         .asInstanceOf[this1.type & _Cand[V1] ]
      }

      ;

      protected
      val cache
      = {
         newJsWeakMap[KeyObjTrait, L.Source[V ] & L.Sink[L.Signal[V] ] ]
      }

      ;
   }

   ;
}

private
trait LlEaKoT {
   ;
   type KeyObjTrait
}

// extension [V] (byLA: ByLlAttr[V] )
// {

//    def :=
//       (value: V )
//    : ByLlAttrAndValue[V]
//    = {
//       byLlAttrAndValue(byLA.a )(value )
//    }

// }

// def byLlAttr
//    [V]
//    (a: LlAttr.ForValue[V] )
// : ByLlAttr[V]
// = {
//    ;
//    ByLlAttr0[V, [_] =>> Null ](a, null )
// }

// type ByLlAttr
//    [V]
// >: ByLlAttr0[V, [_] =>> Null ]
// <: ByLlAttr0[V, [_] =>> Null ]

// def byLlAttrAndValue
//    [V]
//    (a: LlAttr.ForValue[V] )
//    (value: V )
// : ByLlAttrAndValue[V]
// = {
//    ;
//    ByLlAttr0[V, laminar.api.L.Signal ](a, laminar.api.L.Val(value) )
// }

// type ByLlAttrAndValue
//    [V]
// = ByLlAttr0[V, laminar.api.L.Signal ]

// private
// case class ByLlAttr0
//    [V, +O[v] ]
//    (a: LlAttr.ForValue[V] , vPr: O[V] )
// {
//    ;
//    type _Value
//    >: V
//    <: V
//    ;
// }

// type BAVs
//    [Es <: Tuple ]
// = Tuple.Map[Es, ({ type Main[E] = E match { case ByLlAttr[v ] => v } })#Main ]

// val _ = {
//    ((e: BAVs[(ByLlAttr[String ], ByLlAttr[5d ], ByLlAttr[4.5d ] ) ] ) => {} )
//    ()
// }



















val _ = {}