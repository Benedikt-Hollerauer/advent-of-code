name := "adventOfCode"

scalaVersion := "3.2.1"

Compile / scalaSource := baseDirectory.value / "src"

// ZIO
val zioVersion = "2.0.5"

libraryDependencies += "dev.zio" %% "zio" % zioVersion
libraryDependencies += "dev.zio" %% "zio-streams" % zioVersion