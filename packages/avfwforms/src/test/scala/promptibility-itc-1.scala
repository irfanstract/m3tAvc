









import avcframewrk.forms.*







class PromptibilityItcsTypeDefinitiveTest
extends
org.scalatest.funsuite.AnyFunSuite
{

   test("this basic example compiles and completes") {

      //

      def showAlert
         [
            A1 <: Product
            ,

         ]
         (m: A1 )
         (using Promptibility.XDispatcher.ByNoSpec )
         (using Question.HeadlineExtractor[m.type], Question.AcceptableResponseFormatDescExtractorAlgebraic[A1] )
         (using advanced.clauseInterweavedActionItemDispatcherImpl.Main.LexicalAsynchronicity )
      = {

         (summon[Promptibility.XDispatcher.ByNoSpec ] )
         .apply(m)

      }

      assert(1 == 1 )

   }

   test("this basic example 2 compiles and completes") {

      //

      def showAlert
         [
            A1 <: Product
            ,

         ]
         (m: A1 )
         (using Promptibility.XDispatcher.ByNoSpec )
         (using Question.HeadlineExtractor[m.type], Question.AcceptableResponseFormatDescExtractorAlgebraic[A1] )
      = {

         implicit val fgc
         = avcframewrk.forms.math.LexicalImperativeSynchronicityGiven.forByNameAlikeSem

         (summon[Promptibility.XDispatcher.ByNoSpec ] )
         .apply(m)

      }

      assert(1 == 1 )

   }

}











