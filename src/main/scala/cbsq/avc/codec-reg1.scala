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

type Dsd = BbsdCodecInstantiale["application/x-lavfmt-discarddemux", EMediaKind.Mix.type, ?]

// @deprecated("experimental")
// protected 
sealed trait  BbsdCodecInstantiale[
   +SpecificMimeType  <: (Singleton & String     ) ,
   +SpecificMediaKind <: (Singleton & EMediaKind ) ,
   +InstanceAgnosticEvent <: AnyRef & Product ,
](
   
   val mimeType1  : (SpecificMimeType  ) ,
   val mediaKindP : (SpecificMediaKind ) ,

   val openUrlOrArgs1 : (
      (thisCodecInstantiable: CodecProperties ) => (
          Ctpr {
            type Rd 
               >: thisCodecInstantiable.Rd
               <: thisCodecInstantiable.Rd
         }
         // Ctpr
      )
   ) ,

) extends 
   AnyRef 
   with CodecOverview
{ thisCodecInstantiable =>

   /**
    * behind discretion, may support firing of events
    */
   lazy val instanceAgnosticEvents : Iterator[InstanceAgnosticEvent] =
      Iterator()

   final val mimeType: mimeType1.type = 
      mimeType1
   
   // export EMediaKind.{Mix as mediaKind}
   val mediaKind : mediaKindP.type =
      mediaKindP

   /**
    * 
    * expected by [[CodecTemplateOps ]]
    * 
    */
   private[BbsdCodecInstantiale]
   type DestibleFd1
      >: ioUtil.AsBuffered[thisCodecInstantiable.Rd ]
      <: thisCodecInstantiable.Rd

   private[BbsdCodecInstantiale]  
   // lazy
   val oua = (
      openUrlOrArgs1(thisCodecInstantiable)
   )
   
   // type Rd <: java.io.Closeable
   // export oua.Rd
   type Rd <: java.io.Closeable
   
   export oua.{startC, startForFd, startForUrl }

      /**
       * 
       */
      type DestibleFd
         >: thisCodecInstantiable.DestibleFd1
         <: thisCodecInstantiable.DestibleFd1

}















