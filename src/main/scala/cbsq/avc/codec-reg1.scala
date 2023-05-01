package cbsq.avc












// import MediaKind as EMediaKind









// /**
//  * 
//  * basic factoring of a *demuxing* [[CodecTemplateOps]]
//  * 
//  */
// @annotation.experimental
// def bbsd(mimeType1: String) =
//    object zcd extends BbsdZcdImpl(mimeType1 = mimeType1 : mimeType1.type)
//    // ???
//    // ???
//    // // zcd.template : (CodecTemplateOps { val mediaKind: EMediaKind.Mix.type })
//    // ???
//    // ???
//    zcd.template

def dcdDebugTestNoop1(): Unit = {}

// def dcdTest1(): BbsdZcdImpl["application/x-lavfmt-discarddemux", EMediaKind.Mix.type] = {
//    (new BbsdZcdImpl(
//       mimeType1 = "application/x-lavfmt-discarddemux" ,
//       mediaKindP = EMediaKind.Mix ,
//    ) {
      
//       def openUrlOrArgs(
//          url: Null | (java.net.URI | java.net.URLConnection | DestibleFd1) ,
//          args1: IndexedSeq[String] ,
//       ) =
//          // TODO
//          new Instance1() {

//             // lazy val decodedFormO: Some[BbsdAvFrameIterator.OfRegOfHandlerForMediaKind[EMediaKind.Mix.type ] ] =
//             //    throw UnsupportedOperationException("TODO")
//             lazy val decodedFormO = None

//          }

//       type RelevantFd 
//          >: java.io.InputStream
//          <: java.io.InputStream

//    } )
// }

type Dsd = BbsdZcdImpl["application/x-lavfmt-discarddemux", EMediaKind.Mix.type]

// @deprecated("experimental")
// protected 
sealed trait  BbsdZcdImpl[
   +SpecificMimeType  <: (Singleton & String     ) ,
   +SpecificMediaKind <: (Singleton & EMediaKind ) ,
](
   val mimeType1  : (SpecificMimeType  ) ,
   val mediaKindP : (SpecificMediaKind ) ,
) 
{ thisCodecBackend =>

   type InstanceAgnosticEvent <: (
      AnyRef 
      & Product
   )
   /**
    * behind discretion, may support firing of events
    */
   lazy val instanceAgnosticEvents : Iterator[InstanceAgnosticEvent] =
      Iterator()

   type RelevantFd <: java.io.Closeable

   /**
    * 
    * expected by [[CodecTemplateOps ]]
    * 
    */
   type DestibleFd1
      >: ioUtil.AsBuffered[RelevantFd ]
      <: RelevantFd

   /**
    * 
    * the set of ops which `thisCodecBackend.template` shall `implements` .
    * 
    */
   protected 
   trait OverviewXOps extends 
      CodecTemplateOps 
      // with WithIae
      with TPossiblySupportsEventsForwarded[InstanceAgnosticEvent]
      with DedicAliasToGlobalEvtIterator
   {
    
      // thisCodecInstantiable: thisCodecBackend.template.type =>
      thisCodecInstantiable =>

      final val mimeType: mimeType1.type = 
         mimeType1
      
      // export EMediaKind.{Mix as mediaKind}
      val mediaKind : thisCodecBackend.mediaKindP.type =
         thisCodecBackend.mediaKindP

      type Rd 
         >: thisCodecBackend.RelevantFd 
         <: thisCodecBackend.RelevantFd

      // override def hashCode(): Int = 
      //    3
  
   }

   // object template extends OverviewXOps
   // val template: OverviewXOps
   object template extends 
      OverviewXOps
      with TPossiblySupportsEventsForwarded[InstanceAgnosticEvent](backingSourcer = instanceAgnosticEvents)
   {
      
      // thisCodecInstantiable: thisCodecBackend.template.type =>
      thisCodecInstantiable =>

      type Instance 
         >: thisCodecBackend.Instance1AC 
         <: thisCodecBackend.Instance1AC

      /**
       * 
       */
      type DestibleFd
         >: thisCodecBackend.DestibleFd1
         <: thisCodecBackend.DestibleFd1

      inline def startForFd(src: DestibleFd): Instance = 
         thisCodecBackend.openUrlOrArgs(url = src, args1 = IndexedSeq() )
         
      inline def startForUrl(
         href: java.net.URI, 
         flags: IndexedSeq[String] ,
      ): Instance =
         thisCodecBackend.openUrlOrArgs(url = href, args1 = flags )
      
      inline def startC(args: String*): Instance = 
         thisCodecBackend.openUrlOrArgs(url = null, args1 = args.toIndexedSeq )
      
      // def startForOptions(options: CDO): Instance = ???
      
   }
   
   protected 
   trait  DedicAliasToGlobalEvtIterator 
      extends 
      // TPossiblySupportsEvents
      // BbsdCdeDage[InstanceAgnosticEvent]
      TPossiblySupportsEventsForwarded[InstanceAgnosticEvent]
   {
      
      // // override 
      // // lazy val events: thisCodecBackend.instanceAgnosticEvents.type = 
      // //    thisCodecBackend.instanceAgnosticEvents
      // // export thisCodecBackend.{instanceAgnosticEvents as events}
      // /**
      //  * [[CodecTemplateOps#events]]
      //  * 
      //  * @note
      //  * the right ascription would be [[thisCodecBackend.instanceAgnosticEvents]], but
      //  * the compiler would complain "non-stable path" .
      //  * using `final` is not desirable as it prevents overriding,
      //  * unless the `final` `def` were also `inline`.
      //  * for now, 
      //  * using the alias introduced by the `export thisCodecBackend.{instanceAgnosticEvents as prvIae}` (below) compiled at-the-time, tho
      //  * as [[prvIae]] is just another way of saying [[thisCodecBackend.instanceAgnosticEvents]] ,
      //  * it's likely that an updated compiler version reject this - be prepared to refactor this again !
      //  * 
      //  */
      // override 
      // lazy val events: prvIae.type = 
      //    thisCodecBackend.instanceAgnosticEvents
      // export thisCodecBackend.{instanceAgnosticEvents as prvIae}
      
      // type EventInfo
      //    >: InstanceAgnosticEvent
      //    <: InstanceAgnosticEvent
      //    // = InstanceAgnosticEvent

   }

   /**
    * starts, decoding, or encoding,
    * as specified by `url` or `args1`
    * 
    * note - 
    * `flags` here might be incompatible with that of [[CodecTemplateOps#startC]]
    *
    * @param href 
    */
   def openUrlOrArgs(
      url: Null | (java.net.URI | java.net.URLConnection | DestibleFd1) ,
      args1: IndexedSeq[String] ,
   ) : Instance1AC
   
   /* the definitions needed to be split, to avoid compiler crash */
   // sealed 
   trait Instance1AC extends 
      AnyRef
      with java.io.Closeable 
      // TODO - 
      with CodecInstanceOps[template.type]
      with CodecInstanceOps.FromUrl1
   { thisCodecInstance =>
      
      val associatedCodec: template.type = template

      lazy val decodedFormO: Option[BbsdAvFrameIterator.OfRegOfHandlerForMediaKind[thisCodecBackend.mediaKindP.type ] ]
      
   }

   abstract 
   class Instance1() 
      extends 
      AnyRef
      with java.io.Closeable
      // blocked by the compiler crash
      // TODO - 
      // with CodecInstanceOps[template.type]
      // with CodecInstanceOps.FromUrl1
      with Instance1AC
   {

      override 
      lazy val events: Iterator[EventInfo] = 
         Iterator()

      def close() : Unit = {}
      
      override def toString(): String = 
         s"YyCodecRun(.....)@${hashCode }"
      
   }

}















