package avcframewrk.util.errorchecking

















object WildcardTypedInstancing
{

   // case class Ef1[I[_], E0](value : I[E0] ) { type E = E0 }
   // object Ef1
   // {

   //    implicit def unpack[I[_], E, Impl <: Ef1[I, E] ](w: Impl ) : w.value.type = w.value

   //    implicit
   //    def instance[I[_], E0](using I[E0] ): Ef1[I, E0] = {

   //       Ef1[I, E0](summon[I[E0] ] )
   //    }
      
   // }
   
   trait ::![+C[_] ] {
      type Value
      val valuePallete : C[Value]
   }

   type &&&@![
      C1[+_] ,
      C2[-_] ,
   ]
      = C1[Any] & C2[Nothing]

}































