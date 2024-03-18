name := """helloworld"""
organization := "com.example"

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayScala)

scalaVersion := "2.13.1"

libraryDependencies += guice
libraryDependencies += "org.scalatestplus.play" %% "scalatestplus-play" % "7.0.0" % Test
libraryDependencies += "mysql" % "mysql-connector-java" % "8.0.28"
libraryDependencies += "javax.persistence" % "javax.persistence-api" % "2.2"
libraryDependencies += "com.typesafe.play" %% "play-slick" % "5.3.0"
libraryDependencies += "com.typesafe.play" %% "play-slick-evolutions" % "5.3.0"

// Adds additional packages into Twirl
//TwirlKeys.templateImports += "com.example.controllers._"

// Adds additional packages into conf/routes
// play.sbt.routes.RoutesKeys.routesImport += "com.example.binders._"
