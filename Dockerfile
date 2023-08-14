FROM openjdk:17-jdk as build
ARG JAR_FILE=build/libs/Dockerizing-a-Spring-Boot-by-selene-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} app.jar
ENV SPRING_PROFILES_ACTIVE=prod
ENTRYPOINT ["java", "-jar", "/app.jar"]
