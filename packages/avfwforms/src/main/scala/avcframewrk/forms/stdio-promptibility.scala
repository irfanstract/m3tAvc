package avcframewrk.forms




import language.implicitConversions
















@main
def runStdIoWelcomeDemo(): Unit
= {

   // TODO

   given Promptibility.XDispatcher.ByNoSpec
   = stdIoPromptibility.dispatcher

   given LexicalAsynchronicity
   = avcframewrk.forms.math.LexicalImperativeSynchronicityGiven.forByNameAlikeSem

   {
      //

      val q1 = EmeHeadlinedEnumQuestionImpl(messageImpl = "hello", responseFormatImpl = Question.ResponseFormat.ofUnit )

      {
         //

         import EmeHeadlinedEnumQuestionImpl.{given AnyRef }

         Question.XSummedAllViewImpl.apply({ q1 })

         summon[Promptibility.XDispatcher.ByNoSpec ]
         .apply({ q1 })

      }

   }

} // runStdIoWelcomeDemo$

object stdIoPromptibility
{

   def dispatcher
   : Promptibility.XDispatcher.ByTAndSubjectAndBlockingnessImpl
   = dispatcherImpl

   private
   lazy val dispatcherImpl
   = {

      import tphImplicits.{*, given AnyRef }

      promptingDispatcherBy(
         //
         dest = java.lang.System.out.nn 
         ,
      )
   }

}

/**
 * 
 * quick in-hurry `Product` impl for those itc(s)
 * 
 * 
 * @param messageImpl
 * @param responseFormatImpl
 * 
 */
case class EmeHeadlinedEnumQuestionImpl(
   //
   messageImpl: String
   ,
   responseFormatImpl: Question.ResponseFormat.XAlgebraicCaseOps
   ,
)

object EmeHeadlinedEnumQuestionImpl {

   given [T1 ]
   : HeadlineInspectiveExtensiveOps[EmeHeadlinedEnumQuestionImpl ]
   with {

      protected 
      type C
         = EmeHeadlinedEnumQuestionImpl

      type ItsHeadline[+c$ <: InstanceOf[C] ]
         >:  InstanceOf[Any ]
         <:  InstanceOf[Any ]

      extension (c: C)
         def headline
         = c.messageImpl

   }

   given given_AcceptableResponseFormatDescExtractor_ActualEmeImpl[T1]
   : Question.AcceptableResponseFormatDescExtractorAlgebraic[EmeHeadlinedEnumQuestionImpl ]
   = {
      //

      type C
         = EmeHeadlinedEnumQuestionImpl
         
      new Question.AcceptableResponseFormatDescExtractor[C ]
      {

         type ItsAcceptableResponseFormatDesc[+c$ <: InstanceOf[C] ]
            >: InstanceOf[ResponseFormat.XAlgebraicCaseOps ]
            <: InstanceOf[ResponseFormat.XAlgebraicCaseOps ]

         extension (c: C)
            def responseFormat
            = c.responseFormatImpl

      }
   }

   /* testing the summon(ing) */
   ([ActualEmeImpl <: EmeHeadlinedEnumQuestionImpl ] => () => {

      summon[Question.AcceptableResponseFormatDescExtractorAlgebraic[ActualEmeImpl ] ]

      {
         val g = given_AcceptableResponseFormatDescExtractor_ActualEmeImpl[ActualEmeImpl]
         summon[(
            g.type
            <:< Question.AcceptableResponseFormatDescExtractorAlgebraic[ActualEmeImpl ] 
         )]
      }

      ()
   } )

}

protected
def promptingDispatcherBy(
   //
   dest: java.io.Writer | java.io.OutputStream 
   ,
   
)
= {

   import tphImplicits.{*, given AnyRef }

   val pdb = Pdb(dest = dest )

   import pdb.*

   new Promptibility.XDispatcher.ByTAndSubjectAndBlockingnessImpl
   {

      override
      def apply
         [
            A <: Product
            ,
         ]
         (
            main
            : (
               Question.XSummedAllView[A ]
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

         )
      = {
         //

         import main.headline

         import main.responseFormat

         tryPrintHeadline1(headline)

         match {

            case Left(z) => 
               //

               throw
                  new java.util.NoSuchElementException(
                     s"failed headline", z match { case z : Throwable => z ; /* case () => null */ } )

            case Right(() ) => 
               //

               lazy val r: responseFormat.XValue
               = awaitTakeAnswer(responseFormat = responseFormat )

               expectedAsynchronicity.mainByEv(r )
               
         }

      }

   }
} // promptDispatcherBy$

protected
class Pdb(
   //
   dest: java.io.Writer | java.io.OutputStream 
   ,
   
)
{
   //

   import tphImplicits.{*, given AnyRef }

   //

   def printHeadline1[Msg ](using DtHeadlineDispatcher[Msg] )(headline: Msg)
   = {

      (dest : java.io.Writer)
      .printHeadline(headline )
   }

   transparent inline
   def tryPrintHeadline1[Msg](headline: Msg)
   : Either[Unit | Throwable, Unit]
   = {

      headline match {

         case headline : (EmeHeadlinedEnumQuestionImpl         ) => { printHeadline1(headline ) ; Right(() ) }
         
         case _ =>
            Left(new UnsupportedOperationException(s"not found 'DtHeadlineDispatcher[(headline @ '${headline }')]' ") )

      }
   }

   transparent inline
   def awaitTakeAnswer(responseFormat : Question.ResponseFormat.XAlgebraicCaseOps )
   : responseFormat.XValue
   = {

      responseFormat match {

         case Question.ResponseFormat.ofUnit =>

            /* a question which does not expect answer */

            ().asInstanceOf[responseFormat.XValue ]

         case Question.ResponseFormat.ofBoolean =>

            /* TODO */

            (false).asInstanceOf[responseFormat.XValue ]

         case _ =>
            //

            /* unsupported fmat */

            throw
               new java.util.NoSuchElementException(
                  s"unsupported responseFormat (${responseFormat }) " )

      }

   }

}

private
object tphImplicits {

   extension (dest: java.io.Writer )
      transparent
      inline
      def tryPrintHeadline[Msg](m: Msg)
      : Either[Unit | Throwable, Unit]
      = {

         compiletime.summonFrom {

            case dhd : DtHeadlineDispatcher[Msg] =>
               dest printHeadline(m )
               Right(() )

            case _ =>
               Left(new UnsupportedOperationException(s"not found 'DtHeadlineDispatcher[('$m' : Msg)]' ") )
         }
      }

   trait DtHeadlineDispatcher[-Msg]
   {

      extension (dest: java.io.Writer )
         def printHeadline(m: Msg)
         : Unit

   }

   object DtHeadlineDispatcher {

      given DtHeadlineDispatcher[EmeHeadlinedEnumQuestionImpl]
      with {

         import language.unsafeNulls

         extension (dest: java.io.Writer )
            def printHeadline(m: EmeHeadlinedEnumQuestionImpl)
            = {
               // TODO
               dest.println(s"> ${m.messageImpl } ")
            }

      }

   }

   /**
    * 
    * on-demand
    * `PrintWriter(_1, autoFlush = true )` methods on plain `Writer`
    * 
    */
   // @deprecated
   export avcframewrk.forms.inio.generalisedPrintlnOperator

   /**
    * 
    * on-demand
    * adaptation/treatment of `java.io.OutputStream` as `java.io.Writer`
    * 
    */
   @deprecated("the implementation of this auto-conv makes assumptions.")
   given Conversion[java.io.OutputStream | java.io.Writer, java.io.Writer]
   = avcframewrk.forms.inio.`given_Conversion_|_Writer`

}

@main
def runStdIoPmd(): Unit
= {

   import tphImplicits.{*, given AnyRef}

   val r = {
      (java.lang.System.out.nn : java.io.Writer )
      .tryPrintHeadline(() => "bar")
   }

   println(r )

}




;














