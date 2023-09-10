package avcframewrk.forms

package templating

package w3e.impl.js.s1

















transparent inline
def typeable[T]
= {
   // summonHereNotInline[reflect.Typeable[T] ]
   summon[reflect.Typeable[T] ]
}

given given_TypeTest_AnyToOptionOfT[T2]
   (using reflect.TypeTest[Any, T2] )
: reflect.TypeTest[Any , Option[T2] ]
with {

   override
   def unapply(e: Any )
   = {
      Some[e.type ](e)
      .collect({ case e1 @ (None | Some(_ : T2) ) => e1 })
      .map[e.type & Option[T2] ](_ => e.asInstanceOf[e.type & Option[T2] ] )
   }

} // given_TypeTest_Any_Option

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

/**
 * 
 * "close" all the specified "resource"s, by iterating over them in reverse and "close"ing each
 * 
 */
def closeAllOf
   [
      Res
      : util.Using.Releasable
      ,
   ]
   (resources : Seq[Res ] )
: Unit
= {
   ;

   ;

   util.Using.Manager(m => {
      ;

      for (r <- resources.reverse ) {
         m(r)
      }
   })

   ;
} // closeAllOf

given [T0]
: util.Using.Releasable[monix.reactive.Observer[?] ]
= r => r.onComplete()

given given_Releasable_Laminar_Observer[T0]
: util.Using.Releasable[com.raquo.airstream.core.Observer[?] ]
= r => { } // TODO

/**
 * strives for `monix.execution.Scheduler(concurrent.ExecutionContext.parasitic )`, but
 * since the factory overload was unavailable/missing in the JS build of Monix
 * we needed to resort back to `monix.execution.Scheduler.global`
 * 
 */
def trySameThreadScheduler()
: monix.execution.Scheduler
= monix.execution.Scheduler.global

















val _ = {}
