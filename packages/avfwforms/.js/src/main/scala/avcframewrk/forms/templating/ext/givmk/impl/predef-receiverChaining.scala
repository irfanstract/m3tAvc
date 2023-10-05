package avcframewrk.forms

package templating

package ext.givmk

package impl


















private
given predefChainingOps
: AnyRef with {
   ;

   protected
   def scalaUtilChainingOps
      [A](a: A)
      : scala.util.ChainingOps[a.type ]
      = scala.util.ChainingOps[a.type ](a)

   extension [A](a: A)
      private def c1 = scalaUtilChainingOps[a.type] (a)
      export c1.{pipe }
      export c1.{pipe as pipeLooseSelf }
      export c1.{tap  as  tapLooseSelf }

   extension [A <: Singleton](a: A)
      private def c = scalaUtilChainingOps[a.type] (a)
      export c.{pipe as pipeExactSelf }
      export c.{tap  as  tapExactSelf }

}




















val _ = {}
