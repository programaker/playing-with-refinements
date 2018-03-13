package pwr.v2

import cats.data.ValidatedNel
import cats.implicits._
import eu.timepit.refined._
import pwr.v2.SpBus._

object App3 {
  def main(args: Array[String]): Unit = {
    println(buildBus(id = "0", line = "SV917", company = ""))
  }

  private def buildBus(id: String, line: String, company: String): ValidatedNel[String, SpBus] = {
    (
      refineV[Id](id.toInt).toValidatedNel,
      refineV[Line](line).toValidatedNel,
      refineV[Company](company).toValidatedNel
    ) mapN {
      (id, line, company) => SpBus(id, line, company)
    }
  }
}
