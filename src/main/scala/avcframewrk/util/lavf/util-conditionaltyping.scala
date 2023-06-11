package avcframewrk.util.lavf
















object conditionalTyping
{

   /**
    * 
    * type-params 
    * - `R` - typically `this.type`
    * 
    * will evaluate to
    * `C&lt;R>` if `R &lt;: B`, and `Alt&lt;R>` otherwise
    * 
    */
   type IfConforms[+R, -B, C[+T <: B], AltC[+_] ] 
      =
      LvicTb[? >: R, R] match {

         case LvicTb[B, t] =>
            C[t]

         case _ =>
            AltC[R]

      }

   private[conditionalTyping] 
   type LvicTb[-B, +t <: B] =
      () => t

}



































