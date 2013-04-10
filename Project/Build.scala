import sbt._
import Keys._

object ProjBuild extends Build {
  val twitterRepo = "Twitter repo" at "http://maven.twttr.com/"

  val customResolvers = Seq(twitterRepo)

  val deps = Seq(
    "net.databinder" % "unfiltered-filter_2.9.1" % "0.5.3",
    "net.databinder" % "unfiltered-jetty_2.9.1" % "0.5.3",
    "org.scalaz" %% "scalaz-core" % "6.0.4",
    "com.twitter" % "querulous" % "2.1.5",
    "net.liftweb" %% "lift-json" % "2.4",
    "com.typesafe" % "config" % "1.0.0"
  )

  val root = Project(
    "EmployeeDB",
    file("."),
    settings = Defaults.defaultSettings ++ Seq(scalaVersion := "2.9.1", libraryDependencies ++= deps, resolvers ++= customResolvers),
    configurations = Configurations.default
  )
}
