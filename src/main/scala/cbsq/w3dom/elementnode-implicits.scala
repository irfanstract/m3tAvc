package cbsq.w3dom

















object specialImplicits {
   
   extension (doc: org.w3c.dom.NodeList) {

      def toIndexedSeq = {
         doc match {
            case l =>
               IndexedSeq.tabulate(l.getLength())(l.item _)
         }
      }

      def asSeq = {
         collection.View.fromIteratorProvider(() => {
            Iterator.tabulate(doc.getLength() )(doc.item _)
         })
      }

   }

   extension (doc: org.w3c.dom.Element) {

      def childrenSc = {
         doc.getChildNodes()
         .asSeq
      }

      def getElementsByTagNameSc(v: String) = (
         doc.getElementsByTagName(v)
         .getnListToIndexedSeq1
      )

      def getElementsByTagNameNsSc(namespaceURI: String, localName: String) = (
         doc.getElementsByTagNameNS(namespaceURI, localName)
         .getnListToIndexedSeq1
      )

   }

   extension (l0: org.w3c.dom.NodeList) {

      private
      def getnListToIndexedSeq1 : Seq[org.w3c.dom.Element] = {
         l0
         .toIndexedSeq
         .map({
            case e : org.w3c.dom.Element =>
               e
         })
      }

   }

}























