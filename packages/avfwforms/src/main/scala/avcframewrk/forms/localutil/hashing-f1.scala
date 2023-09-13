
package avcframewrk.forms

package localutil




















/**
 * 
 * `ValueToUidAssociator`
 * 
 * the impl of `ValueToUidAssociatorImpl`
 * is
 * an attempt/work on on-demand hashing via on-demand `i`-incrementation
 * 
 * 
 * @param id1 only for type-inference
 * 
 */
opaque type ValueToUidAssociator[Value]
<: ValueToUidAssociatorImpl[Value]
= ValueToUidAssociatorImpl[Value]

object ValueToUidAssociator
{
   ;

   ;

   def apply[Value]
   : ValueToUidAssociator[Value]
   = new ValueToUidAssociatorImpl[Value]

   ;

   ;

   ;
} // ValueToUidAssociator$

protected
class ValueToUidAssociatorImpl[Value]
{
   ;

   ;

   opaque type Id
   <: Matchable
   = Long

   override
   def toString(): String
   = {
      import language.unsafeNulls
      val cont = idToValueMapS.size
      s"ValueToUidStore[m: ${cont } ; ]"
   }

   /** 
    * update the Map to include
    * 
    * it's possible `v` already "exists" in the map -
    * in that case
    * just make it the existing map unchanged ;
    * `updatedWith` in `Map#`
    * 
    */
   def addReg(v: Value)
   : v.type
   = {
      /** 
       * update the Map
       * 
       * it's possible `v` already "exists" in the map -
       * in that case
       * just make it the existing map unchanged ;
       * `updatedWith` in `Map#`
       * 
       */
      valueToIdMap
      .update(m => {
         /** 
          * it's possible `v` already "exists" in the map -
          * in that case
          * just make it the existing map unchanged ;
          * `updatedWith` in `Map#`
          * 
          */
         m
         .updatedWith(v )(ent => (ent orElse Some(m.values.maxOption.getOrElse[Long](0).+(1) ) ) )
      } )

      assert(valueToIdMap.now().keySet contains v )

      /** 
       * return exactly the arg
       * 
       */
      v
   }

   private
   val valueToIdMap
   = com.raquo.airstream.state.Var[Map[Value, Id ] ](Map() )

   /** a public method to query the mapping `Value -> Id` */
   def valueToIdMapS
   : Map[Value, Id ]
   = valueToIdMap.now()

   /** a public method to query the mapping `Id -> Value` */
   def idToValueMapS
   : Map[Id, Value ]
   = valueToIdMapS.toSeq.map(_.swap).toMap

   def get(key: Id)
   : Value
   = { valueToIdMapS.toSeq.collect({ case (v, `key`) => v }) match { case Seq(v) => v } }

   def idOf(v: Value)
   : Id
   = valueToIdMapS apply(v )

   ;
}





































val _ = {}
