













object Build {

   import sbt.*

   /** 
    * 
    * work-around for Bloop
    * 
    */
   lazy val pbgConfig
   = {

      Configuration.of("XCompilerPluginBc", "plugin->default(compile)")
   }

   lazy val sjsDepSpec
   = identity[sbt.ModuleID] (
      //
      "org.scala-js" %% "sbt-scalajs" % (
         // "1.13.2"
         // "1.0.0"
         "1.13.2"
      )
   )

}












