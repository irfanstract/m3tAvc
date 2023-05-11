package cbsq.riffmt

import cbsq.riffmt.btmIndexedSeqBytesBlobbingImplicits.asBlob
















object btmFileSizeSuffixingImplicits {
   
   export cbsq.FileSize.{B, KB, MB, GB}

}

object btmIndexedSeqBytesBlobbingImplicits {
   
   extension (v: IndexedSeq[Byte]) {

      def asBlob : cbsq.ByteBlob = {
         cbsq.ByteBlob(v)
      }

   }

}

object btmBigIntBytesImplicits {
   
   extension (v: BigInt) {

      def bytes : IndexedSeq[Byte] = {
         v.toByteArray.toIndexedSeq
      }

   }

}

object btmBytesBitsImplicits {
   
   import btmFileSizeSuffixingImplicits.*

   import btmIndexedSeqBytesBlobbingImplicits.*

   import btmBigIntBytesImplicits.*

   extension (b: Byte) {
      
      inline
      def intBits8: IndexedSeq[Boolean] = {
         if (true) {
            collection.immutable.ArraySeq.tabulate[Boolean](0x8)(i => {
               val shDistanceInBits = (
                  0x8 + -(1 + i )
               )
               (
                  /** 
                   * the upcast to `Int` will make the padding `1`s, but 
                   * `shDistanceInBits` will not go up to `8`
                   *  */ 
                  ((b: Byte).toInt & (0x1 << shDistanceInBits ) )
                  != 0
               ): Boolean
            })
         } else {
            (
               (IndexedSeq[0 | 1 | 2 | 3 | 4 | 5 | 6 | 7](0, 1, 2, 3, 4, 5, 6, 7).reverse )
               .map((shDistanceInBits) => (
                  /** 
                   * the upcast to `Int` will make the padding `1`s, but 
                   * `shDistanceInBits` will not go up to `8`
                   *  */ 
                  ((b: Byte).toInt & (0x1 << shDistanceInBits ) )
                  != 0
               ): Boolean )
            )
         }
      }
   }

   extension [CC[A] <: collection.SeqOps[A, CC, CC[A] ] ](src: CC[Byte]) {

      def toBits: CC[Boolean] = (
         src
            .flatMap((v: Byte) => (
               v.intBits8
            ) )
      )

   }
   
   extension [CC[A] <: collection.SeqOps[A, CC, CC[A] ] ](src: CC[Boolean]) {

      def toBytes: CC[Byte] = (
         (1 : Int) match
            
            case 1 =>
               require((
                  !(src.isInstanceOf[LazyList[?]] || src.isInstanceOf[Iterator[?]] )
               ), "illegal usage of non-finite collection " )
               src
                  // PAD WITH '0's
                  .padTo[Boolean](((src.length : Double )./(0x8).ceil.`*`(0.8) ).toInt , false )
                  // CONVERT TO BIGINT
                  .foldLeft[BigInt](0)((cumul0: BigInt, beOn: Boolean) => (
                     (cumul0 << 1) | (if (beOn) 1 else 0 )
                  ))
                  // CONVERT TO BYTE-ARRAY
                  .toByteArray.to(src.iterableFactory)
               
            case _ =>
               src
                  .grouped(0x8 ).to(src.iterableFactory )
                  .map(bits => (
                     bits.foldLeft[Int](0)({ case (s0, v1) => ((s0 << 1) | (if (v1) 0x1 else 0 ) ) })
                     .toByte
                  ): Byte )
         
         //
      )

   }
      
   implicit def eib[CC[A] <: collection.SeqOps[A, CC, CC[A] ] ](src: CC[Byte]): (
      AnyRef
      & I0LdB[CC[Byte] ]
   ) = {
      (
         new 
         AnyRef with Selectable 
         with I0LdB[CC[Byte] ]
         {
            
            def withFirstNBitsTurned(zlbN: Int, newV: Boolean): CC[Byte] = {
               src
                  // EXPAND INTO BIT-SEQ
                  .toBits
                  // REPLACE THESE N BITS
                  .drop(zlbN )
                  .prependedAll(IndexedSeq.fill[Boolean](zlbN )(newV: Boolean) )
                  // CONVERT INTO BYTE-SEQ
                  .toBytes
            }

         }
      )
   }
   trait I0LdB[+R] {
      def withFirstNBitsTurned(n: Int, v: Boolean): R
   }

}

object CStdPrimitiveTypeMarshalling {
   


   opaque type OctetReadingOp[+C] 
      <: (src: java.io.DataInput) => C
      = (src: java.io.DataInput) => C

   given OctetReadingOp[Unit   ] = { case _ => () /* nothing to read */ }

   given OctetReadingOp[Byte   ] = _.readByte()
   given OctetReadingOp[Short  ] = _.readShort()
   given OctetReadingOp[Int    ] = _.readInt()
   given OctetReadingOp[Long   ] = _.readLong()
   given OctetReadingOp[Float  ] = _.readFloat()
   given OctetReadingOp[Double ] = _.readDouble()
   


   opaque type OctetWritedownOp[C] 
      <: (src: java.io.DataOutput, v: C) => Unit
      = (src: java.io.DataOutput, v: C) => Unit

   given OctetWritedownOp[Unit   ] = { case _ => /* nothing to write */ }

   given OctetWritedownOp[Byte   ] = _.writeByte(_)
   given OctetWritedownOp[Short  ] = _.writeShort(_)
   given OctetWritedownOp[Int    ] = _.writeInt(_)
   given OctetWritedownOp[Long   ] = _.writeLong(_)
   given OctetWritedownOp[Float  ] = ((o, v) => o.writeInt(java.lang.Float.floatToRawIntBits(v) ) )
   given OctetWritedownOp[Double ] = ((o, v) => o.writeLong(java.lang.Double.doubleToRawLongBits(v) ) )

   

}

trait ByteManipImplicitsReExports {

   export byteManipImplicits.*

}

object byteManipImplicits {




   
   export btmFileSizeSuffixingImplicits.*

   export btmIndexedSeqBytesBlobbingImplicits.*




   export btmBigIntBytesImplicits.*

   export btmBytesBitsImplicits.*




   
   export CStdPrimitiveTypeMarshalling.{OctetReadingOp, OctetWritedownOp }

   extension (r: java.io.DataInput) {

      /**
       * 
       * read n bytes
       * 
       * name has "Sc" at-the-end to avoid clash with one in `java.io.InputStream`
       * 
       */
      def readNBytesSc(length: Int): IndexedSeq[Byte] = (
         // collection.immutable.ArraySeq.fill(length)(r.readByte() /* can throw EOFException */ )
         locally {
            Range(0, length)
            .grouped(0x8000 )
            .iterator
            .map(range => {
               val buf = new Array[Byte](range.length )
               r readFully buf /* can throw EOFException */
               collection.immutable.ArraySeq.unsafeWrapArray(buf)
            })
            .flatten
            .toArray.toIndexedSeq
         }
      )
      
      /**
       * 
       * read bytes up-to the byte satisfying the cond
       * 
       */
      def readUpToCond(p: Byte => Boolean) = {
         val s = (
            r.newByteSeq()
         )
         (s take (s indexWhere p) )
         .toIndexedSeq
      }

   }

   extension (r: java.io.DataInput) {
   
      /**
       * 
       * a new `LazyList` which takes from the `DataInput` .
       * necessary for convenient interoperability with the rest of `collection.*`.
       * prone to race-condition obvious due to having multiple such instances
       * (as only one of them will win !)
       * 
       */
      @deprecated
      def newByteSeq(): LazyList[Byte] = 
         LazyList.continually[Byte](r.readByte() )
         
   }




   
   extension (src : Seq[Byte]) {

      def toNewFd() = {
         new java.io.DataInputStream((
            new java.io.ByteArrayInputStream((
               src.toArray
            ))
         ))
      }

   }




   
   def newMarkResetTurn(r: MarkableInputStreamImpl, s: Int) = {
      r.enmark()
   }
   // /**
   //  * 
   //  * `newMarkResetTurn`
   //  * 
   //  * BROKEN - nested usages will break - FIXME
   //  *
   //  * @param s the `int` argument to the `r.mark(...)` call
   //  * 
   //  */
   // @annotation.experimental
   // class newMarkResetTurn(r: java.io.InputStream, s: Int) extends AnyRef with Selectable with java.io.Closeable {
   //    r mark(s)
      
   //    private 
   //    val aShallReset = new java.util.concurrent.atomic.AtomicBoolean(true )
   
   //    private 
   //    lazy val ensureClosed = { if (aShallReset.get()) r.reset() }
   //    override
   //    def close(): Unit = ensureClosed
   //    override
   //    def finalize() = ensureClosed
      
   //    def setShallReset(v: Boolean): Unit = { aShallReset set(v) }


   // }

   // TODO
   type UnpickleInputStream
      >: MarkableInputStreamImpl
      <: MarkableInputStreamImpl

   extension (inp: java.io.InputStream) {
      def asSicingStream() = {
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

   private
   def toLazyListEc(inp: java.io.InputStream) = (
      LazyList.unfold[EBR, cbsq.FileSize](0.B)({
         case pos0 =>
            val b = (
               inp.readNBytes(0x2000)
               .toIndexedSeq
               .asBlob
            )
            if (0 < b.length.bytes) {
               //
               val pos1 = (
                  pos0.bytes + b.length.bytes
               )
               Some(((Range(pos0.bytes.toInt, pos1.toInt, 1 ) , b ), pos1.B))
            } else {
               // EOF
               None
            }
      })
      .takeWhile((e, b) => (
         0 < e.length
      ) )
   )

   protected 
   opaque type EBR = (Range, cbsq.ByteBlob)
   // extension (r: EBR ) {
   // }

   class MarkableInputStreamImpl(private val inp: java.io.InputStream) extends java.io.InputStream
   {

      private[MarkableInputStreamImpl]
      var loadedSize = {
         new java.util.concurrent.atomic.AtomicLong(0)
      }

      private[MarkableInputStreamImpl]
      val readl = (
         toLazyListEc(inp = inp )
         .tapEach((e, b) => {
            loadedSize set(e.`end` )
         })
      )

      private[MarkableInputStreamImpl]
      case class State(
         pointerPos: cbsq.FileSize ,
      )

      private[MarkableInputStreamImpl]
      val buffer = {
         new java.util.concurrent.atomic.AtomicReference[State]((
            State(
               // allData = cbsq.ByteBlob(IndexedSeq() ) ,
               pointerPos = 0.B ,
            )
         ))
      }

      def getCurrentPos() = (
         buffer.get()
         .pointerPos
      )

      private 
      def getReadlUpToPos(pos: cbsq.FileSize) = (
            readl
            .takeWhile({
               case (r, b) =>
                  r.start <= pos.bytes
            })
      )

      def read(): Int = {
         // throw java.io.IOException("must use the bulk variant")
         (1 : Int) match {

            // case v if (1 <= v ) =>
            //    val newPos = (
            //       buffer
            //       .updateAndGet(s => s.copy(pointerPos = s.pointerPos.bytes.`+`(1).B ) )
            //       .pointerPos
            //    )

            // works, yet very slow and hence not recommended
            case _ => 
               { val buf = new Array[Byte](1) ; read(buf) match { case v if (v <= 0) => -1 ; case v if (0 < v) => buf(0).toInt.&(0x0FF) } }
               
         }
      }

      override def read(b: Array[Byte]): Int = read(b, 0, b.length)
      
      private 
      val readlFLattened = {
                  readl
                  .map((e, b) => b.byteValues )
      }

      override
      def read(buf: Array[Byte], bufOff: Int, len: Int): Int = {
         val currentPos = (
            getCurrentPos()
         )
         (1 : Int) match {

            case v if (1 <= v ) =>
               {
                  readlFLattened
                  .iterator
                  .flatten
                  .drop(currentPos.bytes.toInt )
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
                        r.contains[Int](currentPos.bytes.toInt )
                  })
               }) match {
                  
                  case Some((r, actuallyData )) =>
                     val intActually = (
                        actuallyData.byteValues
                        .drop(currentPos.bytes.toInt - r.start)
                        .copyToArray(buf, bufOff, len)
                     )
                     ontintac(intActually = intActually)
                     
                  case None => 
                     -1

               }
               
         }
      }

      private[MarkableInputStreamImpl]
      def ontintac(intActually: Int): Int = {
               buffer
               .updateAndGet(s0 => (
                  s0.copy(pointerPos = (s0.pointerPos.bytes + intActually).B )
               ))
               (if (0 < intActually) intActually else -1 )
      }

      // TODO
      class enmark() extends AnyRef with java.io.Closeable 
      { thisEnmark =>

         var shallLaterRewind : Boolean = true

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
            buffer
            .updateAndGet({
               case s =>
                  if (shallLaterRewind) {
                     s.copy(pointerPos = math.min(initTimeBufPos.bytes, s.pointerPos.bytes ).B )
                  } else s
            })
         }

         def setShallReset(v: Boolean): Unit = {
            shallLaterRewind = v
            /* otherwise spurious behvs may arise */
            java.lang.invoke.VarHandle.fullFence()
         }

      }

   }
   
   def isAtEof(
      r: MarkableInputStreamImpl,
      lookaheadLimit: Int , /* 20 * 1024 * 1024 */
      tipSize: cbsq.FileSize  = 0x2.B,
   ) : Boolean = {
      if (lookaheadLimit < tipSize.bytes) {
         throw java.io.IOException(s"lookaheadLimit < tipSize.bytes")
      }
      try
         util.Using.resource((
            // TODO 
            newMarkResetTurn(r, lookaheadLimit )
         ))(_ => {
            // r readNBytes(tipSize.bytes.toInt )
            new java.io.DataInputStream(r)
            .readByte()
            false 
         } : false )

      catch {
         
         case z : java.io.EOFException  =>
            true

      }
   } : Boolean

   extension [Return1](f: (dest: java.io.DataOutputStream) => Return1) {

      def testifyOutput() : cbsq.ByteBlob = {
         val r1 = new java.io.ByteArrayOutputStream
         locally {
            val r0 = java.io.DataOutputStream(r1)
            f(r0 )
            r0.flush()
         }
         cbsq.ByteBlob.copyOf(r1 )
      }
      
   }





}




















