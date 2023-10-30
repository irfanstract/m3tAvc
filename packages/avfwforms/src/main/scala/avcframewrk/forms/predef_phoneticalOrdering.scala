package avcframewrk.forms
















;

import avcframewrk.forms.localutil.predefChainingOpsImplicits.given_predefChainingOps_type

;

val xModifiedPhoneticalOrdering
= {
   ;

   Ordering.by(({
      ;

      import language.unsafeNulls

      ;

      ((nm: String) => (Numeric[Double].parseString(nm ).getOrElse[Double](Double.NaN ) *: (
         //

         nm.toUpperCase(java.util.Locale.ROOT )

         .pipeLooseSelf(nm => (
            //

            /* TODO: handle the rest of Latin-Script Code-Page */
            "UWMBPVFOQKGAHXELRNTDCSYIJZ"
            .indexOf({
               nm
               .codePointAt(0)
            })

            .&(Int.MaxValue )
         ))

         //
      ) *: nm *: EmptyTuple ) )
   }))
}













