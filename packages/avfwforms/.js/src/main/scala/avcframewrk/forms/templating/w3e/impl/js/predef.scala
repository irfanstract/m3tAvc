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

/**
 * strives for `monix.execution.Scheduler(concurrent.ExecutionContext.parasitic )`, but
 * since the factory overload was unavailable/missing in the JS build of Monix
 * we needed to resort back to `monix.execution.Scheduler.global`
 * 
 */
def trySameThreadScheduler()
: monix.execution.Scheduler
= monix.execution.Scheduler.global

/**
 * like "pipe"s, but
 * instead of individual items we pass `Observable`s instead
 * 
 */
def newValueUpdateRepipe[R](
   //
   prototype
      : (value: R) => Any
   ,
)
= {
   ;

   implicit val scheduler
   = trySameThreadScheduler()

   avcframewrk.evm.AsyncAlgebraicItemStream.newReroutiblePipe[R ]()
} // newValueUpdateRepipe

/**
 * the consumer-side itc ref will never change identity ; only the impl will change .
 * like "pipe"s, but
 * instead of individual fnc(s) we pass `Observable`s emitting fnc(s) instead .
 * 
 */
def newCallbackImplUpdateRepipe
   [
      A,
      R,
   ]
   (
      //
      prototype
         : (arg: A) => R
      ,
      initialImpl
         : A => R
      = (_: Any) => { throw new IllegalStateException(s"no initial impl") }
      ,
   )
= {
   ;

   type F
   = (argOrCtx: A) => R

   implicit val scheduler
   = trySameThreadScheduler()

   avcframewrk.evm.AsyncAlgebraicItemStream.newReroutiblePipe[A => R ]()
   match { case (_1, _2) => {
      ;

      var vle
      : F
      = initialImpl

      _2
      .map(c => { vle = c } )
      .subscribe()

      locally[(_1.type, F )](_1, { (arg: A) => vle.apply(arg) } )
   } }
} // newCallbackImplUpdatePipe

















val _ = {}
