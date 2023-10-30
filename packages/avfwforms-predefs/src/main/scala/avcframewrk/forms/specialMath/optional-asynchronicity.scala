package avcframewrk.forms.specialMath














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
    * intended to (but i'm not sure it really does the thing)
    * select all possible instances,
    * by being `ByCc[[_] =>> Any ]`
    * 
    * see also `collection.IterableOnceOps`
    * 
    */
   type ByCcBeingAny
      = ByCc[[_] =>> Any ]

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
