package avcframewrk.forms.specialMath














/**
 * 
 * a `C & Singleton`.
 * 
 */
type CSingleton[C]
   = avcalg.CSingleton[C]

/**
 * 
 * an instance of `C`.
 * 
 */
type InstanceOf[+C]
   = avcalg.InstanceOf[C]

/**
 * 
 * a `C` instance's *aspect* which must implement `R` .
 * 
 * @tparam C the base-type for the receiver
 * @tparam R the base-type for the return-value
 * 
 */
type CInstanceAspectR[
   -C,
   +R,
]
   >: [c <: InstanceOf[C] ] =>> R
   <: [c <: InstanceOf[C] ] =>> R














