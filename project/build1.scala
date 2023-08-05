













object Build {

   /**
    * 
    * config which needs to be manually sync-ed against the correspondents in other file(s)
    * 
    */
   object vars {

   } /* object vars */

   /**
    * 
    * external library versions
    * 
    */
   object externalLibraryVersions {

      import sbt.*

      lazy val comMonix
         = identity[ModuleID]("io.monix" %% "monix" % "3.4.1" )

      lazy val orgTypelevelCatsCore
         = identity[ModuleID]("org.typelevel" %% "cats-core" % "2.9.0" )

      lazy val orgTypelevelCatsEffects
         = identity[ModuleID]( "org.typelevel" %% "cats-effect" % "3.5.1" )

   } // externalLibraryVersions$

   // final
   // lazy val pre
   // : PreBuild.type
   // = PreBuild

   /** 
    * 
    * to implement `platform.config.version`
    * Bloop stuck to
    * looping over `libraryDependencies` and
    * filtering to ones whose, in addition to being in/of the expected `organization`, `configuration` "matches" `CompilerPluginConfig`.
    * this means that
    * there *needs to* be the relevant SN-or-SJS artifact(s) (with)in `libraryDependencies`, having that `Configuration`
    * 
    */
   final
   lazy val pbgConfig
   = {

      sbt.Configuration.of("XCompilerPluginBc", "plugin->default(compile)")
   }

}












