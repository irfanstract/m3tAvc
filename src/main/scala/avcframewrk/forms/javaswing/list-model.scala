package avcframewrk.forms.javaswing

















;

def getImmutableListModel[E](src : Seq[E] ): javax.swing.ListModel[E] = {

   import language.unsafeNulls

   new javax.swing.AbstractListModel[E] {

      val lengthImpl = src.length

      def getSize(): lengthImpl.type = lengthImpl

      def getElementAt(i: Int) = src apply(i)
      
   }
}

extension [E](src : javax.swing.ListModel[E] ) {

   /**
    * 
    * a read-only *view* of it
    * 
    */
   def asReadOnly() : javax.swing.ListModel[E] = {

      new javax.swing.ListModel[E] {

         export src.getSize

         export src.getElementAt

         export src.{addListDataListener, removeListDataListener }
         
      }
   }

}

extension [E](src : javax.swing.ListModel[E] ) {

   def items = {

      import language.unsafeNulls

      IndexedSeq.tabulate[E](src.getSize() )(src.getElementAt _ )
   }
   
}

;
















