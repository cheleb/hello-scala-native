enablePlugins(ScalaNativePlugin)

//calaVersion := "2.13.8"
scalaVersion := "3.1.2"

scalafmtOnCompile := true

//scalacOptions ++= Seq("-feature")

//nativeMode := "debug"

libraryDependencies += "org.scalameta" %% "munit" % "0.7.29" % Test
libraryDependencies += "com.lihaoyi" %% "mainargs" % "0.2.3"
libraryDependencies += "com.softwaremill.sttp.client3" %%% "core" % "3.6.2"
// Use %%% for non-JVM projects.
testFrameworks += new TestFramework("munit.Framework")

//nativeGC := "immix"

(Compile / run) / mainClass := Some("example.ReadLine")
