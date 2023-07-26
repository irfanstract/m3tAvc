package avcframewrk.util.xconcurrent.eventflow

val _ = {}











@deprecated
trait XAsyncMonadFactoryOps
extends
AsyncMonadFactoryOps

trait AsyncMonadFactoryOps
{

   type InstanceByItemAndDesignation[+E, +AssignedEventType <: XEffectExtent]
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

      evtType : XEffectExtent
      ,

   ) : (E => Unit , InstanceByItemAndDesignation[E, evtType.type] )
   
   opaque type NewvetImplSpecificToken <: Any
      = Unit
   protected
   given NewvetImplSpecificToken = ()

}

trait AsyncMonadXMissingSingleArgFunctory[+C <: Singleton & AsyncMonadFactoryOps](val c: C)
{
   
   final
   lazy
   val  TsevpEventType = XEffectExtent
   type TsevpEventType = XEffectExtent

   export c.{InstanceByItemAndDesignation => EventIteratorByItemAndDesignation }

   //

   /* the missing `IterableOps` stuffs */
   
   extension [
      OriginalItrItem,
      AssignedEventType <: TsevpEventType ,

   ](originalIterator: EventIteratorByItemAndDesignation[OriginalItrItem , AssignedEventType ] )
   {

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

   extension [
      OriginalItrItem,
      AssignedEventType <: TsevpEventType ,
      
   ](originalIterator: EventIteratorByItemAndDesignation[OriginalItrItem , AssignedEventType ] )
   {

      def tapEach[U](f: OriginalItrItem => U ) = {

         originalIterator
         .map(item => { f(item) ; item })
      }

   }

   extension [
      OriginalItrItem,
      AssignedEventType <: TsevpEventType,
      
   ](originalIterator: EventIteratorByItemAndDesignation[OriginalItrItem , AssignedEventType ] )
   {

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

   extension [
      E,
      AssignedEventType <: TsevpEventType ,
      
   ](itr0: EventIteratorByItemAndDesignation[E , AssignedEventType ] )
   {

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

}

trait AsyncMonadXExtraOps[+C <: Singleton & AsyncMonadFactoryOps](val c: C)
{

   //
   
}












