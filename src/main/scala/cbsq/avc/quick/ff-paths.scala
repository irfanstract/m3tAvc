package cbsq.avc.quick














/**
 * 
 * path to the `bin` directory containing the `ff*` tools,
 * 
 */
lazy val ffPath = {

   import language.unsafeNulls
   
   import cbsq.avc.httpReadlineUtil.*

   val configFileUrl = {
      ffPathConfigFileUrl
   }

   SinglePathSpecFile.getValueFrom(configFileUrl )

} : String

/**
 * 
 * .
 * 
 */
protected
lazy
val ffPathConfigFileUrl = {

   new {}.getClass()
   .getResource("/.ffpath").nn
   
}

@main
def runFfPathCheck() : Unit = {
   // println(s"value : $ffPath")
   ({
      println("value :")
      println(s"${ffPath};" )
   })
}











































