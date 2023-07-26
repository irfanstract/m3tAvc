package cbsq.avc

























export tsevp.EventIterator

export tsevp.EventIteratorByItemAndDesignation

export tsevp.newEventEmitter

protected
type TsevpOps
   = tsevp.type

object tsevp
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
      = factory.InstanceByItemAndDesignation[E, AssignedEventType]

   final
   lazy
   val factory : XFactoryOps = {

      /**
       * 
       * we
       * externed the actual implementation
       * to reduce-or-avoid bootstrap overheads
       * 
       */
      {
         import language.unsafeNulls
         java.lang.Class.forName("avcframewrk.util.impl.TsevpFactoryImpl").getMethod("apply") /* zero-arg */
         .invoke(null)
         .asInstanceOf[XFactoryOps]
      }
   }

   // sealed 
   trait XFactoryOps
   {

      type InstanceByItemAndDesignation[+E, +AssignedEventType <: TsevpEventType]
         <: (
            AnyRef
            & collection.WithFilter[E, [NewE] =>> InstanceByItemAndDesignation[NewE, AssignedEventType] ]
            & java.io.Closeable
         )
      
      /**
       * 
       * allocates a new pipe and
       * returns a pair of itc(s) together proxying the both sides of that (newly-allocated) pipe
       * 
       */
      def newPipe[E](
         //

         evtType : TsevpEventType
         ,

      ) : (E => Unit , InstanceByItemAndDesignation[E, evtType.type] )
      
      opaque type NewvetImplSpecificToken <: Any
         = Unit
      protected
      given NewvetImplSpecificToken = ()

   }

   def newEventEmitter[E](
      //

      evtType : TsevpEventType = {
         TsevpEventType.ofAction
      } ,

   ) = {

      factory.newPipe[E](evtType = evtType )
   }
   
   extension [E](itr0: EventIterator[E] ) {

      def asOfNewEventType(newEvtType : TsevpEventType): EventIteratorByItemAndDesignation[E, newEvtType.type] = {

         val (p, itr1) = {
            newEventEmitter[E](evtType = newEvtType )
         }

         itr0 foreach(p)

         itr1
      }
      
   }

}

// export avcframewrk.util.effectsystem.{EventSeqEffectExtent as TsevpEventType }
final
lazy
val  TsevpEventType = avcframewrk.util.effectsystem.EventSeqEffectExtent
type TsevpEventType = avcframewrk.util.effectsystem.EventSeqEffectExtent

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

         /**
          * 
          * given this *state-update iterator*,
          * return
          * one which reduces consecutive duplicates into one
          * 
          */
         def deduplicate()(using itsIdempotentality: AssignedEventType <:< TsevpEventType.ofUpdate.type ) = {

            originalIterator
            .scanLeft[Option[OriginalItrItem] ](None )({

               case (state0 : Option[s], newItem ) =>
                  //

                  locally[Option[newItem.type] ] {
                     
                     if state0 == Some(newItem) then
                        None
                     else Some(newItem)
                  }

            })
            .flatten
            // match { case itr => val itrFltCode = ((e => Some(e) ) : ((e: String ) => Some[e.type] ) )(compiletime.codeOf({ val itr1 = itr ; itr1.flatten }) ) ; itr.flatten }
         }

      } /* deduplicate */

      extension [OriginalItrItem ](originalIterator: EventIteratorByItemAndDesignation[OriginalItrItem, TsevpEventType ] ) {

         /**
          * 
          * mimics `Iterator.instance.sliding(.....)`
          * 
          */
         def sliding(size: Int, step: Int )
         (using itsNonIdempotentiality: originalIterator.type <:< EventIteratorByItemAndDesignation[Any, TsevpEventType.ofAction.type] )
         = {

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










































