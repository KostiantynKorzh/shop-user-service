FROM maven:3.8-openjdk-15 AS build
COPY src /build/src/
COPY pom.xml /build/
WORKDIR /build/
RUN mvn package -Dmaven.test.skip=true

FROM openjdk:15-jdk-alpine
COPY --from=build /build/target/*.jar app.jar
EXPOSE 8082
ENTRYPOINT ["java","--enable-preview","-jar","/app.jar"]