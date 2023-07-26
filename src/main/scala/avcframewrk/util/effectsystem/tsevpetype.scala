package avcframewrk.util.effectsystem

val _ = {}















/**
 * 
 * `EventSeqEffectExtent`
 * 
 */
sealed
abstract class EventSeqEffectExtent
extends
AnyRef
{

   val necessitatesIdempotence
   : Boolean

   val impliesUnalteredOutput
   : Boolean

}

object EventSeqEffectExtent
{

   final
   lazy val values: IArray[EventSeqEffectExtent] = {

      IArray(
         ofUpdate ,
         ofAction ,
      )
   }

   case object toUpdate extends
   EventSeqEffectExtent
   {

      inline val necessitatesIdempotence
      = true

      private[toUpdate]
      val impliesUnalteredOutputS
      : Boolean
      = false

      val impliesUnalteredOutput
      : impliesUnalteredOutputS.type
      = impliesUnalteredOutputS

   }

   @deprecated("this is a misnomer.")
   final
   lazy val ofUpdate
   : toUpdate.type
   = toUpdate

   case object forUnalteredEffectSeq extends
   EventSeqEffectExtent
   {

      inline val necessitatesIdempotence
      = false

      inline val impliesUnalteredOutput
      = true

   }

   @deprecated("this is a misnomer.")
   final
   lazy val ofAction
   : forUnalteredEffectSeq.type
   = forUnalteredEffectSeq

}


















