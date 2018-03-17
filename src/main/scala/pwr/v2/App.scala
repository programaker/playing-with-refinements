package pwr.v2

object App {
  //Do not forget this import!
  import eu.timepit.refined.auto._

  def main(args: Array[String]): Unit = {
    //Now incorrect values won't compile, except...
    val bus = SpBus(
      id = 79869,
      line = "675N-10",
      company = "Gatusa"
    )

    println(bus)
  }
}
