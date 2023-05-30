package cbsq.avc.upstream


















/**
 * 
 * `PerMuuxCtxOps` ;
 * rewrite of `AvFormatCtx` (`avformat.h`)
 * 
 * each instance of this class
 * deals with either, but not both, *demuxing from one path-or-URL* or *enmuxing to one path-or-URL*
 * 
 * every property is represented as "the (...) question" which needs to be `resolve`d.
 * for convenience,
 * for some commonly-used properties
 * we define the convenience aliases allowing the simple `inputFmt` or `inputFmt = &lt;value>` syntax.
 * 
 */
trait PerMuuxCtxOps
extends
   AnyRef
   with PerMuuxCtxOps.OfCoreQuestions
   with PerMuuxCtxOps.OfPerStreamsList
   with PerMuuxCtxOps.OfTRangeSpec
   with PerMuuxCtxOps.OfInputFmtSpec
   with PerMuuxCtxOps.OfInputUrl
   with PerMuuxCtxOps.OfProtocolWhitelisting
{

   /* we're probably better off basing all this on `Selectable` (XD) */

}
object PerMuuxCtxOps
{

   export pmcoUtil1.*

   type OfAllProps = (
      PerMuuxCtxOps
   )

   opaque type AvClass
      = Unit

   trait OfCoreQuestions 
   {
      
      export     avClassQuestion.{value =>   avClass }

      val avClassQuestion = LateBoundValue.forValue(() )
      
   }
 
   trait OfPerStreamsList 
   {
      
      /**
       * 
       * the streams
       * we're to work with
       * 
       */
      val streamList = {
         GrowableSeq.nextInstance[PerStream]
      }

   }
 
   trait OfTRangeSpec
   {
      
      export     startTQuestion.{value =>   startT }
      export       endTQuestion.{value =>     endT }
      export durationalQuestion.{value => duration }

      val     startTQuestion = LateBoundValue.newInstance[BigDecimal]
      val       endTQuestion = LateBoundValue.newInstance[BigDecimal]
      val durationalQuestion = LateBoundValue.newInstance[BigDecimal]

   }
 
   trait OfInputFmtSpec
   {
      
      export iFormatSimpleNameQuestion.{
         value      =>   iFormatSimpleName     , 
         success    =>   iFormatSimpleName_=   , 
      }
      val iFormatSimpleNameQuestion = {
         LateBoundValue.newInstance[String]
      }
      
      val iFormatWhitelisting = {
         newWhitelisting[String]()
      }
      
   }
 
   trait OfInputUrl
   {
      
      export srcUrlQuestion.{
         value    =>   srcUrl   ,
         success  =>   srcUrl_= ,
      }
      val srcUrlQuestion = {
         LateBoundValue.newInstance[String]
      }

   }
 
   extension [A <: OfInputUrl](this1: A ) {

      def setDestToNull  () = this1 applyConfigCallback (_ srcUrl_= "null:" )

      def setDestToStdIo () = this1 applyConfigCallback (_ srcUrl_= "cstdio:"    )
      def setDestToStdIn () = this1 applyConfigCallback (_ srcUrl_= "cstdio:in"  )
      def setDestToStdOut() = this1 applyConfigCallback (_ srcUrl_= "cstdio:out" )

   }
   
   trait OfProtocolWhitelisting
   {
      
      val protocolWhitelisting = {
         newWhitelisting[String]()
      }
      
   }

   extension [A <: OfAllProps](this1: A ) {

      def doProbeInputBuffer2(

         offset : cbsq.FileSize ,
         maxProbeSize : cbsq.FileSize ,
         
      ): Unit = {

         var buf : java.nio.ByteBuffer = {
            import language.unsafeNulls
            java.nio.ByteBuffer.allocate(0x8000 ) // TODO
         }

         Predef.???
         
      }

   }
 
}

type PerStream

private 
object pmcoUtil1 {
   
   extension (this1: AnyRef) {

      def applyConfigCallback(
         runCallback: this1.type => Unit ,

      ): this1.type = {
         runCallback(this1)
         this1
      }

   }

   class newWhitelisting[E]() {
      
      val blacklist = GrowableSeq.nextInstance[E]
      
      def blacklistedItems: Seq[E] = blacklist.toSeq

      val whitelist = collection.mutable.Buffer.empty[E]

      def whitelistedItems: Seq[E] = {
         whitelist.toSeq
         .filterNot(blacklistedItems.contains _)
      }
      
   }

}




































































