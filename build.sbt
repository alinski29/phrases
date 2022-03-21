import sbt._

organization := "com.github.vladsandulescu"
name := "opinion-phrases"
version := "0.1.0"
scalaVersion := "2.11.11"

val coreNLPVersion = "3.4"

libraryDependencies ++= Seq(
  "edu.stanford.nlp" % "stanford-corenlp" % coreNLPVersion,
  "edu.stanford.nlp" % "stanford-corenlp" % coreNLPVersion classifier "models",
  "edu.stanford.nlp" % "stanford-parser" % coreNLPVersion,
  "junit" % "junit" % "4.11" % Test,
  "org.hamcrest" % "hamcrest-core" % "1.3" % Test,
  "org.hamcrest" % "hamcrest-library" % "1.3" % Test
)

assemblyJarName in assembly := s"${name.value}_${version.value}.jar"
assemblyMergeStrategy in assembly := {
  case PathList("META-INF", xs @ _*) => MergeStrategy.discard
  case PathList("webapps", xs @ _*) => MergeStrategy.discard
  case PathList("win32", xs @ _*) => MergeStrategy.discard
  case _ => MergeStrategy.first
}
assemblyOption in assembly := (assemblyOption in assembly).value.copy(includeScala = false)
