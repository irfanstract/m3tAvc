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
            expectedAsynchronicity.MainByReturnValue[main.responseFormat.XValue ]

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