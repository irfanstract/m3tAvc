package cbsq.avc
















transparent inline
def getInterfaceNoOpInstance[I <: AnyRef : NoOpImplOfInterface.NeitherAnyNorNothing : reflect.ClassTag ]() : I = {

   NoOpImplOfInterface.instanceOfThese[I]
   
}

object NoOpImplOfInterface
{

   type NeitherAnyNorNothing[I]
      >: util.NotGiven[(I, I) <:< ((Any, Nothing) | (Nothing, Any) ) ]
      <: util.NotGiven[(I, I) <:< ((Any, Nothing) | (Nothing, Any) ) ]

   // // private[NoOpImplOfInterface]  
   // def instanceOfThese[
   //    I1 <: AnyRef : reflect.ClassTag ,

   // ] : (
   //    AnyRef
   //    & I1
   // ) = {
      
   //    import language.unsafeNulls
      
   //    instanceOfTheseAll[(
   //       Tuple1[I1]
   //    )]
   //    .asInstanceOf[(
   //       AnyRef
   //       & I1
   //    )]
      
   // }
   
   // // private[NoOpImplOfInterface]
   // def instanceOfThese[
   //    I1 <: AnyRef : reflect.ClassTag ,
   //    I2 <: AnyRef : reflect.ClassTag ,

   // ] : (
   //    AnyRef
   //    & I1
   //    & I2
   // ) = {
      
   //    import language.unsafeNulls
      
   //    instanceOfTheseAll[(
   //       I1 ,
   //       I2 ,
   //    )]
   //    .asInstanceOf[(
   //       AnyRef
   //       & I1
   //       & I2
   //    )]
      
   // }

   def instanceOfThese[
      I1 <: AnyRef : reflect.ClassTag ,

   ] = instanceOfTheseAll[Tuple1[I1] ]

   def instanceOfThese[
      I1 : reflect.ClassTag ,
      I2 : reflect.ClassTag ,

   ] = instanceOfTheseAll[(I1, I2 )]

   def instanceOfThese[
      I1 : reflect.ClassTag ,
      I2 : reflect.ClassTag ,
      I3 : reflect.ClassTag ,

   ] = instanceOfTheseAll[(I1, I2, I3)]
   
   def instanceOfThese[
      I1 : reflect.ClassTag ,
      I2 : reflect.ClassTag ,
      I3 : reflect.ClassTag ,
      I4 : reflect.ClassTag ,

   ] = instanceOfTheseAll[(I1, I2, I3, I4)]
   
   // private[NoOpImplOfInterface]
   inline def instanceOfTheseAll[Ts <: Tuple] : IITAImplement[Ts] = {
      
      import language.unsafeNulls
      
      java.lang.reflect.Proxy.newProxyInstance({
         new {}.getClass().getClassLoader()

      } , {
         (compiletime.summonAll[Tuple.Map[Ts, reflect.ClassTag ] ].toList.map({ case c : reflect.ClassTag[?] => c }) )
         .map(_.runtimeClass)

      }.toArray , {
         (_, _, _) => {
            // ()
            null
         }
         
      } )
      .asInstanceOf[IITAImplement[Ts] ]
      
   }

   protected 
   type IITAImplement[Ts <: Tuple] = 
      Ts match {

         case EmptyTuple.type =>
            AnyRef

         case t1 *: restTs =>
            t1 & IITAImplement[restTs]

      }

}

@main
def runInterfaceNoOpInstance() : Unit = {

   import language.unsafeNulls

   NoOpImplOfInterface.instanceOfThese[Runnable ].run()
   NoOpImplOfInterface.instanceOfThese[Function0[?] ].apply()
   
   println({
      NoOpImplOfInterface.instanceOfThese[Function1[?, ?] ]
      .getClass()
      .getInterfaces().toIndexedSeq
   })
   
   (util.Try { NoOpImplOfInterface.instanceOfThese[java.util.function.IntSupplier ].getAsInt() } )
   .failed.collect({ case z : (NullPointerException | ClassCastException) => z }).get

   locally {
      val i = NoOpImplOfInterface.instanceOfThese[Function1[?, ?], Runnable, java.io.Serializable ]
      i.asInstanceOf[Unit => Unit ].apply(() )
      i.run()
      println(i.getClass().getInterfaces().toIndexedSeq )
   }

   locally {
      val i = NoOpImplOfInterface.instanceOfThese[Function2[?, ?, ?], Runnable, java.io.Closeable, java.lang.Cloneable ]
      i.asInstanceOf[(Unit, Unit) => Unit ].apply((), () )
      i.run()
      i.close()
      println(i.getClass().getInterfaces().toIndexedSeq )
   }

   locally {
      val i = NoOpImplOfInterface.instanceOfTheseAll[(Runnable, java.io.Closeable, java.lang.Cloneable ) ]
      i.run()
      i.close()
      println(i.getClass().getInterfaces().toIndexedSeq )
   }

   println(s"done")
   
}




































