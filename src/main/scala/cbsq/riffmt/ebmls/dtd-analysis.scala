package cbsq.riffmt.ebmls



















import cbsq.w3dom.specialImplicits.*







class totalDtdAnalyse(doc : org.w3c.dom.Document) {

   @deprecated
   val elemDecls = (
      // TODO
      doc.getDocumentElement()
      .getElementsByTagNameSc("element")
      
   ): Seq[org.w3c.dom.Element]
   
   val elemDecls1 = (
      elemDecls
      .map((e: org.w3c.dom.Element) => (
         elementDtdAnalyse(e)
      ))
   )

}

class elementDtdAnalyse(e: org.w3c.dom.Element) {
            //

            /**
             * 
             * `name`
             * 
             */
            val mName = e.getAttribute("name")

            /**
             * 
             * `id` ;
             * every *frame* starts with such integers
             * 
             */
            val clsId = (
               e.getAttribute("id")
            )
            
            /**
             * 
             * `s"[Element '$mName' clsId=$clsId]"`
             * 
             */
            final 
            val asTagString : String = {
               s"[Element '$mName' clsId=$clsId]"
            }
            
            /**
             * 
             * the `<documentation>`'s contents
             * 
             */
            val docum = (
               e.getElementsByTagNameSc("documentation")
               .headOption
               .fold[String]("")(_.getTextContent() )
            )

            override
            def toString(): String = {
               import cbsq.autoTruncated
               if (docum.contains("Duration of the silent data added")) then {
                  java.lang.ref.Reference.reachabilityFence(BigInt )
               }
               asTagString
               .replaceFirst("(?=\\]\\z)", ": " + (
                  java.util.regex.Matcher.quoteReplacement((
                     docum
                     .autoTruncated()
                  ))
               ))
            }

}



extension (analysis : elementDtdAnalyse) {

   def toMarkdown : String = {
            //
            import cbsq.autoLinebroken
            import analysis.{mName, clsId}
            import analysis.asTagString
            import analysis.docum
            val docum1 = (
               docum
               // .grouped(0x60)
               .autoLinebroken
               .mkString("\n")
            )
            (
               Seq()
               :+ asTagString
               :+ docum1.indent(0x2 )
            ).mkString("\r\n")
   }
   
}






























