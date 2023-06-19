package avcframewrk.forms.javaswing
















object localUtil {
   
   def enClosure[R](run : => R ) : (() => R ) = () => run

}






extension (s: java.awt.Shape) {

   def toStroked(c: java.awt.Stroke) = {

      import language.unsafeNulls

      c createStrokedShape s
   }

}






object swingTextDocUtils
{

   import javax.swing
   
   import language.unsafeNulls
   
   extension (doc: swing.text.Document) {

      /**
       * 
       * treat `doc` as *plain text doc* and
       * set the full content to given plain text 
       * 
       */
      def setText1(newValue: String): Unit = {
         
         new swing.JTextArea(doc)
         .setText(newValue)
         
      }

   }

   extension (doc: swing.text.Document) {

      // TODO
      private
      def setDocumentCodeTo(newValue: String): Unit = {
         
         val edp = new swing.JEditorPane()
         edp setDocument doc

         edp setText(newValue )

         /**
          * ensure GC
          */
         edp setDocument null
         
      }

   }

}



























