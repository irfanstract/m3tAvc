package avcalculus

package signalprocessing
















object FrequencyKeyedTable
{
  ;

  ;

  ;

  type _Any
  = ByKAndV[FktQuant, Any]

  type ByEntryValue[+V]
  = ByKAndV[FktQuant, V]

  type ByKAndV[+K <: FktQuant, +V]
  >: FktMap.ByKAndV[K, V]
  <: FktMap.ByKAndV[K, V]

  lazy val _ = {
    ;
    (??? : ByKAndV[compiletime.ops.int.ToDouble[compiletime.ops.string.Length["key"] ] , "value"] )
  }

  extension [K <: FktQuant, V] (this1: ByKAndV[K, V ] ) {
    //

    /** 
     * search for row whose `K` is the "closest" to the given `K`.
     * will make the "closest" comparison an 'NN' lookup in exponential-scale.
     * 
     */
    def searchClosestToKey
      (k: FktQuant)
    = {
      ;
      import math.{log1p as spclLogh}
      this1
      .toSet
      .toIndexedSeq
      // TODO
      .sortBy({
        case (qndK, value) =>
          (spclLogh(qndK) - spclLogh(k) ).abs
      })
      .headOption
    }

  }

  ;

  ;

  ;
}

type FktQuant
>: Double
<: Double







object FktMap
{
  ;

  ;

  type ByKAndV[+K, +V]
  = Impl[Nothing, K, T3Base, V ]

  protected
  opaque type Impl
    [-KL <: KU, +KU, -T3, +ValU]
  <: (
    // collection.immutable.Map[? <: KU, ValU]
    AnyRef
  )
  = collection.immutable.Map[? >: KL <: KU, ValU]

  /* for that one unused Type-param */
  protected
  type T3Base
  <: Nothing

  extension [
    KL <: KU,
    KU,
    ValU ,
    Self
    >: Impl[KL, KU, T3Base, ValU ]
    <: Impl[KL, KU, T3Base, ValU ]
    ,
  ] (receiver: Self ) {
    //

    def asWideningMapOps
    : (
      //
      collection.immutable.MapOps[? >: KU, ValU, [X, Y] =>> Impl[X, X, T3Base, Y ], ? ]
    )
    = {
      ;
      receiver
      .map[KU, ValU] (<:<.refl )
      .nn
    }

    def asNarrowingMapOps
    : (
      //
      collection.immutable.MapOps[? >: KU <: KU, ValU, [X, Y] =>> Impl[X, X, T3Base, Y ], (
        // Self
        // |
        Impl[KU, KU, T3Base, ValU ]
      ) ]
    )
    = {
      ;
      receiver
      .map[KU, ValU] (<:<.refl )
      .match { case map => map }
      .match { case map => map }
    }

    export asWideningMapOps.{apply as getValue }

    export asNarrowingMapOps.{toMap }

    export asNarrowingMapOps.{map, filter }

    export asNarrowingMapOps.{toSet }

    export asNarrowingMapOps.{mkString }

  }


  ;
}













