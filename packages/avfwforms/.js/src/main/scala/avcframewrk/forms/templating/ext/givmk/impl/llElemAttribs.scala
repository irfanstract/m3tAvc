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