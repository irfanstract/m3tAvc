package avcframewrk.forms

package templating

package reactjs
















;

import scalajs.js

import e_ks.*

// @deprecated
val <<
= new IntrinsicElementSelectable._Impl()

val <
= new IntrinsicElementAsMethods()

val <+
= new <+%%()

type   IntrinsicElementAsMethods
=      IntrinsicElementAsMethods._Any
object IntrinsicElementAsMethods {
   ;

   import language.dynamics

   class _Any extends Dynamic
   object _Any {
      ;
      extension (e: _Any )
         def packed
         : e_ks.ksDefaultReactJsImplMethodism.slMethodsImpl.type
         = valueOf
         export packed.*
      //
   }
}

// TODO
object IntrinsicElementSelectable
{
   ;

   import language.dynamics

   type _Any
   = _Impl

   class  _Impl extends Dynamic
   object _Impl {
      ;
      extension (e: _Impl )
         def selectDynamic
            (k: String)
         = k : _Item._Exactly[k.type]
   }

   object _Item
   {
      ;

      type _Any
      >: String | AvfwReactFunctionComponent[Nothing ]
      <: String | AvfwReactFunctionComponent[Nothing ]

      type _Exactly
         [+T <: _Any]
      >: T @annotation.unchecked.uncheckedVariance
      <: T

      extension [T <: _Any] (cls: _Exactly[T] )
         // TODO
         def decribeInstanceWithStModifier
            //
            [M <: typings.react.mod.Attributes ]
            (mods: PropStModifier._ForFullPropsStType[M]* )
         : ReactElement
         = {
            cls match
            case (cls: String) =>
               describeElement(cls, PropStModifier.compileAll(mods) )
         }
         def decribeInstanceWithStModifyingFnc
            //
            [M0 ]
            (mods: ((receiver: M0 & typings.react.mod.Attributes ) => Unit )* )
         = {
            type M = M0 & typings.react.mod.Attributes
            cls.decribeInstanceWithStModifier[M] (mods.map(PropStModifier.apply[M] _ ) : _* )
         }

      ;
   }

   object PropStModifier
   {
      ;

      type _ForFullPropsStType
         [-T <: typings.react.mod.Attributes ]
      = _Impl[T]

      protected
      case class _Impl
         [-T <: typings.react.mod.Attributes ]
         (emod: (receiver: T) => Unit )
      { export emod.{apply as apply } }
      
      def apply
         [T <: typings.react.mod.Attributes ]
         (f: (receiver: T) => Unit )
      : _ForFullPropsStType[T]
      = _Impl(f)

      extension
         [T <: typings.react.mod.Attributes ]
         (receiver: T)
         /** 
          * apply all these in-order in-place
          * 
          */
         def applyAll
            (fAll: Seq[_ForFullPropsStType[T] ] )
         : receiver.type
         = {
            fAll
            .foreach(f => f.apply(receiver = receiver ) )
            receiver
         }

      def compileAll
         [T <: typings.react.mod.Attributes ]
         (fAll: Seq[_ForFullPropsStType[T] ] )
         (using T <:< js.Any )
      : T
      = {
         val s
         = js.Object().asInstanceOf[T ]
         s.applyAll(fAll)
         s
      }

      ;
   }

   //
}

type <+%%
=    <+%%._Any
object <+%% {
   ;

   import language.dynamics

   class _Any extends Dynamic
   object _Any {
      ;

      ;

      extension (e: _Any )
         def packed
         // : KS.SlApplyClsAndArgsMethodsTo[ksDefaultReactJsImpl.type ]
         = {
            ksDefaultReactJsImplMethodism.slMethodsImpl.lift
         }
         export packed.*
      //
   }
}

// class DsClassTypeCompanionImpl
//    [+ops ]
//    (using ValueOf[ops])
// {
//    ;

//    import language.dynamics

//    class _Any extends Dynamic
//    // extension (e: _Any )
//    //    def packed
//    //    : ops
//    //    = valueOf
//    //    export packed.*
// }

;














val _ = {}
