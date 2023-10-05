package avcframewrk.forms

package templating

package ext.givmk


















object ImplDefinedDataType
{
   ;

   ;

   /**
    * 
    * here
    * we don't do `type BarTableModel >: ... <: ...` ; we instead do `object BarTableModel { type _Allocator ... ; ... }` ;
    * due to the effective repetition,
    * here's a generalisation
    * 
    */
   object _Def
   {
      ;

      private[forms]
      object BasicStaticScopedOps
      {
         transparent inline
         def apply()
         = BasicStaticScopedOps1[TypeBoxAlikeAllocatorAny]()
      }

      private[forms]
      class BasicStaticScopedOps1[Etb]
         // private[forms]
         ()
      {
         ;

         /**
          * 
          * here
          * we don't do `type BarTableModel >: ... <: ...` ;
          * we instead do `object BarTableModel { type _Allocator ... ; ... }` ;
          * 
          */
         opaque type _Allocator
         <: Etb
         =  Etb

         object _Allocator
         extends
         AnyRef
         with FTBExtensions
         {
            ;

            /**
             * an `_Allocator` from a TypeBox
             * 
             */
            def fromTypeBox
               (e: Etb )
            : FromTypeBox[e.type]
            = e

            type FromTypeBox[+e <: Etb ]
            = _Allocator & e

            ;
         }

         private[_Def]
         type _AllocatorModule
         = _Allocator.type

      }

      trait  FTBExtensions
      object FTBExtensions {
         ;

         extension (_Allocator: BasicStaticScopedOps1[TypeBoxAlikeAllocatorAny]#_AllocatorModule ) {
            //

            /**
             * an `_Allocator` which maps to the given type
             * 
             */
            transparent
            inline
            def forType
               [T1 <: Any ]
            : ([T] =>> (_Allocator.FromTypeBox[typeBoxProvider.ByLU[T, T] ] ) )[T1]
            = _Allocator.fromTypeBox(typeBox[T1] )

            //
         }

         ;
      }

      ;
   }

   ;

   ;
}

private[templating]
case class PccGeneralisedFactoryImpl
   [
      ArtR,
      -FMinT ,
   ]
(impl : ([F <: FMinT ] => (f: F) => ArtR ) )
{
   ;

   type FMin
   = FMinT @annotation.unchecked.uncheckedVariance

   transparent inline
   def apply
      [F <: FMin ]
      (f: F )
   = impl.apply(f )

   ;
}

private[templating]
case class PccGeneralisedUniLabelledFactoryImpl
   [
      ArtR,
      -FMinT ,
   ]
(impl : ([F <: FMinT ] => (lbl: ArtR, f: F) => ArtR ) )
{
   ;

   type FMin
   = FMinT @annotation.unchecked.uncheckedVariance

   transparent inline
   def apply
      [F <: FMin ]
      (label: ArtR)
      (f: F )
   = impl.apply(label, f )

   ;
}

/** 
 * obtains a type-box for the given `type`
 * 
 */
transparent
inline
def typeBox
   [T <: Any ]
: TypeBoxAlikeAllocatorLU[T, T]
= {
   inline compiletime.erasedValue[T =:= T ]
   match {
      case _ : ((Nothing =:= Nothing) | (Any =:= Any ) ) =>
         compiletime.error("'T' inferred to 'Nothing' or 'Any' ; please make the t-args explicit and try again")
      case _ =>
   }
   typeBoxInstNoCheck[T]
}

/** 
 * obtains a type-box for the given `type`
 * 
 */
def typeBoxInstNoCheck
   [T <: AnyKind ]
: TypeBoxAlikeAllocatorLU[T, T]
= {
   new AnyRef()
   .asInstanceOf[TypeBoxAlikeAllocatorLU[T, T] ]
}

final
lazy
val typeBoxProvider
= localutil.TypeBoxProvider.BcpCapAnyKind

type TypeBoxAlikeAllocatorLU
   [
      -L
      <: U
      ,
      +U
      <: AnyKind
      ,
   ]
= typeBoxProvider.ByLU[L, U]

type TypeBoxAlikeAllocatorAny
= TypeBoxAlikeAllocatorLU[Nothing, Any ]

type TypeBoxAlikeAllocatorAnyKind
= TypeBoxAlikeAllocatorLU[Nothing, AnyKind ]

















