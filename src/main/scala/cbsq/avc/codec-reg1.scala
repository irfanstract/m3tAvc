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

// /**
//  * 
//  * a *demuxer* which *consumes all input* yet does not output any *frame*.
//  * 
//  */
// @annotation.experimental
// lazy val nullOutputDemuxer: (
//    CodecTemplateOps {
//       val mediaKind: EMediaKind.Mix.type 
//    }
// ) =
//    bbsd(
//       mimeType1 = "application/x-lavfzeroframedemux" ,
//    )

protected 
sealed trait  BbsdZcdImpl(val mimeType1: String) 
{ this10 =>

   type InstanceAgnosticEvent <: (
      AnyRef 
      & Product
   )
   lazy val instanceAgnosticEvents : Iterator[InstanceAgnosticEvent] =
      Iterator()

   type RelevantFd <: java.io.Closeable
   
   type DestibleFd1
      >: ioUtil.AsBuffered[RelevantFd ]
      <: RelevantFd
   
   object template extends 
      CodecTemplateOps 
      // with WithIae
   {
    
      this1 =>

      override 
      lazy val events: Iterator[EventInfo] = 
         this10.instanceAgnosticEvents
      type EventInfo
         // >: InstanceAgnosticEvent
         // <: InstanceAgnosticEvent
         = InstanceAgnosticEvent

      final val mimeType: mimeType1.type = mimeType1
      export EMediaKind.{Mix as mediaKind}

      type Rd >: this10.RelevantFd <: this10.RelevantFd

      type Instance 
         >: this10.Instance1AC 
         <: this10.Instance1AC

      /**
       * 
       */
      type DestibleFd
         >: this10.DestibleFd1
         <: this10.DestibleFd1

      def startForFd(src: DestibleFd): Instance = 
         ???
         
      def startForUrl(
         href: java.net.URI, 
         flags: IndexedSeq[String] ,
      ): Instance = ???
      
      def startC(args: String*): Instance = ???
      
      // def startForOptions(options: CDO): Instance = ???
      
      override def hashCode(): Int = 
         3
  
   }

   /* the definitions needed to be split, to avoid compiler crash */
   // sealed 
   trait Instance1AC extends 
      AnyRef
      with java.io.Closeable 
      // TODO - 
      with CodecInstanceOps[template.type]
      with CodecInstanceOps.FromUrl1
   { this1 =>
   }

   class Instance1() extends 
   AnyRef
   with java.io.Closeable
   // blocked by the compiler crash
   // TODO - 
   // with CodecInstanceOps[template.type]
   // with CodecInstanceOps.FromUrl1
   with Instance1AC
   {

      val associatedCodec: template.type = template
      
      override 
      lazy val events: Iterator[EventInfo] = 
         Iterator()

      def close() : Unit = {}
      
   }

}

















