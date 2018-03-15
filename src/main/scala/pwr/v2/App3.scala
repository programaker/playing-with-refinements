package pwr.v2

import cats.data.ValidatedNel
import cats.data.Validated.{Valid, Invalid}
import cats.implicits._
import eu.timepit.refined._
import pwr.v2.SpBus._

object App3 {
  def main(args: Array[String]): Unit = {
    buildBus(id = "0", line = "SV917", company = "", route = List("", "av", "rua Gomes de Carvalho")) match {
      case Valid(bus) => println(bus)
      case Invalid(errors) => errors.toList.foreach(println)
    }

    /*buildBus(id = "64570", line = "607G-10", company = "Mobibrasil", route = List("rua Gomes de Carvalho", "Funchal", "Berrini")) match {
      case Valid(bus) => println(bus)
      case Invalid(errors) => errors.toList.foreach(println)
    }*/
  }

  private def buildBus(id: String, line: String, company: String, route: List[String]): ValidatedNel[String, SpBus] = {
    //Integrating with Cats to accumulate all errors
    //using the ValidatedNel Applicative!
    (
      refineV[IdRange](id.toInt).toValidatedNel,
      refineV[LineRegex](line).toValidatedNel,
      refineV[MinSizeString](company).toValidatedNel,
      refineV[MinSizeStringList](route).toValidatedNel //workaround: validate, discard refined value, use original =(
    ) mapN { (id, line, company, _route) =>
      SpBus(id, line, company, route)
    }
  }
}
