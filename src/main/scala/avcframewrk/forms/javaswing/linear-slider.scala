package avcframewrk.forms.javaswing














;

/**
 * 
 * an `EventIterator` over all the next chg events
 * 
 */
extension (src: javax.swing.BoundedRangeModel) def asAvslValueChangeEventItr() = {

   import language.unsafeNulls

   {
      
         asAvslEventEmitterImpl(src )
         .clientSideEvtItr
   }
}

protected
class asAvslEventEmitterImpl(nativeModel: javax.swing.BoundedRangeModel )
extends 
AnyRef
with java.io.Closeable
{

   override
   def toString(): String = {
      s"asAvslEventEmitterImpl(${nativeModel })"
   }

   //

   export nativeModel.getMinimum
   
   export nativeModel.getMaximum
   
   export nativeModel.{getExtent => getSlidingWindowExtent }

   lazy
   val clientSideEvtItr : (
      avcframewrk.util.EventIterator[ValueChgEvent]
   ) = {

      vceImpl._2
   }

   /**
    * registers it
    */
   locally {

      import language.unsafeNulls 
      
      nativeModel addChangeListener lowerUpwardsListenerObj
   }

   /**
    * the Listener obj to pass on/to `nativeModel`
    */
   private[asAvslEventEmitterImpl]
   lazy
   val lowerUpwardsListenerObj = {

      import language.unsafeNulls 
      
      identity[javax.swing.event.ChangeListener] {

         case eNatively =>
            //

            val newValue = {
               nativeModel.getValue()
            }

            val e = {
               identity[ValueChgEvent] {
                  CvcEvent(newValue = newValue )
               }
            }
            
            fireValueChgEvent(e)

            {}
            
      }
   }

   // protected
   export vceImpl._1.{apply => fireValueChgEvent }

   private[asAvslEventEmitterImpl] 
   final 
   lazy
   val vceImpl = {
      avcframewrk.util.newEventEmitter[ValueChgEvent]()
   }

   private[asAvslEventEmitterImpl] 
   type ValueChgEvent
      >: CvcEvent[Int]
      <: CvcEvent[Int]

   /**
    * 
    * retracts
    * all listeners this constructor registered
    * 
    */
   def retractAllListeners(): Unit = {

      import language.unsafeNulls 
      
      nativeModel removeChangeListener lowerUpwardsListenerObj
   }
   
   override 
   def close(): Unit = {

      retractAllListeners()
   }
   
}







;
















