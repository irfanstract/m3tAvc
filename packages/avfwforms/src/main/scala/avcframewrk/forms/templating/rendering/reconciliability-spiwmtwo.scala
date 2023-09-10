package avcframewrk.forms

package templating

package rendering





















import reconciliabilityC.{*, given }

/**
 * a pair, which's
 * a `SpawnabilityAndReconciliabilityNoArg` and a "data-model"
 * 
 * refines the tuple-type to achieve that 'dependent-typing' of `_1`:
 * - narrowed to
 *   a/any `SpawnabilityAndReconciliabilityNoArg` which allows `(this : (SpawnabilityAndReconciliability, Mdl ) )._2` to be *the model*s
 *   ;
 * - without this narrowing,
 *   there'll be no guarantee that the `SpawnabilityAndReconciliability` could be used with `(this)._2`
 * 
 */
// private[avcframewrk]
type SpiwmTwos[+Mdl, Sp, +R]
= (
   /**
    * to avoid the "unreducible applic with wildcard args" complaint,
    * 
    * we
    * make it a conjunction of two,
    * one being a refined-type, leaving those type-param(s) wildcards, and
    * the next one being the one instantiating them as we demand
    * 
    */

   (
      (SpawnabilityAndReconciliabilityNoArg[?, ?, ? ], Any )
      {
         //
         /** 
          * narrowed to
          * a/any `SpawnabilityAndReconciliabilityNoArg` which allows `(this : (SpawnabilityAndReconciliability, Mdl ) )._2` to be *the model*s
          * 
          * without this narrowing,
          * there'll be no guarantee that the `SpawnabilityAndReconciliability` could be used with `(this)._2`
          * 
          * we leave the other type-arg(s) wildcards, as
          * the remaining type-conjunction will narrow its type further
          * 
          */
         val _1 : SpawnabilityAndReconciliabilityNoArg[_2.type, ?, ? ]
      }
   )
   & /* the not-so-interesting part, necessary to apply the remaining necessary specialisations */
   (SpawnabilityAndReconciliabilityNoArg[?, Sp, R], Mdl )
)

extension [
   //
   Mdl ,
   Spawned   ,
   U ,
](s: SpiwmTwos[Mdl, Spawned, U ])
   //

   // transparent inline
   def spawnThisSpiwmTwos()
   = {
      implicit
      val sp: s._1.type = s._1
      /* needed to desugar this `extension` dispatch, to avoid the ambiguity risking an infinite-looping */
      sp.spawn(s._2)( )
   }

   // transparent inline
   def doSpiwmTwoReconciliationOf(target: Spawned )
   = {
      implicit
      val sp: s._1.type = s._1
      /* needed to desugar this `extension` dispatch, to avoid the ambiguity risking an infinite-looping */
      sp.model_=(target)(s._2 )
   }

val _ = {
   ((arg : SpiwmTwos[1, 2, 3] ) => {})
   .nn
}












val _ = {}
