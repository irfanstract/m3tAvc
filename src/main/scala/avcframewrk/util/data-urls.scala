package avcframewrk.util












extension (v: String) {

   // TODO
   def encodedAsUrl: java.net.URI = {

      import language.unsafeNulls

      // new java.net.URI("data:text/plain," + v)

      new java.net.URI("data", s"text/plain,${v}", null )

   }
   
}


















