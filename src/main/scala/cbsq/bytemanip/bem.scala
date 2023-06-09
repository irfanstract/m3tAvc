package cbsq.bytemanip
















object  OpaquelyTypedCharacterStringExtensionMethodsDefTrait
{

   trait Efse[
      XCharacterBlob <: IndexedSeq[XCharacter] ,
      XCharacter ,
      
   ]
   extends
   AnyRef
   with WithBxi[XCharacterBlob, XCharacter]
   {

      extension (buf: XCharacterBlob) /* `characters` */ {

         def characters: IndexedSeq[XCharacter]

      }

      extension (buf: XCharacterBlob) {

         def slice(start: Int, end: Int) = {
            buf.characters
            .slice(start, `end`)
            .toBlob
         }

         def splitAt(i: Int) = {
            (
               buf.characters.take(i).toBlob ,
               buf.characters.drop(i).toBlob ,
            )
         }
      }

   }

   trait WithBxi[
      XCharacterBlob <: IndexedSeq[XCharacter] ,
      XCharacter ,
      
   ]
   {

      export boxingImplicits.asBlob
      export boxingImplicits.toBlob

      val boxingImplicits : Bxi[XCharacterBlob, XCharacter]

   }

   type WithCharClassTag[
      T1 ,
      ItsCharacter ,
      
   ] = (
      WithCharClassTag1[ItsCharacter]
   )

   protected 
   trait WithCharClassTag1[
      ItsCharacter ,
      
   ]
   {

      given characterClassTag : reflect.ClassTag[ItsCharacter]

   }

   trait Bxi[
      XCharacterBlob <: IndexedSeq[XCharacter] ,
      XCharacter ,
      
   ]
   {

         extension (buf: IndexedSeq[XCharacter]) {

            def asBlob: XCharacterBlob
            
            def toBlob: XCharacterBlob = {
               asBlob
            }
            
         }

   }

   trait EfseAndApply[
      XCharacterBlob <: IndexedSeq[XCharacter] ,
      XCharacter ,
      
   ]
   extends
   AnyRef
   with WithCharClassTag[?, XCharacter]
   with Efse[XCharacterBlob, XCharacter]
   with Apply[XCharacterBlob, XCharacter]
   {

      //
      
   }
   
   trait Apply[
      XCharacterBlob <: IndexedSeq[XCharacter] ,
      XCharacter ,
      
   ]
   extends
   AnyRef
   with WithCharClassTag[?, XCharacter]
   {

      this : (
         AnyRef
         with WithCharClassTag[?, XCharacter]
      ) =>

      /**
       * 
       * exact
       * 
       */
      def apply(data: IndexedSeq[XCharacter]): XCharacterBlob = {
         
         from(data = data )
      }

      /**
       * 
       * exact
       * 
       */
      def from(data: IndexedSeq[XCharacter]): XCharacterBlob = {

         unsafeWrapArray(data.toArray[XCharacter] )

      }

      /**
       * 
       * exact copy
       * 
       */
      def copyOf(srcBuf: collection.Iterable[XCharacter]): XCharacterBlob = {

         unsafeWrapArray((
            srcBuf
            .toArray[XCharacter]
         ))
      }

      /**
       * 
       * exact copy
       * 
       */
      def copyOfByteArrayRange(b: Array[XCharacter], off: Int, len: Int): XCharacterBlob = {

         unsafeWrapArray((
            b
            .view
            .slice(off, off + len)
            .toArray[XCharacter] /* guaranteed to be different Array ref */
         ))
      }

      /**
       * 
       * exact copy
       * 
       */
      def copyOfByteArray(srcBuf: Array[XCharacter]): XCharacterBlob = {

         unsafeWrapArray(srcBuf.clone() )
      }

      /**
       * 
       * exact copy
       * 
       */
      def copyOf(srcBuf: Array[XCharacter]): XCharacterBlob 

      /**
       * 
       * `unsafeWrapArray`
       * 
       */
      @deprecated("unsafe")
      // protected 
      def unsafeWrapArray(buf: Array[XCharacter]): XCharacterBlob 

   }
   
   trait EfseOfAaob[
      XCharacterBlob >: collection.immutable.ArraySeq.ofByte <: collection.immutable.ArraySeq.ofByte ,
      XCharacter >: Byte <: Byte ,
      
   ]
   extends
   AnyRef
   with Efse[XCharacterBlob, XCharacter]
   with EfseAndApply[XCharacterBlob, XCharacter]
   {
      this1 =>
      
      private[EfseOfAaob] 
      object `@#%% Impl` {
      
         final lazy val ByteBlob : this1.type = this1
         type ByteBlob = XCharacterBlob
         
         final lazy val Bytes : this1.type = this1
         type Bytes = XCharacterBlob

      }

      import `@#%% Impl`.*

      override
      implicit
      val characterClassTag = {
         reflect.ClassTag.Byte
      }

      extension (buf: ByteBlob) {

         private
         def lengthImpl = {
            import cbsq.bytemanip.FileSize.boxingImplicits.*
            buf.characters.length
               .toLong
               .B
         }

         def length = {
            buf.lengthImpl
         }

         // def lengthInBytes: Long = {
         //    buf.lengthImpl
         //    .inBytes
         // }

      }

      extension (buf: ByteBlob) {

         def byteValues: IndexedSeq[Byte] = {
            buf
         }

      }

      extension (buf: ByteBlob) /* `characters` */ {

         override
         def characters: IndexedSeq[Byte] = {
            buf
         }

      }

      extension (buf: ByteBlob) {

         def toArray: Array[Byte] = {
            buf.unsafeArray
            .clone()
         }

      }

      // export boxingImplicits.*

      object boxingImplicits
      extends
      AnyRef
      with cbsq.bytemanip.OpaquelyTypedCharacterStringExtensionMethodsDefTrait.Bxi[ByteBlob, Byte]
      {

         extension (buf: IndexedSeq[Byte]) {

            override
            def asBlob: Bytes = {
               Bytes(buf)
            }
            
            // def toBlob: Bytes = {
            //    asBlob
            // }
            
         }

      }

      // /**
      //  * 
      //  * exact
      //  * 
      //  */
      // def apply(data: IndexedSeq[Byte]): ByteBlob = {
      //    from(data = data )
      // }

      /**
       * 
       * exact
       * 
       */
      override
      def from(data: IndexedSeq[Byte]): ByteBlob = {
         data match
            case data : collection.immutable.ArraySeq.ofByte =>
               data
            case _ =>
               unsafeWrapArray(data.toArray[Byte] )
         
      }

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

      /**
       * 
       * exact copy
       * 
       */
      override
      // inline
      def copyOf(srcBuf: Array[Byte]): ByteBlob = {
         copyOfByteArray(srcBuf = srcBuf )
      }

      /**
       * 
       * `unsafeWrapArray`
       * 
       */
      @deprecated("unsafe")
      override
      // protected 
      def unsafeWrapArray(buf: Array[Byte]): ByteBlob = {
         import collection.immutable.ArraySeq
         ArraySeq.ofByte(buf)
      }

      extension (buf: ByteBlob) {

         /**
          * 
          * `unsafeWrapArray`
          * 
          */
         @deprecated("experimental")
         def backingByteArray: Array[Byte] = {
            buf.unsafeArray
         }

      }

      extension (buf : ByteBlob) {

         @deprecated("experimental")
         inline
         def newDirectReader() = {
            new java.io.ByteArrayInputStream((
               buf.unsafeArray
            ))
         }

         def newByteWiseReader(): java.io.InputStream & java.io.DataInput = {
            new java.io.DataInputStream((
               newDirectReader()
            ))
         }

         def newGrossReader() : java.io.InputStream = {
            newDirectReader()
         }

      }

   }

}













































