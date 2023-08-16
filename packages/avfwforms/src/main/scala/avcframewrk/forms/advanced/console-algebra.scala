package avcframewrk.forms

package advanced















object clauseInterweavedActionItemDispatcherImpl
{

   /* the language imports (though, for some reason putting em here works) */

   /* the library name imports */

   import Question.XSummedAllView

   /* the main def */

   trait Main
   {

      import Main.LexicalAsynchronicity

      ()

      ()

      /**
       * 
       * .
       * 
       * 
       * @param main the main action item
       * @param manager the main support for dealing with `main`
       * @param expectedAsynchronicity `LexicalImperativeSynchronicityGiven`
       * 
       */
      def apply
         [
            A <: Product
            ,
         ]
         (
            main
            : (
               // A
               XSummedAllView[A ]
               // Any
            )
            ,
         )
         (using
            expectedAsynchronicity
            : LexicalAsynchronicity
            ,
         )
         : (
            ([R] =>> (
               expectedAsynchronicity.MainByReturnValue[R]
            ))
            [(
               // TODO wait until the first cand no longer crash the compiler, and switch back to it

               main.responseFormat.XValue
               // Product
            ) ]

         ) // r

   } // Main

   object Main {

      //

      type LexicalAsynchronicity
         = avcframewrk.forms.math.LexicalImperativeSynchronicityGiven.ByCc[[_] =>> Any ]

      object LexicalAsynchronicity {

         //

      } // LexicalAsynchronicity$

   } // Main$

} // clauseInterweavedActionItemDispatcherImpl$