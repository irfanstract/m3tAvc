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

type Dsd = (
   // BbsdCodecInstantiable1["application/x-lavfmt-discarddemux", EMediaKind.Mix.type, ?]
   BbsdCodecInstantiable1.CompleteOps1[?]
)

object BbsdCodecInstantiable1
{

   type WithStreamForm[S <: java.io.Closeable] = (
      Ctpr {
         type Rd >: S <: S
      }
   )
   
   /**
    * 
    * a mixin for [[CodecTemplateOps]] which 
    * - widens `this.Instance`'s lower-bound
    * 
    */
   trait ::! extends 
      Ctpr
   { thisCodecInstantiable : CodecTemplateOps =>

      type Instance
         >: CodecInstanceOps[thisCodecInstantiable.type]
         <: CodecInstanceOps[thisCodecInstantiable.type]
      
   }
   
   /**
    * 
    * a factory for the impl of [[Ctpr]].
    * 
    * in general `thisCodecInstantiable` will still be under construction, so
    * the returned peer *should* avoid making calls to its methods
    * 
    */
   type Tci[Receiver1 <: TciReceiverOps] = (
      
      (thisCodecInstantiable: (
         Receiver1
      ) ) => (

         Ctpr 

         /* since `Ctpr` has *this-type* `CodecOverview` and therefore required to override all these methods */
         & (CodecOverview {
            val mimeType  : thisCodecInstantiable.mimeType.type
            val mediaKind : thisCodecInstantiable.mediaKind.type
         })
         
         /* reiterate */
         & Ctpr

         {

            type Rd 
               >: thisCodecInstantiable.Rd
               <: thisCodecInstantiable.Rd

            type DestibleFd
               >: ioUtil.AsBuffered[thisCodecInstantiable.Rd ] & thisCodecInstantiable.Rd
               <: thisCodecInstantiable.Rd

            type Instance 
               <: thisCodecInstantiable.Instance

         }

      )
      
   )

   type TciReceiverOps
         >: Tcir1
         <: Tcir1
   private 
   type Tcir1 = (
      CodecProperties & CodecTemplateOps & BbsdCodecInstantiable1.::!
   )

   // sealed 
   trait WithInstantiator[R <: TciReceiverOps](
      
      private[BbsdCodecInstantiable1 ]
      val instantiator1 : (
         BbsdCodecInstantiable1.Tci[R]
      ) ,
      
   ) extends 
      AnyRef
      with CodecPropertiesMixin 
      with CodecTemplateOps 
      with BbsdCodecInstantiable1.::!
   { thisCodecInstantiable: R =>
      
      private[BbsdCodecInstantiable1]  
      // lazy
      val oua = (
         instantiator1(thisCodecInstantiable)
      )  

      summon[oua.Rd =:= Rd]
      
      /**
       * 
       */
      type DestibleFd
         >: oua.DestibleFd
         <: oua.DestibleFd
         
      summon[oua.DestibleFd =:= DestibleFd]

      export oua.{startC, startForFd, startForUrl }

   }

   sealed trait CompleteOps1[
      +R <: (
         TciReceiverOps
      ) ,
   ] extends 
      AnyRef 
      with CodecOverview
      with CodecTemplateOps
      with BbsdCodecInstantiable1.::!
      with BbsdCodecInstantiable1.WithInstantiator[? <: R]
   { this : R => }
   
}
// @deprecated("experimental")
// protected 
sealed trait  BbsdCodecInstantiable1[
   +R <: BbsdCodecInstantiable1.TciReceiverOps ,
   +SpecificMimeType  <: (Singleton & String     ) ,
   +SpecificMediaKind <: (Singleton & EMediaKind ) ,
   +InstanceAgnosticEvent <: AnyRef & Product ,
](
   
   val mimeType   : (SpecificMimeType  ) ,
   val mediaKind  : (SpecificMediaKind ) ,

   // private[BbsdCodecInstantiable1 ]
   // val 
   // instantiator1 : (
   //    BbsdCodecInstantiable1.Tci[(
   //    Singleton & BbsdCodecInstantiable1.TciReceiverOps
   //    )]
   // ) ,

   iaeProto      : () => Option[InstanceAgnosticEvent] = (
      (() => None)
   ) ,
   xrTypeCorrect : () => Option[R] = (
      (() => None) : (() => Option[BbsdCodecInstantiable1.TciReceiverOps])
   ) ,

) extends 
   AnyRef 
   // with CodecOverview
   // with CodecTemplateOps
   // with BbsdCodecInstantiable1.::!
   // with BbsdCodecInstantiable1.WithInstantiator[R]
   // // (instantiator1 = instantiator1)
   with BbsdCodecInstantiable1.CompleteOps1[R]
{ thisCodecInstantiable: R =>

   /**
    * behind discretion, may support firing of events
    */
   lazy val instanceAgnosticEvents : Iterator[EventInfo] =
      Iterator()

   // private 
   // lazy val eeEhInstoev = (
   //    ([A <: Singleton] => (v: A) => Some(v : v.type) ).apply(instanceAgnosticEvents)
   // )
   // private 
   // lazy val eeEhInstoev: instanceAgnosticEvents.type = (
   //    instanceAgnosticEvents
   // )

   // type Rd <: java.io.Closeable
   // export oua.Rd
   type Rd <: java.io.Closeable
   
   // /**
   //  * 
   //  * expected by [[CodecTemplateOps ]]
   //  * 
   //  */
   // private[BbsdCodecInstantiable1]
   // type DestibleFd1
   //    >: ioUtil.AsBuffered[thisCodecInstantiable.Rd ]
   //    <: thisCodecInstantiable.Rd

}

def dcdTest1() = {
   blankingDemuxer

   implicitly[(java.io.InputStream          ) <:< (blankingDemuxer.Rd             )]
   implicitly[(java.io.BufferedInputStream  ) <:< (blankingDemuxer.DestibleFd     )]
   implicitly[(java.io.BufferedReader       ) <:< (blankingTxtDemuxer.DestibleFd  )]
   
   implicitly[(blankingDemuxer.Rd          ) =:= (java.io.InputStream    )]
   implicitly[(blankingDemuxer.DestibleFd  ) <:< (blankingDemuxer.Rd     )]
}

private
def blankingDemuxerImpl[XReader <: java.io.InputStream | java.io.Reader] = {
   def newPseudoHandle(
      thisCodecInstantiable: CodecProperties & CodecTemplateOps ,
      message: => String ,
   ) = {
      new AnyRef with CodecInstanceOps[thisCodecInstantiable.type]
      {

         val associatedCodec = thisCodecInstantiable
         
         lazy val events = Iterator()

         override def close(): Unit = {}

         override def toString(): String = 
            "BlankingDemuxingProcess(....)"

      }
   }
   def consumeAndDiscarding(src: java.io.Closeable): Unit = {
      import scala.jdk.StreamConverters.*
      import scala.jdk.CollectionConverters.*
      src match
         case s : java.io.InputStream    => s.readAllBytes()
         case s : java.io.BufferedReader => s.lines().forEach(_ => {})
      
      /* for end-user usability, needs to make it named this way */ 
      object SRAE extends RuntimeException(s"successfully read all bytes/chars from the input")
      SRAE.printStackTrace()
      ()
   }
   (new BbsdCodecInstantiable1(

      mimeType  = "application/x-scalavfmt-blankingdemux" ,
      mediaKind = EMediaKind.Mix ,

      // xrTypeCorrect = (_ : BbsdCodecInstantiable1.TciReceiverOps) => {} ,

   )
   with BbsdCodecInstantiable1.WithInstantiator(
      
      instantiator1 = (thisCodecInstantiable) => {
         new Ctpr with CodecOverview 
         { this1 =>

            export thisCodecInstantiable.mimeType

            // val mediaKind = EMediaKind.Mix : EMediaKind.Mix.type
            export thisCodecInstantiable.mediaKind

            type Rd
               >: thisCodecInstantiable.Rd
               <: thisCodecInstantiable.Rd
            
            type DestibleFd
               >: (ioUtil.AsBuffered[this1.Rd ] & this1.Rd)
               <: this1.Rd
               
            def startC(flags: Seq[String]): Instance = 
               newPseudoHandle(thisCodecInstantiable, s"TODO ; args being $flags") 
               
            def startForFd(src: DestibleFd): false | Instance = 
               new Thread(() => {
                  consumeAndDiscarding(src = src )
               })
               .start()
               newPseudoHandle(thisCodecInstantiable, s"TODO ; input being $src") 

            def startForUrl(href: java.net.URI, flags: IndexedSeq[String]): Instance = 
               startC(Seq() :+ ("--src-url=" + href.toASCIIString() ) :++ flags )

            type Instance 
                >: thisCodecInstantiable.Instance
                <: thisCodecInstantiable.Instance

         }
      } ,

   )
   {
      
      type Rd 
         >: XReader
         <: XReader

      override def toString(): String = 
         "BlankingDemuxer(....)"

   } )
}
lazy val blankingDemuxer =
   blankingDemuxerImpl[java.io.InputStream]
lazy val blankingTxtDemuxer =
   blankingDemuxerImpl[java.io.Reader]

object &&&&!%@ {

   @main
   def main(args : String* ): Unit =
      blankingDemuxer
      /* will result in a stack-trace */
      .startForFd(src = (
         new java.io.BufferedInputStream((
            new java.io.ByteArrayInputStream(Array.emptyByteArray )
         ))
      ) )
      /* will reach here */
      sys.process.stderr println "OK"

}















