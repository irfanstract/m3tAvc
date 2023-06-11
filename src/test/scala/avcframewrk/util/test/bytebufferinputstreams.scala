package avcframewrk.util.test









class ByteBufferInputStreamTests extends
org.scalatest.funsuite.AnyFunSuite
{

   import avcframewrk.util.*

   import language.unsafeNulls

   private
   object impl {
      
      val fib1 = {
         
         infiniteFibonacciSequence
         .iterator
         .map(_.toByte )
         .take(0x10 ).toArray.toIndexedSeq
      }

      def newByteIArrayReader(src : IArray[Byte] ) : ByteBufferInputStream = {

         new ByteBufferInputStream((
            
            java.nio.ByteBuffer.wrap((

               src
               .asInstanceOf[Array[Byte] ]

            ) )

         ) )
         
      }

      def newEmptyByteBufferReader() : ByteBufferInputStream = {
         
         new ByteBufferInputStream(java.nio.ByteBuffer.allocate(0) )
      }

      def newXByteBuffer(l: Int) : java.nio.ByteBuffer = {
            {
               java.nio.ByteBuffer.allocate(l )
            }
      }

   }

   import  impl.*

   test("'readNBytes' does not, apart from slicing, alter the sequence") {

      val reader = {
         newByteIArrayReader(IArray.from(fib1 ) )
      }

      val values1 = {
         reader
         .readNBytes(64 * 1024 ).toIndexedSeq
      }

      assert(values1 == fib1 )

   }

   test("reading an empty Byte-Buffer") {

      assert(newEmptyByteBufferReader().read() == -1 )
      
      assert(newEmptyByteBufferReader().readAllBytes().length == 0 )
      
   }

   test("it shifts 'src.position' as intended ; 1 ") {

      {
         def main(n: Int = 0x10 ): Unit = {
            
            val buffer1 = {
               newXByteBuffer(0x100 )
            }

            val reader = {
               new ByteBufferInputStream(buffer1 )
            }

            reader.readNBytes(n )

            assert(buffer1.position() == n )

            ;

         }

         main(n = 0x10 )
         main(n = 0x18 )
         main(n = 0x10 )
      }
      
   }

   test("'mark()' working as intended ") {

      locally {
         def main(n: Int = 0x10 ) = {
            
            val buffer1 = {
               newXByteBuffer(0x100 )
            }

            val reader = {
               new ByteBufferInputStream(buffer1 )
            }

            reader.readNBytes(n )

            reader.mark(readlimit = 1024 * 1024 )

            reader.readAllBytes()

            reader.reset()

            assert(buffer1.position() == n )

            assertResult(()) {}

         }

         main(n = 0x10 )
         main(n = 0x18 )
         main(n = 0x10 )

         assertResult(()) {}

      }
      
   }

   test("separate usage of the Buffer will lead to failing with IOException(ConcurrentModificationException) ") {

      def main(n: Int = 0x10 ) = {
         ;

         require(0 < n, s"not(0 < (n @ $n) )" )
         
         val buffer1 = {
            newXByteBuffer(n)
         }

         val reader = {
            new ByteBufferInputStream(buffer1 )
            {

               override
               def runReadbPreSrcGetTask(): Unit = {

                  super.runReadbPreSrcGetTask()

                  for (_ <- Range(0, 2) ) {
                     buffer1.get()
                  }
                  
               }

            }
         }

         val z = {

            intercept[java.io.IOException] {

               reader.readAllBytes()

            }
         }

         assertResult(()) { }

      }

      main(n = 0x10 )
      main(n = 0x18 )
      main(n = 0x10 )
      
   }

   test("reading an empty Byte-Buffer, again") {

      assert(newEmptyByteBufferReader().read() == -1 )
      
      assert(newEmptyByteBufferReader().readAllBytes().length == 0 )
      
   }

}









