
package avcframewrk.forms

package templating

package ext.ks


















;

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

   // import e_ks.*

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
         export slMethods.{
            applyDynamicNamed ,
            applyDynamic ,
         }
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

   class SemiSl extends
   AnyRef
   with Dynamic
   // opaque type SemiSl
   // <: { def apply() }

   object SemiSl {
      ;

      //
      extension
         [P <: SlMethodism._Peer, I <: SlMethodsTo[P] ]
         (using pVw : ValueOf[P] )
         (using iVw : ValueOf[I & SlMethodsTo[pVw.value.type ] ] )
         (using conv : SlMethodism._ToUni[iVw.value.type ] )
         (receiver: SemiSl )
      {
         export slMethods.{
            applyDynamicNamed ,
            applyDynamic ,
         }
         // transparent inline
         def slMethods
         : SemiSlMethodsTo1[(pVw.value.type ), (iVw.value.type )]
         = iVw.value.lift
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

      export impl.{
         _DataAny ,
         // _Element ,
         _ElementConstructor ,
         _ElementFromCls ,
      }

      transparent
      inline
      def applyDynamicNamed
         //
         [
            // C <: _ElementConstructor ,
            T1 ,
         ]
         (cls: _ElementConstructor )
         (inline propSeq: (String, _DataAny )* )
      // TODO
      : _ElementFromCls[cls.type]

      transparent
      inline
      def applyDynamic
         //
         [
            // C <: _ElementConstructor ,
            T1 ,
         ]
         (cls: _ElementConstructor )
         (inline children: (_DataAny )* )
      // TODO
      : _ElementFromCls[cls.type]

      def lift
      = new SemiSlMethodsTo1(this)

      ;
   }

   type SemiSlMethods
   = SemiSlMethodsTo1[?, ? ]

   type SemiSlMethodsTo
      [
         //
         +implS <: (
            Singleton &
            KS._Impl._Any
         )
         ,
      ]
   = SemiSlMethodsTo1[implS, Singleton & SlMethodsTo[implS] ]

   class SemiSlMethodsTo1
      [
         //
         +implS <: (
            Singleton &
            KS._Impl._Any
         )
         ,
         +Invoker <: (
            Singleton &
            SlMethodsTo[implS]
         )
         ,
      ] private[KS]
      (val impl : Invoker )
   {
      ;

      export impl.{
         _DataAny ,
         // _Element ,
         _ElementConstructor ,
         _ElementFromCls ,
      }

      type _ExportMethodName
      >: "apply"
      <: "apply"

      /** 
       * `stdlib.Dynamic` method `applyDynamicNamed`
       * 
       * note :
       * tuple literals, as also used by `applyDynamicNamed` of `stdlib.Dynamic` ,
       * will widen in such a way unacceptable here, so
       * we need to make `emptyStringAndClsTuple` `inline` and then
       * try to refine the Expr to revive the actual specific (sub)type (via the facility `KvTupleOrigine`)
       * , making dependence of this whole method being also `transparent` .
       * it would still fallback to the widening,
       * if the arg `emptyStringAndClsTuple` expr
       * happens to be something not a tuple-literal (for some reason)
       * 
       */
      transparent
      inline
      def applyDynamicNamed
         //
         [
            C <: _ElementConstructor ,
            T1 <: true ,
         ]
         (m: _ExportMethodName )
         (
            //
            inline emptyStringAndClsTuple: ("", C )
            ,

            inline propSeq: (String, _DataAny )*
         )
      // : _ElementFromCls[emptyStringAndClsTuple._2.type ]
      = {
         ({
            ;

            applyDynamicNamedImpl
               (ksImplUtil.KvTupleOrigine.applyToTuple2(emptyStringAndClsTuple ) )
               (propSeq : _* )
         })
      }

      private[forms]
      transparent
      inline
      def applyDynamicNamedImpl
         //
         (kvTuple: (String, _ElementConstructor ) )
         (inline propSeq: (String, _DataAny )* )
      = {
         ;

         impl.applyDynamicNamed
            (kvTuple._2 )
            (propSeq : _* )
      }

      private
      object adnImpl {
         ;

         /** 
          * additionally defines `type value = value.type`
          * 
          */
         case class CVI
            [+Value](value : Value)
         { type value = value.type }

         //
      }

      /* no need to use such additional/extra macro trickery, which we're using above, here */
      transparent
      inline
      def applyDynamic
         //
         [
            // C <: _ElementConstructor ,
            T1 ,
         ]
         (m: _ExportMethodName )
         (cls: (_ElementConstructor ), inline children: (_DataAny )* )
      // TODO
      = {
         impl.applyDynamic(cls)(children : _* )
      } : _ElementFromCls[cls.type ]

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

;


















val _ = {}
