package avcframewrk.xml
















object XmlCodeStream {

   export xmlCodeStreamFactory.*

}

object xmlCodeStreamFactory {

   export jdkXmlCodeStreamFactoryLocator.defaultXOutputFac.{createXMLStreamWriter => newXEventsEnmWriter }

   export jdkXmlCodeStreamFactoryLocator.defaultXOutputFac.{createXMLEventWriter => newXEventsWriter }

   export jdkXmlCodeStreamFactoryLocator.defaultXInputFac.{createXMLEventReader => newXEventsReader }

}




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













