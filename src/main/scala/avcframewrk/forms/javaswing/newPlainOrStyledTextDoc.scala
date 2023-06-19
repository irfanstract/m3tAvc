package avcframewrk.forms.javaswing














trait DefinesGetNewPlainOrStyledTextDoc[+C <: Any]
{

   import language.unsafeNulls

   /**
    * 
    * returns
    * a new/independent `Document`
    * storing plain, unformatted text (MIME Type: `text/plain` ) (hence, UTF) doc.
    * 
    */
   def newPlainTextDocument(
      //

   ) : javax.swing.text.Document = {

      new javax.swing.text.PlainDocument
   }

   /**
    * 
    * returns
    * a new/independent `StyledDocument`.
    * 
    * avoid making any assumption about the returned `Document`'s actual `class` -
    * if it's necessary for it to be `HTMLDocument` then
    * use the following code instead.
    * 
    * ```
    * val doc = {
    * 
    *    import javax.swing
    * 
    *    val edp = new swing.JEditorPane()
    * 
    *    &#x2F;**
    *     * switch the EditorKit to HTMLEditorKit, so that
    *     * subsequently `setText` would  parse as HTML code/snippet ;
    *     * *&#x2F;
    *    edp setContentType("text/html")
    * 
    *    &#x2F;**
    *     * already invoked switch the EditorKit to HTMLEditorKit, so now
    *     * invoke `setText` with this HTML code/snippet ;
    *     * *&#x2F;
    *    edp setText("&lt;html> ... &lt;body> &lt;p> Paragraph 1 &lt;/p> ... ... ")
    * 
    *    (edp.getDocument() ) asInstanceOf[swing.text.html.HTMLDocument ]
    * } : swing.text.html.HTMLDocument
    * ```
    * 
    */
   def newStyledTextDocument(
      //

   ) : javax.swing.text.StyledDocument = {

      new javax.swing.text.html.HTMLDocument
   }
  
}


























