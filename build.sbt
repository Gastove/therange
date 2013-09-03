libraryDependencies += "org.scalatest" %% "scalatest" % "2.0.M5b" % "test"

libraryDependencies += "org.twitter4j" % "twitter4j-core" % "3.0.3"

libraryDependencies += "org.fusesource.scalamd" %% "scalamd" % "1.6"

javaOptions += "-Xmx5g"

javaOptions += "-XX:+HeapDumpOnOutOfMemoryError"

javaOptions += "-XX:-UseGCOverheadLimit"
