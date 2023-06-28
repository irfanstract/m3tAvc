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
      & avcframewrk.util.TsevpEventType.ofUpdate.Inheritor
   ) = {

      /**
       * first
       * init what's necessary to init
       */
      %::!

      vceImpl._2
   }

   %::!

   /**
    * when first invoked,
    * register this into `nativeModel`, and immediately fire it
    */
   private
   lazy val %::! = {

      import language.unsafeNulls 
      
      nativeModel addChangeListener lowerUpwardsListenerObj

      lowerUpwardsListenerObj stateChanged { new javax.swing.event.ChangeEvent(this) }
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
            
            fireClientSideValueChgEvent(e)

            {}
            
      }
   }

   // protected
   export vceImpl._1.{apply => fireClientSideValueChgEvent }

   private[asAvslEventEmitterImpl] 
   final 
   lazy
   val vceImpl = {
      avcframewrk.util.newEventEmitter[ValueChgEvent](evtType = avcframewrk.util.TsevpEventType.ofUpdate )
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
   def retractAllPreDippedListeners(): Unit = {

      import language.unsafeNulls 
      
      nativeModel removeChangeListener lowerUpwardsListenerObj
   }
   
   def closeAllClientSideIterators(): Unit = {

      import language.unsafeNulls 
      
      clientSideEvtItr.close()
   }
   
   override 
   def close(): Unit = {

      retractAllPreDippedListeners()

      closeAllClientSideIterators()
   }
   
}







@deprecated
object XBoundedRangeModelByEps {

   //

   case class StateImpl(
      //

      range: (Int, Int),
      value: Int,
      slidingWindowExtent: Int ,
      
      changing: Boolean,

      shallHoldNotify : Boolean ,

   )
   {

      def withChangedMin(newBnd : Int) = copy(range = (range).copy(_1 = newBnd ) )

      def withChangedMax(newBnd : Int) = copy(range = (range).copy(_2 = newBnd ) )

   }

}

/**
 * 
 * implementation of the querying/reading methods of `javax.swing.BoundedRangeModel`
 * based on reading `presentlyState`
 * 
 */
@deprecated
trait XBoundedRangeModelByEps(presentlyState0 : () => XBoundedRangeModelByEps.StateImpl ) extends
javax.swing.BoundedRangeModel
{
      //

      def presentlyState = presentlyState0()

      def range = { presentlyState.range }

      def getMaximum(): Int = range._2
      def getMinimum(): Int = range._1

      def getValue() = presentlyState.value 

      def getValueIsAdjusting() = presentlyState.changing

      def getExtent() = presentlyState.slidingWindowExtent 

}

;

;
















