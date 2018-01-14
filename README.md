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

`gradle release -Prelease.useAutomaticVersion=true -Prelease.releaseVersion=1.0.0 -Prelease.newVersion=1.0.1-SNAPSHOT`

## Deploy

### Setup

Set up your project ID as an environment variable `export GCP_PROJECT_ID="my-demo-12345"`

### Create A Google Spanner Database

[gcloud spanner docs](https://cloud.google.com/spanner/docs/gcloud-spanner)

#### Manually

Create the instance:

`gcloud spanner instances create profile-instance --config=regional-us-central1 --description="Profile API Database" --nodes=1`

Create the database:

`gcloud spanner databases create profile-db --instance=profile-instance`

Confirm the database:

`gcloud spanner databases list --instance=profile-instance`

Create a service account:

#### Script

`sh ./deploy-db.sh profile-api`

[Service Accounts](https://cloud.google.com/iam/docs/service-accounts)

### Deploy App

Run `sh ./deploy.sh profile-api`

## Destroy

### Database

#### Manually

`gcloud spanner instances delete profile-instance`

#### Script

To destroy the Spanner instance (losing your data), run `sh ./destroy.sh profile-api`

### App

To clean up, run `sh ./destroy.sh profile-api`

## References

This example builds on previous works:

[Josh Long on Spring Boot Testing](https://spring.io/blog/2017/11/22/spring-tips-bootiful-testing)

[Code repo for above video](]https://github.com/joshlong/bootiful-testing)

[Building Spring Data REST Repositories](https://spring.io/guides/gs/accessing-data-rest/)

[Gradle Release Plugin](https://github.com/researchgate/gradle-release)

[Spring Boot Data JPA w/ Google Cloud Spanner](https://olavloite.github.io/2017/03/11/Google-Cloud-Spanner-with-Spring-Boot-JPA-and-Hibernate.html)


## Contact Me

### Andrew Bell ###

homepage: www.recursivechaos.com

email: andrew@recursivechaos.com

twitter: @recursive_chaos
