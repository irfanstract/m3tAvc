package avcframewrk.forms

import language.implicitConversions
















@main
def runStdIoWelcomeDemo(): Unit
= {

   // TODO

   val p
   = stdIoPromptibility.dispatcher

}

object stdIoPromptibility
{

   def dispatcher
   : Promptibility.XDispatcher.ByTAndSubjectAndBlockingnessImpl
   = dispatcherImpl

   private
   lazy val dispatcherImpl
   = {

      import tphImplicits.{*, given AnyRef }

      promptDispatcherBy(
         //
         dest = java.lang.System.out.nn 
         ,
      )
   }

}

def promptDispatcherBy(dest: java.io.Writer | java.io.OutputStream )
= {

   import tphImplicits.{*, given AnyRef }

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

         (dest : java.io.Writer)
         .tryPrintHeadline(headline )

         match {

            case Left(z) => 
               //

               throw
                  new java.util.NoSuchElementException(
                     s"failed headline", z match { case z : Throwable => z ; case () => null } )

            case Right(() ) => 
               //

               lazy val r: responseFormat.XValue
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

               expectedAsynchronicity.mainByEv(r )
               
         }

      }

   }
}

private
object tphImplicits {

   extension (dest: java.io.Writer )
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

      given DtHeadlineDispatcher[String]
      with {

         import language.unsafeNulls

         extension (dest: java.io.Writer )
            def printHeadline(m: String)
            = {
               // TODO
               dest.println(s"> ${m } ")
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














