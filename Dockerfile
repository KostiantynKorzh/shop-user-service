FROM maven:3.5-jdk-8 AS build
COPY src /build/src/
COPY pom.xml /build/
WORKDIR /build/
RUN mvn package -Dmaven.test.skip=true

FROM openjdk:15-jdk-alpine
ARG JAR_FILE=/build/target/*.jar
COPY ${JAR_FILE} app.jar
EXPOSE 8082
ENTRYPOINT ["java","--enable-preview","-jar","/app.jar"]