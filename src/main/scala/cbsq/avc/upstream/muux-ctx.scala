package cbsq.avc.upstream


















/**
 * 
 * `PerMuuxCtxOps` ;
 * rewrite of `AvFormatCtx` (`avformat.h`)
 * 
 * each instance of this class
 * deals with
 * either, but not both, *demuxing from one path-or-URL* or *enmuxing to one path-or-URL*
 * 
 * in `libavformat`,
 * `AVFormatCtx` is
 * the main structure, maintaining as-much-as-possible info for the de/enmuxing.
 * 
 * `libavformat`'s `AVFormatCtx`
 * puts emphasis on the three fields, `iformat`, `streams`, `pb`,
 * corresponding to, here, `iFormat`, `streamList`, `pb`
 * - `iFormat`
 *   (eventually) refers to the resolved AVFormat
 * - `streamList`
 *    is an add-only (ie no-removal) Seq to maintain the opened in-mux streams
 * - `pb`
 *    will eventually refer to
 *    the InputStream, FileChannel, or OutputStream
 *    serving the I/O from-or-to `src`
 * 
 * every property
 * is represented as
 * `thePropertyQuestion: Question[ThePropertyValue]` which needs to be `resolve`d.
 * for convenience,
 * for some commonly-used properties
 * we define
 * the convenience aliases
 * allowing the simple `thePropertyValue` or (reassignment) `thePropertyValue = &lt;value>` syntax.
 * 
 * one don't explicitly deallocate `PerMuuxCtxOps` like C programs needs to do explicitly ;
 * OO languages (except C) manages all those automatically, where
 * the library
 * will rely on `CleanupThread` or `FinalizationRegistry` to schedule the "finalize" impl
 * 
 */
type PerMuuxCtxOps = (
   PerMuuxCtxOps.OfAllProps
   
)
// trait PerMuuxCtxOps
// extends
//    AnyRef
//    with PerMuuxCtxOps.OfCoreQuestions
//    with PerMuuxCtxOps.OfInMuxStreamsList
//    with PerMuuxCtxOps.OfTRangeSpec
//    with PerMuuxCtxOps.OfInputFmtSpec
//    with PerMuuxCtxOps.OfInputUrl
//    with PerMuuxCtxOps.OfProtocolWhitelisting
// {
//
//    /* we're probably better off basing all this on `Selectable` (XD) */
//
// }
object PerMuuxCtxOps
extends
   AnyRef
   with Odes
{

   export pmcoUtil1.*

   type OfAllProps = (
      OfDemuxing
      | OfEnmuxing
      
   )

   trait OfDemuxing
   extends
      AnyRef
      with OfDemuxingEnmuxingShared

   trait OfEnmuxing
   extends
      AnyRef
      with OfDemuxingEnmuxingShared

   sealed
   trait OfDemuxingEnmuxingShared
   extends
      AnyRef
      with OfCoreQuestions
      with OfInMuxStreamsList
      with OfTRangeSpec
      with OfInputFmtSpec
      with OfInputUrl
      with OfProtocolWhitelisting

   @deprecated
   opaque type AvClass
      = Unit

   def newAvClassQuestion() = {
      LateBoundValue.ofAlreadyResolvedWithValue(() )
   }

   trait OfCoreQuestions 
   {
      
      export avClassQuestion.{value => avClass }

      val avClassQuestion = {
         newAvClassQuestion()
      }
      
   }
 
   /**
    * 
    * all opened in-mux streams
    * 
    */
   trait OfInMuxStreamsList 
   {
      
      /**
       * 
       * the streams
       * we're to work with
       * 
       */
      val streamList = {
         GrowableSeq.nextInstance[InMuxStream]
      }

      export streamList.{toIndexedSeq => streams }

   }
 
   /**
    * 
    * maintains these three values - "the T range"
    * 
    */
   trait OfTRangeSpec
   {
      
      export     startTQuestion.{value =>   startT }
      export       endTQuestion.{value =>     endT }
      export durationalQuestion.{value => duration }

      val     startTQuestion = OfTRangeSpec.newTValueQuestion()
      val       endTQuestion = OfTRangeSpec.newTValueQuestion()
      val durationalQuestion = OfTRangeSpec.newTValueQuestion()

   }
   object OfTRangeSpec
   {

      def newTValueQuestion() = {
         LateBoundValue.newInstance[BigDecimal]
      }

   }
 
   /**
    * 
    * maintains info about the input fmt
    * 
    */
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

   /**
    * 
    * maintains the open I/O stream
    * 
    */
   trait OfInputPb
   {

      import OfInputPb.UNINITIALISED
      import OfInputPb.CLOSED

      val pb = {
         java.util.concurrent.atomic.AtomicReference[(

            UNINITIALISED.type
            | java.io.Closeable
            | CLOSED.type

         )](UNINITIALISED )
      }

   }
   object OfInputPb
   {

      val UNINITIALISED : Matchable = null
      val CLOSED        : Matchable = -1
      
   }
 
   trait OfInputUrl
   {
      
      export srcUrlQuestion.{
         value    =>   srcUrl   ,
         success  =>   srcUrl_= ,
      }
      val srcUrlQuestion = {
         OfInputUrl.newUrlQuestion()
      }

   }
   object OfInputUrl
   {

      def newUrlQuestion() = {
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

   // protected 
   // type OfAvProbing = AvProbeCtx

   // export AvProbeCtx.probeInputBuffer2
 
}

type InMuxStream

/**
 * 
 * decoding and encoding,
 * whilst have possibly rather large set of shared variables,
 * in practice have some mutually-exclusive aspects
 * (eg `--store-tmp` only exists for decoding, while `--quality=&lt;qp>` and `--flush-packets` only exists for encoding )
 * 
 * we define
 * - `OfDemuxingEnmuxingShared` shall be a `trait`, as demonstrated above
 * - `OfDemuxing <: OfDemuxingEnmuxingShared`
 * - `OfAllProps =: OfDemuxing | OfEnmuxing`
 * 
 */
trait Odes
{

   type OfAllProps
      >: this.OfDemuxing | this.OfEnmuxing
      <: this.OfDemuxing | this.OfEnmuxing

   type OfDemuxingEnmuxingShared
      // >: A
   
   type OfDemuxing
      // >: A
      <: this.OfDemuxingEnmuxingShared
   
   type OfEnmuxing
      // >: A
      <: this.OfDemuxingEnmuxingShared
   
}

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




































































