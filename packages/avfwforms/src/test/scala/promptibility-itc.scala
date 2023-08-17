





import avcframewrk.forms.*






extension (dispatcher: Promptibility.XDispatcher.ByNoSpec )
{

   def showAlert[
      A1 <: Product ,

   ](m: A1 )
   (using Question.HeadlineExtractor[m.type] )
   (using advanced.clauseInterweavedActionItemDispatcherImpl.Main.LexicalAsynchronicity )
   // : Unit
   = {

      {
         
         given Question.AcceptableResponseFormatDescExtractorAlgebraic[A1]
         = ???

         // Question.XSummedAllViewImpl.apply[m.type](m)

         dispatcher.apply(m)
      }

   }

   @annotation.experimental
   private
   def dnsp() : Unit = {

      ()

   }

   // def showAsyncWelcomeMsg()
   // : Unit
   // = {

   //    showAlert(??? )

   // }

} // extension dispatcher Promptibility.XDispatcher.ByNoSpec SA










