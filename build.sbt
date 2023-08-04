















// System.err.println("SBT scalac version: " + scala)

val suggestedScalaVersionV: String
= "3.3.0"

ThisBuild / scalaVersion := suggestedScalaVersionV

def computeNecessaryProjectSettings() =
  Seq(
    //

    /* SCALAC OPTIONS */

    scalaVersion := suggestedScalaVersionV ,

    scalacOptions += "-Yexplicit-nulls" ,
    scalacOptions += "-Ysafe-init" ,

    scalacOptions += "-feature" ,
    scalacOptions += "-deprecation" ,
    scalacOptions += "-unchecked" ,

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

lazy val avFwUtilityLibProject
=
  (project in (packagesParentDir / "avfgenerics" ) )
  .aggregate(

    avFwHeadlessUtilityLibProject ,

    avcFormsProject ,

  )

lazy val avFwHeadlessUtilityLibProject
=
  (project in (packagesParentDir / "avfservergenerics" ) )
  .aggregate(

    avcEvLibProject ,
    
  )

lazy val avcEvLibProject
=
  (project in (packagesParentDir / "avfgevops" ) )
  .settings(
    
    computeNecessaryProjectSettings() ,

    //
  )
  .settings(libraryDependencies += Build.externalLibraryVersions.comMonix )

// lazy val amf
// =
//   (project in (packagesParentDir / "amfnf" ) )
//   .aggregate(
// 
//   )

lazy val avcFormsProject
=
  (project in (packagesParentDir / "avfwforms" ) )
  .settings(

    computeNecessaryProjectSettings() ,

    //
  )
  // .dependsOn(avFwHeadlessUtilityLibProject ) /* this pattern is prone to making dependency cycles, and SBT f*c*ed the resol up ☹ */
  .dependsOn(avcEvLibProject )













