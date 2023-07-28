













object Build {

   import sbt.*

   /**
    * 
    * config which needs to be manually sync-ed against the correspondents in other file(s)
    * 
    */
   object vars {

      /**
       * 
       * the artifact for the backend plugin (eg SNative, SJS)
       * 
       * SHALL MATCH THE ONE IN `plugins.sbt`,
       * WHETHER S-NATIVE OR S-JS !
       * 
       */
      final
      lazy val backendSupportArtRef
      : ModuleID
      = {

         identity[ModuleID](

            "org.scala-js" % "sbt-scalajs" % (
               // "1.13.2"
               // "1.0.0"
               "1.13.2"
            )
         )
      }

   } /* object vars */

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

      Configuration.of("XCompilerPluginBc", "plugin->default(compile)")
   }

   /**
    * 
    * the artifact for the backend plugin (eg SNative, SJS)
    * 
    */
   final
   lazy val backendSupportArtRef
   : vars.backendSupportArtRef.type
   = vars.backendSupportArtRef

   @deprecated("this is a misnomer.")
   final
   lazy val backendPluginArtRef
   : backendSupportArtRef.type
   = 
      backendSupportArtRef

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
   lazy val backendSupportArtRefBloop
   : ModuleID
   = {

      // TODO externalise the two hard-coded "version"al values
      Defaults.sbtPluginExtra((

        (backendSupportArtRef)

        % Build.pbgConfig

      ), "1.0", "2.12")
   }

}












