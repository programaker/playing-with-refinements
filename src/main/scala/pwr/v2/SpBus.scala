package pwr.v2

import eu.timepit.refined.W
import eu.timepit.refined.api.Refined
import eu.timepit.refined.boolean.And
import eu.timepit.refined.collection.{MinSize, NonEmpty}
import eu.timepit.refined.numeric.Interval
import eu.timepit.refined.string.MatchesRegex
import pwr.v2.SpBus._

case class SpBus(
  id: Int Refined Id,
  line: String Refined Line,
  company: String Refined Company
)

object SpBus {
  type Id = Interval.Closed[W.`10000`.T, W.`89999`.T]
  type Line = MatchesRegex[W.`"""\\d{3}[0-9A-Z]-\\d{2}"""`.T]
  type Company = NonEmpty And MinSize[W.`3`.T]
}
