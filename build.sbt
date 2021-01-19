enablePlugins(ScalaNativePlugin)

scalaVersion := "2.13.6"

//scalacOptions ++= Seq("-feature")

//nativeMode := "debug"

libraryDependencies += "org.scalameta" %% "munit" % "0.7.29" % Test
libraryDependencies += "com.lihaoyi" %% "mainargs" % "0.2.1"
// Use %%% for non-JVM projects.
testFrameworks += new TestFramework("munit.Framework")

//nativeGC := "immix"

(Compile / run) / mainClass := Some("example.ReadLine")
