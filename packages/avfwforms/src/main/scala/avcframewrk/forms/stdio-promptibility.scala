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

   // summon[Promptibility.XDispatcher.ByNoSpec ]
   // .apply({ Eme(message = "hello", responseFormat = Question.ResponseFormat.ofUnit ) })

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

protected
case class Eme(
   //
   message: String
   ,
   responseFormat: Question.ResponseFormat.XAlgebraicCaseOps
   ,
)

object Eme {

   // given Question.HeadlineExtractor[Eme]
   // with {}

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

         case headline : (Eme         ) => { printHeadline1(headline ) ; Right(() ) }
         
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

      given DtHeadlineDispatcher[Eme]
      with {

         import language.unsafeNulls

         extension (dest: java.io.Writer )
            def printHeadline(m: Eme)
            = {
               // TODO
               dest.println(s"> ${m.message } ")
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














