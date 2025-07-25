FROM ubuntu:latest
LABEL authors="neele"

FROM openjdk:17
EXPOSE 8080

ADD target/devops-integration.jar devops-integration.jar

ENTRYPOINT ["java", "-jar","/devops-integration.jar"]