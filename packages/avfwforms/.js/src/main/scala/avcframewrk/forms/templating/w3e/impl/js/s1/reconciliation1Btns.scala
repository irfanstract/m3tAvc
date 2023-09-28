package avcframewrk.forms

package templating

package w3e.impl.js

package s1














import com.raquo.laminar.{nodes as ln}

import org.scalajs.dom

import laminar.api.L





extension [E] (src : L.Signal[Option[E ] ] ) {
   //

   /** 
    * `scanLeftLiftCoalesceAnimative`
    * 
    * implies deduplication, via `.distinct`, at the end,
    * otherwise there'd be multiple consecutive signals pointing to the same child `Observable` objs
    * 
    */
   def scanLeftLiftCoalesceAnimative()
   : L.Signal[Option[L.Signal[E] ] ]
   = {
      ;

      src

      .scanLeft[Option[L.Var[E ] ] ]((o ) => o.map(newS => L.Var[E ](newS ) ) )({
         case (_, None) =>
            None
         case (None, Some(newS) ) =>
            Some { L.Var[E ](newS ) }
         case (Some(var0), Some(newS) ) =>
            var0.set(newS )
            Some { var0 }
      })

      /* deduplication is essential, otherwise there'd be multiple signal pointing to the same child `Observable` objs */
      .distinct

      /* on each, what's at hand is a `Var`, but we need `Signal` instead */
      .map(o => o.map(_.signal) )

      /* deduplication is essential, otherwise there'd be multiple signal pointing to the same child `Observable` objs */
      .distinct
   }

   //
}





















val _ = {}
