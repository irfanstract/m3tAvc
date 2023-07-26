package avcframewrk.util.impl

val _ = {}









import cbsq.avc.*






/**
 * 
 * an alias to `tsevpFactoryImpl`.
 * guaranteed by the bin/compat/interop spec
 * to be exempt from synthetic nesting (eg which would result in some changing/unstable mangling conv(s) like `event$$minusitr$$package$.tsevpFactoryImpl()` ).
 * 
 */
object TsevpFactoryImpl {

   def apply()
   : tsevpFactoryImpl.type
   = tsevpFactoryImpl

}

final
lazy
val tsevpFactoryImpl : tsevp.XFactoryOps = {

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
         (AssignedEvtType)
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
                  case s @ (_ :+ lastItem) if (mayFlatMappingInstanceImposeIdempotenceByOmissiveBehv && evtType.necessitatesIdempotence ) =>
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
   
   object g1 extends AnyRef
   {

      export tsevp.XFactoryOps

      object factory extends 
      AnyRef with XFactoryOps
      {
         
         type InstanceByItemAndDesignation[+E, +AssignedEventType <: TsevpEventType]
            >: EvtIteratorImplByItemAndDesignationCovar[E, AssignedEventType ]
            <: EvtIteratorImplByItemAndDesignationCovar[E, AssignedEventType ]

         def newPipe[E](
            //

            evtType : TsevpEventType
            ,

         )
         = {

            val peer = {

               new EventIteratorImpl[E, evtType.type](
                  //
                  evtType = evtType ,
                  lastKnownValueOption = None ,
               )
               
               match { case c => evtType.pretendEvtItrAsBeingOfThisType(c) }
            }

            ((e: E) => require(peer.propagateItem(e), s"failing the emit of ${e}" ) , peer )
         } /* `newPipe` */
         
      }
      
   }
   g1.factory
}











