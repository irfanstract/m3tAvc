/* DO NOT USE BLOOP ! */

import sbtcrossproject.CrossProject
















// System.err.println("SBT scalac version: " + scala)

import Build.mainly._

lazy val avFwUtilityLibProject
=
  (crossProject(suggestedTargetPlatforms : _* ).withSuggestedSettings() in (packagesParentDir / "avfgenerics" ) )
  .aggregate(

    avFwHeadlessUtilityLibProject ,

    avcGenericFormsProject ,

  )

lazy val avFwHeadlessUtilityLibProject
=
  (crossProject(suggestedTargetPlatforms : _* ).withSuggestedSettings() in (packagesParentDir / "avfservergenerics" ) )
  .aggregate(

    avcAlgebraLibProject ,

    // avcEvLibProject ,
    
  )

lazy val avcAlgebraLibProject
=
  (crossProject(suggestedTargetPlatforms : _* ).withSuggestedSettings() in (packagesParentDir / "avfwalgeb" ) )
  .asLeafProjectWithNecessarySettings()
  // .settings(libraryDependencies += Build.externalLibraryVersions.comMonix )

lazy val avFwLoopsLibProject
=
  (crossProject(suggestedTargetPlatforms : _* ).withSuggestedSettings() in (packagesParentDir / "avfw-loops" ) )
  .asLeafProjectWithNecessarySettings()
  .dependsOn(avcAlgebraLibProject )
  // .settings(libraryDependencies += Build.externalLibraryVersions.comMonix )

// lazy val avcFormsPredefsProject
// =
//   (crossProject(suggestedTargetPlatforms : _* ).withSuggestedSettings() in (packagesParentDir / "avfwforms-predefs" ) )
//   .asLeafProjectWithNecessarySettings()
//   .dependsOn(avcAlgebraLibProject )

// lazy val avcEvLibProject
// =
//   (crossProject(suggestedTargetPlatforms : _* ).withSuggestedSettings() in (packagesParentDir / "avfgevops" ) )
//   .asLeafProjectWithNecessarySettings()
//   .dependsOn(avcAlgebraLibProject )
//   .withMonix()

lazy val avcGenericFormsProject
=
  (crossProject(suggestedTargetPlatforms : _* ).withSuggestedSettings() in (packagesParentDir / "avfwforms" ) )
  .asLeafProjectWithNecessarySettings()
  // .dependsOn(avFwHeadlessUtilityLibProject )
  .dependsOn(avcAlgebraLibProject )
  // .dependsOn(avcFormsPredefsProject )
  // .dependsOn(avcEvLibProject )
  .withMonix()
  .withComRaquoAirstream()
  .withDevLaminar()
  .withDevSlinky()
  .dependsOn(avFwScTProject )

// lazy val avcFormsDocumentStateMgmtProject
// =
//   (crossProject(suggestedTargetPlatforms : _* ).withSuggestedSettings() in (packagesParentDir / "avfwforms-editors" ) )
//   .asLeafProjectWithNecessarySettings()
//   // .dependsOn(avFwHeadlessUtilityLibProject )
//   .dependsOn(avcAlgebraLibProject )
//   // .dependsOn(avcFormsPredefsProject )
//   .dependsOn(avcGenericFormsProject )
//   // .dependsOn(avcEvLibProject )
//   .withMonix()
//   .withComRaquoAirstream()

lazy val avcReactAppFormsProject
=
  (crossProject(suggestedTargetPlatforms : _* ).withSuggestedSettings() in (packagesParentDir / "avfwforms-reactjsapp" ) )
  .asLeafProjectWithNecessarySettings()
  .dependsOn(avcGenericFormsProject )
  // .dependsOn(avFwHeadlessUtilityLibProject )
  .dependsOn(avcAlgebraLibProject )
  // .dependsOn(avcFormsPredefsProject )
  // .dependsOn(avcEvLibProject )
  // .dependsOn(avcFormsDocumentStateMgmtProject )
  .withMonix()
  .withComRaquoAirstream()
  .withDevLaminar()
  .withDevSlinky()
  .dependsOn(avFwScTProject )

lazy val avcFormsWAuProject
=
  (crossProject(suggestedTargetPlatforms : _* ).withSuggestedSettings() in (packagesParentDir / "avfwau" ) )
  .asLeafProjectWithNecessarySettings()
  .dependsOn(avcGenericFormsProject )
  .withComRaquoAirstream()
  .dependsOn(avFwScTProject )

lazy val avFwScTProject
=
  (crossProject(suggestedTargetPlatforms : _* ).withSuggestedSettings() in (packagesParentDir / "avfw-sct" ) )
  .asScalablyTypedImportRepo()
  .jsSettings(
    //
    /* avoid using the `allow fwd compat` (`^`) flag ; it'd risk extended loading time! */
    Compile / npmDependencies ++= (
      Seq()
      :+ ("@types/node" -> "20.8.2" )
      :+ ("react" -> "18.2.0" )
      :+ ("react-dom" -> "18.2.0" )
      :+ ("@types/react" -> "18.2.25" )
      :+ ("@types/react-dom" -> "^18" )
      // :+ ("ionicons" -> "6.0.3" )
      // :+ ("draft-js" -> "0.11.7" )
      :+ ("native-file-system-adapter" -> "3.0.0" )
    ) ,
  )

lazy val mainSjs
=
  (crossProject(suggestedTargetPlatforms : _* ).withSuggestedSettings() in (packagesParentDir / "main-sjs" ) )
  .asLeafProjectWithNecessarySettings()
  .withDbp(mainClassNames = Some("runSMain") )
  // .dependsOn(avFwHeadlessUtilityLibProject ) /* this pattern is prone to making dependency cycles, and SBT f*c*ed the resol up ☹ */
  .dependsOn(avcAlgebraLibProject )
  // .dependsOn(avcEvLibProject )
  .dependsOn(avcGenericFormsProject )
  .dependsOn(avcReactAppFormsProject )
  // .dependsOn(avcFormsDocumentStateMgmtProject )
  .dependsOn(avFwScTProject )
  .dependsOn(avcFormsWAuProject )
  .withMonix()
  .withJavaUtilLocaleCQuiroz()
  .withDevLaminar()













