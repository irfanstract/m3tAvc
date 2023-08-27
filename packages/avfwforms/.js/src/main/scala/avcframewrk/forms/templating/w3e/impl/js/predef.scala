package avcframewrk.forms

package templating

package w3e.impl.js.s1

















transparent inline
def typeable[T]
= {
   // summonHereNotInline[reflect.Typeable[T] ]
   summon[reflect.Typeable[T] ]
}

object ParentChildRelationship {

   object Cio
   extends
   RelatorOps
   {

      trait ClassOps
         [
            +P <: ClassOps[P, C],
            +C <:  ClassInstanceOps[P, C],
         ]
      {
         this : P =>

         //

         //

         type InstanceOps
         <: (
            (ClassInstanceOps[P, C] {
               val class1 : P & ClassOps.this.type
            })
            &
            C
         )

         type Instance
         = InstanceOps
         
      } // ClassOps

      trait ClassInstanceOps
         [
            +P <: ClassOps[P, C],
            +C <: ClassInstanceOps[P, C],
         ]
      {
         this : C =>

         //

         //

         // protected 
         val class1
         : P

         final
         lazy val `class` : class1.type = class1
         
         final
         lazy val cls : class1.type = class1
         
      } // ClassInstanceOps

   } // Cio$

   trait RelatorOps
   {

      //

      type ClassOps
      <: AnyKind

      type ClassInstanceOps
      <: AnyKind

   } // RelatorOps

} // ParentChildRelationship$

@deprecated
class &@@!
   [
      +Receiver ,
      Src <: avcframewrk.evm.AsyncAlgebraicMonad[Any] ,
   ]
   (val e: Receiver, key: String, val dSrc : Src )
   (runPerRefreshCalls: (receiver: Receiver, state: ({ type Main[T <: Src ] = T match { case avcframewrk.evm.AsyncAlgebraicMonad[t] => t } })#Main[Src ] ) => Unit )
{

   ;

   e.asJsDynamic.updateDynamic(key )(( ) => {
      dSrc
      /*
       * to avoid infinite-looping, a latency will be necessary
       *
       */
      .delayOnNext({ import concurrent.duration.* ; 500.milliseconds })
      /*
       * "subscribe for only the first next item"
       *
       */
      .firstL
      /*
       * run the main callback
       *
       */
      .map((vl) => {
         runPerRefreshCalls(e, vl )
      } )
      /*
       * reschedule
       *
       */
      .map(v => {
         ;

         e.asJsDynamic.applyDynamic(key)( )

         ()
      })
   })
   e.asJsDynamic.applyDynamic(key)( )

} // &@@!

















val _ = {}
