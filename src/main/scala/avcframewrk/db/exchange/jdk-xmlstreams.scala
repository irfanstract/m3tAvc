package avcframewrk.db.exchange

















private[avcframewrk]
object jdkXmlCodeStreamFactoryLocator {

   import language.unsafeNulls

   lazy 
   val defaultXOutputFac = {
      javax.xml.stream.XMLOutputFactory.newFactory()
   }

   lazy 
   val defaultXInputFac = {
      javax.xml.stream.XMLInputFactory.newFactory()
   }

}

































