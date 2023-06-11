package avcframewrk.util.lavf
















object conditionalTyping
{

   type IfConforms[R, -B, C[+T <: B], AltC[+_] ] =
      IfConformsInvar[R, ? >: B, C, AltC]

   type IfConformsInvar[R, B, C[+T <: B], AltC[+_] ] 
      =
      (() => R) match {
         case LvicTb[B, t] =>
            C[t]
         case _ =>
            AltC[R]
      }
   type LvicTb[-B, +t <: B] =
      () => t

}



































