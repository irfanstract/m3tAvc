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
   = Bcp[[L <: U , U <: AnyKind] =>> { type CAP >: L <: U } , AnyKind ]

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

   }

   ;
}


















val _ = {}