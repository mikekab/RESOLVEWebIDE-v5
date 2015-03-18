name := "RESOLVEWebIDE"

version := "5.0"

scalaVersion := "2.11.1"

scalacOptions ++= Seq(
  "-feature", // Shows warnings in detail in the stdout
  "-language:reflectiveCalls" 
)

libraryDependencies ++= Seq(
  javaJpa.exclude("org.hibernate.javax.persistence", "hibernate-jpa-2.0-api"),
  "org.hibernate" % "hibernate-entitymanager" % "4.3.6.Final")

lazy val admin = (project in file("modules/admin"))
  .enablePlugins(PlayJava)

lazy val main = (project in file("."))
  .enablePlugins(PlayJava)
  .dependsOn(admin)
  .aggregate(admin)