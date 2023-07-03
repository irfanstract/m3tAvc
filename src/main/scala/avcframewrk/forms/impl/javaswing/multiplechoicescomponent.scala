package avcframewrk.forms.impl.javaswing
















;

object multipleChoiceCompsImpl {

   import java.awt
   import javax.swing

   /**
    * 
    * not an appropriate choices
    * 
    * - `JOptionPane`.
    *   it only supports *plain array*s, but
    *   `avcf.forms.OptionsList` does not outrule *mutable* ones
    * 
    * - `JList`.
    *   `JList` is relatively limited. use `JTable` instead
    * 
    */
   locally {}

   //

   import language.unsafeNulls

   export avcframewrk.util.forms.controls.MultipleChoice.{OptionsIterable => FwOptionsIterable }

   export avcframewrk.util.forms.syncing.ContinuousArrayDiffing

   // extension [CC[E0] <: collection.IterableOps[E0, CC, CC[E0] ], E ]
   extension [CC[E0] <: collection.immutable.Iterable[E0], E ](s : CC[E] ) {

      def sortedIfNecessary(): IndexedSeq[E] = {

               import math.Ordering.Implicits.*
               ({
                  s match {
                     //
                     case s : Seq[e] =>
                        //
                        s
                        .toIndexedSeq
                     case s  =>
                        //
                        s
                        .toIndexedSeq
                        .sortBy[IndexedSeq[Double] ]({
                           case (e ) =>
                              e match {
                                 case e: java.lang.Number =>
                                    IndexedSeq(e.doubleValue())
                                    .prepended[Double](1)
                                 case e: String =>
                                    e
                                    .toIndexedSeq
                                    .map(_.toInt.toDouble )
                                    .prepended[Double](2)
                              }
                        })
                  }
               })
               .nn
      }

   }

   extension [E](sd: (FwOptionsIterable[E], swing.DefaultListModel[? >: E ]) ) {

      def periodicRefresh(ec: concurrent.ExecutionContext ): (
         AnyRef
         & java.io.Closeable
      ) = {

         val (src, dest) = sd

         val (prodSideCtrl, c) = {
            ContinuousArrayDiffing.startPeriodicSnapshotItr(src)(dispatcher = ec )
         }

         c
         .foreach(s => {
            // TODO advanced algo will come later
            val sSorted = {
               s
               .sortedIfNecessary()
            }
            if (dest.getSize() == sSorted.length ) {
               for (i <- Range(0, dest.getSize() ) ) {
                  dest.set(i, sSorted apply(i) )
               }
            } else {
               dest.clear()
               for (e <- sSorted ) {
                  dest addElement(e)
               }
            }
         })

         prodSideCtrl
      }

   }

}

;


















