package pwr.v2

import eu.timepit.refined._
import pwr.v2.SpBus._

object App2 {
  def main(args: Array[String]): Unit = {
    println(buildBus(id = "0", line = "SV917", company = "", route = Nil))
    println(buildBus(id = "60011", line = "607G-10", company = "Unisul", route = List("av Berrine", "av Bandeirantes")))
    println(buildBus(id = "72811", line = "7600-10", company = "XP", route = List("av Faria Lima", "rua Funchal")))
  }

  private def buildBus(id: String, line: String, company: String, route: List[String]): Either[String, SpBus] = {
    for {
      id <- refineV[Id](id.toInt)
      line <- refineV[Line](line)
      company <- refineV[Company](company)
      _ <- refineV[Route](route) //workaround: validate, discard the value =(
    } yield SpBus(id, line, company, route)
  }
}
