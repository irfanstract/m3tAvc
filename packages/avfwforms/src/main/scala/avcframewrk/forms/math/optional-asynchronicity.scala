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
      : MainByReturnValue[R]

   } // Impl

   /**
    * 
    * for `DummyImplicit ?=> R`s ,
    * thus simulating by-name thunks
    * 
    */
   @deprecated("this is a misnomer.")
   final
   lazy val byDmCf
   : forByNameAlikeSem.type
   = forByNameAlikeSem

   /**
    * 
    * for `DummyImplicit ?=> R`s ,
    * thus simulating by-name thunks
    * 
    */
   final
   lazy val forByNameAlikeSem
   : (
      ByCc[[R] =>> (DummyImplicit ?=> R ) ]
      {
         type MainByReturnValue[+R]
            = (DummyImplicit ?=> R )
      }
   )
   = {

      type DummyImplicitReturn[R]
         = (DummyImplicit ?=> R )

      new Impl[
         [R] =>> DummyImplicitReturn[R] ,
      ]
      {

         override
         type MainByReturnValue[+R]
            = (DummyImplicit ?=> R )

         override
         def mainByEv[R](f: => R )
         = {

            (_ : DummyImplicit) ?=> {
               f
            }
         }

         //

      }
   } // forByNameAlikeSem$

} // LexicalImperativeSynchronicityGiven$


















val _ = {}
