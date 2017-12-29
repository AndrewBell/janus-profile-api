# Janus Profile API

Provides RESTful CRUD operations for the Profile service. Built using Java 8 and Spring Boot 2.0.

## Goals

CRUD operations for Profiles

## Requirements

Some requirements are optional, links are provided below.

BASH - Windows users can use [Git for windows](http://gitforwindows.org/)

[git](https://git-scm.com/downloads)

[Java 8 JDK](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)

[Gradle](https://docs.gradle.org/current/userguide/installation.html)(Optional you can use the [Gradle wrapper](https://docs.gradle.org/3.3/userguide/gradle_wrapper.html) instead)

[Docker](https://docs.docker.com/installation/)(Optional, if you would like to run the example in Docker)

This example uses [Lombok](https://projectlombok.org/), so you may need to configure your IDE to use built in tools 

* [Lombok For IntelliJ](https://plugins.jetbrains.com/plugin/6317-lombok-plugin) Be sure to enable "Annotation Processing" in your preferences [Stack Overflow](https://stackoverflow.com/questions/9424364/cant-compile-project-when-im-using-lombok-under-intellij-idea)

## Executing The Project

### Test

`gradle test`

### Run

`gradle bootRun`

### Run Docker (optional)

`docker build . --tag profile-api`

`docker run profile-api`

## View

Open your browser or curl `localhost:8080`

## Release

## Deploy

Set up your project ID as an environment variable `export GCP_PROJECT_ID="my-demo-12345"`

Run `sh ./deploy.sh profile-api`

## Destroy

To clean up, run `sh ./destroy.sh profile-api`

## References

This example builds on previous works:

Josh Long on Spring Boot Testing: https://spring.io/blog/2017/11/22/spring-tips-bootiful-testing

Code repo for above video: https://github.com/joshlong/bootiful-testing

Building Spring Data REST Repositories: https://spring.io/guides/gs/accessing-data-rest/

Gradle Release Plugin: https://github.com/researchgate/gradle-release


## Contact Me

### Andrew Bell ###

homepage: www.recursivechaos.com

email: andrew@recursivechaos.com

twitter: @recursive_chaos
