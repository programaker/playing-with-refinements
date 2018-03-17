package pwr.v2

import eu.timepit.refined.W
import eu.timepit.refined.api.Refined
import eu.timepit.refined.boolean.{And, Not}
import eu.timepit.refined.collection.MinSize
import eu.timepit.refined.numeric.Interval
import eu.timepit.refined.string.MatchesRegex
import pwr.v2.SpBus._

object SpBus {
  type IdRange = Interval.Closed[W.`10000`.T, W.`89999`.T]
  type LineRegex = MatchesRegex[W.`"""^[1-8][0-9L][0-9][0-9A-Z]-\\d{2}$"""`.T]
  type MinSizeString = MinSize[W.`3`.T] And Not[MatchesRegex[W.`"""^\\s+$"""`.T]]
}

case class SpBus(
  id: Int Refined IdRange,
  line: String Refined LineRegex,
  company: String Refined MinSizeString
)
