ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "2.13.10"

lazy val root = (project in file("."))
  .settings(
    name := "UserRegistrationApplication",
    idePackagePrefix := Some("com.knoldus")
  )

libraryDependencies ++= Seq(
  "mysql" % "mysql-connector-java" % "8.0.27",
  "com.typesafe" % "config" % "1.4.1"
)

libraryDependencies ++= Seq(
 "org.scalafx" %% "scalafx" % "16.0.0-R25"

)

// JavaFX dependencies
libraryDependencies ++= Seq(
  "org.openjfx" % "javafx-controls" % "19.0.2.1",
  "org.openjfx" % "javafx-fxml" % "19.0.2.1",
  "org.openjfx" % "javafx-media" % "19.0.2.1"
)
