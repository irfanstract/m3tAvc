package avcframewrk.util














val infiniteFibonacciSequence = {
   ;
   
   new IterableOnce[Int] {

      override
      def iterator = {

         Iterator.iterate[(Int, Int)]((1, 1 ) )({

            case (val1, val2) =>
               (val2, val1 + val2)
               
         })

         .map((val1, val2) => val1 )
         
      }

   }
   
}

val _ = {

   assert(infiniteFibonacciSequence.iterator.take(0x6) sameElements IndexedSeq(1, 1, 2, 3, 5, 8 ) )
   
   assert(infiniteFibonacciSequence.iterator.take(0x8) sameElements IndexedSeq(1, 1, 2, 3, 5, 8, 13, 21 ) )
   
}




















