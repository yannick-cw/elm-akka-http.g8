package server

import akka.actor.ActorSystem
import akka.http.scaladsl.Http
import akka.http.scaladsl.server.Directives._
import akka.http.scaladsl.server.Route
import akka.http.scaladsl.unmarshalling.Unmarshal
import akka.stream.ActorMaterializer
import akka.http.scaladsl.model.MediaTypes.`application/json`
import akka.http.scaladsl.model.HttpEntity

import scala.concurrent.ExecutionContext.Implicits.global

object Server extends App {
  implicit val system = ActorSystem()
  implicit val materializer = ActorMaterializer()

  val basePageRoute: Route =
    get(pathSingleSlash(getFromFile("../assets/static/index.html"))) ~ getFromDirectory("../assets/static/")

  val pingRoute: Route =
    (get & path("ping")) {
        complete(HttpEntity(`application/json`, """{ "pong" : "Pong: This is dog" }"""))
      }

  Http().bindAndHandle(basePageRoute ~ pingRoute, "0.0.0.0", 8080)
}
