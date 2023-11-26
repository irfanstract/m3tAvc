package avcalculus

package musical












object Key {
   ;

   ;

   type _Any
   = _Impl

   ;

   transparent
   inline
   def bySemitonesFromCKey
      (v: Double )
   = byDegreesFromCKey(v * 30 )

   def byDegreesFromCKey
      (v: Double )
   = byAngleFromCKey(trig.Angular.fromDegrees(v ) )

   def byFromCKeyDeviation
      (v: trig.Angular._Any )
   = byAngleFromCKey(v)

   private[Key]
   def byAngleFromCKey
      (v: trig.Angular._Any )
   : ByAngleFromCKey[v.type ]
   = _Impl(fromKeyCDeviation = v )

   opaque type ByAngleFromCKey
      [+Value <: trig.Angular._Any ]
   <: _Impl
   =  _Impl

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

   transparent
   inline
   def fromKeyCOrdinalImpl
   = this match {
      //

      case C       => 0
      case C_SHARP => 1
      case D       => 2
      case E_FLAT  => 3
      case E       => 4

      case F       => 5
      case F_SHARP => 6
      case G       => 7
      case A_FLAT  => 8
      case A       => 9
      case B_FLAT  => 10
      case B       => 11

   }

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
         transparent
         inline
         def fromKeyADeviation
         = trig.Angular.fromMusicalSemitones(c.fromKeyAOrdinal )

         /** 
          * an `Angular`,
          * the devtn from the key `C`
          * 
          */
         transparent
         inline
         def fromKeyCDeviation
         = trig.Angular.fromMusicalSemitones(c.fromKeyCOrdinal )

         transparent
         inline
         def fromKeyAOrdinal
         = (3 + c.fromKeyCOrdinal ) % 12

         transparent
         inline
         def fromKeyCOrdinal
         = c.fromKeyCOrdinalImpl

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
