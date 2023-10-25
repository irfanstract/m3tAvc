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

export monocle.Lens

export monocle.{Prism as Extractor }
export monocle.{Prism as Selector }
export monocle.{Prism as Matcher }





















