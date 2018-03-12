package pwr.v2

import eu.timepit.refined.api.Refined

object App {
  import eu.timepit.refined.auto._

  def main(args: Array[String]): Unit = {
    val bus = SpBus(
      id = 39869,
      line = "702P-10",
      company = "Consorcio Plus"
    )

    println(bus)
  }
}
