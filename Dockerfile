FROM openjdk:alpine

COPY ./target/project-0.0.1-SNAPSHOT.jar /usr/src/app

WORKDIR /usr/src/app

CMD ["java", "project-0.0.1-SNAPSHOT.jar"]
