package avcframewrk.util











import language.unsafeNulls /* UTF/String utility */



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
   def autoTruncated(
      locale: java.util.Locale ,
      
   ): String = {
      (
         docum
         .replaceAll("\\r?\\n|\\s+", " ")
         .replaceFirst("\\A\\s+", "")
         .replaceFirst("\\A([\\S\\s]{32}\\S*)[\\S\\s]{8,}\\z", "$1...")
         
      ) match {
         case s if (locale == java.util.Locale.ENGLISH) =>
            s
            .replaceFirst("\\A(?:(?i)(?:a[n]?|some|the)\\s+)"                             , "")
            .replaceFirst("\\AA(m|re|pplies|(?:proximate|cknowledge|ssert)s?)\\b"            , "a$1")
            .replaceFirst("\\AC((?:ontain|reate|oordinate|hoose)s?)\\b"                      , "c$1")
            .replaceFirst("\\AH(ow)\\b"                                                      , "h$1")
            .replaceFirst("\\AM((?:ax|in)imum|(?:ap|ention)s?)\\b"                           , "m$1")
            .replaceFirst("\\AS(pecif(?:y|ies)|ize|imilar|(?:elect)s?)\\b"                   , "s$1")
            .replaceFirst("\\AT(o|his|hese|hat|hose|here|han|hen)\\b"                        , "t$1")
            .replaceFirst("\\AD((?:enote|escribe)s?)\\b"                                     , "d$1")
            .replaceFirst("\\AI(n|ff?|s|(?:nstruct|ndicate|nsert)s?)\\b"                     , "i$1")
            .replaceFirst("\\AW(h(?:y|en|ile|ere|at)|as|ere|(?:arn)s?|il(?:|)l|ould)\\b"     , "w$1")
            .replaceFirst("\\AF(or)\\b"                                                      , "f$1")
            .replaceFirst("\\AS((?:et|imilar)\\s+(?:to|if|iff))\\b"                             , "s$1")
            .replaceFirst("\\AT((?:ype|able)\\s+of)\\b"                             , "t$1")
         case s =>
            s
      }
   }

}





















