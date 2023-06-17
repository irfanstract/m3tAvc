package avcframewrk.xml
















object XmlCodeStream {

   export xmlCodeStreamFactory.*

}

object xmlCodeStreamFactory {

   export jdkXmlCodeStreamFactoryLocator.defaultXOutputFac.{createXMLStreamWriter => newXEventsEnmWriter }

   export jdkXmlCodeStreamFactoryLocator.defaultXOutputFac.{createXMLEventWriter => newXEventsItemWriter }

   export jdkXmlCodeStreamFactoryLocator.defaultXInputFac.{createXMLEventReader => newXEventsReader }

   type XmlStreamReader
      >: javax.xml.stream.XMLEventReader
      <: javax.xml.stream.XMLEventReader

   type XmlStreamWriter
      >: javax.xml.stream.XMLStreamWriter
      <: javax.xml.stream.XMLStreamWriter

   def newXmlIser() : (java.io.Writer, XmlStreamReader) = {

      import language.unsafeNulls

      val pisPair = {
         val i1 = new java.io.PipedOutputStream
         val i2 = new java.io.PipedInputStream(i1)
         (i1, i2)
      }

      ({
         val o = new java.io.OutputStreamWriter(pisPair._1, java.nio.charset.StandardCharsets.US_ASCII )
         // TODO write doctype
         o
      }, newXEventsReader(pisPair._2) )
   }

   def newXmlIsing(f : (java.io.PrintWriter => Unit )) = {

         val psp = newXmlIser()

         concurrent.Future.unit
         .foreach(_ => {
            f( new java.io.PrintWriter(psp._1, true ) )
         })(using concurrent.ExecutionContext.global )

         psp._2

   }

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













