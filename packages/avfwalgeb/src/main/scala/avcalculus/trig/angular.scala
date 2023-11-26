package avcalculus

package trig












/** 
 * 
 * normalised angular magnitude,
 * ignoring clockwise-ness
 * 
 */
object Angular {
   ;

   ;

   ;

   type _Any
   = _Impl[?]

   type _ByValueD
      [+V <: Double ]
   = _Impl[V]

   protected
   case class _Impl[+V <: Double ](valueInDegrees: V )

   ;

   ;

   final
   lazy val thirtyDegreeInstance
   = fromDegreesUnchecked(30 )

   final
   lazy val fourtyFiveDegreeInstance
   = fromDegreesUnchecked(45 )

   final
   lazy val sixtyDegreeInstance
   = fromDegreesUnchecked(60 )

   final
   lazy val ninetyDegreeInstance
   = fromDegreesUnchecked(90 )

   transparent
   inline
   def fromMusicalSemitones
      (value: Double)
   = fromDegrees(value = value * 30 )

   transparent
   inline
   def fromDegrees
      (value: Double)
   : _ByValueD[Double ]
   = fromDegreesUnchecked( floorMod1(dividend = value, divisor = 360 ) )

   /** 
    * DO NOT CALL DIRECTLY! only for binary compat.
    * 
    */
   // private
   def fromDegreesUnchecked
      (value: Double)
   : _ByValueD[value.type ]
   = _Impl[value.type ] (valueInDegrees = value )

   ;

   ;

   extension (lhs: _Any) {
      def +(rhs: _Any ) = fromDegrees(lhs.valueInDegrees + rhs.valueInDegrees )
      def -(rhs: _Any ) = fromDegrees(lhs.valueInDegrees - rhs.valueInDegrees )
      def unary_- = lhs.multipliedBy(-1 )
      def multipliedBy(rhs: Double ) = fromDegrees(rhs * lhs.valueInDegrees )
      def unary_! = fromDegrees(360 - lhs.valueInDegrees )
   }

   ;

   ;

   given com.github.plokhotnyuk.jsoniter_scala.core.JsonValueCodec[Angular._Any ]
   = com.github.plokhotnyuk.jsoniter_scala.macros.JsonCodecMaker.make[Angular._Impl[Double] ]

   ;

   ;

   ;

   /** 
    * angular-momental direction ; exactly 2 instances (`CW` and `CCW`) .
    * in-terms-of *user-coord-space*.
    * 
    */
   enum MomentaryDirection {
      case Clockwise
      case CounterClockwise
   }

   ;

   ;

}

enum NeWsPolarQuad(val fromWestClockwiseDevn: Angular._Any )
extends
PolarQuad
{
   case north extends NeWsPolarQuad(fromWestClockwiseDevn = Angular.fromDegrees( 90) ) /* */
   case east  extends NeWsPolarQuad(fromWestClockwiseDevn = Angular.fromDegrees(180) ) /* */
   case west  extends NeWsPolarQuad(fromWestClockwiseDevn = Angular.fromDegrees(  0) ) /* */
   case south extends NeWsPolarQuad(fromWestClockwiseDevn = Angular.fromDegrees(270) ) /* */
}
export NeWsPolarQuad.{north, east, west, south }
sealed trait PolarQuad

transparent
inline
def floorMod1
   (dividend: Double, divisor: Int )
= dividend match {
   case value =>
      value.-(value./(divisor ).floor.*(divisor ) )
}












val _ = {}
