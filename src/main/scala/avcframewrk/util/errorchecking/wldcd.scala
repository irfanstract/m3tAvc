package avcframewrk.util.errorchecking

















/**
 * 
 * a workaround to "error: unreducible application for (...) to wildcardarguments"
 * 
 * sadly, neither of these candidates each `EC` satisfy `[T] ?=>> (EC[T] =: T[?] ) `
 * 
 */
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

   type &&&@%%![
      C[+BU, -BL <: BU ] ,
   ]
      = C[Any, Nothing]

   object ForIcdf {
      
      def apply[
         ImplFactoryFor[_] ,
         ActualR ,

      ](actualFactory : ImplFactoryFor[ActualR] )
      : ({ type Instance ; type Factory <: ImplFactoryFor[Instance] })#Factory
      = {

         object %%% {

            object e0 {}

            object e1 {
               // export allInterfacesGivens.{main => main0 }
               val main0
                  : actualFactory.type
                  = actualFactory
               opaque type Instance
                  = ActualR
               opaque type Factory
                  <: ImplFactoryFor[Instance]
                  = main0.type
               val main1
                  : Factory
                  = main0
               opaque type ThisDefiner
                  <: { type Instance ; type Factory <: ImplFactoryFor[Instance] ; val main1 : Factory }
                  = this.type
            }

            val mainPre1
               : { type Instance ; type Factory <: ImplFactoryFor[Instance] ; val main1 : Factory }
               = e1
               
         }
         {
            import reflect.Selectable.reflectiveSelectable
            (%%%.mainPre1)
            .main1
         }
      }

   }

}































