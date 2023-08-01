















// System.err.println("SBT scalac version: " + scala)

def computeNecessaryProjectSettings() =
  Seq(
    //

    /* SCALAC OPTIONS */

    scalaVersion := "3.3.0" ,

    scalacOptions += "-Yexplicit-nulls" ,

    scalacOptions += "-deprecation" ,

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

libraryDependencies ++= {

  println(s"PATH: '${java.lang.System.getenv("PATH") }'")

  Seq()
}

/**
 * 
 * the parent dir of every of these packages.
 * follows that of the React dev repo.
 * 
 */
val packagesParentDir
= file("packages")













