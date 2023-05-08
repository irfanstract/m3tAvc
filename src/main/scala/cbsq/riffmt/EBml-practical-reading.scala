package cbsq.riffmt







@main
protected 
def ebmlPracticalTest1(): Unit = {
   val path = (
      new java.io.File("C:\\Users\\62857\\Documents\\2022-12-06-170043085--22317149878557285.webm")
      .toURI()
   )
   import EBmlPrimitivesIo.*
   util.Using.resource(path.toURL().openStream() )(r0 => {
      val r = (
         new java.io.DataInputStream(r0)
      )
      for (_ <- () :: Nil) {
         val e = (
            r.readEbmlElement()
         )
         println(e.toString() )
         println({
            import java.nio.charset.{StandardCharsets, Charset }
            new String((e.payload.byteValues.map((_.toChar)) ).toArray )
         } )
         println({
            import java.nio.charset.{StandardCharsets, Charset }
            new String((e.payload ).toArray, StandardCharsets.UTF_8 )
         } )
      }
      try {
         while (true) {
            val e = (
               r.readEbmlElement()
            )
            println((e.typeInt.toString(0x10), e.payloadLength))
         }
      } catch {
         case z : java.io.EOFException =>
            println(z)
      }
   })
   // ???
}




