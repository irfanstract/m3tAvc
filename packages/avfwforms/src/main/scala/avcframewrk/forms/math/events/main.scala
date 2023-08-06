package avcframewrk.forms.math

package events













export avcframewrk.evm.{
   newEventSequencePipe => newComittingPipe ,
}

object LexicalImperativeSynchronicityGiven {

   type ByCc[+CC[+_] ]
      = Impl[CC]

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

   final
   lazy val byDmCf
   = {

      type DummyImplicitReturn[R]
         = (DummyImplicit ?=> R )

      new Impl[
         [R] =>> DummyImplicitReturn[R] ,
      ]
      {

         override
         type MainByReturnValue[+R]
            >: DummyImplicitReturn[R]
            <: DummyImplicitReturn[R]

         override
         def mainByEv[R](f: => R )
         = {

            (_ : DummyImplicit) ?=> {
               f
            }
         }

         //
         
      }
   }

} // LexicalImperativeSynchronicityGiven$













val _ = {}
