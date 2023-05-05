package cbsq.avc





















/**
 * 
 * defines
 * - [[Args]]
 * - [[argsInitially]]
 * - [[ArgsDerivResettibility]]
 * - [[ArgsDerivCompletibility]]
 * 
 */
trait Adcp
   extends 
   AnyRef
{
   
   type Args
   
   val argsInitially : (
      Args
   )

   /*
    * 
    * THE DERIVATIONAL TYPE_GUARDS
    * 
    */
   
   /**
    * 
    * evidence that 
    * it's the appropriate time for `asReset`
    * 
    * 
    * @tparam a `receiver.type`
    * 
    */
   type ArgsDerivResettibility[_, a <: Singleton]
      >: util.NotGiven[a <:< argsInitially.type]
      <: util.NotGiven[a <:< argsInitially.type]
      // >: ValueOf[Unit]
      // <: ValueOf[Unit]
   
   /**
    * 
    * evidence that 
    * it's the appropriate time for the `withYyy`
    * 
    * 
    * @tparam a             `receiver.type`
    * @tparam OperatorName  the operator name
    * 
    */
   type ArgsDerivCompletibility[_, a <: Singleton, OperatorName <: Singleton]
      >: (a <:< argsInitially.type )
      <: (Nothing <:< Any )
      // >: ValueOf[Unit]
      // <: ValueOf[Unit]
      
}

/**
 * 
 * the annotated `val` 
 * is only meant for use with `ArgsDerivCompletibility` .
 * the value 
 * shall be a unique `case` `object` in-turn which shall *implement* [[Product]] .
 * 
 */
sealed
case class AAdcpTag() 
extends annotation.StaticAnnotation

































