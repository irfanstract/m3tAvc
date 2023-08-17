





import avcframewrk.forms.*






/* see also "SIP 48 -- the 'precise' type-modifier" https://github.com/scala/improvement-proposals/pull/48 */

extension (dispatcher: Promptibility.XDispatcher.ByNoSpec )
{

   def showAlert[
      A1 <: Product ,

   ](m: A1 )
   (using Question.HeadlineExtractor[m.type], Question.AcceptableResponseFormatDescExtractorAlgebraic[A1] )
   (using advanced.clauseInterweavedActionItemDispatcherImpl.Main.LexicalAsynchronicity )
   // : Unit
   = {

      {

         // val s = summon[Conversion[A1, Question.XSummedAllView[A1] ] ]

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










