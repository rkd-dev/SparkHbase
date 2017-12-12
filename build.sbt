name := "SparkHbase"

version := "0.1"

scalaVersion := "2.11.8"

val hbaseVersion = "1.2.0"
val hadoopVersion = "2.6.0"
val sparkVersion = "2.1.0"

// Spark
libraryDependencies += "org.apache.spark" %% "spark-core" % sparkVersion
//libraryDependencies += "org.apache.hbase" % "hbase-spark" % hbaseVersion
//libraryDependencies += "org.apache.hbase" % "hbase-spark" % "2.0.0-alpha-1" exclude("log4j", "log4j") exclude ("org.slf4j", "slf4j-log4j12")
// https://mvnrepository.com/artifact/org.apache.hbase/hbase-spark
libraryDependencies += "org.apache.hbase" % "hbase-spark" % "1.2.0-cdh5.13.0"


// HBase
libraryDependencies += "org.apache.hbase" % "hbase-common" % hbaseVersion exclude("log4j", "log4j") exclude ("org.slf4j", "slf4j-log4j12")
libraryDependencies += "org.apache.hbase" % "hbase-common" % hbaseVersion classifier "tests" exclude("log4j", "log4j") exclude ("org.slf4j", "slf4j-log4j12")
libraryDependencies += "org.apache.hbase" % "hbase-client" % hbaseVersion exclude("log4j", "log4j")  exclude ("org.slf4j", "slf4j-log4j12") exclude ("org.slf4j", "slf4j-api")
libraryDependencies += "org.apache.hbase" % "hbase-hadoop-compat" % hbaseVersion exclude("log4j", "log4j") exclude ("org.slf4j", "slf4j-log4j12")
libraryDependencies += "org.apache.hbase" % "hbase-hadoop-compat" % hbaseVersion classifier "tests" exclude("log4j", "log4j") exclude ("org.slf4j", "slf4j-log4j12")
libraryDependencies += "org.apache.hbase" % "hbase-hadoop2-compat" % hbaseVersion exclude("log4j", "log4j") exclude ("org.slf4j", "slf4j-log4j12")
libraryDependencies += "org.apache.hbase" % "hbase-hadoop2-compat" % hbaseVersion classifier "tests" exclude("log4j", "log4j") exclude ("org.slf4j", "slf4j-log4j12")
libraryDependencies += "org.apache.hbase" % "hbase-server" % hbaseVersion exclude("log4j", "log4j") exclude ("org.slf4j", "slf4j-log4j12")
libraryDependencies += "org.apache.hbase" % "hbase-server" % hbaseVersion classifier "tests" exclude("log4j", "log4j") exclude ("org.slf4j", "slf4j-log4j12")

libraryDependencies += "org.apache.hbase" % "hbase-protocol" % hbaseVersion

// Hadoop
libraryDependencies += "org.apache.hadoop" % "hadoop-common" % hadoopVersion exclude("log4j", "log4j") exclude ("org.slf4j", "slf4j-log4j12")
libraryDependencies += "org.apache.hadoop" % "hadoop-common" % hadoopVersion classifier "tests" exclude("log4j", "log4j") exclude ("org.slf4j", "slf4j-log4j12")
libraryDependencies += "org.apache.hadoop" % "hadoop-hdfs" % hadoopVersion exclude("log4j", "log4j") exclude ("org.slf4j", "slf4j-log4j12")
libraryDependencies += "org.apache.hadoop" % "hadoop-hdfs" % hadoopVersion classifier "tests" exclude("log4j", "log4j") exclude ("org.slf4j", "slf4j-log4j12")
libraryDependencies += "org.apache.hadoop" % "hadoop-mapreduce-client-core" % hadoopVersion exclude ("org.slf4j", "slf4j-log4j12")
libraryDependencies += "org.apache.hadoop" % "hadoop-mapreduce-client-jobclient" % hadoopVersion exclude("log4j", "log4j") exclude ("org.slf4j", "slf4j-log4j12")
