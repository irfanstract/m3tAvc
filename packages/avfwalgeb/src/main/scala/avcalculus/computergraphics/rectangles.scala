package avcalculus

package computergraphics












opaque type Point2D
>: RdProduct & (SpQuant, SpQuant)
<: RdProduct & (SpQuant, SpQuant)
= (SpQuant, SpQuant)

// implicit
object Point2D {
   ;

   extension (desc: Point2D)
      def x : desc._1.type = valueOf
      def y : desc._2.type = valueOf

}







opaque type RectangularDesc
<: RdProduct
= RectangularFourAbsolCoords

// implicit
object RectangularDesc {
   ;

   ;

   given Conversion[RectangularDesc, RectangularFourAbsolCoords]
   = <:<.refl[RectangularDesc ].apply _

   ;
}

case class RectangularFourAbsolCoords
   //
   (x0: SpQuant, x1: SpQuant, y0: SpQuant, y1: SpQuant )
{
   ;

   val (xLength, yLength)
   = (
      (x1 - x0)
      .abs
      ,
      (y1 - y0)
      .abs
      ,
   )

   ;
}

object RectangularFourAbsolCoords {
   ;

   given CGA.ByReceiverT[RectangularFourAbsolCoords]
   = CGA((subj: RectangularFourAbsolCoords) => (
      subj.yLength * subj.xLength
   ) )

   ;
}

case class Triangle2D
   (pts: ([A] =>> (A, A, A ) )[Point2D] )
{
   ;

   /** 
    * all points.
    * not repeating the last one, unlike `ToPointsSeq2D` does.
    * 
    */
   val points
   = pts

   /** 
    * all points.
    * not repeating the last one, unlike `ToPointsSeq2D` does.
    * 
    */
   val pointList
   = {
      ;
      pts.toList
      .map({ case (x, y) => (x, y) })
   }

   /* no arithmetics for these one, which means, no numerical loss! */
   /** 
    * all points.
    * not repeating the last one, unlike `ToPointsSeq2D` does.
    * 
    */
   val (xCoords @ List(x1, x2, x3) , yCoords @ List(y1, y2, y3) )
   = {
      pointList
      .unzip
   }

   ;
}

object Triangle2D {
   ;

   implicit class HypotOps(val d: Triangle2D ) {
      //

      import d.*

      val toPolygon
      = UncontrolledPolygonOrPolyline2D((pointList.toIndexedSeq, true ) )

      // val
      transparent inline
      def sideLengths
      = toPolygon.sideLengths

      //
   }

   @annotation.experimental
   given Ar
   : CGA.ByReceiverT[Triangle2D]
   = CGA((subj: Triangle2D) => (
      // TODO
      0.5 * ((subj.x2 - subj.x1 ) * (subj.x3 - subj.x2 ) )
   ) )

   ;
}







