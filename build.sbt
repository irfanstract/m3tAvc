













scalaVersion := "3.3.0"

scalacOptions += "-Yexplicit-nulls"

scalacOptions += "-deprecation"

libraryDependencies ++= Seq(
  "org.scalatest" %% "scalatest" % "3.2.9" % Test
)

Compile / resourceDirectories += (
  baseDirectory.value / "src" / "main" / "resources"
)

lazy val xCompileAllTaskKey = {

  taskKey[Any]("compile all")
}

// @deprecated
lazy val depsHasBeenInitImpl1 = {
  val c = new java.util.concurrent.atomic.AtomicBoolean(false)
  Def.task({
    println(s"[libraryDependencies WARNING] currently: ${libraryDependencies.value } ")
  })
  .triggeredBy(bloopGenerate)
  bloopGenerate
  .~=(r => {
    // println(s"[libraryDependencies WARNING] currently: ${libraryDependencies.value } ")
    assert(c.get(), s"race detected -- unexpectedly, 'bloopGenerate' has run before 'depsHasBeenInitImpl1' has been init-ed ")
    r
  })
  c
}

// lazy val mainProject
// = {

//   project.in(file("."))
//   .settings(
//     libraryDependencies ++= Seq(
//       "org.scalatest" %% "scalatest" % "3.2.9" % Test
//     )
//     ,
    
//     libraryDependencies ++= Seq(
//       "org.ow2.asm" % "asm" % "9.5"
//     )
//     ,
    
//   )
// }

/** 
 * 
 * work-around for Bloop
 * 
 */
libraryDependencies += {
  
  Build.backendSupportArtRefBloop
}

/** 
 * 
 * Depend on the scalajs library.
 * 
 * being a global setting, rather than a project-specific setting.
 * using same versions, across (sub)projects, is necessary to avoid bin-compat-related issues
 * 
 */
libraryDependencies += ({
  scalaJsStdLibDepSpec
})

/** 
 * ```
 * found: Unit
 * required: sbt.internal.DslEntry
 * ```
 */
libraryDependencies ++= ({
  depsHasBeenInitImpl1 set(true)
  Seq()
})

// TODO
lazy val scalaJsStdLibDepSpec: ModuleID
= 
  (
    "org.scala-js"
    // %%% "scalajs-library"
    % "scalajs-library_2.13"
    % (
      scalaJSVersion
      // "1.13.2"
    )
  )

lazy val mainSjsProject
= {
  //

  project.in(file("."))
  .enablePlugins(ScalaJSPlugin) // Enable the Scala.js plugin in this project
  .settings(

    libraryDependencies ++= ({
      println(s"[mainSjsProject] ")
      println(s"prior to def:  ")
      Seq()
    })
    ,

    // libraryDependencies ++= ({
    //   val p = {
    //     thisProject.value
    //   }
    //   println(s"- 'thisProject': ${p.id } ")
    // })
    // ,

    libraryDependencies ++= ({
      val p = {
        thisProject.value
      }
      println(s"- 'thisProject': ${p.id } ")
      val l = libraryDependencies.value
      val l1 = {
        l
        .map(m => s"m[${m.organization} % ${m.name } % ${m.revision} % [${m.configurations.getOrElse("no-config")}] ]")
      }
      println(s"- 'libraryDependencies': ${l } IOW ${l1 } ")
      Seq()
    })
    ,
    
    // scalaVersion := "3.2.2",

    /** 
     * 
     * Depend on the scalajs library.
     * 
     * repeated here.
     * work-around for Bloop
     * 
     */
    libraryDependencies += (
      scalaJsStdLibDepSpec
    )
    ,

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
          ModuleSplitStyle.SmallModulesFor(List("avcf-main")))
    },

    /* Depend on the scalajs-dom library.
     * It provides static types for the browser DOM APIs.
     */
    libraryDependencies += "org.scala-js" %%% "scalajs-dom" % "2.4.0"
    ,

    //

    bloop.integrations.sbt.ScalaJsKeys.scalaJSEmitSourceMaps := true
    ,

    (Compile / mainClass ) := Some("cbsq.avc.runEventsFunctoringDemo")
    ,

    // (Compile / fastLinkJS / scalaJSLinkerOutputDirectory) ~= (r => {

    //   println(s"sjv: ${scalaJSVersion}")

    //   println(s"dest: ${r}")

    //   r
    // })
    // ,
    
    // (Compile / bloopCompile) := ( {

    //   val t = (Compile / bloopCompile).value

    //   (Compile / fastLinkJS ).value
      
    //   // .map(s => {

    //   //   // ???
    //   //   fastLinkJS.value

    //   //   s
    //   // })

    //   t
    // })
    // (Compile / bloopCompile) := ( {

    //   val t = (Compile / fastLinkJS ).value

    //   t
    // })
    // (Compile / resourceGenerators) += (
      
    //   Def.task[Seq[File] ] {
    //     val f = {
    //       (Compile / fastLinkJS).value
    //       (Compile / fastLinkJSOutput).value
    //     }
    //     Seq(f)
    //   }
    // )
    // xCompileAllTaskKey := ({
      
    //   Def.taskDyn({
    //     ;
    //     println(s"sjv: ${scalaJSVersion}")
    //     val _
    //     = 
    //       (Def.task {
    //         ;

    //         val r = (Compile / fastLinkJS / scalaJSLinkerOutputDirectory).value
    //         println(s"dest: ${r}")
    //       })
    //       // .triggeredBy((Compile / fastLinkJS / scalaJSLinkerOutputDirectory) )
    //     val buildTask1
    //     = 
    //       (Def.task {
    //         ;
    //         (Compile / fastLinkJS).value
    //         val o = (Compile / fastLinkJSOutput).value
    //         println(s"FJS: ${o}")
    //       })
    //       .dependsOn((Compile / compile ) )
    //     buildTask1
    //   })
    //   .triggeredBy(Compile / compile )
    // })
    // (Compile / compileIncremental) := {
    //   val v = (Compile / compileIncremental).value
    //   (Compile / fastLinkJS).value
    //   v
    // }
    (Compile / compileIncremental) := {
      val v = (Compile / compileIncremental).value
      println(s"compile task finished; ${v}")
      v
    }
    ,
    
    
  )
}

// mainSjsProject










