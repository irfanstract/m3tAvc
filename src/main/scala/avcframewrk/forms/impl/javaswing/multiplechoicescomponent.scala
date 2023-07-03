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

   export avcframewrk.util.forms.syncing.ArrayDiffing
      
   // extension [E](sd: (FwOptionsIterable, swing.JList[E]) ) {

   //    def periodicRefresh(ec: concurrent.ExecutionContext ): (
   //       AnyRef
   //       & java.io.Closeable
   //    ) = {

   //       /**
   //        * 
   //        * value either `1` (GO_AHEAD) or `-1` (CEASE)
   //        * 
   //        * no atomicity guarantees necessary
   //        * 
   //        */
   //       @volatile
   //       val s = new java.util.concurrent.atomic.AtomicInteger(1)

   //       concurrent.Future({
            
   //          while ((0 < s.get() ) match { case b => Thread.sleep(1000 ) ; b } ) {

   //             val 
               
   //          }

   //       } : Unit )(using es )
         
   //       new AnyRef with java.io.Closeable {

   //          override
   //          def close(): Unit = {
               
   //             s set(-1)
               
   //          }

   //       }
   //    }

   // }

}

;


















