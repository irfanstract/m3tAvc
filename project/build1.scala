













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
   extends
   AnyRef
   with StdLibBuild
   with ScalablyTypedBuildUtil
   with SpecialBspConfigs
   with SpecialSjsBuildConfigs
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

      //

      /* see also [https://github.com/portable-scala/sbt-crossproject](`sbt-crossproject`) */
      val suggestedTargetPlatforms: Seq[sbtcrossproject.Platform ]
      = Seq(JSPlatform)

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
            // TODO
            .withSuggestedResFilesOps()
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

      implicit class XCrossProjectSuggestedResFilesOps(receiver: CrossProject ) {
        //

        def withSuggestedResFilesOps()
        : CrossProject
        = {
          receiver
          .settings(
            //
            (Compile / Keys.sourceGenerators) ++= {
              // (
              //   Nil
              //   :+ (Keys.unmanagedResourceDirectories )
              //   :+ (Keys.unmanagedSourceDirectories )
              // )
              // .map(key => {
              //   ((), bsk(srcDirsConfig = key))
              // })
              // .map(e => e._2.taskValue )
              (
                Nil
                :+ bsk(srcDirsConfig = Keys.unmanagedResourceDirectories ).taskValue
                :+ bsk(srcDirsConfig = Keys.unmanagedSourceDirectories   ).taskValue
              )
            }
            ,
          )
        }

        // workaround to compiler failure due to exception
        private
        def bsk
          (srcDirsConfig: SettingKey[Seq[File]] )
        = Def.taskDyn {
          ;

          ({
            ;

            val logger
            = {
              (Keys.streams).value
              .log
            }

            val destDir
            = {
              (Compile / Keys.sourceManaged).value
            } : File

            (Compile / srcDirsConfig).value
            .map(rootDir => {
              // printAllResFilesIn(rootDir )(logger )
              // (() -> Seq() )
              ({
                ;

                toTranslateAllResFilesIn(srcRoot = rootDir )(destDir = destDir )
              })
            })
            match { case tasks => {
              // Def.sequential(tasks)
              tasks
              .foldLeft[Def.Initialize[Task[Seq[File] ] ] ](Def.task(Seq() ) )((t0, t1) => Def.task({ t0.value ++ t1.value }) )
            } }
          })
        }

        // TODO
        /* no need to restrict to JS ; we're only doing logging here */
        def printAllResFilesIn
          (f: File )
          (logger : Logger )
        : Unit
        = {
          //
          // val logger = Keys.streams.value.log
          logger.info("traversing, for resource files: " + f )
          import sbt.io.*
          for (itemPath <- PathFinder(f).descendantsExcept("*.css", ".ignore").get.take(15 ) ) {
            logger.info("resource file: " + itemPath )
          }
        }

        // TODO
        def toTranslateAllResFilesIn
          (srcRoot: File )
          (destDir : File )
        = Def.task {
          //
          def qtd(value: String)
          = "\"" + value + "\""
          def qtdPath(value: java.nio.file.Path)
          = {
            import scala.jdk.CollectionConverters.*
            "\"" + value.iterator.asScala.toIndexedSeq.map(_.toString() ).mkString("/") + "\""
          }
          val logger
          = Keys.streams.value.log
          val platformLetter = crossProjectPlatform.value.identifier
          import sbt.io.*
          logger.debug(s"toTranslateAllResFilesIn: " )
          logger.debug(s"for src dir $srcRoot -> dest dir $destDir " )
          case class SpecialTranslateRelativePathIntoPkgAndClassName
            (itemRelativePath: File )
          {
            ;

            val sFullName
            = {
              itemRelativePath
              .toString()
              .replace("\\", "/")
              .replaceFirst("\\A\\.\\/", "")
              .replace(".", "_")
              .split("\\/")
              .toIndexedSeq
            }

            val sPkgName :+ sLeafName
            = sFullName
          }
          for (itemRelativePath <- {
            PathFinder(srcRoot).descendantsExcept("*.css", ".ignore").get
            .map(itemAbsPath => {
              srcRoot
              .relativize(itemAbsPath ).get
            } )
          } )
          yield {
            // logger.info("resource file: " + itemPath )
            val prs = SpecialTranslateRelativePathIntoPkgAndClassName(itemRelativePath = itemRelativePath )
            import prs.{itemRelativePath => _ , sLeafName => sFileLeafName , _}
            // TODO
            (for (
              (generatedFileContent, destPath) <- Some( {
                //
                ;
                val finalLeafName
                = s"${sFileLeafName}_${platformLetter}Asset"
                ;
                (
                  Seq()
                  .++({
                    sPkgName
                    .map("package " + _)
                  })
                  .:+("" )
                  // .:+("import typings.{std as domItc } " )
                  // .:+("import typings.std.{global as dom } " )
                  .:+("" )
                  .:+(s"/**" )
                  .:+(s" * generated from" )
                  .:+(s" * file `${itemRelativePath }` in src-tree `${srcRoot }` " )
                  .:+(s" * for import/reference from Scala ." )
                  .:+(s" */ " )
                  // .:+(s"object $finalLeafName {" )
                  // // .:+(s"  scala.util.Try({" )
                  // // .:+(s"    val href = ${ } " )
                  // // .:+(s"    dom.document.appendChild(dom.document.createElement(\"div\") ) " )
                  // // .:+(s"    .innerHTML = \"<link rel=stylesheet href >\" " )
                  // // .:+(s"  }) " )
                  // // .:+(s"  .recover(z => { " )
                  // // .:+(s"    dom.console.info(${"\"cannot do CSS injection:\"" }, z.toString() )   " )
                  // // .:+(s"  } ) " )
                  // .:+(s"} // $finalLeafName " )
                  .:+("final /* works-around the \"not a legal path\" complaint */" )
                  .:+(s"lazy val $finalLeafName " )
                  .:+(s"= avcframewrk.forms.templating.assetsymbolism.`%%`( " )
                  .:+(s"  symbolisedName = ${qtd(finalLeafName ) } , " )
                  .:+(s"  itemRelativePath = ${qtdPath(itemRelativePath.toPath ) } , " )
                  .:+(s"  srcRoot = ${qtdPath(srcRoot.toPath ) } , " )
                  .:+(s") " )
                  .:+("" )
                  .mkString("\r\n")
                ) : String
              } , {
                Some(itemRelativePath)
                .map( { s => new File(s.toString() + ".scala") })
                // .map( { s => (new File("scala") ).toPath .resolve(s.toPath() ) .toFile })
                .map( { s => destDir.toPath .resolve(s.toPath() ) .toFile })
                .get
              } : File )
            )
            yield {
              ;
              logger.info(s"generating $destPath " )
              ;
              logger.info("contents: " + generatedFileContent )
              IO.write(destPath, generatedFileContent : String )
              ;
              (() , destPath)
            })
            .get._2
          }
        }

        //
      }

      /* (with)in-chain utils */

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












