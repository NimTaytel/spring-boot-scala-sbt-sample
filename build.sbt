import sbt.Keys.{mainClass, scalaVersion}
import sbt._

name := "spring-boot-scala-sample"

version := "1.0.0"

scalaVersion := "2.11.8"

exportJars := true

lazy val springVersion = "1.4.3.RELEASE"
lazy val jettyVersion = "9.3.14.v20161028"

lazy val commonSettings = Seq(
    organization := "com.example",
    name := "spring-boot-scala",
    version := "1.0.0",
    scalaVersion := "2.11.8"
)

lazy val app = (project in file("."))
  .settings(commonSettings: _*)
  .settings(
    scalacOptions ++= Seq("-unchecked", "-deprecation", "-feature"),

    mainClass := Some("com.example.app.SpringBootScalaApplication"),

    libraryDependencies ++= Seq(
    "org.springframework.boot" % "spring-boot-starter-web" % springVersion  exclude ("org.springframework.boot", "spring-boot-starter-tomcat") ,
    "org.springframework.boot" % "spring-boot-starter-test" % springVersion % "test",

    // Joda Time
    "joda-time" % "joda-time" % "2.9.6",

    // Jackson
    "com.fasterxml.jackson.module" % "jackson-module-scala_2.11" % "2.8.6",
    "com.fasterxml.jackson.datatype" % "jackson-datatype-joda" % "2.8.6",

    // JUnit
    "junit" % "junit" % "4.12" % "test",

    // Scala test
    "org.scalatest" %% "scalatest" % "2.2.6" %  "test",

    // Logging
    "com.typesafe.scala-logging" % "scala-logging-slf4j_2.11" % "2.1.1",

    "org.hsqldb" % "hsqldb" % "2.3.4",

    "org.eclipse.jetty" % "jetty-webapp" % jettyVersion
  )
)

assemblyMergeStrategy in assembly := {
  case "META-INF/MANIFEST.MF" => MergeStrategy.discard
  case PathList("org", "apache", "commons", "logging", xs @ _*) => MergeStrategy.last
  case PathList("META-INF", xs @ _*) => MergeStrategy.filterDistinctLines
  case x =>
    val oldStrategy = (assemblyMergeStrategy in assembly).value
    oldStrategy(x)
}
