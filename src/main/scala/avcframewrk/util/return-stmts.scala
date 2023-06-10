package avcframewrk.util















object controlFlow
{

   transparent inline
   def breakablyGet[R](
      //
      
      main : (resolve : R => Nothing ) => R ,

   )(using TypeEvidenceNeitherAnyOrNothing[R] ) : R = {

      util.control.NonLocalReturns.returning[R](op ?=> {
         
         main((r : R ) => (op throwReturn r ) )
      } )

   }

   transparent inline
   def breakably[R](
      //

      main : (break1 : DummyImplicit ?=> Nothing ) => Unit ,

   ) = {

      breakablyGet[Unit ](resolve => (
         
         main(_ ?=> (resolve {} ) )

      ) )

   }

}

export controlFlow.{

   breakablyGet ,

   breakably ,

}







type SameParamRetunFncType[A] = (A => A)



type TypeEvidenceNeitherAnyOrNothing[R] = (
   util.NotGiven[SameParamRetunFncType[R] <:< (SameParamRetunFncType[Any] | SameParamRetunFncType[Nothing] ) ]
)

























