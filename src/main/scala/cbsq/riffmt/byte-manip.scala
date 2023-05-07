package cbsq.riffmt
















object byteManipImplicits {



   
   export cbsq.FileSize.B




   extension (v: BigInt) {

      def bytes : IndexedSeq[Byte] = {
         v.toByteArray.toIndexedSeq
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

   extension (r: java.io.DataInput) {

      /**
       * 
       * read n bytes
       * 
       * name has "Sc" at-the-end to avoid clash with one in `java.io.InputStream`
       * 
       */
      def readNBytesSc(length: Int): IndexedSeq[Byte] = (
         collection.immutable.ArraySeq.fill(length)(r.readByte() )
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
       * the bytes in sequence.
       * lazy.
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





}




















