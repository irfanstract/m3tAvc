package avcframewrk.forms

package templating

package ext.givmk


















export PhrasalContent.{_Allocator as PhrasalAllocator }

object PhrasalContent
{
   ;

   ;

   export ssco.{*, given }

   protected
   val ssco
   = ImplDefinedDataType._Def.BasicStaticScopedOps1[Pca.OfAny ]( )

   ;

   ;
}

private[givmk]
object Pca {
   ;

   type OfAny
   = Impl[?]

   type ByRepr
      [C]
   = Impl[? >: C <: C ]

   private[Pca ]
   class Impl
      [ReprT]
      (using val concatenability : avcalg.CBC[ReprT] )
   {
      ;
      type Repr = ReprT
   }

   ;
}




object NpEntityRef {
   ;

   ;

   export ssco.{*, given }

   protected
   val ssco
   = ImplDefinedDataType._Def.BasicStaticScopedOps()

   ;
   ;
}




















val _ = {}