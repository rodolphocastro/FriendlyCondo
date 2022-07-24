# FriendlyCondo

FriendlyCondo aims to ease the pain of communicating within a Condominium.

## Building

Since this is an Android App you'll need Android SDK (and its tools) to be installed. Besides that all you need to do is invoke the `gradle` tasks through the `gradlew` wrapper:

+ The `build` task builds the Application
+ The `test` task runs all the applicable tests (Unit and Instrumented)
+ The `sonarqube` task executes Sonarqube analysis

### Continuous Integration

There are two pipelines for Continuous Integration and validation of the code:

+ The [CI pipeline](.github/workflows/ci.yml) that builds the application every commit
+ The [Sonar pipeline](.github/workflows/sonar.yml) that runs code analysis for every pull request