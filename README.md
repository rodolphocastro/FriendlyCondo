# FriendlyCondo

FriendlyCondo aims to ease the pain of communicating within a Condominium.

## Vitals

[![Quality Gate Status](https://sonarcloud.io/api/project_badges/measure?project=rodolphocastro_FriendlyCondo&metric=alert_status)](https://sonarcloud.io/summary/new_code?id=rodolphocastro_FriendlyCondo)
[![Coverage](https://sonarcloud.io/api/project_badges/measure?project=rodolphocastro_FriendlyCondo&metric=coverage)](https://sonarcloud.io/summary/new_code?id=rodolphocastro_FriendlyCondo)
[![Code Smells](https://sonarcloud.io/api/project_badges/measure?project=rodolphocastro_FriendlyCondo&metric=code_smells)](https://sonarcloud.io/summary/new_code?id=rodolphocastro_FriendlyCondo)
[![Bugs](https://sonarcloud.io/api/project_badges/measure?project=rodolphocastro_FriendlyCondo&metric=bugs)](https://sonarcloud.io/summary/new_code?id=rodolphocastro_FriendlyCondo)
[![Duplicated Lines (%)](https://sonarcloud.io/api/project_badges/measure?project=rodolphocastro_FriendlyCondo&metric=duplicated_lines_density)](https://sonarcloud.io/summary/new_code?id=rodolphocastro_FriendlyCondo)

## Building

Since this is an Android App you'll need Android SDK (and its tools) to be installed. Besides that
all you need to do is invoke the `gradle` tasks through the `gradlew` wrapper:

+ The `build` task builds the Application
+ The `test` task runs all the applicable tests (Unit and Instrumented)
+ The `sonarqube` task executes Sonarqube analysis

### Continuous Integration

There are two pipelines for Continuous Integration and validation of the code:

+ The [CI pipeline](.github/workflows/ci.yml) that builds the application every commit
+ The [Sonar pipeline](.github/workflows/sonar.yml) that runs code analysis for every pull request

## Notes and other tidbits

+ [Notes on learning Jetpack Compose](https://www.notion.so/ardc-overflow/Jetpack-Compose-994c0d9773f94239ba3a7c5ac5caca2b)