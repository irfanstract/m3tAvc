package cbsq.avc





















// export java.nio.{
//    ByteBuffer ,
//    ShortBuffer as JInt16Buffer ,
//    IntBuffer   as JInt32Buffer ,
//    LongBuffer  as JInt64Buffer ,
// }
//
// // val IBuf = java.nio.IntBuffer
//
// // def ibee(arg: java.nio.IntBuffer.type): Unit =
// //    {}
//
// def newInt32Buffer(size: Int): JInt32Buffer = 
//    java.nio.IntBuffer.allocate(size)
//
private object nvib {
   // newInt32Buffer(size = 0x400)
}

// extension (dest: java.io.OutputStream)
//
//    /**
//     * [[java.io.DataOutputStream#writeInt ]]
//     *
//     * @param wrend
//     */
//    def writeInt32BEnd(wrend: Int): Unit =
//       wrapped1.writeInt(wrend)
//
//    def wrapped1 = 
//       new java.io.DataOutputStream(dest)
//
/**
 * see [[java.io.DataOutputStream.writeInt ]]
 * 
 */
given jBEndWriterFrom: Conversion[java.io.OutputStream, java.io.DataOutputStream] =
   new java.io.DataOutputStream(_)

/**
 * the appropriate [[java.nio.Buffer]] subclass.
 * 
 */
type JBB[Character] <: java.nio.Buffer = 
   Character match {
      
      case (Unit  ) => (java.nio.ByteBuffer     )
      
      case (Byte  ) => (java.nio.ByteBuffer     )
      case (Char  ) => (java.nio.CharBuffer     )
      case (Short ) => (java.nio.ShortBuffer    )
      case (Int   ) => (java.nio.IntBuffer      )   
      case (Long  ) => (java.nio.LongBuffer     )    

      case (Float ) => (java.nio.FloatBuffer    )     
      case (Double) => (java.nio.DoubleBuffer   )      

   }









/**
 * 
 * (C/C++)-style *pointer*.
 * 
 * ```
 * // C/C++: bytebuf1 + LIBMVBYTES_PAYLOADOFFSET
 * bytebuf1 + MvBytes.stdPayloadOffset
 * ```
 * 
 */
sealed trait KBuffer { this1 =>

   @specialized(Specializable.Primitives)
   type Character

   type Derived <: (
      KBuffer {
          type Character >: this1.Character <: this1.Character 
      }
   )

   @deprecated("'KBuffer' arithmetique")
   transparent inline
   def +(offset: Int) =
      &:+(offset)

   /**
    * the value at index `offset`, C/C++ idiom `return p[offset]`
    *
    */
   def apply(offset: Int): Character

   /**
    * the value at index `0`, C/C++ idiom `return p*`
    *
    */
   def value0: Character

   /**
    * implementation for the operator `+`
    *
    */
   def &:+(offset: Int): this1.Derived

   trait RnbResultK {
      val athis: this1.type
      val advanced: this1.Derived
   }

}
object KBuffer {

   sealed trait OJXB extends KBuffer
   { this1 =>

      val storage : JBB[this1.Character]
      val offset : Int

      protected transparent inline 
      def stoAdjusted =
         storage
         .slice()
         .position(this1.offset)
         .slice()

      given characterClassTag: reflect.ClassTag[this1.Character]
      protected transparent inline 
      def allocateCharacterArray(n: Long) =
         new Array[this1.Character](n.asInstanceOf[Int])
      
      protected transparent inline 
      def rrk(stoAdvanced1: Derived) =
         new RnbResultK {
            val athis = this1
            val advanced = stoAdvanced1
         }
         
   }
   
}

/**
 * 
 * (C/C++)-style *pointer-type* `int8_t*`.
 * 
 */
sealed 
trait KByteBuffer extends KBuffer
{ this1 =>

   type Character >: Byte <: Byte

   type Derived <: KByteBuffer

   def readNBytes(n: Long): RnbResultK
   def writeBytes(d: collection.immutable.ArraySeq[Byte]): RnbResultK

   def value0: Byte
   
   def &:+(offset: Int): this1.Derived
   
}
object  KByteBuffer {

   def allocate(len: Int): KByteBuffer =
      over(java.nio.ByteBuffer allocate(len) )

   def over(sto: java.nio.ByteBuffer): KByteBuffer =
      OJBB(storage = sto.slice() , offset = 0 )

   /**
    * to match the semantics in C/C++,
    * the implementation of "the pointers + operator" needs to be composible
    *
    * @param storage
    * @param offset
    */
   protected case class OJBB[+Offset <: Int](
      storage: java.nio.ByteBuffer ,
      offset: Offset ,
   ) extends KBuffer.OJXB with KByteBuffer :
      this1 =>

      if 0 != storage.position() then 
         throw IllegalArgumentException("the Buffer's position not at zero")
      
      override
      def toString =
         s"KByteBuffer($offset@$storage) "

      type Derived >: KByteBuffer <: KByteBuffer

      override
      def apply(offset: Int): Character =
         stoAdjusted get(offset)

      def value0 =
         stoAdjusted get(0)

      def &:+(o: Int): KByteBuffer =
         this1 copy(offset = this1.offset + o)

      given characterClassTag: reflect.ClassTag[Byte] = 
         reflect.ClassTag.Byte

      def readNBytes(n: Long) =
         val dst = allocateCharacterArray(n)
         val stoAdvanced = 
            stoAdjusted get (dst: Array[Byte]) 
         rrk(stoAdvanced1 = KByteBuffer over stoAdvanced)
         
      def writeBytes(d: collection.immutable.ArraySeq[Byte]) =
         val d1 = 
            d match {
               case a: collection.immutable.ArraySeq.ofByte =>
                  a
            }
         val stoAdvanced = 
            stoAdjusted put (d1.unsafeArray: Array[Byte]) 
         rrk(stoAdvanced1 = KByteBuffer over stoAdvanced)

   //
}



   










