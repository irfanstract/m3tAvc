package cbsq.riffmt.ebmls












import language.unsafeNulls /* due to the extended usage of non-Scala API(s) */







import cbsq.w3dom.specialImplicits.*

def dtdaIntegerByHexString(repr: String) = {
   (
      BigInt((
         repr
         /**
          * strip the "0x"
          */
         .replaceFirst("0x", "")
         
      ), 0x10)
   )
}







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
             * `name` .
             * 
             * in addition to *element def id*, 
             * every *element def* shall assign a *readable name* to it
             * 
             */
            val mName = (
               e getAttribute("name")
            )
            
            /**
             * 
             * the *def id* for the *element*, as hex string "0x(...)"
             * 
             */
            val clsIdHexString = (
               e getAttribute("id")
            )
            /**
             * 
             * the *def id* for the *element*
             * 
             */
            val clsId = (
               dtdaIntegerByHexString((
                  clsIdHexString
               ))
            ) : BigInt
            
            /**
             * 
             * the value's type's simple-name
             * 
             */
            val mValueTypeSimpleName = (
               e.getAttribute("type")
            )

            @annotation.experimental
            lazy val mValueType = {
               mValueTypeSimpleName match

                  case "float" =>
                     reflect.classTag[BigDecimal]
               
                  case "integer" | "uinteger" =>
                     reflect.classTag[BigInt]
               
                  case "binary" =>
                     reflect.classTag[collection.immutable.ArraySeq.ofByte]
               
                  case "utf8" =>
                     reflect.classTag[String]
               
            } : reflect.ClassTag[?]

            /**
             * 
             * `true` if-and-only-if
             * its *content-model*
             * are "generic elements" ie *zero-or-more* *frames*
             * -- *recursive*!
             * 
             */
            val doesDescribeGenericElement  = {
               mValueTypeSimpleName == "master"
            } : Boolean

            /**
             * 
             * s"[Element '$mName'/$clsIdHexString (...)]"
             * 
             */
            final 
            val asTagString : String = {
               s"[Element '$mName'/$clsIdHexString ($mValueTypeSimpleName)]"
            }
            
            /**
             * 
             * the `&lt;documentation>`'s contents
             * 
             */
            val usageNoteTxt = (
               e.getElementsByTagNameSc("documentation")
               .headOption
               .fold[String]("")(_.getTextContent() )
            )

            override
            def toString(): String = {
               import cbsq.autoTruncated
               // if (usageNoteTxt.contains("Duration of the silent data added")) then {
               //    java.lang.ref.Reference.reachabilityFence(BigInt )
               // }
               asTagString
               .replaceFirst("(?=\\]\\z)", " ; " + (
                  java.util.regex.Matcher.quoteReplacement((
                     usageNoteTxt
                     .autoTruncated()
                  ))
               ))
            }

}



extension (analysis : elementDtdAnalyse) {

   def toMarkdown : String = {
            //
            import cbsq.autoLinebroken
            import analysis.{mName, clsIdHexString}
            import analysis.asTagString
            import analysis.usageNoteTxt
            val docum1 = (
               usageNoteTxt
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






























