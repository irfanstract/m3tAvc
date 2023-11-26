package avcalculus

package computergraphics













object CGA {
   ;

   trait ByReceiverT[-ReceiverT]
   {
      extension (receiver: ReceiverT)
         def area: SpQuant
   }

   def apply
      //
      [ReceiverT] (implGetAreaOf: (subj: ReceiverT) => SpQuant )
   = {
      new ByReceiverT[ReceiverT] with Selectable
      { extension (receiver: ReceiverT) def area = implGetAreaOf(receiver) }
   }

}



object ToPointsSeq2D
{
   ;

   trait ByReceiverT[-ReceiverT]
   {
      extension (receiver: ReceiverT)
         def pointList: IndexedSeq[(SpQuant, SpQuant)]
   }

   def apply
      //
      [ReceiverT] (impl: (subj: ReceiverT) => IndexedSeq[(SpQuant, SpQuant)] )
   = {
      new ByReceiverT[ReceiverT] with Selectable
      { extension (receiver: ReceiverT) def pointList = impl(receiver) }
   }

}



object Circumferentibility
{
   ;

   trait ByReceiverT[-ReceiverT]
   {
      extension (receiver: ReceiverT)
         def circumference: SpQuant
   }

   def apply
      //
      [ReceiverT] (impl: (subj: ReceiverT) => SpQuant )
   = {
      new ByReceiverT[ReceiverT] with Selectable
      { extension (receiver: ReceiverT) def circumference = impl(receiver) }
   }

   given byToPointsSeq
      [T](using ToPointsSeq2D.ByReceiverT[T] )
   : ByReceiverT[T]
   = apply((s: T) => {
      s.pointList
      .grouped(2).toIndexedSeq.map({ case Seq(p0, p2) => (p0, p2) })
      .map({
         case ((x0, y0), (x2, y2)) =>
            math.hypot(x2 - x0, y2 - y0 )
      })
      .sum
   } )

}















