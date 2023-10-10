package avcframewrk.forms

package templating

package reactjs













import scalajs.js

opaque type KS
<: Any
= AnyRef
object KS
{
   ;

   import language.dynamics

   ;

   ;

   import e_ks.*

   ;

   final
   lazy val slToExprValueOfGvns
   = singletonTypeToQuotedExprGvns

   implicit class Sl(receiver: KS )
   extends
   AnyRef
   // with Selectable
   with Dynamic
   {
      ;

      import slToExprValueOfGvns.{*, given }

      transparent
      inline
      def applyDynamicNamed
         //
         [
            // C <: _ElementConstructor ,
            T1 ,
            implS <: (
               Singleton &
               KS._Impl._Any
            ) ,
         ]
         (using implManifest: _ImplManifest[implS] )
         (using impl: implManifest.value.type = implManifest.value )
         (cls: impl._ElementConstructor )
         (inline propSeq: (String, ReactPropValueAny )* )
      = ${sd.importable.mroDynamicRjsElementImpl[impl.type, implS ] ('{ impl }) (clsExpr = '{ cls } )('propSeq ) }

      transparent
      inline
      def applyDynamic
         //
         [
            // C <: _ElementConstructor ,
            T1 ,
            implS <: (
               Singleton &
               KS._Impl._Any
            ) ,
         ]
         (using implManifest: _ImplManifest[implS] )
         (using impl: implManifest.value.type = implManifest.value )
         (cls: impl._ElementConstructor )
         (inline children: ReactPropValueAny* )
      = ${sd.importable.mroDynamicRjsElementAltImpl[impl.type, implS ] ('{ impl }) (clsExpr = '{ cls } )('children ) }

      ;
   }

   /** 
    * if found,
    * legal
    * 
    */
   class Voibility[-C, -N <: Int ]

   /** 
    * the way the multi-staging happens to be implemented,
    * it becomes impossible to directly pass the impl directly .
    * sadly macro(s) were disallowed to take ctx-bound(s) either .
    * hence the need to do this
    * 
    */
   case class _ImplManifest
      [+C <: _Impl._Any & Singleton ]
      (value : C )

   /** 
    * a helper to
    * summon instances of the impl-ref type, and then invoke the selected method.
    * this is necessary as
    * the compiler restricts macros away from calling non-static methods
    * 
    */
   object sd {
      ;

      ;

      import compiletime.*
      import quoted.*

      ;

      extension [
         I <: I0 & Singleton,
         I0 <: (KS._Impl._Any & Singleton ) ,
      ] (implRef: Expr[I] )
         (using Type[I] )
         (using Type[I0] )
         // (using ugh: implRef.type = implRef )
         (using Quotes )
      {
         export implAk.*

         private
         def implAk : _IReExportsFrom[I]
         = {
            import quotes.reflect.*
            given Type[I]
            = {
               Type.of[I0]
               .pipeLooseSelf({
                  e => {
                     e
                  }
               })
               .asInstanceOf[Type[I] ]
            }
            (for {
               impl <- {
                  valueFromQuotesOption[I]
               } : Option[I]
            } yield _IReExportsFrom(impl) )
            .getOrElse({
               report
               .ksErrorAndAbort(s"cannot re-summon (in spliceOwner: ${Symbol.spliceOwner.fullName } ): ${Type.show[I] } ; ", implRef )
            })
         }
      }

      case class _IReExportsFrom
         [+I <: (KS._Impl._Any & Singleton )]
         (impl: I )
      {

         /** 
          * cannot safely base the `export` directly on/at `impl`, as
          * that resulted in the types approx-ed to `?`.
          * instead,
          * the `export` needs to be "based on a `val` whose 'underlying type' is not a(other) wildcard-type"
          * 
          */
         val implProxy
         : impl.type
         = impl

         export implProxy.{*, given}

      }

      /** 
       * interestingly,
       * we still need another level of indirection,
       * like this one
       * 
       */
      object importable {
         export sd.{*, given}
      }

      ;
   }

   export KS1.{*, given }

}

export KS.{Sl as KSAsSelectableImpl }













val _ = {}
