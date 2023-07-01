package avcframewrk.util.forms.controls

















;

object KValueChangeEvent {

   type ForValue[+Value]
      = ForArgs[Value]
      
   protected 
   trait ImplOps[+Value]
      extends 
         AnyRef
         with Cvo[Value]
   {

      val isByUndo : Boolean
      val isByRedo : Boolean

   }
   
   // protected 
   case class ForArgs[+Value](
      //

      priorValue: Value ,
      newValue  : Value ,

      isByUndo : Boolean ,
      isByRedo : Boolean ,

   )
   extends 
      AnyRef
      with ImplOps[Value]
   {

      /**
       * 
       * derived instance --
       * mapped `priorValue` and `newValue`, and
       * maintained remainder
       * 
       */
      def map[TranslatedValue](f: (newValue.type | priorValue.type) => TranslatedValue) = {

         copy[TranslatedValue](
            newValue   = f(newValue  ) ,
            priorValue = f(priorValue) ,
         )
      } 

   }

} /* `KValueChangeEvent` */

/**
 * 
 * defines a minimum set of info relevant to a successful `value_=` op
 * 
 * `priorValue`, `newValue`
 * 
 */
protected
trait Cvo[+Value] {

   val priorValue : Value

   val newValue : Value

} /* `Cvo` */

;

;















