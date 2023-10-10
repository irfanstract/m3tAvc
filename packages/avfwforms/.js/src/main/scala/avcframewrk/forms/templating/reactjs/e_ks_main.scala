package avcframewrk.forms

package templating

package reactjs













import scalajs.js

type KS
= KS.Sl

object KS
extends
AnyRef
with KS1
{
   ;

   import language.dynamics

   ;

   ;

   import e_ks.*

   ;

   class Sl extends
   AnyRef
   with Dynamic

   object Sl {
      ;

      //
      extension
         [P <: SlMethodism._Peer, I <: SlMethods ]
         (using conv : SlMethodism._ToUni[I] & SlMethodism._ToPeer[P] )
         (using iVw : ValueOf[I] )
         (receiver: Sl )
      {
         export slMethods.*
         // transparent inline
         def slMethods
         // : SlMethodsTo[P] & I
         // : I
         // = conv.apply(receiver )
         : iVw.value.type
         = iVw.value
      }

      ;
   }

   type SlMethods
   = SlMethodsTo[?]

   // protected
   abstract
   class SlMethodsTo
      [
         //
         +implS <: (
            Singleton &
            KS._Impl._Any
         )
         ,
      ]
      (using val impl: implS )
   extends
   AnyRef
   {
      ;

      transparent
      inline
      def applyDynamicNamed
         //
         [
            // C <: _ElementConstructor ,
            T1 ,
         ]
         (cls: impl._ElementConstructor )
         (inline propSeq: (String, ReactPropValueAny )* )
      // TODO
      : impl._ElementFromCls[cls.type]

      transparent
      inline
      def applyDynamic
         //
         [
            // C <: _ElementConstructor ,
            T1 ,
         ]
         (cls: impl._ElementConstructor )
         (inline children: ReactPropValueAny* )
      // TODO
      : impl._ElementFromCls[cls.type]

      ;
   }

   /** 
    * conversion to `SlMethods`
    * 
    */
   object SlMethodism {
      ;

      ;

      type _Any = _Impl[?, ? ]

      @deprecated
      type _To
         [
            //
            +implS <: _Peer
            ,
         ]
      = _ToPeer[implS]

      type _ToPeer
         [
            //
            +implS <: _Peer
            ,
         ]
      = _Impl[?, SlMethodsTo[implS ] ]

      type _Peer
      >: KS._Impl._Any & Singleton
      <: KS._Impl._Any & Singleton

      type _ToUni
         [
            +U <: SlMethods
            ,
         ]
      = _Impl[?, U ]

      protected
      trait _Impl
         //
         [
            //
            // +implS <: _Peer
            T1 // UNUSED
            ,
            +U <: SlMethodsTo[_Peer]
            ,
         ]
      extends (Sl => U )

      // // TODO
      // given defaultInstance
      // : _Any
      // = receiver => {
      //    // new SlMethodsImpl(receiver)
      //    ???
      // }

      ;
   }

   /** 
    * if found,
    * legal
    * 
    */
   class Voibility[-C, -N <: Int ]

}

export KS.{Sl as KSAsSelectableImpl }













val _ = {}
