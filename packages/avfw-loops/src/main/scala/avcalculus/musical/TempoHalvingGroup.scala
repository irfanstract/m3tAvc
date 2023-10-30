// package avcalculus.musical

package avcalculus

package musical








import scala.math.Numeric.Implicits.infixNumericOps









// TODO
/** 
 * 
 * we define
 * all halves of it
 * to constitute equivalent instance
 * .
 * 
 */
object InPwOf2Tempo {
   ;

   ;

   ;

   def atBpm
      //
      [I <: scala.AnyVal : Numeric ]
      (value: I )
   : _AtBpm[value.type ]
   = {
      ;
      value.toDouble
      .abs
      match { case v0 => {
         var v1: Double = v0
         while v1 < 80 do
            v1 *= 2
         while 160 <= v1 do
            v1 /= 2
         v1
      } }
      match { case v => {
         assert(80 <= v && v <= 160 )
         80 + (v % 80 )
      } }
      match { case v => {
         _Impl.From80ToBefore160(rateInBpm = v )
      } }
   }

   extension (v: _Any )
      def twoThirdsFriend
      : _Any
      = {
         ;
         atBpm((2.0 / 3 ) * v.rateInBpmD )
      }

   ;

   type _Any
   = _Impl[?]

   opaque type _AtBpm
      [+I <: scala.AnyVal]
   <: _Impl[?]
   =  _Impl[?]
   
   // TODO
   extension (v: _Any )
      def rateInBpmD
      : Double
      = {
         ;
         v.rateInBpm
         .asInstanceOf[scala.AnyVal]
         .asInstanceOf[Double ]
      }

   protected
   enum _Impl
      [+V <: Double ]
   {
      //
      val rateInBpm: V

      //
      case From80ToBefore160
         [+V <: Double ]
         (val rateInBpm: V)
      extends
      _Impl[V]

      //
      override
      def toString(): String
      = {
         import language.unsafeNulls

         val bpms
         = Seq(rateInBpm / 2, rateInBpm, rateInBpm * 2)

         s"${
            bpms
            .map(_.toBpmString() )
         }"
      }
   }

   ;

   extension [V](rateInBpm: V)(using scala.math.Numeric[V] )
      def toBpmString()
      : String
      = {
         import language.unsafeNulls
         s"(${rateInBpm})bpm"
      }

   ;

   ;
}















val _ = {}
