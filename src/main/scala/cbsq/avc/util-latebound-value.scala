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

   def forValue[V](value: V) : (
      AnyRef
      with NhwGetValue[value.type ]
   
   ) = {
      val p = newInstance[value.type]
      p success value
      p
   }

   if false then {

      val randomFloat = math.random()

      val prm = LateBoundValue.forValue(randomFloat)
      
      summon[util.NotGiven[prm.type <:< NhwCompleteWith[?] ] ]

      summon[prm.value.type <:< randomFloat.type ]
      
   }

   lazy val ofUnit = {
      forValue[Unit](() )
   }

   if false then {

      summon[util.NotGiven[ofUnit.type <:< NhwCompleteWith[?] ] ]

      summon[ofUnit.value.type <:< Unit ]

   }

   if false then {
      forValue(() )
      forValue(5 )
      forValue("true" )
      forValue(true )
   }

   trait NhwCompleteWith[V]
   extends 
      AnyRef
   {

      private[LateBoundValue]
      lazy val prmPr : concurrent.Promise[concurrent.Future[V] ] 

      /**
       * 
       * the compiler refused to proceed when the prefix were `nonfinal lazy val`.
       * we can't make `prm` `final` as that'd defeat the purpose of this separation.
       * after all,
       * there's no need to precise the `export`s' typing
       * 
       */
      private[NhwCompleteWith]
      final
      lazy val prmPrExportible = prmPr

      def success(v: V) : concurrent.Promise[?] = {
         prmPr
         .success({
            concurrent.Future.successful(v : v.type )
         })
      }
      
      def complete(v0: util.Try[V]) : concurrent.Promise[?] = {
         prmPr
         .success({
            concurrent.Future.fromTry(v0 )
         })
      }
      
      export prmPrExportible.{
         success => completeWith ,
      }

      def tryComplete(v0: util.Try[V]): Boolean = {
         prmPr
         .trySuccess({
            concurrent.Future.fromTry(v0 )
         })
      }
      
      export prmPrExportible.{
         trySuccess => tryCompleteWith ,
      }

   }

   @deprecatedInheritance("the set of abstract-methods may change")
   trait Nhw[V]
   extends 
      AnyRef
      with NhwCompleteWith[V]
      with NhwGetValue[V]
   {

      override
      final      
      lazy val asFuture = {
         prmPr
         .future
         .flatten
      }

   }

   trait NhwGetValue[+V]
   {

      lazy val asFuture: concurrent.Future[V]

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

   protected 
   class newHolderWithConstraints1[V](

   )
   extends
      AnyRef
      with Nhw[V]
   {

      private[LateBoundValue]
      override
      lazy val prmPr = {
         concurrent.Promise()
      }

      override
      def toString(): String = {
         s":${asFuture.toString() }"
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

















































































































