













scalaVersion := "3.2.2"

scalacOptions += "-Yexplicit-nulls"

libraryDependencies ++= Seq(
  "org.scalatest" %% "scalatest" % "3.2.9" % Test
)

Compile / resourceDirectories += (
  baseDirectory.value / "src" / "main" / "resources"
)










