package avcalg



















// implicit
object plsAndTls
extends
AnyRef
{
   ;

   protected[plsAndTls]
   def scalaUtilChainingOps
      [A](a: A)
      : scala.util.ChainingOps[a.type ]
      = scala.util.ChainingOps[a.type ](a)

   extension [A](a: A) {
      //

      private[plsAndTls]
      def chainingOps
      = scalaUtilChainingOps[a.type] (a)

      export chainingOps.{pipe }
      export chainingOps.{pipe as pipeLooseSelf }
      export chainingOps.{tap  as  tapLooseSelf }

   }

   extension [A <: Singleton](a: A) {
      //

      /** 
       * this time we try as much to maintain the src-value transparency
       */
      private[plsAndTls]
      def strictlyTypeTrackedChainingOps
      = scalaUtilChainingOps[a.type] (a)

      export strictlyTypeTrackedChainingOps.{pipe as pipeExactSelf }
      export strictlyTypeTrackedChainingOps.{tap  as  tapExactSelf }

   }

}

object plsAndTlsAsImplicit {
   implicit
   val given_plsAndTls
   : plsAndTls.type
   = plsAndTls
}





















