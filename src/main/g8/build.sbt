import Dependencies._
import sbt._

inThisBuild(
  Seq(
    version := "0.1",
    scalaVersion := "2.12.2",
    organization := "$oraganization$"
  ))

lazy val root = (project in file("."))
  .aggregate(`server`)
  .settings(run := (run in `server` in Compile).evaluated)

lazy val `server` = (project in file("app/jvm"))
  .settings(
    name := "$name$",
    libraryDependencies ++= serverDependencies
  )
