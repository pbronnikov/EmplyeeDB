import sbt._
import Keys._

object ProjBuild extends Build {
       val root = Project(
           "EmployeeDB",
           file("."),
           settings = Defaults.defaultSettings,
           configurations = Configurations.default
        )
}

