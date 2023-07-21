resolvers ++= Resolver.sonatypeOssRepos("snapshots")

enablePlugins(ScalaNativePlugin)

//calaVersion := "2.13.8"
scalaVersion := "3.3.0"

scalafmtOnCompile := true

//scalacOptions ++= Seq("-feature")

//nativeMode := "debug"

//libraryDependencies += "org.scalameta" %% "munit" % "0.7.29" % Test
libraryDependencies += "com.lihaoyi" %% "mainargs" % "0.5.0"
//libraryDependencies += "com.softwaremill.sttp.client3" %%% "core" % "3.8.16"
// Use %%% for non-JVM projects.
testFrameworks += new TestFramework("munit.Framework")

nativeConfig ~= { _.withMultithreadingSupport(true) }

//nativeGC := "immix"

(Compile / run) / mainClass := Some("example.ReadLine")
