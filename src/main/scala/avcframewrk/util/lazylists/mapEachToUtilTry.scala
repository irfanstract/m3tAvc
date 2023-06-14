package avcframewrk.util.lazylists
















extension [CC[A] <: collection.IterableOps[A, CC, CC[A] ], E ](src: CC[E] ) {

   /**
    * 
    * maps into `util.Try[E]`s.
    * when used with `LazyList`s,
    * return a `LazyList` which will, for each item, not retry the failing computation.
    * 
    * if your code uses `Iterator`s instead,
    * invoke `to(LazyList)` first, and then 
    * convert the resulting LL back into `Iterator` .
    * (the *evidence* lists `Iterator`, but
    * `CC` can't be `IterableOnceOps` due to the `.iterableFactory` usage )
    * 
    */
   @deprecated("experimental")
   def mapToTrials()(using CC[E] <:< (collection.View[?] | LazyList[?] | Iterator[?] ) ): CC[util.Try[E] ] = {

      val ICC = src.iterableFactory

      ICC.unfold[util.Try[E], LazyList[E] ](src.to(LazyList ) )(seq => {

         util.Try({
            
            seq match {
               case v +: seqTail =>
                  Some((util.Success(v) , seqTail))
               case Seq() =>
                  None
            }
         })
         
         .fold[Option[(util.Try[E], LazyList[E] )] ](z => {

            /**
             * 
             * must be the `.drop(1)` version
             * 
             */
            Some((util.Failure(z) , seq.drop(1) ) )
            
         } , identity _ )

         .nn
         
      })
      
   }

}






















