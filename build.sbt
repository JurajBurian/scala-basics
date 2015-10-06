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

libraryDependencies <+= scalaVersion("org.scala-lang" % "scala-reflect" % _)
    