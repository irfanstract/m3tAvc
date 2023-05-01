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

def dcdTest1(): BbsdCodecInstantiale["application/x-lavfmt-discarddemux", EMediaKind.Mix.type, ?] = {
   (new BbsdCodecInstantiale(
      mimeType1 = "application/x-lavfmt-discarddemux" ,
      mediaKindP = EMediaKind.Mix ,
      openUrlOrArgs1 = (thisCodecInstantiable) => {
         new Ctpr 
         { this1 =>

            type Rd
               >: thisCodecInstantiable.Rd
               <: thisCodecInstantiable.Rd
            
            type DestibleFd
               >: (ioUtil.AsBuffered[this1.Rd ] & this1.Rd)
               <: this1.Rd
               
            def startC(flags: Seq[String]): Instance = 
               throw UnsupportedOperationException(s"TODO ; args being $flags")
            def startForFd(src: DestibleFd): false | Instance = 
               throw UnsupportedOperationException(s"TODO ; input being $src")
            def startForUrl(href: java.net.URI, flags: IndexedSeq[String]): Instance = 
               startC(Seq() :+ ("--src-url=" + href.toASCIIString() ) :++ flags )

            final val mediaKind = EMediaKind.Mix : EMediaKind.Mix.type

         }
      } ,
   ) {
      
      type Rd 
         >: java.io.InputStream
         <: java.io.InputStream

      override def toString(): String = 
         "DcdtDUmmyCodecTest(....)"
      
   } )
}

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















