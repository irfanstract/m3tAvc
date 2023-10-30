package avcframewrk.forms

package localutil


















object predefChainingOpsImplicits
{
   given predefChainingOps.type
   = predefChainingOps
}

// implicit
object predefChainingOps
extends
AnyRef
{
   ;

   protected[forms]
   def scalaUtilChainingOps
      [A](a: A)
      : scala.util.ChainingOps[a.type ]
      = scala.util.ChainingOps[a.type ](a)

   extension [A](a: A)
      private[predefChainingOps]
      def chainingOps = scalaUtilChainingOps[a.type] (a)

      export chainingOps.{pipe }
      export chainingOps.{pipe as pipeLooseSelf }
      export chainingOps.{tap  as  tapLooseSelf }

   extension [A <: Singleton](a: A)
      private[predefChainingOps]
      def strictlyTypeTrackedChainingOps = scalaUtilChainingOps[a.type] (a)

      export strictlyTypeTrackedChainingOps.{pipe as pipeExactSelf }
      export strictlyTypeTrackedChainingOps.{tap  as  tapExactSelf }

}




















val _ = {}