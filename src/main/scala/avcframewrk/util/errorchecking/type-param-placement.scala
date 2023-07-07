package avcframewrk.util.errorchecking


















;

object TypeParamPlacement
{

   /**
    * 
    * `val $typer : C`
    * 
    */
   trait STyper[+C <: { } ]
   {

      protected
      val $typer : C

   }
   
}

;

















