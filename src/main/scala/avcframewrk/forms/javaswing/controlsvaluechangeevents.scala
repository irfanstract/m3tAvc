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

/**
 * 
 * a dedicated backend for implementing `addChangeListener`s
 * 
 */
class XSwingChangeListenerList() {
   
   import language.unsafeNulls

   protected
   val listenerList = new javax.swing.event.EventListenerList()
   
   def addChangeListener   (l: javax.swing.event.ChangeListener ): Unit = listenerList add   (classOf[javax.swing.event.ChangeListener], l )
   def removeChangeListener(l: javax.swing.event.ChangeListener ): Unit = listenerList remove(classOf[javax.swing.event.ChangeListener], l )

   def getAllListeners() = {

      listenerList.getListeners(classOf[javax.swing.event.ChangeListener] ).toIndexedSeq
   }

   def fireAllChangeListeners(src: AnyRef): Unit = {

      val e = new javax.swing.event.ChangeEvent(src)

      for (l <- getAllListeners() ) {

         l stateChanged(e)
      }
   }

}

;















