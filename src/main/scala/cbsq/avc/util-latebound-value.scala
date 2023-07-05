package cbsq.avc


















object LateBoundValue
{

   def newInstance[V] : (
      AnyRef
      with NhwCompleteWith[V]
      with NhwGetValue[V]
   
   ) = {
      newHolderWithConstraints1[V]()
   }

   def ofAlreadyResolvedWithValue[V](value: V) : (
      AnyRef
      with NhwGetValue[value.type ]
   
   ) = {
      val p = newInstance[value.type]
      p success value
      p
   }

   if false then {

      val randomFloat = math.random()

      val prm = LateBoundValue.ofAlreadyResolvedWithValue(randomFloat)
      
      summon[util.NotGiven[prm.type <:< NhwCompleteWith[?] ] ]

      summon[prm.value.type <:< randomFloat.type ]
      
   }

   lazy val ofAlreadyResolvedWithUnit = {
      ofAlreadyResolvedWithValue[Unit](() )
   }

   if false then {

      summon[util.NotGiven[ofAlreadyResolvedWithUnit.type <:< NhwCompleteWith[?] ] ]

      summon[ofAlreadyResolvedWithUnit.value.type <:< Unit ]

   }

   if false then {
      ofAlreadyResolvedWithValue(() )
      ofAlreadyResolvedWithValue(5 )
      ofAlreadyResolvedWithValue("true" )
      ofAlreadyResolvedWithValue(true )
   }

   def byFuture[E](f: concurrent.Future[E] ) = {
      
      val derived = LateBoundValue.newInstance[E] 

      (derived match { case e : NhwPrm[E] => e }) completeWith(f)

      derived 
   }

   /**
    * 
    * defines a single `val` in-turn referencing some `Promise[Future[V ] ]`.
    * 
    */
   @deprecated("experimental")
   trait NhwPrm[V]
   extends   
      AnyRef
   {

      val prmPr : concurrent.Promise[concurrent.Future[V] ] 

   }

   trait NhwCompleteWith[-V]
   extends 
      AnyRef
   {
      this : (
         AnyRef
         & NhwPrm[? >: V]
         
      ) =>

      /**
       * 
       * equivalent to `Future.instance.success`.
       * 
       */
      def success(v: V) : Unit = {
         prmPr
         .success({
            concurrent.Future.successful(v : v.type )
         })
      }
      
      /**
       * 
       * equivalent to `Future.instance.complete`.
       * 
       */
      def complete(v0: util.Try[V]) : Unit = {
         prmPr
         .success({
            concurrent.Future.fromTry(v0 )
         })
      }
      
      /**
       * 
       * sets the final `Future`;
       * only can be called once, unlike `Future.instance.completeWith`.
       * 
       */
      export prmPr.{
         success => completeWith ,
      }

      /**
       * 
       * equivalent to `Future.instance.tryComplete`.
       * 
       */
      def tryComplete(v0: util.Try[V]): Boolean = {
         prmPr
         .trySuccess({
            concurrent.Future.fromTry(v0 )
         })
      }
      
      /**
       * 
       * sets the final `Future`;
       * only can happen once, unlike `Future.instance.tryCompleteWith`.
       * 
       */
      export prmPr.{
         trySuccess => tryCompleteWith ,
      }

   }

   trait NhwAsFuture[+V]
   extends   
      AnyRef
   {

      val asFuture: concurrent.Future[V]

   }

   @deprecatedInheritance("the set of abstract-methods may change")
   trait Nhw[V]
   extends 
      AnyRef
      with NhwAsFuture[V]
      with NhwCompleteWith[V]
      with NhwGetValue[V]
   {
      this : (
         AnyRef
         & NhwPrm[V]
         & NhwAsFuture[V]

      ) =>

      /**
       * 
       * `asFuture`.
       * supposed to be `asPromise.future`.
       * 
       */
      export asFuturesValImpls.asFuture

      /**
       * 
       * `lazy val`s can't override `non-lazy val`s
       * 
       */
      private[Nhw]
      object asFuturesValImpls {
         
      final      
      lazy val asFuture = {
         prmPr
         .future
         .flatten
      }

      }

   }

   trait NhwGetValue[+V]  
   extends 
      AnyRef
      with NhwAsFuture[V]
   {
      this : (
         AnyRef
         & NhwAsFuture[V]

      ) =>

      /* TODO hide this */
      opaque type Gv <: V = V

      /** 
       * 
       * `await(asFuture) : V`
       * 
       */
      final
      lazy val value: Gv = {
         getValue()
      }
      
      /** 
       * 
       * `await(asFuture) : V`
       * 
       * no need to make this method private as it will always return the same value
       * 
       */
      def getValue(): Gv = {

         import concurrent.duration.*

         val timeout : FiniteDuration = {
            nhwgvTimeoutPolicies
            .getTimeoutValue()
         }

         for (_ <- startTimingOutIterator(timeout = timeout ) ) {
            try {
               return {
                  concurrent.Await.result(asFuture, 100.milliseconds )
               }
            }
            catch {
               case z : java.util.concurrent.TimeoutException =>
            }
         }

         throw new java.util.concurrent.TimeoutException(s"time up ($timeout); consider manual await with larger timeout")

      }

   }

   object NhwGetValue {
      implicit
      def asIterableOps[V](src : NhwGetValue[V] ): NhwIterableOpsImpl[V, NhwGetValue] = {

         new NhwIterableOpsImpl(
            //
            src = src,
            wrp = [E] => (f: concurrent.Future[E]) => byFuture(f) ,
            
         )
      }
      
   } /* `NhwGetValue` */

   protected 
   class newHolderWithConstraints1[V](

   )
   extends
      AnyRef
      with Nhw[V]
      with NhwPrm[V]
   {

      override
      val prmPr = {
         concurrent.Promise()
      }

      override
      def toString(): String = {
         s":${asFuture.toString() }"
      }
      
   }
   protected[LateBoundValue] 
   case
   class NhwIterableOpsImpl[V, +CC[V1] <: NhwAsFuture[V1] ](
      //
      val src : NhwAsFuture[V],
      wrp : [V1] => concurrent.Future[V1] => CC[V1]
         
   ) extends 
   collection.WithFilter[V, CC ]
   {

      def foreach[U](f: V => U) = {

         map(f)
      }

      def map[B](f: V => B) = {

         src.asFuture
         match { case c => c.map(f)(using concurrent.ExecutionContext.parasitic ) }
         match { case c => wrp(c) }
      }

      @deprecated("'flatMap' signature-wise does not prevent violating the invariant \"only one value\" (eg by expanding to more-than-one values). ")
      def flatMap[B](f: V => scala.collection.IterableOnce[B]) = {

         map((val0: V ) => {

            val val1 +: remainingVal1 = {

               f(val0)
               .iterator
               .toIndexedSeq
            }

            for (_ <- remainingVal1 ) {
               throw new IllegalArgumentException(s"got more than one values. ($val1 +: $remainingVal1 ) ")
            }

            val1
            
         })
      }

      def collect[B](q: PartialFunction[V, B]) = {

         flatMap((q.lift).apply _ )
      }

      def filter(q: V => Boolean) = {

         flatMap(v => Some(v).filter(q) )
      }

      def withFilter(q: V => Boolean) = {

         filter(q )
         match { case c => copy[V, CC ](src = c ) }
      }
      
   }
   
   private[LateBoundValue]
   def startTimingOutIterator(
      timeout : concurrent.duration.Duration ,
      
   ): Iterator[Unit] = {

         import concurrent.duration.*

         (
            new collection.AbstractIterator[Unit] {

               protected 
               val initialT = 0.seconds.fromNow

               def hasNext = {
                  (0.seconds.fromNow - initialT ) < timeout
               }

               def next = {}
               
            }
         )
         
   }

   @deprecated("experimental")
   object nhwgvTimeoutPolicies
   {

      def getTimeoutValue(): concurrent.duration.FiniteDuration = {

         timeoutValueThreadLocal
         .get().nn

      }

      def setTimeoutCtxValue(
         value: concurrent.duration.FiniteDuration,
         
      ): Unit = {

         timeoutValueThreadLocal
         .set(value )

      }

      private[nhwgvTimeoutPolicies ] 
      val timeoutValueThreadLocal = {

         new InheritableThreadLocal[concurrent.duration.FiniteDuration]() {
            set({
               import concurrent.duration.*
               24.hours
            })
         }
         
      }

   }

}

















































































































