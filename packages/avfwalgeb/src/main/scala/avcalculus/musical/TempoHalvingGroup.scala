// package avcalculus.musical

package avcalculus

package musical








import scala.math.Numeric.Implicits.infixNumericOps









// TODO
/** 
 * 
 * *tempo*
 * 
 * exact halves and doubles all each constitutes an identical instance
 * 
 */
object InPwOf2Tempo {
   ;

   ;

   ;

   /** 
    * an instance which describes normalised *half-or-double of `value`bpm*
    * (note that exact halves and doubles all each constitutes an identical instance)
    * 
    */
   def atBpm
      //
      [I <: scala.AnyVal : Numeric ]
      (value: I )
   : _AtBpm[value.type ]
   = {
      ;
      value.toDouble
      match { case v0 => {
         atBpmD(v0)
      } }
   }

   /** 
    * an instance which describes normalised *half-or-double of `value`bpm*
    * (note that exact halves and doubles all each constitutes an identical instance)
    * 
    */
   def atBpmD
      //
      [I <: Double ]
      (value: I )
   : _AtBpm[value.type ]
   = {
      ;
      value
      match { case v0 => {
         _Impl.normaliseToAnyFrom80ToBefore160R(v0)
      } }
      match { case v => {
         assert(80 <= v && v <= 160 )
         v
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
         atBpmD((2.0 / 3 ) * v.rateInBpmD )
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

   object _Impl {
      ;

      ;

      transparent
      inline
      def normaliseToAnyFrom80ToBefore160
         (v0: Double)
      = normaliseToAnyFrom80ToBefore160R(v0)

      /* the non-inline version of it */
      @annotation.tailrec
      def normaliseToAnyFrom80ToBefore160R
         (v0: Double)
      : Double
      = v0 match {
         case v0 if (0 < v0 && v0 < 80) =>
            normaliseToAnyFrom80ToBefore160R(2 * v0 )
         case v0 if 160 <= v0 =>
            normaliseToAnyFrom80ToBefore160R(0.5 * v0 )
         case v0 if !(0 <= v0 ) =>
            throw new IllegalArgumentException(s"not a positive quant/scalar: ${v0} ")
         case v0 if v0.isNaN =>
            throw new IllegalArgumentException(s"a NaN: ${v0} ")
         case _ =>
            throw new IllegalArgumentException(s"not a supported arg: ${v0} ")
      }

      ;
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
