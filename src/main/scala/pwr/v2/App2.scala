package pwr.v2

import eu.timepit.refined._
import pwr.v2.SpBus._

object App2 {
  def main(args: Array[String]): Unit = {
    println(printBus(buildBus(id = "0", line = "SV917", company = "")))
    println(printBus(buildBus(id = "72811", line = "7600-10", company = "XP")))

    println(printBus(buildBus(id = "72811", line = "7600-10", company = "Gatusa")))
    println(printBus(buildBus(id = "60011", line = "607G-10", company = "Unisul")))
    println(printBus(buildBus(id = "63311", line = "6L01-10", company = "Mobibrasil")))
  }

  private def buildBus(id: String, line: String, company: String): Either[String, SpBus] = {
    //Refined does not offer a way to accumulate all validation errors
    //but you can use Cats or Scalaz to do it
    for {
      id <- refineV[IdRange](id.toInt)
      line <- refineV[LineRegex](line)
      company <- refineV[MinSizeString](company)
    } yield SpBus(id, line, company)
  }

  def printBus(eBus: Either[String, SpBus]): String = eBus match {
    case Left(error) =>
      s"""
        |$error
      """.stripMargin

    case Right(bus) =>
      s"""
        |id = ${bus.id}
        |line = ${bus.line}
        |company = ${bus.company}
      """.stripMargin
  }
}
