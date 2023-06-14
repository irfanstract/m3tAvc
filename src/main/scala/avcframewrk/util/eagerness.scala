package avcframewrk.util















object Eagerness
{

   case object toBeLazy extends Eagerness
   {

      final val floatValue = 0

      final val characteristicSeqFactory = {
         LazyList
      }

   }
   
   case object toBeEager extends Eagerness
   {

      final val floatValue = 1

      val characteristicSeqFactory = {
         IndexedSeq
      }

   }
   
}

sealed
abstract class Eagerness
{

   /**
    * either `0` when lazy, or `1` when eager
    */
   val floatValue : Double

   val characteristicSeqFactory : collection.SeqFactory[Seq]

}
























