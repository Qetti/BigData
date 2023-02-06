ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "3.2.1"


lazy val root = (project in file("."))
  .settings(
    name := "final"
  )

val sparkVersion = "3.3.0"
//val mysql = "mysql" % "mysql-connector-java" % "8.0.30"
libraryDependencies ++= Seq(
  "org.apache.spark" %% "spark-core" % sparkVersion,
  "org.apache.spark" %% "spark-sql" % sparkVersion,
  "org.apache.spark" %% "spark-mllib" % sparkVersion,
  "org.apache.spark" %% "spark-streaming" % sparkVersion
)
//libraryDependencies += "org.apache.spark" %% "spark-sql-kafka-0-10" % "3.3.0"

