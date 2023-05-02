package cbsq.avc












// import MediaKind as EMediaKind









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
    * - widens `this.Instance`'s lower-bound this way
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
    * a factory for, given a [[CodecTemplateOps]], the impl of [[Ctpr]].
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

   /**
    * 
    * the type which 
    * every type used in [[Tci]] shall `extends`
    * 
    */
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
      with CodecTemplateOpsMixin 
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

   sealed 
   trait CompleteOps1[
      +R <: (
         TciReceiverOps
      ) ,
   ] extends 
      AnyRef 
      with CodecOverview
      with CodecTemplateOpsMixin
      with BbsdCodecInstantiable1.::!
      with BbsdCodecInstantiable1.WithInstantiator[? <: R]
   { this : R => }

   /**
    * 
    * a mixin to 
    * help properly implementing 
    * the interface which every `instantiator` shall return
    *
    */
   trait Wir[+C <: Singleton & TciReceiverOps](
      private[Wir]
      // private
      val thisCodecInstantiable1 : C ,
   ) extends 
      Ctpr 
      with CodecOverview 
   { this1 => 

      import thisCodecInstantiable1 as thisCodecInstantiable
      
      export thisCodecInstantiable.mimeType

      export thisCodecInstantiable.mediaKind

      type Instance 
            >: thisCodecInstantiable.Instance
            <: thisCodecInstantiable.Instance

      type Rd
         >: thisCodecInstantiable.Rd
         <: thisCodecInstantiable.Rd
      
      type DestibleFd
         >: (ioUtil.AsBuffered[this1.Rd ] & this1.Rd)
         <: this1.Rd

      // @deprecated
      // protected 
      // val ipr = thisCodecInstantiable1
         
   }
   
}
/**
 * 
 * `extends`ing the necessary `trait`s,
 * this `trait` 
 * defines the necessary specialisations of the inherited stuffs
 * to serve as a well-behaving subclass of [[CodecTemplateOps]]
 * 
 *
 * @param xrTypeCorrect - to correct the inference of [[R]]
 * @param mimeType
 * @param mediaKind
 * @param iaeProto      - to correct the inference of [[InstanceAgnosticEvent]]
 * @param xrRdFix       - to correct the inference of [[XRd]]
 * 
  */
@deprecated("experimental")
// protected 
// sealed 
trait  BbsdCodecInstantiable1[
   +R <: BbsdCodecInstantiable1.TciReceiverOps ,
   +InstanceAgnosticEvent <: AnyRef & Product ,
   +SpecificMimeType  <: (Singleton & String     ) ,
   +SpecificMediaKind <: (Singleton & EMediaKind ) ,
   XRd <: java.io.Closeable ,
](
   
   xrTypeCorrect : () => Option[R] = (
      (() => None) : (() => Option[BbsdCodecInstantiable1.TciReceiverOps])
   ) ,

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
   
   xrRdFix: (v: Option[XRd]) => Option[XRd] ,
   
) extends 
   AnyRef 
   with BbsdCodecInstantiable1.CompleteOps1[R]
{ thisCodecInstantiable: R =>

   /**
    * behind discretion, may support firing of events
    */
   lazy val instanceAgnosticEvents : Iterator[EventInfo] =
      Iterator()

   type Rd 
      >: XRd
      <: XRd
   
}

def dcdTest1() = {
   blankingDemuxer

   implicitly[(java.io.InputStream          ) <:< (blankingDemuxer.Rd             )]
   implicitly[(java.io.BufferedInputStream  ) <:< (blankingDemuxer.DestibleFd     )]
   implicitly[(java.io.BufferedReader       ) <:< (blankingTxtDemuxer.DestibleFd  )]
   
   implicitly[(blankingDemuxer.Rd          ) =:= (java.io.InputStream    )]
   implicitly[(blankingDemuxer.DestibleFd  ) <:< (blankingDemuxer.Rd     )]
}

/**
 * 
 * a demuxer which 
 * consumes all input yet 
 * does not output any frame
 * 
 */
private
def blankingDemuxerImpl[
   XReader <: java.io.InputStream | java.io.Reader ,
]() = {
   def newPseudoHandle(
      thisCodecInstantiable: CodecProperties & CodecTemplateOps ,
      message: => String ,
   ) = {
      new AnyRef with CodecInstanceOpsMixin[thisCodecInstantiable.type]
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

      xrRdFix = identity[Option[XReader] ] _ ,

      // xrTypeCorrect = (_ : BbsdCodecInstantiable1.TciReceiverOps) => {} ,

   )
   with BbsdCodecInstantiable1.WithInstantiator(
      
      instantiator1 = (thisCodecInstantiable) => {
         new Ctpr 
         with CodecOverview 
         with BbsdCodecInstantiable1.Wir(thisCodecInstantiable1 = thisCodecInstantiable)
         { this1 =>

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

            type Rd
               >: thisCodecInstantiable.Rd
               <: thisCodecInstantiable.Rd

            // implicitly[ipr.type <:< thisCodecInstantiable.type ]
            // implicitly[ipr.type =:= thisCodecInstantiable.type ]

         }
      } ,

   )
   {
      
      override def toString(): String = 
         "BlankingDemuxer(....)"

   } )
}

/**
 * 
 * a demuxer which 
 * consumes all bytes from the input yet 
 * does not output any frame
 * 
 * @see [[blankingTxtDemuxer]]
 * 
 */
lazy val blankingDemuxer =
   blankingDemuxerImpl[java.io.InputStream]()
/**
 * 
 * a demuxer which 
 * consumes all from the UTF input yet 
 * does not output any frame
 * 
 * @see [[blankingDemuxer]]
 * 
 */
lazy val blankingTxtDemuxer =
   blankingDemuxerImpl[java.io.Reader]()






object &&&&!%@ 
{

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















