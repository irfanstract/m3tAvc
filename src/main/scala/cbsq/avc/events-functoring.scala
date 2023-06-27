package cbsq.avc

























export tsevp.EventIterator

export tsevp.newEventEmitter

// protected
val tsevp : TsevpOps = {
   class EventIteratorImpl[E]
   extends
   collection.WithFilter[E, EventIteratorImpl ]
   with java.io.Closeable
   {

      type XStorableListener
         >: (E => Unit )
         <: (E => Unit )

      private[EventIteratorImpl]
      val listeners0 = {
         new java.util.concurrent.atomic.AtomicReference[(
            Seq[XStorableListener ] 
         )](Seq() )
      }

      def removeAllListeners(): Unit = {

         listeners0
         .updateAndGet(e => e.nn.empty )
         
      }

      /**
       * 
       * trigger
       * propagation, invoking all the registered callbacks, of the given item
       * 
       */
      def propagateItem(newEvt: E): Boolean = {

         listeners0.get().nn 
         .foreach((propagateX : XStorableListener ) => {
            propagateX(newEvt)
         } )

         true
      }

      protected[EventIteratorImpl] 
      def addListener[U](propagateX: E => U) = {
   
         import language.unsafeNulls

         listeners0
         .updateAndGet(ls0 => (
            ls0 :+ {
               ((evt: E) => { propagateX(evt) } : Unit )
               .andThen(<:<.refl[Unit] )
            }
         ))

      }

      /**
       * 
       * implemented this way
       * 
       */
      override
      // inline
      final
      def foreach[U](propagateX: E => U) = {
         
         addListener(propagateX )
         
      }

      /**
       * 
       * implemented this way
       * 
       */
      // inline
      final 
      def flatMap[U](processEvt: E => IterableOnce[U]): EventIteratorImpl[U] = {
         
         /**
          * 
          * a new instance,
          * to receive the already-processed values
          * 
          */
         val mappedValuesInstance = ({
            new EventIteratorImpl[U]()
         })

         /**
          * 
          * `forEach`
          * 
          */
         foreach((e0: E) => {

            /**
             * 
             * apply the processing fnc
             * as requested
             * 
             * the return-value will be "plural"
             * due to what it is, "flat-map"
             * 
             */
            val e1s = {
               processEvt(e0)
            }: scala.collection.IterableOnce[U]

            /**
             * 
             * further pass (in)to `mappedValuesInstance`
             * 
             */
            for (e1 <- e1s) {
               mappedValuesInstance propagateItem e1
            }

         })
         
         mappedValuesInstance
      }
      
      override
      def map[U](process: E => U) = {
         flatMap((evt: E) => ({

            val evtConverted = {
               process(evt)
            } : U

            Seq() :+ evtConverted

         }) )
      }
      
      def withFilter(q: E => Boolean): scala.collection.WithFilter[E, EventIteratorImpl] = {
         flatMap(evt => {
            
            (Seq() :+ evt )
            .filter(q)

         } )
      }

      override
      def close(): Unit = {

         removeAllListeners()
         
      }

   }
   type EventIteratorImplCovar[+E] = (
      EventIteratorImpl[? <: E]
   )
   
   object main extends AnyRef with TsevpOps
   {

      type EventIterator[+E]
         >: EventIteratorImplCovar[E]
         <: EventIteratorImplCovar[E]

      def newEventEmitter[E]() : (E => Unit , EventIterator[E] ) = {
         val peer = {
            new EventIteratorImpl[E]()
         }
         ((e: E) => require(peer.propagateItem(e), s"failing the emit of ${e}" ) , peer )
      }
      
   }
   main
}

protected
trait TsevpOps
{

   type EventIterator[+E]
      <: (
         AnyRef
         & collection.WithFilter[E, EventIterator ]
         & java.io.Closeable
      )

   def newEventEmitter[E]() : (E => Unit , EventIterator[E] )
   
}






@main
def runEventsFunctoringDemo(): Unit = {
   import language.unsafeNulls

   val (emit, eh1) = {
      newEventEmitter[(Unit, Int)]()
   }

   eh1
   .map({
      case (_, val1) =>
         s"emitted value ${val1 } which is instance-of ${val1.getClass() } "
   })
   .flatMap(s => s.split("\\s+").toIndexedSeq )
   .foreach(e => println(s"[evts-functoring] [item] ${e : String }") )

   eh1
   .map({
      case (_, val1) =>
         s"I wants to chill down"
   })
   .foreach(e => println(s"[evts-functoring] [item] ${e : String }") )

   java.lang.Thread.sleep(2 * 1000 )
   emit(((), 3 ))
   java.lang.Thread.sleep(3 * 1000 )
   emit(((), 5 ))
   java.lang.Thread.sleep(3 * 1000 )

}










































