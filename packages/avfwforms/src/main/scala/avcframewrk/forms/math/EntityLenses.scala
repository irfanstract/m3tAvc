package avcframewrk.forms.math














/**
 * 
 * a `C & Singleton`.
 * 
 */
type CSingleton[C]
   = Singleton & C

/**
 * 
 * an instance of `C`.
 * 
 */
type InstanceOf[+C]
   >: Singleton & C
   <: Singleton & C

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














