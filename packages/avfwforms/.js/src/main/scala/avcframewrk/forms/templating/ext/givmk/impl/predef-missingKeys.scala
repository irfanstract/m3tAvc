package avcframewrk.forms

package templating

package ext.givmk

package impl


















;

;

extension [K0, V0] (preExistingSpawnedAttrsMap : Map[K0, V0] ) {
   private def asPAMK = PAMK(preExistingSpawnedAttrsMap)
   export asPAMK.{patchedAtMissingKeys as patchedAtMissingKeys}
   export asPAMK.{patchedAtMissingKeys as withDefaultedKeys1 }
}

protected
case class PAMK [K0, V0] (preExistingSpawnedAttrsMap : Map[K0, V0] ) {
   //

   def patchedAtMissingKeys
      [K >: K0 <: K0, V >: V0 ]
      (incomingSetAttrs : collection.immutable.Iterable[K] )
      (f: K => V )
   : Map[K, V]
   = {
      ;

      val allAttrs
      = {
         Set.from[K ] (Seq() :++ preExistingSpawnedAttrsMap.keySet :++ incomingSetAttrs )
      }

      ({
         ;

         for {
            _ @ (keyValuePair ) <- allAttrs
         }
         yield {
            ;

            preExistingSpawnedAttrsMap.applyOrElse[K, V] (keyValuePair, f )

            .pipeLooseSelf[(K, V)] (e => (keyValuePair, e ) )
         }
      })
      .toMap
   }

   //
}

;



















val _ = {}
