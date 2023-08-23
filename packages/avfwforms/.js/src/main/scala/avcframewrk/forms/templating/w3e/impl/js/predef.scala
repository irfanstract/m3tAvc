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

   object Cio {

      trait ClassOps
         [
            +P <: ClassOps[P, C],
            +C <:  ClassInstanceOps[P, C],
         ]
      {
         // this : P =>

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
         // this : C =>

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
   
} // ParentChildRelationship$

















val _ = {}
