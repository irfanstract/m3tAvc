package avcframewrk.util





















opaque type StringOfBytes
   <: AnyRef & Matchable
   = SbbImpl

protected  
sealed
case class SbbImpl(private[util] val implContents : collection.immutable.ArraySeq.ofByte )
extends
AnyRef
{

   override
   def toString(): String = {

      import language.unsafeNulls
      
      val contentsHexString = {
         toUntaggedContentsHexString()
      }

      s"Bytes($contentsHexString)"
   }

   def toUntaggedContentsHexString(): String = {

      import language.unsafeNulls
      
      val hexFmt = {
         java.util.HexFormat.of()
         .withUpperCase()
         .withDelimiter("_")
      }
      
      val contentsHexString = {
         s"${hexFmt.formatHex(implContents.toIndexedSeq.toArray ) }"
      }

      contentsHexString
   }

   /**
    * 
    * impl for the `asIArray` method ;
    * no copying is necessary since due to the expected type being `IArray`
    * 
    */
   private[util]
   def toIArrayImpl() : IArray[Byte] = {

      IArray.unsafeFromArray(implContents.unsafeArray )
   }

}

object
StringOfBytes
extends
AnyRef
with cbsq.bytemanip.OpaquelyTypedCharacterStringExtensionMethodsDefTrait.EfseAndApplyOfBytes[StringOfBytes, Byte]
{
   //

   import StringOfBytes as ByteBlob

   // extension (buf: ByteBlob) {

   //    private
   //    def lengthImpl = {
   //       import cbsq.bytemanip.FileSize.boxingImplicits.*
   //       buf.characters.length
   //          .toLong
   //          .B
   //    }

   //    def length = {
   //       buf.lengthImpl
   //    }

   //    // def lengthInBytes: Long = {
   //    //    buf.lengthImpl
   //    //    .inBytes
   //    // }

   // }

   // extension (buf: ByteBlob) {

   //    def byteValues: IndexedSeq[Byte] = {
   //       buf
   //    }

   // }

   extension (s: ByteBlob) /* `characters` */ {

      def characters: IndexedSeq[Byte] = {
         (s : SbbImpl)
         .implContents
      }

   }

   // // extension (buf: ByteBlob) {
   // // 
   // //    def slice(start: Int, end: Int) = {
   // //       buf.characters
   // //       .slice(start, `end`)
   // //       .toBlob
   // //    }
   // // 
   // //    def splitAt(i: Int) = {
   // //       (
   // //          buf.characters.take(i).toBlob ,
   // //          buf.characters.drop(i).toBlob ,
   // //       )
   // //    }
   // // }

   // extension (buf: ByteBlob) {

   //    def toArray: Array[Byte] = {
   //       buf.unsafeArray
   //       .clone()
   //    }

   // }

   // // export boxingImplicits.*

   // object boxingImplicits
   // extends
   // AnyRef
   // with cbsq.bytemanip.OpaquelyTypedCharacterStringExtensionMethodsDefTrait.Bxi[ByteBlob, Byte]
   // {

   //    extension (buf: IndexedSeq[Byte]) {

   //       def asBlob: Bytes = {
   //          Bytes(buf)
   //       }
         
   //       // def toBlob: Bytes = {
   //       //    asBlob
   //       // }
         
   //    }

   // }

   extension (buf: ByteBlob) {

      def asArray : IArray[Byte] = {
         (buf : SbbImpl ).toIArrayImpl()
      }

   }

   private 
   def wrapIArrayImpl(buf: IArray[Byte]): ByteBlob = {
      SbbImpl(buf )
   }

   override
   def wrapIArray(buf: IArray[Byte]): ByteBlob = {
      wrapIArrayImpl(buf)
   }

   // /**
   //  * 
   //  * exact
   //  * 
   //  */
   // def apply(data: IndexedSeq[Byte]): ByteBlob = {
   //    from(data = data )
   // }

   // /**
   //  * 
   //  * exact
   //  * 
   //  */
   // def from(data: IndexedSeq[Byte]): ByteBlob = {
   //    data match
   //       case data : collection.immutable.ArraySeq.ofByte =>
   //          data
   //       case _ =>
   //          unsafeWrapArray(data.toArray[Byte] )
      
   // }

   // /**
   //  * 
   //  * exact copy
   //  * 
   //  */
   // def copyOf(srcBuf: collection.Iterable[Byte]): ByteBlob = {
   //    unsafeWrapArray((
   //       srcBuf
   //       .toArray[Byte]
   //    ))
   // }

   // /**
   //  * 
   //  * exact copy
   //  * 
   //  */
   // def copyOfByteArrayRange(b: Array[Byte], off: Int, len: Int): ByteBlob = {
   //    unsafeWrapArray((
   //       b
   //       .view
   //       .slice(off, off + len)
   //       .toArray[Byte] /* guaranteed to be different Array ref */
   //    ))
   // }

   // /**
   //  * 
   //  * exact copy
   //  * 
   //  */
   // def copyOfByteArray(srcBuf: Array[Byte]): ByteBlob = {
   //    unsafeWrapArray(srcBuf.clone() )
   // }

   // /**
   //  * 
   //  * exact copy
   //  * 
   //  */
   // inline def copyOf(srcBuf: Array[Byte]): ByteBlob = {
   //    copyOfByteArray(srcBuf = srcBuf )
   // }

   /**
    * 
    * `unsafeWrapArray`
    * 
    */
   @deprecated("unsafe")
   // protected 
   def unsafeWrapArray(buf: Array[Byte]): ByteBlob = {
      wrapIArrayImpl(IArray.unsafeFromArray(buf) )
   }

   // extension (buf: ByteBlob) {

   //    /**
   //     * 
   //     * `unsafeWrapArray`
   //     * 
   //     */
   //    @deprecated("experimental")
   //    def backingByteArray: Array[Byte] = {
   //       buf.unsafeArray
   //    }

   // }

   // extension (buf : ByteBlob) {

   //    @deprecated("experimental")
   //    inline
   //    def newDirectReader() = {
   //       new java.io.ByteArrayInputStream((
   //          buf.unsafeArray
   //       ))
   //    }

   //    def newByteWiseReader(): java.io.InputStream & java.io.DataInput = {
   //       new java.io.DataInputStream((
   //          newDirectReader()
   //       ))
   //    }

   //    def newGrossReader() : java.io.InputStream = {
   //       newDirectReader()
   //    }

   // }

   /**
    * 
    * exactly the remaining bytes 
    * 
    */
   def takeRemainder(srcBuf: (

      java.nio.ByteBuffer
      | java.io.InputStream

   )): ByteBlob = {

      import language.unsafeNulls
      
      srcBuf match {

         case srcBuf : java.nio.ByteBuffer =>
            takeJbbRemainder(srcBuf = srcBuf )

         case srcBuf : java.io.InputStream =>
            srcBuf.readAllBytes()
            match { case b => unsafeWrapArray(b) }
            
      }
   }

   /**
    * 
    * exactly the remaining bytes  
    * 
    */
   def takeByteIteratorRemainder(src: Iterator[Byte]): ByteBlob = {
      unsafeWrapArray(src.toArray[Byte] )
   }

   @deprecated("the name feels inferior.")
   // private 
   def takeJbbRemainder(srcBuf: java.nio.ByteBuffer): ByteBlob = {
      val b1 = (
         new Array[Byte](srcBuf.remaining() )
      )
      srcBuf get b1
      unsafeWrapArray(b1 )
   }

   /**
    * 
    * exact copy
    * 
    */
   inline def copyOf(src: java.io.ByteArrayOutputStream): ByteBlob = {
      import language.unsafeNulls /* known usage */

      unsafeWrapArray(buf = src.toByteArray() )
   }

}


























































