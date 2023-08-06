package avcframewrk.forms.math














object LexicalImperativeSynchronicityGiven {

   /**
    * 
    * .
    * 
    * see also `collection.IterableOnceOps`
    * 
    */
   type ByCc[+CC[+_] ]
      = Impl[CC]

   /**
    * 
    * for `DummyImplicit ?=> R`s
    * 
    */
   type ByDmCf
      = ByCc[[R] =>> (DummyImplicit ?=> R ) ]

   protected
   trait Impl[
      +CC[+_] ,
   ]
   {

      type MainByReturnValue[+R]
         <: CC[R]

      /**
       * 
       * by a "block"
       * 
       */
      def mainByEv[R](f: => R )
      : CC[R]

   } // Impl

} // LexicalImperativeSynchronicityGiven$


















val _ = {}
