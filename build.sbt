import Dependencies._

val circeVersion = "0.9.1"

lazy val root = (project in file(".")).
  settings(
    inThisBuild(List(
      organization := "com.example",
      scalaVersion := "2.12.3",
      version      := "0.1.0-SNAPSHOT"
    )),
    name := "FeatureFlagClient",
    libraryDependencies ++= Seq(
      scalaTest % Test,
      "io.circe" %% "circe-core" % circeVersion,
      "io.circe" %% "circe-generic" % circeVersion,
      "io.circe" %% "circe-generic-extras" % circeVersion,
      "io.circe" %% "circe-java8" % circeVersion,
      "io.circe" %% "circe-parser" % circeVersion,
      "org.scalamock" %% "scalamock" % "4.1.0" % Test,
      "org.scalatest" %% "scalatest" % "3.0.4" % Test
    )
  )