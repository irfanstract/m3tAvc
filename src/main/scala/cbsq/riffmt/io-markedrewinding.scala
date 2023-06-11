package cbsq.riffmt














import language.unsafeNulls /* due to the extended usage of non-Scala API(s) */




extension (inp: java.io.InputStream) {
   
   /**
    * 
    * a view of the `InputStream` as a lazily-evaluated *byte-chunks* list
    * 
    */
   @deprecated("experimental")
   // protected 
   def asLazyChunksList(

      chunkSize: => cbsq.FileSize = {
         import byteManipImplicitsC.*
         (0x2000).B
      } ,
      
   ) = ({
      import byteManipImplicitsC.*
      import byteManipImplicitsC.asBlob
      LazyList.unfold[EBR, cbsq.FileSize](0.B)({

         case pos0 =>
            val justRead = {
               /**
                * take bytes, as specified
                */
               inp.readNBytes(chunkSize.inBytes.toInt )
               .toIndexedSeq.asBlob
            }
            /**
             * 
             * ensure that the Seq ends when an 'l:0' item comes -
             * zero-length items indicate EOF
             * 
             */
            if (0.B < justRead.length) {
               //
               val pos1 = (
                  pos0 + justRead.length
               )
               Some((
                  (Range(pos0.inBytes.toInt, pos1.inBytes.toInt, 1 ) , justRead ) : EBR , 
                  pos1 ,
               ))
            } else {
               // EOF
               None
            }
            
      })
      /**
       * 
       * ensure that the Seq ends when an 'l:0' item comes -
       * as mentioned,
       * zero-length items indicate EOF
       * 
       */
      .takeWhile((e, b) => (
         0 < e.length
      ) )
   })

}

protected 
opaque type EBR
   <: (Range, cbsq.ByteBlob)
   = (Range, cbsq.ByteBlob)
// extension (r: EBR ) {
// }



@deprecatedInheritance("experimental")
trait IOMR
extends
AnyRef
with IOMR1
{


   // import Ordering.Implicits.*



   
      
   import byteManipImplicitsC.*





   extension (src : Seq[Byte]) {

      @deprecated("experimental")
      def toNewFd() = {
         new java.io.DataInputStream((
            new java.io.ByteArrayInputStream((
               src.toArray
            ))
         ))
      }

   }




   
   extension (inp: java.io.InputStream) {

      /**
       * 
       * a wrapper which can be *mark-and-reset*
       * 
       */
      def asMarkableStream() = {
         inp match {
            case inp : MarkableInputStreamImpl =>
               inp
            case _ =>
               new MarkableInputStreamImpl((
                  new java.io.BufferedInputStream((
                     inp
                  ), 0x100 )
               ))
         }
      }
      
   }

   /**
    * 
    * return
    * a `Closeable` whose
    * `close()`-call would *reset* the stream back to the *pos*
    * (except if another `close()`-call reset its *pos* to some earlier *pos*)
    * 
    */
   @deprecated
   def newMarkResetTurn(r: MarkableInputStreamImpl, s: Int) = {
      r.enmark()
   }

   /* INTERNAL */
   private
   class ERdl(inp: java.io.InputStream) {
      
      val loadedSize = {
         new java.util.concurrent.atomic.AtomicLong(0)
      }

      val payloadChunks = (
         inp.asLazyChunksList()
         .map[(Range, cbsq.ByteBlob)](<:<.refl)
         .tapEach((e, b) => {
            loadedSize set(e.`end` )
         })
      )

   }

   class MarkableInputStreamImpl(private val inp: java.io.InputStream) extends java.io.InputStream
   {

      private[MarkableInputStreamImpl]
      val rdl = ERdl(inp)
      
      export rdl.{payloadChunks}
      import rdl.loadedSize

      def getCurrentPos() = (
         stateVar.get()
         .pointerPos
      )

      def rewindToPos(expectedPos: cbsq.FileSize): Unit = {
            stateVar
            .updateAndGet({
               
               case state0 =>
                  val state1 = {
                     {
                        state0.copy(
                           pointerPos = (
                              math.min(expectedPos.inBytes, state0.pointerPos.inBytes )
                              .B
                           ) ,
                        )
                     }
                  }
                  state1

            })
      }

      /**
       * 
       * all `payloadChunks` items until the one which encloses `pos`
       * 
       */
      // private[MarkableInputStreamImpl]
      def getReadlUpToPos(pos: cbsq.FileSize) = (
            payloadChunks
            .takeWhile({
               case (r, b) =>
                  r.start.B <= pos
            })
      )

      private[MarkableInputStreamImpl]
      case class State(
         pointerPos: cbsq.FileSize ,
      )

      private[MarkableInputStreamImpl]
      val stateVar = {
         new java.util.concurrent.atomic.AtomicReference[State]((
            State(
               // allData = cbsq.ByteBlob(IndexedSeq() ) ,
               pointerPos = 0.B ,
            )
         ))
      }

      def read(): Int = {
         // throw java.io.IOException("must use the bulk variant")
         (1 : Int) match {

            // case v if (1 <= v ) =>
            //    val newPos = (
            //       stateVar
            //       .updateAndGet(s => s.copy(pointerPos = s.pointerPos.inBytes.`+`(1).B ) )
            //       .pointerPos
            //    )

            // works, yet very slow and hence not recommended
            case _ => 
               { val buf = new Array[Byte](1) ; read(buf) match { case v if (v <= 0) => -1 ; case v if (0 < v) => buf(0).toInt.&(0x0FF) } }
               
         }
      }

      override def read(b: Array[Byte]): Int = read(b, 0, b.length)
      
      // private 
      val payloadChunks1 = {
                  payloadChunks
                  .map((e, b) => b.byteValues )
      }

      // private 
      val payloadByteValues = {
         payloadChunks1
         /**
          * 
          * basing it on `.view` rather than `.iterator` -
          * trying to avoid potential hard-to-identify bugs (like "the Iterator is already consumed")
          * 
          */
         .view
         .flatten
      }

      override
      def read(buf: Array[Byte], bufOff: Int, len: Int): Int = {
         val currentPos = (
            getCurrentPos()
         )
         (1 : Int) match {

            case v if (1 <= v ) =>
               {
                  payloadByteValues
                  .drop(currentPos.inBytes.toInt )
                  .copyToArray(buf, bufOff, len)
               } match {
                  case intActually =>
                     ontintac(intActually = intActually)
               }

            case _ => 
               ({

                  getReadlUpToPos(currentPos )
                  .find({
                     case (r, b) =>
                        r.contains[Int](currentPos.inBytes.toInt )
                  })
               }) match {
                  
                  case Some((r, actuallyData )) =>
                     val intActually = (
                        actuallyData.byteValues
                        .drop(currentPos.inBytes.toInt - r.start)
                        .copyToArray(buf, bufOff, len)
                     )
                     ontintac(intActually = intActually)
                     
                  case None => 
                     -1

               }
               
         }
      }

      /**
       * 
       *
       * @param intActually - the return-value of the call to `read(b, off, len)` or `copyToArray(b, off, len)`
       * 
       */
      private[MarkableInputStreamImpl]
      def ontintac(intActually: Int): Int = {
               stateVar
               .updateAndGet(s0 => (
                  s0.copy(pointerPos = (s0.pointerPos.inBytes + intActually).B )
               ))
               (if (0 < intActually) intActually else -1 )
      }

      // TODO
      /**
       * 
       * return
       * a `Closeable` whose
       * `close()`-call would *reset* this `MarkableInputStream` back to the *pos*
       * (except if another `close()`-call reset this' *pos* to some earlier *pos*)
       * 
       */
      class enmark() extends AnyRef with java.io.Closeable 
      { thisEnmark =>

         /**
          * 
          * *pos* when this ctx was created
          * 
          */
         private 
         val initTimeBufPos = (
            getCurrentPos()
         )

         def close(): Unit = {
            if (shallLaterRewind) {
               rewindToPos(expectedPos = initTimeBufPos )
            }
         }

         def setShallReset(v: Boolean): Unit = {
            shallLaterRewind = v
            /* otherwise spurious behvs may arise */
            java.lang.invoke.VarHandle.fullFence()
         }

         var shallLaterRewind : Boolean = true

      }

   }

   extension (r: MarkableInputStreamImpl) {
      
   def isAtEof(
      tipSize: cbsq.FileSize  = 0x2.B,
      
   ) : Boolean = {
      require(0.B < tipSize, "'tipSize' can't be zero " )
      import cbsq.FileSize.*:
      try
         util.Using.resource((
            newMarkResetTurn(r, 4 * tipSize.inBytes.toInt )

         ))(_ => {
            /**
             * 
             * `DataInputStream.prototype.readByte()` can `throw` `EOFException`s, while
             * the base `InputStream` methods never do so
             * 
             */
            new java.io.DataInputStream(r)
               .readByte()
            false 
         } : false )

      catch {
         
         case z : java.io.EOFException  =>
            true

      }
   } : Boolean

   }
   



   //

}

trait IOMR1
{

   //

}

object IOMR1
{

   //
   
}
































































