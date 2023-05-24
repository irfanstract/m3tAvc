package cbsq.avc.codecs









import cbsq.w3dom.specialImplicits.*

import cbsq.riffmt.ebmls

object matrCd {

   lazy val specDocUrl = (
      matrCd.getClass().getResource("/matroska-spec.xml")
      // new java.net.URI("https://github.com/ietf-wg-cellar/matroska-specification/raw/master/ebml_matroska.xml").toURL()
   )

   val doc = {
      import org.xml.sax
      import javax.xml.parsers.*
      val builder = {
         DocumentBuilderFactory.newInstance()
         .newDocumentBuilder()
      }
      builder.parse((
         new sax.InputSource((
            specDocUrl
            .toString()
         ))
      ))
   }

   // val entries = (
   //    Set[(String, BigInt)](
   //       EmptyTuple :* ("Segment"   ) :* (0x18538067   : BigInt ) ,
   //       EmptyTuple :* ("SeekHead"  ) :* (0x114D9B74   : BigInt ) ,
   //       EmptyTuple :* ("Seek"   ) :* (0x4DBB   : BigInt ) ,
   //       EmptyTuple :* ("SeekID"   ) :* (0x53AB   : BigInt ) ,
   //       EmptyTuple :* ("SeekPosition"   ) :* (0x53AC   : BigInt ) ,
   //       EmptyTuple :* ("Info"   ) :* (0x1549A966   : BigInt ) ,
   //    )
   //    //    \/\/\s+<el.*?name="(.*?)".*?id="(.*?)".*
   //    //    EmptyTuple :* ("$1"   ) :* ($2   : BigInt ) ,
   // )
   lazy val entries = (
      ebmls.totalDtdAnalyse(doc)
      .elemDecls1
   )
      
}

extension (eStr : String) {

      def withPaddedSegmentUpTo(i: Int, l: Int): String = (
         (eStr.take(i).padTo(l, ' ') )
         + (eStr drop i) 
      )

}

import cbsq.riffmt.ebmls.toMarkdown

@main
def matrCdTest() : Unit = {
   println(matrCd )
   extension (eStr : String) {
      
      def withPaddedSegmentUpToFirstSemicolonRelevantly(): String = {
            val eStrFirstSemicolonPos = (
               (eStr indexOf ';' ) match {
                  case v =>
                     if (0 <= v) v
                     else eStr.length()
               }
            )
            eStr withPaddedSegmentUpTo(eStrFirstSemicolonPos, l = 0x30 )
      }

   }
   println((
      matrCd.entries
      .map(e => {
         // (
         //    e.toString()
         //    .replaceFirst("\\[Element\\s*\\S+?'\\/0x[0-9A-F]+\\s+")
         // )
         locally {
            val eStr = e.toString()
            val eStrFirstSemicolonPos = (
               (eStr indexOf ';' ) match {
                  case v =>
                     if (0 <= v) v
                     else eStr.length()
               }
            )
            ((i: Int) => (
               (eStr.take(i).padTo(0x30, ' ') )
               + (eStr drop i) 
            ))(eStrFirstSemicolonPos )
         }
      })
      .mkString("\r\n")
   ) )
   if false then {
      import matrCd.doc
      val dschan = (
         ebmls.totalDtdAnalyse(doc)
      )
      import dschan.elemDecls
      import dschan.elemDecls1
      println((
         elemDecls1
         .map({
            case analysis =>
               analysis.toMarkdown
         })
         .mkString("\r\n")
      ))
   }
}



