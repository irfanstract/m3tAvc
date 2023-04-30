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
{ this1 =>
   
      object template extends CodecTemplateOps :

         final val mimeType: mimeType1.type = mimeType1
         export EMediaKind.{Mix as mediaKind}

         type Instance >: Instance1 <: Instance1

         def matchesPreRead(src: ReadableBufferedSrc): Instance = 
            ???
            
         def startForUrl(
            href: java.net.URI, 
            flags: IndexedSeq[String] ,
         ): Instance = ???
         
         def startC(args: String*): Instance = ???
         
         // def startForOptions(options: CDO): Instance = ???
         
         override def hashCode(): Int = 
            3


      class Instance1() extends 
      AnyRef
      with java.io.Closeable
      // TODO
      // with CodecInstanceOps[template.type]
      // with CodecInstanceOps.FromUrl1
      {

         // val associatedCodec: template.type = template

         def close() : Unit = {}
         
      }

}

















