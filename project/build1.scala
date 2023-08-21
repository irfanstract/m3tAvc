













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

      lazy val orgTypelevelKittens
         = identity[ModuleID]( "org.typelevel" %% "kittens" % "3.0.0" )

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

   object mainly
   {
      //

      import sbt._
      import sbt.Keys._

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
      = "3.3.1-RC4"

      ThisBuild / scalaVersion := suggestedScalaVersionV

      def computeNecessaryProjectSrcCodeManifest() =
        Seq(
          //

          /* TITLE */

          name := { s"${name.value } for ${ crossProjectPlatform.value.identifier }" } ,

          /* SCALAC OPTIONS */

          scalaVersion := suggestedScalaVersionV ,

          scalacOptions += "-Yexplicit-nulls" ,
          scalacOptions += "-Ysafe-init" ,

          scalacOptions += "-feature" ,
          scalacOptions += "-deprecation" ,
          scalacOptions += "-unchecked" ,
          scalacOptions += "-language:implicitConversions" ,

          /* RESOURCE PATHS */

          Compile / resourceDirectories += (
            baseDirectory.value / "src" / "main" / "resources"
          )
          ,

          /* STD LIB DEPENDENCIES */

          libraryDependencies ++= Seq(
            "org.scalatest" %% "scalatest" % "3.2.9" % Test
          )
          ,

        )

      lazy val xCompileAllTaskKey = {

        taskKey[Any]("compile all")
      }

      // TODO
      case class OfInputTask[R](peer : InputKey[R]) {
        // def value
        // = peer.evaluated
      }

      libraryDependencies ++= {

        println(s"PATH: '${java.lang.System.getenv("PATH") }'")

        Seq()
      }

      //

      lazy val bci = {

        settingKey[Seq[Task[Any] ] ]("")
      }

      /* see also [https://github.com/portable-scala/sbt-crossproject](`sbt-crossproject`) */
      val suggestedTargetPlatforms: Seq[sbtcrossproject.Platform ]
      = Seq(JVMPlatform, JSPlatform)

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
            .jsSettings(
            //

            // /** 
            //  * 
            //  * Depend on the scalajs library.
            //  * 
            //  * repeated here.
            //  * work-around for Bloop
            //  * 
            //  */
            // libraryDependencies += (
            //   scalaJsStdLibDepSpec
            // )
            // ,

            // Tell Scala.js that this is an application with a main method
            scalaJSUseMainModuleInitializer := true
            ,

            /* Configure Scala.js to emit modules in the optimal way to
            * connect to Vite's incremental reload.
            * - emit ECMAScript modules
            * - emit as many small modules as possible for classes in the "livechart" package
            * - emit as few (large) modules as possible for all other classes
            *   (in particular, for the standard library)
            */
            scalaJSLinkerConfig ~= {

               import org.scalajs.linker.interface.ModuleSplitStyle

               _.withModuleKind(ModuleKind.ESModule)
                  .withModuleSplitStyle(
                  ModuleSplitStyle.SmallModulesFor(List("scm2023021")))
            },

            // /**
            //  * Bloop
            //  * refuses to fully evaluate the std fields, citing the issues with side-effects, and instead
            //  * evaluates the "proxy" fields, in this case `bloopScalaJSModuleKind`
            //  */
            // bloopScalaJSModuleKind := Some("ESModule")
            // ,
            // bloopScalaJSStage := Some("fastopt")
            // ,

            /* Depend on the scalajs-dom library.
            * It provides static types for the browser DOM APIs.
            */
            libraryDependencies += "org.scala-js" %%% "scalajs-dom" % "2.4.0"
            ,

            //

            // bloop.integrations.sbt.ScalaJsKeys.scalaJSEmitSourceMaps := true
            // ,

            )
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
          .withSuggestedPlatformSpecifics()
        }

      }

      /* (with)in-chain utils */

      /**
       * 
       * runs `println(value)`.
       * 
       * */
      def kPrintln(value: Any)
      = println(value)

      lazy val bscc
      = {
        //

        /*  
         * https://github.com/sbt/sbt/blob/ecfb0624e911798a6d2bdf1f6a7c45acb1c59b1e/main/src/main/scala/sbt/internal/server/BuildServerProtocol.scala#L270C16-L270C16 .
         * .
         */
        Global / bspBuildTargetCompile
      }

      /**
       * 
       * ```
       * new Exception(s"sourceGenerators evaluated")
       * .printStackTrace()
       * ```
       * 
       * */
      def runSge()
      : Unit
      = {
        //

        new Exception(s"sourceGenerators evaluated")
        .printStackTrace()
      }

      def fjsHighLevelTaskIn(Phase1 : Configuration)
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

      @deprecated
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

          .settings(
            // libraryDependencies ++= {
            //   //

            //   Def.task({
            //     val value = (Compile / compile).value
            //     kPrintln(s"done Compile:Compile")
            //     fjsHighLevelTask.value
            //     value
            //   })
            //   .triggeredBy(Compile / compile )

            //   Seq()
            // }
            // (Compile / sourceGenerators) += {
            //   //

            //   fjsHighLevelTask
            //   .triggeredBy((Compile / fastLinkJS) )
            // }
            Compile / compile := {
              //

              val value = (Compile / compile).value
              kPrintln(s"done Compile:Compile")
              value
            }
            ,
            Compile / compileIncremental := {
              //

              val value = (Compile / compileIncremental).value
              kPrintln(s"done Compile:compileIncremental")
              value
            }
            , 
            // bspBuildTargetCompile := {
            //   //

            //   val value = (bspBuildTargetCompile).evaluated
            //   kPrintln(s"done bspBuildTargetCompile")
            //   value
            // }
            // // ,
            // mainClass := mainClassNames
            // ,
            bscc := {
              //

              val value = (bscc ).evaluated
              kPrintln(s"done Compile:${bscc }")
              value
            }
            , 
            Compile / bspBuildTargetCompileItem := {
              //

              val value = (Compile / bspBuildTargetCompileItem).value
              kPrintln(s"done Compile:bspBuildTargetCompileItem ; exit-code ${value } ")
              value
            }
            ,
            (Compile / sourceGenerators) += {
              //

              Def.task[Seq[File] ] ({
                runSge()
                Seq()
              })
              .taskValue
              // .triggeredBy((Compile / fastLinkJS) )
            }
            ,
            bci += {
              Def.task[Any ] ({
                println(s"bci in Settings")
                runSge()
                Seq()
              })
              .triggeredBy(Compile / compile )
              .taskValue
            }
            ,
          )
          .jsSettings(
            //

            bscc := {
              //

              val value = (bscc ).evaluated
              kPrintln(s"done Compile:${bscc.toString }")
              fjsHighLevelTask.value
              value
            }
            ,
            (Compile / sourceGenerators) += {
              //

              Def.task[Seq[File] ] ({
                runSge()
                Seq()
              })
              .taskValue
              // .triggeredBy((Compile / fastLinkJS) )
            }
            , 
            (Compile / mainClass) := mainClassNames
            ,

            //

            bspSbtEnabled := true
            ,

            bci += {
              Def.task[Any ] ({
                println(s"bci in JsSettings")
                runSge()
                Seq()
              })
              .triggeredBy(Compile / compile )
              .taskValue
            }
            ,

          )
        }

      }

   }

}












