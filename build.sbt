scalaVersion := "2.11.8"
scalaOrganization := "org.typelevel"

libraryDependencies ++= Seq(
  "io.circe" %% "circe-core" % "0.6.0-RC1",
  "io.circe" %% "circe-parser" % "0.6.0-RC1",
  "io.circe" %% "circe-generic" % "0.6.0-RC1",
  "io.circe" %% "circe-generic-extras" % "0.6.0-RC1",
  "org.scalatest" %% "scalatest" % "3.0.0" % Test
)

PB.targets in Compile := Seq(
  scalapb.gen() -> (sourceManaged in Compile).value
)
