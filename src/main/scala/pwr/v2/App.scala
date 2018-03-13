package pwr.v2

object App {
  import eu.timepit.refined.auto._

  def main(args: Array[String]): Unit = {
    //Now incorrect values won't compile, except...
    val bus = SpBus(
      id = 39869,
      line = "702P-10",
      company = "Consorcio Plus",
      route = List.empty //...[error] compile-time refinement only works with literals
    )

    println(bus)
  }
}
