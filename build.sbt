
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
  .settings(libraryDependencies += Build.externalLibraryVersions.orgTypelevelCatsCore )
  .settings(libraryDependencies += Build.externalLibraryVersions.orgTypelevelKittens )
  // .settings(libraryDependencies += Build.externalLibraryVersions.comMonix )

lazy val avcEvLibProject
=
  (crossProject(suggestedTargetPlatforms : _* ).withSuggestedSettings() in (packagesParentDir / "avfgevops" ) )
  .asLeafProjectWithNecessarySettings()
  .dependsOn(avFwAlgebLibProject )
  .settings(libraryDependencies += Build.externalLibraryVersions.comMonix )

// lazy val amf
// =
//   (crossProject(suggestedTargetPlatforms : _* ).withSuggestedSettings() in (packagesParentDir / "amfnf" ) )
//   .aggregate(
// 
//   )

lazy val avcFormsProject
=
  (crossProject(suggestedTargetPlatforms : _* ).withSuggestedSettings() in (packagesParentDir / "avfwforms" ) )
  .asLeafProjectWithNecessarySettings()
  // .dependsOn(avFwHeadlessUtilityLibProject ) /* this pattern is prone to making dependency cycles, and SBT f*c*ed the resol up ☹ */
  .dependsOn(avFwAlgebLibProject )
  .dependsOn(avcEvLibProject )
  .settings(libraryDependencies += Build.externalLibraryVersions.orgTypelevelCatsCore )
  .settings(libraryDependencies += Build.externalLibraryVersions.comMonix )

lazy val mainSjs
=
  (crossProject(suggestedTargetPlatforms : _* ).withSuggestedSettings() in (packagesParentDir / "main-sjs" ) )
  .asLeafProjectWithNecessarySettings()
  // .dependsOn(avFwHeadlessUtilityLibProject ) /* this pattern is prone to making dependency cycles, and SBT f*c*ed the resol up ☹ */
  .dependsOn(avFwAlgebLibProject )
  .dependsOn(avcEvLibProject )
  .dependsOn(avcFormsProject )
  .settings(libraryDependencies += Build.externalLibraryVersions.orgTypelevelCatsCore )
  .settings(libraryDependencies += Build.externalLibraryVersions.comMonix )













