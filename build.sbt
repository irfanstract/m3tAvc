/* DO NOT USE BLOOP ! */

import sbtcrossproject.CrossProject
















// System.err.println("SBT scalac version: " + scala)

import Build.mainly._

lazy val avFwUtilityLibProject
=
  (crossProject(suggestedTargetPlatforms : _* ).withSuggestedSettings() in (packagesParentDir / "avfgenerics" ) )
  .aggregate(

    avFwHeadlessUtilityLibProject ,

    avcFormsGenericProject ,

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
  (crossProject(suggestedTargetPlatforms.+:(JVMPlatform ) : _* ).withSuggestedSettings() in (packagesParentDir / "avfwalgeb" ) )
  .asLeafProjectWithNecessarySettings()
  // .settings(libraryDependencies += Build.externalLibraryVersions.comMonix )

lazy val avFwLoopAndMusicalAlgebraLibProject
=
  (crossProject(suggestedTargetPlatforms.+:(JVMPlatform ) : _* ).withSuggestedSettings() in (packagesParentDir / "avfw-loops" ) )
  .asLeafProjectWithNecessarySettings()
  .dependsOn(avcAlgebraLibProject )
  // .settings(libraryDependencies += Build.externalLibraryVersions.comMonix )

// lazy val avcEvLibProject
// =
//   (crossProject(suggestedTargetPlatforms : _* ).withSuggestedSettings() in (packagesParentDir / "avfgevops" ) )
//   .asLeafProjectWithNecessarySettings()
//   .dependsOn(avcAlgebraLibProject )
//   .withMonix()

lazy val avcFormsPredefsProject
=
  (crossProject(suggestedTargetPlatforms : _* ).withSuggestedSettings() in (packagesParentDir / "avfwforms-predefs" ) )
  .asLeafProjectWithNecessarySettings()
  .dependsOn(avcAlgebraLibProject )
  .dependsOn(avFwLoopAndMusicalAlgebraLibProject )
  .withComRaquoAirstream()
  .dependsOn(avFwScTJsStdLibProject )

lazy val avcFormsTemplatingSpecificConcurrencyProject
=
  (crossProject(suggestedTargetPlatforms : _* ).withSuggestedSettings() in (packagesParentDir / "avfwforms-concurrency" ) )
  .asLeafProjectWithNecessarySettings()
  .dependsOn(avcAlgebraLibProject )
  .dependsOn(avFwLoopAndMusicalAlgebraLibProject )
  .dependsOn(avcFormsPredefsProject )
  // .dependsOn(avcEvLibProject )
  .withComRaquoAirstream()
  // .withMonix()
  .dependsOn(avFwScTJsStdLibProject )
  // .withDevSlinky()
//

lazy val avcFormsGenericCoreProject
=
  (crossProject(suggestedTargetPlatforms : _* ).withSuggestedSettings() in (packagesParentDir / "avfwforms" ) )
  .asLeafProjectWithNecessarySettings()
  // .dependsOn(avFwHeadlessUtilityLibProject )
  .dependsOn(avcAlgebraLibProject )
  .dependsOn(avcFormsPredefsProject )
  .dependsOn(avcFormsTemplatingSpecificConcurrencyProject )
  // .dependsOn(avcEvLibProject )
  .withMonix()
  .withComRaquoAirstream()
  .dependsOn(avFwScTJsStdLibProject )
  .withDevLaminar()
  .withDevSlinky()
  .dependsOn(avFwScTReactAppDepsProject )

lazy val avcFormsTemplatingFwsProject
=
  (crossProject(suggestedTargetPlatforms : _* ).withSuggestedSettings() in (packagesParentDir / "avfwforms-b-templatingext" ) )
  .asLeafProjectWithNecessarySettings()
  .dependsOn(avcAlgebraLibProject )
  // .dependsOn(avcEvLibProject )
  .withComRaquoAirstream()
  .dependsOn(avcFormsPredefsProject )
  .dependsOn(avcFormsGenericCoreProject )
  .withDevSlinky()
  .dependsOn(avFwScTReactAppDepsProject )
  .dependsOn(avcFormsNativeToolkitUsageHelperProject )

lazy val avcFormsNativeToolkitUsageHelperProject
=
  (crossProject(suggestedTargetPlatforms : _* ).withSuggestedSettings() in (packagesParentDir / "avfwforms-b-nativetoolkithelper" ) )
  .asLeafProjectWithNecessarySettings()
  .dependsOn(avcAlgebraLibProject )
  // .dependsOn(avcEvLibProject )
  .withComRaquoAirstream()
  .dependsOn(avcFormsPredefsProject )
  .dependsOn(avcFormsGenericCoreProject )
  .withDevSlinky()
  .dependsOn(avFwScTReactAppDepsProject )

lazy val avcFormsGenericProject
=
  (crossProject(suggestedTargetPlatforms : _* ).withSuggestedSettings() in (packagesParentDir / "avfwforms-common" ) )
  .asLeafProjectWithNecessarySettings()
  .dependsOn(avcAlgebraLibProject )
  // .dependsOn(avcEvLibProject )
  .withMonix()
  .withComRaquoAirstream()
  .withDevLaminar()
  .dependsOn(avcFormsPredefsProject )
  .dependsOn(avcFormsGenericCoreProject )
  .dependsOn(avcFormsTemplatingSpecificConcurrencyProject )
  .withDevSlinky()
  .dependsOn(avFwScTReactAppDepsProject )
  .dependsOn(avcFormsNativeToolkitUsageHelperProject )
  .dependsOn(avcFormsTemplatingFwsProject )

lazy val avcReactAppFormsProject
=
  (crossProject(suggestedTargetPlatforms : _* ).withSuggestedSettings() in (packagesParentDir / "avfwforms-reactjsapp" ) )
  .asLeafProjectWithNecessarySettings()
  .dependsOn(avcFormsGenericProject )
  // .dependsOn(avFwHeadlessUtilityLibProject )
  .dependsOn(avcAlgebraLibProject )
  // .dependsOn(avcEvLibProject )
  // .dependsOn(avcFormsCommonDocuFormsProject )
  // .withMonix()
  .withComRaquoAirstream()
  .withDevLaminar()
  // .dependsOn(avcFormsPredefsProject )
  .withDevSlinky()
  .dependsOn(avFwScTReactAppDepsProject )

lazy val avcFormsCommonDocuFormsProject
=
  (crossProject(suggestedTargetPlatforms : _* ).withSuggestedSettings() in (packagesParentDir / "avfwforms-editors" ) )
  .asLeafProjectWithNecessarySettings()
  // .dependsOn(avFwHeadlessUtilityLibProject )
  .dependsOn(avcAlgebraLibProject )
  // .dependsOn(avcEvLibProject )
  // .withMonix()
  .withComRaquoAirstream()
  // .dependsOn(avcFormsPredefsProject )
  .dependsOn(avcFormsGenericProject )
  // .configurePlatform(JSPlatform )(pr => {
  //   pr.dependsOn(avcReactAppFormsProject.js )
  // } )
  .dependsOn(avcReactAppFormsProject )
  .withDevSlinky()

lazy val avcFormsCommonDocuFormsProProject
=
  (crossProject(suggestedTargetPlatforms : _* ).withSuggestedSettings() in (packagesParentDir / "avfwforms-editors-pro" ) )
  .asLeafProjectWithNecessarySettings()
  // .dependsOn(avFwHeadlessUtilityLibProject )
  .dependsOn(avcAlgebraLibProject )
  .dependsOn(avFwLoopAndMusicalAlgebraLibProject )
  // .dependsOn(avcEvLibProject )
  // .withMonix()
  .withComRaquoAirstream()
  // .dependsOn(avcFormsPredefsProject )
  .dependsOn(avcFormsGenericProject )
  .dependsOn(avcReactAppFormsProject )
  .dependsOn(avcFormsWAuProject )
  .dependsOn(avcFW3RtcProject )
  .withDevSlinky()

lazy val avcFormsWAuProject
=
  (crossProject(suggestedTargetPlatforms : _* ).withSuggestedSettings() in (packagesParentDir / "avfwau" ) )
  .asLeafProjectWithNecessarySettings()
  .dependsOn(avcAlgebraLibProject )
  .dependsOn(avFwLoopAndMusicalAlgebraLibProject )
  .withComRaquoAirstream()
  .dependsOn(avcFormsGenericProject )
  .dependsOn(avFwScTReactAppDepsProject )

lazy val avcFW3RtcProject
=
  (crossProject(suggestedTargetPlatforms : _* ).withSuggestedSettings() in (packagesParentDir / "avfw3rtc" ) )
  .asLeafProjectWithNecessarySettings()
  .dependsOn(avcAlgebraLibProject )
  .dependsOn(avFwLoopAndMusicalAlgebraLibProject )
  .withComRaquoAirstream()
  .dependsOn(avcFormsGenericProject )
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
  .withNpmDependency ("@types/react" -> "18.2.25" )
  .withNpmDependency ("react" -> "18.2.0" )
  .withNpmDependency ("@types/react-dom" -> "^18" )
  .withNpmDependency ("react-dom" -> "18.2.0" )
  .withNpmDependency ("ionicons" -> "6.0.3" )
  // .withNpmDependency ("draft-js" -> "0.11.7" )
  .withNpmDependency ("recharts" -> "2.10.1" )
  .withNpmDependency ("victory" -> "36.6.12" )
  .withNpmDependency ("@types/d3" -> "7.4.3" )
  .withNpmDependency ("d3" -> "7.8.5" )
  .withNpmDependency ("@types/opentype.js" -> "1.3.8" )
  .withNpmDependency ("opentype.js" -> "1.3.4" )

lazy val mainSjs
=
  (crossProject(suggestedTargetPlatforms : _* ).withSuggestedSettings() in (packagesParentDir / "main-sjs" ) )
  .asLeafProjectWithNecessarySettings()
  .withDbp(mainClassNames = Some("runSMain") )
  // .dependsOn(avFwHeadlessUtilityLibProject ) /* this pattern is prone to making dependency cycles, and SBT f*c*ed the resol up ☹ */
  .dependsOn(avcAlgebraLibProject )
  // .dependsOn(avcEvLibProject )
  .dependsOn(avcFormsGenericProject )
  .dependsOn(avcReactAppFormsProject )
  .dependsOn(avcFormsCommonDocuFormsProject )
  .dependsOn(avcFormsCommonDocuFormsProProject )
  .dependsOn(avFwScTJsStdLibProject )
  .dependsOn(avFwScTReactAppDepsProject )
  .dependsOn(avcFormsWAuProject )
  .dependsOn(avcFW3RtcProject )
  .withMonix()
  .withJavaUtilLocaleCQuiroz()
  .withDevLaminar()













