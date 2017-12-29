# Janus Profile API

Provides RESTful CRUD operations for the Profile service. Built using Java 8 and Spring Boot 2.0.

## Goals

CRUD operations for Profiles

## References

This example builds on previous works:

Josh Long on Spring Boot Testing: https://spring.io/blog/2017/11/22/spring-tips-bootiful-testing

Code repo for above video: https://github.com/joshlong/bootiful-testing

Building Spring Data REST Repositories: https://spring.io/guides/gs/accessing-data-rest/

## Requirements

Some requirements are optional, links are provided below.

[git](https://git-scm.com/downloads)

[Java 8 JDK](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)

[Gradle](https://docs.gradle.org/current/userguide/installation.html)(Optional you can use the [Gradle wrapper](https://docs.gradle.org/3.3/userguide/gradle_wrapper.html) instead)

[Docker](https://docs.docker.com/installation/)(Optional, if you would like to run the example in Docker)

This example uses [Lombok](https://projectlombok.org/), so you may need to configure your IDE to use built in tools 

* [Lombok For IntelliJ](https://plugins.jetbrains.com/plugin/6317-lombok-plugin) Be sure to enable "Annotation Processing" in your preferences [Stack Overflow](https://stackoverflow.com/questions/9424364/cant-compile-project-when-im-using-lombok-under-intellij-idea)

## Executing The Project

### Build

`gradle build`

### Test

`gradle test`

### Run

`gradle bootRun`

### Run Docker

`docker build . --tag profile-api`

`docker run profile-api`

# Contact Me

Andrew Bell

homepage: www.recursivechaos.com

email: andrew@recursivechaos.com

twitter: @recursive_chaos
