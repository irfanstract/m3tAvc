
package avcframewrk.forms

package mutable

package w3e
















trait Appendability[-P, -Child, +R ]
{

   extension (parent: P)
      @annotation.targetName("appendInto")
      def append(c: Child): R

} // Appendability

trait IndexedInsertibility[-P, -CI, -Child, +R ]
{

   extension (parent: P)
      @annotation.targetName("insertInto")
      def insert(i: CI, v: Child): R

} // IndexedInsertibility

trait Reparentibility[-P, -C, +R ]
{

   extension (newChild: C)
      @annotation.targetName("reparent")
      def parent_=(newParent: P ): R

} // Reparentibility

object Reparentibility
{

   given [P, C, R](using impl: Appendability[P, C, R] )
   : Reparentibility[P, C, R]
   with {
      extension (newChild: C)
         @annotation.targetName("reparent")
         def parent_=(newParent: P ) = newParent.append(newChild)
   }

} // Reparentibility$

trait SelfRemovability[-A, +R ]
{

   extension (this1: A)
      @annotation.targetName("removeFromParent")
      def remove() : R

} // SelfRemovability

object SelfRemovability
{

   @deprecated("rethink whether this 'given' is what you want.")
   given [A, R](using impl: Reparentibility[? >: Null, A, R] )
   : SelfRemovability[A, R]
   with {
      extension (this1: A)
         @annotation.targetName("removeFromParent")
         def remove() = this1.parent_=(null)
   }

} // SelfRemovability$
















val _ = {}
