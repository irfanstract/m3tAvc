













object Build {

   /**
    * 
    * config which needs to be manually sync-ed against the correspondents in other file(s)
    * 
    */
   object vars {

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

      sbt.Configuration.of("XCompilerPluginBc", "plugin->default(compile)")
   }

   /** 
    * 
    * to avoid spurious "not found" complaints,
    * we needed to move the affected things away from `/build.sbt` into here,
    * which means we needed to bring most the other things along.
    * 
    * to do both things at once -- developing for JVM and developing for JS, the so-called "cross-compilation" --
    * we needed to put `sbt-crossproject` into play here.
    * - https://www.scala-js.org/doc/project/cross-build.html
    * - https://github.com/portable-scala/sbt-crossproject
    * 
    * we disabled the line `import sbt.Keys._` since
    * the ident(s) of the defs within `sbt.Keys$`
    * conflicts with the fact that the values (of the defs) are `sbt.YyyKey`s rather than their values.
    * 
    */
   object mainly
   {
      //

      import sbt._
      // import sbt.Keys.{compile => _, sourceGenerators => _, _} /* has naming issues */
      import sbt.Keys.{libraryDependencies }

      import org.portablescala.sbtplatformdeps.PlatformDepsPlugin.autoImport._

      import sbtcrossproject.CrossProject
      import sbtcrossproject.CrossPlugin.autoImport.{crossProject, CrossType, _}

      import org.scalajs.sbtplugin.ScalaJSPlugin.autoImport._

      import scalajscrossproject.ScalaJSCrossPlugin.autoImport._

      //

      /**
       * 
       * the parent dir of every of these packages.
       * follows that of the React dev repo.
       * 
       */
      lazy val packagesParentDir
      = file("packages")

      lazy val suggestedScalaVersionV: String
      = "3.3.1"

      ThisBuild / Keys.scalaVersion := suggestedScalaVersionV

      def computeNecessaryProjectSrcCodeManifest()
      = {
        import sbt.Keys._

        Seq(
          //

          /* TITLE */

          name := { s"${name.value } for ${ crossProjectPlatform.value.identifier }" } ,

          /* SCALAC OPTIONS */

          scalaVersion := suggestedScalaVersionV ,

          scalacOptions += "-Yexplicit-nulls" ,
          scalacOptions += "-Ysafe-init" ,

          // scalacOptions += "-explain" ,
          scalacOptions += "-feature" ,
          scalacOptions += "-deprecation" ,
          scalacOptions += "-unchecked" ,
          scalacOptions += "-language:implicitConversions" ,

          /* RESOURCE PATHS */

          Compile / resourceDirectories += (
            baseDirectory.value / "src" / "main" / "resources"
          )
          ,

          /* 
           * THE STD LIB DEPENDENCY SPEC
           * HAS BEEN MOVED BELOW, UNDER `withXMinimumNecessaryBoilerplate`,
           * CALLED BY `asLeafProjectWithNecessarySettings`
           */

        )
      }

      libraryDependencies ++= {

        println(s"PATH: '${java.lang.System.getenv("PATH") }'")

        Seq()
      }

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

      //

      /* see also [https://github.com/portable-scala/sbt-crossproject](`sbt-crossproject`) */
      val suggestedTargetPlatforms: Seq[sbtcrossproject.Platform ]
      = Seq(JSPlatform)

      implicit class XCrossProjectBuilderSuggestedSettingsOps(receiver: CrossProject.Builder ) {

        def withSuggestedSettings()
        : CrossProject.Builder
        = {
          receiver
          .withoutSuffixFor(JVMPlatform )
          .crossType(CrossType.Pure )
        }

      }

      implicit class XCrossProjectSuggestedPlatformSpecificSettingsOps(receiver: CrossProject ) {
         //

         def withSuggestedPlatformSpecifics()
         : CrossProject
         = {
            receiver
            .withJavaUtilLocaleCQuiroz()
            .toSwitchLinkerToEsm()
            /* 
              * 
              * https://www.scala-js.org/doc/semantics.html .
              * otherwise, one'll get `Error` when it needs to be `RuntimeException` instead.
              * 
              */
            .withMaintainedClassCastExceptioning()
            // .asBrowserBasedApp()
            .withWebCtxStdLib()
         }

         def withMainClass
            //
            (mainClassNames: Option[String])
         : CrossProject
         = {
            ;
            receiver
            .settings(
              //

              (Compile / Keys.mainClass) := mainClassNames
              ,

            )
            .jsSettings(
              //

              // Tell Scala.js that this is an application with a main method
              // I'll keep it here for quite a while
              scalaJSUseMainModuleInitializer := true
              ,

              /* Configure Scala.js to emit modules in the optimal way to
               * connect to Vite's incremental reload.
               * - emit as many small modules as possible for classes in the "livechart" package
               * - emit as few (large) modules as possible for all other classes
               *   (in particular, for the standard library)
               */
              scalaJSLinkerConfig ~= (s0 => {

                import org.scalajs.linker.interface.ModuleSplitStyle

                s0
                .withModuleSplitStyle(
                  ModuleSplitStyle.FewestModules )
              }),

            )
         }

         def asBrowserBasedApp
            //
            (mainClassNames: Option[String])
         : CrossProject
         = {
            ;
            receiver
            .withMainClass(mainClassNames )
            .withWebCtxStdLib()
         }

         /* 
          * 
          * https://www.scala-js.org/doc/semantics.html .
          * otherwise, one'll get `Error` when it needs to be `RuntimeException` instead.
          * 
          */
         def withMaintainedClassCastExceptioning()
         : CrossProject
         = {
            ;
            receiver
            .jsSettings(
              //

              scalaJSLinkerConfig ~= (c => (
                 c.withSemantics(s => (
                    s
                    .withAsInstanceOfs(org.scalajs.linker.interface.CheckedBehavior.Compliant )
                 ) )
              ) )
              ,

            )
         }

      }

      implicit class XCrossProjectSuggestedJsSpecificSettingsOps(receiver: CrossProject ) {
        //
        
         def toSwitchLinkerToEsm()
         : CrossProject
         = withSjsLinkerSpecificModuleType(ModuleKind.ESModule )

         def withSjsLinkerSpecificModuleType
          (t: org.scalajs.linker.interface.ModuleKind )
         : CrossProject
         = {
            ;
            receiver
            .jsSettings(
              //

              scalaJSLinkerConfig ~= (s0 => {

                s0
                .withModuleKind(t)
              })
              ,

              scalaJSLinkerConfig ~= (c => {
                // TODO
                c
                .withOutputPatterns(org.scalajs.linker.interface.OutputPatterns.fromJSFile(s"%s.${
                  t match {
                    case ModuleKind.ESModule => "mjs"
                    case ModuleKind.CommonJSModule => "cjs"
                    case _ => "js"
                  }
                }") )
              })
              ,

              /* can't do this checking since Metals won't put the SBT Bloop Plugin outside usage of it */
              // /**
              //  * Bloop
              //  * refuses to fully evaluate the std fields, citing the issues with side-effects, and instead
              //  * evaluates the "proxy" fields, in this case `bloopScalaJSModuleKind`
              //  */
              // bloopScalaJSModuleKind := {
              //   throw new IllegalStateException(s"unsupported Bloop-import ; please switch to SBT-BSP")
              // }
              // ,

            )
         }

         def toSwitchLinkerToCommonJs()
         : CrossProject
         = {
            withSjsLinkerSpecificModuleType(ModuleKind.CommonJSModule )
         }

      }

      implicit class XCrossProjectSuggestedSourceArtefactSettingsOps(receiver: CrossProject ) {

        def asLeafProjectWithNecessarySettings()
        : CrossProject
        = {
          receiver
          .settings(

            computeNecessaryProjectSrcCodeManifest() ,

            //
          )
          .withXMinimumNecessaryBoilerplate()
          .withSuggestedPlatformSpecifics()
          .withJsonIterLib()
        }

      }

      implicit class ScpScalaJsBundlerSpecificOps(receiver: CrossProject ) {
        //

        def withRelevantScJsBundlerSpecificSetup(Compile : Configuration )
        : CrossProject
        = {
          ;
          import scalajsbundler.sbtplugin.ScalaJSBundlerPlugin
          receiver
          .jsEnablePlugins(ScalaJSBundlerPlugin )
          .jsSettings(
            //

            /* https://scalacenter.github.io/scalajs-bundler/reference.html#bundling-mode . */
            (Compile / ScalaJSBundlerPlugin.autoImport.webpackBundlingMode )
            := ScalaJSBundlerPlugin.autoImport.BundlingMode.LibraryAndApplication()
            ,

            /* https://scalacenter.github.io/scalajs-bundler/reference.html#bundling-mode-library-and-application */
            (Compile / ScalaJSBundlerPlugin.autoImport.webpackEmitSourceMaps )
            := true
            ,

            // (Compile / Keys.compileIncremental) := {
            //   val result0 = (Compile / Keys.compileIncremental).value
            //   fjsHighLevelTaskIn(Compile ).value
            //   ({ (Compile / fastLinkJS / ScalaJSBundlerPlugin.autoImport.webpack ).value })
            //   result0
            // }

          )
          /* see the relevant, still-abandoned open bug-ticket */
          .toSwitchLinkerToCommonJs()
          .withWpTask(Compile, org.scalajs.sbtplugin.ScalaJSPlugin.autoImport.fullOptJS )
        }

        // TODO
        def withWpTask
          //
          //
          (Compile: Configuration, stage: (
            TaskKey[Attributed[File ] ]
          ) )
        : CrossProject
        = {
          ;

          import org.scalajs.sbtplugin.ScalaJSPlugin
          import scalajsbundler.sbtplugin.ScalaJSBundlerPlugin

          receiver

          .jsSettings(
            //

            (Compile / ScalaJSBundlerPlugin.autoImport.npmDependencies) ++= (
              Nil
              :+ ("esbuild" -> "0.18.16")
              // :+ ("vite" -> {
              //   ???
              // } )
            )
            ,

          )
          .jsSettings(
            //

            (Compile / stage / ScalaJSBundlerPlugin.autoImport.webpack ) := {
              // val v0 = (Compile / stage / ScalaJSBundlerPlugin.autoImport.webpack ).value
              // val files = v0.map(_.data )
              ;
              val logger
              = Keys.streams.value.log
              ({  })
              ;
              logger
              .info("a customised version of 'webpack', instead relying on ESBuild or Vite " )
              ;
              // val BUNDLEFILE =     "(?i)bundle\\.[cm]?[jt]s\\z".r.unanchored
              // val LIBRARFILE =    "(?i)library\\.[cm]?[jt]s\\z".r.unanchored
              // val ENTRYPFILE = "(?i)entrypoint\\.[cm]?[jt]s\\z".r.unanchored
              ;
              val taskBaseDir : File
              = { (Compile / ScalaJSBundlerPlugin.autoImport.npmUpdate / Keys.crossTarget ).value }
              logger
              .info("taskBaseDir: " + taskBaseDir )
              val fOptFile
              = {
                ({
                  ;
                  (Compile / stage)
                  .value
                  .data
                } )
              } : File
              logger
              .info("fOptFile: " + fOptFile )
              val fOptFileNameIncludingFnmExt
              = {
                ({
                  ;
                  fOptFile
                  .name
                } : String )
              }
              val fOptFileNameExcludingFnmExt
              = {
                fOptFileNameIncludingFnmExt
                // TODO
                .replaceFirst(".[cm]?[jt]sx?\\z", "")
              }
              logger
              .info("fOptFileNameExcludingFnmExt: " + fOptFileNameExcludingFnmExt )
              ;
              logger
              .info("runnng the task 'npmUpdate' " )
              (Compile / ScalaJSBundlerPlugin.autoImport.npmUpdate).value
              ;
              assert(taskBaseDir.toString.contains("scalajs-bundler"), "taskBaseDir points to unexpected directory: " + taskBaseDir )
              ;
              val appOnlyCodeFilePath
              = { {
                import java.nio.file._
                val f1 = (taskBaseDir / fOptFileNameExcludingFnmExt.++(".js") )
                Files.copy(fOptFile.toPath(), f1.toPath(), StandardCopyOption.REPLACE_EXISTING )
                f1
              } : File }
              val fullBundleFilePath
              = { {
                (taskBaseDir / fOptFileNameExcludingFnmExt.++("-bundle.js") )
              } : File }
              logger
              .info("appOnlyCodeFilePath: " + appOnlyCodeFilePath )
              logger
              .info("fullBundleFilePath: " + fullBundleFilePath )
              ({
                import java.nio.file.*
                // ((taskBaseDir / "vite.config.mjs" ) : File )
                Files.writeString((
                  ((taskBaseDir / "vite.config.mjs" ) : File )
                  .toPath()
                ), "import { defineConfig } from \"vite\"; export default defineConfig({ }) ;", StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING )
              })
              val cmd = (
                "npx.cmd" :: "esbuild" :: ({
                  // appOnlyCodeFilePath.absolutePath
                  appOnlyCodeFilePath.name
                } : String)
                :: "--bundle" :: "--sourcemap" ::
                  // "--target=chrome58,firefox57,safari11,edge16" ::
                  "--outfile=".++(fullBundleFilePath.absolutePath ) ::
                  Nil
              )
              logger
              .info("full cmd: " + cmd )
              val r = {
                import sbt.*
                sys.process.Process(cmd , taskBaseDir )
                .!(logger )
                match {
                  case 0 =>
                  case v => throw new RuntimeException("failed with exit-code " + v )
                }
              }
              ;
              Nil :+ (
                //
                Attributed.apply(fullBundleFilePath : File )(AttributeMap({
                  AttributeEntry(scalajsbundler.sbtplugin.SBTBundlerFile.ProjectNameAttr, fOptFileNameExcludingFnmExt)
                } ) )
              )
            }
            ,
            
          )
        }

        //
      }

      implicit class ScpScalablyTypedBuilderOps(receiver: CrossProject ) {
        //

        import org.scalablytyped.converter.plugin.*

        import org.scalablytyped.converter.plugin.ScalablyTypedPluginBase.autoImport.*
        import org.scalablytyped.converter.plugin.ScalablyTypedConverterGenSourcePlugin.autoImport.*
        import org.scalablytyped.converter.plugin.ScalablyTypedConverterPlugin.autoImport.*
        import org.scalablytyped.converter.plugin.ScalablyTypedConverterExternalNpmPlugin.autoImport.*

        def asScalablyTypedImportRepo()
        : CrossProject
        = {
          receiver
          // TODO
          .asLeafProjectWithNecessarySettings()
          .withScalablyTypedConv()
        }

        //
      }

      implicit class ScpScalablyTypedOps(receiver: CrossProject ) {
        //

        import org.scalablytyped.converter.plugin.*

        import org.scalablytyped.converter.plugin.ScalablyTypedPluginBase.autoImport.*
        import org.scalablytyped.converter.plugin.ScalablyTypedConverterGenSourcePlugin.autoImport.*
        import org.scalablytyped.converter.plugin.ScalablyTypedConverterPlugin.autoImport.*
        import org.scalablytyped.converter.plugin.ScalablyTypedConverterExternalNpmPlugin.autoImport.*

        def withScalablyTypedConv()
        = {
          receiver
          .platformsEnablePlugins(JSPlatform )(ScalablyTypedConverterPlugin )
          .jsSettings(
            //
            /* ERROR Unable to reload workspace: scalaJSModuleKind must be set to ModuleKind.CommonJSModule in projects where ScalaJSBundler plugin is enabled */
            scalaJSLinkerConfig ~= {

              //  import org.scalajs.linker.interface.ModuleSplitStyle

               _.withModuleKind(ModuleKind.CommonJSModule)
            },
          )
        }

        //
      }

      /* (with)in-chain utils */

      /**
       * 
       * runs `println(value)`.
       * 
       * */
      def kPrintln(value: Any)
      = println(value)

      /*  
       * https://github.com/sbt/sbt/blob/ecfb0624e911798a6d2bdf1f6a7c45acb1c59b1e/main/src/main/scala/sbt/internal/server/BuildServerProtocol.scala
       * .
       */
      object bspConfigs
      {

        //

        /** 
         * 
         * `bspBuildTargetCompile`.
         * scoped at `Global`.
         * 
         * an `InputKey` rather than a `TaskKey` !!!
         * 
         */
        lazy val forBuildTargetCompile
        = {
          //

          Global / Keys.bspBuildTargetCompile
        }

        /** 
         * 
         * `bspBuildTargetCompileItem`.
         * scoped at `phase`, which will need to be one of `Compile`, `Test`, `IntegrationTest`.
         * 
         */
        def forBuildTargetCompileItemAt(phase: Configuration)
        = {
          //

          phase / Keys.bspBuildTargetCompileItem
        }

      }

      object sJsTasks
      {

        //

        def fastLinkDuring(Phase1 : Configuration)
        : Def.Initialize[Task[Seq[File] ] ]
        = {
          //

          Def.task[Seq[File] ] ({
            kPrintln(s"invoking FastLinkJs")
            val fjsv = (Phase1 / fastLinkJS).value
            kPrintln(s"fjsv: ${fjsv}")
            Seq()
          })
        }

        def bundleWithWebpackTaskDuring(Phase1: Configuration)
        = {
          (Phase1 / org.scalajs.sbtplugin.ScalaJSPlugin.autoImport.fullOptJS / scalajsbundler.sbtplugin.ScalaJSBundlerPlugin.autoImport.webpack )
        }

      }

      /**
       * 
       * ```
       * new Exception(s"sourceGenerators evaluated")
       * .printStackTrace()
       * ```
       * 
       * */
      @deprecated("use 'new Exception(....).printStackTrace()' directly.")
      def runSge()
      : Unit
      = {
        //

        new Exception(s"sourceGenerators evaluated")
        .printStackTrace()
      }

      @deprecated("renamed into 'sJsTasks.fastLinkDuring(Phase1 = Phase1 )'.")
      def fjsHighLevelTaskIn(Phase1 : Configuration)
      : Def.Initialize[Task[Seq[File] ] ]
      = {
        //

        sJsTasks.fastLinkDuring(Phase1 = Phase1)
      }

      @deprecated("renamed into 'fjsHighLevelTaskIn(Phase1 = Compile )'.")
      private[mainly]
      def fjsHighLevelTask
      = fjsHighLevelTaskIn(Phase1 = Compile )

      implicit class CrossProjectDbpOPs(receiver: CrossProject)
      {

        //

        def withDbp(mainClassNames: Option[String])
        : CrossProject
        = {
          //
          
          receiver
          
          .asBrowserBasedApp(mainClassNames )

          // .settings(
          //   //

          //   Compile / Keys.compile := {
          //     //

          //     val value = (Compile / Keys.compile).value
          //     kPrintln(s"done Compile:Compile")
          //     value
          //   }
          //   ,

          //   Compile / Keys.compileIncremental := {
          //     //

          //     val value = (Compile / Keys.compileIncremental).value
          //     kPrintln(s"done Compile:compileIncremental")
          //     value
          //   }
          //   , 

          //   bspConfigs.forBuildTargetCompile := {
          //     //

          //     val value = (bspConfigs.forBuildTargetCompile ).evaluated
          //     kPrintln(s"done ${bspConfigs.forBuildTargetCompile }")
          //     value
          //   }
          //   , 

          //   bspConfigs.forBuildTargetCompileItemAt(phase = Compile ) := {
          //     //

          //     val value = (bspConfigs.forBuildTargetCompileItemAt(phase = Compile ) ).value
          //     kPrintln(s"done ${bspConfigs.forBuildTargetCompileItemAt(phase = Compile ) } ; exit-code ${value } ")
          //     value
          //   }
          //   ,

          //   (Compile / Keys.sourceGenerators) += {
          //     //

          //     Def.task[Seq[File] ] ({
          //       runSge()
          //       Seq()
          //     })
          //     .taskValue
          //     // .triggeredBy((Compile / fastLinkJS) )
          //   }
          //   ,

          //   /* etc */

          // )
          .jsEnablePlugins(scalajsbundler.sbtplugin.ScalaJSBundlerPlugin )
          .withRelevantScJsBundlerSpecificSetup(Compile )
          .jsSettings(
            //

            bspConfigs.forBuildTargetCompile := {
              //

              val value = (bspConfigs.forBuildTargetCompile ).evaluated
              kPrintln(s"done Compile:${bspConfigs.forBuildTargetCompile.toString }")
              fjsHighLevelTask.value
              // ({ ; (Compile / org.scalajs.sbtplugin.ScalaJSPlugin.autoImport.fullOptJS / scalajsbundler.sbtplugin.ScalaJSBundlerPlugin.autoImport.webpack ).value })
              sJsTasks.bundleWithWebpackTaskDuring(Compile ).value
              value
            }
            ,

            (Compile / Keys.sourceGenerators) += {
              //

              Def.task[Seq[File] ] ({
                runSge()
                Seq()
              })
              .taskValue
              // .triggeredBy((Compile / fastLinkJS) )
            }
            , 

            /* etc */

          )
        }

      }

   }

}












