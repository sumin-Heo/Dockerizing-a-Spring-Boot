FROM adoptopenjdk/openjdk17:alpine as build
WORKDIR /app
COPY build.gradle.kts settings.gradle.kts ./
COPY gradlew ./
COPY gradle/ ./gradle/
RUN ./gradlew dependencies

COPY src ./src/

RUN ./gradlew build

FROM adoptopenjdk/openjdk17:alpine
WORKDIR /app
RUN addgroup -S appgroup && adduser -S appuser -G appgroup
COPY --from=build /app/build/libs/*.jar app.jar
USER appuser
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]