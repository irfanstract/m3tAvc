package cbsq.avc

























export tsevp.EventIterator

export tsevp.newEventEmitter

// protected
val tsevp : TsevpOps = {

   sealed
   trait EventIteratorImplPre[E1, +C[E0] ]
   extends
   collection.WithFilter[E1, C ]
   with java.io.Closeable
   
   class EventIteratorImpl[E](
      //

      protected
      val evtType : TsevpEventType ,

      protected
      var lastKnownValueOption : Option[E] ,

   )
   extends
   EventIteratorImplPre[E, EventIteratorImpl]
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

         lastKnownValueOption = Some(newEvt)

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
         
         map(propagateX )
         
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

            new EventIteratorImpl[U](
               //

               evtType = evtType ,

               lastKnownValueOption = None ,

            )
         })

         /**
          * 
          * run the initial call,
          * if appropriate
          * 
          */
         if evtType == TsevpEventType.ofUpdate then {
            
            for (lastKnownValue <- lastKnownValueOption) {

               runCallbackTask(lastKnownValue)
            }

         }

         /**
          * 
          * `addListener`
          * 
          */
         addListener((e0: E) => {

            runCallbackTask(e0)

         })
         
         def runCallbackTask(e0: E): Unit = {

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

         }

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

      def newEventEmitter[E](
         //

         evtType : TsevpEventType ,

      ) : (E => Unit , EventIterator[E] & evtType.Inheritor ) = {
         val peer = {
            new EventIteratorImpl[E](
               //
               evtType = evtType ,
               lastKnownValueOption = None ,
            )
            match { case c => evtType.pretendEvtItrAsBeingOfThisType(c) }
         }
         ((e: E) => require(peer.propagateItem(e), s"failing the emit of ${e}" ) , peer )
      }
      
   }
   main
}

protected
trait TsevpOps
extends
AnyRef
with TsevpIterableOnceOpDefs
{

   type EventIterator[+E]
      <: (
         AnyRef
         & collection.WithFilter[E, EventIterator ]
         & java.io.Closeable
      )

   def newEventEmitter[E](
      //

      evtType : TsevpEventType = {
         TsevpEventType.ofAction
      } ,

   ) : (E => Unit , EventIterator[E] & evtType.Inheritor )
   
   extension [E](itr0: EventIterator[E] ) {

      def asOfNewEventType(newEvtType : TsevpEventType): EventIterator[E] & newEvtType.Inheritor = {

         val (p, itr1) = {
            newEventEmitter[E](evtType = newEvtType )
         }

         itr0 foreach(p)

         itr1
      }
      
   }

   opaque type NewvetImplSpecificToken <: Any
      = Unit
   protected
   given NewvetImplSpecificToken = ()

}

enum TsevpEventType {

   case ofUpdate

   case ofAction

   /**
    * 
    * for listeners added later than events already fired,
    * it'd be necessary to make the intended behv (eg shall fire immediately ?) clear enough AOT.
    * hence this tagging.
    * 
    */
   opaque type Inheritor
      = Any

   /**
    * 
    * for listeners added later than events already fired,
    * it'd be necessary to make the intended behv (eg shall fire immediately ?) clear enough AOT.
    * hence this tagging method.
    * 
    */
   def pretendEvtItrAsBeingOfThisType[
      A <: (
         // TsevpOps#EventIterator[?] // resulted in type-mismatch for some reason
         collection.WithFilter[?, ?]
      ) ,
      
   ](c: A)(using TsevpOps#NewvetImplSpecificToken ) : c.type & Inheritor = c

}

object TsevpEventType {

}

protected
trait TsevpIterableOnceOpDefs
extends
AnyRef
{
   this : (
      AnyRef
      & TsevpOps
      //
   ) =>

   //
   
   /* 
    * 
    * can't directly `extends` `IterableOnceOps`, since
    * `IterableOnceOps` defines synchronous peeking methods while `EventIterator` doesn't
    * 
    */
   
   export tsevpIterableOps.*

   object tsevpIterableOps {

      extension [OriginalItrItem ](originalIterator: EventIterator[OriginalItrItem] ) {

         def collect[Value](f: PartialFunction[OriginalItrItem, Value] ) = {

            originalIterator
            .flatMap((f.lift).apply _ )
         }

      }

      extension [E](itr0: EventIterator[E] ) {

         def filter(f: E => Boolean ) = {

            import f.{apply => test }

            itr0
            .collect({
               case item if test(item) =>
                  item
            })
         }

      }

      extension [OriginalItrItem ](originalIterator: EventIterator[OriginalItrItem] ) {

         /**
          * 
          * mimics `IterableOnceOps.instance.scanLeft(...)(.....)` .
          * turns it into `TsevpEventType.ofUpdate.Inheritor`
          * 
          */
         // protected
         def scanLeft[State](seed: State )(digest: (State, OriginalItrItem) => State ) : (
            //
            EventIterator[State]
            & TsevpEventType.ofUpdate.Inheritor

         ) = {

            val stateVar = {
               /**
                * due to the flakiness of `-Yunsafe-nulls`,
                * needs an extra `Some(...)` containment
                */
               new java.util.concurrent.atomic.AtomicReference[Some[State] ](Some(seed) )
            }

            originalIterator
            .map[State]((originalItrNextItem: OriginalItrItem ) => {

               import language.unsafeNulls

               stateVar.updateAndGet({ case Some(state0) => {

                  val state1 = {
                     digest(state0, originalItrNextItem )
                  }

                  Some(state1)
               } } )
               match { case Some(state) => state }
            } )
            /**
             * 
             * by definition,
             * it need it to be `ofUpdate`
             * 
             */
            .asOfNewEventType(newEvtType = avcframewrk.util.TsevpEventType.ofUpdate )
            
            match { case itr => itr }
         }

      }

      extension [OriginalItrItem ](originalIterator: EventIterator[OriginalItrItem] ) {

         def tapEach[U](f: OriginalItrItem => U ) = {

            originalIterator
            .map(item => { f(item) ; item })
         }

      }

      extension [OriginalItrItem ](originalIterator: EventIterator[OriginalItrItem] ) {

         /**
          * 
          * the number of fires.
          * whose `eventType` will be `ofUpdate`
          * 
          * `Long` rather than `Int`,
          * to minimise the potential issues like overflows
          * 
          */
         def counting() = {

            originalIterator
            .scanLeft[Long](0 )((i0, _ ) => (i0 + 1 ) )
         }

      }

      extension [OriginalItrItem ](originalIterator: EventIterator[OriginalItrItem] ) {

         def dropWhile(f: OriginalItrItem => Boolean ) = {

            val switch1 = {
               new java.util.concurrent.atomic.AtomicBoolean(false)
            }

            originalIterator
            .collect({
               case item if { switch1.get() || switch1.compareAndSet(false, f(item) ) } =>
                  item
            })
         }

      }

      extension [OriginalItrItem ](originalIterator: EventIterator[OriginalItrItem] ) {

         def find(f: OriginalItrItem => Boolean ) : concurrent.Future[OriginalItrItem] = {

            val p = {
               avcframewrk.util.LateBoundValue.newInstance[OriginalItrItem]
            }

            lazy val newItr : EventIterator[OriginalItrItem] = {

               originalIterator
               .tapEach(item => {

                  if f(item) then {

                     if { p tryComplete(util.Success(item) ) } != true then {
                        
                        throw new java.util.ConcurrentModificationException
                     }

                     newItr.close() 
                     
                  }

               })
            }

            p.asFuture
         }

      }

   }

}






@main
def runEventsFunctoringDemo(): Unit = {
   import language.unsafeNulls

   val (emit, eh1) = {
      newEventEmitter[(Unit, Int)](
         //
         evtType = TsevpEventType.ofAction ,
      )
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










































