import sbt._

object Dependencies {

  val akkaHttpVersion = "10.0.5"
  val Seq(akkaHttp, akkaTestkit) = Seq(
    "com.typesafe.akka" %% "akka-http",
    "com.typesafe.akka" %% "akka-http-testkit"
  ).map(_ % akkaHttpVersion)

  val serverDependencies = Seq(
    akkaHttp,
    akkaTestkit % Test
  )
}