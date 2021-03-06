# 01 Database Selection

## Goal

What database technology will give us the most flexibility and ease of us?

* Spring Data JPA support is a plus

## Options

### [Google Bigtable](https://cloud.google.com/bigtable/)

Bigtable is Google's defacto storage solution for data at rest

Cons:
* Heavy vendor lock-in
* Lack library support (i.e. Spring Data JPA)

### [Google Cloud SQL](https://cloud.google.com/sql/)

Google Cloud has introduced managed SQL services for Postgres and MySQL

Pros: 
* High familiarity with devs

### [Google Spanner](https://cloud.google.com/spanner/)

Newer Google scalable Relational db.

Cons:
* Lack library support (i.e. Spring Data JPA)

### Running Postgres in Kubernetes

Dealing with persistent storage in Kubernetes is still a hard problem, but is solvable. 

Pros:
* No vendor lock-in

Cons:
* Difficult to setup

### Message Stream

Use Google's Pub/Sub or Kafka 

Pros:
* _Streaming_ cool points

Cons:
* Additional complexity unnecessary at this point.

## Proposed Change

Use Google Cloud SQL to speed development, but may investigate less locked in solutions in the future.

Spring Cloud GCP (Data JPA support): https://cloud.spring.io/spring-cloud-gcp/

Spring Boot Starter: https://github.com/spring-cloud/spring-cloud-gcp/tree/master/spring-cloud-gcp-starters/spring-cloud-gcp-starter-sql

Example: https://github.com/spring-cloud/spring-cloud-gcp/tree/master/spring-cloud-gcp-samples/spring-cloud-gcp-data-jpa-sample

Google Cloud MySQL Getting Started: https://cloud.google.com/sql/docs/mysql/quickstart

Pricing Tiers: https://cloud.google.com/sql/pricing#2nd-gen-instance-pricing