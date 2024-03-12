FROM openjdk:17-alpine
MAINTAINER Elleined

ADD ./target/*.jar email-sender-api.jar
EXPOSE 8092
CMD ["java", "-jar", "email-sender-api.jar"]