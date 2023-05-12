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

import cbsq.riffmt.ebmls.toMarkdown

@main
def matrCdTest() : Unit = {
   println(matrCd )
   println((
      matrCd.entries
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



