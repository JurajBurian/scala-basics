name := "scala-basics"
version := "1.0"
scalaVersion := "2.11.7"
scalacOptions := 	Seq(
	"-encoding", "UTF-8",
	"-unchecked",
	"-deprecation",
	"-feature",
//	"-Xfatal-warnings",
//	"-Xlint",
	"-Yrangepos",
	"-language:postfixOps"
)

libraryDependencies ++= Seq(
	"com.typesafe.slick" %% "slick" % "3.1.0",
	"org.slf4j" % "slf4j-nop" % "1.6.4",
	"com.h2database" % "h2" % "1.4.190",
	"org.scalatest" %% "scalatest" % "2.2.4" % "test"
)
libraryDependencies <+= scalaVersion("org.scala-lang" % "scala-reflect" % _)
    