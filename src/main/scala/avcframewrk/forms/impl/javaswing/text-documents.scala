package avcframewrk.forms.impl.javaswing














;

val _ = {
   ()
   ()
   ()
}

trait XDefinesDoRenderSwingTextDocDisplay(
   //
   
)
{
   this : XDefinesGetCustomComponent[?] =>

   /* name imports */

   import java.awt
   import javax.swing

   /* givens and UnsafeNulls */

   import concurrent.ExecutionContext.Implicits.global
   import language.unsafeNulls

   /* exports */

   import avcframewrk.util.lavf.{conditionalTyping as rtddConditionalTyping}

   def renderTextDocDisplay(
      //

      src : swing.text.Document ,
      onlyShortPhrase : (
         rtddConditionalTyping.IfConforms[src.type, swing.text.StyledDocument, [_] =>> false, [_] =>> Boolean ]
         
      ) = false ,
      
      editing : Boolean = false ,
      editorKit : (
         rtddConditionalTyping.IfConforms[editing.type, true, [_] =>> (swing.text.EditorKit | Null), [_] =>> Null ]
         
      ) = null ,
      
   ) = getCustomComponent1 {

      (src, onlyShortPhrase) match {
         //

         case (_, true) =>

            new swing.JTextField(src, null, 0 )

         case (src : swing.text.PlainDocument, false) =>

            new swing.JTextArea(src)

         case (src : swing.text.StyledDocument, false) =>

            new swing.JTextPane(src)

         case (src, false) =>

            val edp = new swing.JEditorPane

            if editorKit != null then {
               edp setEditorKit editorKit
            }
            edp setDocument src
            
            edp

      }
      match { case e => e.setEditable(editing) ; e }
   }

}

;
























