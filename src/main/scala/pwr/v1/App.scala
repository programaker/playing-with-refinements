package pwr.v1

object App {
  def main(args: Array[String]): Unit = {
    //The compiler will happily accept those values
    val bus = SpBus(
      id = 0,
      line = "SV917",
      company = ""
    )

    println(bus)
  }
}
