package avcframewrk.forms

package templating

package ext.givmk

package impl

















;

import scalajs.js

import org.scalajs.dom

import com.raquo.laminar.{nodes as ln }

import laminar.api.L

export LlPropAnimableSettibility.*

object LlPropAnimableSettibility
{
   ;

   ;

   type GivenDefaultSequencingKV
      //
      [
         -
         K
         <: LlAttr.ForValue[V]
         ,
         V
         ,
      ]
   = GivenDefaultSequencingImpl[K, ?, V ]

   type GivenDefaultSequencingKEV
      //
      [
         -K
         <: LlAttr.ForValue[V]
         ,
         -E
         <: ln.ChildNode[?]
         ,
         V
         ,
      ]
   = GivenDefaultSequencingImpl[K, E, V ]

   case class GivenDefaultSequencingImpl
      //
      [
         -K
         <: LlAttr.ForValue[V]
         ,
         -E
         <: ln.ChildNode[?]
         ,
         V
         ,
      ]
      (initialSImpl: () => L.Signal[V] )

   ;

   def initialS
      [V]
      (using gds: GivenDefaultSequencingKV[?, V ] )
   = gds.initialSImpl()

   ;

   extension [V] (byLA: LlAttr.ForValue[V] )
      //
      (using reflect.Typeable[V] )
      (using GivenDefaultSequencingKV[byLA.type , V ] )
   {
      //

      def prepareOn
         //
         (e: ln.ReactiveElement[?] )
      = {
         ;
         implPrepareKey(byLA)(e )
      }

      def asAnimablySettibleProp
         //
         // (e: ln.ReactiveElement[?] )
         ( )
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
                        implAssign(key)(e )(newS = newS )
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
      (using gds: GivenDefaultSequencingKV[?, V ] )
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

   private
   def implPrepareKey
      //
      [V]
      (byLA: LlAttr.ForValue[V] )
      (using reflect.Typeable[V] )
      (e: ln.ReactiveElement[?] )
      (using GivenDefaultSequencingKV[byLA.type, V ] )
   = {
      <--?%.ensurePrepared(byLA )(e)
   }

   private
   def implAssign
      //
      [V]
      (byLA: LlAttr.ForValue[V] )
      (using reflect.Typeable[V] )
      (e: ln.ReactiveElement[?] )
      (newS: L.Signal[V] )
      (using GivenDefaultSequencingKV[byLA.type, V ] )
   = {
      <--?%.applyTo(byLA )(e)(newS )
   }

   ;

   protected
   object <--?%
   {
      ;

      ;

      ;

      export _s1.KeyObjTrait

      def ensurePrepared
         //
         [V]
         (byLA: LlAttr.ForValue[V] )
         (using reflect.Typeable[V] )
         (e: ln.ReactiveElement[?] )
         (using GivenDefaultSequencingKV[byLA.type, V ] )
      : Unit
      = {
         _s1.apply(byLA )
         .forE(e)
         ()
         match { case e => summon[e.type <:< Unit ] }
      }

      def applyTo
         //
         [V]
         (byLA: LlAttr.ForValue[V] )
         (using reflect.Typeable[V] )
         (e: ln.ReactiveElement[?] )
         (newS: L.Signal[V] )
         (using GivenDefaultSequencingKV[byLA.type, V ] )
      : Unit
      = {
         _s1.apply(byLA )
         .forE(e)
         .toObserver.onNext(newS )
         match { case e => summon[e.type <:< Unit ] }
      }

      ;

      protected
      object _s1
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
            newJsWeakMap[KeyObjTrait , _S2[?] ]
         }

         def apply
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
                     new _S2[V](key )
                  })
               } pipeLooseSelf(Some(_) ) )
            } )
            .get
            .pretendedAsForT[V]
         }

         ;
      }

      ;

      protected
      class _S2
         [V ] private[<--?%]
         (using val vCt : reflect.Typeable[V] )
         (byLA: LlAttr.ForValue[V] )
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

         protected
         val cache
         = {
            newJsWeakMap[KeyObjTrait, L.Source[V ] & L.Sink[L.Signal[V] ] ]
         }

         private
         def initLink1
            (initialS: => L.Signal[V] )
            (e: KeyObjTrait )
         = {
            ;

            val hub = XVerFlatteningVar[V](initialS )
            byLA
            .<--!(hub )
            .pipeLooseSelf({
               case mod : com.raquo.laminar.modifiers.Modifier[actualETyp] =>
                  mod.apply(e.asInstanceOf[actualETyp] )
            })
            hub
         }

         def forE
            (e: KeyObjTrait )
            (using GivenDefaultSequencingKEV[? , ?, V ] )
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
         : this1.type & _S2[V1]
         = {
            this1
            .asInstanceOf[this1.type & _S2[V1] ]
         }

         ;

         ;
      }

      ;
   }

   ;
}

private
trait LlEaKoT
{
   ;

   ;

   type KeyObjTrait

   ;

   ;

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

   ;
}

;



















val _ = {}