



















trait StdLibBuild {
  ;

  import sbt._
  import sbt.Keys.{libraryDependencies }

  import org.portablescala.sbtplatformdeps.PlatformDepsPlugin.autoImport._

  import sbtcrossproject.CrossProject
  import sbtcrossproject.CrossPlugin.autoImport.{crossProject, CrossType, _}

  import org.scalajs.sbtplugin.ScalaJSPlugin.autoImport._

  import scalajscrossproject.ScalaJSCrossPlugin.autoImport._

  ;

  ;

  implicit class CrossProjectCompilerPluginsDependencyOps(receiver: CrossProject ) {
    //

    def withAutoCompilerPlugin()
    : CrossProject
    = {
      ;
      receiver
      .settings(Keys.autoCompilerPlugins := true )
    }

  }

  /** 
    * 
    * https://www.scala-js.org/doc/project/linking-errors.html ,
    * necessitating expanding the `%%`s into `%%%`
    * .
    * also,
    * "`value` can only be used within a task or setting macro, such as :=, +=, ++=, Def.task, or Def.setting."
    * 
    */
  implicit class CrossProjectCommonStdLibDependencyOps(receiver: CrossProject ) {
    //

    def withOrgScalatestForTests()
    = {
      ;

      receiver
      .settings(libraryDependencies += (
        "org.scalatest" %%% "scalatest"
        % "3.2.9"
        % Test
      ) )
    }

    /** TYPICAL UTILITY LIB DEPENDENCIES */
    def withXMinimumNecessaryBoilerplate()
    = {
      ;

      import sbt.Keys._

      // TODO
      receiver
      .withOrgScalatestForTests()
      .withOrgTypelevelCatsCore()
      .withOrgTypelevelKittens()
      .withDevMonocle()
      .withComGithubRsshCpsAsync()
      .withQuotidian()
    }

    def withOrgTypelevelCatsCore()
    = {
      ;

      receiver
      .settings(libraryDependencies += (
        "org.typelevel"   %%% "cats-core" 
        % "2.9.0"
      ))
    }

    def withOrgTypelevelKittens()
    = {
      ;

      receiver
      .settings(libraryDependencies += (
        "org.typelevel"   %%% "kittens"
        % "3.0.0"  
      ))
    }

    def withDevMonocle()
    = {
      ;

      import sbt.Keys._

      // TODO
      receiver
      .settings(
        //

        libraryDependencies ++= ((ioOpticsMonocleVersion: String) => Seq[ModuleID] (
          ( "dev.optics" %%% "monocle-core"       % ioOpticsMonocleVersion )              ,
          ( "dev.optics" %%% "monocle-macro"      % ioOpticsMonocleVersion )              ,
          ( "dev.optics" %%% "monocle-law"        % ioOpticsMonocleVersion ) % Test       ,
          ( "dev.optics" %%% "monocle-refined"    % ioOpticsMonocleVersion )              ,
          //
        ))("3.2.0")
        ,
        //

      )
    }

    def withQuotidian()
    = {
      ;

      receiver
      .settings(libraryDependencies += (
        "io.github.kitlangton" %% /* not found for non-JVM */ "quotidian"
        % "0.0.6"
        % Compile 
      ))
    }

    def withComGithubRsshCpsAsync()
    = {
      ;

      val libVersion
      = "0.9.19"

      receiver
      .settings(libraryDependencies += (
        "com.github.rssh" %%% "dotty-cps-async" % libVersion
      ) )
      // TODO
      .withAutoCompilerPlugin()
      .settings(
        //
        addCompilerPlugin("com.github.rssh" %% "dotty-cps-async-compiler-plugin" % libVersion )
      )
    }

    /** 
      * for some reason
      * `java.util.Locale` fails to link out-of-the-box
      * 
      */
    def withJavaUtilLocaleCQuiroz()
    = {
      receiver
      .jsSettings(libraryDependencies += (
        "io.github.cquiroz" %%% "scala-java-locales"
        % "1.2.0"
      ) )
    }

    /** 
      * `plokhotnyuk`'s `jsoniter`
      * 
      */
    def withJsonIterLib()
    = {
      ;
      val comPLoKhotNyukJsonIterLibVer = "2.23.5"
      receiver
      .settings(
        //
        /* still unsure if these usage of `%%%` is right */
        libraryDependencies ++= Seq(
          // Use the %%% operator instead of %% for Scala.js and Scala Native 
          "com.github.plokhotnyuk.jsoniter-scala" %%% "jsoniter-scala-core"   % comPLoKhotNyukJsonIterLibVer
          ,
          // Use the "provided" scope instead when the "compile-internal" scope is not supported  
          "com.github.plokhotnyuk.jsoniter-scala" %%% "jsoniter-scala-macros" % comPLoKhotNyukJsonIterLibVer % "compile-internal"
          ,
        )
        ,
      )
    }

    /**
      * `com.raquo.airstream`.
      * a spin-off from Laminar, solely dealing with FRP.
      * 
      * Airstream makes distinction between `EventStream` and `Signal` ;
      * Monix doesn't do this
      * 
      */
    def withComRaquoAirstream()
    = {
      receiver
      .settings(libraryDependencies += (
        "com.raquo" %%% "airstream"
        % "16.0.0"
      ) )
    }

    /**
      * Monix
      * 
      */
    def withMonix()
    = {
      receiver
      .jsSettings(libraryDependencies += "io.monix" %%% "monix" % "3.4.1" )
    }

    def withOrgTypelevelCatsEffects()
    = {
      ;
      receiver
      .settings(libraryDependencies += (
        "org.typelevel" %%% "cats-effect"
        % "3.5.1"
      ) )
    }

    /**
      * Depend on the SJS-idiomatic DOM library.
      * It provides static types for ECMA-262 and one for Browser DOM APIs.
      * 
      * SJS-only.
      * 
      */
    def withWebCtxStdLib()
    : CrossProject
    = {
      ;
      receiver
      .jsSettings(
        //

        /* Depend on the SJS-idiomatic DOM library.
          * It provides static types for ECMA-262 and one for Browser DOM APIs.
          */
        /* 
          * see also https://scalablytyped.org/docs/conversion-options#stusescalajsdom 
          */
        // libraryDependencies += "org.scala-js" %%% "scalajs-dom" % "2.4.0"
        // ,
        org.scalablytyped.converter.plugin.ScalablyTypedPluginBase.autoImport.stUseScalaJsDom := {
          false
        }
        ,
        // scalajsbundler.sbtplugin.ScalaJSBundlerPlugin.autoImport.npmDependencies += (
        //   "std" ->
        //   "^4.3"
        // )
        // ,

      )
    }

    def withDevLaminar()
    = {
      receiver
      /* a JS-only library building on `js.dom`. also, Laminar (re)exports Airstream as well, no need to explicitly list it here */
      .jsSettings(libraryDependencies += "com.raquo" %%% "laminar" % "15.0.1" )
    }

  }

  ;
}
















