package avcframewrk.util.concurrent.eventflow

val _ = {}











trait XFactoryOps
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












