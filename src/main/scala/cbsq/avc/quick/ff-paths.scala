package cbsq.avc.quick














/**
 * 
 * path to the `bin` directory containing the `ff*` tools,
 * loaded (via `Class.prototype.getResource()`) from `/.ffpath`
 * 
 */
lazy val ffPath = {

   import language.unsafeNulls
   
   import cbsq.avc.MimeMultipart.*

   val configFileUrl = {
      new {}.getClass()
      .getResource("/.ffpath")
   }

   val configFileContents = {
      configFileUrl
      .openStream()
      .asXBufferedReader()
      .readAll()
   }

   configFileContents
   .linesIterator.toIndexedSeq
   .filter(_.nonEmpty)
   match { case Seq(v) => v : String }

} : String

@main
def runFfPathCheck() : Unit = {
   println(s"value : $ffPath")
}











































