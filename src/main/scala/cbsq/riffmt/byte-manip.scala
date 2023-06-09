package cbsq.riffmt

















object btmBigIntBytesImplicits {
   
   extension (v: BigInt) {

      /**
       * 
       * its bytes, from the MSB to the LSB
       * 
       */
      def bytes : IndexedSeq[Byte] = {
         v.toByteArray.toIndexedSeq
      }

   }

}

/**
 * 
 * facilities for
 * converting a byte-array into a bit-array and back
 * 
 */
object btmBytesBitsImplicits {
   
   import cbsq.FileSize.boxingImplicits.*

   import cbsq.Bytes.boxingImplicits.*

   import btmBigIntBytesImplicits.*

   extension (b: Byte) {
      
      /**
       * 
       * its eight bits, from the MSb to the LSb
       * 
       */
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

      /**
       * 
       * its bits,
       * in order,
       * each from the MSb to the LSb
       * 
       */
      def toBits: CC[Boolean] = (
         src
            .flatMap((v: Byte) => (
               v.intBits8
            ) )
      )

   }
   
   extension [CC[A] <: collection.SeqOps[A, CC, CC[A] ] ](src: CC[Boolean]) {

      /**
       * 
       * the inverse of `toBits`
       * 
       */
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

/** 
 * 
 * *byte-manip* `implicit`s
 * 
 * only one step towards the main frontend ;
 * chosen to introduce this `namespace` for importing by `io-markrewinding.scala`
 * 
 */
object byteManipImplicitsC {





   export cbsq.FileSize.boxingImplicits.*

   export cbsq.Bytes.boxingImplicits.*




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
         /**
          * 
          * for small `length` use simple `IndexedSeq.fill(length)(readByte() )` ;
          * for large `length` use chunking ;
          * 
          */
         if length < 0x80 then {
            collection.immutable.ArraySeq.fill(length)(r.readByte() /* can throw EOFException */ )
         } else {
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

   /**
    * 
    * read n bytes
    * 
    * name has "EbmSc" at-the-end to avoid clash with one in `java.io.InputStream`
    * 
    */
   extension (r: java.io.InputStream | java.io.DataInput) {
      
      def readNBytesEbmSc(supposedReadingLength: Int) : IndexedSeq[Byte] = {
                  ;

                  import language.unsafeNulls
                  
                  (r match {

                     case r : java.io.InputStream =>
                        r readNBytes(supposedReadingLength )
                        
                     case r : java.io.DataInput =>
                        val buf = new Array[Byte](supposedReadingLength )
                        r readFully(buf )
                        buf

                  })
                  match { case s => collection.immutable.ArraySeq.unsafeWrapArray(s) }

      }

   }

   extension (r: java.io.InputStream | java.io.DataInput ) {

      /**
       * 
       * 
       * 
       */
      def readNBytesScIncremLl(
         n: Int ,
         chunkSize : Int = 1024 ,

      ) : LazyList[IndexedSeq[Byte] ] = {

         Range(0, n, 1)
         .grouped(chunkSize )
         .map(_.length )
         .map((len : Int ) => {
            r.readNBytesEbmSc(len )
         })
         .to(LazyList)
         
      }

   }

   extension (r: java.io.InputStream ) {

      /**
       * 
       * 
       * 
       */
      def readAllBytesScIncremLl(
         //
         
         param1 : Unit = {} ,

         chunkSize : Int = 1024 ,

      ) : LazyList[IndexedSeq[Byte] ] = {

         require(0 < chunkSize, s"chunkSize: $chunkSize")

         import language.unsafeNulls

         Iterator.continually(() )

         .map((_ : Unit ) => {
            /**
             * 
             * `readNBytesEbmSc` would `throw` on premature EOF ;
             * use the native method `readNBytes` instead
             * 
             */
            r.readNBytes(chunkSize ).toIndexedSeq
         })
         .takeWhile(_.nonEmpty )
         
         .to(LazyList)
         
      }

   }

   extension (bytesLlIterator: Iterator[IArray[Byte]] ) {

      def newChunkedByteIteratorInputStream(): java.io.InputStream = {
         ;
         
         new java.io.InputStream {

            import language.unsafeNulls

            var r : IArray[Byte] = {
               IArray.emptyByteIArray
            }

            override
            def read(): Int = ???

            override
            def read(b: Array[Byte], off: Int, len: Int): Int = {

               if (r.length <= 0 ) {

                  for (newArray <- {

                     bytesLlIterator
                     .filter(chars => (0 < chars.length ) )
                     .nextOption()

                  } ) {
                     r = newArray
                  }
                  
               }

               if (0 < r.length ) {
                  val (rTake, rRemaning) = r.splitAt(len)
                  r = rRemaning
                  rTake.copyToArray(b, off )
                  rTake.length
               }
               else {
                  -1
               }

            }
            
         }
         match { case s => new java.io.BufferedInputStream(s, 0x100 ) } // TODO
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





} 

trait ByteManipImplicitsReExports {

   export byteManipImplicits.*

}

/** 
 * 
 * *byte-manip* `implicit`s
 * 
 */
object byteManipImplicits 
extends
AnyRef
with IOMR
{

   export byteManipImplicitsC.*



   
   
   // TODO
   type UnpickleInputStream
      >: MarkableInputStreamImpl
      <: MarkableInputStreamImpl





   //




   
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




















