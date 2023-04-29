package cbsq

package object numerics {
   
   type BoxDimnSize[n <: 0 | 1 | 2 | 3, +V] = (
      n match {
         case 0 => Unit
         case 1 => Tuple1[V]
         case 2 => (V, V )
         case 3 => (V, V, V )
         case 4 => (V, V, V, V )
         case 5 => (V, V, V, V, V )
      }
   )

   // type *:? = *:
   // type TLAs = IndexedSeq[[A] =>> (A, A)] ;

   // lazy val myvalue = compiletime.erasedValue
   // {
   // }
  
}
