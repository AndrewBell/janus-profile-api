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

Setup [Google Cloud Service Authentication](https://developers.google.com/identity/protocols/application-default-credentials)

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

Set up your project ID as an environment variable `export GCP_PROJECT_ID="my-demo-12345"`

Run `sh ./deploy.sh profile-api`

## Destroy

To clean up, run `sh ./destroy.sh profile-api`

## Deploy Database

[Instance Pricing](https://cloud.google.com/sql/pricing#2nd-gen-instance-pricing)

This follows Google's [Create an Instance](https://cloud.google.com/sql/docs/mysql/create-instance)

Show the list of available tiers:

`gcloud sql tiers list`

Create an instance:

`gcloud sql instances create profile-db --tier=db-f1-micro --region=us-central1`

List your instances:

`gcloud sql instances list`

_Note the automatically assigned IP address._

Configure root account:

`gcloud sql users set-password root % --instance profile-db --password my-password`

Create a table: 

`ACCESS_TOKEN="$(gcloud auth application-default print-access-token)"
 curl --header "Authorization: Bearer ${ACCESS_TOKEN}" \
      --header 'Content-Type: application/json' \
      --data '{"project": "'"$GCP_PROJECT_ID"'", "instance": "profile-db", "name": "profile"}' \
      https://www.googleapis.com/sql/v1beta4/projects/${GCP_PROJECT_ID}/instances/profile-db/databases -X POST`
      
`curl --header "Authorization: Bearer ${ACCESS_TOKEN}" \
     https://www.googleapis.com/sql/v1beta4/projects/${GCP_PROJECT_ID}/instances/profile-db/databases -X GET`

## Connect to the Database

Enable Google Cloud API as described: https://github.com/spring-cloud/spring-cloud-gcp/tree/master/spring-cloud-gcp-starters/spring-cloud-gcp-starter-sql

Set the following in your `application.properties`:

 `spring.cloud.gcp.sql.instance-connection-name` to your Cloud SQL instance name from above.
 
 `spring.cloud.gcp.credentials.location` points to your local service account credentials.
 
 `spring.jpa.hibernate.ddl-auto=update`
 
 Your application should connect to your Google Cloud SQL instance. Try by posting the following request to create data:
 
 `curl --header 'Content-Type: application/json' \
       --data '{"displayName": "Brennan", "email": "a@b.com", "location": "3B", "title":"Overseer"}' \
       localhost:8080/v1/profiles -X POST`

## References

This example builds on previous works:

Josh Long on Spring Boot Testing: https://spring.io/blog/2017/11/22/spring-tips-bootiful-testing

Code repo for above video: https://github.com/joshlong/bootiful-testing

Building Spring Data REST Repositories: https://spring.io/guides/gs/accessing-data-rest/

Gradle Release Plugin: https://github.com/researchgate/gradle-release

Spring Cloud GCP SQL Example: https://github.com/spring-cloud/spring-cloud-gcp/tree/master/spring-cloud-gcp-samples/spring-cloud-gcp-data-jpa-sample

Spring Cloud GCP SQL Starter: https://github.com/spring-cloud/spring-cloud-gcp/tree/master/spring-cloud-gcp-starters/spring-cloud-gcp-starter-sql

Creating and managing Google Cloud SQL Databases: https://cloud.google.com/sql/docs/mysql/create-manage-databases

## Contact Me

### Andrew Bell ###

homepage: www.recursivechaos.com

email: andrew@recursivechaos.com

twitter: @recursive_chaos
