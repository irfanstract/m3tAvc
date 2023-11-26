package avcalculus

package computergraphics




















case class UncontrolledPolygonOrPolyline2D
   (private val impl: (([A] =>> (::[A] | IndexedSeq[A] ) )[Point2D] , Boolean) )
{
   ;

   val (pts, closed)
   = impl

   require(pts.nonEmpty)

   ;

   def points
   = pts.toIndexedSeq

   ;
}

object UncontrolledPolygonOrPolyline2D {
   ;

   ;

   implicit class HypotOps(val d: UncontrolledPolygonOrPolyline2D ) {
      //

      import d.*

      /** 
       * the locations of each pair of consecutive pts
       * 
       * excludes the last segment unless `closed` is `true`
       * 
       */
      def consecutiveTwosLocation
      = {
         points
         .appendedAll({
            if closed then
               (Nil :+ points.head )
            else Nil
         })
         .grouped(2).toIndexedSeq.map({ case Seq(p1, p2) => (p1, p2) })
      }

      /** 
       * delta between the two pts
       * 
       * excludes the last segment unless `closed` is `true` .
       * does not normalise negative-signed coords except for `hypot`
       * 
       * NUMERICALLY LOSSY
       * 
       */
      def sideLengths
      = {
         consecutiveTwosLocation
         .map({
            case ((x0, y0), (x2, y2)) =>
               (x2 - x0, y2 - y0)
         })
         .map((math.hypot ).tupled )
      }

      //
   }

   ;
}











