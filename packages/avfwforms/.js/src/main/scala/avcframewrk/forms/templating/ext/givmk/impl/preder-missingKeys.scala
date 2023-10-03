package avcframewrk.forms

package templating

package ext.givmk

package impl


















;

;

// val preExistingSpawnedAttrsMap
// = {
//    ;

//    attrs

//    .toMapToPreSpawnedAttrs()
// }

// val allAttrs
// = {
//    Set.from[AttrKeyAndValuePairAny ] (preExistingSpawnedAttrsMap.keySet ++ incomingSetAttrs )
// }

// ({
//    ;

//    for {
//       _ @ (keyValuePair: AttrKeyAndValuePairByValue[vl] ) <- allAttrs
//    }
//    yield {
//       ;

//       preExistingSpawnedAttrsMap.get(keyValuePair)

//       .getOrElse[ByLlAttrPreparedImpl[?] ] ({
//          ;

//          keyValuePair

//          .pipeLooseSelf({

//             case keyValuePair: AttrKeyAndValuePairByValue[v] =>
//                ;

//                // TODO
//                given LlPropAnimableSettibility.GivenDefaultSequencingKV[keyValuePair.key.type, v ]
//                = LlPropAnimableSettibility.gdsBy(L.Val(keyValuePair.value : v ) )

//                new ByLlAttrPreparedImpl[v](keyValuePair.key, keyValuePair.asReselved)(llE)

//          })

//          .pipeLooseSelf(<:<.refl[ByLlAttrPreparedImpl[?] ] )
//       })

//       .pipeLooseSelf[(AttrKeyAndValuePairByValue[vl] , ByLlAttrPreparedImpl[? >: Nothing <: Any ] ) ] (e => (keyValuePair, e ) )
//    }
// })
// .toMap

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
