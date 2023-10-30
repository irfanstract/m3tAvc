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

   def fromDegrees
      (value: Double)
   : _ByValueD[Double ]
   = _Impl (valueInDegrees = floorMod1(dividend = value, divisor = 360 ) )

   def fromMusicalSemitones
      (value: Double)
   = fromDegrees(value = value * 30 )

   ;

   ;

   given com.github.plokhotnyuk.jsoniter_scala.core.JsonValueCodec[Angular._Any ]
   = com.github.plokhotnyuk.jsoniter_scala.macros.JsonCodecMaker.make[Angular._Impl[Double] ]

   ;
}

def floorMod1
   (dividend: Double, divisor: Int )
= dividend match {
   case value =>
      value.-(value./(divisor ).floor.*(divisor ) )
}












val _ = {}
