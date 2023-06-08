package cbsq.riffmt.ebmls














/**
 * 
 * lazily-computed mapping
 * 
 */
class Lazy[+V](presentlyValue: => V ) {

   final
   lazy val value = presentlyValue
   
}




/**
 * 
 * lazily-computed mapping
 * 
 */
sealed
case class Lze[K, +V](protected val getPresentValue: K => V ) {

   import language.unsafeNulls /* due to the extended usage of non-Scala API(s) */
   
   private
   val at = {
      new java.util.concurrent.atomic.AtomicReference[Map[K, util.Try[V]] ](Map() )
   }

   private
   def prepareForKey(k: K) = {

      at
      .updateAndGet(m0 => {

         m0
         /**
          * load, if-and-only-if left unset
          */
         .updatedWith[util.Try[V] ](k)(priorValueOptional => (
            
            priorValueOptional
            orElse
            ({
               val tried = (
                  util.Try[V] {
                     getPresentValue(k)
                  }
               )
               Some(tried)
            })

         ) )
         
      })
      
   }

   def get(k: K): V = {
      prepareForKey(k)
      .apply(k )
      .get
   }
   
}

object Lze
{
   ;

   extension [V](r: Lze[Unit, V]) {

      def value: V = {
         r get()
      }
      
   }

}






















































