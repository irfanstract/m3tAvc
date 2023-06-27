package avcframewrk.forms.javaswing

















;

val _ = {}

extension [Value](s: avcframewrk.util.EventIterator[CvcEvent[Value ] ] ) {

   /**
    * 
    * a `javax.swing.text.Document` to
    * constantly animate/refresh/update everytime it receives new ValueChangeEvent(s)
    * 
    */
   def asAnimatedSwingTextDocument(): javax.swing.text.Document = {

      import language.unsafeNulls
      
      import avcframewrk.forms.javaswing.swingTextDocUtils.setText1

      val d = new javax.swing.text.PlainDocument

      for (value <- s.map(_.newValue) ) do {
         
         d setText1 s"value: ${value}; "
      }

      d
   }

}

/**
 * 
 * Form Control Value Change Event
 * 
 */
case class CvcEvent[+Value](newValue: Value )

;

;















