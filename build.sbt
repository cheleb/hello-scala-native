enablePlugins(ScalaNativePlugin)

scalaVersion := "2.11.12"

scalacOptions ++= Seq("-feature")

nativeMode := "debug"

nativeGC := "immix"