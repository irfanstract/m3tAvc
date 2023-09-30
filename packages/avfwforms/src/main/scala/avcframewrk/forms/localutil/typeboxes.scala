// package avcframewrk.forms.localutil.typelevel.allocators

package avcframewrk.forms

package localutil


















object TypeBoxProvider {
   ;

   inline
   def Bcp
      [
         C[
            -InstanceL <: InstanceU,
            +InstanceU <: GlbU ,
         ]
         ,
         GlbU
         <: AnyKind
         ,
      ]
   = new BcpImpl[C, GlbU]

   inline
   def BcpCapAnyKind
   = Bcp[[L <: U , U <: AnyKind] =>> CcForT[? >: L <: U ] , AnyKind ]

   private[localutil]
   case class CcForT
      [T <: AnyKind ]
      ()
   { type CAP >: T <: T }

   private[TypeBoxProvider]
   class BcpImpl
      [
         +
         C[
            -InstanceL <: InstanceU,
            +InstanceU <: GlbU ,
         ]
         ,
         // -
         GlbU
         <: AnyKind
         ,
      ]
   {
      ;

      type ByLU
         [
            -L <: U,
            +U <: GlbU ,
         ]
      >: C[L, U ] @annotation.unchecked.uncheckedVariance
      <: C[L, U ] @annotation.unchecked.uncheckedVariance

      type ForExactly
         [U <: GlbU ]
      = ByLU[U, U ]

      /* 
       * 
       * we
       * 'd also like to put in a `match`-based introspector abstract here, but
       * the speculated limitations in the compiler's capability to do that
       * blocks us from doing that
       * 
       */
      ;

   }

   ;
}


















val _ = {}