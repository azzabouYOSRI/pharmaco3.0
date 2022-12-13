FROM maven:3.6.1-jdk-11 AS MAVEN_BUILD

COPY ./ ./

RUN mvn clean package -DskipTests

FROM openjdk:11.0.11-9-jdk

COPY --from=MAVEN_BUILD target/pharmaco.jar app.jar

ENTRYPOINT ["java", "-jar", "/app.jar"]

EXPOSE 8080