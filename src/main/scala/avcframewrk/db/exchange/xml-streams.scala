package avcframewrk.db.exchange















/**
 * 
 * a simple XML incremental/iterative/streaming itc
 * 
 */
object XmlCodeStream {

   export xmlCodeStreamFactory.*

}

protected 
object xsrNameTwin {
   
   type XmlStreamReader
      >: javax.xml.stream.XMLEventReader
      <: javax.xml.stream.XMLEventReader

   type XmlStreamWriter
      >: javax.xml.stream.XMLStreamWriter
      <: javax.xml.stream.XMLStreamWriter

}

export xsrNameTwin.*

/**
 * 
 * factory for
 * simple XML incremental/iterative/streaming itc(s)
 * 
 */
object xmlCodeStreamFactory
extends
AnyRef
with XswReExports
{

   export xsrNameTwin.*

   def newXmlIser() : (java.io.Writer, XmlStreamReader) = {

      import localUtil.*

      import language.unsafeNulls

      val pisPair = {
         GivenPipedStreamFactory.ofBytes
         .instantiate()
      }

      ({
         val o = new java.io.OutputStreamWriter(pisPair._1, stdCharsets.UTF_8 )
         // TODO write doctype
         o
      }, newXEventsReader(pisPair._2) )
   }

   def newXmlIsing(f : (java.io.PrintWriter => Unit )) = {

      import localUtil.*

      val psp = newXmlIser()

      startAndForget {
         f( psp._1.asPrintWriter() )
      }

      psp._2

   }

}




// sealed
trait XswReExports {
   
   import language.unsafeNulls

   export jdkXmlCodeStreamFactoryLocator.defaultXOutputFac.{createXMLStreamWriter => newXEventsEnmWriter }

   export jdkXmlCodeStreamFactoryLocator.defaultXOutputFac.{createXMLEventWriter => newXEventsItemWriter }

   export jdkXmlCodeStreamFactoryLocator.defaultXInputFac.{createXMLEventReader => newXEventsReader }

}






























