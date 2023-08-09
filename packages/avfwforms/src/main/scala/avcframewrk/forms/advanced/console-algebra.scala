package avcframewrk.forms

package advanced















@annotation.experimental
object clauseInterweavedActionItemDispatcherImpl
{

   /* the language imports (though, for some reason putting em here works) */

   import language.experimental.clauseInterleaving

   /* the library name imports */

   import Promptibility.XDispatchTimePrereqsImpl

   /* the main def */

   trait Main
   {

      /**
       * 
       * .
       * 
       * 
       * @param main the main action item
       * @param manager the main support for dealing with `main`
       * 
       * @param expectedAsynchronicity `LexicalImperativeSynchronicityGiven`
       * 
       */
      def apply
         [
            A <: Product ,
         ]
         (
            main
            : (
               A
               // Any
            )
            ,
         )
         [M >: main.type <: A ]
         (using
            manager: XDispatchTimePrereqsImpl[? >: M]
            ,
         )
         (using
            expectedAsynchronicity
            : avcframewrk.forms.math.LexicalImperativeSynchronicityGiven.ByCc[[_] =>> Any ]
            ,
         )
         : (
            ([R] =>> (
               expectedAsynchronicity.MainByReturnValue[R]
            ))
            [(
               // TODO wait until the first cand no longer crash the compiler, and switch back to it

               manager.ItsRfdXValue[main.type]
            ) ]

         ) // r

   }

   object Main {

      //

   } // Main$

} // `&&&%!`