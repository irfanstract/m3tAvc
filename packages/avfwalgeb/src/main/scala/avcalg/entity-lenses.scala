package avcalg















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





















