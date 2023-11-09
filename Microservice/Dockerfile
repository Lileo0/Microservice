FROM gradle:8.4.0-jdk17 AS build
COPY --chown=gradle:gradle . /home/gradle/src
WORKDIR /home/gradle/src
RUN gradle build

FROM openjdk:17
EXPOSE 9090
COPY --from=build /home/gradle/src/build/libs/Microservice-0.0.1-SNAPSHOT.jar /app/
RUN bash -c 'touch /app/Microservice-0.0.1-SNAPSHOT.jar'
ENTRYPOINT ["java", "-Dspring.profiles.active=dev","-jar","/app/Microservice-0.0.1-SNAPSHOT.jar"]