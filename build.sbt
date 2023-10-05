
import sbtcrossproject.CrossProject
















// System.err.println("SBT scalac version: " + scala)

import Build.mainly._

lazy val avFwUtilityLibProject
=
  (crossProject(suggestedTargetPlatforms : _* ).withSuggestedSettings() in (packagesParentDir / "avfgenerics" ) )
  .aggregate(

    avFwHeadlessUtilityLibProject ,

    avcFormsProject ,

  )

lazy val avFwHeadlessUtilityLibProject
=
  (crossProject(suggestedTargetPlatforms : _* ).withSuggestedSettings() in (packagesParentDir / "avfservergenerics" ) )
  .aggregate(

    avFwAlgebLibProject ,

    avcEvLibProject ,
    
  )

lazy val avFwAlgebLibProject
=
  (crossProject(suggestedTargetPlatforms : _* ).withSuggestedSettings() in (packagesParentDir / "avfwalgeb" ) )
  .asLeafProjectWithNecessarySettings()
  // .settings(libraryDependencies += Build.externalLibraryVersions.comMonix )

lazy val avcEvLibProject
=
  (crossProject(suggestedTargetPlatforms : _* ).withSuggestedSettings() in (packagesParentDir / "avfgevops" ) )
  .asLeafProjectWithNecessarySettings()
  .dependsOn(avFwAlgebLibProject )
  .withMonix()

lazy val avcFormsProject
=
  (crossProject(suggestedTargetPlatforms : _* ).withSuggestedSettings() in (packagesParentDir / "avfwforms" ) )
  .asLeafProjectWithNecessarySettings()
  // .dependsOn(avFwHeadlessUtilityLibProject ) /* this pattern is prone to making dependency cycles, and SBT f*c*ed the resol up ☹ */
  .dependsOn(avFwAlgebLibProject )
  .dependsOn(avcEvLibProject )
  .withMonix()
  .withComRaquoAirstream()
  .withDevLaminar()
  .dependsOn(avFwScTProject )

lazy val avFwScTProject
=
  (crossProject(suggestedTargetPlatforms : _* ).withSuggestedSettings() in (packagesParentDir / "avfw-sct" ) )
  .asLeafProjectWithNecessarySettings()
  .withScalablyTypedConv()
  .jsSettings(
    //
    Compile / npmDependencies ++= (
      Seq()
      :+ ("@types/node" -> "20.8.2" )
      :+ ("react" -> "^18.2.0" )
      :+ ("react-dom" -> "^18.2.0" )
      :+ ("@types/react" -> "18.2.25" )
      :+ ("@types/react-dom" -> "^18" )
      // :+ ("ionicons" -> "^6.0.3" )
      // :+ ("draft-js" -> "0.11.7" )
    ) ,
  )

lazy val mainSjs
=
  (crossProject(suggestedTargetPlatforms : _* ).withSuggestedSettings() in (packagesParentDir / "main-sjs" ) )
  .asLeafProjectWithNecessarySettings()
  .withDbp(mainClassNames = Some("runSMain") )
  // .dependsOn(avFwHeadlessUtilityLibProject ) /* this pattern is prone to making dependency cycles, and SBT f*c*ed the resol up ☹ */
  .dependsOn(avFwAlgebLibProject )
  .dependsOn(avcEvLibProject )
  .dependsOn(avcFormsProject )
  .dependsOn(avFwScTProject )
  .withMonix()
  .withJavaUtilLocaleCQuiroz()
  .withDevLaminar()













