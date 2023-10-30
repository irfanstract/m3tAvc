package avcframewrk.forms

package domutil






import scalajs.js








import org.scalajs.dom.*

extension [LhsE <: Node ] (lhsE: LhsE )
   def isDescendantOrSelf
      [RhsE <: Node ]
      (rhsE: RhsE )
   = {
      Iterator.unfold[Node, Node ] (rhsE ) ({
         case e0 =>
            ;
            for {
               e2 <- Option(e0.parentNode)
            }
            yield (e2, e2)
      })
      .find((opd: Node ) => (opd == lhsE ) )
      .nonEmpty
   }














;