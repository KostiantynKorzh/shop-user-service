FROM openjdk:15-jdk-alpine

RUN mvn clean install

ARG JAR_FILE=target/*.jar

COPY ${JAR_FILE} app.jar

EXPOSE 8082

ENTRYPOINT ["java","--enable-preview","-jar","/app.jar"]