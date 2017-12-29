FROM openjdk:alpine

COPY build/libs/profile-api.jar /usr/src/app/

WORKDIR /usr/src/app/

CMD ["java", "-jar", "profile-api.jar"]