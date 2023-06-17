package avcframewrk.xml
















object XmlCodeStream {

   export xmlCodeStreamFactory.*

   type XmlStreamReader
      >: javax.xml.stream.XMLEventReader
      <: javax.xml.stream.XMLEventReader

   type XmlStreamWriter
      >: javax.xml.stream.XMLStreamWriter
      <: javax.xml.stream.XMLStreamWriter

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













