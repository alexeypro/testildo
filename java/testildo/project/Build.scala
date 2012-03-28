import sbt._
import Keys._
import PlayProject._

object ApplicationBuild extends Build {

    val appName         = "testildo"
    val appVersion      = "1.0-SNAPSHOT"

    val appDependencies = Seq(
      // Add your project dependencies here,
      "com.google.code" % "morphia" % "0.91"
    )

    val main = PlayProject(appName, appVersion, appDependencies, mainLang = JAVA).settings(
      // Add your own project settings here      
    )

}
