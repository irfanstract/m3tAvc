package avcframewrk.forms




import language.implicitConversions
















object stdIoPromptibility
{

   def dispatcher
   : Promptibility.XDispatcher.ByTAndSubjectAndBlockingnessImpl
   = dispatcherImpl

   private
   lazy val dispatcherImpl
   = {

      import tphImplicits.{*, given AnyRef }

      ???
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














