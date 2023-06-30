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
   
   class EventIteratorImpl[E, +AssignedEvtType <: TsevpEventType ](
      //

      protected
      val evtType : AssignedEvtType ,

      protected
      var lastKnownValueOption : Option[E] ,

   )
   extends
   EventIteratorImplPre[E, [E1] =>> (
      EventIteratorImpl[E1, (
         /**
          * by definition of those four methods,
          * the resulting views can confidently inherit the src's `evtType`, too 
          */
         (evtType.type & AssignedEvtType)
      )]
   ) ]
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
      def flatMap[U](processEvt: E => IterableOnce[U]) = {
         
         /**
          * 
          * a new instance,
          * to receive the already-processed values
          * 
          */
         val mappedValuesInstance = ({

            new EventIteratorImpl[U, evtType.type](
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
            for (e1 <- {
               Vector.from(e1s)
               match {
                  case s @ (_ :+ lastItem) if (mayFlatMappingInstanceImposeIdempotenceByOmissiveBehv && evtType == TsevpEventType.ofUpdate ) =>
                     Vector(lastItem)
                  case s =>
                     s 
               }
               match { case s => s : Seq[U] }
            }) {
               mappedValuesInstance propagateItem e1
            }

         }

         mappedValuesInstance
      }

      /**
       * 
       * in theory,
       * when `evtType == EventType.ofUpdate`,
       * we
       * had choice to make `flatMap` to restrict to, from the returned `ItrOnce`, the last item,
       * but
       * this
       * can result in
       * the undesirable *over-omission* in combination with later-applied `collect`, `filter`, any other methods which omits items
       * 
       */
      val mayFlatMappingInstanceImposeIdempotenceByOmissiveBehv : Boolean = {

         false
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
      
      def withFilter(q: E => Boolean) = {
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
   type EvtIteratorImplByItemAndDesignation[E, +AssignedEvtType <: TsevpEventType ] = (
      EventIteratorImpl[
         E,
         AssignedEvtType,
      ]
   )
   type EvtIteratorImplByItemAndDesignationCovar[+E, +AssignedEvtType <: TsevpEventType ] = (
      EvtIteratorImplByItemAndDesignation[
         ? <: E,
         AssignedEvtType ,
      ]
   )
   
   object main extends AnyRef with TsevpOps
   {

      type EventIteratorByItemAndDesignation[+E, +AssignedEventType <: TsevpEventType]
         >: EvtIteratorImplByItemAndDesignationCovar[E, AssignedEventType ]
         <: EvtIteratorImplByItemAndDesignationCovar[E, AssignedEventType ]

      def newEventEmitter[E](
         //

         evtType : TsevpEventType ,

      ) : (E => Unit , EventIteratorByItemAndDesignation[E, evtType.type] ) = {
         val peer = {
            new EventIteratorImpl[E, evtType.type](
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
      = EventIteratorByItemAndDesignation[E, TsevpEventType ]

   /**
    * 
    * the base-type for *event iterator*s.
    * must maintain `the item-type`.
    * 
    * in addition,
    * for purpose of defining additional/extra ops, often restricted to instances of certain specialisations,
    * needs to maintain additional tagging(s), like `AssignedEventType`
    * 
    * when `the evt-type` is `ofUpdate`, to establish *idempotence*,
    * `flatMap`
    * may drop, from the callback-returned `IterableOnce`, all-but-the-last *item*s
    * 
    */
   type EventIteratorByItemAndDesignation[+E, +AssignedEventType <: TsevpEventType]
      <: (
         AnyRef
         & collection.WithFilter[E, [NewE] =>> EventIteratorByItemAndDesignation[NewE, AssignedEventType] ]
         & java.io.Closeable
      )

   def newEventEmitter[E](
      //

      evtType : TsevpEventType = {
         TsevpEventType.ofAction
      } ,

   ) : (E => Unit , EventIteratorByItemAndDesignation[E, evtType.type] )
   
   extension [E](itr0: EventIterator[E] ) {

      def asOfNewEventType(newEvtType : TsevpEventType): EventIteratorByItemAndDesignation[E, newEvtType.type] = {

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

      /* flatten */ extension [OriginalItrItem, AssignedEventType <: TsevpEventType ](originalIterator: EventIteratorByItemAndDesignation[OriginalItrItem , AssignedEventType ] ) {

         /**
          * 
          * mimics the same-named method in `IterableOnceOps` .
          * mainly for filtering-or-mapping the items (*event*s) ;
          * does not switch `designation` at all .
          * 
          */
         def flatten[NewItrValue](using OriginalItrItem <:< IterableOnce[NewItrValue] ) = {

            originalIterator
            .flatMap(summon[OriginalItrItem <:< IterableOnce[NewItrValue] ] )
         }

      } /* flatten */

      extension [OriginalItrItem, AssignedEventType <: TsevpEventType ](originalIterator: EventIteratorByItemAndDesignation[OriginalItrItem , AssignedEventType ] ) {

         /**
          * 
          * mimics the same-named method in `IterableOnceOps` .
          * mainly for filtering-or-mapping the items (*event*s) ;
          * does not switch `designation` at all .
          * 
          */
         def collect[Value](f: PartialFunction[OriginalItrItem, Value] ) = {

            originalIterator
            .flatMap((f.lift).apply _ )
         }

      }

      extension [E, AssignedEventType <: TsevpEventType ](itr0: EventIteratorByItemAndDesignation[E , AssignedEventType ] ) {

         /**
          * 
          * mimics the same-named method in `IterableOnceOps` .
          * mainly for filtering-or-mapping the items (*event*s) ;
          * does not switch `designation` at all .
          * 
          */
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
          * turns into `TsevpEventType.ofUpdate.Inheritor`; this is all about *state*
          * 
          */
         def scanLeft[State](seed: State )(digest: (State, OriginalItrItem) => State ) : (
            //
            EventIteratorByItemAndDesignation[State, TsevpEventType.ofUpdate.type ]

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

      extension [OriginalItrItem, AssignedEventType <: TsevpEventType ](originalIterator: EventIteratorByItemAndDesignation[OriginalItrItem , AssignedEventType ] ) {

         def deduplicate()(using itsIdempotentality: AssignedEventType <:< TsevpEventType.ofUpdate.type ) = {

            originalIterator
            .scanLeft[Option[OriginalItrItem] ](None )({

               case (state0 : Option[s], newItem ) =>
                  if state0 == Some(newItem) then
                     None
                  else Some(newItem)

            })
            .flatten
            // match { case itr => val itrFltCode = ((e => Some(e) ) : ((e: String ) => Some[e.type] ) )(compiletime.codeOf({ val itr1 = itr ; itr1.flatten }) ) ; itr.flatten }
         }

      }

      extension [OriginalItrItem ](originalIterator: EventIteratorByItemAndDesignation[OriginalItrItem, TsevpEventType.ofUpdate.type ] ) {

         /**
          * 
          * mimics `Iterator.instance.sliding(.....)`
          * 
          */
         def sliding(size: Int, step: Int ) = {

            originalIterator
            .slidingImpl(expectedLength = size, step = step )
         }

         private[TsevpIterableOnceOpDefs]
         def slidingImpl(expectedLength: Int, step: Int ) = {

            originalIterator
            .scanLeft[IndexedSeq[OriginalItrItem] ](Vector() )({

               case (bufferedItems0, newItem) =>
                  //
                  
                  bufferedItems0

                  match { case bufferedItems => {

                     /**
                      * deduce, if reaching `expectedLength`,
                      * by `step`
                      */
                     if bufferedItems.length <= expectedLength then 
                        bufferedItems
                     else bufferedItems.drop(step )
                  } }
                  
                  match { case bufferedItems => {
                     
                     /**
                      * append `newItem`, and then
                      * truncate to the rightmost `expectedLength` items
                      */
                     bufferedItems
                     .appended[OriginalItrItem ](newItem )
                     .takeRight(expectedLength )
                  } }

            })
            .filter((bufferedItems0: IndexedSeq[?]) => {

               expectedLength <= bufferedItems0.length
            } )
         }

      } /* `sliding` */

      extension [OriginalItrItem, AssignedEventType <: TsevpEventType ](originalIterator: EventIteratorByItemAndDesignation[OriginalItrItem , AssignedEventType ] ) {

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

      extension [OriginalItrItem, AssignedEventType <: TsevpEventType ](originalIterator: EventIteratorByItemAndDesignation[OriginalItrItem , AssignedEventType ] ) {

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

         def takeWhile(f: OriginalItrItem => Boolean ) = {

            /**
             * 
             * the resulting iterator
             * needs to bbe closed upon termination
             * 
             */
            {
               
               lazy val newItr : EventIteratorByItemAndDesignation[OriginalItrItem, AssignedEventType] = {

                  originalIterator
                  .collect({
                     ((item : OriginalItrItem ) => Some(item).filter(f) ).unlift
                     .orElse({ case _ if { newItr.close() ; false } => throw new AssertionError() })
                  }) 
               }

               newItr
            }
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










































