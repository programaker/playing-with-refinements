package pwr.v3

import eu.timepit.refined.api.Refined
import eu.timepit.refined.boolean.And
import eu.timepit.refined.collection.{Forall, NonEmpty}
import eu.timepit.refined._
import eu.timepit.refined.numeric.Positive
import eu.timepit.refined.string.ValidInt

object Gotcha2 {
  //This import does refinement autoboxing!
  import eu.timepit.refined.auto._

  type NonEmptyValidInts = NonEmpty And Forall[ValidInt]
  type AllPositiveInts = Forall[Positive]
  type PositiveIntList = List[Int] Refined AllPositiveInts

  def main(args: Array[String]): Unit = {
    println(parse(""))
    println(parse("-2,-1,0,1,2"))
    println(parse("1,2,3,4,5,6"))
  }

  def parse(s: String): Either[String, PositiveIntList] = {
    //1) Parse "s" validating if it really represents a non-empty List of Ints
    val validatedStringList = refineV[NonEmptyValidInts](s.split(",").toList)

    //2) Validate if those Ints are all positive
    val validatedIntList = validatedStringList.flatMap { stringList =>
      val intList = stringList.map{ _.toInt }
      refineV[AllPositiveInts](intList)
    }

    //3) Returns the result
    validatedIntList
  }
}
