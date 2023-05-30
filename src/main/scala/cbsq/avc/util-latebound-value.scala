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
      lazy val prm : concurrent.Promise[V] 

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
      lazy val prmExportible = prm

      export prmExportible.{
         success ,
         complete ,
         completeWith ,
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
         prm.future
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

         while (true) {
            try {
               return {
                  concurrent.Await.result(asFuture, 5.seconds )
               }
            }
            catch {
               case z : java.util.concurrent.TimeoutException =>
            }
         }

         throw new java.util.NoSuchElementException

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
      lazy val prm : concurrent.Promise[V] = {
         concurrent.Promise[V]
      }

      override
      def toString(): String = {
         s":${asFuture.toString() }"
      }
      
   }

}

















































































































