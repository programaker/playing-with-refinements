package pwr.v3

import eu.timepit.refined.boolean.And
import eu.timepit.refined.collection.{Forall, NonEmpty}
import eu.timepit.refined.numeric.Positive

object Gotcha1 {
  //import eu.timepit.refined.api.Refined

  //This import does refinement autoboxing!
  //import eu.timepit.refined.auto._

  type NonEmptyPositiveList = NonEmpty And Forall[Positive]

  def main(args: Array[String]): Unit = {
    /* compile-time refinement only works with literals */

    //val x: List[Int] Refined NonEmptyPositiveList = List(1,2,3,4,5,6,7,8,9)
    //println(x)
  }
}
