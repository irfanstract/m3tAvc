package avcalculus

package musical












object Key {
   ;

   ;

   type _Any
   = _Impl

   ;

   def byFromCKeyDeviation
      (v: trig.Angular._Any )
   = byAngleFromCKey(v)

   private[Key]
   def byAngleFromCKey
      (v: trig.Angular._Any )
   : _Impl
   = _Impl(fromKeyCDeviation = v )

   ;

   protected
   case class _Impl
      (val fromKeyCDeviation: trig.Angular._Any )

   ;

   extension (k: _Any )
      def isAnInTwelvethKey
      : Option[InTwelvethKey ]
      = {
         InTwelvethKey.values.toIndexedSeq
         .map({ case (c) => (c.fromKeyCDeviation, c ) })
         .toMap
         .get(k.fromKeyCDeviation )
      }

   ;

   ;

   ;

   ;

   given com.github.plokhotnyuk.jsoniter_scala.core.JsonValueCodec[Key._Any ]
   = com.github.plokhotnyuk.jsoniter_scala.macros.JsonCodecMaker.make[Key._Impl ]

   ;
}

enum InTwelvethKey
extends
java.lang.Enum[InTwelvethKey ]
{
   //

   case C
   case C_SHARP
   case D
   case E_FLAT
   case E

   case F
   case F_SHARP
   case G
   case A_FLAT
   case A
   case B_FLAT
   case B

   override
   def toString
   = name().nn

   //
}
object InTwelvethKey {
   ;

   ;

   given fkysOps
   : AnyRef
      with FromKeyYInferSomething.FkdOps[InTwelvethKey, (trig.Angular._Any) ]
      with FromKeyYInferSomething.FkoOps[InTwelvethKey, (Int              ) ]
   with {
      ;

      extension (c: InTwelvethKey ) {
         //

         /** 
          * an `Angular`,
          * the devtn from the key `A`
          * 
          */
         def fromKeyADeviation
         = trig.Angular.fromMusicalSemitones(c.fromKeyAOrdinal )

         /** 
          * an `Angular`,
          * the devtn from the key `C`
          * 
          */
         def fromKeyCDeviation
         = trig.Angular.fromMusicalSemitones(c.fromKeyCOrdinal )

         def fromKeyAOrdinal
         = (3 + c.ordinal ) % 12

         def fromKeyCOrdinal
         = c.ordinal

      }

      ;
   }

   ;

   ;

   given com.github.plokhotnyuk.jsoniter_scala.core.JsonValueCodec[InTwelvethKey ]
   = {
      import language.unsafeNulls
      com.github.plokhotnyuk.jsoniter_scala.macros.JsonCodecMaker.make
   }

}

object FromKeyYInferSomething {
   ;

   ;

   ;

   trait FkdOps
      [-A, +R <: Matchable ]
   {

      extension (c: A ) {
         //

         /** 
          * an `Angular`,
          * the devtn from the key `A`
          * 
          */
         def fromKeyADeviation
         : R

         /** 
          * an `Angular`,
          * the devtn from the key `C`
          * 
          */
         def fromKeyCDeviation
         : R

      }

   }

   trait FkoOps
      [-A, +R <: Matchable ]
   {

      extension (c: A ) {
         //

         def fromKeyAOrdinal
         : R

         def fromKeyCOrdinal
         : R

      }
   }

   ;
}












val _ = {}
