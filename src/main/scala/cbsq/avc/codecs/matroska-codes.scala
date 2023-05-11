package cbsq.avc.codecs









object matrCd {

   val doc = {
      import org.xml.sax
      import javax.xml.parsers.*
      val builder = {
         DocumentBuilderFactory.newInstance()
         .newDocumentBuilder()
      }
      // builder.parse((
      //    new sax.InputSource((
      //       matrCd.getClass().getResource("/matroska-spec.xml")
      //       .toString()
      //    ))
      // ))
   }

   val entries = (
      Set[(String, BigInt)](
         EmptyTuple :* ("Segment"   ) :* (0x18538067   : BigInt ) ,
         EmptyTuple :* ("SeekHead"  ) :* (0x114D9B74   : BigInt ) ,
         EmptyTuple :* ("Seek"   ) :* (0x4DBB   : BigInt ) ,
         EmptyTuple :* ("SeekID"   ) :* (0x53AB   : BigInt ) ,
         EmptyTuple :* ("SeekPosition"   ) :* (0x53AC   : BigInt ) ,
         EmptyTuple :* ("Info"   ) :* (0x1549A966   : BigInt ) ,
      )
      //    \/\/\s+<el.*?name="(.*?)".*?id="(.*?)".*
      //    EmptyTuple :* ("$1"   ) :* ($2   : BigInt ) ,
   )
      
}



