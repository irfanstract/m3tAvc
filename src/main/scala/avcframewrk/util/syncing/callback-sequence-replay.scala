package avcframewrk.util.syncing



















object CallbackSequenceReplay
{

   //

   /**
    * 
    * a helper to
    * allow later-added decorators
    * to automatically be applied to instances of `C` already passed-in-to `addOperand`
    * 
    * the templates returned by `avcframewrk.forms.impl.allInterfacesGivens.main`
    * are not directly an instantiated `awt.Component`s (since that'd prevent reuse), but instead
    * a "zero-arg factory" (eg `DefinesGetNewInstanceNoArg`) which produces those.
    * the ability to `theTemplate.newInstance()` more-than-once,
    * combined with
    * the imperativity (to make it a drop-in sub of the typical `swing.JYyyComponent`s) of
    * the interface(s) returned by the methods `newYyyPanel(.....)`,
    * this additional complexity becomes essential.
    * 
    */
   // private[CallbackSequenceReplay] 
   class XDecorativeFncQueue[C : avcframewrk.util.errorchecking.EvidenceOfBeingNeitherExactlyAnyNorNothing]()
   {

      import language.unsafeNulls

      def addOperand(c: C ): Unit = {
         
         oph ensureOped c

      }

      private[XDecorativeFncQueue]
      val oph = {
         new XIdempotentInitOperandList[C](onReg = c => {
            
            concurrent.Future[Unit]({
               ;
               
               allDecorators
               .map(decorate1 => {
                  decorate1(c)
               })
               /**
                * 
                * `LazyList`s are by-definition *lazy*.
                * needs explicit `foreach`.
                * 
                * alternatively `to(Vector)` would also work, but that's unsemantic
                * 
                */
               .foreach({ case _ => })

            })(using servicingThread)

         })
      }

      protected 
      lazy
      val servicingThread: concurrent.ExecutionContext = {

         concurrent.ExecutionContext.global
      }

      def addOperator(f: C => Unit ): Unit = {

         addDecorator1(f)
         
      }

      private[XDecorativeFncQueue]
      val (addDecorator1, allDecorators) = {
         newXcdfLl[C, Unit]()
      }

   }

   /**
    * 
    * secondary `ensureOped` invoc "with given instance of `C`"
    * will not make the callback run twice (ie the callback will only run once)
    * 
    */
   // private[CallbackSequenceReplay] 
   class XIdempotentInitOperandList[C : avcframewrk.util.errorchecking.EvidenceOfBeingNeitherExactlyAnyNorNothing ](onReg : C => Unit )
   {

      import language.unsafeNulls

      private[XIdempotentInitOperandList]
      val alreadyOpedItems = {
         new java.util.concurrent.atomic.AtomicReference[Set[C] ](Set() )
      }

      def ensureOped(c: C) : Unit = {
         
         val alreadyOped = {

            alreadyOpedItems
            .getAndUpdate({ case operands0 => operands0.incl(c) })
            .contains(c)
         }

         if !alreadyOped then {
            onReg(c)
         }

      }

   }

   /**
    * 
    * used above
    * 
    */
   private[avcframewrk] 
   def newXcdfLl[C, R]()(using avcframewrk.util.errorchecking.EvidenceOfBeingNeitherExactlyAnyNorNothing[C] ) : ((C => R ) => Unit , LazyList[C => R] ) = {

      newLazyListPipe[C => R]()
   }

   /**
    * 
    * the 2nd itc is
    * an infinite-length `LazyList`
    * whose items are the values submitted onto the *callback* returned as the 1st itc (in order)
    * 
    * `LinkedBlockingQueue` and the sibling alternatives
    * rejects `null`s.
    * 
    */
   def newLazyListPipe[Item]( )(using util.NotGiven[Null <:< Item] ) : (Item => Unit , LazyList[Item] ) = {

      import language.unsafeNulls

      val ebq = {
         new java.util.concurrent.LinkedBlockingQueue[Item ]()
      }
      
      val dequeueingLl = {
         LazyList.continually(ebq.take().nn )
      }

      (ebq.put _ , dequeueingLl )
   }

}






























