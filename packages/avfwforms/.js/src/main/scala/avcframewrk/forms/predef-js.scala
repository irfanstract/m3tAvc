package avcframewrk.forms














def closeAllOf
   (resources : Seq[monix.reactive.Observer[?] ] )
: Unit
= {
   ;

   ;

   util.Using.Manager(m => {
      ;

      given util.Using.Releasable[monix.reactive.Observer[?] ]
      = _.onComplete()

      for (r <- resources ) {
         m(r)
      }
   })

   ;
}














val _ = {}
