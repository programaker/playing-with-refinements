package pwr.v2

import eu.timepit.refined.W
import eu.timepit.refined.api.Refined
import eu.timepit.refined.boolean.And
import eu.timepit.refined.collection.{MinSize, NonEmpty}
import eu.timepit.refined.numeric.Interval
import eu.timepit.refined.string.MatchesRegex
import pwr.v2.SpBus._

final case class Nel()

case class SpBus(
  id: Id,
  line: Line,
  company: Company
)

object SpBus {
  type Id = Int Refined Interval.Closed[W.`10000`.T, W.`89999`.T]
  type Line = String Refined MatchesRegex[W.`"""\\d{3}[0-9A-Z]-\\d{2}"""`.T]
  type Company = String Refined (NonEmpty And MinSize[W.`3`.T])
}
