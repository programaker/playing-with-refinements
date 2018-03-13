name := "PlayingWithRefinements"
version := "0.1"
scalaVersion := "2.12.4"

libraryDependencies += "eu.timepit" %% "refined" % "0.8.7"

scalacOptions += "-Ypartial-unification"
libraryDependencies += "eu.timepit" %% "refined-cats" % "0.8.7"