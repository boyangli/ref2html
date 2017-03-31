name := "BookPersonality" 

organization := "com.drp"

version := "0.1"

scalaVersion := "2.11.7"

publishMavenStyle := false

publishTo := Some(Resolver.file("file",  new File( "C:\\Users\\boyangli\\.ivy2\\local" )) )

libraryDependencies  ++=  Seq(
   "org.jbibtex" % "jbibtex" % "1.0.15",
   "de.undercouch" % "citeproc-java" % "1.0.1",
   "org.citationstyles" % "styles" % "1.0.1-SNAPSHOT",
   "org.citationstyles" % "locales" % "1.0.1-SNAPSHOT"
	)


