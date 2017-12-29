FROM openjdk:alpine

COPY build/libs/janus-profile-api-0.0.1-SNAPSHOT.jar /usr/src/app/

WORKDIR /usr/src/app/

CMD ["java", "-jar", "janus-profile-api-0.0.1-SNAPSHOT.jar"]