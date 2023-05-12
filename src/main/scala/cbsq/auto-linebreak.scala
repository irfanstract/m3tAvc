package cbsq













extension (v: java.lang.String) {

   /**
    * 
    * "smart line-breaking" -
    * split the String into lines,
    * honouring the rules like "maximum width" etc
    * 
    */
   def autoLinebroken: Seq[String] = {
      v
      .linesIterator
      .toSeq
      .flatMap[String]((v: String) => (
         v
         .autoLinebrokenImpl
      ))
      .map((l: String) => (
         l.replaceFirst("\\A\\s+", "")
      ))
   }
   
}

private 
val slbContinentMatcher = (
         /**
          * 
          * at-most 60 chars, extending until the end of the token/word
          * 
          */
         "(?:.(?!\\r?\\n)){1,60}\\S*(|.*)"
         .r
)

extension (v: java.lang.String) {

   private
   def autoLinebrokenImpl: Seq[String] = {
      slbContinentMatcher
      .findAllIn(v)
      .toIndexedSeq
   }

}



extension (docum: java.lang.String) {

   // TODO
   def autoTruncated(): String = {
      (
         docum
         .replaceAll("\\r?\\n|\\s+", " ")
         .replaceFirst("\\A\\s+", "")
         .replaceFirst("\\A([\\S\\s]{32}\\S*)[\\S\\s]{8,}\\z", "$1...")
         .replaceFirst("\\A(?:(?i)(?:a[n]?|some|the)\\s+)", "")
      )
   }

}




















