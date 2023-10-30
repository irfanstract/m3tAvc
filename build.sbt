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
  .dependsOn(avFwScTReactAppDepsProject )

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
  .dependsOn(avFwScTReactAppDepsProject )

lazy val avcFormsWAuProject
=
  (crossProject(suggestedTargetPlatforms : _* ).withSuggestedSettings() in (packagesParentDir / "avfwau" ) )
  .asLeafProjectWithNecessarySettings()
  .dependsOn(avcGenericFormsProject )
  .withComRaquoAirstream()
  .dependsOn(avFwScTReactAppDepsProject )

lazy val avFwScTJsStdLibProject
=
  (crossProject(suggestedTargetPlatforms : _* ).withSuggestedSettings() in (packagesParentDir / "avfw-sct-stds" ) )
  .asScalablyTypedImportRepo()
  /* avoid using the `allow fwd compat` (`^`) flag ; it'd risk extended loading time! */
  .withNpmDependency ("@types/node" -> "20.8.2" )

lazy val avFwScTReactAppDepsProject
=
  (crossProject(suggestedTargetPlatforms : _* ).withSuggestedSettings() in (packagesParentDir / "avfw-sct" ) )
  .dependsOn(avFwScTJsStdLibProject )
  .asScalablyTypedImportRepo()
  /* avoid using the `allow fwd compat` (`^`) flag ; it'd risk extended loading time! */
  .withNpmDependency ("native-file-system-adapter" -> "3.0.0" )
  .withNpmDependency ("react" -> "18.2.0" )
  .withNpmDependency ("react-dom" -> "18.2.0" )
  .withNpmDependency ("@types/react" -> "18.2.25" )
  .withNpmDependency ("@types/react-dom" -> "^18" )
  .withNpmDependency ("ionicons" -> "6.0.3" )
  // .withNpmDependency ("draft-js" -> "0.11.7" )
  .withNpmDependency ("recharts" -> "2.10.1" )
  .withNpmDependency ("victory" -> "36.6.12" )
  .withNpmDependency ("d3" -> "7.8.5" )
  .withNpmDependency ("@types/d3" -> "7.4.3" )

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
  .dependsOn(avFwScTJsStdLibProject )
  .dependsOn(avFwScTReactAppDepsProject )
  .dependsOn(avcFormsWAuProject )
  .withMonix()
  .withJavaUtilLocaleCQuiroz()
  .withDevLaminar()













