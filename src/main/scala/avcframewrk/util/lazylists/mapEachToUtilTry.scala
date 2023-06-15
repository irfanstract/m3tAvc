package avcframewrk.util.lazylists










type XByNameArg[+Value ]
   >: DummyImplicit ?=> Value
   <: DummyImplicit ?=> Value





extension [CC[A] <: collection.IterableOnceOps[A, CC, CC[A] ], E ](src: CC[E] ) {

   /**
    * 
    * . TODO
    * 
    * @param h will be run on exception - if the returned Throwable is a different one, shall log the existing
    * 
    */
   def asTerminatingOnException(
      //

      handleGivenException : XHge = {
         getDefaultXHge()
      } ,

   )(using CC[E] <:< Iterator[E] ): Iterator[E] = {

      new collection.AbstractIterator[E] {
         ;
         
         var stateVar: util.Either[Unit | Throwable, Unit] = {
            util.Right {}
         }

         private 
         val s = new AnyRef
 
         // TODO
         val synchronized     = [E] => (e: DummyImplicit ?=> E ) => (s synchronized { e } ) : E
         val synchronizedRead = [E] => (e: DummyImplicit ?=> E ) => (s synchronized { e } ) : E

         def state = (stateVar )

         final
         def stateTr = {
            
            (state )
            .left.map[Throwable]({
               case () =>
                  new java.util.NoSuchElementException
               case z : Throwable =>
                  z
            })
            .toTry
         }

         protected 
         def markAsClosedDueToException(z0 : Throwable): Unit = {
            
                  stateVar = util.Left(z0)

                  val z1 = {
                     {
                        try handleGivenException(z0)
                        catch {
                           case z1 =>
                              !(z1 == z0) && { z1 addSuppressed z0 ; true }
                              z1
                        }
                     }
                     match { case v => v : (Unit | Throwable) }
                  }
                  
                  stateVar = util.Left(z1)

         }

         override
         def hasNext: Boolean = synchronizedRead {
            
            try {
               state.isRight && src.hasNext
            }
            catch {
               case z =>
                  markAsClosedDueToException(z)
                  throw stateTr.failed.get
            }
         }

         def checkStillUp() : Unit = synchronizedRead {

            stateTr
            .get
         }

         override
         def next(): E = synchronized {

            checkStillUp()

            try src.next()
            catch {

               case z0 =>
                  
                  markAsClosedDueToException(z0)
                  
                  throw stateTr.failed.get

            }
         }
         
      }
   }

}

type XHge 
   >: Throwable => Unit
   <: Throwable => Unit
def getDefaultXHge() = {
         (z0 : Throwable ) => {
            import language.unsafeNulls
            throw z0
         }
}
def getConvertingXHge() = {
         (z0 : Throwable ) => {
            import language.unsafeNulls
            z0.printStackTrace(System.err )
            throw new java.util.concurrent.ExecutionException(s"can't continue, due to Exception, $z0", z0)
         }
}

extension [CC[A] <: collection.IterableOps[A, CC, CC[A] ], E ](src: CC[E] ) {

   def asTerminatingCollOnException(
      //
      
      handleGivenException : XHge = {
         getDefaultXHge()
      } ,

   )(using CC[E] <:< (collection.View[E] | LazyList[E] ) ) : CC[E] = {

      src
      .iterator
      .asTerminatingOnException(handleGivenException = handleGivenException )
      .to(src.iterableFactory)
   }
   
}






















